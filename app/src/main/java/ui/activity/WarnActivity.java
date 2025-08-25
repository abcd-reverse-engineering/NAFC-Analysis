package ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import ui.Hicore;

/* loaded from: classes2.dex */
public class WarnActivity extends AppCompatActivity {

    @BindView(R.id.tv_dialog_phone)
    TextView mTvAppVersion;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 23)
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(6848512);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(9);
        setContentView(R.layout.layout_call_intercepter);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.tv_dialog_phone})
    public void onViewClicked(View view) {
        if (!Hicore.getApp().isDouble() && view.getId() == R.id.tv_dialog_phone) {
            finish();
        }
    }
}
