package ru.usernamedrew.springauthorizationservicet1;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAuthorizationServiceT1Application {

    public static void main(String[] args) {
//        Dotenv dotenv = Dotenv.load();
//		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
//		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
//		System.setProperty("DB_URL", dotenv.get("DB_URL"));
//		System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
//        System.setProperty("DB_NAME", dotenv.get("DB_NAME"));

        SpringApplication.run(SpringAuthorizationServiceT1Application.class, args);
    }

}
