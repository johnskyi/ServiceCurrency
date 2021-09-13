# ServiceCurrency
Test task from Alfa Bank

The service that accesses the exchange rate service, and gives a gif in response:
if the exchange rate against the ruble for today has become higher than yesterday, then we give a random one from here https://giphy.com/search/rich 
if below - from here https://giphy.com/search/broke
____


## 1.To start the application, you need to register on the services to provide the api key:

**https://docs.openexchangerates.org/**

**https://developers.giphy.com/docs/api#quick-start-guide**

Enter the received keys into the appropriate sections of application.yml:

**course.appId: f6ef239b77134d**

**gifs.apiKey: 6QAt1H7Flq17tOOpCh**

_I draw your attention to the fact that on the service of the exchange rate in a free mode, you can receive only the exchange rate in relation to USD.
If you have a paid api key, then the currency of interest must be entered in the application.yml settings_

**courses.base: USD**
____
## 2. Pull projects at once

1.Create the servicecurrency root folder in your working space. You can choose another name if you want.
2.Execute the following git command inside that folder

**git clone https://github.com/johnskyi/ServiceCurrency**
____
## 3. Available method

### GET /api/{symbols}  ---- Returns gif depending on the course

{symbols} - Here you need to specify the currency of interest in international encoding (Example RUB, USD, EUR, AUD, etc.)

##4. Запуск приложения
Запускать проект можно несколькими способами:

1. Запустить приложение из среды разработки (Например Intellij IDEA) Приложение будет доступно по адресу http://localhost:8080/

  Приложение будет доступно по адресу http://localhost:8080/

2. Запустить через терминал\командную строку из корневой папки проекта

      **java -jar ServiceCurrency-0.0.1-SNAPSHOT.jar**
      
3. Запустить приложение из docker контейнера
 
**docker push johnskyi/service-currency:0.0.1**

Затем необходимо отредактировать файл application.yml по инструкции выше и запустить контейнер

**docker run -d -p 8080:8080 -v <Здесь путь к вашему файлу настроек >/application.yml:/config/application.yml --name anyname johnskyi/service-currency:latest**

Приложение также будет доступно по адресу http://localhost:8080/


##Enjoy. Thank you for the attention
  


