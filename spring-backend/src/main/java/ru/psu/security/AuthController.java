package ru.psu.security;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping(value = "/auth", produces = "application/json; charset=UTF-8")
public class AuthController {

    private UserService userService;
    public static final String LOGIN_COOKIE_NAME = "username";

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void login(@RequestBody AuthDto authDto, HttpServletResponse response) {
        if (!doLogin(authDto, response)){
            throw new RuntimeException("Неверный логин или пароль");
        }
    }

    @GetMapping("/current")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    private boolean doLogin(AuthDto authDto, HttpServletResponse response) {
        if (userService.checkPassword(authDto.getLogin(), authDto.getPassword())) {
            Cookie cookie = new Cookie(LOGIN_COOKIE_NAME, authDto.getLogin());
            cookie.setMaxAge(6 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);

            userService.login(authDto.getLogin());
            return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doLogout(request, response);
        String redirect = request.getRequestURL().substring(0, request.getRequestURL().toString().indexOf('/', 8));
        response.sendRedirect(redirect);
    }

    private boolean doLogout(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        String login = "";
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(LOGIN_COOKIE_NAME)) {
                    login = cookie.getValue();
                }
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        userService.logout(login);
        return true;
    }
}
