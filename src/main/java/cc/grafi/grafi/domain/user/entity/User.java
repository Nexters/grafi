package cc.grafi.grafi.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Table(name = "users")
public class User {
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
}
