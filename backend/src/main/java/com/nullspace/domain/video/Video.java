package com.nullspace.domain.video;

import com.nullspace.domain.channel.Channel;
import jakarta.persistence.*; // @Entity, @Id, @Column, @ManyToOne 등 포함
import lombok.*; // @Getter, @Builder, @NoArgsConstructor 등 포함
import java.time.LocalDateTime; // LocalDateTime 포함

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Video {
    @Id
    private String videoId; // PK

    private String title;
    private String thumbnailUrl;
    private Long viewCount;
    private Long likeCount;
    private LocalDateTime publishedAt;
    
    @Column(columnDefinition = "TEXT") // 설명란은 글자수가 많으므로 TEXT 타입 명시
    private String description;

    // 여러 영상이 하나의 채널에 속함 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_id")
    private Channel channel;
}