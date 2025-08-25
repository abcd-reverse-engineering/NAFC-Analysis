package com.lxj.easyadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import h.e1;
import h.q2.t.i0;
import h.q2.t.v;
import h.y;
import i.c.a.d;

/* compiled from: ViewHolder.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/lxj/easyadapter/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "convertView", "Landroid/view/View;", "(Landroid/view/View;)V", "getConvertView", "()Landroid/view/View;", "mViews", "Landroid/util/SparseArray;", "getView", ExifInterface.GPS_DIRECTION_TRUE, "viewId", "", "(I)Landroid/view/View;", "setImageResource", "resId", "setText", "text", "", "Companion", "easy-adapter_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes.dex */
public final class ViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: c, reason: collision with root package name */
    public static final a f7886c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<View> f7887a;

    /* renamed from: b, reason: collision with root package name */
    @d
    private final View f7888b;

    /* compiled from: ViewHolder.kt */
    public static final class a {
        private a() {
        }

        @d
        public final ViewHolder a(@d View view) {
            i0.f(view, "itemView");
            return new ViewHolder(view);
        }

        public /* synthetic */ a(v vVar) {
            this();
        }

        @d
        public final ViewHolder a(@d Context context, @d ViewGroup viewGroup, int i2) {
            i0.f(context, com.umeng.analytics.pro.d.R);
            i0.f(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(context).inflate(i2, viewGroup, false);
            i0.a((Object) viewInflate, "itemView");
            return new ViewHolder(viewInflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolder(@d View view) {
        super(view);
        i0.f(view, "convertView");
        this.f7888b = view;
        this.f7887a = new SparseArray<>();
    }

    @d
    public final View a() {
        return this.f7888b;
    }

    @d
    public final <T extends View> T a(int i2) {
        T t = (T) this.f7887a.get(i2);
        if (t == null) {
            t = (T) this.f7888b.findViewById(i2);
            this.f7887a.put(i2, t);
        }
        if (t != null) {
            return t;
        }
        throw new e1("null cannot be cast to non-null type T");
    }

    @d
    public final ViewHolder a(int i2, @d CharSequence charSequence) {
        i0.f(charSequence, "text");
        ((TextView) a(i2)).setText(charSequence);
        return this;
    }

    @d
    public final ViewHolder a(int i2, int i3) {
        ((ImageView) a(i2)).setImageResource(i3);
        return this;
    }
}
