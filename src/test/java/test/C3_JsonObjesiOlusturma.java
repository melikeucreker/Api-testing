package test;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {
    /*
     Asagidaki JSON Objesini olusturup konsolda yazdirin.

    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
     */
    @Test
    public void jsonObje01() {
        JSONObject ilkjsonObject = new JSONObject();
        ilkjsonObject.put("title", "Ahmet").put("body", "Merhaba").put("userId", 1);
        System.out.println("ILK Json Objemiz" + ilkjsonObject);


    }

    @Test
    public void jsonObje02() {
        /*

                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2018-01-01").put("checkout", "2019-01-01");
        JSONObject bookingJsonObject = new JSONObject();
        bookingJsonObject.put("firstname", "Jim").put("additionalneeds", "Breakfast").put("bookingDates", bookingDates)
                .put("totalprice", 111)
                .put("depositpaid", true).put("lastname", "Brown");
        System.out.println("Booking json object:" + bookingJsonObject);





    }

}
