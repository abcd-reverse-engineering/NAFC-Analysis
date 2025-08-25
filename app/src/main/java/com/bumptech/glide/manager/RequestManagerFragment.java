package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: g, reason: collision with root package name */
    private static final String f5053g = "RMFragment";

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.manager.a f5054a;

    /* renamed from: b, reason: collision with root package name */
    private final l f5055b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<RequestManagerFragment> f5056c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.k f5057d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private RequestManagerFragment f5058e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private Fragment f5059f;

    private class a implements l {
        a() {
        }

        @Override // com.bumptech.glide.manager.l
        @NonNull
        public Set<com.bumptech.glide.k> a() {
            Set<RequestManagerFragment> setA = RequestManagerFragment.this.a();
            HashSet hashSet = new HashSet(setA.size());
            for (RequestManagerFragment requestManagerFragment : setA) {
                if (requestManagerFragment.c() != null) {
                    hashSet.add(requestManagerFragment.c());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    @Nullable
    @TargetApi(17)
    private Fragment e() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.f5059f;
    }

    private void f() {
        RequestManagerFragment requestManagerFragment = this.f5058e;
        if (requestManagerFragment != null) {
            requestManagerFragment.b(this);
            this.f5058e = null;
        }
    }

    public void a(@Nullable com.bumptech.glide.k kVar) {
        this.f5057d = kVar;
    }

    @NonNull
    com.bumptech.glide.manager.a b() {
        return this.f5054a;
    }

    @Nullable
    public com.bumptech.glide.k c() {
        return this.f5057d;
    }

    @NonNull
    public l d() {
        return this.f5055b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            a(activity);
        } catch (IllegalStateException unused) {
            Log.isLoggable(f5053g, 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f5054a.a();
        f();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        f();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f5054a.b();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f5054a.c();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    RequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f5055b = new a();
        this.f5056c = new HashSet();
        this.f5054a = aVar;
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f5056c.add(requestManagerFragment);
    }

    private void b(RequestManagerFragment requestManagerFragment) {
        this.f5056c.remove(requestManagerFragment);
    }

    @TargetApi(17)
    private boolean b(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    @NonNull
    @TargetApi(17)
    Set<RequestManagerFragment> a() {
        if (equals(this.f5058e)) {
            return Collections.unmodifiableSet(this.f5056c);
        }
        if (this.f5058e != null && Build.VERSION.SDK_INT >= 17) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f5058e.a()) {
                if (b(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    void a(@Nullable Fragment fragment) {
        this.f5059f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        a(fragment.getActivity());
    }

    private void a(@NonNull Activity activity) {
        f();
        this.f5058e = com.bumptech.glide.b.a((Context) activity).i().b(activity);
        if (equals(this.f5058e)) {
            return;
        }
        this.f5058e.a(this);
    }
}
