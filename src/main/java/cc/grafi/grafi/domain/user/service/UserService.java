package cc.grafi.grafi.domain.user.service;

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

    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("실패"));
    }
}
