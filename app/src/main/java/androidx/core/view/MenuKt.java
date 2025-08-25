package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import com.hihonor.honorid.core.data.ChildrenInfo;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.q2.s.l;
import h.q2.s.p;
import h.q2.t.i0;
import h.q2.t.q1.d;
import h.x2.m;
import h.y;
import h.y1;
import java.util.Iterator;

/* compiled from: Menu.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {ChildrenInfo.o, "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class MenuKt {

    /* compiled from: Menu.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "(Landroid/view/Menu;)V", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<MenuItem>, d {
        private int index;
        final /* synthetic */ Menu receiver$0;

        AnonymousClass1(Menu menu) {
            this.receiver$0 = menu;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.receiver$0.size();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.index--;
            this.receiver$0.removeItem(this.index);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @i.c.a.d
        public MenuItem next() {
            Menu menu = this.receiver$0;
            int i2 = this.index;
            this.index = i2 + 1;
            MenuItem item = menu.getItem(i2);
            if (item != null) {
                return item;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@i.c.a.d Menu menu, @i.c.a.d MenuItem menuItem) {
        i0.f(menu, "$receiver");
        i0.f(menuItem, "item");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i0.a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@i.c.a.d Menu menu, @i.c.a.d l<? super MenuItem, y1> lVar) {
        i0.f(menu, "$receiver");
        i0.f(lVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            i0.a((Object) item, "getItem(index)");
            lVar.invoke(item);
        }
    }

    public static final void forEachIndexed(@i.c.a.d Menu menu, @i.c.a.d p<? super Integer, ? super MenuItem, y1> pVar) {
        i0.f(menu, "$receiver");
        i0.f(pVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            Integer numValueOf = Integer.valueOf(i2);
            MenuItem item = menu.getItem(i2);
            i0.a((Object) item, "getItem(index)");
            pVar.invoke(numValueOf, item);
        }
    }

    @i.c.a.d
    public static final MenuItem get(@i.c.a.d Menu menu, int i2) {
        i0.f(menu, "$receiver");
        MenuItem item = menu.getItem(i2);
        i0.a((Object) item, "getItem(index)");
        return item;
    }

    @i.c.a.d
    public static final m<MenuItem> getChildren(@i.c.a.d final Menu menu) {
        i0.f(menu, "$receiver");
        return new m<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // h.x2.m
            @i.c.a.d
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(@i.c.a.d Menu menu) {
        i0.f(menu, "$receiver");
        return menu.size();
    }

    public static final boolean isEmpty(@i.c.a.d Menu menu) {
        i0.f(menu, "$receiver");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@i.c.a.d Menu menu) {
        i0.f(menu, "$receiver");
        return menu.size() != 0;
    }

    @i.c.a.d
    public static final Iterator<MenuItem> iterator(@i.c.a.d Menu menu) {
        i0.f(menu, "$receiver");
        return new AnonymousClass1(menu);
    }

    public static final void minusAssign(@i.c.a.d Menu menu, @i.c.a.d MenuItem menuItem) {
        i0.f(menu, "$receiver");
        i0.f(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
