package zxing.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import c.b.c.r;
import com.hicorenational.antifraud.R;
import java.util.Collection;
import java.util.Map;
import zxing.view.ViewfinderView;

/* loaded from: classes2.dex */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {

    /* renamed from: k, reason: collision with root package name */
    public static final int f21075k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final String f21076l = "codedContent";

    /* renamed from: m, reason: collision with root package name */
    private static final String f21077m = CaptureActivity.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private m.a.d f21078a;

    /* renamed from: b, reason: collision with root package name */
    private zxing.android.a f21079b;

    /* renamed from: c, reason: collision with root package name */
    private ViewfinderView f21080c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f21081d;

    /* renamed from: e, reason: collision with root package name */
    private d f21082e;

    /* renamed from: f, reason: collision with root package name */
    private Collection<c.b.c.a> f21083f;

    /* renamed from: g, reason: collision with root package name */
    private Map<c.b.c.e, ?> f21084g;

    /* renamed from: h, reason: collision with root package name */
    private String f21085h;

    /* renamed from: i, reason: collision with root package name */
    private c f21086i;

    /* renamed from: j, reason: collision with root package name */
    private ImageButton f21087j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CaptureActivity.this.finish();
        }
    }

    private void a(Context context) {
    }

    private void e() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.msg_camera_framework_bug));
        builder.setPositiveButton(R.string.button_ok, new b(this));
        builder.setOnCancelListener(new b(this));
        builder.show();
    }

    public void a() {
        this.f21080c.a();
    }

    public m.a.d b() {
        return this.f21078a;
    }

    public Handler c() {
        return this.f21079b;
    }

    public ViewfinderView d() {
        return this.f21080c;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        setContentView(R.layout.capture);
        this.f21081d = false;
        this.f21086i = new c(this);
        this.f21087j = (ImageButton) findViewById(R.id.capture_imageview_back);
        this.f21087j.setOnClickListener(new a());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.f21086i.d();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() throws InterruptedException {
        zxing.android.a aVar = this.f21079b;
        if (aVar != null) {
            aVar.a();
            this.f21079b = null;
        }
        this.f21086i.b();
        this.f21078a.a();
        if (!this.f21081d) {
            ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f21078a = new m.a.d(getApplication());
        this.f21080c = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.f21080c.setCameraManager(this.f21078a);
        this.f21079b = null;
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.preview_view)).getHolder();
        if (this.f21081d) {
            a(holder);
        } else {
            holder.addCallback(this);
        }
        this.f21086i.c();
        this.f21082e = d.NONE;
        this.f21083f = null;
        this.f21085h = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f21081d) {
            return;
        }
        this.f21081d = true;
        a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f21081d = false;
    }

    public void a(r rVar, Bitmap bitmap, float f2) {
        this.f21086i.a();
        if (rVar != null) {
            a(this);
            Intent intent = getIntent();
            intent.putExtra(f21076l, rVar.e());
            setResult(-1, intent);
            finish();
        }
    }

    private void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            if (this.f21078a.d()) {
                return;
            }
            try {
                this.f21078a.a(surfaceHolder);
                if (this.f21079b == null) {
                    this.f21079b = new zxing.android.a(this, this.f21083f, this.f21084g, this.f21085h, this.f21078a);
                    return;
                }
                return;
            } catch (Exception unused) {
                e();
                return;
            }
        }
        throw new IllegalStateException("No SurfaceHolder provided");
    }
}
