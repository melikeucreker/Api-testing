package test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;




public class C05_Get_ResponseBodyTesti {
    /*
      https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Response’in
             status code'unun 200,
             ve content type'inin ContentType.JSON,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
             oldugunu test edin.
     */
    @Test
    public void get01(){
        //1_endpoint ve request body hazirla
        String url="https://jsonplaceholder.typicode.com/posts/44 ";
        //2-expected data hazırla
        //3_Response'ı kaydet
       Response response=given().when().get(url);
        //4-assertion
        /*
        body methodu matchers bekliyor.
         */
        response.then().assertThat().statusCode(200).contentType( ContentType.JSON).body(" userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }

}
