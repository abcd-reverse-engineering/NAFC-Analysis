package zxing.android;

import android.app.Activity;
import android.content.DialogInterface;

/* compiled from: FinishListener.java */
/* loaded from: classes2.dex */
public final class b implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f21095a;

    public b(Activity activity) {
        this.f21095a = activity;
    }

    private void a() {
        this.f21095a.finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        a();
    }
}
