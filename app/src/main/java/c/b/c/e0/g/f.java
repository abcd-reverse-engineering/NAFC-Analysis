package c.b.c.e0.g;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import c.b.c.w;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.Contants;
import com.huawei.agconnect.exception.AGCServerException;
import com.just.agentweb.ActionActivity;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import com.taobao.accs.flowcontrol.FlowControl;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.push.BuildConfig;
import com.yalantis.ucrop.UCrop;
import com.youth.banner.BannerConfig;
import network.APICode;

/* compiled from: PDF417ErrorCorrection.java */
/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f2725a = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, 428, 379}, new int[]{274, 562, 232, 755, 599, 524, 801, 132, 295, 116, 442, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, Contants.PREVIEW_W, 321, 536, 742, 677, 742, 687, 284, 193, 517, 273, 494, 263, 147, 593, BannerConfig.DURATION, 571, 320, 803, 133, util.c2.a.B0, 390, 685, 330, 63, 410}, new int[]{539, FlowControl.STATUS_FLOW_CTRL_BRUSH, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, UCrop.REQUEST_MULTI_CROP, 858, 822, 543, 376, FrameMetricsAggregator.EVERY_DURATION, 400, 672, 762, 283, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 440, 35, 519, 31, 460, 594, 225, 535, 517, 352, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 651, 201, BuildConfig.VERSION_CODE, 502, 648, 733, 717, 83, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, TinkerReport.KEY_APPLIED_FAIL_COST_60S_LESS, c.b.c.e0.a.f2614b, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_ATTACK_PICTURE, 516, CustomCameraView.BUTTON_STATE_ONLY_RECORDER, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, SubsamplingScaleImageView.ORIENTATION_270, 447, 90, 507, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADPITCH, 754, 336, 89, 614, 87, 432, 670, 616, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META, 374, 242, 726, 600, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, util.c2.a.v0, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR, 858, 194, 311, 913, 275, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT, 540, 913, 801, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_NOPEOPLE, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 884, 315, 70, 329, 793, 490, 274, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 399, 908, 103, FrameMetricsAggregator.EVERY_DURATION, 51, 8, 517, 225, 289, APICode.CODE_EXPRIE, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 588, PictureConfig.CHOOSE_REQUEST, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_BLINK, 192, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT, 142, 673, 687, 234, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_DEFAULT_ERROR, 384, 177, 752, 607, Contants.PREVIEW_W, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 697, 755, 756, 60, util.c2.a.B0, 773, 434, FlowControl.STATUS_FLOW_CTRL_CUR, 726, 528, AGCServerException.SERVER_NOT_AVAILABLE, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, UCrop.REQUEST_MULTI_CROP, 441, 180, 791, 893, 754, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_HEADRIGHT, 383, 228, 749, 760, 213, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, UCrop.REQUEST_MULTI_CROP, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, TinkerReport.KEY_LOADED_SUCC_COST_OTHER, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 409, 574, 118, 498, 285, 380, TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, Contants.PREVIEW_W, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, BannerConfig.DURATION, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, 407, 855, 85, 99, 62, 482, 180, 20, 297, TinkerReport.KEY_LOADED_INTERPRET_INTERPRET_COMMAND_ERROR, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, InputDeviceCompat.SOURCE_DPAD, 192, 516, CustomCameraView.BUTTON_STATE_ONLY_RECORDER, 240, 518, 794, 395, 768, 848, 51, 610, 384, 168, 190, 826, 328, ActionActivity.REQUEST_CODE, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, 531, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, TinkerReport.KEY_LOADED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, 785, 288, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, TinkerReport.KEY_LOADED_INTERPRET_TYPE_INTERPRET_OK, 578, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, FlowControl.STATUS_FLOW_CTRL_ALL, 245, 288, 594, 394, FrameMetricsAggregator.EVERY_DURATION, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKERFLAG_NOT_SUPPORT, TinkerReport.KEY_APPLIED_FAIL_COST_OTHER, 563, 564, 343, 693, 109, 608, 563, 365, TinkerReport.KEY_APPLIED_PATCH_FILE_EXTRACT, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, 247, TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT, 45, 787, 680, 18, 66, 407, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, FlowControl.STATUS_FLOW_CTRL_ALL, TinkerReport.KEY_LOADED_MISSING_PATCH_FILE, 441, TinkerReport.KEY_APPLIED_FAIL_COST_30S_LESS, 300, 892, 827, 141, 537, 381, 662, InputDeviceCompat.SOURCE_DPAD, 56, TinkerReport.KEY_LOADED_EXCEPTION_DEX, 341, 242, 797, 838, 837, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, TinkerReport.KEY_LOADED_INFO_CORRUPTED, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, util.c2.a.u0, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, FlowControl.STATUS_FLOW_CTRL_BRUSH, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, 273, 610, 296, TinkerReport.KEY_APPLIED_LIB_EXTRACT, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_AUTH_ERROR, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, 316, 342, 299, 534, 105, 667, BuildConfig.VERSION_CODE, Contants.PREVIEW_W, 672, 576, 540, 316, 486, 721, 610, 46, 656, 447, 171, 616, 464, 190, 531, 297, 321, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, ActionActivity.REQUEST_CODE, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, 407, 164, 332, 899, 165, 726, 600, 325, 498, 655, TinkerReport.KEY_LOADED_PACKAGE_CHECK_RES_META, 752, 768, util.c2.a.z0, 849, 647, 63, 310, 863, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 366, 304, 282, 738, 675, 410, 389, 244, 31, 121, 303, 263}};

    private f() {
    }

    static int a(int i2) {
        if (i2 < 0 || i2 > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i2 + 1);
    }

    static int b(int i2) throws w {
        if (i2 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }
        if (i2 <= 40) {
            return 2;
        }
        if (i2 <= 160) {
            return 3;
        }
        if (i2 <= 320) {
            return 4;
        }
        if (i2 <= 863) {
            return 5;
        }
        throw new w("No recommendation possible");
    }

    static String a(CharSequence charSequence, int i2) {
        int iA = a(i2);
        char[] cArr = new char[iA];
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            int iCharAt = (charSequence.charAt(i3) + cArr[cArr.length - 1]) % c.b.c.e0.a.f2613a;
            for (int i4 = iA - 1; i4 >= 1; i4--) {
                cArr[i4] = (char) ((cArr[i4 - 1] + (929 - ((f2725a[i2][i4] * iCharAt) % c.b.c.e0.a.f2613a))) % c.b.c.e0.a.f2613a);
            }
            cArr[0] = (char) ((929 - ((iCharAt * f2725a[i2][0]) % c.b.c.e0.a.f2613a)) % c.b.c.e0.a.f2613a);
        }
        StringBuilder sb = new StringBuilder(iA);
        for (int i5 = iA - 1; i5 >= 0; i5--) {
            if (cArr[i5] != 0) {
                cArr[i5] = (char) (929 - cArr[i5]);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }
}
