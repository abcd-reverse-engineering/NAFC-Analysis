package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class IDVarfySuccessActivity extends BaseActivity {

    /* renamed from: a, reason: collision with root package name */
    String f18249a;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_tips)
    TextView mTvTips;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("核实完成");
        this.f18249a = getIntent().getStringExtra(util.k1.k0);
        this.mTvTips.setText("恭喜您完成“身份核实”\n\n核实结果将传达给请求方" + this.f18249a);
    }

    @OnClick({R.id.iv_back, R.id.btn_idvrfy_start})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.btn_idvrfy_start || id == R.id.iv_back) {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(39, null));
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_var_ok;
    }
}
