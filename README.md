# Finzy-Weather-App
Weather API - Using OpenWeatherMap Services.

# Description
Built an Backend Application where users can see the weather for one of the following cities:  
● Bengaluru  
● New Delhi  
● Mumbai
● Kolkata  

The website should have a listing page where all the four cities are listed with their current weather conditions. A details page should also be made accessible where each city’s 5 days forecasted weather is available to view.  The weather data can be accessed using OpenWeatherMaps. They provide an API free of cost here.  As the number of calls that can be made to OpenWeatherMaps API is limited in the free version and the weather gets updated every couple of hours, the data once fetched should be cached for a configurable amount of time so that the weather data is always available to the users of our website. 

# Requirements
* Java 1.8
* Spring Boot
* Mongo DB
* OpenWeather API-Key

# Implemented features:
* 5 days Data / 3-hour forecast
* Current weather data

# First steps
Make a API call to backend service to fetch the current weather by providing required details like city name or city id. The data will be fetched from MongoDB. Note, that 4 cities are initialized on setting up the context.

# Limitations (and possible improvements)
->If a city is removed all weather data for the city is removed as well and no more weather data will be queried for it.
->All weather data is fetched by city name (vs. city id, which the API also supports). For this reason bulk requests are currently not used although some parts of it have been implemented (see the javadoc for comments on what changes would be necessary).
->Detailed error handling and handling of invalid/faulty data from the API is not implemented! What is handled are invalid city names.
->Unit tests need to be extended!

