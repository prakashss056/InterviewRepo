package ApiAssesment.utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    private static Response response;
    public static String JsonParseKey(Response response, String key){
        JsonPath js= new JsonPath(response.asString());
        return js.get(key).toString();
    }

    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String cdate = formatter.format(date);
        return cdate;
    }

}
