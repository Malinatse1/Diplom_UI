package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class CheckSearchAndFilters extends TestBase {
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    @DisplayName("Проверка поиска и нажатие на 'Enter' ")
    @Tag("Позитивный кейс")
    public void Test1SearchAndApplyCheckOnEnter (){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что в списке есть AirPods Pro",() -> {
            $(".mts-search__results").shouldHave(text("AirPods Pro"));
        });
    }
    @Test
    @DisplayName("Проверка меню в хедере на странице поиска")
    @Tag("Позитивный кейс")
    public void Test2CheckMenuInHeader(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step("Проверка меню в хедере", () -> {
            $(".main-menu").shouldHave(text("Комбо"), text("Связь"),
                    text("Для дома"), text("Сервисы"), text("Финансы"), text("Интернет-магазин"));
        });
    }
    @Test
    @DisplayName("Проверка фильтра на странице поиска")
    @Tag("Позитивный кейс")
    public void Test3CheckFiltersOnTheSearchPage(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что появился фильтр ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Полезные статьи"));
        });
    }

    @Test
    @DisplayName("Проверка фильтра 'Сбросить'")
    @Tag("Позитивный кейс")
    public void Test4CheckFilterReset(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что появился фильтр 'Полезные статьи' ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Полезные статьи"));
        });
        step ("Нажать на фильтр 'Полезные статьи' ",() -> {
            $(".choose-filter__item").shouldHave(text("Полезные статьи")).click();
        });
        step (" Проверка, что возле статей есть обозначение 'Полезные статьи' ",() -> {
            $(".mts-search__result_badge").shouldHave(text("Полезные статьи"));
        });
        step (" Проверка, что появился фильтр 'Сбросить' ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Сбросить"));
        });
        step ("Нажать на фильтр 'Сбросить' ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Сбросить")).click();
        });
        step (" Проверка, что фильтра 'Сбросить' нет ",() -> {
            $(".mts-search__result_badge").shouldNotHave(text("Сбросить"));
        });
    }
    @Test
    @DisplayName("Проверка, что без выбранного одного из фильтра нет 'Сбросить'")
    @Tag("Позитивный кейс")
    public void Test5CheckFilterResetWithoutFilter(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что появился фильтр ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Полезные статьи"));
        });
        step (" Проверка, что фильтра 'Сбросить' нет ",() -> {
            $(".mts-search__result_badge").shouldNotHave(text("Сбросить"));
        });
    }
    @AfterEach
    void AfterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
