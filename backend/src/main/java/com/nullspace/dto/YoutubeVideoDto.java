package com.nullspace.dto;

import java.time.LocalDateTime;

public record YoutubeVideoDto(
    String videoId,
    String title,
    String description,
    String thumbnailUrl,
    LocalDateTime publishedAt
) {}