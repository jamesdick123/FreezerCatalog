# FreezerCatalog
Springboot application allowing http requests for managing a freezer catalog


# Brief Summary
Due to not having used springboot in the past, I was unable to complete many of the Unit tests that were expected. Despite this, I conducted some tests by running both GET and POST requests through Postman to determine that the functions developed still worked correctly. Perhaps, with training within Springboot I would have been able to complete unit tests, or alternatively complete some integration tests. 

The method I incorporated that allows adding a food item to the freezer, also functions as the updating method. This could have been improved by separating this into 2 methods, so that anyone using the API could never accidentally update when attempting to add, or vice versa. 

A further advancement that could be made could be not allowing redundant data to be added. If chicken was already in the freezer, the API could prevent the user from storing another row with the name "chicken".

When searching for a food item, I decided that it would be better to remove any case-sensitivity aspects from the method. I found that if the user was looking for a particular food item, it would be unlikely that CHicken and chicken for example would need to be different. The prior advancement mentioned of not allowing redundant data could also make use of this feature, checking for all ways of capitalisation in order to prevent redundant data.
