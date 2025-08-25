package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.Hicore;

/* loaded from: classes2.dex */
public class EvidenceDiscActivity extends BaseActivity {

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.ed_describe)
    EditText mEtCaseDescribe;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    private void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("disc");
        this.mTvTitle.setText(stringExtra);
        this.mEtCaseDescribe.setText(stringExtra2);
        if (TextUtils.equals("案情描述", stringExtra)) {
            this.mEtCaseDescribe.setHint("请详细描述案件经过（时间、地点、人物、原因、经过、结果）... ");
        }
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        String string = this.mEtCaseDescribe.getText().toString();
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            org.greenrobot.eventbus.c.f().d(new util.c2.a(2, string));
            finish();
            return;
        }
        if (TextUtils.isEmpty(string)) {
            util.w1.a("请填写举报信息");
        } else {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(2, string));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_evidence;
    }
}
