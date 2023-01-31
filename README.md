# Проект по автоматизации тестирования сайта МТС :abacus:

## Стек используемых технологий

<p  align="center"

<code><img width="5%" title="IntelliJ IDEA" src="readme_resources/IDEA.svg"></code>
<code><img width="5%" title="Java" src="readme_resources/Java.svg"></code>
<code><img width="5%" title="Selenoid" src="readme_resources/Selenoid.svg"></code>
<code><img width="5%" title="Selenide" src="readme_resources/Selenide.svg"></code>
<code><img width="5%" title="Gradle" src="readme_resources/Gradle.svg"></code>
<code><img width="5%" title="Junit5" src="readme_resources/Junit5.svg"></code>
<code><img width="5%" title="GitHub" src="readme_resources/GitHub.svg"></code>
<code><img width="5%" title="Allure Report" src="readme_resources/Allure_Report.svg"></code>
<code><img width="5%" title="Jenkins" src="readme_resources/Jenkins.svg"></code>
<code><img width="5%" title="Jira" src="readme_resources/Java.svg"></code>
<code><img width="5%" title="Telegram" src="readme_resources/Telegram.svg"></code>
</p>

В данном проекте автотесты написаны на `Java` с использованием `Selenide` для UI-тестов.

`Selenoid выполняет` запуск браузеров в контейнерах `Docker`.

`Allure Report` формирует отчет о запуске тестов.

Для автоматизированной сборки проекта используется `Gradle`.

В качестве библиотеки для модульного тестирования используется `JUnit 5.`

`Jenkins` выполняет запуск тестов. После завершения прогона отправляются уведомления с помощью бота в `Telegram`.
##  Запуск тестов из терминала :computer:
###  Локальный запуск тестов
```gradle clean test```
###   Удаленный запуск тестов
 ```gradle clean test
    -Dbrowser=${BROWSER}
    -DbrowserVersion=${BROWSER_VERSION}
    -DbrowserSize=${BROWSER_SIZE}
    -DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
    -DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
    -Dthreads=${THREADS}/
```

###    Параметры сборки
```REMOTE_URL``` – адрес удаленного сервера, на котором будут запускаться тесты.

```BROWSER``` – браузер, в котором будут выполняться тесты (по умолчанию - chrome).

```BROWSER_VERSION``` – версия браузера, в которой будут выполняться тесты (по умолчанию - 91.0).

```BROWSER_SIZE``` – размер окна браузера, в котором будут выполняться тесты (по умолчанию - 1920x1080).
##  Запуск тестов в Jenkins
Для запуска сборки необходимо указать значения параметров и нажать кнопку ```Собрать```.

![](/readme_resources/Jenkins.png)


##  Отчет о результатах тестирования в Allure Report :bar_chart:
###  Основной Дашборд ###
Для перехода к просмотру отчета в разделе "История сборок" нажать значок "Allure Report", откроется страница с отчетом по прохождению.

![This is an image](/readme_resources/Allure_result.png)

###  Группировка тестов по проверяемому функционалу ###

![This is an image](/readme_resources/Allure_steps.png)
##  Уведомления в Telegram с использованием бота

После завершения сборки, Вам будет отправлено уведомление в ```Telegram``` с отчетом о прохождении.

![This is an image](/readme_resources/Telegram_bot.png)
##  Пример запуска теста в Selenoid :film_strip:

К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="readme_resources/video.mp4">
</p>

