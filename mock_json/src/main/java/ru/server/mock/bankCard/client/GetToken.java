package ru.server.mock.bankCard.client;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

public class GetToken {


    public static String getToken(String numberCard) {

         final String URL_EMPLOYEES = "http://localhost:7777/api/v1/gettoken?number=" + numberCard;

        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        //	headers.set("my_other_key", "my_other_value");

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Send request with GET method, and Headers.
        ResponseEntity<String> response = restTemplate.exchange(URL_EMPLOYEES, //
                HttpMethod.GET, entity, String.class);

        String result = response.getBody();

       // System.out.println("result - " + result);




        return numberCard + numberCard;
    }
}
