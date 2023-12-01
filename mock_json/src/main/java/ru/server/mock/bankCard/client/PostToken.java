package ru.server.mock.bankCard.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class PostToken {
    static final String URL_CREATE_EMPLOYEE = "http://localhost:7777/api/v1/gettoken";

    public static String postToken(String number) {

   //     String number = "123456789";
        Card numberCard = new Card("GetToken");
	    numberCard.setCard(number + number);
		//System.out.println("name = " + numberCard);
        HttpHeaders headers = new HttpHeaders();
    //headers.add("Accept",String.valueOf(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		//System.out.println("header = " + headers);
        RestTemplate restTemplate = new RestTemplate();
		//System.out.println("restTemplate = " + restTemplate);
    // Data attached to the request.
        HttpEntity<Card> requestBody = new HttpEntity<>(numberCard, headers);
		//System.out.println("requestBody = " + requestBody);
    // Send request with POST method.
        String response = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, String.class);
		//System.out.println("RESPONSE = " + response);

        return numberCard.getCard();
    }

}
