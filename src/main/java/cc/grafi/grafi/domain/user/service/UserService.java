package cc.grafi.grafi.domain.user.service;

import cc.grafi.grafi.domain.auth.dto.UserLoginRequest;
import cc.grafi.grafi.domain.auth.exception.UnauthorizedException;
import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.dto.UserUpdateRequest;
import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDetailResponse login(UserLoginRequest request) {
        String userId = request.getUserId();
        String password = request.getPassword();

        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저를 조회할 수 없습니다."));
        if (!password.equals(user.getPassword())) {
            throw new UnauthorizedException("유효하지 않은 비밀번호입니다.");
        }

        return UserDetailResponse.fromEntity(user);
    }

    public UserDetailResponse getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저를 조회할 수 없습니다."));
        return UserDetailResponse.fromEntity(user);
    }

    @Transactional
    public void saveUser(UserCreationRequest request) {
        User user = UserCreationRequest.toEntity(request);
        user.changeName("grafi");
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getUser_id()).orElseThrow(() -> new IllegalArgumentException("해당 유저를 조회할 수 없습니다."));
        user.updateUser(request);
        userRepository.save(user);
    }
}
