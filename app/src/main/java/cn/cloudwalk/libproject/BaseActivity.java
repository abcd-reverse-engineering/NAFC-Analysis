package cn.cloudwalk.libproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import cn.cloudwalk.libproject.util.LogUtils;
import cn.cloudwalk.libproject.util.Util;
import java.io.File;

/* loaded from: classes.dex */
public class BaseActivity extends Activity {
    public void IntentPhoto(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "选择图片"), i2);
        } else {
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.GET_CONTENT");
            intent2.setType("image/*");
            startActivityForResult(Intent.createChooser(intent2, "选择图片"), i2);
        }
    }

    public File intentCamera(int i2, Context context) {
        Uri uriFromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File file = new File(Util.getDiskCacheDir(context), "cameraImg" + System.currentTimeMillis() + ".jpg");
        LogUtils.LOGE("--camera-dir", file.getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 24) {
            String str = Builder.authorites;
            if (TextUtils.isEmpty(str)) {
                str = "cn.cloudwalk.dev.mobilebank.fileprovider";
            }
            uriFromFile = FileProvider.getUriForFile(context, str, file);
        } else {
            uriFromFile = Uri.fromFile(file);
        }
        intent.putExtra("output", uriFromFile);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, i2);
        return file;
    }

    public void makeToast(String str) {
        Toast.makeText(this, str + "", 1).show();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void startCls(Class cls) {
        startActivity(new Intent(this, (Class<?>) cls));
    }
}
