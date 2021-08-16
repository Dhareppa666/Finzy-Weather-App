# Finzy-Weather-App
Weather API - Using OpenWeatherMap Services.

# Description
Built an Backend Application where users can see the weather for one of the following cities:  
● Bengaluru  
● New Delhi  
● Mumbai
● Kolkata  

The website should have a listing page where all the four cities are listed with their current weather conditions. A details page should also be made accessible where each city’s 5 days forecasted weather is available to view.

# Requirements
* Java 11
* Spring Boot
* Mongo DB
* OpenWeather API-Key

# Implemented features:
* 5 days Data / 3-hour forecast
* Current weather data

# First steps
Make a API call to backend service to fetch the current weather by providing required details like city name or city id. The data will be fetched from MongoDB. Note, that 4 cities are initialized on setting up the context.

# Implemented Features In Detail : 
1. *At initial state of Application since we dont have any data on the DB, we schedule a job to update the DB with respective Details.
2. *By taking the city names from the Configuration/json file we fetch the weather data from the OpenWeatherMap for all the cities and upadte the DB with 5 days weather.
3. *if we get any request from the cleint it will be received from the client at Rest endpints and processed further.
4. *As of now by city name we fetch the required details from the DB and return back to the end User. Fatching the data from DB based on date is yet to be implmented for the Best practice.
5. *Since we are only making calls to DB and rest Calls its doesn't require much of Error handling at priority Level. But basic validation is added in the code like while fetching city name and all.
6. *Unit Test cases needs to be addressed.

# Endpoints available:
1. LB_CHECK (/api/LB_CHECK)
2. Fetch weather by city name (/api/city/{cityname})
