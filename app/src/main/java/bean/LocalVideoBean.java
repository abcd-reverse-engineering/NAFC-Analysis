package bean;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class LocalVideoBean {
    public static final int TYPEMP3 = 1;
    public static final int TYPEMP4 = 2;
    private Bitmap bitmap;
    private long duration;
    private long lastTime;
    private int mimeType;
    private String name;
    private String path;
    private long size;
    private String thumbPath;

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getLastTime() {
        return this.lastTime;
    }

    public int getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setLastTime(long j2) {
        this.lastTime = j2;
    }

    public void setMimeType(int i2) {
        this.mimeType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j2) {
        this.size = j2;
    }

    public void setThumbPath(String str) {
        this.thumbPath = str;
    }
}
