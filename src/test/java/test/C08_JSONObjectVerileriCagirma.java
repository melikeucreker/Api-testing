package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
    /*
     {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */
    @Test
    public void jsonPath01() {
        JSONObject cepTel=new JSONObject();

        cepTel.put("type","iphone");
        cepTel.put( "number","0123-4567-8888");
        JSONObject evTel=new JSONObject();
        evTel.put( "streetAddress", "naist street");
        evTel.put( "number", "0123-4567-8910");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,cepTel); //bu ilk sıradakiydi
        phoneNumbers.put(1,evTel); // bu da ikinci sıradakiydi

        JSONObject adress=new JSONObject();
        adress.put("streetAddress", "naist street").put("city", "Nara").put("postalCode","630-0192");
        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put( "firstName", "John").put("lastName", "doe").put( "age", 26).put("address",adress)
                .put("phoneNumbers",phoneNumbers);
        System.out.println(kisiBilgisi);




    }
}
