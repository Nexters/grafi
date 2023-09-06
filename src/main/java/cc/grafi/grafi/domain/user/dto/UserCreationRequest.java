package cc.grafi.grafi.domain.user.dto;

import cc.grafi.grafi.domain.user.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreationRequest {
    @NotBlank
    private String userId;
    @NotNull
    private String password;

    public static User toEntity(UserCreationRequest request) {
        return User.builder()
                .id(request.getUserId())
                .password(request.getPassword())
                .build();
    }
}
