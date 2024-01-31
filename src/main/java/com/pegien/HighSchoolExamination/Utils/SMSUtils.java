package com.pegien.HighSchoolExamination.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.ClientParamsStack;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.springframework.data.web.JsonPath;

public class SMSUtils {
    public static void sendMesage(String message, String phone) {

        System.out.println("sending message : "+message+" to "+phone);
    }

    private static String apiKey="117d6d6bb8e32867a6c0f69a49607ff8";


    private static String partnerID="9541";


    public static String getBalance()
    {
        String url = "https://sms.textsms.co.ke/api/services/getbalance/";

        // Create an HttpClient instance
        HttpClient httpClient = HttpClients.createDefault();

        // Create an HttpPost request
        HttpPost httpPost = new HttpPost(url);

        try{


            httpPost.setHeader("Content-Type", "application/json");

            String requestBody = "{ \"apikey\": \""+apiKey+"\", \"partnerID\": \""+partnerID+"\" }";
            StringEntity requestEntity = new StringEntity(requestBody);
            httpPost.setEntity(requestEntity);

//            httpPost.setParams();


            HttpResponse response = httpClient.execute(httpPost);

//            System.out.println();
//            return response.toString();
            String responseString=new String(response.getEntity().getContent().readAllBytes());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseString);

            // Assuming JSON structure like: { "credit": "100" }
            return jsonNode.get("credit").asText();

        }catch (Exception es)
        {

            es.printStackTrace();
            return es.toString();
        }
    }





    public static Boolean sendSms(String phone,String message)
    {
        String url = "https://sms.textsms.co.ke/api/services/sendsms/";

        // Create an HttpClient instance
        HttpClient httpClient = HttpClients.createDefault();

        // Create an HttpPost request
        HttpPost httpPost = new HttpPost(url);

        try{


            httpPost.setHeader("Content-Type", "application/json");

            String requestBody = "{ \"apikey\": \""+apiKey+"\"" +
                    ", \"partnerID\": \""+partnerID+"\" " +
                    ",\"shortcode\": \"TextSMS\"," +
                    "\"mobile\": \"" +ConvertionUtils.formatPhone(phone)+"\","+
                    "\"message\" : \"" +message+"\""+
                            "}";
            StringEntity requestEntity = new StringEntity(requestBody);
            httpPost.setEntity(requestEntity);

//            httpPost.setParams();


            HttpResponse response = httpClient.execute(httpPost);

//            System.out.println();
//            return response.toString();
            String responseString=new String(response.getEntity().getContent().readAllBytes());
//            System.out.println(responseString);
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode jsonNode = objectMapper.readTree(responseString);

            // Assuming JSON structure like: { "credit": "100" }
//            return jsonNode.get("credit").asText();
            if(responseString.contains("\"response-code\":200"))
                return true;
            else
                return false;

        }catch (Exception es)
        {

            es.printStackTrace();
//            return es.toString();
            return false;
        }
//        return false;
    }
}
