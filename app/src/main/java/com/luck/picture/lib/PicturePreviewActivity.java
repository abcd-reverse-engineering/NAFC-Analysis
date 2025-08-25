package com.luck.picture.lib;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.observable.ImagesObservable;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.luck.picture.lib.tools.ScreenUtils;
import com.luck.picture.lib.tools.ToastUtils;
import com.luck.picture.lib.tools.ValueOf;
import com.luck.picture.lib.widget.PreviewViewPager;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.model.CutInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PicturePreviewActivity extends PictureBaseActivity implements View.OnClickListener, PictureSimpleFragmentAdapter.OnCallBackActivity {

    /* renamed from: adapter, reason: collision with root package name */
    protected PictureSimpleFragmentAdapter f7745adapter;
    protected Animation animation;
    protected View btnCheck;
    protected TextView check;
    protected String currentDirectory;
    protected int index;
    protected boolean isChangeSelectedData;
    protected boolean isCompleteOrSelected;
    protected boolean isShowCamera;
    protected boolean is_bottom_preview;
    protected CheckBox mCbOriginal;
    protected Handler mHandler;
    protected TextView mTvPictureOk;
    protected ImageView picture_left_back;
    protected int position;
    protected boolean refresh;
    protected int screenWidth;
    protected RelativeLayout selectBarLayout;
    protected View titleViewBg;
    protected TextView tv_img_num;
    protected TextView tv_title;
    protected PreviewViewPager viewPager;
    protected List<LocalMedia> images = new ArrayList();
    protected List<LocalMedia> selectImages = new ArrayList();

    private void bothMimeTypeWith(String str, LocalMedia localMedia) throws Resources.NotFoundException {
        if (!this.config.enableCrop) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        boolean zEqImage = PictureMimeType.eqImage(str);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode == 1 && zEqImage) {
            pictureSelectionConfig.originalPath = localMedia.getPath();
            startCrop(this.config.originalPath, localMedia.getMimeType());
            return;
        }
        ArrayList<CutInfo> arrayList = new ArrayList<>();
        int size = this.selectImages.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            LocalMedia localMedia2 = this.selectImages.get(i3);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath())) {
                if (PictureMimeType.eqImage(localMedia2.getMimeType())) {
                    i2++;
                }
                CutInfo cutInfo = new CutInfo();
                cutInfo.setId(localMedia2.getId());
                cutInfo.setPath(localMedia2.getPath());
                cutInfo.setImageWidth(localMedia2.getWidth());
                cutInfo.setImageHeight(localMedia2.getHeight());
                cutInfo.setMimeType(localMedia2.getMimeType());
                cutInfo.setAndroidQToPath(localMedia2.getAndroidQToPath());
                cutInfo.setId(localMedia2.getId());
                cutInfo.setDuration(localMedia2.getDuration());
                cutInfo.setRealPath(localMedia2.getRealPath());
                arrayList.add(cutInfo);
            }
        }
        if (i2 > 0) {
            startCrop(arrayList);
        } else {
            this.isCompleteOrSelected = true;
            onBackPressed();
        }
    }

    private void initViewPageAdapterData() {
        this.tv_title.setText(getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(this.position + 1), Integer.valueOf(this.images.size())}));
        this.f7745adapter = new PictureSimpleFragmentAdapter(this.config, this.images, this);
        this.viewPager.setAdapter(this.f7745adapter);
        this.viewPager.setCurrentItem(this.position);
        onImageChecked(this.position);
        if (this.images.size() > 0) {
            LocalMedia localMedia = this.images.get(this.position);
            this.index = localMedia.getPosition();
            if (this.config.checkNumMode) {
                this.tv_img_num.setSelected(true);
                this.check.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                notifyCheckChanged(localMedia);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isPreviewEggs(boolean z, int i2, int i3) {
        if (!z || this.images.size() <= 0) {
            return;
        }
        if (i3 < this.screenWidth / 2) {
            LocalMedia localMedia = this.images.get(i2);
            this.check.setSelected(isSelected(localMedia));
            if (this.config.checkNumMode) {
                this.check.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                notifyCheckChanged(localMedia);
                onImageChecked(i2);
                return;
            }
            return;
        }
        int i4 = i2 + 1;
        LocalMedia localMedia2 = this.images.get(i4);
        this.check.setSelected(isSelected(localMedia2));
        if (this.config.checkNumMode) {
            this.check.setText(ValueOf.toString(Integer.valueOf(localMedia2.getNum())));
            notifyCheckChanged(localMedia2);
            onImageChecked(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCheckChanged(LocalMedia localMedia) {
        if (this.config.checkNumMode) {
            this.check.setText("");
            int size = this.selectImages.size();
            for (int i2 = 0; i2 < size; i2++) {
                LocalMedia localMedia2 = this.selectImages.get(i2);
                if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                    localMedia.setNum(localMedia2.getNum());
                    this.check.setText(String.valueOf(localMedia.getNum()));
                }
            }
        }
    }

    private void separateMimeTypeWith(String str, LocalMedia localMedia) throws Resources.NotFoundException {
        if (!this.config.enableCrop || !PictureMimeType.eqImage(str)) {
            onBackPressed();
            return;
        }
        this.isCompleteOrSelected = false;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode == 1) {
            pictureSelectionConfig.originalPath = localMedia.getPath();
            startCrop(this.config.originalPath, localMedia.getMimeType());
            return;
        }
        ArrayList<CutInfo> arrayList = new ArrayList<>();
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2 != null && !TextUtils.isEmpty(localMedia2.getPath())) {
                CutInfo cutInfo = new CutInfo();
                cutInfo.setId(localMedia2.getId());
                cutInfo.setPath(localMedia2.getPath());
                cutInfo.setImageWidth(localMedia2.getWidth());
                cutInfo.setImageHeight(localMedia2.getHeight());
                cutInfo.setMimeType(localMedia2.getMimeType());
                cutInfo.setAndroidQToPath(localMedia2.getAndroidQToPath());
                cutInfo.setId(localMedia2.getId());
                cutInfo.setDuration(localMedia2.getDuration());
                cutInfo.setRealPath(localMedia2.getRealPath());
                arrayList.add(cutInfo);
            }
        }
        startCrop(arrayList);
    }

    private void subSelectPosition() {
        int size = this.selectImages.size();
        int i2 = 0;
        while (i2 < size) {
            LocalMedia localMedia = this.selectImages.get(i2);
            i2++;
            localMedia.setNum(i2);
        }
    }

    private void updateResult() {
        Intent intent = new Intent();
        if (this.isChangeSelectedData) {
            intent.putExtra(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectImages);
        }
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isOriginalControl) {
            intent.putExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, pictureSelectionConfig.isCheckOriginalImage);
        }
        setResult(0, intent);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.config.isCheckOriginalImage = z;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public int getResourceId() {
        return R.layout.picture_preview;
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initCompleteText(int i2) {
        String string;
        boolean z = this.config.style != null;
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.selectionMode == 1) {
            if (i2 <= 0) {
                this.mTvPictureOk.setText((!z || TextUtils.isEmpty(pictureSelectionConfig.style.pictureUnCompleteText)) ? getString(R.string.picture_please_select) : this.config.style.pictureUnCompleteText);
                return;
            }
            if (!(z && pictureSelectionConfig.style.isCompleteReplaceNum) || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
                this.mTvPictureOk.setText((!z || TextUtils.isEmpty(this.config.style.pictureCompleteText)) ? getString(R.string.picture_done) : this.config.style.pictureCompleteText);
                return;
            } else {
                this.mTvPictureOk.setText(String.format(this.config.style.pictureCompleteText, Integer.valueOf(i2), 1));
                return;
            }
        }
        boolean z2 = z && pictureSelectionConfig.style.isCompleteReplaceNum;
        if (i2 <= 0) {
            TextView textView = this.mTvPictureOk;
            if (!z || TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                int i3 = R.string.picture_done_front_num;
                PictureSelectionConfig pictureSelectionConfig2 = this.config;
                string = getString(i3, new Object[]{Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig2.maxVideoSelectNum + pictureSelectionConfig2.maxSelectNum)});
            } else {
                string = this.config.style.pictureUnCompleteText;
            }
            textView.setText(string);
            return;
        }
        if (!z2 || TextUtils.isEmpty(this.config.style.pictureCompleteText)) {
            TextView textView2 = this.mTvPictureOk;
            int i4 = R.string.picture_done_front_num;
            PictureSelectionConfig pictureSelectionConfig3 = this.config;
            textView2.setText(getString(i4, new Object[]{Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig3.maxVideoSelectNum + pictureSelectionConfig3.maxSelectNum)}));
            return;
        }
        TextView textView3 = this.mTvPictureOk;
        String str = this.config.style.pictureCompleteText;
        PictureSelectionConfig pictureSelectionConfig4 = this.config;
        textView3.setText(String.format(str, Integer.valueOf(i2), Integer.valueOf(pictureSelectionConfig4.maxVideoSelectNum + pictureSelectionConfig4.maxSelectNum)));
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    public void initPictureSelectorStyle() {
        PictureParameterStyle pictureParameterStyle = this.config.style;
        if (pictureParameterStyle != null) {
            int i2 = pictureParameterStyle.pictureTitleTextColor;
            if (i2 != 0) {
                this.tv_title.setTextColor(i2);
            }
            int i3 = this.config.style.pictureTitleTextSize;
            if (i3 != 0) {
                this.tv_title.setTextSize(i3);
            }
            int i4 = this.config.style.pictureLeftBackIcon;
            if (i4 != 0) {
                this.picture_left_back.setImageResource(i4);
            }
            int i5 = this.config.style.picturePreviewBottomBgColor;
            if (i5 != 0) {
                this.selectBarLayout.setBackgroundColor(i5);
            }
            int i6 = this.config.style.pictureCheckNumBgStyle;
            if (i6 != 0) {
                this.tv_img_num.setBackgroundResource(i6);
            }
            int i7 = this.config.style.pictureCheckedStyle;
            if (i7 != 0) {
                this.check.setBackgroundResource(i7);
            }
            int i8 = this.config.style.pictureUnCompleteTextColor;
            if (i8 != 0) {
                this.mTvPictureOk.setTextColor(i8);
            }
            if (!TextUtils.isEmpty(this.config.style.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(this.config.style.pictureUnCompleteText);
            }
        }
        this.titleViewBg.setBackgroundColor(this.colorPrimary);
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isOriginalControl) {
            PictureParameterStyle pictureParameterStyle2 = pictureSelectionConfig.style;
            if (pictureParameterStyle2 != null) {
                int i9 = pictureParameterStyle2.pictureOriginalControlStyle;
                if (i9 != 0) {
                    this.mCbOriginal.setButtonDrawable(i9);
                } else {
                    this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                }
                int i10 = this.config.style.pictureOriginalFontColor;
                if (i10 != 0) {
                    this.mCbOriginal.setTextColor(i10);
                } else {
                    this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
                }
                int i11 = this.config.style.pictureOriginalTextSize;
                if (i11 != 0) {
                    this.mCbOriginal.setTextSize(i11);
                }
            } else {
                this.mCbOriginal.setButtonDrawable(ContextCompat.getDrawable(this, R.drawable.picture_original_checkbox));
                this.mCbOriginal.setTextColor(ContextCompat.getColor(this, R.color.picture_color_53575e));
            }
        }
        onSelectNumChange(false);
    }

    @Override // com.luck.picture.lib.PictureBaseActivity
    protected void initWidgets() {
        super.initWidgets();
        this.mHandler = new Handler();
        this.titleViewBg = findViewById(R.id.titleViewBg);
        this.screenWidth = ScreenUtils.getScreenWidth(this);
        this.animation = AnimationUtils.loadAnimation(this, R.anim.picture_anim_modal_in);
        this.picture_left_back = (ImageView) findViewById(R.id.picture_left_back);
        this.viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        this.btnCheck = findViewById(R.id.btnCheck);
        this.check = (TextView) findViewById(R.id.check);
        this.picture_left_back.setOnClickListener(this);
        this.mTvPictureOk = (TextView) findViewById(R.id.tv_ok);
        this.mCbOriginal = (CheckBox) findViewById(R.id.cb_original);
        this.tv_img_num = (TextView) findViewById(R.id.tv_img_num);
        this.selectBarLayout = (RelativeLayout) findViewById(R.id.select_bar_layout);
        this.mTvPictureOk.setOnClickListener(this);
        this.tv_img_num.setOnClickListener(this);
        this.tv_title = (TextView) findViewById(R.id.picture_title);
        this.position = getIntent().getIntExtra("position", 0);
        if (this.numComplete) {
            initCompleteText(0);
        }
        this.tv_img_num.setSelected(this.config.checkNumMode);
        this.btnCheck.setOnClickListener(this);
        this.selectImages = getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST);
        this.is_bottom_preview = getIntent().getBooleanExtra(PictureConfig.EXTRA_BOTTOM_PREVIEW, false);
        this.isShowCamera = getIntent().getBooleanExtra(PictureConfig.EXTRA_SHOW_CAMERA, this.config.isCamera);
        this.currentDirectory = getIntent().getStringExtra(PictureConfig.EXTRA_IS_CURRENT_DIRECTORY);
        this.images = this.is_bottom_preview ? getIntent().getParcelableArrayListExtra(PictureConfig.EXTRA_PREVIEW_SELECT_LIST) : ImagesObservable.getInstance().readPreviewMediaData();
        initViewPageAdapterData();
        this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.luck.picture.lib.PicturePreviewActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
                if (PicturePreviewActivity.this.getContext() instanceof PictureSelectorPreviewWeChatStyleActivity) {
                    return;
                }
                PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                picturePreviewActivity.isPreviewEggs(picturePreviewActivity.config.previewEggs, i2, i3);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                PicturePreviewActivity picturePreviewActivity = PicturePreviewActivity.this;
                picturePreviewActivity.position = i2;
                picturePreviewActivity.tv_title.setText(picturePreviewActivity.getString(R.string.picture_preview_image_num, new Object[]{Integer.valueOf(picturePreviewActivity.position + 1), Integer.valueOf(PicturePreviewActivity.this.images.size())}));
                PicturePreviewActivity picturePreviewActivity2 = PicturePreviewActivity.this;
                LocalMedia localMedia = picturePreviewActivity2.images.get(picturePreviewActivity2.position);
                PicturePreviewActivity.this.index = localMedia.getPosition();
                PicturePreviewActivity picturePreviewActivity3 = PicturePreviewActivity.this;
                PictureSelectionConfig pictureSelectionConfig = picturePreviewActivity3.config;
                if (!pictureSelectionConfig.previewEggs) {
                    if (pictureSelectionConfig.checkNumMode) {
                        picturePreviewActivity3.check.setText(ValueOf.toString(Integer.valueOf(localMedia.getNum())));
                        PicturePreviewActivity.this.notifyCheckChanged(localMedia);
                    }
                    PicturePreviewActivity picturePreviewActivity4 = PicturePreviewActivity.this;
                    picturePreviewActivity4.onImageChecked(picturePreviewActivity4.position);
                }
                if (PicturePreviewActivity.this.config.isOriginalControl) {
                    PicturePreviewActivity.this.mCbOriginal.setVisibility(PictureMimeType.eqVideo(localMedia.getMimeType()) ? 8 : 0);
                    PicturePreviewActivity picturePreviewActivity5 = PicturePreviewActivity.this;
                    picturePreviewActivity5.mCbOriginal.setChecked(picturePreviewActivity5.config.isCheckOriginalImage);
                }
                PicturePreviewActivity.this.onPageSelectedChange(localMedia);
            }
        });
        if (this.config.isOriginalControl) {
            boolean booleanExtra = getIntent().getBooleanExtra(PictureConfig.EXTRA_CHANGE_ORIGINAL, this.config.isCheckOriginalImage);
            this.mCbOriginal.setVisibility(0);
            PictureSelectionConfig pictureSelectionConfig = this.config;
            pictureSelectionConfig.isCheckOriginalImage = booleanExtra;
            this.mCbOriginal.setChecked(pictureSelectionConfig.isCheckOriginalImage);
            this.mCbOriginal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.luck.picture.lib.o
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    this.f7809a.a(compoundButton, z);
                }
            });
        }
    }

    protected boolean isSelected(LocalMedia localMedia) {
        int size = this.selectImages.size();
        for (int i2 = 0; i2 < size; i2++) {
            LocalMedia localMedia2 = this.selectImages.get(i2);
            if (localMedia2.getPath().equals(localMedia.getPath()) || localMedia2.getId() == localMedia.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.luck.picture.lib.adapter.PictureSimpleFragmentAdapter.OnCallBackActivity
    public void onActivityBackPressed() {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 == 96) {
                ToastUtils.s(getContext(), ((Throwable) intent.getSerializableExtra(UCrop.EXTRA_ERROR)).getMessage());
                return;
            }
            return;
        }
        if (i2 == 69) {
            if (intent != null) {
                intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectImages);
                setResult(-1, intent);
            }
            finish();
            return;
        }
        if (i2 != 609) {
            return;
        }
        intent.putParcelableArrayListExtra(UCrop.Options.EXTRA_OUTPUT_URI_LIST, (ArrayList) UCrop.getMultipleOutput(intent));
        intent.putParcelableArrayListExtra(PictureConfig.EXTRA_SELECT_LIST, (ArrayList) this.selectImages);
        setResult(-1, intent);
        finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i2;
        updateResult();
        PictureWindowAnimationStyle pictureWindowAnimationStyle = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle == null || pictureWindowAnimationStyle.activityPreviewExitAnimation == 0) {
            closeActivity();
            return;
        }
        finish();
        PictureWindowAnimationStyle pictureWindowAnimationStyle2 = this.config.windowAnimationStyle;
        if (pictureWindowAnimationStyle2 == null || (i2 = pictureWindowAnimationStyle2.activityPreviewExitAnimation) == 0) {
            i2 = R.anim.picture_anim_exit;
        }
        overridePendingTransition(0, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0381  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onCheckedComplete() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1013
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.PicturePreviewActivity.onCheckedComplete():void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        int id = view.getId();
        if (id == R.id.picture_left_back) {
            onBackPressed();
            return;
        }
        if (id == R.id.tv_ok || id == R.id.tv_img_num) {
            onComplete();
        } else if (id == R.id.btnCheck) {
            onCheckedComplete();
        }
    }

    protected void onComplete() throws Resources.NotFoundException {
        int i2;
        int i3;
        int size = this.selectImages.size();
        LocalMedia localMedia = this.selectImages.size() > 0 ? this.selectImages.get(0) : null;
        String mimeType = localMedia != null ? localMedia.getMimeType() : "";
        PictureSelectionConfig pictureSelectionConfig = this.config;
        if (pictureSelectionConfig.isWithVideoImage) {
            int size2 = this.selectImages.size();
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size2; i6++) {
                if (PictureMimeType.eqVideo(this.selectImages.get(i6).getMimeType())) {
                    i5++;
                } else {
                    i4++;
                }
            }
            PictureSelectionConfig pictureSelectionConfig2 = this.config;
            if (pictureSelectionConfig2.selectionMode == 2) {
                int i7 = pictureSelectionConfig2.minSelectNum;
                if (i7 > 0 && i4 < i7) {
                    ToastUtils.s(getContext(), getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(this.config.minSelectNum)}));
                    return;
                }
                int i8 = this.config.minVideoSelectNum;
                if (i8 > 0 && i5 < i8) {
                    ToastUtils.s(getContext(), getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(this.config.minVideoSelectNum)}));
                    return;
                }
            }
        } else if (pictureSelectionConfig.selectionMode == 2) {
            if (PictureMimeType.eqImage(mimeType) && (i3 = this.config.minSelectNum) > 0 && size < i3) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_img_num, new Object[]{Integer.valueOf(i3)}));
                return;
            } else if (PictureMimeType.eqVideo(mimeType) && (i2 = this.config.minVideoSelectNum) > 0 && size < i2) {
                ToastUtils.s(getContext(), getString(R.string.picture_min_video_num, new Object[]{Integer.valueOf(i2)}));
                return;
            }
        }
        this.isCompleteOrSelected = true;
        this.isChangeSelectedData = true;
        PictureSelectionConfig pictureSelectionConfig3 = this.config;
        if (pictureSelectionConfig3.isCheckOriginalImage) {
            onBackPressed();
        } else if (pictureSelectionConfig3.chooseMode == PictureMimeType.ofAll() && this.config.isWithVideoImage) {
            bothMimeTypeWith(mimeType, localMedia);
        } else {
            separateMimeTypeWith(mimeType, localMedia);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.selectImages = PictureSelector.obtainSelectorList(bundle);
            this.isCompleteOrSelected = bundle.getBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, false);
            this.isChangeSelectedData = bundle.getBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, false);
            onImageChecked(this.position);
            onSelectNumChange(false);
        }
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!this.isOnSaveInstanceState) {
            ImagesObservable.getInstance().clearPreviewMediaData();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        Animation animation = this.animation;
        if (animation != null) {
            animation.cancel();
            this.animation = null;
        }
        PictureSimpleFragmentAdapter pictureSimpleFragmentAdapter = this.f7745adapter;
        if (pictureSimpleFragmentAdapter != null) {
            pictureSimpleFragmentAdapter.clear();
        }
    }

    public void onImageChecked(int i2) {
        List<LocalMedia> list = this.images;
        if (list == null || list.size() <= 0) {
            this.check.setSelected(false);
        } else {
            this.check.setSelected(isSelected(this.images.get(i2)));
        }
    }

    protected void onPageSelectedChange(LocalMedia localMedia) {
    }

    @Override // com.luck.picture.lib.PictureBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(PictureConfig.EXTRA_COMPLETE_SELECTED, this.isCompleteOrSelected);
        bundle.putBoolean(PictureConfig.EXTRA_CHANGE_SELECTED_DATA, this.isChangeSelectedData);
        PictureSelector.saveSelectorList(bundle, this.selectImages);
    }

    protected void onSelectNumChange(boolean z) {
        this.refresh = z;
        if (!(this.selectImages.size() != 0)) {
            this.mTvPictureOk.setEnabled(false);
            this.mTvPictureOk.setSelected(false);
            PictureParameterStyle pictureParameterStyle = this.config.style;
            if (pictureParameterStyle != null) {
                int i2 = pictureParameterStyle.pictureUnCompleteTextColor;
                if (i2 != 0) {
                    this.mTvPictureOk.setTextColor(i2);
                } else {
                    this.mTvPictureOk.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_9b));
                }
            }
            if (this.numComplete) {
                initCompleteText(0);
                return;
            }
            this.tv_img_num.setVisibility(4);
            PictureParameterStyle pictureParameterStyle2 = this.config.style;
            if (pictureParameterStyle2 == null || TextUtils.isEmpty(pictureParameterStyle2.pictureUnCompleteText)) {
                this.mTvPictureOk.setText(getString(R.string.picture_please_select));
                return;
            } else {
                this.mTvPictureOk.setText(this.config.style.pictureUnCompleteText);
                return;
            }
        }
        this.mTvPictureOk.setEnabled(true);
        this.mTvPictureOk.setSelected(true);
        PictureParameterStyle pictureParameterStyle3 = this.config.style;
        if (pictureParameterStyle3 != null) {
            int i3 = pictureParameterStyle3.pictureCompleteTextColor;
            if (i3 != 0) {
                this.mTvPictureOk.setTextColor(i3);
            } else {
                this.mTvPictureOk.setTextColor(ContextCompat.getColor(getContext(), R.color.picture_color_fa632d));
            }
        }
        if (this.numComplete) {
            initCompleteText(this.selectImages.size());
            return;
        }
        if (this.refresh) {
            this.tv_img_num.startAnimation(this.animation);
        }
        this.tv_img_num.setVisibility(0);
        this.tv_img_num.setText(String.valueOf(this.selectImages.size()));
        PictureParameterStyle pictureParameterStyle4 = this.config.style;
        if (pictureParameterStyle4 == null || TextUtils.isEmpty(pictureParameterStyle4.pictureCompleteText)) {
            this.mTvPictureOk.setText(getString(R.string.picture_completed));
        } else {
            this.mTvPictureOk.setText(this.config.style.pictureCompleteText);
        }
    }

    protected void onSelectedChange(boolean z, LocalMedia localMedia) {
    }
}
