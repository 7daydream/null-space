@Entity
@Getter
@NoArgsConstructor
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

    // 생성자도 필드에 맞춰 업데이트
    public Video(String videoId, String title, String thumbnailUrl, Long viewCount, 
                 Long likeCount, LocalDateTime publishedAt, String description, Channel channel) {
        this.videoId = videoId;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.publishedAt = publishedAt;
        this.description = description;
        this.channel = channel;
    }
}