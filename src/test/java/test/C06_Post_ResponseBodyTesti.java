package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTesti {
    /*
    https://jsonplaceholder.typicode.com/posts
         url’ine asagidaki body ile bir POST request gonderdigimizde

        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10,
        }

        donen Response’un,

        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
     */
    @Test
    public void post01(){
        //1_end point ve request body hazırla
        String url=" https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody=new JSONObject();
        requestBody.put("title","API").put( "body","API").put("userId",10);
        System.out.println(requestBody);

        //2 expected data

        //3 response
        Response response=given().contentType(ContentType.JSON).when().body(requestBody.toString()).post(url);
        response.prettyPrint();

        /*
        yani önce api yi çalıştırıyoruz apimiz bize bir response dönüyor onu kaydediyoruz sonra assertionleri yapıyoruz
        bir de givenden sonra contenttype ı su sebeple yazıyoruz gönderdigim seyin iceriginin yani dilinin json oldugunu
         belirtiyorum
         responseın dogrulunu kontrol etmek icin assertionlar yapıyoruz
         */

        //4 assertion
        response.then().assertThat().statusCode(201).contentType("application/json")
                .body("title", Matchers.equalTo("API")).body("userId",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));


    }
}
