package cc.grafi.grafi.domain.user.controller;

import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailResponse> getUserById(@PathVariable("userId") String userId) {
        UserDetailResponse response = userService.getUser(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserCreationRequest request) {
        userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }
}
