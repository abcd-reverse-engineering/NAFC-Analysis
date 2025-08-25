package ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import bean.PushEntity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import com.lxj.xpopup.b;
import com.lxj.xpopup.core.BasePopupView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import interfaces.IBaseBeanCall;
import interfaces.IClickListener;
import interfaces.IOneClickListener;
import java.util.List;
import network.http.AddressHttp;
import ui.Hicore;
import ui.view.HuaKuaiWindow;
import util.UpdateUtil;
import util.y1;

/* loaded from: classes2.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int PERMISSION_CODE = 999;
    public static final String PERMISSION_TYPE_NUMBER = "PERMISSION_TYPE_NUMBER";
    public static boolean haveLiuhai;
    public static int liuhaiHeight;
    public Activity mActivity;
    private ui.view.s mProgressDialogBar;
    public Typeface typ_ME;
    Unbinder unbinder;
    private String mRegionId = "";
    public boolean isPerssionChecking = false;

    class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            util.b1.a();
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + BaseActivity.this.mActivity.getPackageName()));
            BaseActivity.this.startActivity(intent);
        }
    }

    class b extends AddressHttp.MyPicker {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f17695a;

        b(TextView textView) {
            this.f17695a = textView;
        }

        @Override // network.http.AddressHttp.MyPicker, b.a.a.e.a.e
        public void onAddressPicked(b.a.a.d.k kVar, b.a.a.d.d dVar, b.a.a.d.e eVar) {
            if (kVar == null || dVar == null || eVar == null) {
                BaseActivity.this.mRegionId = "";
                this.f17695a.setText("");
                util.w1.a("结果出错！");
                return;
            }
            BaseActivity.this.mRegionId = eVar.getAreaId();
            this.f17695a.setText(kVar.getName() + dVar.getName() + eVar.getName());
        }

        @Override // network.http.AddressHttp.MyPicker
        public void onClear() {
            super.onClear();
            BaseActivity.this.mRegionId = "";
            this.f17695a.setText("");
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseActivity.this.isPerssionChecking = false;
        }
    }

    private String getTruePath(String str) throws IllegalArgumentException {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getAuthority())) {
            return uri.getPath();
        }
        Cursor cursorQuery = getContentResolver().query(uri, null, null, null, null);
        if (cursorQuery != null) {
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(columnIndexOrThrow);
                cursorQuery.close();
                return string;
            }
        }
        return "";
    }

    private void setBlackStatusBar() {
        ui.statusbarcompat.b.a((Activity) this, getResources().getColor(R.color.black), false);
    }

    private void setWhiteStatusBar() {
        ui.statusbarcompat.b.a((Activity) this, getResources().getColor(R.color.white), true);
    }

    public void changePath(List<LocalMedia> list) throws IllegalArgumentException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setPath(getTruePath(list.get(i2).getPath()));
        }
    }

    public void getPushData() {
        try {
            PushEntity pushEntity = (PushEntity) getIntent().getSerializableExtra(util.k1.f20845c);
            if (pushEntity != null) {
                receiver.e.a(pushEntity.getExtra(), this);
            }
        } catch (Exception unused) {
        }
    }

    public String getmRegionId() {
        return this.mRegionId;
    }

    public void hideProgressDialog() {
        ui.view.s sVar = this.mProgressDialogBar;
        if (sVar == null || !sVar.isShowing()) {
            return;
        }
        this.mProgressDialogBar.dismiss();
    }

    public void hideSoftInput() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void initPage();

    public boolean isDouble() {
        return Hicore.getApp().isDouble();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mActivity = this;
        this.typ_ME = Typeface.createFromAsset(getAssets(), "DIN-Medium.otf");
        util.v1.a((Activity) this);
        if (setLayoutView() != 0) {
            setContentView(setLayoutView());
        }
        this.unbinder = ButterKnife.bind(this);
        setStatusBar();
        initPage();
        PushAgent.getInstance(this).onAppStart();
        haveLiuhai = ui.statusbarcompat.a.b(this);
        liuhaiHeight = ui.statusbarcompat.a.a(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void regionShow(TextView textView, Activity activity) {
        AddressHttp.getAddSint(activity).regionPick(new b(textView));
    }

    public void resetPerssionChecking() {
        y1.f21027b.postDelayed(new c(), 500L);
    }

    public abstract int setLayoutView();

    public void setRegionId(String str) {
        this.mRegionId = str;
    }

    protected void setStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            setWhiteStatusBar();
        } else {
            setBlackStatusBar();
        }
        ui.statusbarcompat.b.a((Activity) this, true, true);
    }

    public void showDlogPrimssExcept() {
        util.b1.a(this.mActivity, "国家反诈中心”未取得权限，这样会导致此功能无法使用", "取消", "去授权", new a());
    }

    public void showProgressDialog() {
        showProgressDialog("加载中...");
    }

    public void showSoftInput(EditText editText) {
        editText.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(editText, 1);
    }

    public void startActivity(Class<?> cls) {
        startActivity(cls, (Bundle) null);
    }

    public void toYanzheng(IOneClickListener iOneClickListener) {
        hideSoftInput();
        new b.a(this.mActivity).a((BasePopupView) new HuaKuaiWindow(this.mActivity, iOneClickListener)).r();
    }

    public void updateAppWithTime(IBaseBeanCall iBaseBeanCall) {
        if (UpdateUtil.isCheckUpdateAlready) {
            if (iBaseBeanCall != null) {
                iBaseBeanCall.onfail();
                return;
            }
            return;
        }
        if (!TextUtils.equals(y1.d("yyyy-MM-dd"), util.u1.a("update_home", ""))) {
            UpdateUtil.updateAppOnly(this.mActivity, iBaseBeanCall);
        } else if (iBaseBeanCall != null) {
            iBaseBeanCall.onfail();
        }
    }

    public void showProgressDialog(boolean z) {
        showProgressDialog("加载中...", z);
    }

    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void showProgressDialog(String str) {
        showProgressDialog(str, true);
    }

    public void showProgressDialog(String str, boolean z) {
        if (isFinishing()) {
            return;
        }
        ui.view.s sVar = this.mProgressDialogBar;
        if (sVar == null) {
            this.mProgressDialogBar = ui.view.s.a(this);
        } else if (sVar.isShowing()) {
            return;
        }
        this.mProgressDialogBar.a(str);
        this.mProgressDialogBar.setCanceledOnTouchOutside(false);
        this.mProgressDialogBar.setCancelable(z);
        this.mProgressDialogBar.show();
    }
}
