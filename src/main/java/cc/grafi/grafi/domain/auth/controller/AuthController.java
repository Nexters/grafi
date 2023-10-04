package cc.grafi.grafi.domain.auth.controller;

import cc.grafi.grafi.domain.auth.dto.UserLoginRequest;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "auth")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserDetailResponse> login(
            @Valid @RequestBody UserLoginRequest request
    ) {
        UserDetailResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
