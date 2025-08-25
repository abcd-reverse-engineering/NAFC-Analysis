package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Preview;
import com.luck.picture.lib.R;

/* loaded from: classes.dex */
public class PreviewView extends FrameLayout {
    private final DisplayManager.DisplayListener mDisplayListener;
    Implementation mImplementation;
    private ImplementationMode mImplementationMode;

    /* renamed from: androidx.camera.view.PreviewView$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode = new int[ImplementationMode.values().length];

        static {
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[ImplementationMode.SURFACE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[ImplementationMode.TEXTURE_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    interface Implementation {
        @NonNull
        Preview.SurfaceProvider getSurfaceProvider();

        void init(@NonNull FrameLayout frameLayout);

        void onDisplayChanged();
    }

    public enum ImplementationMode {
        SURFACE_VIEW(0),
        TEXTURE_VIEW(1);

        private final int mId;

        ImplementationMode(int i2) {
            this.mId = i2;
        }

        static ImplementationMode fromId(int i2) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i2) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException("Unsupported implementation mode " + i2);
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum ScaleType {
        FILL_START,
        FILL_CENTER,
        FILL_END,
        FIT_START,
        FIT_CENTER,
        FIT_END
    }

    public PreviewView(@NonNull Context context) {
        this(context, null);
    }

    private void setUp() {
        removeAllViews();
        int i2 = AnonymousClass2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[this.mImplementationMode.ordinal()];
        if (i2 == 1) {
            this.mImplementation = new SurfaceViewImplementation();
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("Unsupported implementation mode " + this.mImplementationMode);
            }
            this.mImplementation = new TextureViewImplementation();
        }
        this.mImplementation.init(this);
    }

    @NonNull
    public ImplementationMode getImplementationMode() {
        return this.mImplementationMode;
    }

    @NonNull
    public Preview.SurfaceProvider getPreviewSurfaceProvider() {
        return this.mImplementation.getSurfaceProvider();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = (DisplayManager) getContext().getSystemService("display");
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.mDisplayListener, getHandler());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DisplayManager displayManager = (DisplayManager) getContext().getSystemService("display");
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayListener);
        }
    }

    public void setImplementationMode(@NonNull ImplementationMode implementationMode) {
        this.mImplementationMode = implementationMode;
        setUp();
    }

    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mDisplayListener = new DisplayManager.DisplayListener() { // from class: androidx.camera.view.PreviewView.1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int i4) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int i4) {
                PreviewView.this.mImplementation.onDisplayChanged();
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int i4) {
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PreviewView, i2, i3);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.PreviewView, attributeSet, typedArrayObtainStyledAttributes, i2, i3);
        }
        try {
            this.mImplementationMode = ImplementationMode.fromId(typedArrayObtainStyledAttributes.getInteger(R.styleable.PreviewView_implementationMode, ImplementationMode.TEXTURE_VIEW.getId()));
            typedArrayObtainStyledAttributes.recycle();
            setUp();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
