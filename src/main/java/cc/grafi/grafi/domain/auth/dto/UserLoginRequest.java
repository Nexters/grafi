package cc.grafi.grafi.domain.auth.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserLoginRequest {
    @NotBlank(message = "user_id는 필수 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "잘못된 user_id 형식입니다.")
    private String userId;

    @NotBlank(message = "password는 필수 값입니다.")
    @Pattern(regexp = "^[0-9]+$", message = "잘못된 password 형식입니다.")
    private String password;
}
