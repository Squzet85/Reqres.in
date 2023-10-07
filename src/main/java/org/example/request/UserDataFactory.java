package org.example.request;

public class UserDataFactory {
    public static UserData getGeneratedUserData() {
        return new UserData.UserDataBuilder()
                .email("eve.holt@reqres.in")
                .password(String.valueOf(PasswordOptions.getRandomPassword()))
                .build();
    }
}
