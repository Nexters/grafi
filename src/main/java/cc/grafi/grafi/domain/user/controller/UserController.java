package cc.grafi.grafi.domain.user.controller;

import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.dto.UserUpdateRequest;
import cc.grafi.grafi.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "users")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원 조회")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원 조회 성공"),
            @ApiResponse(responseCode = "400", description = "값을 누락하고 보냈거나, 값의 타입이 잘못된 경우"),
            @ApiResponse(responseCode = "500", description = "서버 오류"),
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailResponse> getUserById(@PathVariable("userId") String userId) {
        UserDetailResponse response = userService.getUser(userId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "회원가입")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "값을 누락하고 보냈거나, 값의 타입이 잘못된 경우"),
            @ApiResponse(responseCode = "500", description = "서버 오류"),
    })
    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserCreationRequest request) {
        userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

    @Operation(summary = "회원 정보 수정")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원 정보 수정 성공"),
            @ApiResponse(responseCode = "400", description = "값을 누락하고 보냈거나, 값의 타입이 잘못된 경우"),
            @ApiResponse(responseCode = "500", description = "서버 오류"),
    })
    @PutMapping()
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserUpdateRequest request) {
        userService.updateUser(request);
        return ResponseEntity.ok("유저 정보 업데이트 성공");
    }
}
