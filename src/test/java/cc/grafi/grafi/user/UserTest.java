package cc.grafi.grafi.user;

import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void 유저_조회() {
        User user = userService.getUser("aodtns");
        Assertions.assertThat(user.getName()).isEqualTo("맹순맹순ddb");
    }
}
