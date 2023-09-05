package cc.grafi.grafi.domain.user.dto;

import cc.grafi.grafi.domain.user.entity.User;
import lombok.Data;

@Data
public class UserCreationRequest {
    private String userId;
    private String password;

    public static User toEntity(UserCreationRequest request) {
        return User.builder()
                .id(request.getUserId())
                .password(request.getPassword())
                .build();
    }
}
