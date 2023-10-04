package cc.grafi.grafi.user;

import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.repository.UserRepository;
import cc.grafi.grafi.domain.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("아이디로 유저 조회 - 성공")
    public void 유저_조회() {
        // given
        given(userRepository.findById(anyString()))
                .willReturn(Optional.ofNullable(testUserBuilder()));

        // when
        UserDetailResponse foundUser = userService.getUser("grafi");

        // then
        Assertions.assertThat(foundUser.getName()).isEqualTo("그라피");
    }

    private User testUserBuilder() {
        return User.builder()
                .id("grafi")
                .name("그라피")
                .password("0819")
                .email("grafi@naver.com")
                .text("취향 공유 서비스, 그라피")
                .build();
    }
}
