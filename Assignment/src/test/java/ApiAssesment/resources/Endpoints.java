package ApiAssesment.resources;

public class Endpoints {

    private static String Base_url = "https://weather.visualcrossing.com/";
    private static String GetWeatherEndpoint = "VisualCrossingWebServices/rest/services/timeline/";


    public static String getbaseUrl(){
        return Base_url;
    }
    public static String GetWeatherEndpoint(){
        return GetWeatherEndpoint;
    }
}
