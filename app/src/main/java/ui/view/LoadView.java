package ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hicorenational.antifraud.R;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class LoadView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f20340a;

    /* renamed from: b, reason: collision with root package name */
    private View f20341b;

    /* renamed from: c, reason: collision with root package name */
    private View f20342c;

    /* renamed from: d, reason: collision with root package name */
    private Button f20343d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f20344e;

    /* renamed from: f, reason: collision with root package name */
    private d f20345f;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoadView.this.a();
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadView.this.b();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object netData = LoadView.this.getNetData();
            LoadView loadView = LoadView.this;
            loadView.f20345f = loadView.a(netData);
            LoadView.this.a((Runnable) new a());
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20349a = new int[d.values().length];

        static {
            try {
                f20349a[d.loading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20349a[d.success.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20349a[d.error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum d {
        loading,
        success,
        error
    }

    public LoadView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f20340a.setVisibility(8);
        this.f20341b.setVisibility(8);
        this.f20342c.setVisibility(8);
        int i2 = c.f20349a[this.f20345f.ordinal()];
        if (i2 == 1) {
            this.f20340a.setVisibility(0);
        } else if (i2 == 2) {
            this.f20341b.setVisibility(0);
        } else {
            if (i2 != 3) {
                return;
            }
            this.f20342c.setVisibility(0);
        }
    }

    private void c() {
        this.f20340a = View.inflate(getContext(), R.layout.page_loading, null);
        this.f20341b = getSuccess();
        this.f20342c = View.inflate(getContext(), R.layout.page_error, null);
        this.f20343d = (Button) this.f20342c.findViewById(R.id.btn_reload);
        this.f20343d.setOnClickListener(new a());
        addView(this.f20340a);
        addView(this.f20341b);
        addView(this.f20342c);
        b();
        a();
    }

    protected abstract Object getNetData();

    public abstract View getSuccess();

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.f20344e = new Handler(Looper.getMainLooper());
        this.f20345f = d.loading;
        c();
    }

    public void a(Runnable runnable) {
        this.f20344e.post(runnable);
    }

    public void a() {
        new Thread(new b()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d a(Object obj) {
        if (obj == null) {
            return d.error;
        }
        if (obj instanceof List) {
            if (((List) obj).size() > 0) {
                return d.success;
            }
            return d.error;
        }
        return d.success;
    }
}
