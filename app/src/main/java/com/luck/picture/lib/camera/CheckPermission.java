package com.luck.picture.lib.camera;

import android.media.AudioRecord;

/* loaded from: classes.dex */
public class CheckPermission {
    public static final int STATE_NO_PERMISSION = -2;
    public static final int STATE_RECORDING = -1;
    public static final int STATE_SUCCESS = 1;

    public static int getRecordState() throws IllegalStateException {
        int minBufferSize = AudioRecord.getMinBufferSize(44100, 16, 2);
        AudioRecord audioRecord = new AudioRecord(0, 44100, 16, 2, minBufferSize * 100);
        short[] sArr = new short[minBufferSize];
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                audioRecord.stop();
                audioRecord.release();
                return -1;
            }
            if (audioRecord.read(sArr, 0, sArr.length) <= 0) {
                audioRecord.stop();
                audioRecord.release();
                return -2;
            }
            audioRecord.stop();
            audioRecord.release();
            return 1;
        } catch (Exception unused) {
            audioRecord.release();
            return -2;
        }
    }
}
