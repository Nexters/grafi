package cc.grafi.grafi.domain.user.dto;

import cc.grafi.grafi.domain.user.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailResponse {
    private String user_id;
    private String name;
    private Long visitors;
    private String text;
    private String profile_img;

    public static UserDetailResponse fromEntity(User user) {
        return UserDetailResponse.builder()
                .user_id(user.getId())
                .name(user.getName())
                .visitors(user.getVisitors())
                .text(user.getText())
                .profile_img(user.getProfile())
                .build();
    }
}
