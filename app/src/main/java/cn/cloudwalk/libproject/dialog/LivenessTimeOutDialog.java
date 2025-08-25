package cn.cloudwalk.libproject.dialog;

import android.content.Context;
import android.view.View;
import cn.cloudwalk.libproject.R;

/* loaded from: classes.dex */
public class LivenessTimeOutDialog extends BaseDialog {
    public LivenessTimeOutDialog(Context context) {
        super(context);
        setScale(0.0f, 0.0f);
    }

    private void setScale(float f2, float f3) {
        setScaleWidth(f2);
        setScaleHeight(f3);
    }

    @Override // cn.cloudwalk.libproject.dialog.BaseDialog
    public int getLayoutRes() {
        return R.layout.dialog_time_out;
    }

    @Override // cn.cloudwalk.libproject.dialog.BaseDialog
    public void onClick(View view, int i2) {
        OnDialogClickListener onDialogClickListener = this.onDialogClickListener;
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, i2);
        }
    }

    @Override // cn.cloudwalk.libproject.dialog.BaseDialog
    public void onCreateData() {
        setOnCilckListener(R.id.tv_cancle, R.id.tv_again);
    }

    public LivenessTimeOutDialog(Context context, int i2) {
        super(context, i2);
        setScale(0.0f, 0.0f);
    }
}
