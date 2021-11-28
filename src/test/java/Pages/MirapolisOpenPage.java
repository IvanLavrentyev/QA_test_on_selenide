package Pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class MirapolisOpenPage  {


    public void openPage(String url) {
        Selenide.open(url);
    }
}
