package com.nullspace.service.service;

import com.nullspace.domain.video.Video;
import com.nullspace.domain.video.VideoRepository;
import com.nullspace.dto.YoutubeApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final YoutubeClient youtubeClient;
    private final VideoRepository videoRepository;

    @Transactional
    public void fetchAndSaveVideos(String channelId) {
        // 1. 유튜브에서 데이터 가져오기
        YoutubeApiResponse response = youtubeClient.getVideosByChannel(channelId);

        if (response.items() == null) return;

        // 2. 응답 데이터(Item)를 하나씩 우리 엔티티로 변환하여 저장
        for (YoutubeApiResponse.Item item : response.items()) {
            // 썸네일 URL null 방어 코드
            String thumbnailUrl = null;
            if(item.snippet().thumbnails() != null && item.snippet().thumbnails().defaultInfo() != null) {
                thumbnailUrl = item.snippet().thumbnails().defaultInfo().url();
            }

            Video video = Video.builder()
                    .videoId(item.id().videoId())
                    .title(item.snippet().title())
                    .description(item.snippet().description())
                    .thumbnailUrl(thumbnailUrl)
                    .build();
            
            videoRepository.save(video);
        }
    }
}