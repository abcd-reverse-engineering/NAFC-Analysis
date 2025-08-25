package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.immersion.CropImmersiveManage;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.util.MimeType;
import com.yalantis.ucrop.util.ScreenUtils;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class UCropActivity extends AppCompatActivity {
    public static final int ALL = 3;
    private static final long CONTROLS_ANIMATION_DURATION = 50;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    private static final int ROTATE_WIDGET_SENSITIVITY_COEFFICIENT = 42;
    public static final int SCALE = 1;
    private static final int SCALE_WIDGET_SENSITIVITY_COEFFICIENT = 15000;
    private static final int TABS_COUNT = 3;
    private static final String TAG = "UCropActivity";
    private boolean isDragFrame;
    private boolean isOpenWhiteStatusBar;
    private boolean isRotateEnabled;
    private boolean isScaleEnabled;
    private int mActiveControlsWidgetColor;
    private int mActiveWidgetColor;
    protected View mBlockingView;
    private Transition mControlsTransition;
    private GestureCropImageView mGestureCropImageView;
    private ViewGroup mLayoutAspectRatio;
    private ViewGroup mLayoutRotate;
    private ViewGroup mLayoutScale;
    private int mLogoColor;
    private OverlayView mOverlayView;

    @ColorInt
    private int mRootViewBackgroundColor;
    protected int mScreenWidth;
    protected boolean mShowBottomControls;
    private int mStatusBarColor;
    private TextView mTextViewRotateAngle;
    private TextView mTextViewScalePercent;

    @DrawableRes
    private int mToolbarCancelDrawable;
    private int mToolbarColor;

    @DrawableRes
    private int mToolbarCropDrawable;
    private String mToolbarTitle;
    private int mToolbarWidgetColor;
    private UCropView mUCropView;
    private ViewGroup mWrapperStateAspectRatio;
    private ViewGroup mWrapperStateRotate;
    private ViewGroup mWrapperStateScale;
    protected RelativeLayout uCropPhotoBox;
    private boolean mShowLoader = true;
    private List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    private List<AspectRatioTextView> mAspectRatioTextViews = new ArrayList();
    private Bitmap.CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    private int mCompressQuality = 90;
    private int[] mAllowedGestures = {1, 2, 3};
    private TransformImageView.TransformImageListener mImageListener = new TransformImageView.TransformImageListener() { // from class: com.yalantis.ucrop.UCropActivity.1
        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            UCropActivity.this.mUCropView.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.mBlockingView.setClickable(!r0.isOnTouch());
            UCropActivity.this.mShowLoader = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.a();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f2) {
            UCropActivity.this.setAngleText(f2);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f2) {
            UCropActivity.this.setScaleText(f2);
        }
    };
    private final View.OnClickListener mStateClickListener = new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.setWidgetState(view.getId());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    private void changeSelectedTab(int i2) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.mControlsTransition);
        this.mWrapperStateScale.findViewById(R.id.text_view_scale).setVisibility(i2 == R.id.state_scale ? 0 : 8);
        this.mWrapperStateAspectRatio.findViewById(R.id.text_view_crop).setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
        this.mWrapperStateRotate.findViewById(R.id.text_view_rotate).setVisibility(i2 != R.id.state_rotate ? 8 : 0);
    }

    private void getCustomOptionsData(@NonNull Intent intent) {
        this.isOpenWhiteStatusBar = intent.getBooleanExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_OPEN_WHITE_STATUSBAR, false);
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        if (this.mToolbarColor == 0) {
            this.mToolbarColor = ContextCompat.getColor(this, R.color.ucrop_color_toolbar);
        }
        if (this.mStatusBarColor == 0) {
            this.mStatusBarColor = ContextCompat.getColor(this, R.color.ucrop_color_statusbar);
        }
    }

    private void initiateRootViews() {
        this.uCropPhotoBox = (RelativeLayout) findViewById(R.id.ucrop_photobox);
        this.mUCropView = (UCropView) findViewById(R.id.ucrop);
        this.mGestureCropImageView = this.mUCropView.getCropImageView();
        this.mOverlayView = this.mUCropView.getOverlayView();
        this.mGestureCropImageView.setTransformImageListener(this.mImageListener);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.mLogoColor, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.mRootViewBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOnTouch() {
        Uri uri = (Uri) getIntent().getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        if (uri == null) {
            return true;
        }
        return isOnTouch(uri);
    }

    private void processOptions(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = DEFAULT_COMPRESS_FORMAT;
        }
        this.mCompressFormat = compressFormatValueOf;
        this.mCompressQuality = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        this.mOverlayView.setDimmedBorderColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_BORDER_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.isDragFrame = intent.getBooleanExtra(UCrop.Options.EXTRA_DRAG_CROP_FRAME, true);
        this.mOverlayView.setDimmedStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CIRCLE_STROKE_WIDTH_LAYER, 1));
        this.isScaleEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_SCALE, true);
        this.isRotateEnabled = intent.getBooleanExtra(UCrop.Options.EXTRA_ROTATE, true);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.mAllowedGestures = intArrayExtra;
        }
        this.mGestureCropImageView.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.mGestureCropImageView.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.mGestureCropImageView.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.mOverlayView.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.mOverlayView.setDragFrame(this.isDragFrame);
        this.mOverlayView.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.mOverlayView.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.mOverlayView.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.mOverlayView.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.mOverlayView.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.mOverlayView.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.mOverlayView.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.mOverlayView.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.mOverlayView.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.mOverlayView.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.mWrapperStateAspectRatio;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.mGestureCropImageView.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.mGestureCropImageView.setTargetAspectRatio(0.0f);
        } else {
            this.mGestureCropImageView.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY());
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.mGestureCropImageView.setMaxResultImageSizeX(intExtra2);
        this.mGestureCropImageView.setMaxResultImageSizeY(intExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetRotation() {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i2) {
        this.mGestureCropImageView.postRotate(i2);
        this.mGestureCropImageView.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i2) {
        boolean z;
        if (isOnTouch()) {
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            boolean z2 = false;
            if (this.isScaleEnabled && this.mShowBottomControls) {
                int[] iArr = this.mAllowedGestures;
                z = iArr[i2] == 3 || iArr[i2] == 1;
            } else {
                z = this.isScaleEnabled;
            }
            gestureCropImageView.setScaleEnabled(z);
            GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
            if (this.isRotateEnabled && this.mShowBottomControls) {
                int[] iArr2 = this.mAllowedGestures;
                if (iArr2[i2] == 3 || iArr2[i2] == 2) {
                    z2 = true;
                }
            } else {
                z2 = this.isRotateEnabled;
            }
            gestureCropImageView2.setRotateEnabled(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f2) {
        TextView textView = this.mTextViewRotateAngle;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f2)));
        }
    }

    private void setNavBar() {
        int intExtra;
        if (Build.VERSION.SDK_INT < 21 || (intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_NAV_BAR_COLOR, 0)) == 0) {
            return;
        }
        getWindow().setNavigationBarColor(intExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f2) {
        TextView textView = this.mTextViewScalePercent;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f2 * 100.0f))));
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(@ColorInt int i2) {
        Window window;
        if (Build.VERSION.SDK_INT < 21 || (window = getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(@IdRes int i2) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i2 == R.id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i2 == R.id.state_rotate);
            this.mWrapperStateScale.setSelected(i2 == R.id.state_scale);
            this.mLayoutAspectRatio.setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i2 == R.id.state_rotate ? 0 : 8);
            this.mLayoutScale.setVisibility(i2 == R.id.state_scale ? 0 : 8);
            changeSelectedTab(i2);
            if (i2 == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i2 == R.id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.mStatusBarColor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.mToolbarColor);
        toolbar.setTitleTextColor(this.mToolbarWidgetColor);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.mToolbarWidgetColor);
        textView.setText(this.mToolbarTitle);
        Drawable drawableMutate = ContextCompat.getDrawable(this, this.mToolbarCancelDrawable).mutate();
        drawableMutate.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawableMutate);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setupAspectRatioWidget(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        int i2 = -1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        if (getCurrentActivity() instanceof PictureMultiCuttingActivity) {
            this.mAspectRatioTextViews = new ArrayList();
            this.mCropAspectRatioViews = new ArrayList();
        }
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            AspectRatio aspectRatio = (AspectRatio) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.mActiveControlsWidgetColor);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            this.mAspectRatioTextViews.add(aspectRatioTextView);
            linearLayout.addView(frameLayout);
            this.mCropAspectRatioViews.add(frameLayout);
        }
        this.mCropAspectRatioViews.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.mCropAspectRatioViews) {
            i2++;
            viewGroup.setTag(Integer.valueOf(i2));
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UCropActivity.this.mGestureCropImageView.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                    UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
                    if (view.isSelected()) {
                        return;
                    }
                    for (ViewGroup viewGroup2 : UCropActivity.this.mCropAspectRatioViews) {
                        viewGroup2.setSelected(viewGroup2 == view);
                    }
                }
            });
        }
    }

    private void setupRotateWidget() {
        this.mTextViewRotateAngle = (TextView) findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.3
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f2, float f3) {
                UCropActivity.this.mGestureCropImageView.postRotate(f2 / 42.0f);
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.resetRotation();
            }
        });
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UCropActivity.this.rotateByAngle(90);
            }
        });
    }

    private void setupScaleWidget() {
        this.mTextViewScalePercent = (TextView) findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.6
            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScroll(float f2, float f3) {
                if (f2 > 0.0f) {
                    UCropActivity.this.mGestureCropImageView.zoomInImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f2 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                } else {
                    UCropActivity.this.mGestureCropImageView.zoomOutImage(UCropActivity.this.mGestureCropImageView.getCurrentScale() + (f2 * ((UCropActivity.this.mGestureCropImageView.getMaxScale() - UCropActivity.this.mGestureCropImageView.getMinScale()) / 15000.0f)));
                }
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollEnd() {
                UCropActivity.this.mGestureCropImageView.setImageToWrapCropBounds();
            }

            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
            public void onScrollStart() {
                UCropActivity.this.mGestureCropImageView.cancelAllAnimations();
            }
        });
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.mActiveWidgetColor);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.mActiveControlsWidgetColor));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.mActiveControlsWidgetColor));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.mActiveControlsWidgetColor));
    }

    protected void addBlockingView() {
        if (this.mBlockingView == null) {
            this.mBlockingView = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.mBlockingView.setLayoutParams(layoutParams);
            this.mBlockingView.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.mBlockingView);
    }

    protected void closeActivity() {
        finish();
        exitAnimation();
    }

    protected void cropAndSaveImage() {
        this.mBlockingView.setClickable(true);
        this.mShowLoader = true;
        supportInvalidateOptionsMenu();
        this.mGestureCropImageView.cropAndSaveImage(this.mCompressFormat, this.mCompressQuality, new BitmapCropCallback() { // from class: com.yalantis.ucrop.UCropActivity.8
            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onBitmapCropped(@NonNull Uri uri, int i2, int i3, int i4, int i5) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.mGestureCropImageView.getTargetAspectRatio(), i2, i3, i4, i5);
                if (UCropActivity.this.getCurrentActivity() instanceof PictureMultiCuttingActivity) {
                    return;
                }
                UCropActivity.this.a();
            }

            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public void onCropFailure(@NonNull Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.a();
            }
        });
    }

    protected void exitAnimation() {
        int intExtra = getIntent().getIntExtra(UCrop.Options.EXTRA_WINDOW_EXIT_ANIMATION, 0);
        int i2 = R.anim.ucrop_anim_fade_in;
        if (intExtra == 0) {
            intExtra = R.anim.ucrop_close;
        }
        overridePendingTransition(i2, intExtra);
    }

    protected Activity getCurrentActivity() {
        return this;
    }

    public void immersive() {
        CropImmersiveManage.immersiveAboveAPI23(this, this.mStatusBarColor, this.mToolbarColor, this.isOpenWhiteStatusBar);
    }

    @Override // android.app.Activity
    public boolean isImmersive() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void a() {
        closeActivity();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        getCustomOptionsData(intent);
        if (isImmersive()) {
            immersive();
        }
        setContentView(R.layout.ucrop_activity_photobox);
        this.mScreenWidth = ScreenUtils.getScreenWidth(this);
        setupViews(intent);
        setNavBar();
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                String.format("%s - %s", e2.getMessage(), getString(R.string.ucrop_mutate_exception_hint));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.mToolbarWidgetColor, PorterDuff.Mode.SRC_ATOP);
            menuItemFindItem2.setIcon(drawable);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            cropAndSaveImage();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        a();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R.id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    protected void setImageData(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri == null || uri2 == null) {
            setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            a();
            return;
        }
        try {
            boolean zIsOnTouch = isOnTouch(uri);
            this.mGestureCropImageView.setRotateEnabled(zIsOnTouch ? this.isRotateEnabled : zIsOnTouch);
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            if (zIsOnTouch) {
                zIsOnTouch = this.isScaleEnabled;
            }
            gestureCropImageView.setScaleEnabled(zIsOnTouch);
            this.mGestureCropImageView.setImageUri(uri, uri2);
        } catch (Exception e2) {
            setResultError(e2);
            a();
        }
    }

    protected void setInitialState() {
        if (!this.mShowBottomControls) {
            setAllowedGestures(0);
        } else if (this.mWrapperStateAspectRatio.getVisibility() == 0) {
            setWidgetState(R.id.state_aspect_ratio);
        } else {
            setWidgetState(R.id.state_scale);
        }
    }

    protected void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    protected void setResultUri(Uri uri, float f2, int i2, int i3, int i4, int i5) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f2).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i4).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i5).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i2).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i3));
    }

    protected void setupViews(@NonNull Intent intent) {
        this.mStatusBarColor = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_statusbar));
        this.mToolbarColor = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.mActiveWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_widget_background));
        this.mActiveControlsWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, ContextCompat.getColor(this, R.color.ucrop_color_active_controls_color));
        this.mToolbarWidgetColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.mToolbarCancelDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.mToolbarCropDrawable = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        this.mToolbarTitle = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        String string = this.mToolbarTitle;
        if (string == null) {
            string = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.mToolbarTitle = string;
        this.mLogoColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.mShowBottomControls = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.mRootViewBackgroundColor = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.mShowBottomControls) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            viewGroup.setBackgroundColor(this.mRootViewBackgroundColor);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            this.mControlsTransition = new AutoTransition();
            this.mControlsTransition.setDuration(CONTROLS_ANIMATION_DURATION);
            this.mWrapperStateAspectRatio = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.mWrapperStateAspectRatio.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateRotate = (ViewGroup) findViewById(R.id.state_rotate);
            this.mWrapperStateRotate.setOnClickListener(this.mStateClickListener);
            this.mWrapperStateScale = (ViewGroup) findViewById(R.id.state_scale);
            this.mWrapperStateScale.setOnClickListener(this.mStateClickListener);
            this.mLayoutAspectRatio = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.mLayoutRotate = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.mLayoutScale = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    private boolean isOnTouch(Uri uri) {
        if (uri == null) {
            return true;
        }
        if (MimeType.isHttp(uri.toString())) {
            return !MimeType.isGifForSuffix(MimeType.getLastImgType(uri.toString()));
        }
        String mimeTypeFromMediaContentUri = MimeType.getMimeTypeFromMediaContentUri(this, uri);
        if (mimeTypeFromMediaContentUri.endsWith("image/*")) {
            mimeTypeFromMediaContentUri = MimeType.getImageMimeType(FileUtils.getPath(this, uri));
        }
        return !MimeType.isGif(mimeTypeFromMediaContentUri);
    }
}
