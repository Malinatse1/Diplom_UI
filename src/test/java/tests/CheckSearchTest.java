package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchProductPage;

@Tag("Позитивный кейс")
@Owner("Bochkova N")
public class CheckSearchTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchProductPage searchProductPage = new SearchProductPage();

    @Test
    @DisplayName("Проверка поиска и нажатие на 'Enter' ")
    public void test1CheckSearchProduct() {
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkListProduct("AirPods Pro");
    }
}
