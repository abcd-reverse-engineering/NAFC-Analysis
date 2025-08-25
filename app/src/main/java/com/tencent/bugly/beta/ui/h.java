package com.tencent.bugly.beta.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class h extends a {
    public static h v = new h();
    protected TextView n;
    protected TextView o;
    public y p;
    public DownloadTask q;
    public Runnable r;
    public Runnable s;
    public BitmapDrawable u;
    public UILifecycleListener w;
    private d C = null;
    protected Bitmap t = null;
    View.OnClickListener x = new com.tencent.bugly.beta.global.b(9, this);
    View.OnClickListener y = new com.tencent.bugly.beta.global.b(4, this);
    View.OnClickListener z = new com.tencent.bugly.beta.global.b(5, this);
    View.OnClickListener A = new com.tencent.bugly.beta.global.b(6, this);
    DownloadListener B = new com.tencent.bugly.beta.download.a(2, this);

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.tencent.bugly.beta.download.DownloadTask r9) {
        /*
            r8 = this;
            int r0 = r9.getStatus()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L4e
            r3 = 1
            if (r0 == r3) goto L49
            if (r0 == r1) goto L24
            r9 = 3
            if (r0 == r9) goto L1f
            r9 = 4
            if (r0 == r9) goto L4e
            r9 = 5
            if (r0 == r9) goto L1a
            java.lang.String r9 = ""
            r0 = r2
            goto L52
        L1a:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogRetryBtn
            android.view.View$OnClickListener r0 = r8.y
            goto L52
        L1f:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogContinueBtn
            android.view.View$OnClickListener r0 = r8.y
            goto L52
        L24:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            long r5 = r9.getSavedLength()
            float r5 = (float) r5
            long r6 = r9.getTotalLength()
            float r9 = (float) r6
            float r5 = r5 / r9
            r9 = 1120403456(0x42c80000, float:100.0)
            float r5 = r5 * r9
            java.lang.Float r9 = java.lang.Float.valueOf(r5)
            r3[r4] = r9
            java.lang.String r9 = "%.1f%%"
            java.lang.String r9 = java.lang.String.format(r0, r9, r3)
            android.view.View$OnClickListener r0 = r8.z
            goto L52
        L49:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogInstallBtn
            android.view.View$OnClickListener r0 = r8.x
            goto L52
        L4e:
            java.lang.String r9 = com.tencent.bugly.beta.Beta.strUpgradeDialogUpgradeBtn
            android.view.View$OnClickListener r0 = r8.y
        L52:
            com.tencent.bugly.proguard.y r3 = r8.p
            byte r3 = r3.f9481g
            if (r3 == r1) goto L60
            java.lang.String r1 = com.tencent.bugly.beta.Beta.strUpgradeDialogCancelBtn
            android.view.View$OnClickListener r2 = r8.A
            r8.a(r1, r2, r9, r0)
            goto L63
        L60:
            r8.a(r2, r2, r9, r0)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.ui.h.a(com.tencent.bugly.beta.download.DownloadTask):void");
    }

    public synchronized void c() {
        try {
        } catch (Exception e2) {
            if (this.f8819l != 0) {
                an.e("please confirm your argument: [Beta.upgradeDialogLayoutId] is correct", new Object[0]);
            }
            if (!an.b(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f8809b != null && this.p != null && this.q != null) {
            Bitmap bitmapA = null;
            if (this.f8819l != 0) {
                this.f8813f.setText(this.p.f9475a);
                if (this.f8812e != null) {
                    this.f8812e.setAdjustViewBounds(true);
                    if (this.f8818k != 0) {
                        this.t = com.tencent.bugly.beta.global.a.a(this.f8808a, 0, this.f8817j.a("IMG_title"));
                        this.u = null;
                        if (this.t != null) {
                            bitmapA = this.t;
                        } else if (com.tencent.bugly.beta.global.e.G.f8800j != 0) {
                            bitmapA = com.tencent.bugly.beta.global.a.a(this.f8808a, 1, Integer.valueOf(com.tencent.bugly.beta.global.e.G.f8800j));
                        }
                        this.f8812e.setImageBitmap(bitmapA);
                    }
                }
            } else if (this.f8818k != 0) {
                this.t = com.tencent.bugly.beta.global.a.a(this.f8808a, 0, this.f8817j.a("IMG_title"));
                this.u = null;
                if (this.t != null) {
                    bitmapA = this.t;
                } else if (com.tencent.bugly.beta.global.e.G.f8800j != 0) {
                    bitmapA = com.tencent.bugly.beta.global.a.a(this.f8808a, 1, Integer.valueOf(com.tencent.bugly.beta.global.e.G.f8800j));
                }
                this.f8813f.getViewTreeObserver().removeOnPreDrawListener(this.C);
                this.C = new d(1, this, this.f8813f, bitmapA, Integer.valueOf(this.f8818k));
                this.f8813f.getViewTreeObserver().addOnPreDrawListener(this.C);
            } else {
                this.f8813f.setHeight(com.tencent.bugly.beta.global.a.a(this.f8808a, 42.0f));
                this.f8813f.setText(this.p.f9475a);
            }
            this.o.setText(this.p.f9476b.length() > 500 ? this.p.f9476b.substring(0, 500) : this.p.f9476b);
            if (com.tencent.bugly.beta.global.e.G.W) {
                StringBuilder sb = new StringBuilder();
                sb.append(Beta.strUpgradeDialogVersionLabel);
                sb.append(": ");
                sb.append(this.p.f9479e.f9453d);
                sb.append("\n");
                sb.append(Beta.strUpgradeDialogFileSizeLabel);
                sb.append(": ");
                float f2 = this.p.f9480f.f9447d;
                if (f2 >= 1048576.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1048576.0f)));
                    sb.append("M");
                } else if (f2 >= 1024.0f) {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2 / 1024.0f)));
                    sb.append("K");
                } else {
                    sb.append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(f2)));
                    sb.append("B");
                }
                sb.append("\n");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
                sb.append(Beta.strUpgradeDialogUpdateTimeLabel);
                sb.append(": ");
                sb.append(simpleDateFormat.format(new Date(this.p.o)));
                this.n.setText(sb);
            }
            a(this.q);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        this.f8819l = eVar.f8801k;
        this.w = eVar.f8803m;
        try {
            this.f8818k = Integer.parseInt(ResBean.f8780a.a("VAL_style"));
        } catch (Exception e2) {
            an.a(e2.getMessage(), new Object[0]);
            this.f8818k = 0;
        }
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f8819l != 0) {
            this.n = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_INFO);
            this.o = (TextView) viewOnCreateView.findViewWithTag(Beta.TAG_UPGRADE_FEATURE);
        } else {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout = new LinearLayout(this.f8808a);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            ResBean resBean = ResBean.f8780a;
            if (com.tencent.bugly.beta.global.e.G.W) {
                this.n = new TextView(this.f8808a);
                this.n.setLayoutParams(layoutParams2);
                TextView textView = this.n;
                resBean.getClass();
                textView.setTextColor(Color.parseColor("#757575"));
                this.n.setTextSize(14);
                this.n.setTag(Beta.TAG_UPGRADE_INFO);
                this.n.setLineSpacing(15.0f, 1.0f);
                linearLayout.addView(this.n);
            }
            TextView textView2 = new TextView(this.f8808a);
            textView2.setLayoutParams(layoutParams2);
            resBean.getClass();
            textView2.setTextColor(Color.parseColor("#273238"));
            float f2 = 14;
            textView2.setTextSize(f2);
            textView2.setSingleLine();
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(String.valueOf(Beta.strUpgradeDialogFeatureLabel + ": "));
            textView2.setPadding(0, com.tencent.bugly.beta.global.a.a(this.f8808a, 8.0f), 0, 0);
            linearLayout.addView(textView2);
            this.o = new TextView(this.f8808a);
            this.o.setLayoutParams(layoutParams2);
            TextView textView3 = this.o;
            resBean.getClass();
            textView3.setTextColor(Color.parseColor("#273238"));
            this.o.setTextSize(f2);
            this.o.setTag(Beta.TAG_UPGRADE_FEATURE);
            this.o.setMaxHeight(com.tencent.bugly.beta.global.a.a(this.f8808a, 200.0f));
            this.o.setLineSpacing(15.0f, 1.0f);
            linearLayout.addView(this.o);
            this.f8816i.addView(linearLayout);
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            FragmentActivity activity = getActivity();
            y yVar = this.p;
            uILifecycleListener.onCreate(activity, viewOnCreateView, yVar != null ? new UpgradeInfo(yVar) : null);
        }
        return viewOnCreateView;
    }

    @Override // com.tencent.bugly.beta.ui.a, androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            super.onDestroyView();
            this.n = null;
            this.o = null;
            synchronized (this) {
                this.C = null;
            }
            if (this.u != null) {
                this.u.setCallback(null);
            }
            if (this.w != null) {
                this.w.onDestroy(this.f8808a, this.f8809b, this.p != null ? new UpgradeInfo(this.p) : null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.bugly.beta.ui.b, androidx.fragment.app.Fragment
    public void onPause() {
        DownloadTask downloadTask;
        super.onPause();
        DownloadListener downloadListener = this.B;
        if (downloadListener != null && (downloadTask = this.q) != null) {
            downloadTask.removeListener(downloadListener);
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.f8808a;
            View view = this.f8809b;
            y yVar = this.p;
            uILifecycleListener.onPause(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // com.tencent.bugly.beta.ui.b, androidx.fragment.app.Fragment
    public void onResume() {
        DownloadTask downloadTask;
        super.onResume();
        DownloadListener downloadListener = this.B;
        if (downloadListener != null && (downloadTask = this.q) != null) {
            downloadTask.addListener(downloadListener);
        }
        c();
        if (this.f8818k != 0 && this.t == null) {
            com.tencent.bugly.beta.global.f.f8804a.a(new com.tencent.bugly.beta.global.d(7, this));
        }
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.f8808a;
            View view = this.f8809b;
            y yVar = this.p;
            uILifecycleListener.onResume(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.f8808a;
            View view = this.f8809b;
            y yVar = this.p;
            uILifecycleListener.onStart(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        UILifecycleListener uILifecycleListener = this.w;
        if (uILifecycleListener != null) {
            Context context = this.f8808a;
            View view = this.f8809b;
            y yVar = this.p;
            uILifecycleListener.onStop(context, view, yVar != null ? new UpgradeInfo(yVar) : null);
        }
    }

    public synchronized void a(y yVar, DownloadTask downloadTask) {
        this.p = yVar;
        this.q = downloadTask;
        this.q.addListener(this.B);
        com.tencent.bugly.beta.utils.e.a(new com.tencent.bugly.beta.global.d(7, this));
    }

    @Override // com.tencent.bugly.beta.ui.b
    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return false;
        }
        if (this.p.f9481g == 2) {
            return true;
        }
        Runnable runnable = this.s;
        if (runnable != null) {
            runnable.run();
        }
        a();
        return true;
    }
}
