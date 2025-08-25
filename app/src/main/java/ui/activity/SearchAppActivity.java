package ui.activity;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import bean.AppInfoBean;
import com.hicorenational.antifraud.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import ui.presenter.AppSearchPresenter;
import ui.view.swip.SwipBackLayout;

/* compiled from: SearchAppActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lui/activity/SearchAppActivity;", "Lui/activity/BaseActivity;", "Landroid/view/View$OnClickListener;", "Lui/presenter/AppSearchPresenter$OnItemClickListener;", "()V", "mEtSearch", "Landroid/widget/EditText;", "mIvBack", "Landroid/widget/ImageView;", "mPresenter", "Lui/presenter/AppSearchPresenter;", "mRvAppList", "Landroidx/recyclerview/widget/RecyclerView;", "doAppCompare", "", "initListener", "initPage", "initView", "onClick", "view", "Landroid/view/View;", "onItemClickListener", "bean", "Lbean/AppInfoBean;", "setLayoutView", "", "Companion", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SearchAppActivity extends BaseActivity implements View.OnClickListener, AppSearchPresenter.a {

    /* renamed from: e, reason: collision with root package name */
    @i.c.a.d
    public static ArrayList<AppInfoBean> f18867e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f18868f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private ImageView f18869a;

    /* renamed from: b, reason: collision with root package name */
    private EditText f18870b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f18871c;

    /* renamed from: d, reason: collision with root package name */
    private AppSearchPresenter f18872d;

    /* compiled from: SearchAppActivity.kt */
    public static final class a {
        private a() {
        }

        @i.c.a.d
        public final ArrayList<AppInfoBean> a() {
            ArrayList<AppInfoBean> arrayList = SearchAppActivity.f18867e;
            if (arrayList == null) {
                h.q2.t.i0.k("phoneAllApps");
            }
            return arrayList;
        }

        public /* synthetic */ a(h.q2.t.v vVar) {
            this();
        }

        public final void a(@i.c.a.d ArrayList<AppInfoBean> arrayList) {
            h.q2.t.i0.f(arrayList, "<set-?>");
            SearchAppActivity.f18867e = arrayList;
        }
    }

    /* compiled from: SearchAppActivity.kt */
    static final class b<T> implements Comparator<AppInfoBean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Collator f18873a;

        b(Collator collator) {
            this.f18873a = collator;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(AppInfoBean appInfoBean, AppInfoBean appInfoBean2) {
            Collator collator = this.f18873a;
            h.q2.t.i0.a((Object) appInfoBean, "o1");
            String name = appInfoBean.getName();
            h.q2.t.i0.a((Object) appInfoBean2, "o2");
            return collator.compare(name, appInfoBean2.getName());
        }
    }

    /* compiled from: SearchAppActivity.kt */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@i.c.a.e Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@i.c.a.e CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@i.c.a.e CharSequence charSequence, int i2, int i3, int i4) {
            Filter filter;
            AppSearchPresenter appSearchPresenter = SearchAppActivity.this.f18872d;
            if (appSearchPresenter == null || (filter = appSearchPresenter.getFilter()) == null) {
                return;
            }
            filter.filter(String.valueOf(charSequence));
        }
    }

    public final void initListener() {
        ImageView imageView = this.f18869a;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        if (imageView == null) {
            h.q2.t.i0.f();
        }
        imageView.setOnClickListener(this);
        AppSearchPresenter appSearchPresenter = this.f18872d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setOnItemClickListener(this);
        }
        EditText editText = this.f18870b;
        if (editText == null) {
            h.q2.t.i0.k("mEtSearch");
        }
        editText.addTextChangedListener(new c());
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        ui.statusbarcompat.b.a((Activity) this, true, true);
        SwipBackLayout.a(this.mActivity).a();
        initView();
        initListener();
    }

    public final void initView() {
        View viewFindViewById = findViewById(R.id.iv_back);
        h.q2.t.i0.a((Object) viewFindViewById, "findViewById(R.id.iv_back)");
        this.f18869a = (ImageView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.et_search);
        h.q2.t.i0.a((Object) viewFindViewById2, "findViewById(R.id.et_search)");
        this.f18870b = (EditText) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.rv_appList);
        h.q2.t.i0.a((Object) viewFindViewById3, "findViewById(R.id.rv_appList)");
        this.f18871c = (RecyclerView) viewFindViewById3;
        Activity activity = this.mActivity;
        h.q2.t.i0.a((Object) activity, "mActivity");
        this.f18872d = new AppSearchPresenter(activity);
        AppSearchPresenter appSearchPresenter = this.f18872d;
        if (appSearchPresenter != null) {
            RecyclerView recyclerView = this.f18871c;
            if (recyclerView == null) {
                h.q2.t.i0.k("mRvAppList");
            }
            appSearchPresenter.initRecycleCoins(recyclerView);
        }
        AppSearchPresenter appSearchPresenter2 = this.f18872d;
        if (appSearchPresenter2 != null) {
            ArrayList<AppInfoBean> arrayList = f18867e;
            if (arrayList == null) {
                h.q2.t.i0.k("phoneAllApps");
            }
            appSearchPresenter2.setListData(arrayList);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (!isDouble() && view.getId() == R.id.iv_back) {
            a();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_search;
    }

    public final void a() {
        ArrayList<AppInfoBean> arrayList = new ArrayList<>();
        ArrayList<AppInfoBean> arrayList2 = f18867e;
        if (arrayList2 == null) {
            h.q2.t.i0.k("phoneAllApps");
        }
        if (arrayList2.size() > 0) {
            ArrayList<AppInfoBean> arrayList3 = f18867e;
            if (arrayList3 == null) {
                h.q2.t.i0.k("phoneAllApps");
            }
            int size = arrayList3.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList<AppInfoBean> arrayList4 = f18867e;
                if (arrayList4 == null) {
                    h.q2.t.i0.k("phoneAllApps");
                }
                AppInfoBean appInfoBean = arrayList4.get(i2);
                h.q2.t.i0.a((Object) appInfoBean, "phoneAllApps.get(index)");
                AppInfoBean appInfoBean2 = appInfoBean;
                if (appInfoBean2.getFileSize() <= 209715200) {
                    arrayList.add(appInfoBean2);
                }
            }
        }
        Collections.sort(arrayList, new b(Collator.getInstance(Locale.CHINA)));
        AppSearchPresenter appSearchPresenter = this.f18872d;
        if (appSearchPresenter != null) {
            appSearchPresenter.setListData(arrayList);
        }
    }

    @Override // ui.presenter.AppSearchPresenter.a
    public void a(@i.c.a.d AppInfoBean appInfoBean) {
        h.q2.t.i0.f(appInfoBean, "bean");
        if (appInfoBean.getFileSize() > 209715200) {
            util.w1.a("200M以上文件不可选择");
            return;
        }
        org.greenrobot.eventbus.c.f().d(new util.c2.a(35, null));
        org.greenrobot.eventbus.c.f().d(new util.c2.a(30, appInfoBean));
        finish();
    }
}
