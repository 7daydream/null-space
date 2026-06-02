package com.nullspace;

import com.nullspace.service.service.VideoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NullSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NullSpaceApplication.class, args);
	}

	// 애플리케이션 시작 시 데이터 테스트
    @Bean
    public CommandLineRunner run(VideoService videoService) {
        return args -> {
            String channelId = "UCvPPXcl5dJiBgRKGTA8inPA"; // Code Fiction 채널 ID
            videoService.fetchAndSaveVideos(channelId);
            System.out.println("✅ 데이터 저장 완료!");
        };
    }
}
