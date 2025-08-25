package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
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

/* compiled from: ViewGroup.kt */
@y(bv = {1, 0, 2}, d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010\u001d\u001a\u00020\u000e*\u00020\u001e2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0086\b\u001a5\u0010\u001f\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010 \u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010\"\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0086\b\u001a5\u0010$\u001a\u00020\u000e*\u00020\u001e2\b\b\u0003\u0010%\u001a\u00020\u00072\b\b\u0003\u0010!\u001a\u00020\u00072\b\b\u0003\u0010&\u001a\u00020\u00072\b\b\u0003\u0010#\u001a\u00020\u0007H\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, d2 = {ChildrenInfo.o, "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class ViewGroupKt {

    /* compiled from: ViewGroup.kt */
    @y(bv = {1, 0, 2}, d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\t\u0010\b\u001a\u00020\u0002H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "(Landroid/view/ViewGroup;)V", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 1, 10})
    /* renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<View>, d {
        private int index;
        final /* synthetic */ ViewGroup receiver$0;

        AnonymousClass1(ViewGroup viewGroup) {
            this.receiver$0 = viewGroup;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.receiver$0.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.index--;
            this.receiver$0.removeViewAt(this.index);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @i.c.a.d
        public View next() {
            ViewGroup viewGroup = this.receiver$0;
            int i2 = this.index;
            this.index = i2 + 1;
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@i.c.a.d ViewGroup viewGroup, @i.c.a.d View view) {
        i0.f(viewGroup, "$receiver");
        i0.f(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(@i.c.a.d ViewGroup viewGroup, @i.c.a.d l<? super View, y1> lVar) {
        i0.f(viewGroup, "$receiver");
        i0.f(lVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            i0.a((Object) childAt, "getChildAt(index)");
            lVar.invoke(childAt);
        }
    }

    public static final void forEachIndexed(@i.c.a.d ViewGroup viewGroup, @i.c.a.d p<? super Integer, ? super View, y1> pVar) {
        i0.f(viewGroup, "$receiver");
        i0.f(pVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Integer numValueOf = Integer.valueOf(i2);
            View childAt = viewGroup.getChildAt(i2);
            i0.a((Object) childAt, "getChildAt(index)");
            pVar.invoke(numValueOf, childAt);
        }
    }

    @i.c.a.d
    public static final View get(@i.c.a.d ViewGroup viewGroup, int i2) {
        i0.f(viewGroup, "$receiver");
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    @i.c.a.d
    public static final m<View> getChildren(@i.c.a.d final ViewGroup viewGroup) {
        i0.f(viewGroup, "$receiver");
        return new m<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // h.x2.m
            @i.c.a.d
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final int getSize(@i.c.a.d ViewGroup viewGroup) {
        i0.f(viewGroup, "$receiver");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(@i.c.a.d ViewGroup viewGroup) {
        i0.f(viewGroup, "$receiver");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(@i.c.a.d ViewGroup viewGroup) {
        i0.f(viewGroup, "$receiver");
        return viewGroup.getChildCount() != 0;
    }

    @i.c.a.d
    public static final Iterator<View> iterator(@i.c.a.d ViewGroup viewGroup) {
        i0.f(viewGroup, "$receiver");
        return new AnonymousClass1(viewGroup);
    }

    public static final void minusAssign(@i.c.a.d ViewGroup viewGroup, @i.c.a.d View view) {
        i0.f(viewGroup, "$receiver");
        i0.f(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(@i.c.a.d ViewGroup viewGroup, @i.c.a.d View view) {
        i0.f(viewGroup, "$receiver");
        i0.f(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(@i.c.a.d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        i0.f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(@i.c.a.d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        i0.f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* bridge */ /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        i0.f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@i.c.a.d ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        i0.f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    @RequiresApi(17)
    public static /* bridge */ /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        i0.f(marginLayoutParams, "$receiver");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
