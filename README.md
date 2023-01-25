# Проект по автоматизации тестирования сайта МТС

В данном проекте автотесты написаны на `Java` с использованием `Selenide` для UI-тестов.

`Selenoid выполняет` запуск браузеров в контейнерах `Docker`.

`Allure Report` формирует отчет о запуске тестов.

Для автоматизированной сборки проекта используется `Gradle`.

В качестве библиотеки для модульного тестирования используется `JUnit 5.`

`Jenkins` выполняет запуск тестов. После завершения прогона отправляются уведомления с помощью бота в `Telegram`.
##  Запуск тестов из терминала
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

![Главная страница Allure-отчета](/src/test/resources/2023-01-25_20-18-18.png)


##  Отчет о результатах тестирования в Allure Report
###  Основной Дашборд ###
Для перехода к просмотру отчета в разделе "История сборок" нажать значок "Allure Report", откроется страница с отчетом по прохождению.
![This is an image](/src/test/resources/2023-01-25_20-34-04.png)
###  Группировка тестов по проверяемому функционалу ###
![This is an image](/src/test/resources/2023-01-25_20-38-06.png)
##  Уведомления в Telegram с использованием бота
После завершения сборки, Вам будет отправлено уведомление в ```Telegram``` с отчетом о прохождении.
![This is an image](/src/test/resources/2023-01-25_20-42-42.png)
##  Пример запуска теста в Selenoid
К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
