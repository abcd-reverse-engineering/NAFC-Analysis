package util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import bean.APIH5Bean;
import com.hicorenational.antifraud.R;
import interfaces.IBaseBeanCall;
import java.lang.reflect.Type;
import manager.BaseDialog;
import manager.UpdateManager;
import network.APIException;
import network.DownloadInfo;
import network.MiddleSubscriber;
import network.account.APIresult;
import ui.callview.UpdateAppView;
import ui.presenter.UpdateAppPresenter;

/* loaded from: classes2.dex */
public class UpdateUtil implements UpdateAppView {
    private static IBaseBeanCall baseBeanCall = null;
    public static boolean isCheckUpdateAlready = false;
    private static Activity mActivity;
    private static UpdateAppPresenter mPresenter;
    private static UpdateUtil updateUt;
    private static BaseDialog uppVerDlg;

    class a extends UpdateManager.DownLoadBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f20705a;

        a(TextView textView) {
            this.f20705a = textView;
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onCompleted(String str) {
            super.onCompleted(str);
            this.f20705a.setText("立即安装");
            this.f20705a.setEnabled(true);
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onDownLoading(int i2) {
            super.onDownLoading(i2);
            if (UpdateUtil.uppVerDlg == null || i2 <= 0 || i2 > 100) {
                return;
            }
            this.f20705a.setText("下载中... " + i2 + "%");
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onError() {
            super.onError();
            w1.a("请重新下载");
            this.f20705a.setText("立即更新");
            this.f20705a.setEnabled(true);
            UpdateManager.getInstance().stopThread(true);
        }

        @Override // manager.UpdateManager.DownLoadBack
        public void onFinaly() {
            if (UpdateUtil.uppVerDlg == null || !UpdateUtil.uppVerDlg.isShowing()) {
                return;
            }
            UpdateUtil.uppVerDlg.dismiss();
        }
    }

    class b extends MiddleSubscriber<APIresult<APIH5Bean>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f20707a;

        b(DownloadInfo downloadInfo) {
            this.f20707a = downloadInfo;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return APIH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            onErrorMiddle(APIException.getApiExcept("获取更新地址失败，请重试~"));
            n1.a("hsc", "h5Url  onErrorMiddle===");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<APIH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null) {
                UpdateUtil.this.showDialogUpdate(this.f20707a, null);
                return;
            }
            String value = aPIresult.getData().getValue();
            n1.a("hsc", "h5Url===" + value);
            if (TextUtils.isEmpty(value)) {
                UpdateUtil.this.showDialogUpdate(this.f20707a, null);
            } else {
                UpdateUtil.this.showDialogUpdate(this.f20707a, value);
            }
        }
    }

    private UpdateUtil() {
        mPresenter = new UpdateAppPresenter(mActivity, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateApp(TextView textView, DownloadInfo downloadInfo, String str) {
        if (!q1.f()) {
            w1.a("请检查网络连接");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            w1.a("更新异常，请重试");
            return;
        }
        textView.setText("下载中... 0%");
        textView.setEnabled(false);
        UpdateManager.getInstance().downloadApp(false, str, "{\"filePath\":\"" + downloadInfo.getUrl() + "\"}", new a(textView));
    }

    private void requestAppDownlaod(DownloadInfo downloadInfo) {
        mPresenter.requestAppDownload(new b(downloadInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogUpdate(final DownloadInfo downloadInfo, final String str) {
        Activity activity;
        if (downloadInfo == null || (activity = mActivity) == null || activity.isFinishing()) {
            return;
        }
        BaseDialog baseDialog = uppVerDlg;
        if (baseDialog == null || !baseDialog.isShowing()) {
            uppVerDlg = new BaseDialog(mActivity, R.style.base_dialog_style);
            uppVerDlg.setContentView(R.layout.dialog_update);
            uppVerDlg.setGravityLayout(2);
            uppVerDlg.setWidthDialog(-2.0d);
            uppVerDlg.setHeightDialog(-2.0d);
            uppVerDlg.setCancelable(false);
            uppVerDlg.setCanceledOnTouchOutside(false);
            uppVerDlg.initOnCreate();
            uppVerDlg.show();
            TextView textView = (TextView) uppVerDlg.findViewById(R.id.update_title);
            TextView textView2 = (TextView) uppVerDlg.findViewById(R.id.update_content);
            final TextView textView3 = (TextView) uppVerDlg.findViewById(R.id.update);
            ImageView imageView = (ImageView) uppVerDlg.findViewById(R.id.update_close);
            if (downloadInfo.isIsForcedVersion()) {
                imageView.setVisibility(4);
                u1.b("update_home", "");
            } else {
                imageView.setVisibility(0);
            }
            String version = downloadInfo.getVersion();
            String content = downloadInfo.getContent();
            if (TextUtils.isEmpty(version)) {
                version = "";
            }
            String strReplace = TextUtils.isEmpty(content) ? "" : content.replace("\\n", "\n").replace(c.c.a.b.a.a.f3100g, "");
            textView.setText(ExifInterface.GPS_MEASUREMENT_INTERRUPTED + version);
            textView2.setText(strReplace);
            if (UpdateManager.getInstance().existsApk()) {
                textView3.setText("立即安装");
            }
            textView3.setOnClickListener(new View.OnClickListener() { // from class: util.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f20952a.a(str, textView3, downloadInfo, view);
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: util.s0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateUtil.a(view);
                }
            });
        }
    }

    public static UpdateUtil updateAppOnly(Activity activity, IBaseBeanCall iBaseBeanCall) {
        mActivity = activity;
        baseBeanCall = iBaseBeanCall;
        if (updateUt == null) {
            updateUt = new UpdateUtil();
        }
        mPresenter.principalHttp(baseBeanCall);
        return updateUt;
    }

    private void updateShowMes(boolean z, IBaseBeanCall iBaseBeanCall, APIresult<DownloadInfo> aPIresult) {
        if (iBaseBeanCall != null) {
            if (z) {
                iBaseBeanCall.onsuccess(aPIresult);
            } else {
                iBaseBeanCall.onfail();
            }
        }
    }

    public /* synthetic */ void a(String str, TextView textView, DownloadInfo downloadInfo, View view) {
        if (UpdateManager.getInstance().existsApk()) {
            UpdateManager.getInstance().onReinstall();
        } else {
            util.permissionutil.c.a(mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new x1(this, str, textView, downloadInfo));
        }
    }

    @Override // ui.callview.UpdateAppView
    public void onSuccRequest(APIresult<DownloadInfo> aPIresult, IBaseBeanCall iBaseBeanCall) {
        if (aPIresult != null) {
            if (aPIresult.getCode() != 0) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                n1.a("updateApp onNext-->", aPIresult.getMsg());
                return;
            }
            DownloadInfo data = aPIresult.getData();
            try {
                if (data.getInnerVersion() > r1.f()) {
                    u1.b(u1.p, data.getFileMD5());
                    requestAppDownlaod(data);
                    updateShowMes(true, iBaseBeanCall, aPIresult);
                } else {
                    UpdateManager.getInstance().deleteApk();
                    updateShowMes(false, iBaseBeanCall, aPIresult);
                }
            } catch (Exception e2) {
                updateShowMes(false, iBaseBeanCall, aPIresult);
                n1.b("updateApp onNext catch>", e2.getMessage());
            }
        }
    }

    static /* synthetic */ void a(View view) {
        u1.b("update_home", y1.d("yyyy-MM-dd"));
        IBaseBeanCall iBaseBeanCall = baseBeanCall;
        if (iBaseBeanCall != null) {
            iBaseBeanCall.onClose();
        }
        UpdateManager.getInstance().stopThread(true);
        BaseDialog baseDialog = uppVerDlg;
        if (baseDialog != null) {
            baseDialog.dismiss();
        }
    }
}
