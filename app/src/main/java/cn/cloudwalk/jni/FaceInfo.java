package cn.cloudwalk.jni;

/* loaded from: classes.dex */
public class FaceInfo {
    public byte[] alignedData;
    public int alignedH;
    public int alignedW;
    public int attack;
    float blackframeglassProb;
    public float brightness;
    public float clarity;
    public int detected = 0;
    public float[] drawpointX;
    public float[] drawpointY;
    public int errcode;
    public int eyeAct;
    public int faceId;
    public int headPitch;
    public int headYaw;
    public int height;
    public float keyptScore;
    float leftEyeOpening;
    public float livenessConfidence;
    public int mouthAct;
    float mouthOpening;
    public int nChannels;
    public int nkeypt;
    public float occlusion;
    public int opType;
    public float pitch;
    public float[] pointX;
    public float[] pointY;
    public float proceduremask;
    float qualityPitch;
    float qualityRoll;
    public float qualityScore;
    float qualityYaw;
    public int rectheight;
    public int rectwidth;
    public int rectx;
    public int recty;
    public int reportImageChannel;
    public byte[] reportImageData;
    public int reportImageH;
    public int reportImageW;
    public long reportTimeStamp;
    public float[] reportpointX;
    public float[] reportpointY;
    float rightEyeOpening;
    public float roll;
    float skinScore;
    public byte[] srcImage;
    public int srcImageH;
    public int srcImageW;
    float sunglassProb;
    public float timeStamp;
    public int width;
    public int x;
    public int y;
    public float yaw;

    public String toString() {
        return "FaceInfo{detected=" + this.detected + ", faceId=" + this.faceId + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", keyptScore=" + this.keyptScore + ", alignedW=" + this.alignedW + ", alignedH=" + this.alignedH + ", nChannels=" + this.nChannels + ", qualityScore=" + this.qualityScore + ", clarity=" + this.clarity + ", brightness=" + this.brightness + ", qualityYaw=" + this.qualityYaw + ", qualityPitch=" + this.qualityPitch + ", qualityRoll=" + this.qualityRoll + ", skinScore=" + this.skinScore + ", mouthOpening=" + this.mouthOpening + ", leftEyeOpening=" + this.leftEyeOpening + ", rightEyeOpening=" + this.rightEyeOpening + ", blackframeglassProb=" + this.blackframeglassProb + ", sunglassProb=" + this.sunglassProb + ", proceduremask=" + this.proceduremask + ", occlusion=" + this.occlusion + ", errcode=" + this.errcode + ", headPitch=" + this.headPitch + ", headYaw=" + this.headYaw + ", mouthAct=" + this.mouthAct + ", eyeAct=" + this.eyeAct + ", attack=" + this.attack + ", timeStamp=" + this.timeStamp + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + ", rectx=" + this.rectx + ", recty=" + this.recty + ", rectwidth=" + this.rectwidth + ", rectheight=" + this.rectheight + ", nkeypt=" + this.nkeypt + ", opType=" + this.opType + ", reportImageW=" + this.reportImageW + ", reportImageH=" + this.reportImageH + ", reportImageChannel=" + this.reportImageChannel + ", reportTimeStamp=" + this.reportTimeStamp + ", srcImageW=" + this.srcImageW + ", srcImageH=" + this.srcImageH + '}';
    }
}
