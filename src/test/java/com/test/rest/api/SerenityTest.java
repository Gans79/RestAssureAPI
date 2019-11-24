package com.test.rest.api;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.GetCurrentWeatherSteps;


@RunWith(SerenityRunner.class)
public class SerenityTest {


    @Steps
    GetCurrentWeatherSteps getCurrentWeatherSteps;

    @Test
    public void verifyThatUserCanQueryCurrentWeatherWithPostCode() {
        getCurrentWeatherSteps.searchWeatherByPostcode("2150");
        getCurrentWeatherSteps.searchIsExecutedSuccesfully(200);
        getCurrentWeatherSteps.iShouldFindWeather("Clear sky");
    }

    @Test
    public void verifyThatUserCanQueryCurrentWeatherWithPostCode_negativeTest() {
        getCurrentWeatherSteps.searchWeatherByPostcode("2150");
        getCurrentWeatherSteps.searchIsExecutedSuccesfully(400);
        getCurrentWeatherSteps.iShouldFindWeather("Clear sky");
    }

    @Test
    public void verifyThatUserCanQueryCurrentWeatherWithLocation() {
        getCurrentWeatherSteps.searchWeatherByLocation("38","78.25");
        getCurrentWeatherSteps.searchIsExecutedSuccesfully(200);
        getCurrentWeatherSteps.iShouldFindWeather("Scattered clouds");
    }



}
