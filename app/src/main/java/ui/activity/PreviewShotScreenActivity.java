package ui.activity;

import android.os.Handler;
import android.widget.ImageView;
import butterknife.BindView;
import com.hicorenational.antifraud.R;
import com.umeng.analytics.MobclickAgent;

/* loaded from: classes2.dex */
public class PreviewShotScreenActivity extends BaseActivity {

    @BindView(R.id.iv_shot_screen_preview)
    ImageView ivShotScreenPreview;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PreviewShotScreenActivity.this.finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.ivShotScreenPreview.setImageURI(getIntent().getData());
        new Handler().postDelayed(new a(), 2000L);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override // ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        getWindow().setFlags(1024, 1024);
        return R.layout.activity_preview_shot_screen;
    }
}
