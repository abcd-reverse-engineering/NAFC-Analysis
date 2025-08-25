package zxing.android;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import c.b.c.r;
import com.hicorenational.antifraud.R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Collection;
import java.util.Map;

/* compiled from: CaptureActivityHandler.java */
/* loaded from: classes2.dex */
public final class a extends Handler {

    /* renamed from: e, reason: collision with root package name */
    private static final String f21089e = a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f21090a;

    /* renamed from: b, reason: collision with root package name */
    private final m.b.c f21091b;

    /* renamed from: c, reason: collision with root package name */
    private EnumC0325a f21092c;

    /* renamed from: d, reason: collision with root package name */
    private final m.a.d f21093d;

    /* compiled from: CaptureActivityHandler.java */
    /* renamed from: zxing.android.a$a, reason: collision with other inner class name */
    private enum EnumC0325a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public a(CaptureActivity captureActivity, Collection<c.b.c.a> collection, Map<c.b.c.e, ?> map, String str, m.a.d dVar) {
        this.f21090a = captureActivity;
        this.f21091b = new m.b.c(captureActivity, collection, map, str, new zxing.view.a(captureActivity.d()));
        this.f21091b.start();
        this.f21092c = EnumC0325a.SUCCESS;
        this.f21093d = dVar;
        dVar.e();
        b();
    }

    public void a() throws InterruptedException {
        this.f21092c = EnumC0325a.DONE;
        this.f21093d.f();
        Message.obtain(this.f21091b.a(), R.id.quit).sendToTarget();
        try {
            this.f21091b.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }

    public void b() {
        if (this.f21092c == EnumC0325a.SUCCESS) {
            this.f21092c = EnumC0325a.PREVIEW;
            this.f21093d.a(this.f21091b.a(), R.id.decode);
            this.f21090a.a();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ActivityInfo activityInfo;
        String str = null;
        switch (message.what) {
            case R.id.decode_failed /* 2131296498 */:
                this.f21092c = EnumC0325a.PREVIEW;
                this.f21093d.a(this.f21091b.a(), R.id.decode);
                break;
            case R.id.decode_succeeded /* 2131296499 */:
                this.f21092c = EnumC0325a.SUCCESS;
                this.f21090a.a((r) message.obj, null, 0.0f);
                break;
            case R.id.launch_product_query /* 2131296878 */:
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveInfoResolveActivity = this.f21090a.getPackageManager().resolveActivity(intent, 65536);
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    str = activityInfo.packageName;
                    String str3 = "Using browser in package " + str;
                }
                if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                    intent.setPackage(str);
                    intent.addFlags(CommonNetImpl.FLAG_AUTH);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.f21090a.startActivity(intent);
                    break;
                } catch (ActivityNotFoundException unused) {
                    String str4 = "Can't find anything to handle VIEW of URI " + str2;
                    return;
                }
            case R.id.restart_preview /* 2131297168 */:
                b();
                break;
            case R.id.return_scan_result /* 2131297171 */:
                this.f21090a.setResult(-1, (Intent) message.obj);
                this.f21090a.finish();
                break;
        }
    }
}
