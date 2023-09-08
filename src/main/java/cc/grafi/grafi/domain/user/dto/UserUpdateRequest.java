package cc.grafi.grafi.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserUpdateRequest {
    @NotBlank
    private String user_id;
    private String name;
    private String password;
    private String email;
    private String theme_color;
    private String text;
    private String profile_img;
}
