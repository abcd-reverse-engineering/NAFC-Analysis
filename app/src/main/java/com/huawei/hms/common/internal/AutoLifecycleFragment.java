package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: classes.dex */
public class AutoLifecycleFragment extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f6720a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f6721b;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public final HuaweiApiClient f6722a;

        /* renamed from: b, reason: collision with root package name */
        protected final int f6723b;

        public a(int i2, HuaweiApiClient huaweiApiClient) {
            this.f6722a = huaweiApiClient;
            this.f6723b = i2;
        }

        public void a() {
            this.f6722a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e2);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f6721b = true;
        for (int i2 = 0; i2 < this.f6720a.size(); i2++) {
            this.f6720a.valueAt(i2).f6722a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f6721b = false;
        for (int i2 = 0; i2 < this.f6720a.size(); i2++) {
            this.f6720a.valueAt(i2).f6722a.disconnect();
        }
    }

    public void startAutoMange(int i2, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        Preconditions.checkState(this.f6720a.indexOfKey(i2) < 0, "Already managing a HuaweiApiClient with this clientId: " + i2);
        this.f6720a.put(i2, new a(i2, huaweiApiClient));
        if (this.f6721b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i2) {
        a aVar = this.f6720a.get(i2);
        this.f6720a.remove(i2);
        if (aVar != null) {
            aVar.a();
        }
    }
}
