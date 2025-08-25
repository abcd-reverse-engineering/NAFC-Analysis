package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: g, reason: collision with root package name */
    private static final String f5061g = "SupportRMFragment";

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f5062a;

    /* renamed from: b, reason: collision with root package name */
    private final l f5063b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f5064c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private SupportRequestManagerFragment f5065d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.k f5066e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f5067f;

    private class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.manager.l
        @NonNull
        public Set<com.bumptech.glide.k> a() {
            Set<SupportRequestManagerFragment> setD = SupportRequestManagerFragment.this.d();
            HashSet hashSet = new HashSet(setD.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : setD) {
                if (supportRequestManagerFragment.f() != null) {
                    hashSet.add(supportRequestManagerFragment.f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f5064c.remove(supportRequestManagerFragment);
    }

    private boolean c(@NonNull Fragment fragment) {
        Fragment fragmentH = h();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(fragmentH)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @Nullable
    private Fragment h() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f5067f;
    }

    private void i() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f5065d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.b(this);
            this.f5065d = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.k kVar) {
        this.f5066e = kVar;
    }

    @NonNull
    Set<SupportRequestManagerFragment> d() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f5065d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f5064c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f5065d.d()) {
            if (c(supportRequestManagerFragment2.h())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    com.bumptech.glide.manager.a e() {
        return this.f5062a;
    }

    @Nullable
    public com.bumptech.glide.k f() {
        return this.f5066e;
    }

    @NonNull
    public l g() {
        return this.f5063b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager fragmentManagerB = b((Fragment) this);
        if (fragmentManagerB == null) {
            Log.isLoggable(f5061g, 5);
            return;
        }
        try {
            a(getContext(), fragmentManagerB);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f5061g, 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5062a.a();
        i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f5067f = null;
        i();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5062a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5062a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + h() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f5063b = new a();
        this.f5064c = new HashSet();
        this.f5062a = aVar;
    }

    private void a(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f5064c.add(supportRequestManagerFragment);
    }

    @Nullable
    private static FragmentManager b(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    void a(@Nullable Fragment fragment) {
        FragmentManager fragmentManagerB;
        this.f5067f = fragment;
        if (fragment == null || fragment.getContext() == null || (fragmentManagerB = b(fragment)) == null) {
            return;
        }
        a(fragment.getContext(), fragmentManagerB);
    }

    private void a(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        i();
        this.f5065d = com.bumptech.glide.b.a(context).i().a(context, fragmentManager);
        if (equals(this.f5065d)) {
            return;
        }
        this.f5065d.a(this);
    }
}
