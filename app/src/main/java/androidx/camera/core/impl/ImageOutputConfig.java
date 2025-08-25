package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
public interface ImageOutputConfig {
    public static final int INVALID_ROTATION = -1;
    public static final Rational DEFAULT_ASPECT_RATIO_LANDSCAPE = new Rational(4, 3);
    public static final Rational DEFAULT_ASPECT_RATIO_PORTRAIT = new Rational(3, 4);
    public static final Config.Option<Rational> OPTION_TARGET_ASPECT_RATIO_CUSTOM = Config.Option.create("camerax.core.imageOutput.targetAspectRatioCustom", Rational.class);
    public static final Config.Option<Integer> OPTION_TARGET_ASPECT_RATIO = Config.Option.create("camerax.core.imageOutput.targetAspectRatio", AspectRatio.class);
    public static final Config.Option<Integer> OPTION_TARGET_ROTATION = Config.Option.create("camerax.core.imageOutput.targetRotation", Integer.TYPE);
    public static final Config.Option<Size> OPTION_TARGET_RESOLUTION = Config.Option.create("camerax.core.imageOutput.targetResolution", Size.class);
    public static final Config.Option<Size> OPTION_DEFAULT_RESOLUTION = Config.Option.create("camerax.core.imageOutput.defaultResolution", Size.class);
    public static final Config.Option<Size> OPTION_MAX_RESOLUTION = Config.Option.create("camerax.core.imageOutput.maxResolution", Size.class);
    public static final Config.Option<List<Pair<Integer, Size[]>>> OPTION_SUPPORTED_RESOLUTIONS = Config.Option.create("camerax.core.imageOutput.supportedResolutions", List.class);

    public interface Builder<B> {
        @NonNull
        B setDefaultResolution(@NonNull Size size);

        @NonNull
        B setMaxResolution(@NonNull Size size);

        @NonNull
        B setSupportedResolutions(@NonNull List<Pair<Integer, Size[]>> list);

        @NonNull
        B setTargetAspectRatio(int i2);

        @NonNull
        B setTargetAspectRatioCustom(@NonNull Rational rational);

        @NonNull
        B setTargetResolution(@NonNull Size size);

        @NonNull
        B setTargetRotation(int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RotationValue {
    }

    @NonNull
    Size getDefaultResolution();

    @Nullable
    Size getDefaultResolution(@Nullable Size size);

    @NonNull
    Size getMaxResolution();

    @Nullable
    Size getMaxResolution(@Nullable Size size);

    @NonNull
    List<Pair<Integer, Size[]>> getSupportedResolutions();

    @Nullable
    List<Pair<Integer, Size[]>> getSupportedResolutions(@Nullable List<Pair<Integer, Size[]>> list);

    int getTargetAspectRatio();

    @NonNull
    Rational getTargetAspectRatioCustom();

    @Nullable
    Rational getTargetAspectRatioCustom(@Nullable Rational rational);

    @NonNull
    Size getTargetResolution();

    @Nullable
    Size getTargetResolution(@Nullable Size size);

    int getTargetRotation();

    int getTargetRotation(int i2);

    boolean hasTargetAspectRatio();
}
