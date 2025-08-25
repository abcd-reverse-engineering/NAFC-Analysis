package cn.cloudwalk.libproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class LivenessFailActivity extends BaseActivity {
    TextView tv_again;

    private void initView() {
        this.tv_again = (TextView) findViewById(R.id.tv_again);
        this.tv_again.setOnClickListener(new View.OnClickListener() { // from class: cn.cloudwalk.libproject.LivenessFailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LivenessFailActivity.this.tv_again.setClickable(false);
                LivenessFailActivity livenessFailActivity = LivenessFailActivity.this;
                livenessFailActivity.startActivity(new Intent(livenessFailActivity, (Class<?>) LiveActivity.class));
                LivenessFailActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_liveness_fail);
        getWindow().addFlags(128);
        setRequestedOrientation(14);
        initView();
    }
}
