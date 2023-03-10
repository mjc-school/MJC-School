package com.shankhadeepghoshal.httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import lombok.SneakyThrows;

/**
 * @author <a href="mailto:shankhadeepghoshal1996@gmail.com">Shankhadeep Ghoshal</a>
 **/

public class RestService {

		private final HttpClient httpClient = HttpClient.newBuilder().build();

		@SneakyThrows
		public void makeGetRequest() {
				final var httpRequest =
						HttpRequest.newBuilder(URI.create("https://postman-echo.com/get")).GET().build();
				final var response = httpClient.send(httpRequest, BodyHandlers.ofString()).body();
				System.out.println(response);
		}

		@SneakyThrows
		public void makePostRequest() {
				record Data(int x, int y) {}
				final var payload = new ObjectMapper().writeValueAsString(new Data(1, 2));

				final var bodyPublisher =
						HttpRequest.BodyPublishers.ofString(payload);
				final var httpRequest =
						HttpRequest.newBuilder(URI.create("https://postman-echo.com/post"))
								.timeout(Duration.ofMillis(100L))
								.POST(bodyPublisher)
								.headers("Content-Type", "application/json;charset=UTF-8")
								.build();
				final var response = httpClient.send(httpRequest, BodyHandlers.ofString()).body();
				System.out.println(response);
		}
}
