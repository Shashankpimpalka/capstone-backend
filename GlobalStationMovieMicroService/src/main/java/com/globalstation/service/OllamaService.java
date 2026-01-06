package com.globalstation.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class OllamaService {

    private final WebClient webClient = WebClient.create("http://localhost:11434");

    public Flux<Map<String,Object>> askQuestion(String model, String prompt) {
        Map<String, Object> request = Map.of(
                "model", model,
                "prompt", prompt,
                "stream", false
        );

        return webClient.post()
                .uri("/api/generate")
                .bodyValue(request)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Map<String, Object>>() {
                })
                .doOnSubscribe(sub-> System.out.println("Sending request to Ollama API..." + request))
                .doOnNext(stringObjectMap -> System.out.println("Received response from Ollama API: " + stringObjectMap));
    }
}