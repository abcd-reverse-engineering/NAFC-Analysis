package androidx.camera.view;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class TextureViewImplementation implements PreviewView.Implementation {
    private static final String TAG = "TextureViewImpl";
    private Size mResolution;
    c.b.b.a.a.a<SurfaceRequest.Result> mSurfaceReleaseFuture;
    SurfaceRequest mSurfaceRequest;
    SurfaceTexture mSurfaceTexture;
    private WeakReference<FrameLayout> mWeakReferenceParent;
    private WeakReference<TextureView> mWeakReferenceTextureView;

    private void correctPreviewForCenterCrop(@NonNull View view, @NonNull TextureView textureView, @NonNull Size size) {
        Pair<Float, Float> fillScaleWithBufferAspectRatio = ScaleTypeTransform.getFillScaleWithBufferAspectRatio(view, textureView, size);
        textureView.setScaleX(((Float) fillScaleWithBufferAspectRatio.first).floatValue());
        textureView.setScaleY(((Float) fillScaleWithBufferAspectRatio.second).floatValue());
        Point originOfCenteredView = ScaleTypeTransform.getOriginOfCenteredView(view, textureView);
        textureView.setX(originOfCenteredView.x);
        textureView.setY(originOfCenteredView.y);
        textureView.setRotation(-ScaleTypeTransform.getRotationDegrees(textureView));
    }

    private FrameLayout getParent() {
        return this.mWeakReferenceParent.get();
    }

    private TextureView getTextureView() {
        return this.mWeakReferenceTextureView.get();
    }

    private void initInternal() {
        final TextureView textureView = new TextureView(getParent().getContext());
        this.mWeakReferenceTextureView = new WeakReference<>(textureView);
        textureView.setLayoutParams(new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: androidx.camera.view.TextureViewImplementation.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
                textureViewImplementation.mSurfaceTexture = surfaceTexture;
                textureViewImplementation.tryToProvidePreviewSurface();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
                c.b.b.a.a.a<SurfaceRequest.Result> aVar;
                TextureViewImplementation textureViewImplementation = TextureViewImplementation.this;
                textureViewImplementation.mSurfaceTexture = null;
                if (textureViewImplementation.mSurfaceRequest != null || (aVar = textureViewImplementation.mSurfaceReleaseFuture) == null) {
                    return true;
                }
                Futures.addCallback(aVar, new FutureCallback<SurfaceRequest.Result>() { // from class: androidx.camera.view.TextureViewImplementation.1.1
                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onFailure(Throwable th) {
                        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", th);
                    }

                    @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                    public void onSuccess(SurfaceRequest.Result result) {
                        Preconditions.checkState(result.getResultCode() != 3, "Unexpected result from SurfaceRequest. Surface was provided twice.");
                        surfaceTexture.release();
                    }
                }, ContextCompat.getMainExecutor(textureView.getContext().getApplicationContext()));
                return false;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                String str = "onSurfaceTextureSizeChanged(width:" + i2 + ", height: " + i3 + " )";
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
        getParent().removeAllViews();
        getParent().addView(textureView);
    }

    public /* synthetic */ void a(final SurfaceRequest surfaceRequest) {
        this.mResolution = surfaceRequest.getResolution();
        initInternal();
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null) {
            surfaceRequest2.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor(getTextureView().getContext().getApplicationContext()), new Runnable() { // from class: androidx.camera.view.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f1575a.b(surfaceRequest);
            }
        });
        tryToProvidePreviewSurface();
    }

    public /* synthetic */ void b(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 == null || surfaceRequest2 != surfaceRequest) {
            return;
        }
        this.mSurfaceRequest = null;
        this.mSurfaceReleaseFuture = null;
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    @NonNull
    public Preview.SurfaceProvider getSurfaceProvider() {
        return new Preview.SurfaceProvider() { // from class: androidx.camera.view.f
            @Override // androidx.camera.core.Preview.SurfaceProvider
            public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
                this.f1577a.a(surfaceRequest);
            }
        };
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    public void init(@NonNull FrameLayout frameLayout) {
        this.mWeakReferenceParent = new WeakReference<>(frameLayout);
    }

    @Override // androidx.camera.view.PreviewView.Implementation
    public void onDisplayChanged() {
        if (getParent() == null || getTextureView() == null || this.mResolution == null) {
            return;
        }
        correctPreviewForCenterCrop(getParent(), getTextureView(), this.mResolution);
    }

    void tryToProvidePreviewSurface() {
        SurfaceTexture surfaceTexture;
        Size size = this.mResolution;
        if (size == null || (surfaceTexture = this.mSurfaceTexture) == null || this.mSurfaceRequest == null) {
            return;
        }
        surfaceTexture.setDefaultBufferSize(size.getWidth(), this.mResolution.getHeight());
        final Surface surface = new Surface(this.mSurfaceTexture);
        final c.b.b.a.a.a<SurfaceRequest.Result> future = CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.view.g
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f1578a.a(surface, completer);
            }
        });
        this.mSurfaceReleaseFuture = future;
        this.mSurfaceReleaseFuture.addListener(new Runnable() { // from class: androidx.camera.view.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f1572a.a(surface, future);
            }
        }, ContextCompat.getMainExecutor(getTextureView().getContext().getApplicationContext()));
        this.mSurfaceRequest = null;
        correctPreviewForCenterCrop(getParent(), getTextureView(), this.mResolution);
    }

    public /* synthetic */ Object a(Surface surface, final CallbackToFutureAdapter.Completer completer) throws Exception {
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor executorDirectExecutor = CameraXExecutors.directExecutor();
        completer.getClass();
        surfaceRequest.provideSurface(surface, executorDirectExecutor, new Consumer() { // from class: androidx.camera.view.a
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                completer.set((SurfaceRequest.Result) obj);
            }
        });
        return "provideSurface[request=" + this.mSurfaceRequest + " surface=" + surface + "]";
    }

    public /* synthetic */ void a(Surface surface, c.b.b.a.a.a aVar) {
        surface.release();
        if (this.mSurfaceReleaseFuture == aVar) {
            this.mSurfaceReleaseFuture = null;
        }
    }
}
