package cc.grafi.grafi.domain.user.entity;

import cc.grafi.grafi.global.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String password;

    private String email;

    private Long visitors;

    private String themeColor;

    private String text;

    private String profile;

    public void changeName(String name) {
        this.name = name;
    }
}
