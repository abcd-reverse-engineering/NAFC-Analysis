package com.youth.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoaderInterface;
import com.youth.banner.view.BannerViewPager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Banner extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: adapter, reason: collision with root package name */
    private BannerPagerAdapter f13487adapter;
    private int bannerBackgroundImage;
    private ImageView bannerDefaultImage;
    private OnBannerClickListener bannerListener;
    private int bannerStyle;
    private TextView bannerTitle;
    private Context context;
    private int count;
    private int currentItem;
    private int delayTime;
    private DisplayMetrics dm;
    private int gravity;
    private WeakHandler handler;
    private ImageLoaderInterface imageLoader;
    private List imageUrls;
    private List<View> imageViews;
    private LinearLayout indicator;
    private List<ImageView> indicatorImages;
    private LinearLayout indicatorInside;
    private int indicatorSize;
    private boolean isAutoPlay;
    private boolean isScroll;
    private int lastPosition;
    private OnBannerListener listener;
    private int mIndicatorHeight;
    private int mIndicatorMargin;
    private int mIndicatorSelectedResId;
    private int mIndicatorUnselectedResId;
    private int mIndicatorWidth;
    private int mLayoutResId;
    private ViewPager.OnPageChangeListener mOnPageChangeListener;
    private BannerScroller mScroller;
    private TextView numIndicator;
    private TextView numIndicatorInside;
    private int scaleType;
    private int scrollTime;
    public String tag;
    private final Runnable task;
    private int titleBackground;
    private int titleHeight;
    private int titleTextColor;
    private int titleTextSize;
    private LinearLayout titleView;
    private List<String> titles;
    private BannerViewPager viewPager;

    class BannerPagerAdapter extends PagerAdapter {
        BannerPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return Banner.this.imageViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, final int i2) {
            viewGroup.addView((View) Banner.this.imageViews.get(i2));
            View view = (View) Banner.this.imageViews.get(i2);
            if (Banner.this.bannerListener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.youth.banner.Banner.BannerPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String str = Banner.this.tag;
                        Banner.this.bannerListener.OnBannerClick(i2);
                    }
                });
            }
            if (Banner.this.listener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.youth.banner.Banner.BannerPagerAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Banner.this.listener.OnBannerClick(Banner.this.toRealPosition(i2));
                    }
                });
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    private void createIndicator() {
        this.indicatorImages.clear();
        this.indicator.removeAllViews();
        this.indicatorInside.removeAllViews();
        for (int i2 = 0; i2 < this.count; i2++) {
            ImageView imageView = new ImageView(this.context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mIndicatorWidth, this.mIndicatorHeight);
            int i3 = this.mIndicatorMargin;
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = i3;
            if (i2 == 0) {
                imageView.setImageResource(this.mIndicatorSelectedResId);
            } else {
                imageView.setImageResource(this.mIndicatorUnselectedResId);
            }
            this.indicatorImages.add(imageView);
            int i4 = this.bannerStyle;
            if (i4 == 1 || i4 == 4) {
                this.indicator.addView(imageView, layoutParams);
            } else if (i4 == 5) {
                this.indicatorInside.addView(imageView, layoutParams);
            }
        }
    }

    private void handleTypedArray(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner);
        this.mIndicatorWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_width, this.indicatorSize);
        this.mIndicatorHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_height, this.indicatorSize);
        this.mIndicatorMargin = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_indicator_margin, 5);
        this.mIndicatorSelectedResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Banner_indicator_drawable_selected, R.drawable.gray_radius);
        this.mIndicatorUnselectedResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Banner_indicator_drawable_unselected, R.drawable.white_radius);
        this.scaleType = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_image_scale_type, this.scaleType);
        this.delayTime = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_delay_time, 2000);
        this.scrollTime = typedArrayObtainStyledAttributes.getInt(R.styleable.Banner_scroll_time, BannerConfig.DURATION);
        this.isAutoPlay = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Banner_is_auto_play, true);
        this.titleBackground = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_title_background, -1);
        this.titleHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_title_height, -1);
        this.titleTextColor = typedArrayObtainStyledAttributes.getColor(R.styleable.Banner_title_textcolor, -1);
        this.titleTextSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Banner_title_textsize, -1);
        this.mLayoutResId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Banner_banner_layout, this.mLayoutResId);
        this.bannerBackgroundImage = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Banner_banner_default_image, R.drawable.no_banner);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initImages() {
        this.imageViews.clear();
        int i2 = this.bannerStyle;
        if (i2 == 1 || i2 == 4 || i2 == 5) {
            createIndicator();
            return;
        }
        if (i2 == 3) {
            this.numIndicatorInside.setText("1/" + this.count);
            return;
        }
        if (i2 == 2) {
            this.numIndicator.setText("1/" + this.count);
        }
    }

    private void initView(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        this.imageViews.clear();
        handleTypedArray(context, attributeSet);
        View viewInflate = LayoutInflater.from(context).inflate(this.mLayoutResId, (ViewGroup) this, true);
        this.bannerDefaultImage = (ImageView) viewInflate.findViewById(R.id.bannerDefaultImage);
        this.viewPager = (BannerViewPager) viewInflate.findViewById(R.id.bannerViewPager);
        this.titleView = (LinearLayout) viewInflate.findViewById(R.id.titleView);
        this.indicator = (LinearLayout) viewInflate.findViewById(R.id.circleIndicator);
        this.indicatorInside = (LinearLayout) viewInflate.findViewById(R.id.indicatorInside);
        this.bannerTitle = (TextView) viewInflate.findViewById(R.id.bannerTitle);
        this.numIndicator = (TextView) viewInflate.findViewById(R.id.numIndicator);
        this.numIndicatorInside = (TextView) viewInflate.findViewById(R.id.numIndicatorInside);
        this.bannerDefaultImage.setImageResource(this.bannerBackgroundImage);
        initViewPagerScroll();
    }

    private void initViewPagerScroll() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            this.mScroller = new BannerScroller(this.viewPager.getContext());
            this.mScroller.setDuration(this.scrollTime);
            declaredField.set(this.viewPager, this.mScroller);
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    private void setBannerStyleUI() {
        int i2 = this.count > 1 ? 0 : 8;
        int i3 = this.bannerStyle;
        if (i3 == 1) {
            this.indicator.setVisibility(i2);
            return;
        }
        if (i3 == 2) {
            this.numIndicator.setVisibility(i2);
            return;
        }
        if (i3 == 3) {
            this.numIndicatorInside.setVisibility(i2);
            setTitleStyleUI();
        } else if (i3 == 4) {
            this.indicator.setVisibility(i2);
            setTitleStyleUI();
        } else {
            if (i3 != 5) {
                return;
            }
            this.indicatorInside.setVisibility(i2);
            setTitleStyleUI();
        }
    }

    private void setData() {
        this.currentItem = 1;
        if (this.f13487adapter == null) {
            this.f13487adapter = new BannerPagerAdapter();
            this.viewPager.addOnPageChangeListener(this);
        }
        this.viewPager.setAdapter(this.f13487adapter);
        this.viewPager.setFocusable(true);
        this.viewPager.setCurrentItem(1);
        int i2 = this.gravity;
        if (i2 != -1) {
            this.indicator.setGravity(i2);
        }
        if (!this.isScroll || this.count <= 1) {
            this.viewPager.setScrollable(false);
        } else {
            this.viewPager.setScrollable(true);
        }
        if (this.isAutoPlay) {
            startAutoPlay();
        }
    }

    private void setImageList(List<?> list) {
        if (list == null || list.size() <= 0) {
            this.bannerDefaultImage.setVisibility(0);
            return;
        }
        this.bannerDefaultImage.setVisibility(8);
        initImages();
        int i2 = 0;
        while (i2 <= this.count + 1) {
            ImageLoaderInterface imageLoaderInterface = this.imageLoader;
            View viewCreateImageView = imageLoaderInterface != null ? imageLoaderInterface.createImageView(this.context) : null;
            if (viewCreateImageView == null) {
                viewCreateImageView = new ImageView(this.context);
            }
            setScaleType(viewCreateImageView);
            Object obj = i2 == 0 ? list.get(this.count - 1) : i2 == this.count + 1 ? list.get(0) : list.get(i2 - 1);
            this.imageViews.add(viewCreateImageView);
            ImageLoaderInterface imageLoaderInterface2 = this.imageLoader;
            if (imageLoaderInterface2 != null) {
                imageLoaderInterface2.displayImage(this.context, obj, viewCreateImageView);
            }
            i2++;
        }
    }

    private void setScaleType(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            switch (this.scaleType) {
                case 0:
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    break;
                case 1:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                case 2:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case 3:
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case 4:
                    imageView.setScaleType(ImageView.ScaleType.FIT_END);
                    break;
                case 5:
                    imageView.setScaleType(ImageView.ScaleType.FIT_START);
                    break;
                case 6:
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                case 7:
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    break;
            }
        }
    }

    private void setTitleStyleUI() {
        if (this.titles.size() != this.imageUrls.size()) {
            throw new RuntimeException("[Banner] --> The number of titles and images is different");
        }
        int i2 = this.titleBackground;
        if (i2 != -1) {
            this.titleView.setBackgroundColor(i2);
        }
        int i3 = this.titleHeight;
        if (i3 != -1) {
            this.titleView.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3));
        }
        int i4 = this.titleTextColor;
        if (i4 != -1) {
            this.bannerTitle.setTextColor(i4);
        }
        int i5 = this.titleTextSize;
        if (i5 != -1) {
            this.bannerTitle.setTextSize(0, i5);
        }
        List<String> list = this.titles;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.bannerTitle.setText(this.titles.get(0));
        this.bannerTitle.setVisibility(0);
        this.titleView.setVisibility(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.isAutoPlay) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                startAutoPlay();
            } else if (action == 0) {
                stopAutoPlay();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Banner isAutoPlay(boolean z) {
        this.isAutoPlay = z;
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
        if (i2 == 0) {
            int i3 = this.currentItem;
            if (i3 == 0) {
                this.viewPager.setCurrentItem(this.count, false);
                return;
            } else {
                if (i3 == this.count + 1) {
                    this.viewPager.setCurrentItem(1, false);
                    return;
                }
                return;
            }
        }
        if (i2 != 1) {
            return;
        }
        int i4 = this.currentItem;
        int i5 = this.count;
        if (i4 == i5 + 1) {
            this.viewPager.setCurrentItem(1, false);
        } else if (i4 == 0) {
            this.viewPager.setCurrentItem(i5, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(toRealPosition(i2), f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        this.currentItem = i2;
        ViewPager.OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(toRealPosition(i2));
        }
        int i3 = this.bannerStyle;
        if (i3 == 1 || i3 == 4 || i3 == 5) {
            List<ImageView> list = this.indicatorImages;
            int i4 = this.lastPosition - 1;
            int i5 = this.count;
            list.get((i4 + i5) % i5).setImageResource(this.mIndicatorUnselectedResId);
            List<ImageView> list2 = this.indicatorImages;
            int i6 = this.count;
            list2.get(((i2 - 1) + i6) % i6).setImageResource(this.mIndicatorSelectedResId);
            this.lastPosition = i2;
        }
        if (i2 == 0) {
            i2 = this.count;
        }
        if (i2 > this.count) {
            i2 = 1;
        }
        int i7 = this.bannerStyle;
        if (i7 != 1) {
            if (i7 == 2) {
                this.numIndicator.setText(i2 + "/" + this.count);
                return;
            }
            if (i7 != 3) {
                if (i7 == 4) {
                    this.bannerTitle.setText(this.titles.get(i2 - 1));
                    return;
                } else {
                    if (i7 != 5) {
                        return;
                    }
                    this.bannerTitle.setText(this.titles.get(i2 - 1));
                    return;
                }
            }
            this.numIndicatorInside.setText(i2 + "/" + this.count);
            this.bannerTitle.setText(this.titles.get(i2 - 1));
        }
    }

    public void releaseBanner() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public Banner setBannerAnimation(Class<? extends ViewPager.PageTransformer> cls) {
        try {
            setPageTransformer(true, cls.newInstance());
        } catch (Exception unused) {
        }
        return this;
    }

    public Banner setBannerStyle(int i2) {
        this.bannerStyle = i2;
        return this;
    }

    public Banner setBannerTitles(List<String> list) {
        this.titles = list;
        return this;
    }

    public Banner setDelayTime(int i2) {
        this.delayTime = i2;
        return this;
    }

    public Banner setImageLoader(ImageLoaderInterface imageLoaderInterface) {
        this.imageLoader = imageLoaderInterface;
        return this;
    }

    public Banner setImages(List<?> list) {
        this.imageUrls = list;
        this.count = list.size();
        return this;
    }

    public Banner setIndicatorGravity(int i2) {
        if (i2 == 5) {
            this.gravity = 19;
        } else if (i2 == 6) {
            this.gravity = 17;
        } else if (i2 == 7) {
            this.gravity = 21;
        }
        return this;
    }

    public Banner setOffscreenPageLimit(int i2) {
        BannerViewPager bannerViewPager = this.viewPager;
        if (bannerViewPager != null) {
            bannerViewPager.setOffscreenPageLimit(i2);
        }
        return this;
    }

    @Deprecated
    public Banner setOnBannerClickListener(OnBannerClickListener onBannerClickListener) {
        this.bannerListener = onBannerClickListener;
        return this;
    }

    public Banner setOnBannerListener(OnBannerListener onBannerListener) {
        this.listener = onBannerListener;
        return this;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public Banner setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        this.viewPager.setPageTransformer(z, pageTransformer);
        return this;
    }

    public Banner setViewPagerIsScroll(boolean z) {
        this.isScroll = z;
        return this;
    }

    public Banner start() {
        setBannerStyleUI();
        setImageList(this.imageUrls);
        setData();
        return this;
    }

    public void startAutoPlay() {
        this.handler.removeCallbacks(this.task);
        this.handler.postDelayed(this.task, this.delayTime);
    }

    public void stopAutoPlay() {
        this.handler.removeCallbacks(this.task);
    }

    public int toRealPosition(int i2) {
        int i3 = this.count;
        int i4 = (i2 - 1) % i3;
        return i4 < 0 ? i4 + i3 : i4;
    }

    public void update(List<?> list, List<String> list2) {
        this.titles.clear();
        this.titles.addAll(list2);
        update(list);
    }

    public void updateBannerStyle(int i2) {
        this.indicator.setVisibility(8);
        this.numIndicator.setVisibility(8);
        this.numIndicatorInside.setVisibility(8);
        this.indicatorInside.setVisibility(8);
        this.bannerTitle.setVisibility(8);
        this.titleView.setVisibility(8);
        this.bannerStyle = i2;
        start();
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i2) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        super(context, attributeSet, i2);
        this.tag = "banner";
        this.mIndicatorMargin = 5;
        this.bannerStyle = 1;
        this.delayTime = 2000;
        this.scrollTime = BannerConfig.DURATION;
        this.isAutoPlay = true;
        this.isScroll = true;
        this.mIndicatorSelectedResId = R.drawable.gray_radius;
        this.mIndicatorUnselectedResId = R.drawable.white_radius;
        this.mLayoutResId = R.layout.banner;
        this.count = 0;
        this.gravity = -1;
        this.lastPosition = 1;
        this.scaleType = 1;
        this.handler = new WeakHandler();
        this.task = new Runnable() { // from class: com.youth.banner.Banner.1
            @Override // java.lang.Runnable
            public void run() {
                if (Banner.this.count <= 1 || !Banner.this.isAutoPlay) {
                    return;
                }
                Banner banner = Banner.this;
                banner.currentItem = (banner.currentItem % (Banner.this.count + 1)) + 1;
                if (Banner.this.currentItem == 1) {
                    Banner.this.viewPager.setCurrentItem(Banner.this.currentItem, false);
                    Banner.this.handler.post(Banner.this.task);
                } else {
                    Banner.this.viewPager.setCurrentItem(Banner.this.currentItem);
                    Banner.this.handler.postDelayed(Banner.this.task, Banner.this.delayTime);
                }
            }
        };
        this.context = context;
        this.titles = new ArrayList();
        this.imageUrls = new ArrayList();
        this.imageViews = new ArrayList();
        this.indicatorImages = new ArrayList();
        this.dm = context.getResources().getDisplayMetrics();
        this.indicatorSize = this.dm.widthPixels / 80;
        initView(context, attributeSet);
    }

    public void update(List<?> list) {
        this.imageUrls.clear();
        this.imageViews.clear();
        this.indicatorImages.clear();
        this.imageUrls.addAll(list);
        this.count = this.imageUrls.size();
        start();
    }
}
