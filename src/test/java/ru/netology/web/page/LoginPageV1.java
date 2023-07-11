package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV1 {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void setErrorNotification(String textError) {
        errorNotification.shouldBe(Condition.visible).shouldHave(Condition.text("Ошибка"), Duration.ofSeconds(15));
    }

  //  public static VerificationPage validLogin(DataHelper.AuthInfo info) {
    //    $("[data-test-id=login] input").setValue(info.getLogin());
      //  $("[data-test-id=password] input").setValue(info.getPassword());
        //$("[data-test-id=action-login]").click();
        //return new VerificationPage();
   // }
    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        return new VerificationPage();
    }
    public static  void notValidPassword(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $("[data-test-id=password] input").setValue(DataHelper.getRandomUser().getPassword());
        $("[data-test-id=action-login]").click();
        $("[data-test-id='error-notification']");
 //       return new VerificationPage();
    }
}