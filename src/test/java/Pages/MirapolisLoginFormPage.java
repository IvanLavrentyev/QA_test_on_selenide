package Pages;// Главная страницв тестируемого сайта

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MirapolisLoginFormPage {
    private final SelenideElement loginField = $x("//input [@placeholder='Введите ваш логин']");
    private final SelenideElement passwordField = $x("//input [@placeholder='Введите ваш пароль']");
    private final SelenideElement enterButton = $x("//button[@id='button_submit_login_form']");
    private final SelenideElement title = Selenide.$x("//title[text()='Авторизация']");

    public SelenideElement getLoginField() {
        return loginField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public void fillLoginField(String login){
        loginField.sendKeys(login);;
    }

    public void fillPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void clickAtEnter(){
        enterButton.click();
    }

    public boolean loginFieldIsPresentOnPage(){
        return loginField.isDisplayed();
    }

    public String getTitle(){
        return title.getOwnText();
    }

}
