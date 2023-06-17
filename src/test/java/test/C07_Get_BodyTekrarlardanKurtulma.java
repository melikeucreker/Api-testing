package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_BodyTekrarlardanKurtulma {
    /*

                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,

                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki
                    "firstname“in,"susan",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 613,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
     */
    @Test
    public void get01() {


        //1_end point ve request body hazırla
        String url = "https://restful-booker.herokuapp.com/booking/10 ";
        //2_expected data hazirla

        //3_response ı kaydet
        Response response = given().when().get(url);

        //4_assertion

        /*response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname", Matchers.equalTo("Mark"))
                .body("lastaname",Matchers.equalTo(null))
                .body("totalprice",Matchers.equalTo(888))
                .body("depositpaid",Matchers.equalTo(false)).
                body("additionalneeds",Matchers.equalTo("null"));
                /*
         */
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Susan"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(613),
                        "depositpaid", equalTo(false),
                        "additionalneeds", equalTo("Breakfast"));


    }
}