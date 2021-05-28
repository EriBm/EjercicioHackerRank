package com.example.EjercicioHackerRank.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/hack")
public class HackController {
	
	private final WebClient webClient;

	public HackController(WebClient webClient) {
		super();
		this.webClient = webClient;
	}
	
	
	
	@GetMapping
	public Flux<String> getResultado(@RequestParam("author") String author, @RequestParam("page") Integer page) {
		
		String url = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" +  page;
		
		return webClient
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono( new ParameterizedTypeReference<JSONResponse>() {})
				.flatMapIterable(j -> j.getData())
				.filter(d -> d.getTitle() != null || d.getStoryTitle() != null)
				.map(d -> {
					if (d.getTitle() != null)
						return d.getTitle();
					else
						return d.getStoryTitle();
				});
	}

}
