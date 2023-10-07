package org.test;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.example.request.ErrorData;
import org.example.request.UserData;
import org.example.request.UserDataFactory;
import org.example.response.ErrorResponse;
import org.example.response.LoginResponse;
import org.example.response.RegistrationResponse;
import org.example.response.UserResponse;
import org.example.services.LoginService;
import org.example.services.PageService;
import org.example.services.RegistrationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReqresinTest {
    private UserData user;
    private RegistrationService registrationService = new RegistrationService();
    private LoginService loginService = new LoginService();
    private PageService pageService = new PageService();

    @Owner(value = "А.Матрюк")
    @TmsLink("1")
    @Story("POSITIVE")
    @DisplayName("Регистрация пользователя с email и захардкоженым паролем")
    @Test
    public void registerSuccessfulTest() {
        int id = 4;
        UserData user = UserData.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        RegistrationResponse registrationResponse = registrationService.successfulRegisterUser(user);

        assertAll(
                () -> assertEquals(id, registrationResponse.getId(), "Unexpected id"),
                () -> assertTrue(registrationResponse.getToken().contains("wL5tke"), "Unexpected token")
        );
    }

    @Owner(value = "А.Матрюк")
    @TmsLink("2")
    @Story("POSITIVE")
    @DisplayName("Авторизация пользователя с email и генерируемым паролем")
    @Test
    public void loginSuccessfulTest() {
        user = UserDataFactory.getGeneratedUserData();
        LoginResponse loginResponse = loginService.successfulLoginUser(user);

        assertTrue(loginResponse.getToken().startsWith("QpwL5"), "Unexpected token");
    }

    @Owner(value = "А.Матрюк")
    @TmsLink("3")
    @Story("NEGATIVE")
    @DisplayName("Авторизация пользователя только с email")
    @Test
    public void loginUnsuccessfulTest() {
        ErrorData user = ErrorData.builder()
                .email("peter@klaven")
                .build();
        ErrorResponse errorResponse = loginService.unsuccessfulLoginUser(user);

        assertNotNull(errorResponse.getError(), "Error is null");
    }

    @Owner(value = "А.Матрюк")
    @TmsLink("4")
    @Story("POSITIVE")
    @DisplayName("Получение списка пользователей с первой страницы с проверкой на то, что в каждом поле Avatar содержится значение поля Id")
    @Test
    public void getListUserTest() {
        List<UserResponse> userResponse = pageService.getListUsers(1);

        userResponse.stream().forEach(x -> assertTrue(x.getAvatar().contains(x.getId().toString())));
    }
}
