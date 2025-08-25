package util;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.a.e.d;
import b.a.a.e.i;
import com.hicorenational.antifraud.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.List;

/* compiled from: PickUtil.java */
/* loaded from: classes2.dex */
public class s1 {

    /* compiled from: PickUtil.java */
    static class a implements d.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f20962a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d.m f20963b;

        a(TextView textView, d.m mVar) {
            this.f20962a = textView;
            this.f20963b = mVar;
        }

        @Override // b.a.a.e.d.m
        public void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str3 + c.c.a.b.a.a.f3100g + str4 + Constants.COLON_SEPARATOR + str5;
            TextView textView = this.f20962a;
            if (textView != null) {
                textView.setText(str6);
            }
            d.m mVar = this.f20963b;
            if (mVar != null) {
                mVar.a(str, str2, str3, str4, str5);
            }
        }
    }

    /* compiled from: PickUtil.java */
    static class b implements i.b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b f20964a;

        b(i.b bVar) {
            this.f20964a = bVar;
        }

        @Override // b.a.a.e.i.b
        public void a(int i2, String str) {
            i.b bVar = this.f20964a;
            if (bVar != null) {
                bVar.a(i2, str);
            }
        }
    }

    /* compiled from: PickUtil.java */
    static class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a.a.e.i f20965a;

        c(b.a.a.e.i iVar) {
            this.f20965a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20965a.a();
        }
    }

    /* compiled from: PickUtil.java */
    static class d implements i.b<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.b f20966a;

        d(i.b bVar) {
            this.f20966a = bVar;
        }

        @Override // b.a.a.e.i.b
        public void a(int i2, String str) {
            i.b bVar = this.f20966a;
            if (bVar != null) {
                bVar.a(i2, str);
            }
        }
    }

    /* compiled from: PickUtil.java */
    static class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a.a.e.i f20967a;

        e(b.a.a.e.i iVar) {
            this.f20967a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f20967a.a();
        }
    }

    public static void a(Activity activity, TextView textView) {
        a(activity, textView, (d.m) null);
    }

    public static void a(Activity activity, TextView textView, d.m mVar) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(activity, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new a(textView, mVar));
        dVar.m();
    }

    public static void a(Activity activity, String[] strArr, i.b bVar) {
        if (strArr == null) {
            return;
        }
        b.a.a.e.i iVar = new b.a.a.e.i(activity, strArr);
        iVar.setOnItemPickListener(new b(bVar));
        TextView textView = new TextView(iVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(R.color.black_light));
        textView.setOnClickListener(new c(iVar));
        iVar.m();
    }

    public static void a(Activity activity, List<String> list, i.b<String> bVar) {
        if (list == null || list.size() <= 0) {
            return;
        }
        b.a.a.e.i iVar = new b.a.a.e.i(activity, list);
        iVar.setOnItemPickListener(new d(bVar));
        TextView textView = new TextView(iVar.d());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        textView.setGravity(17);
        textView.setTextColor(activity.getResources().getColor(R.color.black_light));
        textView.setOnClickListener(new e(iVar));
        iVar.m();
    }
}
