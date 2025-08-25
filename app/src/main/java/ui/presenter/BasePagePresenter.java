package ui.presenter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IOneClickListener;
import java.util.ArrayList;
import ui.basemvp.BasePresenter;
import util.k1;
import util.w1;

/* loaded from: classes2.dex */
public class BasePagePresenter extends BasePresenter {
    private Activity mActivity;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IOneClickListener f19793a;

        /* renamed from: ui.presenter.BasePagePresenter$a$a, reason: collision with other inner class name */
        class RunnableC0294a implements Runnable {
            RunnableC0294a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IOneClickListener iOneClickListener = a.this.f19793a;
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            }
        }

        a(IOneClickListener iOneClickListener) {
            this.f19793a = iOneClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 23 || !k1.a((Context) BasePagePresenter.this.mActivity)) {
                return;
            }
            BasePagePresenter.this.mActivity.runOnUiThread(new RunnableC0294a());
        }
    }

    public BasePagePresenter(Activity activity) {
        this.mActivity = activity;
    }

    @SuppressLint({"NewApi"})
    public void checkOtherPerssion(String[] strArr) {
        try {
            String str = Build.BRAND;
            String str2 = Build.DEVICE;
            if (str.equalsIgnoreCase("vivo")) {
                if (util.permissionutil.c.a((Context) this.mActivity) != 0) {
                    this.mActivity.startActivityForResult(k1.d(this.mActivity), 10001);
                    return;
                }
                return;
            }
            if (str2.equalsIgnoreCase("hwH60")) {
                if (strArr != null) {
                    ActivityCompat.requestPermissions(this.mActivity, strArr, d.d.f13552h);
                }
                if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.mActivity)) {
                    return;
                }
                Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS", Uri.parse("package:" + this.mActivity.getPackageName()));
                intent.addFlags(CommonNetImpl.FLAG_AUTH);
                this.mActivity.startActivityForResult(intent, d.d.f13553i);
                return;
            }
            if (!str.equalsIgnoreCase("oppo") || Build.VERSION.SDK_INT != 22) {
                if (k1.a((Context) this.mActivity)) {
                    return;
                }
                this.mActivity.startActivityForResult(k1.d(this.mActivity), 10001);
                return;
            }
            try {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.setFlags(CommonNetImpl.FLAG_AUTH);
                intent2.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
                this.mActivity.startActivityForResult(intent2, 10001);
            } catch (Exception e2) {
                e2.printStackTrace();
                w1.a("请去手机管家设置");
            }
        } catch (Exception unused) {
        }
    }

    public String[] checkPermission() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.f20916j);
        arrayList.add(util.permissionutil.a.f20918l);
        arrayList.add(util.permissionutil.a.w);
        arrayList.add(util.permissionutil.a.v);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(util.permissionutil.a.r);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] checkPermissionCall() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.f20916j);
        arrayList.add(util.permissionutil.a.f20918l);
        if (Build.VERSION.SDK_INT >= 26) {
            arrayList.add(util.permissionutil.a.r);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] checkPermissionSms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(util.permissionutil.a.w);
        arrayList.add(util.permissionutil.a.v);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @SuppressLint({"NewApi"})
    public boolean isOpenFlowPrim() {
        if (Build.BRAND.equalsIgnoreCase("vivo")) {
            if (util.permissionutil.c.a((Context) this.mActivity) != 0) {
                return false;
            }
        } else if (!k1.a((Context) this.mActivity)) {
            return false;
        }
        return !Build.DEVICE.equalsIgnoreCase("hwH60") || Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(this.mActivity);
    }

    public void onActivityResult(IOneClickListener iOneClickListener) {
        new Handler().postDelayed(new a(iOneClickListener), 500L);
    }
}
