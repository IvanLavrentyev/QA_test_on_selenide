package tests;

import pages.MirapolisAuthPassedPage;
import pages.MirapolisLoginFormPage;
import pages.MirapolisOpenPage;
import initialization.BaseTest;
import com.codeborne.selenide.Selenide;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MirapolisTest extends BaseTest{

    private final String BASE_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private final String TITLE = "Авторизация";
    private final String LOGIN = "fominaelena";
    private final String PASSWORD = "1P73BP4Z";


    @Before
    public void beforeTests(){
        MirapolisOpenPage mirapolisOpenPage = new MirapolisOpenPage();
        mirapolisOpenPage.openPage(BASE_URL);
    }

    // проверка заговолока открываемой страницы
    @Test
    public void checkTitle(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        Assert.assertEquals(TITLE, mirapolisLoginFormPage.getTitle());
    }

    // положительная проверка, пароль и логин верные
    @Test
    public void loginTestPositiveCheck(){
         MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
         mirapolisLoginFormPage.fillLoginField(LOGIN);
         mirapolisLoginFormPage.fillPasswordField(PASSWORD);
         mirapolisLoginFormPage.clickAtEnter();

        MirapolisAuthPassedPage mirapolisAuthPassedPage = new MirapolisAuthPassedPage();
        Assert.assertTrue(mirapolisAuthPassedPage.getPersonalData().contains("Сотрудник"));
    }

//     отрицательная проверка, неверный пароль
    @Test
    public void loginTestNegativeWrongPassword(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        mirapolisLoginFormPage.fillLoginField(LOGIN);
        mirapolisLoginFormPage.fillPasswordField(PASSWORD.concat(PASSWORD));
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, неверный логин
    @Test
    public void loginTestNegativeWrongLogin(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        mirapolisLoginFormPage.fillLoginField(LOGIN.concat(LOGIN));
        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, слишком длинный логин
    @Test
    public void loginIsTooLong(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        StringBuilder builder = new StringBuilder(LOGIN);

        for (int i = 0; i <100 ; i++)
            builder = builder.append(LOGIN);

        mirapolisLoginFormPage.fillLoginField(builder.toString());

        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, слишком длинный пароль
    @Test
    public void passwordIsTooLong(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        mirapolisLoginFormPage.fillLoginField(LOGIN);

        StringBuilder builder = new StringBuilder(PASSWORD);
        for (int i = 0; i <100 ; i++)
            builder = builder.append(PASSWORD);

        mirapolisLoginFormPage.fillPasswordField(builder.toString());

        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }


    //     отрицательная проверка, поле пароля пусто
    @Test
    public void loginTestNegativeEmptyPassword(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        mirapolisLoginFormPage.fillLoginField(LOGIN);
        mirapolisLoginFormPage.fillPasswordField("");
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, поле логина пусто
    @Test
    public void loginTestNegativeEmptyLogin(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();
        mirapolisLoginFormPage.fillLoginField("");
        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, логин содержить пробелы в конце
    @Test
    public void loginTestNegativeExtraSpacersAfterLogin(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(LOGIN.concat("  "));
        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, пароль содержить пробелы в конце
    @Test
    public void loginTestNegativeExtraSpacersAfterPassword(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(LOGIN);
        mirapolisLoginFormPage.fillPasswordField(PASSWORD.concat("   "));
        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, логин содержить пробелы в начале
    @Test
    public void loginTestNegativeExtraSpacersBeforeLogin(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(("  ").concat(LOGIN));
        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, пароль содержить пробелы в начале
    @Test
    public void loginTestNegativeExtraSpacersBeforePassword(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(LOGIN);
        mirapolisLoginFormPage.fillPasswordField(("   ").concat(PASSWORD));
        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, пароль содержить непечатуемые символы в конце
    @Test
    public void loginTestNegativeUnestablishedSymbolInPassword(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(LOGIN);
        mirapolisLoginFormPage.fillPasswordField(PASSWORD.concat("\u0003"));
        mirapolisLoginFormPage.clickAtEnter();
        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    //     отрицательная проверка, логин содержить непечатуемые символы в конце
    @Test
    public void loginTestNegativeUnestablishedSymbolInLogin(){
        MirapolisLoginFormPage mirapolisLoginFormPage = new MirapolisLoginFormPage();

        mirapolisLoginFormPage.fillLoginField(LOGIN.concat("\u0003"));
        mirapolisLoginFormPage.fillPasswordField(PASSWORD);
        mirapolisLoginFormPage.clickAtEnter();

        Assert.assertTrue(mirapolisLoginFormPage.getLoginField().getText().isEmpty());
    }

    @After
    public void close(){
        Selenide.closeWebDriver();
    }
}


