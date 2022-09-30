package com.example.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootAppApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(SpringBootAppApplication.class, args);


		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://lingvanex-translate.p.rapidapi.com/translate"))
				.header("content-type", "application/json")
				.header("X-RapidAPI-Key", "7febc69911msh4d0fee8657396ffp16c5a3jsn2397f8a7f417")
				.header("X-RapidAPI-Host", "lingvanex-translate.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\n  \"from\": \"en_GB\",\n  \"to\": \"de_DE\",\n  \"data\": \"Hello World\",\n  \"platform\": \"api\"\n}"))
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());

	}

}
