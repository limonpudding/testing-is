package ru.psu.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ru.psu.dao.AppUserDaoImpl;
import ru.psu.generated.tables.pojos.AppUser;

import java.time.LocalDateTime;

import static ru.psu.generated.tables.AppUser.APP_USER;

@Service
public class UserService {
    private AppUserDaoImpl appUserDao;
    private UserContext userContext;

    @Value("${auth.salt}")
    private String salt;

    UserService(AppUserDaoImpl appUserDao, UserContext userContext) {
        this.appUserDao = appUserDao;
        this.userContext = userContext;
    }

    public AppUser getUserByLogin(String login){
        return appUserDao.fetchOptional(APP_USER.LOGIN, login)
                .orElse(null);
    }

    public boolean checkPassword(String login, String password) {
        AppUser user = getUserByLogin(login);
        if (user == null) {
            return false;
        }
        password = password + salt;

        String md5Hex = DigestUtils.md5DigestAsHex(password.getBytes())
                .toUpperCase();

        return md5Hex.equals(user.getPasswordHash());
    }

    public UserDto getCurrentUser() {

        return new UserDto(userContext.getUser());
    }

    public void login(String login) {
        AppUser user = getUserByLogin(login);
        user.setLastLoginDate(LocalDateTime.now());
        user.setIsActive(true);

        appUserDao.update(user);
    }

    public void logout(String login) {
        AppUser user = getUserByLogin(login);
        user.setIsActive(false);
        appUserDao.update(user);
    }
}
