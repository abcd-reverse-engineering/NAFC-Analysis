package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.bh;
import h.e1;
import h.q2.t.g1;
import h.q2.t.i0;
import java.util.ArrayList;
import java.util.Iterator;
import ui.Hicore;
import ui.activity.SearchAppActivity;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;

/* compiled from: AppSearchPresenter.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0018\u0019B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010\u0015\u001a\u00020\u00122\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\nR\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lui/presenter/AppSearchPresenter;", "Lui/model/ModelPresent;", "Lui/basemvp/BaseView;", "Landroid/widget/Filterable;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "itemAdapter", "Lui/presenter/AppSearchPresenter$RyListAdapte;", "mOnItemClickListener", "Lui/presenter/AppSearchPresenter$OnItemClickListener;", "phoneAllApps", "Ljava/util/ArrayList;", "Lbean/AppInfoBean;", "Lkotlin/collections/ArrayList;", "getFilter", "Landroid/widget/Filter;", "initRecycleCoins", "", "mViewRecycle", "Landroidx/recyclerview/widget/RecyclerView;", "setListData", "setOnItemClickListener", "onItemClickListener", "OnItemClickListener", "RyListAdapte", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class AppSearchPresenter extends ModelPresent<BaseView> implements Filterable {
    private RyListAdapte itemAdapter;
    private a mOnItemClickListener;
    private ArrayList<AppInfoBean> phoneAllApps;

    /* compiled from: AppSearchPresenter.kt */
    @h.y(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0016J \u0010\r\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lui/presenter/AppSearchPresenter$RyListAdapte;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lui/presenter/AppSearchPresenter$RyListAdapte$ListHolder;", "Lui/presenter/AppSearchPresenter;", com.umeng.analytics.pro.d.R, "Landroid/content/Context;", "(Lui/presenter/AppSearchPresenter;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListHolder", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
    public final class RyListAdapte extends RecyclerView.Adapter<ListHolder> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f19779a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppSearchPresenter f19780b;

        /* compiled from: AppSearchPresenter.kt */
        @h.y(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001a"}, d2 = {"Lui/presenter/AppSearchPresenter$RyListAdapte$ListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lui/presenter/AppSearchPresenter$RyListAdapte;Landroid/view/View;)V", "appIv", "Landroid/widget/ImageView;", "getAppIv", "()Landroid/widget/ImageView;", "setAppIv", "(Landroid/widget/ImageView;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "setAppName", "(Landroid/widget/TextView;)V", "appVersion", "getAppVersion", "setAppVersion", "checkImg", "getCheckImg", "setCheckImg", "checkImg2", "getCheckImg2", "setCheckImg2", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
        public final class ListHolder extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            @i.c.a.d
            private ImageView f19781a;

            /* renamed from: b, reason: collision with root package name */
            @i.c.a.d
            private TextView f19782b;

            /* renamed from: c, reason: collision with root package name */
            @i.c.a.d
            private TextView f19783c;

            /* renamed from: d, reason: collision with root package name */
            @i.c.a.d
            private ImageView f19784d;

            /* renamed from: e, reason: collision with root package name */
            @i.c.a.d
            private ImageView f19785e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ RyListAdapte f19786f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ListHolder(@i.c.a.d RyListAdapte ryListAdapte, View view) {
                super(view);
                i0.f(view, "itemView");
                this.f19786f = ryListAdapte;
                View viewFindViewById = view.findViewById(R.id.app_icon);
                i0.a((Object) viewFindViewById, "itemView.findViewById(R.id.app_icon)");
                this.f19781a = (ImageView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R.id.tv_app_name);
                i0.a((Object) viewFindViewById2, "itemView.findViewById(R.id.tv_app_name)");
                this.f19782b = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(R.id.tv_app_version);
                i0.a((Object) viewFindViewById3, "itemView.findViewById(R.id.tv_app_version)");
                this.f19783c = (TextView) viewFindViewById3;
                View viewFindViewById4 = view.findViewById(R.id.iv_checkbox);
                i0.a((Object) viewFindViewById4, "itemView.findViewById(R.id.iv_checkbox)");
                this.f19784d = (ImageView) viewFindViewById4;
                View viewFindViewById5 = view.findViewById(R.id.iv_checkbox2);
                i0.a((Object) viewFindViewById5, "itemView.findViewById(R.id.iv_checkbox2)");
                this.f19785e = (ImageView) viewFindViewById5;
            }

            @i.c.a.d
            public final ImageView a() {
                return this.f19781a;
            }

            @i.c.a.d
            public final TextView b() {
                return this.f19782b;
            }

            @i.c.a.d
            public final TextView c() {
                return this.f19783c;
            }

            @i.c.a.d
            public final ImageView d() {
                return this.f19784d;
            }

            @i.c.a.d
            public final ImageView e() {
                return this.f19785e;
            }

            public final void a(@i.c.a.d ImageView imageView) {
                i0.f(imageView, "<set-?>");
                this.f19781a = imageView;
            }

            public final void b(@i.c.a.d TextView textView) {
                i0.f(textView, "<set-?>");
                this.f19783c = textView;
            }

            public final void c(@i.c.a.d ImageView imageView) {
                i0.f(imageView, "<set-?>");
                this.f19785e = imageView;
            }

            public final void a(@i.c.a.d TextView textView) {
                i0.f(textView, "<set-?>");
                this.f19782b = textView;
            }

            public final void b(@i.c.a.d ImageView imageView) {
                i0.f(imageView, "<set-?>");
                this.f19784d = imageView;
            }
        }

        /* compiled from: AppSearchPresenter.kt */
        static final class a implements View.OnClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ g1.h f19788b;

            a(g1.h hVar) {
                this.f19788b = hVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a aVar;
                if (RyListAdapte.this.f19780b.mOnItemClickListener == null || (aVar = RyListAdapte.this.f19780b.mOnItemClickListener) == null) {
                    return;
                }
                aVar.a((AppInfoBean) this.f19788b.element);
            }
        }

        public RyListAdapte(@i.c.a.d AppSearchPresenter appSearchPresenter, Context context) {
            i0.f(context, com.umeng.analytics.pro.d.R);
            this.f19780b = appSearchPresenter;
            this.f19779a = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v2, types: [T, bean.AppInfoBean] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@i.c.a.d ListHolder listHolder, int i2) {
            i0.f(listHolder, "holder");
            if (this.f19780b.phoneAllApps.size() > 0) {
                g1.h hVar = new g1.h();
                Object obj = this.f19780b.phoneAllApps.get(i2);
                i0.a(obj, "phoneAllApps.get(position)");
                hVar.element = (AppInfoBean) obj;
                T t = hVar.element;
                if (((AppInfoBean) t) != null) {
                    Drawable appIcon = ((AppInfoBean) t).getAppIcon();
                    if (appIcon != null) {
                        listHolder.a().setImageDrawable(appIcon);
                    }
                    listHolder.b().setText(((AppInfoBean) hVar.element).getName());
                    String fileSize = Formatter.formatFileSize(Hicore.getApp(), ((AppInfoBean) hVar.element).getFileSize());
                    listHolder.c().setText("版本:" + ((AppInfoBean) hVar.element).getVersionCode() + "  |  " + fileSize);
                    if (((AppInfoBean) hVar.element).getFileSize() > 209715200) {
                        listHolder.d().setVisibility(8);
                        listHolder.e().setVisibility(0);
                    } else if (((AppInfoBean) hVar.element).isSelect()) {
                        listHolder.d().setImageResource(R.mipmap.checkbox_checked);
                        listHolder.d().setVisibility(0);
                        listHolder.e().setVisibility(8);
                    } else {
                        listHolder.d().setImageResource(R.mipmap.checkbox_unchecked);
                        listHolder.d().setVisibility(0);
                        listHolder.e().setVisibility(8);
                    }
                    listHolder.itemView.setOnClickListener(new a(hVar));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f19780b.phoneAllApps.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @i.c.a.d
        public ListHolder onCreateViewHolder(@i.c.a.d ViewGroup viewGroup, int i2) {
            i0.f(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(this.f19779a).inflate(R.layout.recyclerview_app_select, viewGroup, false);
            i0.a((Object) viewInflate, "LayoutInflater.from(cont…pp_select, parent, false)");
            return new ListHolder(this, viewInflate);
        }
    }

    /* compiled from: AppSearchPresenter.kt */
    public interface a {
        void a(@i.c.a.d AppInfoBean appInfoBean);
    }

    /* compiled from: AppSearchPresenter.kt */
    public static final class b extends Filter {
        b() {
        }

        @Override // android.widget.Filter
        @i.c.a.d
        protected Filter.FilterResults performFiltering(@i.c.a.d CharSequence charSequence) {
            i0.f(charSequence, bh.aE);
            String string = charSequence.toString();
            if (string == null) {
                throw new e1("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = string.toUpperCase();
            i0.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
            Filter.FilterResults filterResults = new Filter.FilterResults();
            ArrayList arrayList = new ArrayList();
            if (SearchAppActivity.f18868f.a() != null) {
                ArrayList<AppInfoBean> arrayListA = SearchAppActivity.f18868f.a();
                if ((arrayListA != null ? Integer.valueOf(arrayListA.size()) : null).intValue() > 0) {
                    Iterator<AppInfoBean> it = SearchAppActivity.f18868f.a().iterator();
                    while (it.hasNext()) {
                        AppInfoBean next = it.next();
                        i0.a((Object) next, Constants.JumpUrlConstants.SRC_TYPE_APP);
                        String name = next.getName();
                        i0.a((Object) name, "app.name");
                        if (h.z2.c0.c((CharSequence) name, (CharSequence) upperCase, false, 2, (Object) null)) {
                            arrayList.add(next);
                        }
                    }
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(@i.c.a.d CharSequence charSequence, @i.c.a.d Filter.FilterResults filterResults) {
            i0.f(charSequence, "constraint");
            i0.f(filterResults, "results");
            try {
                AppSearchPresenter appSearchPresenter = AppSearchPresenter.this;
                Object obj = filterResults.values;
                if (obj == null) {
                    throw new e1("null cannot be cast to non-null type kotlin.collections.ArrayList<bean.AppInfoBean> /* = java.util.ArrayList<bean.AppInfoBean> */");
                }
                appSearchPresenter.phoneAllApps = (ArrayList) obj;
                RyListAdapte ryListAdapte = AppSearchPresenter.this.itemAdapter;
                if (ryListAdapte != null) {
                    ryListAdapte.notifyDataSetChanged();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSearchPresenter(@i.c.a.d Activity activity) {
        super(activity, (BaseView) null);
        i0.f(activity, "activity");
        this.phoneAllApps = new ArrayList<>();
    }

    @Override // android.widget.Filterable
    @i.c.a.d
    public Filter getFilter() {
        return new b();
    }

    public final void initRecycleCoins(@i.c.a.d RecyclerView recyclerView) {
        i0.f(recyclerView, "mViewRecycle");
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        Activity activity = this.mActivity;
        i0.a((Object) activity, "mActivity");
        this.itemAdapter = new RyListAdapte(this, activity);
        recyclerView.setAdapter(this.itemAdapter);
    }

    public final void setListData(@i.c.a.d ArrayList<AppInfoBean> arrayList) {
        i0.f(arrayList, "phoneAllApps");
        this.phoneAllApps = arrayList;
        RyListAdapte ryListAdapte = this.itemAdapter;
        if (ryListAdapte != null) {
            ryListAdapte.notifyDataSetChanged();
        }
    }

    public final void setOnItemClickListener(@i.c.a.d a aVar) {
        i0.f(aVar, "onItemClickListener");
        this.mOnItemClickListener = aVar;
    }
}
