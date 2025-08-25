package ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class IDVarfyFaceActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("");
    }

    @OnClick({R.id.iv_back, R.id.tv_firm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.iv_back) {
            finish();
        } else {
            if (id != R.id.tv_firm) {
                return;
            }
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_id_varfy_face;
    }
}
