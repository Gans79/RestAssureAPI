package steps;

import Business.SkyScannerSession;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

public class SkyScannerSteps {

    private Response response;
    private String  locationid;
    private String  sessionid;




    SkyScannerSession skyScannerSession =new SkyScannerSession();


    @Step("I try to search skyscanner with {0} origin {1} destination {2} inbounddate {3} outbounddate " +
            " {4} cabinclass {5} adults ")
    public void postTwoLocations(String originplace, String destinationplace,
                                 String inbounddate, String outbounddate,
                                 String cabinclass, String adults ){
        response  = skyScannerSession.postCreateSessionID(originplace, destinationplace,
                inbounddate,outbounddate,cabinclass,adults);
        locationid = response.getHeader("Location");
        String[] parts = locationid.split("/");
        sessionid = parts[6];


    }

    @Step("Then I should get status code {0}")
    public void searchIsExecutedSuccesfully(int code){
        response.then().statusCode(code);
    }


    @Step("I can get the search results using sessionid ")
    public void getTwoLocations(){
        response = skyScannerSession.getPollSession(sessionid);
    }


}
