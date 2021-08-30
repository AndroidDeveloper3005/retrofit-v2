# retrofit-v2
Retrofit requires three main components:
1. Retrofit Instance:
We can create an instance of Retrofit by Retrofit.Builder class. And we have to specify the base url and converter factory at the time of the Retrofit instance creation

2. Model Class:
Retrofit needs a Model class for sending and receiving Request. It uses the model class for parsing server Response by using converters like Gson, Moshi etc.

3. An Interface for possible API calls:
The interface contains methods that represents possible API calls. Each methods need a base Url end point annotation that represents the Http methods like GET, POST etc.
