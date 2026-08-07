package com.globitel.task.management.system.core.token.entity;

import com.globitel.task.management.system.core.shared.entity.BaseEntity;
import com.globitel.task.management.system.core.token.entity.embedded.TokenStatus;
import com.globitel.task.management.system.core.token.identity.TokenIdentity;
import com.globitel.task.management.system.core.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "tokens")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TokenEntity extends BaseEntity implements TokenIdentity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    TokenStatus tokenStatus;
    @ManyToOne(optional = false)
    private UserEntity user;
    @Column(nullable = false)
    private Instant lastUsed;


    public TokenEntity(
            String uuid,
            UserEntity user,
            TokenStatus tokenStatus,
            Instant createdAt,
            Instant lastUsed
    ) {
        super(uuid, createdAt);
        this.user = user;
        this.tokenStatus = tokenStatus;

        this.lastUsed = lastUsed;
    }

}
