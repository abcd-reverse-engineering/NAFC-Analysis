package h.q2.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: SpreadBuilder.java */
/* loaded from: classes2.dex */
public class l1 {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f16405a;

    public l1(int i2) {
        this.f16405a = new ArrayList<>(i2);
    }

    public int a() {
        return this.f16405a.size();
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f16405a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f16405a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f16405a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f16405a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f16405a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public void a(Object obj) {
        this.f16405a.add(obj);
    }

    public Object[] a(Object[] objArr) {
        return this.f16405a.toArray(objArr);
    }
}
