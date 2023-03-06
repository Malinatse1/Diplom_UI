# Проект по автоматизации тестирования сайта МТС :abacus:

## Стек используемых технологий

<p  align="left"

<code><img width="5%" title="IntelliJ IDEA" src="readme_resources/Idea.svg"></code>
<code><img width="5%" title="Java" src="readme_resources/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="readme_resources/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="readme_resources/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="readme_resources/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="readme_resources/JUnit5.svg"></code>
<code><img width="5%" title="GitHub" src="readme_resources/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="readme_resources/Allure_Report.svg"></code>
<code><img width="5%" title="Jenkins" src="readme_resources/Jenkins.svg"></code>
<code><img width="5%" title="Telegram" src="readme_resources/Telegram.svg"></code>
<code><img width="5%" title="Allure_TO" src="readme_resources/Allure_TO.svg"></code>
</p>

В данном проекте автотесты написаны на `Java` с использованием `Selenide` для UI-тестов.

`Selenoid выполняет` запуск браузеров в контейнерах `Docker`.

`Allure Report` формирует отчет о запуске тестов.

Для автоматизированной сборки проекта используется `Gradle`.

В качестве библиотеки для модульного тестирования используется `JUnit 5.`

`Jenkins` выполняет запуск тестов. После завершения прогона отправляются уведомления с помощью бота в `Telegram`.
`Allure TestOps` - как система управления тестированием.
##  Запуск тестов из терминала :computer:
###  Локальный запуск тестов
```gradle clean test```
###   Удаленный запуск тестов
 ```
  clean
  ${TASK}
-DremoteUrl=${REMOTE_URL}
-DbrowserSize=${BROWSER_SIZE}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
```

###    Параметры сборки
```REMOTE_URL``` – адрес удаленного сервера, на котором будут запускаться тесты.

```BROWSER``` – браузер, в котором будут выполняться тесты (по умолчанию - chrome).

```BROWSER_VERSION``` – версия браузера, в которой будут выполняться тесты (по умолчанию - 91.0).

```BROWSER_SIZE``` – размер окна браузера, в котором будут выполняться тесты (по умолчанию - 1920x1080).
##  Запуск тестов в Jenkins
Для запуска сборки необходимо указать значения параметров и нажать кнопку ```Собрать```.

![](/readme_resources/Jenkins.png)

После завершения сборки результаты тестирования доступны в:
>- <code><strong>*Allure Report*</strong></code>
>- <code><strong>*Allure TestOps*</strong></code> - результаты загружаются туда и тест-кейсы могут автоматически обновляться в соответствии с последними изменениями в коде.

##  Отчет о результатах тестирования в Allure Report :bar_chart:
###  Основной Дашборд ###
Для перехода к просмотру отчета в разделе "История сборок" нажать значок "Allure Report", откроется страница с отчетом по прохождению.

![This is an image](/readme_resources/Allure_results.png)

###  Группировка тестов по проверяемому функционалу ###

![This is an image](/readme_resources/Allure_steps.png)
##  Уведомления в Telegram с использованием бота

После завершения сборки, Вам будет отправлено уведомление в ```Telegram``` с отчетом о прохождении.

![This is an image](/readme_resources/Telegram_bot.png)

## <img width="4%" title="Allure TestOPS" src="readme_resources/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/18485)
### Основной дашборд

<p align="center">
  <img src="readme_resources/Allure_TO_dashboard.png" alt="dashboard" width="900">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="readme_resources/Allure_TO_results.png" alt="dashboard" width="900">
</p>



##  Пример запуска теста в Selenoid :film_strip:

К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="readme_resources/video.gif">
</p>

