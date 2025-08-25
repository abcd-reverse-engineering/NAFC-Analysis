package receiver;

import android.os.Bundle;
import android.widget.TextView;
import com.hicorenational.antifraud.R;
import com.umeng.message.UmengNotifyClickActivity;
import com.umeng.message.entity.UMessage;

/* loaded from: classes2.dex */
public class UMMipushReceiverActivity extends UmengNotifyClickActivity {

    /* renamed from: b, reason: collision with root package name */
    private TextView f17538b;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UMessage f17539a;

        a(UMessage uMessage) {
            this.f17539a = uMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            UMMipushReceiverActivity.this.f17538b.setText(this.f17539a.getRaw().toString());
        }
    }

    @Override // com.umeng.message.UmengNotifyClickActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.umeng_mipush);
        this.f17538b = (TextView) findViewById(R.id.mipushTextView);
    }

    @Override // com.umeng.message.UmengNotifyClickActivity
    protected void onMessage(UMessage uMessage) {
        super.onMessage(uMessage);
        runOnUiThread(new a(uMessage));
    }
}
