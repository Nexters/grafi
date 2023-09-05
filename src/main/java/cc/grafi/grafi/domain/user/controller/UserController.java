package cc.grafi.grafi.domain.user.controller;

import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.service.UserService;
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
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody UserCreationRequest request) {
        userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }
}