package app.module.component;

import app.module.TimeServer;
import app.module.IObserver;
import app.module.Subject;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;


import java.io.File;


public class Signal extends MediaView implements IObserver {

    int count;
    int start;
    String file;
    Media sound;
    MediaPlayer mediaPlayer;
    Boolean state;
    Subject subject;


    public Signal() {
        subject = new TimeServer();
        this.count = 0;
        this.state = false;
        this.start = subject.getState();
        this.file = "src/main/resources/vivo.mp4";
        this.sound = new Media(new File(file).toURI().toString());
        this.mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(Duration.ZERO);
        });
        setMediaPlayer(mediaPlayer);
        setVisible(false);
    }


    public void onComp(int count) {
        this.start = subject.getState();
        this.count = count;
        this.state = true;
    }


    public void offComp() {
        this.state = false;
        mediaPlayer.stop();
        setVisible(false);
    }

    public void update(Subject st) {
        if (state) {
            if (st.getState() >= start + count) {
                setVisible(true);
                mediaPlayer.setAutoPlay(true);
                mediaPlayer.play();
            }
        }
    }
}