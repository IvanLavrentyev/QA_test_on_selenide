package Pages; // Страница личного кабинета

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MirapolisAuthPassedPage {
     private final SelenideElement personalData = $x("//div[@title='Сотрудник']");
     private final SelenideElement logout = $x("//span[text()='Выйти']");

     public String getPersonalData(){
          return personalData.getText();
     }

     public void logout(){
          personalData.click();
          logout.click();
     }


}
