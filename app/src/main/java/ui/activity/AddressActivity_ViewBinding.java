package ui.activity;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.hicorenational.antifraud.R;
import ui.view.RegionWheelView;

/* loaded from: classes2.dex */
public class AddressActivity_ViewBinding implements Unbinder {

    /* renamed from: a, reason: collision with root package name */
    private AddressActivity f17636a;

    /* renamed from: b, reason: collision with root package name */
    private View f17637b;

    class a extends DebouncingOnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AddressActivity f17638a;

        a(AddressActivity addressActivity) {
            this.f17638a = addressActivity;
        }

        @Override // butterknife.internal.DebouncingOnClickListener
        public void doClick(View view) {
            this.f17638a.onViewClicked(view);
        }
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity) {
        this(addressActivity, addressActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AddressActivity addressActivity = this.f17636a;
        if (addressActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f17636a = null;
        addressActivity.mConfirm = null;
        addressActivity.mLlRegion = null;
        this.f17637b.setOnClickListener(null);
        this.f17637b = null;
    }

    @UiThread
    public AddressActivity_ViewBinding(AddressActivity addressActivity, View view) {
        this.f17636a = addressActivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.confirm, "field 'mConfirm' and method 'onViewClicked'");
        addressActivity.mConfirm = (TextView) Utils.castView(viewFindRequiredView, R.id.confirm, "field 'mConfirm'", TextView.class);
        this.f17637b = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new a(addressActivity));
        addressActivity.mLlRegion = (RegionWheelView) Utils.findRequiredViewAsType(view, R.id.ll_region, "field 'mLlRegion'", RegionWheelView.class);
    }
}
