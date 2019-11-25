package com.test.rest.api;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SkyScannerSteps;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
public class SerenityTest_SkyScanner {


        @TestData
        public static Collection<Object[]> testData(){
            return Arrays.asList(new Object[][]{
                    {"MEL-sky", "SYD-sky", "2019-12-01", "2019-12-20", "business", "1"},
                    {"MEL-sky", "SYD-sky", "2019-12-02", "2019-12-21", "business", "2"},


            });
        }

        private String  originplace;
        private String  destinationplace;
        private String  inbounddate;
        private String  outbounddate;
        private String  cabinclass;
        private String  adults;





    public SerenityTest_SkyScanner(String originplace, String  destinationplace,
                                       String inbounddate, String outbounddate,
                                       String cabinclass, String adults){
            this.originplace =originplace;
            this.destinationplace =destinationplace;
            this.inbounddate = inbounddate;
            this.outbounddate = outbounddate;
            this.cabinclass = cabinclass;
            this.adults = adults;



    }

    @Steps
    SkyScannerSteps skyScannerSteps;

    @Test
    @WithTag("feature:skyscanner")
    public void verifyThatUserCanPollSession_paramterized() {
        skyScannerSteps.postTwoLocations(originplace,destinationplace,outbounddate,
                inbounddate, cabinclass,adults );
        skyScannerSteps.searchIsExecutedSuccesfully(200);
        skyScannerSteps.getTwoLocations();
        skyScannerSteps.searchIsExecutedSuccesfully(200);
    }



}
