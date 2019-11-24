package Business;

import net.serenitybdd.rest.SerenityRest;

import io.restassured.response.Response;

public class CurrentWeather {

    private String base_url;
    private String api_key;
    private Response response;

    public CurrentWeather(){

        this.base_url = DefaultKeys.base_url;
        this.api_key  = DefaultKeys.api_key;

    }

    public Response getWeatherWithLocation(String latitude, String longitude){

        response    = SerenityRest.given().params("lat",longitude).
                params("lon",latitude).
                params("key", api_key).
                when().get(base_url);

        return response;
    }

    public Response getWeatherWithPostalCode(String postcode){

        response    = SerenityRest.given().params("postal_code",postcode).
                params("key", api_key).
                when().get(base_url);

        return response;

    }



}
