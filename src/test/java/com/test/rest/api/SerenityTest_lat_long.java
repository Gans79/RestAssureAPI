package com.test.rest.api;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import java.util.Arrays;
import net.thucydides.junit.annotations.TestData;
import org.junit.runner.RunWith;
import steps.GetCurrentWeatherSteps;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SerenityTest_lat_long {


        @TestData
        public static Collection<Object[]> testData(){
            return Arrays.asList(new Object[][]{
                    {"38", "78.25", "Overcast clouds"},
                    {"40", "78.25",  "Few clouds"},

            });
        }

        private String latitude;
        private String  longitude;
        private String  result;

        public SerenityTest_lat_long(String latitude, String  longitude, String  result){
            this.latitude =latitude;
            this.longitude =longitude;
            this.result = result;
        }

    @Steps
    GetCurrentWeatherSteps getCurrentWeatherSteps;

    @Test
    public void verifyThatUserCanQueryCurrentWeatherWithLocation_paramterized() {
        getCurrentWeatherSteps.searchWeatherByLocation(latitude,longitude);
        getCurrentWeatherSteps.searchIsExecutedSuccesfully(200);
        getCurrentWeatherSteps.iShouldFindWeather(result);
    }



}
