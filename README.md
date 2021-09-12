# ServiceCurrency
Test task from Alfa Bank

The service that accesses the exchange rate service, and gives a gif in response:
if the exchange rate against the ruble for today has become higher than yesterday, then we give a random one from here https://giphy.com/search/rich 
if below - from here https://giphy.com/search/broke

1.To start the application, you need to register on the services to provide the api key:

https://docs.openexchangerates.org/

https://developers.giphy.com/docs/api#quick-start-guide

Enter the received keys into the appropriate sections of application.yml:

course.appId: f6ef239b77134d

gifs.apiKey: 6QAt1H7Flq17tOOpCh

I draw your attention to the fact that on the service of the exchange rate in a free mode, you can receive only the exchange rate in relation to USD.
If you have a paid api key, then the currency of interest must be entered in the application.yml settings

courses.base: USD
