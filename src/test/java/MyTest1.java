import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class MyTest1 {

    String BaseUrl = "http://46.101.196.83/api";
    String token;


    @Test
    public void verifySOmething() {

        RestAssured.baseURI = "http://46.101.196.83/api";
        RequestSpecification request = RestAssured.given();
        request.headers("Content-Type", "application/x-www-form-urlencoded", "Authorization", "Basic YmV0MTE6YmV0MTE=");


request.formParam("grant_type","password")
                .formParam("username", "coffe22@mailinator.com")
                .formParam("platform", "ANDROID")
                .formParam("password", "Qwe1156q@@");
//?grant_type=password&username=coffe22@mailinator.com&platform=ANDROID&password=Qwe1156q@@
        request.post("/oauth/token").prettyPrint();
//System.out.println("Here you can find response\n"+response.body().prettyPeek());




       /* RestAssured.given().baseUri("http://46.101.196.83/api")
                .basePath("/oauth/token")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Authorization", "Basic YmV0MTE6YmV0MTE=")

                .formParam("grant-type", "password")
                .formParam("username", "coffe22@mailinator.com")
                .formParam("platform", "ANDROID")
                .formParam("password", "Qwe1156q")
                .when().post()

                .then().statusCode(200);
        System.out.println("Response body ++++"+ResponseBody.);
*/

//ResponseBody body = response.getBody();
        // System.out.println(body.asString());

    }

    @Test
    public void getWallet() {
        RestAssured.given().baseUri("http://46.101.196.83/api")
                .header("Authorization", "bearer 7346035a-cbe7-4c89-926b-236bcca1115a")
                .when().get("/users/me/wallet")
                .then().statusCode(200);
    }

    @Test
    public void findPetByStatus() {
        RestAssured.given()
                .baseUri("http://petstore.swagger.io")
                .basePath("/v2/pet/findByStatus")
                .header("Content-Type", "application/json")
                .queryParam("status", "available").when().get().then().statusCode(200);

    }

    @Test
    public void getWallet2() {
        RestAssured
                .given()
                .header("Authorization", "bearer 4c4ea7af-70b3-4603-8f7d-b80330ae1af7")
                .when()
                .get("http://46.101.196.83/api/users/me/wallet").then().statusCode(200);


    }

}

