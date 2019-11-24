package Business;

import io.restassured.response.Response;
import io.restassured.config.Config;
import net.serenitybdd.rest.SerenityRest;

public class SkyScannerSession {

    private String baseurl;
    private String baseurl2;
    private String baseurlsessionid;
    private String apikey;
    private String apihost;
    private Response response;



    public SkyScannerSession(){

        this.baseurl = DefaultKeys.baseurl;
        this.baseurl2 = DefaultKeys.baseurl2;
        this.apikey  = DefaultKeys.apikey;
        this.apihost  = DefaultKeys.apihost;

    }



    public Response postCreateSessionID(String originplace, String destinationplace,
                                        String inbounddate, String outbounddate, String cabinclass, String adults) {

        response = SerenityRest.given()
                .baseUri(baseurl)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("originPlace",originplace)
                .formParam("destinationPlace",destinationplace)
                .formParam("inboundDate",inbounddate)
                .formParam("outboundDate",outbounddate)
                .formParam("cabinClass",cabinclass)
                .formParam("adults",adults)
                .formParam("country","AU")
                .formParam("currency","AUD")
                .formParam("locale","en-US")
                .headers("x-rapidapi-host", apihost)
                .headers("x-rapidapi-key", apikey)
                .when().post("/oauth2/token");


        return response;
    }

  /*  public Response postCreateSessionid(String originplace, String destinationplace,
                                        String inbounddate, String outbounddate, String cabinclass, String adults) {

        response = SerenityRest.given().headers("x-rapidapi-host", apihost).
                headers("x-rapidapi-key", apikey).
                body("originPlace", originplace).
                body("destinationPlace", destinationplace).
                body("inboundDate", inbounddate).
                body("outboundDate", outbounddate).
                body("cabinClass", cabinclass).
                body("adults", adults).
                body("country", "AU").
                body("currency","AUD").
                body("locale","en-US").when().post(baseurl);

        return response;
    }
 */

        public Response getPollSession(String sessionid) {

            baseurlsessionid = baseurl2.concat(sessionid);
            response = SerenityRest.given()
                    .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                    .headers("x-rapidapi-host", apihost).
                    headers("x-rapidapi-key", apikey).
                    when().get(baseurlsessionid);

            return response;
        }

}
