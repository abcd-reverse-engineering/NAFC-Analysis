package c.b.c.b0.b;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import anet.channel.util.HttpConstant;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.Contants;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huawei.agconnect.exception.AGCServerException;
import com.just.agentweb.ActionActivity;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.common.Constants;
import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.socialize.bean.HandlerRequestCode;
import com.vivo.push.BuildConfig;
import com.yalantis.ucrop.UCrop;
import com.youth.banner.BannerConfig;
import network.APICode;

/* compiled from: BitMatrixParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f2413b = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 156, 163, 162, 169, 168, 175, com.hicorenational.antifraud.a.f5936e, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 180, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, 141, HandlerRequestCode.TWITTER_REQUEST_AUTH_CODE, 147, 146, 153, 152, 159, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 165, 164, 171, 170, 177, 176, TinkerReport.KEY_APPLIED_LIB_EXTRACT, TinkerReport.KEY_APPLIED_DEX_EXTRACT, 189, PictureConfig.CHOOSE_REQUEST, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, 143, 142, 149, 148, 155, 154, 161, 160, 167, PictureConfig.PREVIEW_VIDEO_CODE, 173, 172, 179, 178, 185, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 191, 190, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, SubsamplingScaleImageView.ORIENTATION_270, 265, 264, CustomCameraView.BUTTON_STATE_BOTH, CustomCameraView.BUTTON_STATE_ONLY_RECORDER, TinkerReport.KEY_LOADED_EXCEPTION_DEX_CHECK, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 247, 246, 241, 240, util.c2.a.C0, 234, 229, 228, util.c2.a.z0, util.c2.a.y0, 217, 216, util.c2.a.v0, util.c2.a.u0, 205, 204, BaseQuickAdapter.T, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, TinkerReport.KEY_LOADED_EXCEPTION_RESOURCE, 249, 248, 243, 242, 237, 236, util.c2.a.B0, util.c2.a.A0, 225, 224, 219, 218, 213, 212, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, 257, 256, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 250, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, 214, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, TinkerReport.KEY_LOADED_PACKAGE_CHECK_DEX_META, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, TinkerReport.KEY_LOADED_PACKAGE_CHECK_PACKAGE_META_NOT_FOUND, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, TinkerReport.KEY_LOADED_MISSING_PATCH_FILE, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, FlowControl.STATUS_FLOW_CTRL_CUR, FlowControl.STATUS_FLOW_CTRL_ALL, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, HttpConstant.SC_REQUESTED_RANGE_NOT_SATISFIABLE, 423, FlowControl.STATUS_FLOW_CTRL_BRUSH, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, new int[]{AntiBrush.STATUS_BRUSH, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, Constants.PORT, 442, 449, 448, 836, 835}, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, APICode.CODE_EXPRIE, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, FrameMetricsAggregator.EVERY_DURATION, 510, 517, 516, 842, 841}, new int[]{489, BuildConfig.VERSION_CODE, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, InputDeviceCompat.SOURCE_DPAD, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, AGCServerException.SERVER_NOT_AVAILABLE, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, BaseQuickAdapter.S, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_BLINK, 600, 607, 606, 613, 612, 619, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, ActionActivity.REQUEST_CODE, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADDOWN, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADPITCH, UCrop.REQUEST_MULTI_CROP, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADLEFT, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, Contants.PREVIEW_W, 647, 646, 854, 853}, new int[]{727, 726, 721, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR, 715, 714, 709, 708, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_OVERTIME, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_PEOPLECHANGED, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_DEFAULT_ERROR, 717, 716, 711, 710, 705, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_ATTACK_PICTURE, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_MULTIPEOPLE, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_NOPEOPLE, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, HandlerRequestCode.SINA_SHARE_REQUEST_CODE, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, BannerConfig.DURATION, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};

    /* renamed from: a, reason: collision with root package name */
    private final c.b.c.z.b f2414a;

    a(c.b.c.z.b bVar) {
        this.f2414a = bVar;
    }

    byte[] a() {
        byte[] bArr = new byte[144];
        int iD = this.f2414a.d();
        int iG = this.f2414a.g();
        for (int i2 = 0; i2 < iD; i2++) {
            int[] iArr = f2413b[i2];
            for (int i3 = 0; i3 < iG; i3++) {
                int i4 = iArr[i3];
                if (i4 >= 0 && this.f2414a.b(i3, i2)) {
                    int i5 = i4 / 6;
                    bArr[i5] = (byte) (((byte) (1 << (5 - (i4 % 6)))) | bArr[i5]);
                }
            }
        }
        return bArr;
    }
}
