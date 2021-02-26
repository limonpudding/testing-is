package ru.psu.security;

import ru.psu.generated.tables.pojos.AppUser;

import java.io.Serializable;

public class UserDto implements Serializable {
    private String login;

    public UserDto() {
    }

    public UserDto(String login) {
        this.login = login;
    }

    public UserDto(AppUser appUser) {
        this.login = appUser.getLogin();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
