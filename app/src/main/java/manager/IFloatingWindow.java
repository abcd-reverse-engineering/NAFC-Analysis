package manager;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import java.util.List;

/* loaded from: classes2.dex */
public interface IFloatingWindow {
    void dismiss();

    <T extends View> T findViewById(@IdRes int i2);

    List<IFloatingWindow> getAllWindow();

    WindowManager.LayoutParams getCallWarnLayoutParams();

    View getContentView();

    Context getContext();

    WindowManager.LayoutParams getLayoutParams();

    WindowManager.LayoutParams getRecordTimeLayoutParams();

    WindowManager.LayoutParams getSMSWarnLayoutParams();

    WindowManager.LayoutParams getWarnGuideLayoutParams();

    boolean isShowing();

    void removeAll();

    void setContentView(@LayoutRes int i2);

    void setContentView(View view);

    void setParams(WindowManager.LayoutParams layoutParams);

    void show();
}
