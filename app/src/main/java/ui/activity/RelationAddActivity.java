package ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import bean.RelationBean;
import bean.RelationPlatBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import ui.callview.RelationView;
import ui.presenter.RelationPresenter;
import util.y1;

/* compiled from: RelationAddActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010<\u001a\u00020;2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002010>2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020@H\u0004J\b\u0010B\u001a\u00020@H\u0002J\u0018\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020GH\u0016J\u0016\u0010H\u001a\u00020@2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002010>H\u0016J\b\u0010I\u001a\u00020@H\u0016J\u0010\u0010J\u001a\u00020@2\u0006\u0010K\u001a\u00020\u0018H\u0007J\u0006\u0010L\u001a\u00020@J\b\u0010M\u001a\u00020@H\u0002J\b\u0010N\u001a\u00020;H\u0016J\u0006\u0010O\u001a\u00020@J\u0010\u0010P\u001a\u00020\u00072\u0006\u0010Q\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020103X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lui/activity/RelationAddActivity;", "Lui/activity/BaseActivity;", "Lui/callview/RelationView;", "()V", "bean", "Lbean/RelationBean;", "caseInfoId", "", "mEtAccount", "Landroid/widget/EditText;", "getMEtAccount", "()Landroid/widget/EditText;", "setMEtAccount", "(Landroid/widget/EditText;)V", "mEtOtherName", "getMEtOtherName", "setMEtOtherName", "mFlowLayout", "Lcom/zhy/view/flowlayout/TagFlowLayout;", "getMFlowLayout", "()Lcom/zhy/view/flowlayout/TagFlowLayout;", "setMFlowLayout", "(Lcom/zhy/view/flowlayout/TagFlowLayout;)V", "mLlAccNorm", "Landroid/view/View;", "getMLlAccNorm", "()Landroid/view/View;", "setMLlAccNorm", "(Landroid/view/View;)V", "mLlAccOther", "getMLlAccOther", "setMLlAccOther", "mPresenter", "Lui/presenter/RelationPresenter;", "mTagAdapter", "Lcom/zhy/view/flowlayout/TagAdapter;", "mTvAccName", "Landroid/widget/TextView;", "getMTvAccName", "()Landroid/widget/TextView;", "setMTvAccName", "(Landroid/widget/TextView;)V", "mTvOtherTips", "getMTvOtherTips", "setMTvOtherTips", "mTvTitle", "getMTvTitle", "setMTvTitle", "platBean", "Lbean/RelationPlatBean;", "platBeans", "", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "selectIndex", "", "contains", "result", "", "initPage", "", "initTagAdapter", "intentData", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "onSuccessSave", "onViewClicked", "view", "onkeyback", "saveHttpApi", "setLayoutView", "showTagView", "subContains", "input", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RelationAddActivity extends BaseActivity implements RelationView {

    /* renamed from: bean, reason: collision with root package name */
    private RelationBean f18655bean;

    @BindView(R.id.et_account)
    @i.c.a.d
    public EditText mEtAccount;

    @BindView(R.id.et_other_name)
    @i.c.a.d
    public EditText mEtOtherName;

    @BindView(R.id.flow_layout)
    @i.c.a.d
    public TagFlowLayout mFlowLayout;

    @BindView(R.id.ll_acc_nomar)
    @i.c.a.d
    public View mLlAccNorm;

    @BindView(R.id.ll_acc_other)
    @i.c.a.d
    public View mLlAccOther;
    private RelationPresenter mPresenter;
    private com.zhy.view.flowlayout.b<?> mTagAdapter;

    @BindView(R.id.tv_acc_name)
    @i.c.a.d
    public TextView mTvAccName;

    @BindView(R.id.tv_other_name)
    @i.c.a.d
    public TextView mTvOtherTips;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;
    private RelationPlatBean platBean;

    @BindView(R.id.scrollView)
    @i.c.a.d
    public NestedScrollView scrollView;
    private int selectIndex;
    private final List<RelationPlatBean> platBeans = new ArrayList();
    private String caseInfoId = "";

    /* compiled from: RelationAddActivity.kt */
    public static final class a extends com.zhy.view.flowlayout.b<RelationPlatBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        @i.c.a.d
        public View a(@i.c.a.d FlowLayout flowLayout, int i2, @i.c.a.d RelationPlatBean relationPlatBean) {
            h.q2.t.i0.f(flowLayout, "parent");
            h.q2.t.i0.f(relationPlatBean, "t");
            View viewInflate = LayoutInflater.from(RelationAddActivity.this.mActivity).inflate(R.layout.tag_flow, (ViewGroup) RelationAddActivity.this.getMFlowLayout(), false);
            if (viewInflate == null) {
                throw new h.e1("null cannot be cast to non-null type android.widget.TextView");
            }
            TextView textView = (TextView) viewInflate;
            textView.setText(((RelationPlatBean) RelationAddActivity.this.platBeans.get(i2)).getPlatformText());
            textView.setTextColor(RelationAddActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    /* compiled from: RelationAddActivity.kt */
    static final class b implements TagFlowLayout.c {
        b() {
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.c
        public final boolean a(@i.c.a.d View view, int i2, @i.c.a.d FlowLayout flowLayout) {
            h.q2.t.i0.f(view, "view");
            h.q2.t.i0.f(flowLayout, "parent");
            RelationAddActivity.this.selectIndex = i2;
            RelationAddActivity.this.showTagView();
            return true;
        }
    }

    /* compiled from: RelationAddActivity.kt */
    public static final class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            RelationAddActivity.this.saveHttpApi();
        }
    }

    /* compiled from: RelationAddActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            RelationAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private final int contains(List<? extends RelationPlatBean> list, RelationBean relationBean) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(list.get(i2).getPlatform(), relationBean != null ? relationBean.getPlatform() : null)) {
                return i2;
            }
        }
        return 0;
    }

    private final void intentData() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.f18655bean = (RelationBean) getIntent().getSerializableExtra(util.k1.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveHttpApi() {
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            h.q2.t.i0.f();
        }
        relationPresenter.saveRelationTel(this.f18655bean);
    }

    private final String subContains(String str) {
        int size = this.platBeans.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.platBeans.get(i2).getEx() == 0) {
                String platformText = this.platBeans.get(i2).getPlatformText();
                h.q2.t.i0.a((Object) platformText, "platBeans[i].platformText");
                if (platformText == null) {
                    throw new h.e1("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = platformText.toLowerCase();
                h.q2.t.i0.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                if (str == null) {
                    throw new h.e1("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase2 = str.toLowerCase();
                h.q2.t.i0.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                if (TextUtils.equals(lowerCase, lowerCase2)) {
                    String platform = this.platBeans.get(i2).getPlatform();
                    h.q2.t.i0.a((Object) platform, "platBeans[i].platform");
                    return platform;
                }
            }
        }
        RelationPlatBean relationPlatBean = this.platBean;
        return String.valueOf(relationPlatBean != null ? relationPlatBean.getPlatform() : null);
    }

    @i.c.a.d
    public final EditText getMEtAccount() {
        EditText editText = this.mEtAccount;
        if (editText == null) {
            h.q2.t.i0.k("mEtAccount");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtOtherName() {
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            h.q2.t.i0.k("mEtOtherName");
        }
        return editText;
    }

    @i.c.a.d
    public final TagFlowLayout getMFlowLayout() {
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            h.q2.t.i0.k("mFlowLayout");
        }
        return tagFlowLayout;
    }

    @i.c.a.d
    public final View getMLlAccNorm() {
        View view = this.mLlAccNorm;
        if (view == null) {
            h.q2.t.i0.k("mLlAccNorm");
        }
        return view;
    }

    @i.c.a.d
    public final View getMLlAccOther() {
        View view = this.mLlAccOther;
        if (view == null) {
            h.q2.t.i0.k("mLlAccOther");
        }
        return view;
    }

    @i.c.a.d
    public final TextView getMTvAccName() {
        TextView textView = this.mTvAccName;
        if (textView == null) {
            h.q2.t.i0.k("mTvAccName");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvOtherTips() {
        TextView textView = this.mTvOtherTips;
        if (textView == null) {
            h.q2.t.i0.k("mTvOtherTips");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @i.c.a.d
    public final NestedScrollView getScrollView() {
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            h.q2.t.i0.k("scrollView");
        }
        return nestedScrollView;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            h.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            h.q2.t.i0.f();
        }
        textView.setText("添加关联类嫌疑人电话");
        this.mPresenter = new RelationPresenter(this.mActivity, this);
        intentData();
        initTagAdapter();
        RelationPresenter relationPresenter = this.mPresenter;
        if (relationPresenter == null) {
            h.q2.t.i0.f();
        }
        relationPresenter.getRelationPlatList();
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            h.q2.t.i0.k("scrollView");
        }
        y1.a(nestedScrollView, this.mActivity);
    }

    protected final void initTagAdapter() {
        List<RelationPlatBean> list = this.platBeans;
        if (list == null) {
            throw new h.e1("null cannot be cast to non-null type kotlin.collections.List<bean.RelationPlatBean>");
        }
        this.mTagAdapter = new a(list);
        TagFlowLayout tagFlowLayout = this.mFlowLayout;
        if (tagFlowLayout == null) {
            h.q2.t.i0.k("mFlowLayout");
        }
        if (tagFlowLayout == null) {
            h.q2.t.i0.f();
        }
        tagFlowLayout.setAdapter(this.mTagAdapter);
        TagFlowLayout tagFlowLayout2 = this.mFlowLayout;
        if (tagFlowLayout2 == null) {
            h.q2.t.i0.k("mFlowLayout");
        }
        if (tagFlowLayout2 == null) {
            h.q2.t.i0.f();
        }
        tagFlowLayout2.setOnTagClickListener(new b());
    }

    @Override // ui.callview.RelationView
    public void onItemDelet(int i2) {
        RelationView.a.a(this, i2);
    }

    @Override // ui.callview.RelationView
    public void onItemEdit() {
        RelationView.a.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, @i.c.a.d KeyEvent keyEvent) {
        h.q2.t.i0.f(keyEvent, "event");
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        onkeyback();
        return true;
    }

    @Override // ui.callview.RelationView
    public void onSuccessList(@i.c.a.d List<? extends RelationBean> list) {
        h.q2.t.i0.f(list, "list");
        RelationView.a.a(this, list);
    }

    @Override // ui.callview.RelationView
    public void onSuccessPlatList(@i.c.a.d List<? extends RelationPlatBean> list) {
        h.q2.t.i0.f(list, "result");
        RelationView.a.b(this, list);
        if (!list.isEmpty()) {
            this.platBeans.clear();
            this.platBeans.addAll(list);
            com.zhy.view.flowlayout.b<?> bVar = this.mTagAdapter;
            if (bVar == null) {
                h.q2.t.i0.f();
            }
            bVar.c();
            RelationBean relationBean = this.f18655bean;
            if (relationBean == null) {
                com.zhy.view.flowlayout.b<?> bVar2 = this.mTagAdapter;
                if (bVar2 == null) {
                    h.q2.t.i0.f();
                }
                bVar2.a(0);
                this.selectIndex = 0;
                showTagView();
                return;
            }
            int iContains = contains(list, relationBean);
            com.zhy.view.flowlayout.b<?> bVar3 = this.mTagAdapter;
            if (bVar3 == null) {
                h.q2.t.i0.f();
            }
            bVar3.a(iContains);
            this.selectIndex = iContains;
            showTagView();
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                h.q2.t.i0.k("mEtOtherName");
            }
            if (editText == null) {
                h.q2.t.i0.f();
            }
            RelationBean relationBean2 = this.f18655bean;
            if (relationBean2 == null) {
                h.q2.t.i0.f();
            }
            editText.setText(relationBean2.getPlatformText());
            EditText editText2 = this.mEtAccount;
            if (editText2 == null) {
                h.q2.t.i0.k("mEtAccount");
            }
            if (editText2 == null) {
                h.q2.t.i0.f();
            }
            RelationBean relationBean3 = this.f18655bean;
            if (relationBean3 == null) {
                h.q2.t.i0.f();
            }
            editText2.setText(relationBean3.getSuspectMobile());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // ui.callview.RelationView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessSave() {
        /*
            r1 = this;
            bean.RelationBean r0 = r1.f18655bean
            if (r0 == 0) goto L19
            if (r0 != 0) goto L9
            h.q2.t.i0.f()
        L9:
            java.lang.String r0 = r0.getLinkTelInfoID()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L19
            java.lang.String r0 = "修改成功"
            util.w1.a(r0)
            goto L1e
        L19:
            java.lang.String r0 = "添加成功"
            util.w1.a(r0)
        L1e:
            r1.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.RelationAddActivity.onSuccessSave():void");
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        EditText editText = this.mEtOtherName;
        if (editText == null) {
            h.q2.t.i0.k("mEtOtherName");
        }
        if (editText == null) {
            h.q2.t.i0.f();
        }
        String string = editText.getText().toString();
        EditText editText2 = this.mEtAccount;
        if (editText2 == null) {
            h.q2.t.i0.k("mEtAccount");
        }
        if (editText2 == null) {
            h.q2.t.i0.f();
        }
        String string2 = editText2.getText().toString();
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean == null || relationPlatBean.getEx() != 2) {
            RelationPlatBean relationPlatBean2 = this.platBean;
            if (relationPlatBean2 != null && relationPlatBean2.getEx() == 1 && TextUtils.isEmpty(string)) {
                util.w1.a("请输入平台名称");
                return;
            }
        } else if (TextUtils.isEmpty(string)) {
            util.w1.a("请输入公众号/服务号名称");
            return;
        }
        if (TextUtils.isEmpty(string2)) {
            util.w1.a("请输入嫌疑人手机号");
            return;
        }
        if (this.f18655bean == null) {
            this.f18655bean = new RelationBean();
        }
        RelationBean relationBean = this.f18655bean;
        if (relationBean != null) {
            relationBean.setCaseInfoID(this.caseInfoId);
        }
        RelationBean relationBean2 = this.f18655bean;
        if (relationBean2 != null) {
            relationBean2.setSuspectMobile(string2);
        }
        RelationPlatBean relationPlatBean3 = this.platBean;
        if (relationPlatBean3 == null || relationPlatBean3.getEx() != 0) {
            RelationBean relationBean3 = this.f18655bean;
            if (relationBean3 != null) {
                relationBean3.setPlatformText(string);
            }
            RelationBean relationBean4 = this.f18655bean;
            if (relationBean4 != null) {
                relationBean4.setPlatform(subContains(string));
            }
        } else {
            RelationBean relationBean5 = this.f18655bean;
            if (relationBean5 != null) {
                RelationPlatBean relationPlatBean4 = this.platBean;
                relationBean5.setPlatform(relationPlatBean4 != null ? relationPlatBean4.getPlatform() : null);
            }
            RelationBean relationBean6 = this.f18655bean;
            if (relationBean6 != null) {
                RelationPlatBean relationPlatBean5 = this.platBean;
                relationBean6.setPlatformText(relationPlatBean5 != null ? relationPlatBean5.getPlatformText() : null);
            }
        }
        if (h.q2.t.i0.a((Object) string2, (Object) AccountManager.getVisiblePhone())) {
            util.b1.a(this.mActivity, "添加的嫌疑人手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", -1, -1, (IClickListener) new c());
        } else {
            saveHttpApi();
        }
    }

    public final void onkeyback() {
        util.b1.b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new d());
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_relation_acc_add;
    }

    public final void setMEtAccount(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtAccount = editText;
    }

    public final void setMEtOtherName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtOtherName = editText;
    }

    public final void setMFlowLayout(@i.c.a.d TagFlowLayout tagFlowLayout) {
        h.q2.t.i0.f(tagFlowLayout, "<set-?>");
        this.mFlowLayout = tagFlowLayout;
    }

    public final void setMLlAccNorm(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlAccNorm = view;
    }

    public final void setMLlAccOther(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlAccOther = view;
    }

    public final void setMTvAccName(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvAccName = textView;
    }

    public final void setMTvOtherTips(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvOtherTips = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setScrollView(@i.c.a.d NestedScrollView nestedScrollView) {
        h.q2.t.i0.f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void showTagView() {
        this.platBean = this.platBeans.get(this.selectIndex);
        RelationPlatBean relationPlatBean = this.platBean;
        if (relationPlatBean != null && relationPlatBean.getEx() == 1) {
            View view = this.mLlAccOther;
            if (view == null) {
                h.q2.t.i0.k("mLlAccOther");
            }
            if (view == null) {
                h.q2.t.i0.f();
            }
            view.setVisibility(0);
            TextView textView = this.mTvOtherTips;
            if (textView == null) {
                h.q2.t.i0.k("mTvOtherTips");
            }
            if (textView == null) {
                h.q2.t.i0.f();
            }
            textView.setText("平台名称");
            EditText editText = this.mEtOtherName;
            if (editText == null) {
                h.q2.t.i0.k("mEtOtherName");
            }
            if (editText == null) {
                h.q2.t.i0.f();
            }
            editText.setHint("请输入平台名称");
            EditText editText2 = this.mEtOtherName;
            if (editText2 == null) {
                h.q2.t.i0.k("mEtOtherName");
            }
            editText2.setText("");
            return;
        }
        RelationPlatBean relationPlatBean2 = this.platBean;
        if (relationPlatBean2 == null || relationPlatBean2.getEx() != 2) {
            View view2 = this.mLlAccOther;
            if (view2 == null) {
                h.q2.t.i0.k("mLlAccOther");
            }
            if (view2 == null) {
                h.q2.t.i0.f();
            }
            view2.setVisibility(8);
            View view3 = this.mLlAccNorm;
            if (view3 == null) {
                h.q2.t.i0.k("mLlAccNorm");
            }
            if (view3 == null) {
                h.q2.t.i0.f();
            }
            view3.setVisibility(0);
            EditText editText3 = this.mEtOtherName;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtOtherName");
            }
            editText3.setText("");
            return;
        }
        View view4 = this.mLlAccOther;
        if (view4 == null) {
            h.q2.t.i0.k("mLlAccOther");
        }
        if (view4 == null) {
            h.q2.t.i0.f();
        }
        view4.setVisibility(0);
        TextView textView2 = this.mTvOtherTips;
        if (textView2 == null) {
            h.q2.t.i0.k("mTvOtherTips");
        }
        if (textView2 == null) {
            h.q2.t.i0.f();
        }
        textView2.setText("公号名称");
        EditText editText4 = this.mEtOtherName;
        if (editText4 == null) {
            h.q2.t.i0.k("mEtOtherName");
        }
        if (editText4 == null) {
            h.q2.t.i0.f();
        }
        editText4.setHint("请输入公众号/服务号名称");
        EditText editText5 = this.mEtOtherName;
        if (editText5 == null) {
            h.q2.t.i0.k("mEtOtherName");
        }
        editText5.setText("");
    }
}
