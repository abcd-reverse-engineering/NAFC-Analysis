package cn.cloudwalk.libproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import cn.cloudwalk.FaceInterface;
import cn.cloudwalk.libproject.callback.ResultCallBack;
import cn.cloudwalk.libproject.util.ImgUtil;
import cn.cloudwalk.libproject.view.CircleImageView;
import cn.cloudwalk.libproject.view.CircleMarkView;

/* loaded from: classes.dex */
public class LivenessSucessActivity extends BaseActivity {
    private CircleMarkView circle_mark;
    private Bitmap faceBitmap;
    private double facescore;
    private CircleImageView img_circle;
    private ImageView img_success;
    private boolean islivepass;
    private boolean isverfypass;
    private String sessionid;
    private TextView tv_ok;
    private int type;

    private void getIntentData() {
        this.type = getIntent().getIntExtra(Contants.FACEDECT_RESULT_TYPE, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK);
        this.islivepass = getIntent().getBooleanExtra(Contants.ISLIVEPASS, false);
        this.isverfypass = getIntent().getBooleanExtra(Contants.ISVERFYPASS, false);
        this.facescore = getIntent().getDoubleExtra(Contants.FACESCORE, 0.0d);
        this.sessionid = getIntent().getStringExtra(Contants.SESSIONID);
    }

    private void initView() {
        this.img_success = (ImageView) findViewById(R.id.img_success);
        this.img_circle = (CircleImageView) findViewById(R.id.img_circle);
        this.circle_mark = (CircleMarkView) findViewById(R.id.circle_mark);
        this.tv_ok = (TextView) findViewById(R.id.tv_ok);
        this.tv_ok.setOnClickListener(new View.OnClickListener() { // from class: cn.cloudwalk.libproject.LivenessSucessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (Builder.isFrontHack) {
                    ResultCallBack resultCallBack = Builder.mResultCallBack;
                    if (resultCallBack != null) {
                        resultCallBack.result(LivenessSucessActivity.this.islivepass, LivenessSucessActivity.this.isverfypass, LivenessSucessActivity.this.sessionid, LivenessSucessActivity.this.facescore, LivenessSucessActivity.this.type, Builder.bestFaceData, Builder.clipedBestFaceData, Builder.liveDatas);
                    }
                    LivenessSucessActivity.this.finish();
                    return;
                }
                ResultCallBack resultCallBack2 = Builder.mResultCallBack;
                if (resultCallBack2 != null) {
                    resultCallBack2.result(true, true, "", 0.0d, FaceInterface.CW_LivenessCode.CW_FACE_LIVENESS_FACEDEC_OK, Builder.bestFaceData, Builder.clipedBestFaceData, Builder.liveDatas);
                }
                LivenessSucessActivity.this.finish();
            }
        });
        this.circle_mark.setRadius(0);
        this.circle_mark.setLineColor(getResources().getColor(R.color.color_44d7b6), true);
        byte[] bArr = Builder.bestFaceData;
        if (bArr == null) {
            bArr = Builder.clipedBestFaceData;
        }
        if (bArr != null) {
            this.faceBitmap = ImgUtil.getBitmapFromBytes(bArr, null);
            Bitmap bitmap = this.faceBitmap;
            if (bitmap != null) {
                this.img_circle.setImageBitmap(bitmap);
            } else {
                this.img_circle.setImageDrawable(getResources().getDrawable(R.color.color_ffffff));
            }
        } else {
            this.img_circle.setImageDrawable(getResources().getDrawable(R.color.color_ffffff));
        }
        scaleAnim();
    }

    private void scaleAnim() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.img_success, "scaleX", 0.0f, 1.0f).setDuration(1500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.img_success, "scaleY", 0.0f, 1.0f).setDuration(1500L);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.play(duration).with(duration2);
        animatorSet.start();
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_liveness_success);
        getWindow().addFlags(128);
        setRequestedOrientation(14);
        initView();
        getIntentData();
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.faceBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.faceBitmap = null;
        }
    }
}
