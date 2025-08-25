package cn.cloudwalk.libproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class LiveStartActivity extends BaseActivity {
    public static LiveStartActivity activity;
    private final int REQUEST_PERMISSION = 273;
    private TextView tv_start;

    private void initView() {
        this.tv_start = (TextView) findViewById(R.id.tv_start);
        this.tv_start.setOnClickListener(new View.OnClickListener() { // from class: cn.cloudwalk.libproject.LiveStartActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LiveStartActivity.this.tv_start.setClickable(false);
                LiveStartActivity.this.beginDetect();
            }
        });
    }

    public void beginDetect() {
        startActivity(new Intent(this, (Class<?>) LiveActivity.class));
        finish();
    }

    @Override // cn.cloudwalk.libproject.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        activity = this;
        setContentView(R.layout.cloudwalk_layout_facedect_start);
        getWindow().addFlags(128);
        setRequestedOrientation(14);
        initView();
    }
}
