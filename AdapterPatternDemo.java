
interface MediaPlayer {
    void play(String fileName);
}

class AudioPlayer implements MediaPlayer {
    
    public void play(String fileName) {
        if(fileName.endsWith(".mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid file format for AudioPlayer");
        }
    }
}

class MP4Player {
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Step 3: Create VLCPlayer class to play VLC files
class VLCPlayer {
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

class MP4Adapter implements MediaPlayer {
    private MP4Player mp4Player;

    public MP4Adapter() {
        mp4Player = new MP4Player();
    }

    public void play(String fileName) {
        mp4Player.playMP4(fileName);
    }
}

// Step 4: Create VLCAdapter to make VLCPlayer compatible with MediaPlayer
class VLCAdapter implements MediaPlayer {
    private VLCPlayer vlcPlayer;

    public VLCAdapter() {
        vlcPlayer = new VLCPlayer();
    }

    public void play(String fileName) {
        vlcPlayer.playVLC(fileName);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
       
        audioPlayer.play("song.mp3");

        MediaPlayer mp4Player = new MP4Adapter();
        mp4Player.play("video.mp4");

        MediaPlayer vlcPlayer = new VLCAdapter();
        vlcPlayer.play("movie.vlc");
    }
}
