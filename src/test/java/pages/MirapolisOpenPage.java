package pages;
import com.codeborne.selenide.Selenide;

public class MirapolisOpenPage  {


    public void openPage(String url) {
        Selenide.open(url);
    }
}
