package ui.activity;

import adapter.ReportPictureSelAdapter;
import android.content.Intent;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.e.d;
import b.a.a.e.h;
import bean.DeliveryBean;
import bean.DeliveryPlatBean;
import bean.UploadFileBean;
import bean.UploadStateInfo;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.analytics.pro.bh;
import interfaces.IClickListener;
import interfaces.PermissionsListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import ui.Hicore;
import ui.callview.DeliveryView;
import ui.presenter.DeliveryPresenter;
import util.y1;

/* compiled from: DeliveryAddActivity.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000Ô\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\f\u0010{\u001a\b\u0012\u0004\u0012\u00020G0oH\u0002J\b\u0010|\u001a\u00020yH\u0002J\b\u0010}\u001a\u00020yH\u0016J>\u0010~\u001a\u00020\u00132\u0006\u0010r\u001a\u00020s2\u0006\u0010\u007f\u001a\u00020V2\u0016\u0010{\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`H2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010oJ\u0007\u0010\u0082\u0001\u001a\u00020yJ\t\u0010\u0083\u0001\u001a\u00020yH\u0016J&\u0010\u0084\u0001\u001a\u00020y2\u0006\u0010z\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u00072\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J1\u0010\u0088\u0001\u001a\u00020y2\u0012\u0010\u0089\u0001\u001a\r\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u008a\u00012\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010@2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0016J/\u0010\u008d\u0001\u001a\u00020y2\u0007\u0010\u008c\u0001\u001a\u00020\u00072\u001b\u0010\u008e\u0001\u001a\u0016\u0012\u0004\u0012\u00020G\u0018\u00010Fj\n\u0012\u0004\u0012\u00020G\u0018\u0001`HH\u0016J\u001d\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u00072\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001H\u0016J\u0018\u0010\u0094\u0001\u001a\u00020y2\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020p0oH\u0016J\u0012\u0010\u0096\u0001\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020\u001fH\u0016J\u0012\u0010\u0098\u0001\u001a\u00020y2\u0007\u0010\u0099\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020y2\u0007\u0010\u008b\u0001\u001a\u00020@H\u0007J\u0007\u0010\u009b\u0001\u001a\u00020yJ\t\u0010\u009c\u0001\u001a\u00020yH\u0014J\u0012\u0010\u009d\u0001\u001a\u00020y2\u0007\u0010\u009e\u0001\u001a\u00020\u0007H\u0002J\u0007\u0010\u009f\u0001\u001a\u00020yJ\u0012\u0010 \u0001\u001a\u00020y2\u0007\u0010¡\u0001\u001a\u00020\rH\u0002J\u0012\u0010¢\u0001\u001a\u00020y2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0016J\t\u0010£\u0001\u001a\u00020yH\u0002J\t\u0010¤\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010¥\u0001\u001a\u00020yJ\u0014\u0010¦\u0001\u001a\u00020y2\t\u0010§\u0001\u001a\u0004\u0018\u00010\\H\u0002J&\u0010¨\u0001\u001a\u00020y2\u001d\u0010©\u0001\u001a\u0018\u0012\u0005\u0012\u00030ª\u0001\u0018\u00010Fj\u000b\u0012\u0005\u0012\u00030ª\u0001\u0018\u0001`HJ\u0007\u0010«\u0001\u001a\u00020yR\u0014\u0010\u0006\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u001e\u0010-\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u00100\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001e\u00103\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)R\u001e\u00106\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020G0Fj\b\u0012\u0004\u0012\u00020G`HX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\tR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001e\u0010U\u001a\u00020V8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001e\u0010[\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001e\u0010a\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R\u001e\u0010d\u001a\u00020\\8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010^\"\u0004\bf\u0010`R\u001e\u0010g\u001a\u0012\u0012\u0004\u0012\u00020\r0Fj\b\u0012\u0004\u0012\u00020\r`HX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020p\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010r\u001a\u00020s8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010w¨\u0006¬\u0001"}, d2 = {"Lui/activity/DeliveryAddActivity;", "Lui/activity/BasePicUploadActivity;", "Lui/callview/DeliveryView;", "Ladapter/ReportPictureSelAdapter$OnItemClickListener;", "Lcom/chad/library/adapter/base/BaseQuickAdapter$OnItemChildClickListener;", "()V", "CODE_PREVIEW", "", "getCODE_PREVIEW", "()I", "REQUEST_CODE_RECORD", "getREQUEST_CODE_RECORD", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "mAdapter", "Ladapter/ReportPictureSelAdapter;", "getMAdapter", "()Ladapter/ReportPictureSelAdapter;", "setMAdapter", "(Ladapter/ReportPictureSelAdapter;)V", "mBtnConfirm", "Landroid/widget/Button;", "getMBtnConfirm", "()Landroid/widget/Button;", "setMBtnConfirm", "(Landroid/widget/Button;)V", "mDeliveryBean", "Lbean/DeliveryBean;", "getMDeliveryBean", "()Lbean/DeliveryBean;", "setMDeliveryBean", "(Lbean/DeliveryBean;)V", "mEtDeliveryAddress", "Landroid/widget/EditText;", "getMEtDeliveryAddress", "()Landroid/widget/EditText;", "setMEtDeliveryAddress", "(Landroid/widget/EditText;)V", "mEtDeliveryName", "getMEtDeliveryName", "setMEtDeliveryName", "mEtDeliveryNum", "getMEtDeliveryNum", "setMEtDeliveryNum", "mEtDeliveryPhone", "getMEtDeliveryPhone", "setMEtDeliveryPhone", "mEtDeliveryWp", "getMEtDeliveryWp", "setMEtDeliveryWp", "mEtPlatName", "getMEtPlatName", "setMEtPlatName", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlDeliveryPlat", "Landroid/view/View;", "getMLlDeliveryPlat", "()Landroid/view/View;", "setMLlDeliveryPlat", "(Landroid/view/View;)V", "mLocalMedia", "Ljava/util/ArrayList;", "Lcom/luck/picture/lib/entity/LocalMedia;", "Lkotlin/collections/ArrayList;", "getMLocalMedia", "()Ljava/util/ArrayList;", "setMLocalMedia", "(Ljava/util/ArrayList;)V", "mMaxSelectNum", "getMMaxSelectNum", "mPresenter", "Lui/presenter/DeliveryPresenter;", "getMPresenter", "()Lui/presenter/DeliveryPresenter;", "setMPresenter", "(Lui/presenter/DeliveryPresenter;)V", "mRecyView", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mTvDeliveryPlat", "Landroid/widget/TextView;", "getMTvDeliveryPlat", "()Landroid/widget/TextView;", "setMTvDeliveryPlat", "(Landroid/widget/TextView;)V", "mTvDeliveryTime", "getMTvDeliveryTime", "setMTvDeliveryTime", "mTvTitle", "getMTvTitle", "setMTvTitle", "pickTypes", "picker", "Lcn/qqtheme/framework/picker/OptionPicker;", "getPicker", "()Lcn/qqtheme/framework/picker/OptionPicker;", "setPicker", "(Lcn/qqtheme/framework/picker/OptionPicker;)V", "platList", "", "Lbean/DeliveryPlatBean;", "platformCode", "scrollView", "Landroidx/core/widget/NestedScrollView;", "getScrollView", "()Landroidx/core/widget/NestedScrollView;", "setScrollView", "(Landroidx/core/widget/NestedScrollView;)V", "checkPermission", "", "requestCode", "localMediaList", "editChangeListner", "initPage", "initRecycle", "recyclerView", "uploadStateInfoList", "Lbean/UploadStateInfo;", "initView", "notifyAdapter", "onActivityResult", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onItemChildClick", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "view", "position", "onItemClickListener", "myLiveList", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onSuccessPlatList", "list", "onSuccessSave", "bean", "onSuccessSaveFail", "msg", "onViewClicked", "onkeyback", "pageFileFinish", "platSelect", "index", "redisplayData", "regexPlat", "editStr", "removeLocalData", "saveHttpApi", "setLayoutView", "showPlatPiker", "showTimePiker", "timePk", "transLocalMedia", "picBeans", "Lbean/UploadFileBean;", "upLoadMedia", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DeliveryAddActivity extends BasePicUploadActivity implements DeliveryView, ReportPictureSelAdapter.a, BaseQuickAdapter.i {

    @i.c.a.e
    private ReportPictureSelAdapter mAdapter;

    @BindView(R.id.btn_confirm)
    @i.c.a.d
    public Button mBtnConfirm;

    @i.c.a.e
    private DeliveryBean mDeliveryBean;

    @BindView(R.id.et_delivery_address)
    @i.c.a.d
    public EditText mEtDeliveryAddress;

    @BindView(R.id.et_delivery_sender)
    @i.c.a.d
    public EditText mEtDeliveryName;

    @BindView(R.id.et_delivery_num)
    @i.c.a.d
    public EditText mEtDeliveryNum;

    @BindView(R.id.et_delivery_phone)
    @i.c.a.d
    public EditText mEtDeliveryPhone;

    @BindView(R.id.et_delivery_wp)
    @i.c.a.d
    public EditText mEtDeliveryWp;

    @BindView(R.id.et_delivery_name)
    @i.c.a.d
    public EditText mEtPlatName;

    @BindView(R.id.iv_back)
    @i.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_delivery_plat)
    @i.c.a.d
    public View mLlDeliveryPlat;

    @i.c.a.e
    private DeliveryPresenter mPresenter;

    @BindView(R.id.recyclerview)
    @i.c.a.d
    public RecyclerView mRecyView;

    @BindView(R.id.tv_delivery_plat)
    @i.c.a.d
    public TextView mTvDeliveryPlat;

    @BindView(R.id.tv_delivery_time)
    @i.c.a.d
    public TextView mTvDeliveryTime;

    @BindView(R.id.tv_title)
    @i.c.a.d
    public TextView mTvTitle;

    @i.c.a.e
    private b.a.a.e.h picker;
    private List<? extends DeliveryPlatBean> platList;
    private String platformCode;

    @BindView(R.id.ns_layout)
    @i.c.a.d
    public NestedScrollView scrollView;
    private final int CODE_PREVIEW = 1000;
    private final int REQUEST_CODE_RECORD = 1001;

    @i.c.a.d
    private String caseInfoId = "";
    private final int mMaxSelectNum = 6;

    @i.c.a.d
    private ArrayList<LocalMedia> mLocalMedia = new ArrayList<>();
    private ArrayList<String> pickTypes = new ArrayList<>();

    /* compiled from: DeliveryAddActivity.kt */
    public static final class a implements PermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f18098b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f18099c;

        a(List list, int i2) {
            this.f18098b = list;
            this.f18099c = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(@i.c.a.d List<String> list, boolean z) {
            h.q2.t.i0.f(list, "deniedPermissions");
            util.permissionutil.c.a(DeliveryAddActivity.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(DeliveryAddActivity.this.mActivity, 200L, PictureMimeType.ofImage(), DeliveryAddActivity.this.getMMaxSelectNum() - this.f18098b.size()).forResult(this.f18099c);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@i.c.a.d Editable editable) {
            h.q2.t.i0.f(editable, bh.aE);
            DeliveryAddActivity.this.regexPlat(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@i.c.a.d CharSequence charSequence, int i2, int i3, int i4) {
            h.q2.t.i0.f(charSequence, bh.aE);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    public static final class c implements IClickListener {
        c() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            DeliveryAddActivity.this.upLoadMedia();
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    public static final class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            DeliveryAddActivity.this.cancleUpLoad();
            DeliveryAddActivity.this.finish();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    public static final class e extends h.a {
        e() {
        }

        @Override // b.a.a.e.h.a
        public void b(int i2, @i.c.a.d String str) {
            h.q2.t.i0.f(str, "item");
            DeliveryAddActivity.this.platSelect(i2);
        }
    }

    /* compiled from: DeliveryAddActivity.kt */
    static final class f implements d.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f18104a;

        f(TextView textView) {
            this.f18104a = textView;
        }

        @Override // b.a.a.e.d.m
        public final void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str + '-' + str2 + '-' + str3 + ' ' + str4 + ':' + str5;
            TextView textView = this.f18104a;
            if (textView == null) {
                h.q2.t.i0.f();
            }
            textView.setText(str6);
        }
    }

    private final void checkPermission(int i2, List<? extends LocalMedia> list) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a(list, i2));
    }

    private final void editChangeListner() {
        EditText editText = this.mEtDeliveryNum;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryNum");
        }
        if (editText == null) {
            h.q2.t.i0.f();
        }
        editText.addTextChangedListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void platSelect(int i2) {
        List<? extends DeliveryPlatBean> list = this.platList;
        if (list == null) {
            h.q2.t.i0.f();
        }
        DeliveryPlatBean deliveryPlatBean = list.get(i2);
        this.platformCode = deliveryPlatBean.getPlatform();
        if (deliveryPlatBean.getEx() == 1) {
            View view = this.mLlDeliveryPlat;
            if (view == null) {
                h.q2.t.i0.k("mLlDeliveryPlat");
            }
            view.setVisibility(0);
        } else {
            View view2 = this.mLlDeliveryPlat;
            if (view2 == null) {
                h.q2.t.i0.k("mLlDeliveryPlat");
            }
            view2.setVisibility(8);
        }
        TextView textView = this.mTvDeliveryPlat;
        if (textView == null) {
            h.q2.t.i0.k("mTvDeliveryPlat");
        }
        textView.setText(deliveryPlatBean.getPlatformText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void regexPlat(String str) {
        if (TextUtils.isEmpty(str)) {
            TextView textView = this.mTvDeliveryPlat;
            if (textView == null) {
                h.q2.t.i0.k("mTvDeliveryPlat");
            }
            textView.setText("");
            View view = this.mLlDeliveryPlat;
            if (view == null) {
                h.q2.t.i0.k("mLlDeliveryPlat");
            }
            view.setVisibility(8);
            return;
        }
        List<? extends DeliveryPlatBean> list = this.platList;
        if (list != null) {
            Integer numValueOf = list != null ? Integer.valueOf(list.size()) : null;
            if (numValueOf == null) {
                h.q2.t.i0.f();
            }
            if (numValueOf.intValue() > 0) {
                List<? extends DeliveryPlatBean> list2 = this.platList;
                if (list2 == null) {
                    h.q2.t.i0.f();
                }
                int size = list2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    List<? extends DeliveryPlatBean> list3 = this.platList;
                    if (list3 == null) {
                        h.q2.t.i0.f();
                    }
                    if (y1.a(str, list3.get(i2).getOddNumRegex())) {
                        b.a.a.e.h hVar = this.picker;
                        if (hVar != null) {
                            hVar.E(i2);
                        }
                        platSelect(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void saveHttpApi() {
        ArrayList<UploadFileBean> mailingTelDetails;
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        if (arrayList == null || arrayList.size() == 0) {
            DeliveryBean deliveryBean = this.mDeliveryBean;
            if (deliveryBean != null) {
                deliveryBean.setMailingTelDetails(null);
            }
        } else {
            ArrayList<UploadFileBean> arrayList2 = this.mUploadPicList;
            if (arrayList2 != null && arrayList2.size() > 0) {
                DeliveryBean deliveryBean2 = this.mDeliveryBean;
                if ((deliveryBean2 != null ? deliveryBean2.getMailingTelDetails() : null) != null) {
                    DeliveryBean deliveryBean3 = this.mDeliveryBean;
                    if (deliveryBean3 != null && (mailingTelDetails = deliveryBean3.getMailingTelDetails()) != null) {
                        mailingTelDetails.addAll(this.mUploadPicList);
                    }
                } else {
                    DeliveryBean deliveryBean4 = this.mDeliveryBean;
                    if (deliveryBean4 != null) {
                        deliveryBean4.setMailingTelDetails(this.mUploadPicList);
                    }
                }
            }
        }
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter == null) {
            h.q2.t.i0.f();
        }
        deliveryPresenter.saveDeliveryTelHttp(this.mDeliveryBean);
    }

    private final void showTimePiker(TextView textView) {
        Calendar calendar = Calendar.getInstance();
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        int i5 = calendar.get(11);
        int i6 = calendar.get(12);
        b.a.a.e.d dVar = new b.a.a.e.d(this, 0, 3);
        dVar.g(2018, 2055);
        dVar.a(i2, i3, i4, i5, i6);
        dVar.setOnDateTimePickListener(new f(textView));
        dVar.m();
    }

    public final int getCODE_PREVIEW() {
        return this.CODE_PREVIEW;
    }

    @i.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    @i.c.a.e
    public final ReportPictureSelAdapter getMAdapter() {
        return this.mAdapter;
    }

    @i.c.a.d
    public final Button getMBtnConfirm() {
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        return button;
    }

    @i.c.a.e
    public final DeliveryBean getMDeliveryBean() {
        return this.mDeliveryBean;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryAddress() {
        EditText editText = this.mEtDeliveryAddress;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryAddress");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryName() {
        EditText editText = this.mEtDeliveryName;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryName");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryNum() {
        EditText editText = this.mEtDeliveryNum;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryNum");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryPhone() {
        EditText editText = this.mEtDeliveryPhone;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryPhone");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtDeliveryWp() {
        EditText editText = this.mEtDeliveryWp;
        if (editText == null) {
            h.q2.t.i0.k("mEtDeliveryWp");
        }
        return editText;
    }

    @i.c.a.d
    public final EditText getMEtPlatName() {
        EditText editText = this.mEtPlatName;
        if (editText == null) {
            h.q2.t.i0.k("mEtPlatName");
        }
        return editText;
    }

    @i.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            h.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @i.c.a.d
    public final View getMLlDeliveryPlat() {
        View view = this.mLlDeliveryPlat;
        if (view == null) {
            h.q2.t.i0.k("mLlDeliveryPlat");
        }
        return view;
    }

    @i.c.a.d
    public final ArrayList<LocalMedia> getMLocalMedia() {
        return this.mLocalMedia;
    }

    public final int getMMaxSelectNum() {
        return this.mMaxSelectNum;
    }

    @i.c.a.e
    public final DeliveryPresenter getMPresenter() {
        return this.mPresenter;
    }

    @i.c.a.d
    public final RecyclerView getMRecyView() {
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyView");
        }
        return recyclerView;
    }

    @i.c.a.d
    public final TextView getMTvDeliveryPlat() {
        TextView textView = this.mTvDeliveryPlat;
        if (textView == null) {
            h.q2.t.i0.k("mTvDeliveryPlat");
        }
        return textView;
    }

    @i.c.a.d
    public final TextView getMTvDeliveryTime() {
        TextView textView = this.mTvDeliveryTime;
        if (textView == null) {
            h.q2.t.i0.k("mTvDeliveryTime");
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

    @i.c.a.e
    public final b.a.a.e.h getPicker() {
        return this.picker;
    }

    public final int getREQUEST_CODE_RECORD() {
        return this.REQUEST_CODE_RECORD;
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
        textView.setText("寄递类嫌疑人电话详情");
        initView();
        editChangeListner();
        DeliveryPresenter deliveryPresenter = this.mPresenter;
        if (deliveryPresenter == null) {
            h.q2.t.i0.f();
        }
        deliveryPresenter.getPlatList();
    }

    @i.c.a.d
    public final ReportPictureSelAdapter initRecycle(@i.c.a.d NestedScrollView nestedScrollView, @i.c.a.d RecyclerView recyclerView, @i.c.a.d ArrayList<LocalMedia> arrayList, @i.c.a.d List<? extends UploadStateInfo> list) {
        h.q2.t.i0.f(nestedScrollView, "scrollView");
        h.q2.t.i0.f(recyclerView, "recyclerView");
        h.q2.t.i0.f(arrayList, "localMediaList");
        h.q2.t.i0.f(list, "uploadStateInfoList");
        recycleViewListener(nestedScrollView, recyclerView);
        ReportPictureSelAdapter reportPictureSelAdapterA = ReportPictureSelAdapter.a(this.mActivity, recyclerView, this.mMaxSelectNum, this, this, arrayList, list);
        h.q2.t.i0.a((Object) reportPictureSelAdapterA, "ReportPictureSelAdapter.…List,uploadStateInfoList)");
        return reportPictureSelAdapterA;
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.k1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mDeliveryBean = (DeliveryBean) getIntent().getSerializableExtra(util.k1.f20845c);
        this.mPresenter = new DeliveryPresenter(this.mActivity, this);
        NestedScrollView nestedScrollView = this.scrollView;
        if (nestedScrollView == null) {
            h.q2.t.i0.k("scrollView");
        }
        RecyclerView recyclerView = this.mRecyView;
        if (recyclerView == null) {
            h.q2.t.i0.k("mRecyView");
        }
        ArrayList<LocalMedia> arrayList = this.mLocalMedia;
        ArrayList<UploadStateInfo> arrayList2 = this.mUploadStateList;
        h.q2.t.i0.a((Object) arrayList2, "mUploadStateList");
        this.mAdapter = initRecycle(nestedScrollView, recyclerView, arrayList, arrayList2);
    }

    @Override // ui.activity.BasePicUploadActivity
    public void notifyAdapter() {
        super.notifyAdapter();
        if (this.mLocalMedia == null || this.isScroll) {
            this.isScrollOver = true;
            return;
        }
        if (this.mCurrentUploadIndex < 0) {
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter == null) {
                h.q2.t.i0.f();
            }
            reportPictureSelAdapter.notifyDataSetChanged();
            return;
        }
        if (!this.isScrollOver) {
            ReportPictureSelAdapter reportPictureSelAdapter2 = this.mAdapter;
            if (reportPictureSelAdapter2 == null) {
                h.q2.t.i0.f();
            }
            reportPictureSelAdapter2.notifyDataSetChanged();
            return;
        }
        ReportPictureSelAdapter reportPictureSelAdapter3 = this.mAdapter;
        if (reportPictureSelAdapter3 == null) {
            h.q2.t.i0.f();
        }
        reportPictureSelAdapter3.notifyItemRangeChanged(0, this.mCurrentUploadIndex);
        this.isScrollOver = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @i.c.a.e Intent intent) throws IllegalArgumentException {
        List<LocalMedia> listObtainMultipleResult;
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 || i2 != this.REQUEST_CODE_RECORD || (listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent)) == null || listObtainMultipleResult.size() <= 0) {
            return;
        }
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        if (button.isEnabled()) {
            if (Build.VERSION.SDK_INT > 28) {
                changePath(listObtainMultipleResult);
            }
            List<LocalMedia> listA = y1.a(listObtainMultipleResult);
            h.q2.t.i0.a((Object) listA, "newList");
            int size = listA.size();
            for (int i4 = 0; i4 < size; i4++) {
                UploadFileBean uploadFileBean = new UploadFileBean();
                uploadFileBean.setLocalPath(listA.get(i4).getPath());
                uploadFileBean.setFileName(listA.get(i4).getFileName());
                this.mLocalMedia.add(listA.get(i4));
                this.mUploadStateList.add(new UploadStateInfo());
                this.mUploadPicList.add(uploadFileBean);
            }
            ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
            if (reportPictureSelAdapter != null) {
                reportPictureSelAdapter.notifyDataSetChanged();
            }
            changeBtnCommit("确定", true);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(@i.c.a.e BaseQuickAdapter<?, ?> baseQuickAdapter, @i.c.a.e View view, int i2) {
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (numValueOf != null && numValueOf.intValue() == R.id.iv_clear) {
            Button button = this.mBtnConfirm;
            if (button == null) {
                h.q2.t.i0.k("mBtnConfirm");
            }
            if (button.isEnabled()) {
                deleteDialog(i2);
            }
        }
    }

    @Override // adapter.ReportPictureSelAdapter.a
    public void onItemClickListener(int i2, @i.c.a.e ArrayList<LocalMedia> arrayList) {
        LocalMedia localMedia;
        if (isDouble()) {
            return;
        }
        if (arrayList != null && i2 == arrayList.size()) {
            if (rejuctOperation(false)) {
                return;
            }
            checkPermission(this.REQUEST_CODE_RECORD, this.mLocalMedia);
            return;
        }
        String path = (arrayList == null || (localMedia = arrayList.get(i2)) == null) ? null : localMedia.getPath();
        Intent intent = new Intent(this, (Class<?>) PreviewPictureActivity.class);
        intent.putParcelableArrayListExtra(PreviewPictureActivity.f18539f, arrayList);
        intent.putExtra(PreviewPictureActivity.f18540g, i2);
        intent.putExtra(PreviewPictureActivity.f18541h, arrayList != null ? Integer.valueOf(arrayList.size()) : null);
        intent.putExtra(PreviewPictureActivity.f18542i, path);
        startActivityForResult(intent, this.CODE_PREVIEW);
    }

    @Override // ui.callview.DeliveryView
    public void onItemDelet(int i2) {
        DeliveryView.a.a(this, i2);
    }

    @Override // ui.callview.DeliveryView
    public void onItemEdit(int i2) {
        DeliveryView.a.b(this, i2);
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

    @Override // ui.callview.DeliveryView
    public void onSuccessList(@i.c.a.d List<? extends DeliveryBean> list) {
        h.q2.t.i0.f(list, "list");
        DeliveryView.a.a(this, list);
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessPlatList(@i.c.a.d List<? extends DeliveryPlatBean> list) {
        h.q2.t.i0.f(list, "list");
        DeliveryView.a.b(this, list);
        if (list.size() > 0) {
            this.platList = list;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pickTypes.add(list.get(i2).getPlatformText());
                String platform = list.get(i2).getPlatform();
                DeliveryBean deliveryBean = this.mDeliveryBean;
                if (h.q2.t.i0.a((Object) platform, (Object) (deliveryBean != null ? deliveryBean.getPlatform() : null))) {
                    if (list.get(i2).getEx() == 1) {
                        DeliveryBean deliveryBean2 = this.mDeliveryBean;
                        if (deliveryBean2 != null) {
                            deliveryBean2.setEx(1);
                        }
                    } else {
                        DeliveryBean deliveryBean3 = this.mDeliveryBean;
                        if (deliveryBean3 != null) {
                            deliveryBean3.setEx(0);
                        }
                    }
                }
            }
            redisplayData();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    @Override // ui.callview.DeliveryView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccessSave(@i.c.a.d bean.DeliveryBean r2) {
        /*
            r1 = this;
            java.lang.String r0 = "bean"
            h.q2.t.i0.f(r2, r0)
            bean.DeliveryBean r2 = r1.mDeliveryBean
            if (r2 == 0) goto L1e
            if (r2 != 0) goto Le
            h.q2.t.i0.f()
        Le:
            java.lang.String r2 = r2.getMailingTelInfoid()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L1e
            java.lang.String r2 = "修改成功"
            util.w1.a(r2)
            goto L23
        L1e:
            java.lang.String r2 = "添加成功"
            util.w1.a(r2)
        L23:
            android.widget.Button r2 = r1.mBtnConfirm
            if (r2 != 0) goto L2c
            java.lang.String r0 = "mBtnConfirm"
            h.q2.t.i0.k(r0)
        L2c:
            r0 = 1
            r2.setEnabled(r0)
            r1.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ui.activity.DeliveryAddActivity.onSuccessSave(bean.DeliveryBean):void");
    }

    @Override // ui.callview.DeliveryView
    public void onSuccessSaveFail(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "msg");
        DeliveryView.a.a(this, str);
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        button.setEnabled(true);
    }

    @OnClick({R.id.iv_back, R.id.tv_delivery_plat, R.id.tv_delivery_time, R.id.btn_confirm})
    public final void onViewClicked(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "view");
        Hicore app = Hicore.getApp();
        h.q2.t.i0.a((Object) app, "Hicore.getApp()");
        if (app.isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_confirm /* 2131296396 */:
                EditText editText = this.mEtDeliveryNum;
                if (editText == null) {
                    h.q2.t.i0.k("mEtDeliveryNum");
                }
                String string = editText.getText().toString();
                TextView textView = this.mTvDeliveryPlat;
                if (textView == null) {
                    h.q2.t.i0.k("mTvDeliveryPlat");
                }
                String string2 = textView.getText().toString();
                EditText editText2 = this.mEtPlatName;
                if (editText2 == null) {
                    h.q2.t.i0.k("mEtPlatName");
                }
                String string3 = editText2.getText().toString();
                EditText editText3 = this.mEtDeliveryName;
                if (editText3 == null) {
                    h.q2.t.i0.k("mEtDeliveryName");
                }
                String string4 = editText3.getText().toString();
                EditText editText4 = this.mEtDeliveryPhone;
                if (editText4 == null) {
                    h.q2.t.i0.k("mEtDeliveryPhone");
                }
                String string5 = editText4.getText().toString();
                EditText editText5 = this.mEtDeliveryAddress;
                if (editText5 == null) {
                    h.q2.t.i0.k("mEtDeliveryAddress");
                }
                String string6 = editText5.getText().toString();
                TextView textView2 = this.mTvDeliveryTime;
                if (textView2 == null) {
                    h.q2.t.i0.k("mTvDeliveryTime");
                }
                String string7 = textView2.getText().toString();
                EditText editText6 = this.mEtDeliveryWp;
                if (editText6 == null) {
                    h.q2.t.i0.k("mEtDeliveryWp");
                }
                String string8 = editText6.getText().toString();
                if (!(string.length() == 0)) {
                    EditText editText7 = this.mEtPlatName;
                    if (editText7 == null) {
                        h.q2.t.i0.k("mEtPlatName");
                    }
                    if (editText7.isShown()) {
                        if (string3.length() == 0) {
                            util.w1.a("请填写物流公司名称");
                            break;
                        }
                    }
                    if (!(string2.length() == 0)) {
                        if (!(string4.length() == 0)) {
                            if (!(string5.length() == 0)) {
                                if (!(string6.length() == 0)) {
                                    if (!(string7.length() == 0)) {
                                        if (!(string8.length() == 0)) {
                                            DeliveryBean deliveryBean = this.mDeliveryBean;
                                            if (deliveryBean == null) {
                                                this.mDeliveryBean = new DeliveryBean();
                                                DeliveryBean deliveryBean2 = this.mDeliveryBean;
                                                if (deliveryBean2 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean2.setCaseInfoID(this.caseInfoId);
                                                DeliveryBean deliveryBean3 = this.mDeliveryBean;
                                                if (deliveryBean3 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean3.setPlatform(this.platformCode);
                                                EditText editText8 = this.mEtPlatName;
                                                if (editText8 == null) {
                                                    h.q2.t.i0.k("mEtPlatName");
                                                }
                                                if (editText8.isShown()) {
                                                    DeliveryBean deliveryBean4 = this.mDeliveryBean;
                                                    if (deliveryBean4 == null) {
                                                        h.q2.t.i0.f();
                                                    }
                                                    deliveryBean4.setDeliveryPlat(string3);
                                                } else {
                                                    DeliveryBean deliveryBean5 = this.mDeliveryBean;
                                                    if (deliveryBean5 == null) {
                                                        h.q2.t.i0.f();
                                                    }
                                                    deliveryBean5.setDeliveryPlat(string2);
                                                }
                                                DeliveryBean deliveryBean6 = this.mDeliveryBean;
                                                if (deliveryBean6 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean6.setDeliveryNum(string);
                                                DeliveryBean deliveryBean7 = this.mDeliveryBean;
                                                if (deliveryBean7 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean7.setDeliveryAddress(string6);
                                                DeliveryBean deliveryBean8 = this.mDeliveryBean;
                                                if (deliveryBean8 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean8.setDeliveryName(string4);
                                                DeliveryBean deliveryBean9 = this.mDeliveryBean;
                                                if (deliveryBean9 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean9.setDeliveryPhone(string5);
                                                DeliveryBean deliveryBean10 = this.mDeliveryBean;
                                                if (deliveryBean10 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean10.setDeliveryTime(string7);
                                                DeliveryBean deliveryBean11 = this.mDeliveryBean;
                                                if (deliveryBean11 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean11.setDeliveryWp(string8);
                                            } else {
                                                if (deliveryBean == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean.setCaseInfoID(this.caseInfoId);
                                                DeliveryBean deliveryBean12 = this.mDeliveryBean;
                                                if (deliveryBean12 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean12.setPlatform(this.platformCode);
                                                EditText editText9 = this.mEtPlatName;
                                                if (editText9 == null) {
                                                    h.q2.t.i0.k("mEtPlatName");
                                                }
                                                if (editText9.isShown()) {
                                                    DeliveryBean deliveryBean13 = this.mDeliveryBean;
                                                    if (deliveryBean13 == null) {
                                                        h.q2.t.i0.f();
                                                    }
                                                    deliveryBean13.setDeliveryPlat(string3);
                                                } else {
                                                    DeliveryBean deliveryBean14 = this.mDeliveryBean;
                                                    if (deliveryBean14 == null) {
                                                        h.q2.t.i0.f();
                                                    }
                                                    deliveryBean14.setDeliveryPlat(string2);
                                                }
                                                DeliveryBean deliveryBean15 = this.mDeliveryBean;
                                                if (deliveryBean15 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean15.setDeliveryNum(string);
                                                DeliveryBean deliveryBean16 = this.mDeliveryBean;
                                                if (deliveryBean16 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean16.setDeliveryAddress(string6);
                                                DeliveryBean deliveryBean17 = this.mDeliveryBean;
                                                if (deliveryBean17 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean17.setDeliveryName(string4);
                                                DeliveryBean deliveryBean18 = this.mDeliveryBean;
                                                if (deliveryBean18 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean18.setDeliveryPhone(string5);
                                                DeliveryBean deliveryBean19 = this.mDeliveryBean;
                                                if (deliveryBean19 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean19.setDeliveryTime(string7);
                                                DeliveryBean deliveryBean20 = this.mDeliveryBean;
                                                if (deliveryBean20 == null) {
                                                    h.q2.t.i0.f();
                                                }
                                                deliveryBean20.setDeliveryWp(string8);
                                            }
                                            if (!h.q2.t.i0.a((Object) string5, (Object) AccountManager.getVisiblePhone())) {
                                                upLoadMedia();
                                                break;
                                            } else {
                                                util.b1.b(this.mActivity, "添加的寄件人手机号码是您的登录号码，确定添加个人号码为诈骗号码?", "", "取消", "确定", new c());
                                                break;
                                            }
                                        } else {
                                            util.w1.a("请填写快递物品");
                                            break;
                                        }
                                    } else {
                                        util.w1.a("请选择寄件时间");
                                        break;
                                    }
                                } else {
                                    util.w1.a("请填写寄件地址");
                                    break;
                                }
                            } else {
                                util.w1.a("请填写寄件人电话");
                                break;
                            }
                        } else {
                            util.w1.a("请填写寄件人姓名");
                            break;
                        }
                    } else {
                        util.w1.a("请选择物流公司");
                        break;
                    }
                } else {
                    util.w1.a("请输入或粘贴快递单号");
                    break;
                }
            case R.id.iv_back /* 2131296762 */:
                onkeyback();
                break;
            case R.id.tv_delivery_plat /* 2131297520 */:
                showPlatPiker();
                break;
            case R.id.tv_delivery_time /* 2131297524 */:
                TextView textView3 = this.mTvDeliveryTime;
                if (textView3 == null) {
                    h.q2.t.i0.k("mTvDeliveryTime");
                }
                showTimePiker(textView3);
                break;
        }
    }

    public final void onkeyback() {
        util.b1.b(this.mActivity, "放弃本次信息编辑？", "", "确定", "取消", new d());
    }

    @Override // ui.activity.BasePicUploadActivity
    protected void pageFileFinish() {
        super.pageFileFinish();
        saveHttpApi();
    }

    public final void redisplayData() {
        if (this.mDeliveryBean != null) {
            EditText editText = this.mEtDeliveryNum;
            if (editText == null) {
                h.q2.t.i0.k("mEtDeliveryNum");
            }
            DeliveryBean deliveryBean = this.mDeliveryBean;
            editText.setText(deliveryBean != null ? deliveryBean.getDeliveryNum() : null);
            EditText editText2 = this.mEtDeliveryPhone;
            if (editText2 == null) {
                h.q2.t.i0.k("mEtDeliveryPhone");
            }
            DeliveryBean deliveryBean2 = this.mDeliveryBean;
            editText2.setText(deliveryBean2 != null ? deliveryBean2.getDeliveryPhone() : null);
            EditText editText3 = this.mEtDeliveryAddress;
            if (editText3 == null) {
                h.q2.t.i0.k("mEtDeliveryAddress");
            }
            DeliveryBean deliveryBean3 = this.mDeliveryBean;
            editText3.setText(deliveryBean3 != null ? deliveryBean3.getDeliveryAddress() : null);
            EditText editText4 = this.mEtDeliveryName;
            if (editText4 == null) {
                h.q2.t.i0.k("mEtDeliveryName");
            }
            if (editText4 == null) {
                h.q2.t.i0.f();
            }
            DeliveryBean deliveryBean4 = this.mDeliveryBean;
            editText4.setText(deliveryBean4 != null ? deliveryBean4.getDeliveryName() : null);
            TextView textView = this.mTvDeliveryTime;
            if (textView == null) {
                h.q2.t.i0.k("mTvDeliveryTime");
            }
            DeliveryBean deliveryBean5 = this.mDeliveryBean;
            textView.setText(deliveryBean5 != null ? deliveryBean5.getDeliveryTime() : null);
            EditText editText5 = this.mEtDeliveryWp;
            if (editText5 == null) {
                h.q2.t.i0.k("mEtDeliveryWp");
            }
            DeliveryBean deliveryBean6 = this.mDeliveryBean;
            editText5.setText(deliveryBean6 != null ? deliveryBean6.getDeliveryWp() : null);
            DeliveryBean deliveryBean7 = this.mDeliveryBean;
            if (deliveryBean7 == null || deliveryBean7.getEx() != 1) {
                View view = this.mLlDeliveryPlat;
                if (view == null) {
                    h.q2.t.i0.k("mLlDeliveryPlat");
                }
                view.setVisibility(8);
                TextView textView2 = this.mTvDeliveryPlat;
                if (textView2 == null) {
                    h.q2.t.i0.k("mTvDeliveryPlat");
                }
                if (textView2 == null) {
                    h.q2.t.i0.f();
                }
                DeliveryBean deliveryBean8 = this.mDeliveryBean;
                textView2.setText(deliveryBean8 != null ? deliveryBean8.getDeliveryPlat() : null);
            } else {
                View view2 = this.mLlDeliveryPlat;
                if (view2 == null) {
                    h.q2.t.i0.k("mLlDeliveryPlat");
                }
                view2.setVisibility(0);
                TextView textView3 = this.mTvDeliveryPlat;
                if (textView3 == null) {
                    h.q2.t.i0.k("mTvDeliveryPlat");
                }
                if (textView3 == null) {
                    h.q2.t.i0.f();
                }
                ArrayList<String> arrayList = this.pickTypes;
                textView3.setText(arrayList.get(arrayList.size() - 1));
                EditText editText6 = this.mEtPlatName;
                if (editText6 == null) {
                    h.q2.t.i0.k("mEtPlatName");
                }
                if (editText6 == null) {
                    h.q2.t.i0.f();
                }
                DeliveryBean deliveryBean9 = this.mDeliveryBean;
                editText6.setText(deliveryBean9 != null ? deliveryBean9.getDeliveryPlat() : null);
            }
            DeliveryBean deliveryBean10 = this.mDeliveryBean;
            this.platformCode = deliveryBean10 != null ? deliveryBean10.getPlatform() : null;
            DeliveryBean deliveryBean11 = this.mDeliveryBean;
            transLocalMedia(deliveryBean11 != null ? deliveryBean11.getMailingTelDetails() : null);
        }
    }

    @Override // ui.activity.BasePicUploadActivity
    public void removeLocalData(int i2) {
        ArrayList<UploadFileBean> mailingTelDetails;
        this.mLocalMedia.remove(i2);
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
        DeliveryBean deliveryBean = this.mDeliveryBean;
        if (deliveryBean == null || (mailingTelDetails = deliveryBean.getMailingTelDetails()) == null) {
            return;
        }
        mailingTelDetails.remove(i2);
    }

    public final void setCaseInfoId(@i.c.a.d String str) {
        h.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_delivery_add;
    }

    public final void setMAdapter(@i.c.a.e ReportPictureSelAdapter reportPictureSelAdapter) {
        this.mAdapter = reportPictureSelAdapter;
    }

    public final void setMBtnConfirm(@i.c.a.d Button button) {
        h.q2.t.i0.f(button, "<set-?>");
        this.mBtnConfirm = button;
    }

    public final void setMDeliveryBean(@i.c.a.e DeliveryBean deliveryBean) {
        this.mDeliveryBean = deliveryBean;
    }

    public final void setMEtDeliveryAddress(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryAddress = editText;
    }

    public final void setMEtDeliveryName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryName = editText;
    }

    public final void setMEtDeliveryNum(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryNum = editText;
    }

    public final void setMEtDeliveryPhone(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryPhone = editText;
    }

    public final void setMEtDeliveryWp(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtDeliveryWp = editText;
    }

    public final void setMEtPlatName(@i.c.a.d EditText editText) {
        h.q2.t.i0.f(editText, "<set-?>");
        this.mEtPlatName = editText;
    }

    public final void setMIvBack(@i.c.a.d ImageView imageView) {
        h.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlDeliveryPlat(@i.c.a.d View view) {
        h.q2.t.i0.f(view, "<set-?>");
        this.mLlDeliveryPlat = view;
    }

    public final void setMLocalMedia(@i.c.a.d ArrayList<LocalMedia> arrayList) {
        h.q2.t.i0.f(arrayList, "<set-?>");
        this.mLocalMedia = arrayList;
    }

    public final void setMPresenter(@i.c.a.e DeliveryPresenter deliveryPresenter) {
        this.mPresenter = deliveryPresenter;
    }

    public final void setMRecyView(@i.c.a.d RecyclerView recyclerView) {
        h.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyView = recyclerView;
    }

    public final void setMTvDeliveryPlat(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDeliveryPlat = textView;
    }

    public final void setMTvDeliveryTime(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvDeliveryTime = textView;
    }

    public final void setMTvTitle(@i.c.a.d TextView textView) {
        h.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setPicker(@i.c.a.e b.a.a.e.h hVar) {
        this.picker = hVar;
    }

    public final void setScrollView(@i.c.a.d NestedScrollView nestedScrollView) {
        h.q2.t.i0.f(nestedScrollView, "<set-?>");
        this.scrollView = nestedScrollView;
    }

    public final void showPlatPiker() {
        if (this.pickTypes.size() == 0) {
            return;
        }
        this.picker = new b.a.a.e.h(this.mActivity, this.pickTypes);
        b.a.a.e.h hVar = this.picker;
        if (hVar != null) {
            hVar.x(3);
        }
        b.a.a.e.h hVar2 = this.picker;
        if (hVar2 != null) {
            hVar2.E(0);
        }
        b.a.a.e.h hVar3 = this.picker;
        if (hVar3 != null) {
            hVar3.C(15);
        }
        b.a.a.e.h hVar4 = this.picker;
        if (hVar4 != null) {
            hVar4.setOnOptionPickListener(new e());
        }
        b.a.a.e.h hVar5 = this.picker;
        if (hVar5 != null) {
            hVar5.m();
        }
    }

    public final void transLocalMedia(@i.c.a.e ArrayList<UploadFileBean> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mUploadPicList.addAll(arrayList);
            Iterator<UploadFileBean> it = arrayList.iterator();
            while (it.hasNext()) {
                UploadFileBean next = it.next();
                new UploadFileBean();
                UploadStateInfo uploadStateInfo = new UploadStateInfo();
                uploadStateInfo.setUploadState(2);
                this.mUploadStateList.add(uploadStateInfo);
                LocalMedia localMedia = new LocalMedia();
                h.q2.t.i0.a((Object) next, "bean");
                localMedia.setPath(next.getLocalPath());
                localMedia.setFileName(next.getFileName());
                this.mLocalMedia.add(localMedia);
            }
        }
        ReportPictureSelAdapter reportPictureSelAdapter = this.mAdapter;
        if (reportPictureSelAdapter != null) {
            reportPictureSelAdapter.notifyDataSetChanged();
        }
    }

    public final void upLoadMedia() {
        if (this.mLocalMedia.size() <= 0) {
            pageFileFinish();
            return;
        }
        commitDeal();
        Button button = this.mBtnConfirm;
        if (button == null) {
            h.q2.t.i0.k("mBtnConfirm");
        }
        button.setEnabled(false);
    }
}
