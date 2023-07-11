package ru.netology.web.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.data.SQLHelper;
import ru.netology.web.page.LoginPageV1;

import static com.codeborne.selenide.Selenide.open;

public class TestSQL {
    @AfterAll
    static void teardown() {
        SQLHelper.cleanDatabase();
    }

    @BeforeEach
    public void urlOpen() {
        open("http://localhost:9999");
    }
    @Test
    void userValid() {
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPageV1.validLogin(authInfo);
        verificationPage.VerificationPage();
        var verificationCode = SQLHelper.getVerificationCode();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.DashboardPage();
    }

    @Test
    public void userNotValid() {
        var loginPageV1 = new LoginPageV1();
        var authInfo = DataHelper.getRandomUser();
        var verificationPage = LoginPageV1.validLogin(authInfo);
        loginPageV1.setErrorNotification("Ошибка");
    }

    @Test
    public void userBlocking() {
        var loginPageV1 = new LoginPageV1();
        var authInfo = DataHelper.getAuthInfo();
       // var verificationPage = LoginPageV1.notValidPassword(authInfo);
        LoginPageV1.notValidPassword(authInfo);
        LoginPageV1.notValidPassword(authInfo);
        LoginPageV1.notValidPassword(authInfo);
        loginPageV1.setErrorNotification("Ошибка");
    }
}
