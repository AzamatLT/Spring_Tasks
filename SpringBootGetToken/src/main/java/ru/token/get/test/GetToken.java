package ru.token.get.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Сервис нужен отправки токена в ответ на полученный номер карты от заглушки - mock_json SpringMockServer_Json_Actuator_Log
@SpringBootApplication
public class GetToken {

	public static void main(String[] args) {
		SpringApplication.run(GetToken.class, args);
	}

}
