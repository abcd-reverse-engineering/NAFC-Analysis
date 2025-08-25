package manager;

import a.a.u.a;
import android.media.MediaPlayer;
import java.io.IOException;
import util.n1;

/* loaded from: classes2.dex */
public class MediaPlayerManager {
    static MediaPlayer mediaPlayer;

    public static MediaPlayerManager getInstance() {
        MediaPlayerManager mediaPlayerManager = new MediaPlayerManager();
        getMediaPlayer();
        return mediaPlayerManager;
    }

    public static MediaPlayer getMediaPlayer() {
        if (mediaPlayer == null) {
            synchronized (MediaPlayerManager.class) {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }
            }
        }
        return mediaPlayer;
    }

    public void pauseMedia() throws IllegalStateException {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    public void playMedia(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        try {
            stopMedia();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(str);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: manager.MediaPlayerManager.1
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer2) throws IllegalStateException {
                    n1.c(a.n, "onPrepared        开始播放          ");
                    MediaPlayerManager.mediaPlayer.start();
                }
            });
            mediaPlayer.prepareAsync();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void releaseMedia() throws IllegalStateException {
        MediaPlayer mediaPlayer2 = mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
            mediaPlayer.release();
        }
    }

    public void resumeMedia() throws IllegalStateException {
        if (mediaPlayer.isPlaying()) {
            return;
        }
        mediaPlayer.start();
    }

    public void stopMedia() throws IllegalStateException {
        MediaPlayer mediaPlayer2 = mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
        }
    }
}
