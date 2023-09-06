package cc.grafi.grafi.user;

import cc.grafi.grafi.domain.user.controller.UserController;
import cc.grafi.grafi.domain.user.dto.UserDetailResponse;
import cc.grafi.grafi.domain.user.entity.User;
import cc.grafi.grafi.domain.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;


    @Test
    @DisplayName("아이디로 유저 조회")
    void 유저_조회() throws Exception {
        // given
        String uri = "/users/grafi";
        given(userService.getUser(anyString())).willReturn(testUserResponse());

        // when
        MockHttpServletResponse response = mvc.perform(get(uri))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value("grafi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("grafi"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.visitors").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value("취향 공유 서비스, 그라피"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profile_img").value("test profile"))
                .andDo(print())
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

    private static UserDetailResponse testUserResponse() {
        return UserDetailResponse.builder()
                .user_id("grafi")
                .name("grafi")
                .visitors(1L)
                .text("취향 공유 서비스, 그라피")
                .profile_img("test profile")
                .build();
    }
}
