package cc.grafi.grafi.domain.user.dto;

import cc.grafi.grafi.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailResponse {
    private String userId;
    private String name;
    private Long visitors;
    private String text;
    private String profile;

    public static UserDetailResponse fromEntity(User user) {
        return UserDetailResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .visitors(user.getVisitors())
                .text(user.getText())
                .profile(user.getProfile())
                .build();
    }
}
