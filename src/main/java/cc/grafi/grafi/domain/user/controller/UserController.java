package cc.grafi.grafi.domain.user.controller;

import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public String getUserById(@PathVariable("userId") String userId) {
        userService.getUser(userId);
        return "성공";
    }

    @PostMapping()
    public void saveUser(@RequestBody UserCreationRequest request) {
        userService.saveUser(request);
    }
}
