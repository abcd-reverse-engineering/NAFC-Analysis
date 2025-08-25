package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class ChildHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "ChildrenHelper";
    final Callback mCallback;
    final Bucket mBucket = new Bucket();
    final List<View> mHiddenViews = new ArrayList();

    static class Bucket {
        static final int BITS_PER_WORD = 64;
        static final long LAST_BIT = Long.MIN_VALUE;
        long mData = 0;
        Bucket mNext;

        Bucket() {
        }

        private void ensureNext() {
            if (this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        void clear(int i2) {
            if (i2 < 64) {
                this.mData &= ~(1 << i2);
                return;
            }
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.clear(i2 - 64);
            }
        }

        int countOnesBefore(int i2) {
            Bucket bucket = this.mNext;
            return bucket == null ? i2 >= 64 ? Long.bitCount(this.mData) : Long.bitCount(this.mData & ((1 << i2) - 1)) : i2 < 64 ? Long.bitCount(this.mData & ((1 << i2) - 1)) : bucket.countOnesBefore(i2 - 64) + Long.bitCount(this.mData);
        }

        boolean get(int i2) {
            if (i2 < 64) {
                return (this.mData & (1 << i2)) != 0;
            }
            ensureNext();
            return this.mNext.get(i2 - 64);
        }

        void insert(int i2, boolean z) {
            if (i2 >= 64) {
                ensureNext();
                this.mNext.insert(i2 - 64, z);
                return;
            }
            boolean z2 = (this.mData & Long.MIN_VALUE) != 0;
            long j2 = (1 << i2) - 1;
            long j3 = this.mData;
            this.mData = ((j3 & (~j2)) << 1) | (j3 & j2);
            if (z) {
                set(i2);
            } else {
                clear(i2);
            }
            if (z2 || this.mNext != null) {
                ensureNext();
                this.mNext.insert(0, z2);
            }
        }

        boolean remove(int i2) {
            if (i2 >= 64) {
                ensureNext();
                return this.mNext.remove(i2 - 64);
            }
            long j2 = 1 << i2;
            boolean z = (this.mData & j2) != 0;
            this.mData &= ~j2;
            long j3 = j2 - 1;
            long j4 = this.mData;
            this.mData = Long.rotateRight(j4 & (~j3), 1) | (j4 & j3);
            Bucket bucket = this.mNext;
            if (bucket != null) {
                if (bucket.get(0)) {
                    set(63);
                }
                this.mNext.remove(0);
            }
            return z;
        }

        void reset() {
            this.mData = 0L;
            Bucket bucket = this.mNext;
            if (bucket != null) {
                bucket.reset();
            }
        }

        void set(int i2) {
            if (i2 < 64) {
                this.mData |= 1 << i2;
            } else {
                ensureNext();
                this.mNext.set(i2 - 64);
            }
        }

        public String toString() {
            if (this.mNext == null) {
                return Long.toBinaryString(this.mData);
            }
            return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
        }
    }

    interface Callback {
        void addView(View view, int i2);

        void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i2);

        View getChildAt(int i2);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i2);
    }

    ChildHelper(Callback callback) {
        this.mCallback = callback;
    }

    private int getOffset(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = this.mCallback.getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            int iCountOnesBefore = i2 - (i3 - this.mBucket.countOnesBefore(i3));
            if (iCountOnesBefore == 0) {
                while (this.mBucket.get(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += iCountOnesBefore;
        }
        return -1;
    }

    private void hideViewInternal(View view) {
        this.mHiddenViews.add(view);
        this.mCallback.onEnteredHiddenState(view);
    }

    private boolean unhideViewInternal(View view) {
        if (!this.mHiddenViews.remove(view)) {
            return false;
        }
        this.mCallback.onLeftHiddenState(view);
        return true;
    }

    void addView(View view, boolean z) {
        addView(view, -1, z);
    }

    void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int childCount = i2 < 0 ? this.mCallback.getChildCount() : getOffset(i2);
        this.mBucket.insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.attachViewToParent(view, childCount, layoutParams);
    }

    void detachViewFromParent(int i2) {
        int offset = getOffset(i2);
        this.mBucket.remove(offset);
        this.mCallback.detachViewFromParent(offset);
    }

    View findHiddenNonRemovedView(int i2) {
        int size = this.mHiddenViews.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.mHiddenViews.get(i3);
            RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i2 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    View getChildAt(int i2) {
        return this.mCallback.getChildAt(getOffset(i2));
    }

    int getChildCount() {
        return this.mCallback.getChildCount() - this.mHiddenViews.size();
    }

    View getUnfilteredChildAt(int i2) {
        return this.mCallback.getChildAt(i2);
    }

    int getUnfilteredChildCount() {
        return this.mCallback.getChildCount();
    }

    void hide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.mBucket.set(iIndexOfChild);
            hideViewInternal(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    int indexOfChild(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1 || this.mBucket.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.mBucket.countOnesBefore(iIndexOfChild);
    }

    boolean isHidden(View view) {
        return this.mHiddenViews.contains(view);
    }

    void removeAllViewsUnfiltered() {
        this.mBucket.reset();
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
            this.mHiddenViews.remove(size);
        }
        this.mCallback.removeAllViews();
    }

    void removeView(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.mBucket.remove(iIndexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(iIndexOfChild);
    }

    void removeViewAt(int i2) {
        int offset = getOffset(i2);
        View childAt = this.mCallback.getChildAt(offset);
        if (childAt == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    boolean removeViewIfHidden(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild == -1) {
            unhideViewInternal(view);
            return true;
        }
        if (!this.mBucket.get(iIndexOfChild)) {
            return false;
        }
        this.mBucket.remove(iIndexOfChild);
        unhideViewInternal(view);
        this.mCallback.removeViewAt(iIndexOfChild);
        return true;
    }

    public String toString() {
        return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
    }

    void unhide(View view) {
        int iIndexOfChild = this.mCallback.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.mBucket.get(iIndexOfChild)) {
            this.mBucket.clear(iIndexOfChild);
            unhideViewInternal(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    void addView(View view, int i2, boolean z) {
        int childCount = i2 < 0 ? this.mCallback.getChildCount() : getOffset(i2);
        this.mBucket.insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        this.mCallback.addView(view, childCount);
    }
}
