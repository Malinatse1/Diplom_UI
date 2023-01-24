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
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.mts.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @Test
    @DisplayName("Проверка поиска и нажатие на 'Enter' ")
    @Tag("Позитивный кейс")
    public void TestSearchAndApplyCheckOnEnter (){

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
    @DisplayName("Проверка поиска и переход по найденному результату")
    @Tag("Позитивный кейс")
    public void TestSearchAndApplyCheckOnEnterAndGoingToResult(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step ("Проверка, что в списке есть AirPods Pro",() -> {
            $(".mts-search__results").shouldHave(text("AirPods Pro")).click();
        });
        step (" Проверка, что в статье есть AirPods Pro",() -> {
            $(".section-box").shouldHave(text("На фоне перехода на удаленный формат работы продажи беспроводных наушников в России выросли в полтора раза"));
        });
    }
    @Test
    @DisplayName("Проверка фильтров на странице поиска")
    @Tag("Позитивный кейс")
    public void TestCheckFiltersOnTheSearchPage(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что появились два фильтра ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Полезные статьи"));
            $(".mts-search__filter-container").shouldHave(text("Новости"));
        });
    }

    @Test
    @DisplayName("Проверка фильтра 'Сбросить'")
    @Tag("Позитивный кейс")
    public void TestCheckFilterReset(){

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
    public void TestCheckFilterResetWithoutFilter(){

        SelenideLogger.addListener("allure", new AllureSelenide());

        step ("Открыть страницу МТС",() ->
        {open("https://www.mts.ru");
        });
        step ("Ввести в поиск данные",() -> {
            $(".header-search__btn").click();
            $(".header-search__input").sendKeys("AirPods Pro");
            $(".header-search__input").pressEnter();
        });
        step (" Проверка, что появились два фильтра ",() -> {
            $(".mts-search__filter-container").shouldHave(text("Полезные статьи"));
            $(".mts-search__filter-container").shouldHave(text("Новости"));
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
