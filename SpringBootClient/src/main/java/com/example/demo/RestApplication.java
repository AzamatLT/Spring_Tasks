package com.example.demo;


import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


//@SpringBootApplication

public class RestApplication {

	static final String URL_CREATE_EMPLOYEE = "http://localhost:7777/api/v1/gettoken";

	public static void main(String[] args) {


// POST - работает

	String number = "123456789";
	Card numberCard = new Card("GetToken");
	numberCard.setCard(number);
		System.out.println("name = " + numberCard);
		HttpHeaders headers = new HttpHeaders();
		//headers.add("Accept",String.valueOf(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		System.out.println("header = " + headers);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("restTemplate = " + restTemplate);
		// Data attached to the request.
		HttpEntity<Card> requestBody = new HttpEntity<>(numberCard, headers);
		System.out.println("requestBody = " + requestBody);
		// Send request with POST method.
		String response = restTemplate.postForObject(URL_CREATE_EMPLOYEE, requestBody, String.class);
		System.out.println("RESPONSE = " + response);


	}

//GET работает
/*
		static final String URL_EMPLOYEES = "http://localhost:7777/api/v1/gettoken?number=" + "5555555";

		public static void main (String[]args){

			// HttpHeaders
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

			System.out.println(result);
		}
*/
}
