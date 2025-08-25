package manager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.io.IOException;
import ui.Hicore;
import ui.c;
import util.f1;
import util.o1;
import util.u1;

/* loaded from: classes2.dex */
public class UpdateManager {
    private static final int COMPLETED = 2;
    private static final int ERROR = 4;
    private static final int INSTALL_FINALY = 5;
    public static final int REQUESTCODE_INSTALL_PERMISS_CODE = 50001;
    private static final int RESTART = 6;
    private static final String UPDATE_FILE_NAME = "update.apk";
    private static final String UPDATE_FILE_PATH = "/downloads";
    private DownLoadBack mDownLoadBack;
    private String mDownloadPath;
    private DownloadHandler mHandler;
    private String mUrl;
    boolean stopTh;

    public static class DownLoadBack {
        public void onCompleted(String str) {
            UpdateManager.getInstance().completed(str);
        }

        public void onDownLoading(int i2) {
        }

        public void onError() {
        }

        public void onFinaly() {
        }
    }

    private static class DownloadHandler extends Handler {
        private DownloadHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 2) {
                UpdateManager.getInstance().onCompleted();
                return;
            }
            if (i2 == 4) {
                UpdateManager.getInstance().onError();
            } else if (i2 != 5) {
                UpdateManager.getInstance().onDownLoading(((Integer) message.obj).intValue());
            } else {
                UpdateManager.getInstance().onFinaly();
            }
        }
    }

    private class DownloadThread extends Thread {
        private String mParam;
        private String mQuestType;
        private String mUrl;

        /* JADX WARN: Removed duplicated region for block: B:145:0x0205 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:159:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:168:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 526
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: manager.UpdateManager.DownloadThread.run():void");
        }

        private DownloadThread(String str) {
            this.mUrl = str;
        }

        private DownloadThread(String str, String str2) {
            this.mUrl = str;
            this.mParam = str2;
        }

        private DownloadThread(String str, String str2, String str3) {
            this.mUrl = str;
            this.mParam = str2;
            this.mQuestType = str3;
        }
    }

    private static class SingletonHolder {
        private static final UpdateManager INSTANCE = new UpdateManager();

        private SingletonHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completed(String str) throws IOException {
        Activity activityC;
        try {
            activityC = c.i().c();
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 26 && !Hicore.getApp().getPackageManager().canRequestPackageInstalls()) {
            activityC.startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + activityC.getPackageName())), REQUESTCODE_INSTALL_PERMISS_CODE);
            return;
        }
        try {
            Runtime.getRuntime().exec("chmod 777 " + str + File.separator + UPDATE_FILE_NAME);
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(CommonNetImpl.FLAG_AUTH);
        File file = new File(str + File.separator + UPDATE_FILE_NAME);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(5);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(Hicore.getApp(), Hicore.getApp().getPackageName() + ".fileprovider", file);
            intent.addFlags(1);
            intent.addFlags(2);
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        activityC.startActivity(intent);
        c.i().d();
        e3.printStackTrace();
        c.i().d();
    }

    private boolean doNormalSignCheck(File file) {
        return u1.b(u1.p).equalsIgnoreCase(o1.a(file));
    }

    public static UpdateManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private boolean isDownloading() {
        return this.mHandler != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleted() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onCompleted(this.mDownloadPath);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDownLoading(int i2) {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onDownLoading(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFinaly() {
        DownLoadBack downLoadBack = this.mDownLoadBack;
        if (downLoadBack != null) {
            downLoadBack.onFinaly();
        }
        this.mUrl = null;
        this.mHandler = null;
        this.mDownLoadBack = null;
    }

    public void deleteApk() {
        File file = new File(this.mDownloadPath + File.separator + UPDATE_FILE_NAME);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public void downloadApp(boolean z, String str, String str2, DownLoadBack downLoadBack) {
        this.mUrl = str;
        this.stopTh = false;
        if (downLoadBack != null) {
            this.mDownLoadBack = downLoadBack;
        } else {
            this.mDownLoadBack = new DownLoadBack();
        }
        this.mHandler = new DownloadHandler();
        if (z) {
            new DownloadThread(str, str2, "POST").start();
        } else {
            new DownloadThread(str, str2, "GET").start();
        }
    }

    public boolean existsApk() {
        File file = new File(this.mDownloadPath + File.separator + UPDATE_FILE_NAME);
        if (!file.exists()) {
            return false;
        }
        if (doNormalSignCheck(file)) {
            return true;
        }
        file.delete();
        return false;
    }

    public void onReinstall() {
        if (TextUtils.isEmpty(this.mDownloadPath)) {
            return;
        }
        completed(this.mDownloadPath);
    }

    public void stopThread(boolean z) {
        deleteApk();
        this.stopTh = z;
        this.mHandler = null;
    }

    private UpdateManager() {
        this.mDownloadPath = f1.a() + UPDATE_FILE_PATH;
    }
}
