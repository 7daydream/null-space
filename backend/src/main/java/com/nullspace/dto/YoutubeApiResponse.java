package com.nullspace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

// JSON 데이터에서 필요한 계층만 골라서 매핑합니다.
@JsonIgnoreProperties(ignoreUnknown = true)
public record YoutubeApiResponse(List<Item> items) {

    // 1. ChannelId 정보를 담을 record 추가
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Id(String videoId) {}

    public record Item(Id id, Snippet snippet) {}
    
    public record Snippet(
        String title,
        String description,
        Thumbnails thumbnails,
        String publishedAt
    ) {}

    public record Thumbnails(
        @com.fasterxml.jackson.annotation.JsonProperty("default") Default defaultInfo
    ) {}
    
    public record Default(String url) {}
}