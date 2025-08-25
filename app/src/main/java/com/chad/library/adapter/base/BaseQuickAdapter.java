package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;
    protected static final String Q = "BaseQuickAdapter";
    public static final int R = 273;
    public static final int S = 546;
    public static final int T = 819;
    public static final int U = 1365;
    protected List<T> A;
    private RecyclerView B;
    private boolean C;
    private boolean D;
    private o E;
    private int F;
    private boolean G;
    private boolean H;
    private n I;
    private com.chad.library.adapter.base.d.a<T> J;
    private int K;

    /* renamed from: a, reason: collision with root package name */
    private boolean f5412a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5413b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5414c;

    /* renamed from: d, reason: collision with root package name */
    private com.chad.library.adapter.base.c.a f5415d;

    /* renamed from: e, reason: collision with root package name */
    private m f5416e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5417f;

    /* renamed from: g, reason: collision with root package name */
    private k f5418g;

    /* renamed from: h, reason: collision with root package name */
    private l f5419h;

    /* renamed from: i, reason: collision with root package name */
    private i f5420i;

    /* renamed from: j, reason: collision with root package name */
    private j f5421j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5422k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5423l;

    /* renamed from: m, reason: collision with root package name */
    private Interpolator f5424m;
    private int n;
    private int o;
    private com.chad.library.adapter.base.a.b p;
    private com.chad.library.adapter.base.a.b q;
    private LinearLayout r;
    private LinearLayout s;
    private FrameLayout t;
    private boolean u;
    private boolean v;
    private boolean w;
    protected Context x;
    protected int y;
    protected LayoutInflater z;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f5425a;

        a(LinearLayoutManager linearLayoutManager) {
            this.f5425a = linearLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5425a.findLastCompletelyVisibleItemPosition() + 1 != BaseQuickAdapter.this.getItemCount()) {
                BaseQuickAdapter.this.e(true);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StaggeredGridLayoutManager f5427a;

        b(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f5427a = staggeredGridLayoutManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.f5427a.getSpanCount()];
            this.f5427a.findLastCompletelyVisibleItemPositions(iArr);
            if (BaseQuickAdapter.this.a(iArr) + 1 != BaseQuickAdapter.this.getItemCount()) {
                BaseQuickAdapter.this.e(true);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseQuickAdapter.this.f5415d.d() == 3) {
                BaseQuickAdapter.this.C();
            }
            if (BaseQuickAdapter.this.f5417f && BaseQuickAdapter.this.f5415d.d() == 4) {
                BaseQuickAdapter.this.C();
            }
        }
    }

    class d extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f5430a;

        d(GridLayoutManager gridLayoutManager) {
            this.f5430a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            int itemViewType = BaseQuickAdapter.this.getItemViewType(i2);
            if (itemViewType == 273 && BaseQuickAdapter.this.u()) {
                return 1;
            }
            if (itemViewType == 819 && BaseQuickAdapter.this.t()) {
                return 1;
            }
            if (BaseQuickAdapter.this.I != null) {
                return BaseQuickAdapter.this.d(itemViewType) ? this.f5430a.getSpanCount() : BaseQuickAdapter.this.I.a(this.f5430a, i2 - BaseQuickAdapter.this.j());
            }
            if (BaseQuickAdapter.this.d(itemViewType)) {
                return this.f5430a.getSpanCount();
            }
            return 1;
        }
    }

    class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f5432a;

        e(BaseViewHolder baseViewHolder) {
            this.f5432a = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseQuickAdapter.this.e(view, this.f5432a.getLayoutPosition() - BaseQuickAdapter.this.j());
        }
    }

    class f implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f5434a;

        f(BaseViewHolder baseViewHolder) {
            this.f5434a = baseViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return BaseQuickAdapter.this.f(view, this.f5434a.getLayoutPosition() - BaseQuickAdapter.this.j());
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseQuickAdapter.this.f5416e.a();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface h {
    }

    public interface i {
        void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface j {
        boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface k {
        void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface l {
        boolean a(BaseQuickAdapter baseQuickAdapter, View view, int i2);
    }

    public interface m {
        void a();
    }

    public interface n {
        int a(GridLayoutManager gridLayoutManager, int i2);
    }

    public interface o {
        void a();
    }

    public BaseQuickAdapter(@LayoutRes int i2, @Nullable List<T> list) {
        this.f5412a = false;
        this.f5413b = false;
        this.f5414c = false;
        this.f5415d = new com.chad.library.adapter.base.c.b();
        this.f5417f = false;
        this.f5422k = true;
        this.f5423l = false;
        this.f5424m = new LinearInterpolator();
        this.n = 300;
        this.o = -1;
        this.q = new com.chad.library.adapter.base.a.a();
        this.u = true;
        this.F = 1;
        this.K = 1;
        this.A = list == null ? new ArrayList<>() : list;
        if (i2 != 0) {
            this.y = i2;
        }
    }

    private void G() {
        if (s() == null) {
            throw new RuntimeException("please bind recyclerView first!");
        }
    }

    private int H() {
        int i2 = 1;
        if (e() != 1) {
            return j() + this.A.size();
        }
        if (this.v && j() != 0) {
            i2 = 2;
        }
        if (this.w) {
            return i2;
        }
        return -1;
    }

    private int I() {
        return (e() != 1 || this.v) ? 0 : -1;
    }

    private void n(int i2) {
        o oVar;
        if (!x() || y() || i2 > this.F || (oVar = this.E) == null) {
            return;
        }
        oVar.a();
    }

    private void o(int i2) {
        List<T> list = this.A;
        if ((list == null ? 0 : list.size()) == i2) {
            notifyDataSetChanged();
        }
    }

    private com.chad.library.adapter.base.b.b p(int i2) {
        T item = getItem(i2);
        if (c((BaseQuickAdapter<T, K>) item)) {
            return (com.chad.library.adapter.base.b.b) item;
        }
        return null;
    }

    private int q(@IntRange(from = 0) int i2) {
        T item = getItem(i2);
        int iQ = 0;
        if (!c((BaseQuickAdapter<T, K>) item)) {
            return 0;
        }
        com.chad.library.adapter.base.b.b bVar = (com.chad.library.adapter.base.b.b) item;
        if (bVar.isExpanded()) {
            List<T> listA = bVar.a();
            if (listA == null) {
                return 0;
            }
            for (int size = listA.size() - 1; size >= 0; size--) {
                T t = listA.get(size);
                int iD = d((BaseQuickAdapter<T, K>) t);
                if (iD >= 0) {
                    if (t instanceof com.chad.library.adapter.base.b.b) {
                        iQ += q(iD);
                    }
                    this.A.remove(iD);
                    iQ++;
                }
            }
        }
        return iQ;
    }

    public void A() {
        d(false);
    }

    public void B() {
        if (l() == 0) {
            return;
        }
        this.f5414c = false;
        this.f5415d.a(3);
        notifyItemChanged(m());
    }

    public void C() {
        if (this.f5415d.d() == 2) {
            return;
        }
        this.f5415d.a(1);
        notifyItemChanged(m());
    }

    public void D() {
        this.f5423l = true;
    }

    public void E() {
        if (g() == 0) {
            return;
        }
        this.s.removeAllViews();
        int iH = H();
        if (iH != -1) {
            notifyItemRemoved(iH);
        }
    }

    public void F() {
        if (j() == 0) {
            return;
        }
        this.r.removeAllViews();
        int I = I();
        if (I != -1) {
            notifyItemRemoved(I);
        }
    }

    protected abstract void a(K k2, T t);

    protected boolean d(int i2) {
        return i2 == 1365 || i2 == 273 || i2 == 819 || i2 == 546;
    }

    public void e(boolean z) {
        int iL = l();
        this.f5413b = z;
        int iL2 = l();
        if (iL == 1) {
            if (iL2 == 0) {
                notifyItemRemoved(m());
            }
        } else if (iL2 == 1) {
            this.f5415d.a(1);
            notifyItemInserted(m());
        }
    }

    public void f(@IntRange(from = 0) int i2) {
        this.A.remove(i2);
        int iJ = i2 + j();
        notifyItemRemoved(iJ);
        o(0);
        notifyItemRangeChanged(iJ, this.A.size() - iJ);
    }

    public int g() {
        LinearLayout linearLayout = this.s;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Nullable
    public T getItem(@IntRange(from = 0) int i2) {
        if (i2 < this.A.size()) {
            return this.A.get(i2);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i2 = 1;
        if (e() != 1) {
            return l() + j() + this.A.size() + g();
        }
        if (this.v && j() != 0) {
            i2 = 2;
        }
        return (!this.w || g() == 0) ? i2 : i2 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        if (e() == 1) {
            boolean z = this.v && j() != 0;
            if (i2 != 0) {
                return i2 != 1 ? i2 != 2 ? U : T : z ? U : T;
            }
            if (z) {
                return 273;
            }
            return U;
        }
        int iJ = j();
        if (i2 < iJ) {
            return 273;
        }
        int i3 = i2 - iJ;
        int size = this.A.size();
        return i3 < size ? c(i3) : i3 - size < g() ? T : S;
    }

    public void h(int i2) {
        this.n = i2;
    }

    public void i(boolean z) {
        this.C = z;
    }

    public void j(boolean z) {
        this.D = z;
    }

    @Deprecated
    public int k() {
        return j();
    }

    public void l(int i2) {
        this.F = i2;
    }

    public int m() {
        return j() + this.A.size() + g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new d(gridLayoutManager));
        }
    }

    public final l r() {
        return this.f5419h;
    }

    protected RecyclerView s() {
        return this.B;
    }

    public void setNewData(@Nullable List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.A = list;
        if (this.f5416e != null) {
            this.f5412a = true;
            this.f5413b = true;
            this.f5414c = false;
            this.f5415d.a(1);
        }
        this.o = -1;
        notifyDataSetChanged();
    }

    public void setOnItemChildClickListener(i iVar) {
        this.f5420i = iVar;
    }

    public void setOnItemChildLongClickListener(j jVar) {
        this.f5421j = jVar;
    }

    public void setOnItemClickListener(@Nullable k kVar) {
        this.f5418g = kVar;
    }

    public void setOnItemLongClickListener(l lVar) {
        this.f5419h = lVar;
    }

    public boolean t() {
        return this.H;
    }

    public boolean u() {
        return this.G;
    }

    public boolean v() {
        return this.f5413b;
    }

    public boolean w() {
        return this.f5414c;
    }

    public boolean x() {
        return this.C;
    }

    public boolean y() {
        return this.D;
    }

    public void z() {
        if (l() == 0) {
            return;
        }
        this.f5414c = false;
        this.f5412a = true;
        this.f5415d.a(1);
        notifyItemChanged(m());
    }

    private void b(m mVar) {
        this.f5416e = mVar;
        this.f5412a = true;
        this.f5413b = true;
        this.f5414c = false;
    }

    private void c(RecyclerView recyclerView) {
        this.B = recyclerView;
    }

    private void m(int i2) {
        if (l() != 0 && i2 >= getItemCount() - this.K && this.f5415d.d() == 1) {
            this.f5415d.a(2);
            if (this.f5414c) {
                return;
            }
            this.f5414c = true;
            if (s() != null) {
                s().post(new g());
            } else {
                this.f5416e.a();
            }
        }
    }

    public void d(boolean z) {
        if (l() == 0) {
            return;
        }
        this.f5414c = false;
        this.f5412a = false;
        this.f5415d.a(z);
        if (z) {
            notifyItemRemoved(m());
        } else {
            this.f5415d.a(4);
            notifyItemChanged(m());
        }
    }

    public int g(View view) {
        return c(view, 0, 1);
    }

    @Deprecated
    public int h() {
        return g();
    }

    public LinearLayout i() {
        return this.r;
    }

    public void j(int i2) {
        this.o = i2;
    }

    public void k(int i2) {
        if (i2 > 1) {
            this.K = i2;
        }
    }

    public int l() {
        if (this.f5416e == null || !this.f5413b) {
            return 0;
        }
        return ((this.f5412a || !this.f5415d.g()) && this.A.size() != 0) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(ViewGroup viewGroup, int i2) {
        K k2;
        this.x = viewGroup.getContext();
        this.z = LayoutInflater.from(this.x);
        if (i2 == 273) {
            k2 = (K) c((View) this.r);
        } else if (i2 == 546) {
            k2 = (K) a(viewGroup);
        } else if (i2 == 819) {
            k2 = (K) c((View) this.s);
        } else if (i2 != 1365) {
            k2 = (K) b(viewGroup, i2);
            b((BaseViewHolder) k2);
        } else {
            k2 = (K) c((View) this.t);
        }
        k2.a(this);
        return k2;
    }

    public void a(RecyclerView recyclerView) {
        if (s() == null) {
            c(recyclerView);
            s().setAdapter(this);
            return;
        }
        throw new RuntimeException("Don't bind twice");
    }

    public void c(@IntRange(from = 0) int i2, @NonNull T t) {
        this.A.set(i2, t);
        notifyItemChanged(i2 + j());
    }

    public void g(boolean z) {
        a(z, false);
    }

    public void h(boolean z) {
        this.G = z;
    }

    public void i(int i2) {
        G();
        b(i2, (ViewGroup) s());
    }

    public int j() {
        LinearLayout linearLayout = this.r;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Nullable
    public final i o() {
        return this.f5420i;
    }

    @Deprecated
    public void g(int i2) {
        k(i2);
    }

    public int h(View view) {
        return d(view, 0, 1);
    }

    public com.chad.library.adapter.base.d.a<T> n() {
        return this.J;
    }

    @Nullable
    public final j p() {
        return this.f5421j;
    }

    @NonNull
    public List<T> c() {
        return this.A;
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        e(false);
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerView.postDelayed(new a((LinearLayoutManager) layoutManager), 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            recyclerView.postDelayed(new b((StaggeredGridLayoutManager) layoutManager), 50L);
        }
    }

    protected int c(int i2) {
        com.chad.library.adapter.base.d.a<T> aVar = this.J;
        if (aVar != null) {
            return aVar.a(this.A, i2);
        }
        return super.getItemViewType(i2);
    }

    public void f(boolean z) {
        this.H = z;
    }

    @Deprecated
    public void a(m mVar) {
        b(mVar);
    }

    public int e() {
        FrameLayout frameLayout = this.t;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.u || this.A.size() != 0) ? 0 : 1;
    }

    public boolean f(View view, int i2) {
        return r().a(this, view, i2);
    }

    public void a(m mVar, RecyclerView recyclerView) {
        b(mVar);
        if (s() == null) {
            c(recyclerView);
        }
    }

    public LinearLayout f() {
        return this.s;
    }

    protected K c(View view) {
        K k2;
        Class clsA = null;
        for (Class<?> superclass = getClass(); clsA == null && superclass != null; superclass = superclass.getSuperclass()) {
            clsA = a((Class) superclass);
        }
        if (clsA == null) {
            k2 = (K) new BaseViewHolder(view);
        } else {
            k2 = (K) a(clsA, view);
        }
        return k2 != null ? k2 : (K) new BaseViewHolder(view);
    }

    public int d(View view, int i2) {
        return d(view, i2, 1);
    }

    public void f(View view) {
        boolean z;
        int i2 = 0;
        if (this.t == null) {
            this.t = new FrameLayout(view.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = layoutParams2.width;
                ((ViewGroup.MarginLayoutParams) layoutParams).height = layoutParams2.height;
            }
            this.t.setLayoutParams(layoutParams);
            z = true;
        } else {
            z = false;
        }
        this.t.removeAllViews();
        this.t.addView(view);
        this.u = true;
        if (z && e() == 1) {
            if (this.v && j() != 0) {
                i2 = 1;
            }
            notifyItemInserted(i2);
        }
    }

    public int d(View view, int i2, int i3) {
        LinearLayout linearLayout = this.r;
        if (linearLayout != null && linearLayout.getChildCount() > i2) {
            this.r.removeViewAt(i2);
            this.r.addView(view, i2);
            return i2;
        }
        return b(view, i2, i3);
    }

    public void e(View view, int i2) {
        q().onItemClick(this, view, i2);
    }

    public void a() {
        G();
        b(s());
    }

    public void e(View view) {
        int I;
        if (j() == 0) {
            return;
        }
        this.r.removeView(view);
        if (this.r.getChildCount() != 0 || (I = I()) == -1) {
            return;
        }
        notifyItemRemoved(I);
    }

    public final k q() {
        return this.f5418g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int[] iArr) {
        int i2 = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    public void b(@IntRange(from = 0) int i2, @NonNull T t) {
        this.A.add(i2, t);
        notifyItemInserted(i2 + j());
        o(1);
    }

    public void d(View view) {
        int iH;
        if (g() == 0) {
            return;
        }
        this.s.removeView(view);
        if (this.s.getChildCount() != 0 || (iH = H()) == -1) {
            return;
        }
        notifyItemRemoved(iH);
    }

    public void a(o oVar) {
        this.E = oVar;
    }

    public int c(View view, int i2) {
        return c(view, i2, 1);
    }

    public void a(com.chad.library.adapter.base.c.a aVar) {
        this.f5415d = aVar;
    }

    public int c(View view, int i2, int i3) {
        LinearLayout linearLayout = this.s;
        if (linearLayout != null && linearLayout.getChildCount() > i2) {
            this.s.removeViewAt(i2);
            this.s.addView(view, i2);
            return i2;
        }
        return a(view, i2, i3);
    }

    public void e(int i2) {
        this.f5423l = true;
        this.p = null;
        if (i2 == 1) {
            this.q = new com.chad.library.adapter.base.a.a();
            return;
        }
        if (i2 == 2) {
            this.q = new com.chad.library.adapter.base.a.c();
            return;
        }
        if (i2 == 3) {
            this.q = new com.chad.library.adapter.base.a.d();
        } else if (i2 == 4) {
            this.q = new com.chad.library.adapter.base.a.e();
        } else {
            if (i2 != 5) {
                return;
            }
            this.q = new com.chad.library.adapter.base.a.f();
        }
    }

    @Deprecated
    public void a(@IntRange(from = 0) int i2, @NonNull T t) {
        b(i2, (int) t);
    }

    public void b(@NonNull Collection<? extends T> collection) {
        List<T> list = this.A;
        if (collection != list) {
            list.clear();
            this.A.addAll(collection);
        }
        notifyDataSetChanged();
    }

    public BaseQuickAdapter(@Nullable List<T> list) {
        this(0, list);
    }

    public void a(@NonNull T t) {
        this.A.add(t);
        notifyItemInserted(this.A.size() + j());
        o(1);
    }

    public BaseQuickAdapter(@LayoutRes int i2) {
        this(i2, null);
    }

    public View d() {
        return this.t;
    }

    private int d(T t) {
        List<T> list;
        if (t == null || (list = this.A) == null || list.isEmpty()) {
            return -1;
        }
        return this.A.indexOf(t);
    }

    public void c(boolean z) {
        this.u = z;
    }

    private void b(BaseViewHolder baseViewHolder) {
        View view;
        if (baseViewHolder == null || (view = baseViewHolder.itemView) == null) {
            return;
        }
        if (q() != null) {
            view.setOnClickListener(new e(baseViewHolder));
        }
        if (r() != null) {
            view.setOnLongClickListener(new f(baseViewHolder));
        }
    }

    public void a(@IntRange(from = 0) int i2, @NonNull Collection<? extends T> collection) {
        this.A.addAll(i2, collection);
        notifyItemRangeInserted(i2 + j(), collection.size());
        o(collection.size());
    }

    public int c(int i2, boolean z, boolean z2) {
        T item;
        int iJ = i2 - j();
        int i3 = iJ + 1;
        T item2 = i3 < this.A.size() ? getItem(i3) : null;
        com.chad.library.adapter.base.b.b bVarP = p(iJ);
        if (bVarP == null) {
            return 0;
        }
        if (!a(bVarP)) {
            bVarP.setExpanded(true);
            notifyItemChanged(iJ);
            return 0;
        }
        int iB = b(j() + iJ, false, false);
        while (i3 < this.A.size() && (item = getItem(i3)) != item2) {
            if (c((BaseQuickAdapter<T, K>) item)) {
                iB += b(j() + i3, false, false);
            }
            i3++;
        }
        if (z2) {
            if (z) {
                notifyItemRangeInserted(iJ + j() + 1, iB);
            } else {
                notifyDataSetChanged();
            }
        }
        return iB;
    }

    public void a(@NonNull Collection<? extends T> collection) {
        this.A.addAll(collection);
        notifyItemRangeInserted((this.A.size() - collection.size()) + j(), collection.size());
        o(collection.size());
    }

    protected K b(ViewGroup viewGroup, int i2) {
        int iA = this.y;
        com.chad.library.adapter.base.d.a<T> aVar = this.J;
        if (aVar != null) {
            iA = aVar.a(i2);
        }
        return (K) a(viewGroup, iA);
    }

    private K a(ViewGroup viewGroup) {
        K k2 = (K) c(a(this.f5415d.a(), viewGroup));
        k2.itemView.setOnClickListener(new c());
        return k2;
    }

    public void a(boolean z) {
        this.f5417f = z;
    }

    public int b(View view) {
        return b(view, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(K k2) {
        super.onViewAttachedToWindow(k2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType != 1365 && itemViewType != 273 && itemViewType != 819 && itemViewType != 546) {
            b((RecyclerView.ViewHolder) k2);
        } else {
            a((RecyclerView.ViewHolder) k2);
        }
    }

    public int b(View view, int i2) {
        return b(view, i2, 1);
    }

    public int b(View view, int i2, int i3) {
        int I;
        if (this.r == null) {
            this.r = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.r.setOrientation(1);
                this.r.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.r.setOrientation(0);
                this.r.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.r.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.r.addView(view, i2);
        if (this.r.getChildCount() == 1 && (I = I()) != -1) {
            notifyItemInserted(I);
        }
        return i2;
    }

    protected void a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
        }
    }

    public int c(int i2, boolean z) {
        return c(i2, true, !z);
    }

    public boolean c(T t) {
        return t != null && (t instanceof com.chad.library.adapter.base.b.b);
    }

    public void a(n nVar) {
        this.I = nVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(K k2, int i2) {
        n(i2);
        m(i2);
        int itemViewType = k2.getItemViewType();
        if (itemViewType == 0) {
            a((BaseQuickAdapter<T, K>) k2, (K) getItem(i2 - j()));
            return;
        }
        if (itemViewType != 273) {
            if (itemViewType == 546) {
                this.f5415d.a(k2);
            } else {
                if (itemViewType == 819 || itemViewType == 1365) {
                    return;
                }
                a((BaseQuickAdapter<T, K>) k2, (K) getItem(i2 - j()));
            }
        }
    }

    public void b(int i2, ViewGroup viewGroup) {
        f(LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false));
    }

    private void b(RecyclerView.ViewHolder viewHolder) {
        if (this.f5423l) {
            if (!this.f5422k || viewHolder.getLayoutPosition() > this.o) {
                com.chad.library.adapter.base.a.b bVar = this.p;
                if (bVar == null) {
                    bVar = this.q;
                }
                for (Animator animator : bVar.a(viewHolder.itemView)) {
                    a(animator, viewHolder.getLayoutPosition());
                }
                this.o = viewHolder.getLayoutPosition();
            }
        }
    }

    public void a(com.chad.library.adapter.base.d.a<T> aVar) {
        this.J = aVar;
    }

    protected K a(ViewGroup viewGroup, int i2) {
        return (K) c(a(i2, viewGroup));
    }

    private K a(Class cls, View view) throws NoSuchMethodException, SecurityException {
        try {
            if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(getClass(), View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(this, view);
            }
            Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(view);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public void b(boolean z) {
        this.f5422k = z;
    }

    public int b(@IntRange(from = 0) int i2, boolean z, boolean z2) {
        int iJ = i2 - j();
        com.chad.library.adapter.base.b.b bVarP = p(iJ);
        int iA = 0;
        if (bVarP == null) {
            return 0;
        }
        if (!a(bVarP)) {
            bVarP.setExpanded(true);
            notifyItemChanged(iJ);
            return 0;
        }
        if (!bVarP.isExpanded()) {
            List<T> listA = bVarP.a();
            int i3 = iJ + 1;
            this.A.addAll(i3, listA);
            iA = 0 + a(i3, (List) listA);
            bVarP.setExpanded(true);
        }
        int iJ2 = iJ + j();
        if (z2) {
            if (z) {
                notifyItemChanged(iJ2);
                notifyItemRangeInserted(iJ2 + 1, iA);
            } else {
                notifyDataSetChanged();
            }
        }
        return iA;
    }

    private Class a(Class cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (BaseViewHolder.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            } else if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                if (rawType instanceof Class) {
                    Class cls3 = (Class) rawType;
                    if (BaseViewHolder.class.isAssignableFrom(cls3)) {
                        return cls3;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
        return null;
    }

    public int b(@IntRange(from = 0) int i2, boolean z) {
        return b(i2, z, true);
    }

    public int b(@IntRange(from = 0) int i2) {
        return b(i2, true, true);
    }

    public int a(View view) {
        return a(view, -1, 1);
    }

    public void b() {
        for (int size = (this.A.size() - 1) + j(); size >= j(); size--) {
            c(size, false, false);
        }
    }

    public int a(View view, int i2) {
        return a(view, i2, 1);
    }

    public int a(View view, int i2, int i3) {
        int iH;
        if (this.s == null) {
            this.s = new LinearLayout(view.getContext());
            if (i3 == 1) {
                this.s.setOrientation(1);
                this.s.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                this.s.setOrientation(0);
                this.s.setLayoutParams(new RecyclerView.LayoutParams(-2, -1));
            }
        }
        int childCount = this.s.getChildCount();
        if (i2 < 0 || i2 > childCount) {
            i2 = childCount;
        }
        this.s.addView(view, i2);
        if (this.s.getChildCount() == 1 && (iH = H()) != -1) {
            notifyItemInserted(iH);
        }
        return i2;
    }

    public int b(@NonNull T t) {
        int iD = d((BaseQuickAdapter<T, K>) t);
        if (iD == -1) {
            return -1;
        }
        int iB = t instanceof com.chad.library.adapter.base.b.b ? ((com.chad.library.adapter.base.b.b) t).b() : Integer.MAX_VALUE;
        if (iB == 0) {
            return iD;
        }
        if (iB == -1) {
            return -1;
        }
        while (iD >= 0) {
            T t2 = this.A.get(iD);
            if (t2 instanceof com.chad.library.adapter.base.b.b) {
                com.chad.library.adapter.base.b.b bVar = (com.chad.library.adapter.base.b.b) t2;
                if (bVar.b() >= 0 && bVar.b() < iB) {
                    return iD;
                }
            }
            iD--;
        }
        return -1;
    }

    public void a(boolean z, boolean z2) {
        this.v = z;
        this.w = z2;
    }

    protected void a(Animator animator, int i2) {
        animator.setDuration(this.n).start();
        animator.setInterpolator(this.f5424m);
    }

    protected View a(@LayoutRes int i2, ViewGroup viewGroup) {
        return this.z.inflate(i2, viewGroup, false);
    }

    public void a(com.chad.library.adapter.base.a.b bVar) {
        this.f5423l = true;
        this.p = bVar;
    }

    @Nullable
    public View a(int i2, @IdRes int i3) {
        G();
        return a(s(), i2, i3);
    }

    @Nullable
    public View a(RecyclerView recyclerView, int i2, @IdRes int i3) {
        BaseViewHolder baseViewHolder;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i2)) == null) {
            return null;
        }
        return baseViewHolder.c(i3);
    }

    private int a(int i2, @NonNull List list) {
        int size = list.size();
        int size2 = (i2 + list.size()) - 1;
        int size3 = list.size() - 1;
        while (size3 >= 0) {
            if (list.get(size3) instanceof com.chad.library.adapter.base.b.b) {
                com.chad.library.adapter.base.b.b bVar = (com.chad.library.adapter.base.b.b) list.get(size3);
                if (bVar.isExpanded() && a(bVar)) {
                    List<T> listA = bVar.a();
                    int i3 = size2 + 1;
                    this.A.addAll(i3, listA);
                    size += a(i3, (List) listA);
                }
            }
            size3--;
            size2--;
        }
        return size;
    }

    public int a(@IntRange(from = 0) int i2, boolean z, boolean z2) {
        int iJ = i2 - j();
        com.chad.library.adapter.base.b.b bVarP = p(iJ);
        if (bVarP == null) {
            return 0;
        }
        int iQ = q(iJ);
        bVarP.setExpanded(false);
        int iJ2 = iJ + j();
        if (z2) {
            if (z) {
                notifyItemChanged(iJ2);
                notifyItemRangeRemoved(iJ2 + 1, iQ);
            } else {
                notifyDataSetChanged();
            }
        }
        return iQ;
    }

    public int a(@IntRange(from = 0) int i2) {
        return a(i2, true, true);
    }

    public int a(@IntRange(from = 0) int i2, boolean z) {
        return a(i2, z, true);
    }

    private boolean a(com.chad.library.adapter.base.b.b bVar) {
        List<T> listA;
        return (bVar == null || (listA = bVar.a()) == null || listA.size() <= 0) ? false : true;
    }
}
