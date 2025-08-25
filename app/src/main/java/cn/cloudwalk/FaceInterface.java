package cn.cloudwalk;

/* loaded from: classes.dex */
public interface FaceInterface {

    public interface CW_FACE_LIVENESS_ERRCODE extends FaceInterface {
        public static final int CW_FACE_LIVENESS_NO_INFO = 21000;
        public static final int CW_FACE_LIVENESS_OK = 0;
    }

    public interface CW_FaceDETCode extends FaceInterface {
        public static final int CW_FACE_ALIGN_ERR = 20015;
        public static final int CW_FACE_DETECT_MODEL_ERR = 20009;
        public static final int CW_FACE_DET_ERR = 20013;
        public static final int CW_FACE_EMPTY_FRAME_ERR = 20000;
        public static final int CW_FACE_KEYPT_ERR = 20014;
        public static final int CW_FACE_KEYPT_MODEL_ERR = 20010;
        public static final int CW_FACE_LIVENESS_ERR = 20017;
        public static final int CW_FACE_LIVENESS_MODEL_ERR = 20012;
        public static final int CW_FACE_METHOD_UNAVAILABLE = 20006;
        public static final int CW_FACE_MINMAX_ERR = 20004;
        public static final int CW_FACE_NO_FACE = 20002;
        public static final int CW_FACE_OK = 0;
        public static final int CW_FACE_OUTOF_RANGE_ERR = 20005;
        public static final int CW_FACE_QUALITY_ERR = 20016;
        public static final int CW_FACE_QUALITY_MODEL_ERR = 20011;
        public static final int CW_FACE_ROI_ERR = 20003;
        public static final int CW_FACE_UNAUTHORIZED_ERR = 20007;
        public static final int CW_FACE_UNINITIALIZED_ERR = 20008;
        public static final int CW_FACE_UNSUPPORT_FORMAT_ERR = 20001;
    }

    public interface CW_FaceSelectCode extends FaceInterface {
        public static final int CW_FACE_LIVENESS_SELECT_NONE = 21051;
        public static final int CW_FACE_LIVENESS_SELECT_OK = 0;
        public static final int CW_FACE_LIVENESS_SELECT_RUNNING = 21050;
        public static final int CW_FACE_LIVENESS_SELECT_TIMEOUT = 21052;
        public static final int CW_FACE_LIVENESS_SELECT_UNKNOWN = 21053;
    }

    public interface CW_LivenessAntiHackMethod extends FaceInterface {
        public static final int CW_LIVE_FRONT_HACK = 1;
        public static final int CW_LIVE_SERVER_HACK = 2;
    }

    public interface CW_LivenessCode extends FaceInterface {
        public static final int CW_FACE_INFO_ALGORITHM_FRONT = 20000;
        public static final int CW_FACE_INFO_ALGORITHM_OK = 1;
        public static final int CW_FACE_INFO_ALGORITHM_PEOPLECHANGED_ATTACK = -7;
        public static final int CW_FACE_INFO_ALGORITHM_PICTURE_ATTACK = -4;
        public static final int CW_FACE_INFO_BORDER_ATTACK = -5;
        public static final int CW_FACE_INFO_EYES_DEDUCTION = -3;
        public static final int CW_FACE_INFO_EYES_WIDE = 11;
        public static final int CW_FACE_INFO_FACECHANGE_ATTACK = -1;
        public static final int CW_FACE_INFO_FACE_SHIELD = 10;
        public static final int CW_FACE_INFO_GLASS = 15;
        public static final int CW_FACE_INFO_MASK = 16;
        public static final int CW_FACE_INFO_MOUTH_DEDUCTION = -2;
        public static final int CW_FACE_INFO_MOUTH_WIDE = 12;
        public static final int CW_FACE_INFO_NOT_CENTER = 8;
        public static final int CW_FACE_INFO_NOT_FRONTAL = 4;
        public static final int CW_FACE_INFO_NOT_STABLE = 5;
        public static final int CW_FACE_INFO_NO_FACE = 9;
        public static final int CW_FACE_INFO_PAPER_ATTACK = -6;
        public static final int CW_FACE_INFO_READY_EYES_CLOSE = 14;
        public static final int CW_FACE_INFO_READY_MUOTH_OPEN = 13;
        public static final int CW_FACE_INFO_TOO_BRIGHT = 7;
        public static final int CW_FACE_INFO_TOO_CLOSE = 3;
        public static final int CW_FACE_INFO_TOO_DARK = 6;
        public static final int CW_FACE_INFO_TOO_FAR = 2;
        public static final int CW_FACE_INFO_WAIT_NEXT_FRAME = 0;
        public static final int CW_FACE_LIVENESS_ATTACK_PICTURE = 704;
        public static final int CW_FACE_LIVENESS_AUTH_ERROR = 720;
        public static final int CW_FACE_LIVENESS_BLINK = 601;
        public static final int CW_FACE_LIVENESS_DEFAULT_ERROR = 722;
        public static final int CW_FACE_LIVENESS_FACEDEC_OK = 618;
        public static final int CW_FACE_LIVENESS_FRONT_ATTACK_FAIL = 75003902;
        public static final int CW_FACE_LIVENESS_HEADDOWN = 603;
        public static final int CW_FACE_LIVENESS_HEADLEFT = 604;
        public static final int CW_FACE_LIVENESS_HEADPITCH = 602;
        public static final int CW_FACE_LIVENESS_HEADRIGHT = 605;
        public static final int CW_FACE_LIVENESS_LACK_CAMERA_PERMISSION = 75003904;
        public static final int CW_FACE_LIVENESS_LACK_WRITE_EXTERNAL_STORAGE_PERMISSION = 75003905;
        public static final int CW_FACE_LIVENESS_LOCK_AND_TOBACK = 75003901;
        public static final int CW_FACE_LIVENESS_MODEL_ERROR = 75003801;
        public static final int CW_FACE_LIVENESS_MULTIPEOPLE = 701;
        public static final int CW_FACE_LIVENESS_NOPEOPLE = 700;
        public static final int CW_FACE_LIVENESS_NOT_SUPPORT_CPU_ARCH = 75003908;
        public static final int CW_FACE_LIVENESS_OPENMOUTH = 600;
        public static final int CW_FACE_LIVENESS_OPEN_CAMERA_FAIL = 75003906;
        public static final int CW_FACE_LIVENESS_OVERTIME = 703;
        public static final int CW_FACE_LIVENESS_PEOPLECHANGED = 702;
        public static final int CW_FACE_LIVENESS_SDK_INIT_TOO_LOW = 75003903;
        public static final int CW_FACE_LIVENESS_STORAGE_NOT_ENOUGH = 75003907;
    }

    public interface FaceDetType extends FaceInterface {
        public static final int CW_FACE_ALIGN = 8;
        public static final int CW_FACE_DET = 0;
        public static final int CW_FACE_KEYPT = 4;
        public static final int CW_FACE_LIVENESS = 4064;
        public static final int CW_FACE_LIVENESS_ATTACK = 2048;
        public static final int CW_FACE_LIVENESS_EYE = 1024;
        public static final int CW_FACE_LIVENESS_HEAD_DOWN = 64;
        public static final int CW_FACE_LIVENESS_HEAD_LEFT = 128;
        public static final int CW_FACE_LIVENESS_HEAD_RIGHT = 256;
        public static final int CW_FACE_LIVENESS_HEAD_UP = 32;
        public static final int CW_FACE_LIVENESS_MOUTH = 512;
        public static final int CW_FACE_QUALITY = 16;
        public static final int CW_FACE_TRACK = 2;
    }

    public interface ImageAngle extends FaceInterface {
        public static final int CW_IMG_ANGLE_0 = 0;
        public static final int CW_IMG_ANGLE_180 = 2;
        public static final int CW_IMG_ANGLE_270 = 3;
        public static final int CW_IMG_ANGLE_90 = 1;
    }

    public interface ImageForm extends FaceInterface {
        public static final int CW_IMG_BGR888 = 1;
        public static final int CW_IMG_BGRA8888 = 2;
        public static final int CW_IMG_GRAY8 = 0;
        public static final int CW_IMG_JPG = 6;
        public static final int CW_IMG_NV12 = 4;
        public static final int CW_IMG_NV21 = 5;
        public static final int CW_IMG_YUV420P = 3;
    }

    public interface ImageMirror extends FaceInterface {
        public static final int CW_IMG_MIRROR_HOR = 1;
        public static final int CW_IMG_MIRROR_HV = 3;
        public static final int CW_IMG_MIRROR_NONE = 0;
        public static final int CW_IMG_MIRROR_VER = 2;
    }

    public interface LevelType extends FaceInterface {
        public static final int LEVEL_EASY = 1;
        public static final int LEVEL_HARD = 3;
        public static final int LEVEL_STANDARD = 2;
    }

    public interface LivessFlag extends FaceInterface {
        public static final int LIVE_DONOTHING = 0;
        public static final int LIVE_EYE_BLINK = 8;
        public static final int LIVE_HEAD_DOWN = 64;
        public static final int LIVE_HEAD_LEFT = 2;
        public static final int LIVE_HEAD_RIGHT = 4;
        public static final int LIVE_HEAD_UP = 32;
        public static final int LIVE_MOUTH_OPEN = 16;
        public static final int LIVE_PREPARE = 1;
    }

    public interface LivessType extends FaceInterface {
        public static final int LIVESS_EYE = 1004;
        public static final int LIVESS_HEAD_LEFT = 1000;
        public static final int LIVESS_HEAD_RIGHT = 1001;
        public static final int LIVESS_MOUTH = 1005;
    }

    public interface ModelMode extends FaceInterface {
        public static final int CW_MODEL_FILE = 0;
        public static final int CW_MODEL_FILE_MEMORY = 2;
        public static final int CW_MODEL_MEMORY = 1;
    }
}
