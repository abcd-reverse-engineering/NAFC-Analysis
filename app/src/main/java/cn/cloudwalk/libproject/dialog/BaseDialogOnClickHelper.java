package cn.cloudwalk.libproject.dialog;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class BaseDialogOnClickHelper {
    private static BaseDialogOnClickHelper OnClickHelper;

    private BaseDialogOnClickHelper() {
    }

    public static BaseDialogOnClickHelper getInstance() {
        if (OnClickHelper == null) {
            synchronized (BaseDialogOnClickHelper.class) {
                OnClickHelper = OnClickHelper == null ? new BaseDialogOnClickHelper() : OnClickHelper;
            }
        }
        return OnClickHelper;
    }

    private void setOnClickListener(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(onClickListener);
        if (view instanceof ViewGroup) {
            setOnClickListener((ViewGroup) view, onClickListener);
        }
    }

    public void onBindClickListener(View view, View.OnClickListener onClickListener) {
        setOnClickListener(view, onClickListener);
    }

    private void setOnClickListener(ViewGroup viewGroup, View.OnClickListener onClickListener) {
        try {
            viewGroup.setOnClickListener(onClickListener);
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof ViewGroup) {
                    setOnClickListener((ViewGroup) childAt, onClickListener);
                } else if (childAt != null && (childAt instanceof View)) {
                    childAt.setOnClickListener(onClickListener);
                }
            }
        } catch (Exception unused) {
        }
    }
}
