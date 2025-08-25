package util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import bean.CheckUserBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.ICheckVerifyListener;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import java.util.HashMap;
import manager.AccountManager;
import ui.activity.BaseActivity;
import ui.activity.VerifyFaceActivity;
import ui.presenter.HelperPresenter;

/* compiled from: VerifiedUtil.java */
/* loaded from: classes2.dex */
public class z1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f21049a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f21050b = 1011;

    /* renamed from: c, reason: collision with root package name */
    public static final int f21051c = 1012;

    /* renamed from: d, reason: collision with root package name */
    public static final int f21052d = 1013;

    /* renamed from: e, reason: collision with root package name */
    public static final int f21053e = 1014;

    /* renamed from: f, reason: collision with root package name */
    public static final int f21054f = 3;

    /* renamed from: g, reason: collision with root package name */
    public static final int f21055g = 4;

    /* renamed from: h, reason: collision with root package name */
    public static final int f21056h = 6;

    /* renamed from: i, reason: collision with root package name */
    public static final int f21057i = 7;

    /* renamed from: j, reason: collision with root package name */
    public static final int f21058j = 8;

    /* renamed from: k, reason: collision with root package name */
    public static final int f21059k = 9;

    /* renamed from: l, reason: collision with root package name */
    public static final int f21060l = 10;

    /* renamed from: m, reason: collision with root package name */
    public static final int f21061m = 11;
    public static final int n = 12;
    public static final int o = 13;
    public static final int p = 15;
    public static final int q = 16;
    public static final int r = 17;
    public static final int s = 18;
    public static final int t = 19;
    public static final int u = 20;
    public static HashMap<String, Object> v = null;
    public static boolean w = false;
    private static Context x;
    private static z1 y;
    private static HelperPresenter z;

    /* compiled from: VerifiedUtil.java */
    class a implements ICheckVerifyListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21062a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f21063b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IVerifyListener f21064c;

        a(int i2, HashMap map, IVerifyListener iVerifyListener) {
            this.f21062a = i2;
            this.f21063b = map;
            this.f21064c = iVerifyListener;
        }

        @Override // interfaces.ICheckVerifyListener
        public void onSuccessVerify(CheckUserBean checkUserBean) {
            p1.a(p1.f20902l, checkUserBean);
            z1.this.a(this.f21062a, checkUserBean, this.f21063b, this.f21064c);
        }
    }

    /* compiled from: VerifiedUtil.java */
    class b implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21066a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f21067b;

        b(int i2, HashMap map) {
            this.f21066a = i2;
            this.f21067b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            u1.b(u1.x0, this.f21066a);
            HashMap map = this.f21067b;
            if (map != null && !map.isEmpty()) {
                z1.v = this.f21067b;
            }
            z1.x.startActivity(new Intent(z1.x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* compiled from: VerifiedUtil.java */
    class c implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21069a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f21070b;

        c(int i2, HashMap map) {
            this.f21069a = i2;
            this.f21070b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            u1.b(u1.x0, this.f21069a);
            HashMap map = this.f21070b;
            if (map != null && !map.isEmpty()) {
                z1.v = this.f21070b;
            }
            z1.x.startActivity(new Intent(z1.x, (Class<?>) VerifyFaceActivity.class));
        }
    }

    /* compiled from: VerifiedUtil.java */
    class d implements IClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21072a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap f21073b;

        d(int i2, HashMap map) {
            this.f21072a = i2;
            this.f21073b = map;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            u1.b(u1.x0, this.f21072a);
            HashMap map = this.f21073b;
            if (map != null && !map.isEmpty()) {
                z1.v = this.f21073b;
            }
            z1.w = true;
            Intent intent = new Intent("com.deraud.regiestPersonal");
            intent.setFlags(CommonNetImpl.FLAG_AUTH);
            intent.addCategory("android.intent.category.DEFAULT");
            z1.x.startActivity(intent);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x000b. Please report as an issue. */
    private String a(int i2) {
        if (i2 == 3 || i2 == 1011 || i2 == 1014) {
            return "请先进行实名认证";
        }
        switch (i2) {
        }
        return "请先进行实名认证";
    }

    private void b(int i2, HashMap map, IVerifyListener iVerifyListener) {
        if (i2 > -1) {
            z.checkisverify(new a(i2, map, iVerifyListener));
        }
    }

    public static z1 a(Context context) {
        x = context;
        z = new HelperPresenter(context);
        if (y == null) {
            y = new z1();
        }
        return y;
    }

    public void b() {
        Context context = x;
        if (context instanceof Activity) {
            b1.b((Activity) context, "您的实名认证已转人工审核，请联 系派出所民警审核通过后使用该功能", "我知道了", null);
        }
    }

    public boolean a() {
        return AccountManager.isVerified();
    }

    public void a(int i2, IVerifyListener iVerifyListener) {
        v = null;
        w = false;
        if (a()) {
            iVerifyListener.onSuccessVerify();
        } else if (i2 > -1) {
            b(i2, null, iVerifyListener);
        }
    }

    public void a(int i2, HashMap map, IVerifyListener iVerifyListener) {
        v = null;
        w = false;
        if (a()) {
            iVerifyListener.onSuccessVerify();
            map.clear();
        } else if (i2 > -1) {
            b(i2, map, iVerifyListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, CheckUserBean checkUserBean, HashMap map, IVerifyListener iVerifyListener) {
        String str;
        String str2;
        String strA = a(i2);
        String str3 = "我知道了";
        if (checkUserBean.getAuditStatus() == 2) {
            b1.b((BaseActivity) x, "您的实名认证人工审核中，请联系 所在辖区派出所民警审核通过后 使用该功能", "我知道了", null);
            return;
        }
        if (checkUserBean.getAuditStatus() == 3) {
            str = "未通过原因：" + checkUserBean.getAuditMessage();
            strA = "实名认证未通过，无法使用该功能";
            str2 = "重新验证";
        } else if (checkUserBean.getAuditStatus() == 1) {
            AccountManager.setVerified(true, checkUserBean.getName(), checkUserBean.getIdNumber());
            iVerifyListener.onSuccessVerify();
            return;
        } else {
            str = "";
            str3 = "取消";
            str2 = "身份验证";
        }
        b1.b((BaseActivity) x, strA, str, str3, str2, new b(i2, map));
    }

    public void a(int i2, HashMap map) {
        b1.a(x, "提示", a(i2), "取消", "身份验证", new c(i2, map));
    }

    private void a(Context context, int i2, HashMap map) {
        b1.a(context, "提示", a(i2), "取消", "身份验证", new d(i2, map));
    }
}
