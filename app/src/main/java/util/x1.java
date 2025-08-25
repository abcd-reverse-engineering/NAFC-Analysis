package util;

import android.widget.TextView;
import interfaces.PermissionsListener;
import java.util.List;
import network.DownloadInfo;

/* compiled from: UpdateUtil.java */
/* loaded from: classes2.dex */
class x1 implements PermissionsListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f21021a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextView f21022b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ DownloadInfo f21023c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ UpdateUtil f21024d;

    x1(UpdateUtil updateUtil, String str, TextView textView, DownloadInfo downloadInfo) {
        this.f21024d = updateUtil;
        this.f21021a = str;
        this.f21022b = textView;
        this.f21023c = downloadInfo;
    }

    @Override // interfaces.PermissionsListener
    public void onDenied(List<String> list, boolean z) {
        util.permissionutil.c.a(UpdateUtil.mActivity, list, z, false, this);
    }

    @Override // interfaces.PermissionsListener
    public void onGranted() {
        n1.a("hsc", "AppDownlaodUrl=====" + this.f21021a);
        this.f21024d.doUpdateApp(this.f21022b, this.f21023c, this.f21021a);
    }
}
