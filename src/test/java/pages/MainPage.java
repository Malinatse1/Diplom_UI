package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    @Step ("Ввести в поиск данные")
    public SearchProductPage searchProduct(String product){
        $(".header-search__btn").click();
        $(".header-search__input").sendKeys(product);
        $(".header-search__input").pressEnter();
        return null;
    }
}
