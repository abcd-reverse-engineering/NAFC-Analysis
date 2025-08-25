package bean;

import network.BaseBean;

/* loaded from: classes.dex */
public class CasePicBean extends BaseBean {
    private String compressPath;
    private boolean compressed;
    private String cutPath;
    private long duration;
    private int height;
    private boolean isChecked;
    private boolean isCut;
    private int mimeType;
    private int num;
    private String path;
    private String pictureType;
    public int position;
    private int width;

    public String getCompressPath() {
        return this.compressPath;
    }

    public String getCutPath() {
        return this.cutPath;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getMimeType() {
        return this.mimeType;
    }

    public int getNum() {
        return this.num;
    }

    public String getPath() {
        return this.path;
    }

    public String getPictureType() {
        return this.pictureType;
    }

    public int getPosition() {
        return this.position;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isCompressed() {
        return this.compressed;
    }

    public boolean isCut() {
        return this.isCut;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public void setCompressPath(String str) {
        this.compressPath = str;
    }

    public void setCompressed(boolean z) {
        this.compressed = z;
    }

    public void setCut(boolean z) {
        this.isCut = z;
    }

    public void setCutPath(String str) {
        this.cutPath = str;
    }

    public void setDuration(long j2) {
        this.duration = j2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setMimeType(int i2) {
        this.mimeType = i2;
    }

    public void setNum(int i2) {
        this.num = i2;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPictureType(String str) {
        this.pictureType = str;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }
}
