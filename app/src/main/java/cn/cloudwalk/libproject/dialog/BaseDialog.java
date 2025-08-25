package cn.cloudwalk.libproject.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import cn.cloudwalk.libproject.R;

/* loaded from: classes.dex */
public abstract class BaseDialog extends Dialog implements View.OnClickListener {
    protected int animType;
    protected Context context;
    protected DisplayMetrics displayMetrics;
    protected int gravity;
    protected float maxHeight;
    public OnDialogClickListener onDialogClickListener;
    protected View rootView;
    protected float scaleHeight;
    protected float scaleWidth;
    public Object tag;

    public BaseDialog(Context context) {
        super(context);
        this.scaleWidth = 1.0f;
        initBaseDialogTheme();
        initDialog();
    }

    private void attachView(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setGravity(51);
        attributes.x = iArr[0] + (getViewWidth(view) / 2);
        attributes.y = iArr[1] + (getViewHeight(view) / 2);
        window.setAttributes(attributes);
    }

    private void measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        view.measure(childMeasureSpec, i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public void destody() {
        super.dismiss();
        this.context = null;
        this.rootView.destroyDrawingCache();
        this.rootView = null;
        this.displayMetrics = null;
        this.onDialogClickListener = null;
    }

    public <T extends View> T findView(int i2) {
        return (T) this.rootView.findViewById(i2);
    }

    @LayoutRes
    public abstract int getLayoutRes();

    protected int getViewHeight(View view) {
        measureView(view);
        return view.getMeasuredHeight();
    }

    protected int getViewWidth(View view) {
        measureView(view);
        return view.getMeasuredWidth();
    }

    protected void initBaseDialogTheme() {
        this.animType = 0;
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    protected void initDialog() {
        this.displayMetrics = getContext().getResources().getDisplayMetrics();
        this.maxHeight = this.displayMetrics.heightPixels;
        this.rootView = LayoutInflater.from(getContext()).inflate(getLayoutRes(), (ViewGroup) null);
        this.tag = getClass().getSimpleName();
        setContentView(this.rootView);
        setCanceledOnTouchOutside(false);
        BaseDialogOnClickHelper.getInstance().onBindClickListener(this.rootView, this);
        onCreateData();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        float f2 = this.scaleWidth;
        int i2 = f2 == 0.0f ? -2 : (int) (this.displayMetrics.widthPixels * f2);
        float f3 = this.scaleHeight;
        this.rootView.setLayoutParams(new FrameLayout.LayoutParams(i2, f3 != 0.0f ? f3 == 1.0f ? -1 : (int) (this.maxHeight * f3) : -2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onClick(view, view.getId());
    }

    public abstract void onClick(View view, int i2);

    public abstract void onCreateData();

    public void onDialogClickListener(int i2) {
        OnDialogClickListener onDialogClickListener = this.onDialogClickListener;
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, i2);
        }
    }

    public BaseDialog setAnimType(@AnimType int i2) {
        this.animType = i2;
        if (2 == i2) {
            setGravity(80);
        } else if (3 == i2) {
            setGravity(48);
        } else if (1 == i2 || i2 == 0) {
            setGravity(17);
        }
        return this;
    }

    public BaseDialog setGravity(int i2) {
        this.gravity = i2;
        getWindow().setGravity(i2);
        return this;
    }

    public BaseDialog setOnCilckListener(int i2) {
        View viewFindView = findView(i2);
        if (viewFindView == null) {
            return this;
        }
        viewFindView.setOnClickListener(this);
        return this;
    }

    public BaseDialog setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        this.onDialogClickListener = onDialogClickListener;
        return this;
    }

    public BaseDialog setOnKeyListener(BaseOnKeyListener baseOnKeyListener) {
        super.setOnKeyListener((DialogInterface.OnKeyListener) baseOnKeyListener);
        return this;
    }

    public BaseDialog setScaleHeight(float f2) {
        this.scaleHeight = f2;
        return this;
    }

    public BaseDialog setScaleWidth(float f2) {
        this.scaleWidth = f2;
        return this;
    }

    public BaseDialog setText(int i2, String str) {
        setText(findView(i2), str);
        return this;
    }

    public void setViewVisiable(View view, int i2) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    public void show(@AnimType int i2) {
        Window window = getWindow();
        if (2 == i2) {
            setGravity(80);
            window.setWindowAnimations(R.style.dialog_anim_bottom2top);
        } else if (3 == i2) {
            setGravity(48);
            window.setWindowAnimations(R.style.dialog_anim_top2bottom);
        } else if (1 == i2) {
            setGravity(17);
            window.setWindowAnimations(R.style.dialog_anim_scale);
        } else if (i2 == 0) {
            setGravity(17);
            window.setWindowAnimations(R.style.dialog_anim_alpha);
        }
        super.show();
    }

    public BaseDialog tag(Object obj) {
        if (obj != null) {
            this.tag = obj;
        }
        return this;
    }

    public void setViewVisiable(int i2, int i3) {
        View viewFindView = findView(i2);
        if (viewFindView != null) {
            viewFindView.setVisibility(i3);
        }
    }

    public Object tag() {
        return this.tag;
    }

    public BaseDialog setOnCilckListener(int... iArr) {
        for (int i2 = 0; iArr != null && i2 < iArr.length; i2++) {
            setOnCilckListener(iArr[i2]);
        }
        return this;
    }

    public BaseDialog setText(View view, String str) {
        if (view != null && str != null) {
            if (view instanceof TextView) {
                ((TextView) view).setText(str);
            }
            if (view instanceof EditText) {
                ((EditText) view).setSelection(str.length());
            }
        }
        return this;
    }

    public BaseDialog setGravity(int i2, int i3) {
        this.gravity = i2;
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = (int) (i3 * this.context.getResources().getDisplayMetrics().density);
        window.setGravity(i2);
        return this;
    }

    public BaseDialog(Context context, int i2) {
        super(context, i2);
        this.scaleWidth = 1.0f;
        initBaseDialogTheme();
        initDialog();
    }
}
