package b.a.a.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import b.a.a.e.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CarNumberPicker.java */
/* loaded from: classes.dex */
public class b extends f<b.a.a.d.c, b.a.a.d.b, Void> {
    private static final String[] x0 = {"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂", "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新"};

    /* compiled from: CarNumberPicker.java */
    private static class a implements f.k<b.a.a.d.c, b.a.a.d.b, Void> {

        /* renamed from: a, reason: collision with root package name */
        private List<b.a.a.d.c> f2249a = new ArrayList();

        a() {
            for (String str : b.x0) {
                this.f2249a.add(new b.a.a.d.c(str));
            }
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<b.a.a.d.c> a() {
            return this.f2249a;
        }

        @Override // b.a.a.e.f.k
        public boolean b() {
            return true;
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<b.a.a.d.b> a(int i2) {
            return this.f2249a.get(i2).getSeconds();
        }

        @Override // b.a.a.e.f.k
        @NonNull
        public List<Void> a(int i2, int i3) {
            return new ArrayList();
        }
    }

    public b(Activity activity) {
        super(activity, new a());
    }
}
