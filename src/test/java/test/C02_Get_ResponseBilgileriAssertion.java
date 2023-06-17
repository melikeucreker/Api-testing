package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {
    /*

        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
        gonderdigimizde donen Response’un,

        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK

        oldugunu test edin.
     */
    @Test
    public void get01() {
        //1_End point ve request body hazirla
        String url = " https://restful-booker.herokuapp.com/booking/10";
        //2_expected data hazirla

        //3_request gönderip dönen response'ı kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();
        response
                .then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("server", "Cowboy").
                statusLine("HTTP/1.1 200 OK");

        //4_Assertion islemleri

    }

}
