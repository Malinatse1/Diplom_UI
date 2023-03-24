package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.SearchProductPage;

@Tag("Позитивный кейс")
@Owner("Bochkova N")
public class CheckFiltersTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchProductPage searchProductPage = new SearchProductPage();

    @Test
    @DisplayName("Проверка фильтра Новости на странице поиска")
    public void test1CheckFilterNewsOnTheSearchPage() {
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkFilterNews();
    }
    @Test
    @DisplayName("Проверка фильтра Полезные статьи на странице поиска")
    public void test2CheckFilterUsefulOnTheSearchPage(){
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkFilterUsefulArticles();
    }
    @Test
    @DisplayName("Проверка фильтра 'Сбросить' с выбранным фильтром 'Полезные статьи'")
    public void test3CheckClickFilterUsefulArticleAndReset(){
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.clickFilterUsefulArticles();
        searchProductPage.checkDesignationUsefulArticles();
        searchProductPage.checkFilterReset();
        searchProductPage.clickFilterReset();
        searchProductPage.checkNoFilterReset();
    }
    @Test
    @DisplayName("Проверка, что без выбранного одного из фильтра нет 'Сбросить'")
    public void test4CheckFilterResetWithoutFilter(){
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.checkNoFilterReset();
    }
    @Test
    @DisplayName("Проверка, что можно нажать на оба фильтра 'Новости' и 'Полезные статьи'")
    public void test5CheckClickBothFilters(){
        mainPage.searchProduct("AirPods Pro");
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.clickFilterUsefulArticles();
        searchProductPage.checkFilterNews();
        searchProductPage.clickFilterNews();
    }
    @Test
    @DisplayName("Проверка, что при двойном нажатии на фильтр 'Полезные статьи' пропадает фильтр 'Сбросить' ")
    public void test6CheckDoubleClickFilterAndReset() {
       mainPage.searchProduct("AirPods Pro");
       searchProductPage.checkFilterUsefulArticles();
       searchProductPage.clickFilterUsefulArticles();
       searchProductPage.checkDesignationUsefulArticles();
       searchProductPage.checkFilterReset();
       searchProductPage.clickFilterUsefulArticles();
       searchProductPage.checkNoFilterReset();
    }
}
