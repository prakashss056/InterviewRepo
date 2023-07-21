package ApiAssesment.builders;

import ApiAssesment.resources.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static RequestSpecification requestSpecification;

    public static RequestSpecification getrequestSpecification(){
        requestSpecification=  new RequestSpecBuilder()
                .setBaseUri(Endpoints.getbaseUrl())
                .addQueryParam("unitGroup","metric")
                .addQueryParam("key","3CJRV4WYALYKMSD6Y3MR2AKUD")
                .setContentType(ContentType.JSON)
                .build();
        return requestSpecification;
    }
}
