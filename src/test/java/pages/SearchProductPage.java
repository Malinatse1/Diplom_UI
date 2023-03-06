package pages;

import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
public class SearchProductPage {
    public final String product = "AirPods Pro";
    public final String filterUsefulArticles = "Полезные статьи";
    public final String filterReset = "Сбросить";
    public final String filterNews = "Новости";

    @Step(" Проверка, что в списке есть искомый продукт")
    public SearchProductPage checkListProduct(){
        $(".header-search__btn").click();
        $(".header-search__input").setValue(product);
        $(".header-search__input").pressEnter();
        return null;
    }

    @Step("Проверка меню в хедере")
    public SearchProductPage checkMenuHeader(){
        $(".header-search__btn").click();
        $(".header-search__input").setValue(product);
        $(".header-search__input").pressEnter();
        return null;
    }

    @Step("Проверка, что появился фильтр")
    public SearchProductPage checkFilterUsefulArticles(){
        step (" Проверка, что появился фильтр ",() -> {
            $(".mts-search__filter-container").shouldHave(text(filterUsefulArticles));
        });
        return null;
    }
    @Step("Нажать на фильтр 'Полезные статьи")
    public SearchProductPage clickFilterUsefulArticles(){
        $(".choose-filter__item").shouldHave(text(filterUsefulArticles)).click();
        return null;
    }
    @Step("Нажать на фильтр 'Новости")
    public SearchProductPage clickFilterNews(){
        $(".mts-search__filter-container").shouldHave(text(filterNews)).click();
        return null;
    }

    @Step("Проверка, что возле статей есть обозначение 'Полезные статьи")
    public SearchProductPage checkDesignationUsefulArticles(){
        $(".mts-search__result_badge").shouldHave(text(filterUsefulArticles));
        return null;
    }

    @Step("Проверка, что появился фильтр 'Сбросить'")
    public SearchProductPage checkFilterReset(){
        $(".mts-search__filter-container").shouldHave(text(filterReset));
        return null;
    }

    @Step("Нажать на фильтр 'Сбросить")
    public SearchProductPage clickFilterReset(){
        $(".mts-search__filter-container").shouldHave(text(filterReset)).click();
        return null;
    }

    @Step("Проверка, что фильтра 'Сбросить' нет")
    public SearchProductPage checkNoFilterReset(){
        $(".mts-search__result_badge").shouldNotHave(text(filterReset));
        return null;
    }
    @Step("Проверка, что появился фильтр 'Новости'")
    public SearchProductPage checkFilterNews(){
        $(".mts-search__filter-container").shouldHave(text(filterNews));
        return null;
    }
}
