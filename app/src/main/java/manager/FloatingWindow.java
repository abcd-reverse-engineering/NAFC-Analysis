package manager;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import ui.activity.BaseProgressUploadActivity;
import util.c1;

/* loaded from: classes2.dex */
public class FloatingWindow implements IFloatingWindow {
    public static ArrayList<String> phoneWindow = new ArrayList<>();
    private View mContentView;
    private Context mContext;
    private boolean mIsShowing = false;
    private WindowManager.LayoutParams mLayoutParams;

    public FloatingWindow(@NonNull Context context) {
        this.mContext = context;
    }

    @Override // manager.IFloatingWindow
    public void dismiss() {
        FloatWindowManager.getFWManager().hideWindow(this);
        this.mIsShowing = false;
    }

    public boolean equals(Object obj) {
        return obj instanceof IFloatingWindow ? ((IFloatingWindow) obj).getContentView() == getContentView() : super.equals(obj);
    }

    @Override // manager.IFloatingWindow
    public <T extends View> T findViewById(int i2) {
        View view = this.mContentView;
        if (view != null) {
            return (T) view.findViewById(i2);
        }
        throw new NullPointerException("please invoke setContentView method first");
    }

    @Override // manager.IFloatingWindow
    public List<IFloatingWindow> getAllWindow() {
        return FloatWindowManager.getFWManager().getAllWindow();
    }

    @Override // manager.IFloatingWindow
    public WindowManager.LayoutParams getCallWarnLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
        }
        layoutParams.gravity = 48;
        layoutParams.height = -2;
        layoutParams.x = 0;
        layoutParams.y = c1.a(Hicore.getApp(), 35.0f);
        layoutParams.format = 1;
        layoutParams.flags = 7143848;
        return layoutParams;
    }

    @Override // manager.IFloatingWindow
    public View getContentView() {
        return this.mContentView;
    }

    @Override // manager.IFloatingWindow
    public Context getContext() {
        return this.mContext;
    }

    @Override // manager.IFloatingWindow
    public WindowManager.LayoutParams getLayoutParams() {
        return this.mLayoutParams;
    }

    @Override // manager.IFloatingWindow
    public WindowManager.LayoutParams getRecordTimeLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
        }
        layoutParams.gravity = 17;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        return layoutParams;
    }

    @Override // manager.IFloatingWindow
    public WindowManager.LayoutParams getSMSWarnLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
        }
        layoutParams.gravity = 48;
        layoutParams.height = -2;
        layoutParams.x = 0;
        layoutParams.y = c1.a(Hicore.getApp(), 35.0f);
        layoutParams.format = 1;
        layoutParams.flags = 7143848;
        return layoutParams;
    }

    @Override // manager.IFloatingWindow
    public WindowManager.LayoutParams getWarnGuideLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_2;
        }
        layoutParams.gravity = 48;
        layoutParams.height = -2;
        layoutParams.x = 0;
        layoutParams.y = c1.a(Hicore.getApp(), 35.0f);
        layoutParams.format = 1;
        layoutParams.flags = 7143848;
        return layoutParams;
    }

    @Override // manager.IFloatingWindow
    public boolean isShowing() {
        return this.mIsShowing;
    }

    @Override // manager.IFloatingWindow
    public void removeAll() {
        FloatWindowManager.getFWManager().removeAllWindow();
        this.mIsShowing = false;
    }

    @Override // manager.IFloatingWindow
    public void setContentView(@NonNull View view) {
        this.mContentView = view;
    }

    @Override // manager.IFloatingWindow
    public void setParams(WindowManager.LayoutParams layoutParams) {
        this.mLayoutParams = layoutParams;
    }

    @Override // manager.IFloatingWindow
    public void show() {
        if (this.mIsShowing) {
            return;
        }
        if (this.mLayoutParams == null) {
            this.mLayoutParams = getCallWarnLayoutParams();
        }
        this.mIsShowing = FloatWindowManager.getFWManager().showWindow(this);
    }

    @Override // manager.IFloatingWindow
    public void setContentView(int i2) {
        this.mContentView = LayoutInflater.from(this.mContext).inflate(i2, (ViewGroup) null);
    }
}
