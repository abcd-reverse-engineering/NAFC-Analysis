package com.luck.picture.lib.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumDirectoryAdapter;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.listener.OnAlbumItemClickListener;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.tools.AnimUtils;
import com.luck.picture.lib.tools.AttrsUtils;
import com.luck.picture.lib.tools.ScreenUtils;
import java.util.List;

/* loaded from: classes.dex */
public class FolderPopWindow extends PopupWindow {

    /* renamed from: adapter, reason: collision with root package name */
    private PictureAlbumDirectoryAdapter f7824adapter;
    private int chooseMode;
    private PictureSelectionConfig config;
    private Context context;
    private Drawable drawableDown;
    private Drawable drawableUp;
    private boolean isDismiss = false;
    private ImageView ivArrowView;
    private int maxHeight;
    private RecyclerView recyclerView;
    private View rootView;
    private View rootViewBg;
    private View window;

    public FolderPopWindow(Context context, PictureSelectionConfig pictureSelectionConfig) {
        this.context = context;
        this.config = pictureSelectionConfig;
        this.chooseMode = pictureSelectionConfig.chooseMode;
        this.window = LayoutInflater.from(context).inflate(R.layout.picture_window_folder, (ViewGroup) null);
        setContentView(this.window);
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        PictureParameterStyle pictureParameterStyle = pictureSelectionConfig.style;
        if (pictureParameterStyle != null) {
            int i2 = pictureParameterStyle.pictureTitleUpResId;
            if (i2 != 0) {
                this.drawableUp = ContextCompat.getDrawable(context, i2);
            }
            int i3 = pictureSelectionConfig.style.pictureTitleDownResId;
            if (i3 != 0) {
                this.drawableDown = ContextCompat.getDrawable(context, i3);
            }
        } else if (pictureSelectionConfig.isWeChatStyle) {
            this.drawableUp = ContextCompat.getDrawable(context, R.drawable.picture_icon_wechat_up);
            this.drawableDown = ContextCompat.getDrawable(context, R.drawable.picture_icon_wechat_down);
        } else {
            int i4 = pictureSelectionConfig.upResId;
            if (i4 != 0) {
                this.drawableUp = ContextCompat.getDrawable(context, i4);
            } else {
                this.drawableUp = AttrsUtils.getTypeValueDrawable(context, R.attr.picture_arrow_up_icon);
            }
            int i5 = pictureSelectionConfig.downResId;
            if (i5 != 0) {
                this.drawableDown = ContextCompat.getDrawable(context, i5);
            } else {
                this.drawableDown = AttrsUtils.getTypeValueDrawable(context, R.attr.picture_arrow_down_icon);
            }
        }
        this.maxHeight = (int) (ScreenUtils.getScreenHeight(context) * 0.6d);
        initView();
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public void bindFolder(List<LocalMediaFolder> list) {
        this.f7824adapter.setChooseMode(this.chooseMode);
        this.f7824adapter.bindFolderData(list);
        this.recyclerView.getLayoutParams().height = (list == null || list.size() <= 8) ? -2 : this.maxHeight;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isDismiss) {
            return;
        }
        this.rootViewBg.animate().alpha(0.0f).setDuration(150L).start();
        this.ivArrowView.setImageDrawable(this.drawableDown);
        AnimUtils.rotateArrow(this.ivArrowView, false);
        this.isDismiss = true;
        super.dismiss();
        this.isDismiss = false;
    }

    public void initView() {
        this.rootViewBg = this.window.findViewById(R.id.rootViewBg);
        this.f7824adapter = new PictureAlbumDirectoryAdapter(this.config);
        this.recyclerView = (RecyclerView) this.window.findViewById(R.id.folder_list);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        this.recyclerView.setAdapter(this.f7824adapter);
        this.rootView = this.window.findViewById(R.id.rootView);
        this.rootViewBg.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.widget.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f7826a.a(view);
            }
        });
        if (Build.VERSION.SDK_INT < 21) {
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f7825a.b(view);
                }
            });
        }
    }

    public void setArrowImageView(ImageView imageView) {
        this.ivArrowView = imageView;
    }

    public void setOnAlbumItemClickListener(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.f7824adapter.setOnAlbumItemClickListener(onAlbumItemClickListener);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        try {
            if (Build.VERSION.SDK_INT == 24) {
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
            } else {
                super.showAsDropDown(view);
            }
            this.isDismiss = false;
            this.ivArrowView.setImageDrawable(this.drawableUp);
            AnimUtils.rotateArrow(this.ivArrowView, true);
            this.rootViewBg.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateFolderCheckStatus(List<LocalMedia> list) {
        int i2;
        try {
            List<LocalMediaFolder> folderData = this.f7824adapter.getFolderData();
            int size = folderData.size();
            for (int i3 = 0; i3 < size; i3++) {
                LocalMediaFolder localMediaFolder = folderData.get(i3);
                localMediaFolder.setCheckedNum(0);
                List<LocalMedia> images = localMediaFolder.getImages();
                int size2 = images.size();
                int size3 = list.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    LocalMedia localMedia = images.get(i4);
                    String path = localMedia.getPath();
                    while (i2 < size3) {
                        LocalMedia localMedia2 = list.get(i2);
                        i2 = (path.equals(localMedia2.getPath()) || localMedia.getId() == localMedia2.getId()) ? 0 : i2 + 1;
                        localMediaFolder.setCheckedNum(1);
                        break;
                    }
                }
            }
            this.f7824adapter.bindFolderData(folderData);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
