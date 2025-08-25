package ui.activity;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class PreviewShotScreenActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private PreviewShotScreenActivity f18554a;

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity) {
        this(previewShotScreenActivity, previewShotScreenActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PreviewShotScreenActivity previewShotScreenActivity = this.f18554a;
        if (previewShotScreenActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f18554a = null;
        previewShotScreenActivity.ivShotScreenPreview = null;
    }

    @UiThread
    public PreviewShotScreenActivity_ViewBinding(PreviewShotScreenActivity previewShotScreenActivity, View view) {
        this.f18554a = previewShotScreenActivity;
        previewShotScreenActivity.ivShotScreenPreview = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_shot_screen_preview, "field 'ivShotScreenPreview'", ImageView.class);
    }
}
