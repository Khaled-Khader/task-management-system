package com.globitel.task.management.system.presentation.spring.boot.filter;

import com.globitel.task.management.system.core.token.factory.TokenUseCaseFactory;
import com.globitel.task.management.system.core.user.factory.UserUseCaseFactory;
import com.globitel.task.management.system.presentation.spring.boot.filter.response.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Instant;


@RequiredArgsConstructor
public class TaskManagementTokenValidationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final TokenUseCaseFactory tokenUseCaseFactory;
    private final UserUseCaseFactory userUseCaseFactory;
    private final ObjectMapper objectMapper;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
       String path=request.getRequestURI();
       return path.contains("/login");
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {

            String token = getString(request);
            tokenUseCaseFactory.tokenValidationUseCase().execute(token);


            String userUuid=tokenUseCaseFactory.extractUserUuidFromTokenUseCase().execute(token);
            String userName=userUseCaseFactory.findUserNameByUserUuidUseCase().execute(userUuid);

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(userName);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext()
                    .setAuthentication(authentication);

            filterChain.doFilter(request, response);
        } catch (Exception e) {

            ErrorResponse error = new ErrorResponse(
                    "INVALID_TOKEN  ",
                    e.getMessage(),
                    Instant.now()
            );
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
           response.getWriter().write(objectMapper.writeValueAsString(error));
        }

    }

    private static @NonNull String getString(@NonNull HttpServletRequest request) {
        String token = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("access_token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        if (token == null) {
            throw new RuntimeException("Authorization header not found");
        }

        return token;
    }
}
