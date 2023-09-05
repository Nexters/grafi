package cc.grafi.grafi.domain.user.service;

import cc.grafi.grafi.domain.user.dto.UserCreationRequest;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
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
}
