package cn.cloudwalk.jni;

/* loaded from: classes.dex */
public class FaceParam {
    public int attack_op;
    public float border_thres;
    public float card_thres;
    public float clarity_thres;
    public float flow_thres;
    public float hor_margin;
    public int liveness_quality_op;
    public boolean mask;
    public float mask3d_thres;
    public float mask_attack_thres;
    public float mask_thres;
    public int maxFaceNumPerImg;
    public float max_brightness;
    public float max_face;
    public float min_brightness;
    public float min_face;
    public float occ_thres;
    public boolean occlusion;
    public float paper_thres;
    public int perfmonLevel;
    public float pitch_thres;
    public int quality_detection_quality_op;
    public int roiHeight;
    public int roiWidth;
    public int roiX;
    public int roiY;
    public float roll_thres;
    public int spooflevel;
    public boolean stable;
    public boolean sunglass;
    public float texture3d_thres;
    public float texture_thres;
    public float ver_margin;
    public float yaw_thres;
    public boolean zero_action;

    public String toString() {
        return "FaceParam{roiX=" + this.roiX + ", roiY=" + this.roiY + ", roiWidth=" + this.roiWidth + ", roiHeight=" + this.roiHeight + ", maxFaceNumPerImg=" + this.maxFaceNumPerImg + ", perfmonLevel=" + this.perfmonLevel + ", liveness_quality_op=" + this.liveness_quality_op + ", quality_detection_quality_op=" + this.quality_detection_quality_op + ", attackOp=" + this.attack_op + ", zero_action=" + this.zero_action + ", spooflevel=" + this.spooflevel + ", min_brightness=" + this.min_brightness + ", max_brightness=" + this.max_brightness + ", min_face=" + this.min_face + ", max_face=" + this.max_face + ", hor_margin=" + this.hor_margin + ", ver_margin=" + this.ver_margin + ", yaw_thres=" + this.yaw_thres + ", pitch_thres=" + this.pitch_thres + ", roll_thres=" + this.roll_thres + ", occlusion=" + this.occlusion + ", stable=" + this.stable + ", mask=" + this.mask + ", sunglass=" + this.sunglass + ", flow_thres=" + this.flow_thres + ", occ_thres=" + this.occ_thres + ", clarity_thres=" + this.clarity_thres + ", mask_thres=" + this.mask_thres + ", border_thres=" + this.border_thres + ", mask_attack_thres=" + this.mask_attack_thres + ", texture_thres=" + this.texture_thres + ", texture3d_thres=" + this.texture3d_thres + ", paper_thres=" + this.paper_thres + ", mask3d_thres=" + this.mask3d_thres + ", card_thres=" + this.card_thres + '}';
    }
}
