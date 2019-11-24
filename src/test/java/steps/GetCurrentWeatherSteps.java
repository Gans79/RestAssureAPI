package steps;

import net.serenitybdd.rest.SerenityRest;

import Business.CurrentWeather;

import static org.hamcrest.Matchers.is;

import net.serenitybdd.junit.runners.SerenityRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetCurrentWeatherSteps {

    private Response response;
    CurrentWeather currentWeather =new CurrentWeather();


    @Step("I try to search the weather with {0} post code")
    public void searchWeatherByPostcode(String postcode){
        response = currentWeather.getWeatherWithPostalCode(postcode);
    }

    @Step("then I should get status code {0}")
    public void searchIsExecutedSuccesfully(int code){
        response.then().statusCode(code);
    }

    @Step
    public void iShouldFindWeather(String weather){
        response.then().body("data[0].weather.description", is(weather));
    }

    @Step("I try to search the weather with {0} latitude and {1} longitude")
    public void searchWeatherByLocation(String latitude, String longitude){
        response = currentWeather.getWeatherWithLocation(latitude, longitude);
    }
}
