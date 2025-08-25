package com.umeng.socialize.shareboard.widgets;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.umeng.socialize.shareboard.widgets.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class SocializeViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DEFAULT_WIDTH_FACTOR = 1;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private int mActivePointerId;
    private SocializePagerAdapter mAdapter;
    private boolean mCalledSuper;
    private int mCloseEnough;
    private int mCurPosition;
    private int mDefaultGutterSize;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private List<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mScrollState;
    private Scroller mScroller;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.2
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.3
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;

        ItemInfo() {
        }
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i2);

        void onPageScrolled(int i2, float f2, int i3);

        void onPageSelected(int i2);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws Resources.NotFoundException {
            SocializeViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() throws Resources.NotFoundException {
            SocializeViewPager.this.dataSetChanged();
        }
    }

    public SocializeViewPager(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i2, ItemInfo itemInfo2) {
        int i3;
        int i4;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        if (itemInfo2 != null) {
            int i5 = itemInfo2.position;
            int i6 = itemInfo.position;
            if (i5 < i6) {
                int i7 = 0;
                float pageWidth = itemInfo2.offset + 1.0f + 0.0f;
                while (true) {
                    i5++;
                    if (i5 > itemInfo.position || i7 >= this.mItems.size()) {
                        break;
                    }
                    ItemInfo itemInfo5 = this.mItems.get(i7);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i5 <= itemInfo4.position || i7 >= this.mItems.size() - 1) {
                            break;
                        }
                        i7++;
                        itemInfo5 = this.mItems.get(i7);
                    }
                    while (i5 < itemInfo4.position) {
                        pageWidth += this.mAdapter.getPageWidth(i5) + 0.0f;
                        i5++;
                    }
                    itemInfo4.offset = pageWidth;
                    pageWidth += 1.0f;
                }
            } else if (i5 > i6) {
                int size = this.mItems.size() - 1;
                float pageWidth2 = itemInfo2.offset;
                while (true) {
                    i5--;
                    if (i5 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i5 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i5 > itemInfo3.position) {
                        pageWidth2 -= this.mAdapter.getPageWidth(i5) + 0.0f;
                        i5--;
                    }
                    pageWidth2 -= 1.0f;
                    itemInfo3.offset = pageWidth2;
                }
            }
        }
        int size2 = this.mItems.size();
        float pageWidth3 = itemInfo.offset;
        int i8 = itemInfo.position;
        int i9 = i8 - 1;
        this.mFirstOffset = i8 == 0 ? pageWidth3 : -3.4028235E38f;
        int i10 = count - 1;
        this.mLastOffset = itemInfo.position == i10 ? (itemInfo.offset + 1.0f) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i11);
            while (true) {
                i4 = itemInfo7.position;
                if (i9 <= i4) {
                    break;
                }
                pageWidth3 -= this.mAdapter.getPageWidth(i9) + 0.0f;
                i9--;
            }
            pageWidth3 -= 1.0f;
            itemInfo7.offset = pageWidth3;
            if (i4 == 0) {
                this.mFirstOffset = pageWidth3;
            }
            i11--;
            i9--;
        }
        float pageWidth4 = itemInfo.offset + 1.0f + 0.0f;
        int i12 = itemInfo.position + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i13);
            while (true) {
                i3 = itemInfo8.position;
                if (i12 >= i3) {
                    break;
                }
                pageWidth4 += this.mAdapter.getPageWidth(i12) + 0.0f;
                i12++;
            }
            if (i3 == i10) {
                this.mLastOffset = (pageWidth4 + 1.0f) - 1.0f;
            }
            itemInfo8.offset = pageWidth4;
            pageWidth4 += 1.0f;
            i13++;
            i12++;
        }
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2 && (!this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (currX != scrollX) {
                    pageScrolled(currX);
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 += (int) (f2 + (i2 >= this.mCurPosition ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() <= 0) {
            return i2;
        }
        return Math.max(this.mItems.get(0).position, Math.min(i2, this.mItems.get(r4.size() - 1).position));
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i4);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i2, f2, i3);
                }
            }
        }
    }

    private void dispatchOnPageSelected(int i2) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
            }
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i2);
                }
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        ItemInfo itemInfo = null;
        int i3 = 0;
        boolean z = true;
        int i4 = -1;
        float f2 = 0.0f;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i3);
            if (!z && itemInfo2.position != (i2 = i4 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f2 + 0.0f + 0.0f;
                itemInfo2.position = i2;
                i3--;
            }
            f2 = itemInfo2.offset;
            float f3 = 1.0f + f2 + 0.0f;
            if (!z && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f3 || i3 == this.mItems.size() - 1) {
                return itemInfo2;
            }
            i4 = itemInfo2.position;
            i3++;
            itemInfo = itemInfo2;
            z = false;
        }
        return itemInfo;
    }

    private void init() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mCloseEnough = (int) (2.0f * f2);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mDefaultGutterSize = (int) (f2 * 16.0f);
        ViewCompat.setOnApplyWindowInsetsListener(this, new ViewCompat.OnApplyWindowInsetsListener() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.4
            @Override // com.umeng.socialize.shareboard.widgets.ViewCompat.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (windowInsetsCompatOnApplyWindowInsets.isConsumed()) {
                    return windowInsetsCompatOnApplyWindowInsets;
                }
                Rect rect = SocializeViewPager.this.mTempRect;
                rect.left = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetLeft();
                rect.top = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetTop();
                rect.right = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetRight();
                rect.bottom = windowInsetsCompatOnApplyWindowInsets.getSystemWindowInsetBottom();
                int childCount = SocializeViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WindowInsetsCompat windowInsetsCompatDispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(SocializeViewPager.this.getChildAt(i2), windowInsetsCompatOnApplyWindowInsets);
                    rect.left = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetLeft(), rect.left);
                    rect.top = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetTop(), rect.top);
                    rect.right = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetRight(), rect.right);
                    rect.bottom = Math.min(windowInsetsCompatDispatchApplyWindowInsets.getSystemWindowInsetBottom(), rect.bottom);
                }
                return windowInsetsCompatOnApplyWindowInsets.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > 0.0f) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i2) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo itemInfoInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i3 = itemInfoInfoForCurrentScrollPosition.position;
        float f2 = clientWidth;
        float f3 = ((i2 / f2) - itemInfoInfoForCurrentScrollPosition.offset) / 1.0f;
        this.mCalledSuper = false;
        onPageScrolled(i3, f3, (int) (f2 * f3));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f2) {
        boolean z;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        ItemInfo itemInfo = this.mItems.get(0);
        List<ItemInfo> list = this.mItems;
        boolean z2 = true;
        ItemInfo itemInfo2 = list.get(list.size() - 1);
        if (itemInfo.position != 0) {
            f4 = itemInfo.offset * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f5 = itemInfo2.offset * clientWidth;
            z2 = false;
        }
        if (scrollX < f4) {
            scrollX = f4;
        } else if (scrollX > f5) {
            scrollX = f5;
            z = z2;
        } else {
            z = false;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - i2;
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void populate() throws Resources.NotFoundException {
        populate(this.mCurPosition);
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        ItemInfo itemInfoInfoForPosition = infoForPosition(this.mCurPosition);
        int iMin = (int) ((itemInfoInfoForPosition != null ? Math.min(itemInfoInfoForPosition.offset, this.mLastOffset) : 0.0f) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            completeScroll(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        return true;
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) throws Resources.NotFoundException {
        ItemInfo itemInfoInfoForPosition = infoForPosition(i2);
        int clientWidth = itemInfoInfoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(itemInfoInfoForPosition.offset, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i3);
            if (z2) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        ItemInfo itemInfoInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurPosition) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    ItemInfo addNewItem(int i2, int i3) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i2;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i3, itemInfo);
        }
        return itemInfo;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo itemInfoInfoForChild;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurPosition) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.isDecor |= false;
        if (!this.mInLayout) {
            super.addView(view, i2, layoutParams);
        } else {
            if (layoutParams2 != null && layoutParams2.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r7) throws android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            android.view.View r0 = r6.findFocus()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != r6) goto La
            goto L63
        La:
            if (r0 == 0) goto L62
            android.view.ViewParent r4 = r0.getParent()
        L10:
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L1d
            if (r4 != r6) goto L18
            r4 = 1
            goto L1e
        L18:
            android.view.ViewParent r4 = r4.getParent()
            goto L10
        L1d:
            r4 = 0
        L1e:
            if (r4 != 0) goto L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
        L34:
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L4d
            java.lang.String r5 = " => "
            r4.append(r5)
            java.lang.Class r5 = r0.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r4.append(r5)
            android.view.ViewParent r0 = r0.getParent()
            goto L34
        L4d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r5)
            java.lang.String r4 = r4.toString()
            r0.append(r4)
            r0.toString()
            goto L63
        L62:
            r3 = r0
        L63:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r0 = r0.findNextFocus(r6, r3, r7)
            r4 = 66
            r5 = 17
            if (r0 == 0) goto Lb4
            if (r0 == r3) goto Lb4
            if (r7 != r5) goto L94
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto L8e
            if (r1 < r2) goto L8e
            boolean r0 = r6.pageLeft()
            goto L92
        L8e:
            boolean r0 = r0.requestFocus()
        L92:
            r2 = r0
            goto Lc7
        L94:
            if (r7 != r4) goto Lc7
            android.graphics.Rect r1 = r6.mTempRect
            android.graphics.Rect r1 = r6.getChildRectInPagerCoordinates(r1, r0)
            int r1 = r1.left
            android.graphics.Rect r2 = r6.mTempRect
            android.graphics.Rect r2 = r6.getChildRectInPagerCoordinates(r2, r3)
            int r2 = r2.left
            if (r3 == 0) goto Laf
            if (r1 > r2) goto Laf
            boolean r0 = r6.pageRight()
            goto L92
        Laf:
            boolean r0 = r0.requestFocus()
            goto L92
        Lb4:
            if (r7 == r5) goto Lc3
            if (r7 != r1) goto Lb9
            goto Lc3
        Lb9:
            if (r7 == r4) goto Lbe
            r0 = 2
            if (r7 != r0) goto Lc7
        Lbe:
            boolean r2 = r6.pageRight()
            goto Lc7
        Lc3:
            boolean r2 = r6.pageLeft()
        Lc7:
            if (r2 == 0) goto Ld0
            int r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7)
            r6.playSoundEffect(r7)
        Ld0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.shareboard.widgets.SocializeViewPager.arrowScroll(int):boolean");
    }

    protected boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollHorizontally(view, -i2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void dataSetChanged() throws Resources.NotFoundException {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int iMax = this.mCurPosition;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i3 = this.mCurPosition;
                    if (i3 == itemInfo.position) {
                        iMax = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = itemInfo.position;
                    if (i4 != itemPosition) {
                        if (i4 == this.mCurPosition) {
                            iMax = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            setCurrentItemInternal(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoInfoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurPosition && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                if (KeyEventCompat.hasNoModifiers(keyEvent)) {
                    return arrowScroll(2);
                }
                if (KeyEventCompat.hasModifiers(keyEvent, 1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public int getCurrentItem() {
        return this.mCurPosition;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    ItemInfo infoForChild(View view) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i2) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            ItemInfo itemInfo = this.mItems.get(i3);
            if (itemInfo.position == i2) {
                return itemInfo;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.mLastMotionX;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.mInitialMotionY);
                if (f2 != 0.0f && !isGutterDrag(this.mLastMotionX, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.mLastMotionX = x2;
                    this.mLastMotionY = y2;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                if (fAbs > this.mTouchSlop && fAbs * 0.5f > fAbs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    float f3 = this.mInitialMotionX;
                    float f4 = this.mTouchSlop;
                    this.mLastMotionX = f2 > 0.0f ? f3 + f4 : f3 - f4;
                    this.mLastMotionY = y2;
                } else if (fAbs2 > this.mTouchSlop) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) throws Resources.NotFoundException {
        ItemInfo itemInfoInfoForChild;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i8 = (i6 - paddingLeft) - paddingRight;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!layoutParams.isDecor && (itemInfoInfoForChild = infoForChild(childAt)) != null) {
                    float f2 = i8;
                    int i10 = ((int) (itemInfoInfoForChild.offset * f2)) + paddingLeft;
                    if (layoutParams.needsMeasure) {
                        layoutParams.needsMeasure = false;
                        childAt.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i7 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt.layout(i10, paddingTop, childAt.getMeasuredWidth() + i10, childAt.getMeasuredHeight() + paddingTop);
                }
            }
        }
        if (this.mFirstLayout) {
            scrollToItem(this.mCurPosition, false, 0, false);
        }
        this.mFirstLayout = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) throws Resources.NotFoundException {
        LayoutParams layoutParams;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft * 1, 1073741824), iMakeMeasureSpec);
            }
        }
    }

    protected void onPageScrolled(int i2, float f2, int i3) {
        dispatchOnPageScrolled(i2, f2, i3);
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        ItemInfo itemInfoInfoForChild;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (itemInfoInfoForChild = infoForChild(childAt)) != null && itemInfoInfoForChild.position == this.mCurPosition && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            recomputeScrollPosition(i2, i4, 0, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.shareboard.widgets.SocializeViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean pageLeft() throws Resources.NotFoundException {
        int i2 = this.mCurPosition;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    boolean pageRight() throws Resources.NotFoundException {
        SocializePagerAdapter socializePagerAdapter = this.mAdapter;
        if (socializePagerAdapter == null || this.mCurPosition >= socializePagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurPosition + 1, true);
        return true;
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(SocializePagerAdapter socializePagerAdapter) throws Resources.NotFoundException {
        SocializePagerAdapter socializePagerAdapter2 = this.mAdapter;
        if (socializePagerAdapter2 != null) {
            socializePagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                ItemInfo itemInfo = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeAllViews();
            this.mCurPosition = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = socializePagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem < 0) {
                if (z) {
                    requestLayout();
                    return;
                } else {
                    populate();
                    return;
                }
            }
            this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
            setCurrentItemInternal(this.mRestoredCurItem, false, true);
            this.mRestoredCurItem = -1;
            this.mRestoredAdapterState = null;
            this.mRestoredClassLoader = null;
        }
    }

    public void setCurrentItem(int i2) throws Resources.NotFoundException {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        setCurrentItemInternal(i2, z, z2, 0);
    }

    void setScrollState(int i2) {
        if (this.mScrollState == i2) {
            return;
        }
        this.mScrollState = i2;
        dispatchOnScrollStateChanged(i2);
    }

    void smoothScrollTo(int i2, int i3) throws Resources.NotFoundException {
        smoothScrollTo(i2, i3, 0);
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor;

        public LayoutParams() {
            super(-1, -1);
            this.widthFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.widthFactor = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SocializeViewPager.LAYOUT_ATTRS);
            this.gravity = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0060, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fa A[PHI: r7 r11 r15
  0x00fa: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B:60:0x00ef, B:57:0x00dc, B:51:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00fa: PHI (r11v4 int) = (r11v3 int), (r11v2 int), (r11v7 int) binds: [B:60:0x00ef, B:57:0x00dc, B:51:0x00c8] A[DONT_GENERATE, DONT_INLINE]
  0x00fa: PHI (r15v5 int) = (r15v3 int), (r15v4 int), (r15v8 int) binds: [B:60:0x00ef, B:57:0x00dc, B:51:0x00c8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0159 A[PHI: r3 r12
  0x0159: PHI (r3v22 float) = (r3v20 float), (r3v21 float), (r3v19 float) binds: [B:94:0x0181, B:91:0x016a, B:84:0x014e] A[DONT_GENERATE, DONT_INLINE]
  0x0159: PHI (r12v7 int) = (r12v5 int), (r12v6 int), (r12v4 int) binds: [B:94:0x0181, B:91:0x016a, B:84:0x014e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void populate(int r18) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.shareboard.widgets.SocializeViewPager.populate(int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) throws Resources.NotFoundException {
        SocializePagerAdapter socializePagerAdapter = this.mAdapter;
        if (socializePagerAdapter == null || socializePagerAdapter.getCount() <= 0) {
            return;
        }
        if (z2 || this.mCurPosition != i2 || this.mItems.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.mAdapter.getCount()) {
                i2 = this.mAdapter.getCount() - 1;
            }
            int i4 = this.mOffscreenPageLimit;
            int i5 = this.mCurPosition;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                    this.mItems.get(i6).scrolling = true;
                }
            }
            boolean z3 = this.mCurPosition != i2;
            if (!this.mFirstLayout) {
                populate(i2);
                scrollToItem(i2, z, i3, z3);
            } else {
                this.mCurPosition = i2;
                if (z3) {
                    dispatchOnPageSelected(i2);
                }
                requestLayout();
            }
        }
    }

    void smoothScrollTo(int i2, int i3, int i4) throws Resources.NotFoundException {
        int scrollX;
        if (getChildCount() == 0) {
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fDistanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / (f2 * this.mAdapter.getPageWidth(this.mCurPosition))) + 1.0f) * 100.0f), 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i5, scrollY, i6, i7, iMin);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setCurrentItem(int i2, boolean z) throws Resources.NotFoundException {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SocializeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    public SocializeViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }

    @TargetApi(21)
    public SocializeViewPager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mActivePointerId = -1;
        this.mOffscreenPageLimit = 1;
        this.mItems = new ArrayList();
        this.mTempItem = new ItemInfo();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mTempRect = new Rect();
        this.mEndScrollRunnable = new Runnable() { // from class: com.umeng.socialize.shareboard.widgets.SocializeViewPager.1
            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                SocializeViewPager.this.setScrollState(0);
                SocializeViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        init();
    }
}
