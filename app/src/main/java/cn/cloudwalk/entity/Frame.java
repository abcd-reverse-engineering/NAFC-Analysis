package cn.cloudwalk.entity;

/* loaded from: classes.dex */
public class Frame {
    private byte[] alignData;
    private int mode;
    private float score;

    public byte[] getAlignData() {
        return this.alignData;
    }

    public int getMode() {
        return this.mode;
    }

    public float getScore() {
        return this.score;
    }

    public void setAlignData(byte[] bArr) {
        this.alignData = bArr;
    }

    public void setMode(int i2) {
        this.mode = i2;
    }

    public void setScore(float f2) {
        this.score = f2;
    }
}
