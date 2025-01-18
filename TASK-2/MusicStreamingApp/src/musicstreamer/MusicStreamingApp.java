package musicstreamer;

// Common interface for music sources
interface MusicSource {
    void play();
}

// Adapter for Local Files
class LocalFileMusicSource implements MusicSource {
    private String filePath;

    public LocalFileMusicSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing music from local file: " + filePath);
    }
}

// Adapter for Online Streaming Service
class OnlineStreamingMusicSource implements MusicSource {
    private String url;

    public OnlineStreamingMusicSource(String url) {
        this.url = url;
    }

    @Override
    public void play() {
        System.out.println("Streaming music online from: " + url);
    }
}

// Adapter for Radio Station
class RadioStationMusicSource implements MusicSource {
    private String stationName;

    public RadioStationMusicSource(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void play() {
        System.out.println("Tuning into radio station: " + stationName);
    }
}

// Music Player Abstraction (Bridge Pattern)
abstract class MusicPlayer {
    protected MusicSource musicSource;

    public MusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void playMusic();
}

// Concrete Implementation of Music Player
class BasicMusicPlayer extends MusicPlayer {
    public BasicMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void playMusic() {
        System.out.println("Basic Music Player:");
        musicSource.play();
    }
}

// Decorator Pattern: Adding features to Music Player
abstract class MusicPlayerDecorator extends MusicPlayer {
    protected MusicPlayer musicPlayer;

    public MusicPlayerDecorator(MusicPlayer musicPlayer) {
        super(musicPlayer.musicSource);
        this.musicPlayer = musicPlayer;
    }

    @Override
    public void playMusic() {
        musicPlayer.playMusic();
    }
}

// Equalizer Feature
class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void playMusic() {
        super.playMusic();
        System.out.println("Equalizer settings applied.");
    }
}

// Volume Control Feature
class VolumeControlDecorator extends MusicPlayerDecorator {
    public VolumeControlDecorator(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void playMusic() {
        super.playMusic();
        System.out.println("Volume control enabled.");
    }
}

// Main Application
public class MusicStreamingApp {
    public static void main(String[] args) {
        // Local file music source
        MusicSource localFile = new LocalFileMusicSource("song.mp3");
        MusicPlayer basicPlayer = new BasicMusicPlayer(localFile);

        // Adding features
        MusicPlayer playerWithEqualizer = new EqualizerDecorator(basicPlayer);
        MusicPlayer playerWithAllFeatures = new VolumeControlDecorator(playerWithEqualizer);

        System.out.println("Playing local file with all features:");
        playerWithAllFeatures.playMusic();

        // Online streaming source
        MusicSource onlineStream = new OnlineStreamingMusicSource("http://example.com/stream");
        MusicPlayer onlinePlayer = new BasicMusicPlayer(onlineStream);

        System.out.println("\nPlaying online stream:");
        onlinePlayer.playMusic();

        // Radio station source
        MusicSource radioStation = new RadioStationMusicSource("RadioOne FM");
        MusicPlayer radioPlayer = new BasicMusicPlayer(radioStation);

        System.out.println("\nPlaying radio station:");
        radioPlayer.playMusic();
    }
}
