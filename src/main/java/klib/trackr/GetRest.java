package klib.trackr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetRest {

	private static final Logger log = LoggerFactory.getLogger(GetRest.class);
	private static String start = "48.9621219,9.0710486";
	private static String end = "48.7389943,9.1017945";

	public static void main(String args[]) {
		SpringApplication.run(GetRest.class);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Response response = restTemplate.getForObject(
					"https://route.api.here.com/routing/7.2/calculateroute.json?app_id=xjipTEag66SG6fNwgEQm&app_code=0eiHle7fs2IZsXChP2sWKQ&waypoint0=geo!"
							+ start + "&waypoint1=geo!" + end + "&mode=fastest;car;traffic:disabled",
					Response.class);
			response.getResponse().getRoute().get(0).getLeg().get(0).getManeuver().forEach(u -> log.info(u.toString()));
		};
	}
}