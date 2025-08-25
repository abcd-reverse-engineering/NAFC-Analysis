package ui.view.drag;

import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/* compiled from: Children.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<View, a> f20526a = new LinkedHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<a> f20527b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private HandyGridView f20528c;

    public b(HandyGridView handyGridView) {
        this.f20528c = handyGridView;
    }

    public void a(int i2, View view) {
        a aVar = this.f20526a.get(view);
        if (aVar == null) {
            aVar = new a(view);
            aVar.a(this.f20528c);
            this.f20526a.put(view, aVar);
        }
        this.f20527b.add(i2, aVar);
    }

    public void b(int i2) {
        this.f20527b.remove(i2);
    }

    public int b() {
        return this.f20527b.size();
    }

    public boolean a(a aVar) {
        return this.f20527b.remove(aVar);
    }

    public a a(int i2) {
        return this.f20527b.get(i2);
    }

    public int a(View view) {
        a aVar = this.f20526a.get(view);
        if (aVar == null) {
            return -2;
        }
        return this.f20527b.indexOf(aVar);
    }

    public void a() {
        this.f20526a.clear();
        Iterator<a> it = this.f20527b.iterator();
        while (it.hasNext()) {
            it.next().b();
            it.remove();
        }
    }
}
