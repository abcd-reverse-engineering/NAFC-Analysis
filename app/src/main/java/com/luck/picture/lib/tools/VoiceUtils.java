package com.luck.picture.lib.tools;

import android.content.Context;
import android.media.SoundPool;

/* loaded from: classes.dex */
public class VoiceUtils {
    private static VoiceUtils instance;
    private SoundPool soundPool;

    public static VoiceUtils getInstance() {
        if (instance == null) {
            synchronized (VoiceUtils.class) {
                if (instance == null) {
                    instance = new VoiceUtils();
                }
            }
        }
        return instance;
    }

    private void initPool(Context context) {
        if (this.soundPool == null) {
            this.soundPool = new SoundPool(1, 4, 0);
        }
    }

    public void init(Context context) {
        initPool(context);
    }

    public void play() {
    }

    public void releaseSoundPool() {
        try {
            if (this.soundPool != null) {
                this.soundPool.release();
                this.soundPool = null;
            }
            instance = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
