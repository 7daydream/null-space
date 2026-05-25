@Entity
@Getter
@NoArgsConstructor
public class Channel {
    @Id
    private String channelId; // PK

    private String channelName;
    private boolean isWhitelisted;

    // 채널 하나에 여러 영상이 연결됨 (1:N)
    // CascadeType.ALL + orphanRemoval = true 설정
    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();

    public Channel(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.isWhitelisted = false; // 기본값
    }
}