package cn.cloudwalk.jni;

/* loaded from: classes.dex */
public class FaceLivingImg {
    public int faceId = -1;
    public int faceRectHeight;
    public int faceRectWidth;
    public int faceRectX;
    public int faceRectY;
    public float keyptScore;
    public int livingImageChannel;
    public byte[] livingImageData;
    public int livingImageH;
    public int livingImageW;
    public long livingTimeStamp;
    public int nkeypt;
    public float pitch;
    public float[] pointX;
    public float[] pointY;
    public float roll;
    public float yaw;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FaceLivingImg{keyptScore=");
        sb.append(this.keyptScore);
        sb.append(", nkeypt=");
        sb.append(this.nkeypt);
        sb.append(", pointX=");
        float[] fArr = this.pointX;
        sb.append(fArr == null ? "" : Integer.valueOf(fArr.length));
        sb.append(", pointY=");
        float[] fArr2 = this.pointY;
        sb.append(fArr2 == null ? "" : Integer.valueOf(fArr2.length));
        sb.append(", pitch=");
        sb.append(this.pitch);
        sb.append(", yaw=");
        sb.append(this.yaw);
        sb.append(", roll=");
        sb.append(this.roll);
        sb.append(", livingImageW=");
        sb.append(this.livingImageW);
        sb.append(", livingImageH=");
        sb.append(this.livingImageH);
        sb.append(", livingImageChannel=");
        sb.append(this.livingImageChannel);
        sb.append(", livingImageData=");
        byte[] bArr = this.livingImageData;
        sb.append(bArr != null ? Integer.valueOf(bArr.length) : "");
        sb.append(", livingTimeStamp=");
        sb.append(this.livingTimeStamp);
        sb.append(", faceId=");
        sb.append(this.faceId);
        sb.append(", faceRectX=");
        sb.append(this.faceRectX);
        sb.append(", faceRectY=");
        sb.append(this.faceRectY);
        sb.append(", faceRectWidth=");
        sb.append(this.faceRectWidth);
        sb.append(", faceRectHeight=");
        sb.append(this.faceRectHeight);
        sb.append('}');
        return sb.toString();
    }
}
