package com.nullspace.service.service;

import com.nullspace.dto.YoutubeApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class YoutubeClient {

    private final RestClient restClient;
    private final String apiKey;

    public YoutubeClient(@Value("${youtube.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.restClient = RestClient.builder()
                .baseUrl("https://www.googleapis.com/youtube/v3")
                .build();
    }

    public YoutubeApiResponse getVideosByChannel(String channelId) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("key", apiKey)
                        .queryParam("channelId", channelId)
                        .queryParam("part", "snippet")
                        .queryParam("order", "date")
                        .queryParam("maxResults", 10)
                        .build())
                .retrieve()
                .body(YoutubeApiResponse.class);
    }
}