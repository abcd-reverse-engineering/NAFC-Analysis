package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.BlockFileBean;
import bean.OssFileInfo;
import bean.OssFileRequest;
import bean.SurveyAppBean;
import bean.module.ModuelConfig;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import interfaces.IOssPicCallback;
import interfaces.PermissionsListener;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.activity.AppSelectedActivity;
import ui.activity.ReportAppAddActivity;
import ui.callview.ReportAppView;
import ui.model.OSSModelPresent;
import util.k1;
import util.o1;
import util.w1;
import util.y1;

/* loaded from: classes2.dex */
public class ReportAppPresenter extends OSSModelPresent<ReportAppView> {
    private BlockFileBean blockApp;
    private BlockFileBean blockLogo;
    private BlockFileBean blockQrcode;
    private String caseInfoId;
    private HolderAdapte mAdapter;
    private List<SurveyAppBean> mAppBeans;
    boolean upApp;
    boolean upLogo;
    boolean upZXing;

    public class HolderAdapte extends RecyclerView.Adapter<a> {

        /* renamed from: a, reason: collision with root package name */
        private Context f20038a;

        class a extends RecyclerView.ViewHolder {

            /* renamed from: a, reason: collision with root package name */
            public View f20040a;

            /* renamed from: b, reason: collision with root package name */
            public TextView f20041b;

            /* renamed from: c, reason: collision with root package name */
            public TextView f20042c;

            /* renamed from: d, reason: collision with root package name */
            public TextView f20043d;

            /* renamed from: e, reason: collision with root package name */
            public View f20044e;

            /* renamed from: f, reason: collision with root package name */
            public View f20045f;

            /* renamed from: g, reason: collision with root package name */
            public ImageView f20046g;

            public a(View view) {
                super(view);
                this.f20040a = view.findViewById(R.id.fl_view);
                this.f20041b = (TextView) view.findViewById(R.id.tv_app_name);
                this.f20044e = view.findViewById(R.id.ll_app_pkg);
                this.f20042c = (TextView) view.findViewById(R.id.tv_app_pkg);
                this.f20045f = view.findViewById(R.id.ll_app_vers);
                this.f20043d = (TextView) view.findViewById(R.id.tv_app_vers);
                this.f20046g = (ImageView) view.findViewById(R.id.iv_item_det);
            }
        }

        public HolderAdapte(Context context) {
            this.f20038a = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(a aVar, final int i2) {
            if (ReportAppPresenter.this.mAppBeans.size() > 0) {
                SurveyAppBean surveyAppBean = (SurveyAppBean) ReportAppPresenter.this.mAppBeans.get(i2);
                aVar.f20041b.setText(surveyAppBean.getAppName());
                if (y1.p(surveyAppBean.getPackageName())) {
                    aVar.f20044e.setVisibility(8);
                } else {
                    aVar.f20044e.setVisibility(0);
                    aVar.f20042c.setText(surveyAppBean.getPackageName());
                }
                if (y1.p(surveyAppBean.getAppVersion())) {
                    aVar.f20045f.setVisibility(8);
                } else {
                    aVar.f20045f.setVisibility(0);
                    aVar.f20043d.setText(surveyAppBean.getAppVersion());
                }
            }
            aVar.f20040a.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20237a.a(i2, view);
                }
            });
            aVar.f20046g.setOnClickListener(new View.OnClickListener() { // from class: ui.presenter.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20239a.b(i2, view);
                }
            });
        }

        public /* synthetic */ void b(int i2, View view) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onItemDelet(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ReportAppPresenter.this.mAppBeans.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new a(LayoutInflater.from(this.f20038a).inflate(R.layout.item_report_app, viewGroup, false));
        }

        public /* synthetic */ void a(int i2, View view) {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) ReportAppAddActivity.class);
            intent.putExtra(k1.C0, ReportAppPresenter.this.caseInfoId);
            intent.putExtra(k1.F0, i2);
            intent.putExtra(k1.f20845c, (Serializable) ReportAppPresenter.this.mAppBeans.get(i2));
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class a implements PermissionsListener {
        a() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(ReportAppPresenter.this.mActivity, (Class<?>) AppSelectedActivity.class);
            intent.putExtra(AppSelectedActivity.f17651h, 2);
            intent.putExtra(k1.f20846d, 2);
            intent.putExtra("extra_select_limite", 1);
            ReportAppPresenter.this.mActivity.startActivity(intent);
        }
    }

    class b implements PermissionsListener {
        b() {
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(ReportAppPresenter.this.mActivity, list, z, true, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            j.e.a(ReportAppPresenter.this.mActivity, 200L, PictureMimeType.ofImage(), 1).forResult(PictureConfig.CHOOSE_REQUEST);
        }
    }

    class c extends MiddleSubscriber<APIresult<List<SurveyAppBean>>> {

        class a extends com.google.gson.d0.a<List<SurveyAppBean>> {
            a() {
            }
        }

        c() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<SurveyAppBean>> aPIresult) {
            if (aPIresult.getCode() != 0 || aPIresult.getData() == null) {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, new ArrayList());
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(1, aPIresult.getData());
            }
        }
    }

    class d extends MiddleSubscriber<APIresult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20052a;

        d(int i2) {
            this.f20052a = i2;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.f20052a, null);
            }
        }
    }

    class e extends MiddleSubscriber<APIresult> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) throws Resources.NotFoundException {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) throws Resources.NotFoundException {
            if (aPIresult == null || aPIresult.getCode() != 0) {
                onErrorMiddle(APIException.getApiExcept(aPIresult.getMsg()));
            } else {
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(4, null);
            }
        }
    }

    class f implements IOssPicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BlockFileBean f20055a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f20056b;

        f(BlockFileBean blockFileBean, int i2) {
            this.f20055a = blockFileBean;
            this.f20056b = i2;
        }

        @Override // interfaces.IOssPicCallback
        public void onFail(String str) {
            ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onFailRequest();
        }

        @Override // interfaces.IOssPicCallback
        public void onSuccess(OssFileInfo ossFileInfo) {
            if (ossFileInfo != null) {
                this.f20055a.setFilePath(ossFileInfo.getFilePath());
                this.f20055a.setFileMd5(ossFileInfo.getFileMd5());
                this.f20055a.setFileSHA1(ossFileInfo.getFileSHA1());
                ((ReportAppView) ((OSSModelPresent) ReportAppPresenter.this).mvpView).onSuccessHandle(this.f20056b, null);
            }
        }
    }

    public ReportAppPresenter(Activity activity, String str, ReportAppView reportAppView) {
        super(activity, reportAppView);
        this.mAppBeans = new ArrayList();
        this.caseInfoId = str;
    }

    private String getMd5(String str, String str2) {
        return TextUtils.isEmpty(str) ? o1.a(new File(str2)) : str;
    }

    private void httpHandleApp(SurveyAppBean surveyAppBean, int i2) {
        surveyCaseApp(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.N1), surveyAppBean, new d(i2));
    }

    public void addAppCheck() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new a());
    }

    public void addPicCheck() {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.z}, new b());
    }

    public void addSurveyApp(String str, String str2, String str3) {
        if (!this.upApp) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(12, null);
            return;
        }
        this.blockApp = new BlockFileBean();
        this.blockApp.setFileID(str);
        this.blockApp.setLocalPath(str2);
        this.blockApp.setFileName(str3);
        uploadFile(12, this.blockApp);
    }

    public void addSurveyLogo(String str, String str2, String str3) {
        if (!this.upLogo) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(10, null);
            return;
        }
        this.blockLogo = new BlockFileBean();
        this.blockLogo.setFileID(str);
        this.blockLogo.setLocalPath(str2);
        this.blockLogo.setFileName(str3);
        uploadFile(10, this.blockLogo);
    }

    public void addSurveyQrcode(String str, String str2, String str3) {
        if (!this.upZXing) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(11, null);
            return;
        }
        this.blockQrcode = new BlockFileBean();
        this.blockQrcode.setFileID(str);
        this.blockQrcode.setLocalPath(str2);
        this.blockQrcode.setFileName(str3);
        uploadFile(11, this.blockQrcode);
    }

    public void deleteCaseAppInfo(String str) {
        String strA = d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.O1);
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        deleteCaseAppInfo(strA, map, new e());
    }

    public void getSurveyAppList(String str) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", str);
        getSurveyAppList(d.a.a(ModuelConfig.MODEL_CASEXC, 4, e.b.M1), map, new c());
    }

    public void handleAppInfo(SurveyAppBean surveyAppBean, int i2) {
        surveyAppBean.setPackageFile(this.blockApp);
        surveyAppBean.setQrCodeFile(this.blockQrcode);
        surveyAppBean.setAppLogoFile(this.blockLogo);
        httpHandleApp(surveyAppBean, i2);
    }

    public void handleUpdate(SurveyAppBean surveyAppBean, boolean z, boolean z2, boolean z3) {
        this.upLogo = z3;
        this.upZXing = z2;
        this.upApp = z;
        if (TextUtils.isEmpty(surveyAppBean.getAppLogoPath())) {
            ((ReportAppView) ((OSSModelPresent) this).mvpView).onSuccessHandle(10, null);
        } else {
            addSurveyLogo(surveyAppBean.getAppLogoFileID(), surveyAppBean.getAppLogoPath(), surveyAppBean.getAppLogoName());
        }
    }

    public void initRecycleWeb(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HolderAdapte(this.mActivity);
        recyclerView.setAdapter(this.mAdapter);
    }

    public void setListData(List<SurveyAppBean> list) {
        if (list != null) {
            this.mAppBeans = list;
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void uploadFile(int i2, BlockFileBean blockFileBean) {
        OssFileRequest ossFileRequest = new OssFileRequest();
        ossFileRequest.setType("5");
        ossFileRequest.setFilePath(blockFileBean.getLocalPath());
        upFileToOss(ossFileRequest, new f(blockFileBean, i2));
    }
}
