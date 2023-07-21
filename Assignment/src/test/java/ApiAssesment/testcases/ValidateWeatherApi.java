package ApiAssesment.testcases;

import ApiAssesment.builders.RequestBuilder;
import ApiAssesment.resources.Endpoints;
import ApiAssesment.utility.Utility;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateWeatherApi {
    @Test
    public void validategetRequest(){
        String city = "bangalore";
        Response response = given().spec(RequestBuilder.getrequestSpecification()).log().all()
                    .queryParam("unitGroup", "metric")
                    .queryParam("contentType", "json")
                    .queryParam("key", "3CJRV4WYALYKMSD6Y3MR2AKUD")
                .when()
                    .get(Endpoints.GetWeatherEndpoint()+city)
                .then().log().all().statusCode(200).extract().response();

        //validating the Response
        Assert.assertEquals(Utility.JsonParseKey(response,"address"),city);    // validate response is coming for given city
        Assert.assertTrue(Utility.JsonParseKey(response,"latitude")!=null); // validate latitude
        Assert.assertTrue(Utility.JsonParseKey(response,"longitude") !=null); // validate longitude
        Assert.assertEquals(Utility.JsonParseKey(response,"days[0].datetime"), Utility.getCurrentDate());
        Double temp= Double.parseDouble(Utility.JsonParseKey(response,"days[0].temp"));//validate tempature for the current date
        Assert.assertTrue(temp!=null && temp>= 20.0);


        /*Note :
        here i am using JsonPath to parse the response
        we can use the JsonParser or Mapper as well
        we can convert Response to pojo and validate but that is very lengthy approach
         */
    }
}

 /* Requirement :
       Part 2 - API test
        Create an automated test for getting weather data using API endpoint.
        You can use framework of your choice for RESTful API test automation. We use REST Assured.
        In order to use API, you need to get a key, for this you have to sign up for a
        VisualCrossing account at https://www.visualcrossing.com.
        You can find the API key under you "Account Details" menu after you log in to VisualCrossing (click on "Account" button on the top right).
        The test should send GET request to the VisualCrossing API endpoint (replace Tallinn with your city in request):
        https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Tallinn?unitGroup=metric&key=YOUR_API_KEY&contentType=json
        Verify returned response contains correct data.
        Decide what assertions should be used to verify the correctness of the response and add them to the test.
        */
