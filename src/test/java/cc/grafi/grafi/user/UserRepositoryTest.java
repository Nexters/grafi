package cc.grafi.grafi.user;

import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("아이디로 유저 조회 - 성공")
    public void 유저_조회() {
        // given
        User user = User.builder()
                .id("grafi")
                .name("그라피")
                .password("0819")
                .email("grafi@naver.com")
                .text("취향 공유 서비스, 그라피")
                .build();
        userRepository.save(user);

        // when
        User foundUser = userRepository.findById("grafi").orElse(User.builder().build());

        // then
        Assertions.assertThat(foundUser.getName()).isEqualTo("그라피");
    }
}
