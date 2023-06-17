package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssertion {
    /*
       https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Response’un,
            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
     */
    @Test
    public void put01(){
        //1-end point ve requestbody hazirla
        String url=" https://jsonplaceholder.typicode.com/posts/70";
        JSONObject reqBody=new JSONObject();
        //put:update islemi yapar yani zaten id si 70 olan var sadece degisiklik yapıyoruz
        reqBody.put("title","Ahmet").put("body","Merhaba").put("userId",10).put("id",70);
        //2_expected daha hazirla
        //3_response u kayder
        /*
        eger sorgumuzda bir request body gönderiyorsak,content type ını yazıyoruz.Gonderdigimiz datanin formatini
        belirtmek zorundayız.Bunu da hemen given()methodundan sonra pre condition olarak belirtebiliriz.
        given ve when gherkin dilinde aynı seviyede ama pre condit devreye giriyor bazen.
        requestbody mi body nin icine yazarken java onu anlasın diye tostring e cevirmem gerekiyor.

         */
        Response response=given()
                .contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                put(url);
        response.prettyPrint();
        //4_assertion
        response.
                then().
                assertThat()
                .statusCode(200).
                contentType("application/json; charset=utf-8")
                .header("Server","cloudflare").statusLine("HTTP/1.1 200 OK");



    }
}
