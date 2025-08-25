package androidx.camera.core;

import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
final class SettableImageProxyBundle implements ImageProxyBundle {
    private final List<Integer> mCaptureIdList;
    final Object mLock = new Object();

    @GuardedBy("mLock")
    final SparseArray<CallbackToFutureAdapter.Completer<ImageProxy>> mCompleters = new SparseArray<>();

    @GuardedBy("mLock")
    private final SparseArray<c.b.b.a.a.a<ImageProxy>> mFutureResults = new SparseArray<>();

    @GuardedBy("mLock")
    private final List<ImageProxy> mOwnedImageProxies = new ArrayList();

    @GuardedBy("mLock")
    private boolean mClosed = false;

    SettableImageProxyBundle(List<Integer> list) {
        this.mCaptureIdList = list;
        setup();
    }

    private void setup() {
        synchronized (this.mLock) {
            Iterator<Integer> it = this.mCaptureIdList.iterator();
            while (it.hasNext()) {
                final int iIntValue = it.next().intValue();
                this.mFutureResults.put(iIntValue, CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver<ImageProxy>() { // from class: androidx.camera.core.SettableImageProxyBundle.1
                    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                    public Object attachCompleter(@NonNull CallbackToFutureAdapter.Completer<ImageProxy> completer) {
                        synchronized (SettableImageProxyBundle.this.mLock) {
                            SettableImageProxyBundle.this.mCompleters.put(iIntValue, completer);
                        }
                        return "getImageProxy(id: " + iIntValue + ")";
                    }
                }));
            }
        }
    }

    void addImageProxy(ImageProxy imageProxy) {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            Integer num = (Integer) imageProxy.getImageInfo().getTag();
            if (num == null) {
                throw new IllegalArgumentException("CaptureId is null.");
            }
            CallbackToFutureAdapter.Completer<ImageProxy> completer = this.mCompleters.get(num.intValue());
            if (completer != null) {
                this.mOwnedImageProxies.add(imageProxy);
                completer.set(imageProxy);
            } else {
                throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + num);
            }
        }
    }

    void close() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            Iterator<ImageProxy> it = this.mOwnedImageProxies.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.mOwnedImageProxies.clear();
            this.mFutureResults.clear();
            this.mCompleters.clear();
            this.mClosed = true;
        }
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public List<Integer> getCaptureIds() {
        return Collections.unmodifiableList(this.mCaptureIdList);
    }

    @Override // androidx.camera.core.impl.ImageProxyBundle
    @NonNull
    public c.b.b.a.a.a<ImageProxy> getImageProxy(int i2) {
        c.b.b.a.a.a<ImageProxy> aVar;
        synchronized (this.mLock) {
            if (this.mClosed) {
                throw new IllegalStateException("ImageProxyBundle already closed.");
            }
            aVar = this.mFutureResults.get(i2);
            if (aVar == null) {
                throw new IllegalArgumentException("ImageProxyBundle does not contain this id: " + i2);
            }
        }
        return aVar;
    }

    void reset() {
        synchronized (this.mLock) {
            if (this.mClosed) {
                return;
            }
            Iterator<ImageProxy> it = this.mOwnedImageProxies.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            this.mOwnedImageProxies.clear();
            this.mFutureResults.clear();
            this.mCompleters.clear();
            setup();
        }
    }
}
