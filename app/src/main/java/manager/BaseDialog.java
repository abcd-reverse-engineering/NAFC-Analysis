package manager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* loaded from: classes2.dex */
public class BaseDialog extends Dialog {
    public static final int BOTTOM = 0;
    public static final int CENTER = 2;
    public static final int TOP = 1;
    public static final float WARPHEIGHT = -2.0f;
    public static final float WARPWIDTH = -2.0f;
    public Context context;

    /* renamed from: d, reason: collision with root package name */
    private Display f17303d;
    public DisplayMetrics dm;
    public int gravityLayout;
    public double heightDialog;
    public float heightDialogdp;
    public WindowManager.LayoutParams lp;
    private Window mWindow;
    public double widthDialog;
    public float widthDialogdp;

    public BaseDialog(Context context) {
        super(context);
        this.widthDialog = 0.0d;
        this.heightDialog = 0.0d;
        this.heightDialogdp = 0.0f;
        this.widthDialogdp = 0.0f;
        this.gravityLayout = 0;
        this.context = context;
        initWindowState();
    }

    private void initWindowState() {
        this.mWindow = getWindow();
        this.lp = this.mWindow.getAttributes();
        WindowManager windowManager = ((Activity) this.context).getWindowManager();
        this.f17303d = windowManager.getDefaultDisplay();
        this.dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(this.dm);
    }

    public int dp2px(float f2) {
        return (int) ((f2 * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getStatusBarHeight() throws IllegalAccessException, InstantiationException, ClassNotFoundException, NumberFormatException {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return this.context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public <T extends View> T getViewById(int i2) {
        return (T) findViewById(i2);
    }

    public void initOnCreate() {
        WindowManager.LayoutParams layoutParams = this.lp;
        layoutParams.gravity = this.gravityLayout;
        if (this.widthDialog > 0.0d) {
            layoutParams.width = (int) (this.f17303d.getWidth() * this.widthDialog);
        } else {
            float f2 = this.widthDialogdp;
            if (f2 > 0.0f) {
                layoutParams.width = dp2px(f2);
            } else if (f2 == -2.0f) {
                layoutParams.width = -2;
            } else {
                layoutParams.width = this.f17303d.getWidth();
            }
        }
        if (this.heightDialog > 0.0d) {
            this.lp.height = (int) (this.f17303d.getHeight() * this.heightDialog);
        } else {
            float f3 = this.heightDialogdp;
            if (f3 > 0.0f) {
                this.lp.height = dp2px(f3);
            } else if (f3 == -2.0f) {
                this.lp.height = -2;
            } else {
                this.lp.height = this.f17303d.getHeight() - getStatusBarHeight();
            }
        }
        this.mWindow.setAttributes(this.lp);
    }

    public void setGravityLayout(int i2) {
        if (i2 == 0) {
            this.gravityLayout = 80;
        }
        if (1 == i2) {
            this.gravityLayout = 48;
        }
        if (2 == i2) {
            this.gravityLayout = 17;
        }
    }

    public void setHeightDialog(double d2) {
        this.heightDialog = d2;
    }

    public void setHeightDialogdp(float f2) {
        this.heightDialogdp = f2;
    }

    public void setWidthDialog(double d2) {
        this.widthDialog = d2;
    }

    public void setWidthDialogdp(float f2) {
        this.widthDialogdp = f2;
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.widthDialog = 0.0d;
        this.heightDialog = 0.0d;
        this.heightDialogdp = 0.0f;
        this.widthDialogdp = 0.0f;
        this.gravityLayout = 0;
        this.context = context;
        initWindowState();
    }
}
