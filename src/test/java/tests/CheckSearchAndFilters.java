package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.SearchProductPage;
public class CheckSearchAndFilters extends TestBase {
    MainPage mainPage = new MainPage();
    SearchProductPage searchProductPage = new SearchProductPage();
    @Test
    @DisplayName("Проверка поиска и нажатие на 'Enter' ")
    @Tag("Позитивный кейс")
    public void test1SearchAndApplyCheckOnEnter (){
        mainPage.searchProduct();
        searchProductPage.checkListProduct();
    }
    @Test
    @DisplayName("Проверка фильтра Новости на странице поиска")
    @Tag("Позитивный кейс")
    public void test2CheckFilterNewsOnTheSearchPage() {
        mainPage.searchProduct();
        searchProductPage.checkFilterNews();
    }
    @Test
    @DisplayName("Проверка фильтра Полезные статьи на странице поиска")
    @Tag("Позитивный кейс")
    public void test3CheckFilterUsefulOnTheSearchPage(){
        mainPage.searchProduct();
        searchProductPage.checkFilterUsefulArticles();
    }
    @Test
    @DisplayName("Проверка фильтра 'Сбросить' с выбранным фильтром 'Полезные статьи'")
    @Tag("Позитивный кейс")
    public void test4CheckClickFilterUsefulArticleAndReset(){
        mainPage.searchProduct();
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.clickFilterUsefulArticles();
        searchProductPage.checkDesignationUsefulArticles();
        searchProductPage.checkFilterReset();
        searchProductPage.clickFilterReset();
        searchProductPage.checkNoFilterReset();
    }
    @Test
    @DisplayName("Проверка, что без выбранного одного из фильтра нет 'Сбросить'")
    @Tag("Позитивный кейс")
    public void test5CheckFilterResetWithoutFilter(){
        mainPage.searchProduct();
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.checkNoFilterReset();
    }
    @Test
    @DisplayName("Проверка, что можно нажать на оба фильтра 'Новости' и 'Полезные статьи'")
    @Tag("Позитивный кейс")
    public void test6CheckClickBothFilters(){
        mainPage.searchProduct();
        searchProductPage.checkFilterUsefulArticles();
        searchProductPage.clickFilterUsefulArticles();
        searchProductPage.checkFilterNews();
        searchProductPage.clickFilterNews();
    }
    @Test
    @DisplayName("Проверка, что при двойном нажатии на фильтр 'Полезные статьи' пропадает фильтр 'Сбросить' ")
    @Tag("Позитивный кейс")
    public void test7CheckDoubleClickFilterAndReset() {
       mainPage.searchProduct();
       searchProductPage.checkFilterUsefulArticles();
       searchProductPage.clickFilterUsefulArticles();
       searchProductPage.checkDesignationUsefulArticles();
       searchProductPage.checkFilterReset();
       searchProductPage.clickFilterUsefulArticles();
       searchProductPage.checkNoFilterReset();
    }
}
