package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: classes.dex */
public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mNewDataStart;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback;
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(this.mWrappedCallback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areContentsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areItemsTheSame(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.mWrappedCallback.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.mWrappedCallback.getChangePayload(t2, t22);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i2, int i3) {
            this.mBatchingListUpdateCallback.onChanged(i2, i3, null);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i2, int i3) {
            this.mBatchingListUpdateCallback.onInserted(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i2, int i3) {
            this.mBatchingListUpdateCallback.onMoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i2, int i3) {
            this.mBatchingListUpdateCallback.onRemoved(i2, i3);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i2, int i3, Object obj) {
            this.mBatchingListUpdateCallback.onChanged(i2, i3, obj);
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i2, int i3);

        public void onChanged(int i2, int i3, Object obj) {
            onChanged(i2, i3);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void addAllInternal(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iSortAndDedup = sortAndDedup(tArr);
        if (this.mSize != 0) {
            merge(tArr, iSortAndDedup);
            return;
        }
        this.mData = tArr;
        this.mSize = iSortAndDedup;
        this.mCallback.onInserted(0, iSortAndDedup);
    }

    private void addToData(int i2, T t) {
        int i3 = this.mSize;
        if (i2 > i3) {
            throw new IndexOutOfBoundsException("cannot add item to " + i2 + " because size is " + this.mSize);
        }
        T[] tArr = this.mData;
        if (i3 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
            System.arraycopy(this.mData, 0, tArr2, 0, i2);
            tArr2[i2] = t;
            System.arraycopy(this.mData, i2, tArr2, i2 + 1, this.mSize - i2);
            this.mData = tArr2;
        } else {
            System.arraycopy(tArr, i2, tArr, i2 + 1, i3 - i2);
            this.mData[i2] = t;
        }
        this.mSize++;
    }

    private T[] copyArray(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int findIndexOf(T t, T[] tArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int i5 = (i2 + i3) / 2;
            T t2 = tArr[i5];
            int iCompare = this.mCallback.compare(t2, t);
            if (iCompare < 0) {
                i2 = i5 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.mCallback.areItemsTheSame(t2, t)) {
                        return i5;
                    }
                    int iLinearEqualitySearch = linearEqualitySearch(t, i5, i2, i3);
                    return (i4 == 1 && iLinearEqualitySearch == -1) ? i5 : iLinearEqualitySearch;
                }
                i3 = i5;
            }
        }
        if (i4 == 1) {
            return i2;
        }
        return -1;
    }

    private int findSameItem(T t, T[] tArr, int i2, int i3) {
        while (i2 < i3) {
            if (this.mCallback.areItemsTheSame(tArr[i2], t)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private int linearEqualitySearch(T t, int i2, int i3, int i4) {
        T t2;
        for (int i5 = i2 - 1; i5 >= i3; i5--) {
            T t3 = this.mData[i5];
            if (this.mCallback.compare(t3, t) != 0) {
                break;
            }
            if (this.mCallback.areItemsTheSame(t3, t)) {
                return i5;
            }
        }
        do {
            i2++;
            if (i2 >= i4) {
                return -1;
            }
            t2 = this.mData[i2];
            if (this.mCallback.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.mCallback.areItemsTheSame(t2, t));
        return i2;
    }

    private void merge(T[] tArr, int i2) {
        boolean z = !(this.mCallback instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        int i3 = 0;
        this.mOldDataStart = 0;
        int i4 = this.mSize;
        this.mOldDataSize = i4;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i4 + i2 + 10));
        this.mNewDataStart = 0;
        while (true) {
            if (this.mOldDataStart >= this.mOldDataSize && i3 >= i2) {
                break;
            }
            int i5 = this.mOldDataStart;
            int i6 = this.mOldDataSize;
            if (i5 == i6) {
                int i7 = i2 - i3;
                System.arraycopy(tArr, i3, this.mData, this.mNewDataStart, i7);
                this.mNewDataStart += i7;
                this.mSize += i7;
                this.mCallback.onInserted(this.mNewDataStart - i7, i7);
                break;
            }
            if (i3 == i2) {
                int i8 = i6 - i5;
                System.arraycopy(this.mOldData, i5, this.mData, this.mNewDataStart, i8);
                this.mNewDataStart += i8;
                break;
            }
            T t = this.mOldData[i5];
            T t2 = tArr[i3];
            int iCompare = this.mCallback.compare(t, t2);
            if (iCompare > 0) {
                T[] tArr2 = this.mData;
                int i9 = this.mNewDataStart;
                this.mNewDataStart = i9 + 1;
                tArr2[i9] = t2;
                this.mSize++;
                i3++;
                this.mCallback.onInserted(this.mNewDataStart - 1, 1);
            } else if (iCompare == 0 && this.mCallback.areItemsTheSame(t, t2)) {
                T[] tArr3 = this.mData;
                int i10 = this.mNewDataStart;
                this.mNewDataStart = i10 + 1;
                tArr3[i10] = t2;
                i3++;
                this.mOldDataStart++;
                if (!this.mCallback.areContentsTheSame(t, t2)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                T[] tArr4 = this.mData;
                int i11 = this.mNewDataStart;
                this.mNewDataStart = i11 + 1;
                tArr4[i11] = t;
                this.mOldDataStart++;
            }
        }
        this.mOldData = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private void removeItemAtIndex(int i2, boolean z) {
        T[] tArr = this.mData;
        System.arraycopy(tArr, i2 + 1, tArr, i2, (this.mSize - i2) - 1);
        this.mSize--;
        this.mData[this.mSize] = null;
        if (z) {
            this.mCallback.onRemoved(i2, 1);
        }
    }

    private void replaceAllInsert(T t) {
        T[] tArr = this.mData;
        int i2 = this.mNewDataStart;
        tArr[i2] = t;
        this.mNewDataStart = i2 + 1;
        this.mSize++;
        this.mCallback.onInserted(this.mNewDataStart - 1, 1);
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        boolean z = !(this.mCallback instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        this.mOldData = this.mData;
        this.mNewDataStart = 0;
        int iSortAndDedup = sortAndDedup(tArr);
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, iSortAndDedup));
        while (true) {
            if (this.mNewDataStart >= iSortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                break;
            }
            int i2 = this.mOldDataStart;
            int i3 = this.mOldDataSize;
            if (i2 >= i3) {
                int i4 = this.mNewDataStart;
                int i5 = iSortAndDedup - i4;
                System.arraycopy(tArr, i4, this.mData, i4, i5);
                this.mNewDataStart += i5;
                this.mSize += i5;
                this.mCallback.onInserted(i4, i5);
                break;
            }
            int i6 = this.mNewDataStart;
            if (i6 >= iSortAndDedup) {
                int i7 = i3 - i2;
                this.mSize -= i7;
                this.mCallback.onRemoved(i6, i7);
                break;
            }
            T t = this.mOldData[i2];
            T t2 = tArr[i6];
            int iCompare = this.mCallback.compare(t, t2);
            if (iCompare < 0) {
                replaceAllRemove();
            } else if (iCompare > 0) {
                replaceAllInsert(t2);
            } else if (this.mCallback.areItemsTheSame(t, t2)) {
                T[] tArr2 = this.mData;
                int i8 = this.mNewDataStart;
                tArr2[i8] = t2;
                this.mOldDataStart++;
                this.mNewDataStart = i8 + 1;
                if (!this.mCallback.areContentsTheSame(t, t2)) {
                    Callback callback = this.mCallback;
                    callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                replaceAllRemove();
                replaceAllInsert(t2);
            }
        }
        this.mOldData = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private void replaceAllRemove() {
        this.mSize--;
        this.mOldDataStart++;
        this.mCallback.onRemoved(this.mNewDataStart, 1);
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.mCallback);
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T t = tArr[i4];
            if (this.mCallback.compare(tArr[i3], t) == 0) {
                int iFindSameItem = findSameItem(t, tArr, i3, i2);
                if (iFindSameItem != -1) {
                    tArr[iFindSameItem] = t;
                } else {
                    if (i2 != i4) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i4) {
                    tArr[i2] = t;
                }
                i3 = i2;
                i2++;
            }
        }
        return i2;
    }

    private void throwIfInMutationOperation() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t) {
        throwIfInMutationOperation();
        return add(t, true);
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        throwIfInMutationOperation();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            addAllInternal(tArr);
        } else {
            addAllInternal(copyArray(tArr));
        }
    }

    public void beginBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.mBatchedCallback == null) {
            this.mBatchedCallback = new BatchedCallback(callback);
        }
        this.mCallback = this.mBatchedCallback;
    }

    public void clear() {
        throwIfInMutationOperation();
        int i2 = this.mSize;
        if (i2 == 0) {
            return;
        }
        Arrays.fill(this.mData, 0, i2, (Object) null);
        this.mSize = 0;
        this.mCallback.onRemoved(0, i2);
    }

    public void endBatchedUpdates() {
        throwIfInMutationOperation();
        Callback callback = this.mCallback;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.mCallback;
        BatchedCallback batchedCallback = this.mBatchedCallback;
        if (callback2 == batchedCallback) {
            this.mCallback = batchedCallback.mWrappedCallback;
        }
    }

    public T get(int i2) throws IndexOutOfBoundsException {
        int i3;
        if (i2 < this.mSize && i2 >= 0) {
            T[] tArr = this.mOldData;
            return (tArr == null || i2 < (i3 = this.mNewDataStart)) ? this.mData[i2] : tArr[(i2 - i3) + this.mOldDataStart];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i2 + " but size is " + this.mSize);
    }

    public int indexOf(T t) {
        if (this.mOldData == null) {
            return findIndexOf(t, this.mData, 0, this.mSize, 4);
        }
        int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mNewDataStart, 4);
        if (iFindIndexOf != -1) {
            return iFindIndexOf;
        }
        int iFindIndexOf2 = findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
        if (iFindIndexOf2 != -1) {
            return (iFindIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
        }
        return -1;
    }

    public void recalculatePositionOfItemAt(int i2) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i2);
        removeItemAtIndex(i2, false);
        int iAdd = add(t, false);
        if (i2 != iAdd) {
            this.mCallback.onMoved(i2, iAdd);
        }
    }

    public boolean remove(T t) {
        throwIfInMutationOperation();
        return remove(t, true);
    }

    public T removeItemAt(int i2) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t = get(i2);
        removeItemAtIndex(i2, true);
        return t;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        throwIfInMutationOperation();
        if (z) {
            replaceAllInternal(tArr);
        } else {
            replaceAllInternal(copyArray(tArr));
        }
    }

    public int size() {
        return this.mSize;
    }

    public void updateItemAt(int i2, T t) throws IndexOutOfBoundsException {
        throwIfInMutationOperation();
        T t2 = get(i2);
        boolean z = t2 == t || !this.mCallback.areContentsTheSame(t2, t);
        if (t2 != t && this.mCallback.compare(t2, t) == 0) {
            this.mData[i2] = t;
            if (z) {
                Callback callback = this.mCallback;
                callback.onChanged(i2, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.mCallback;
            callback2.onChanged(i2, 1, callback2.getChangePayload(t2, t));
        }
        removeItemAtIndex(i2, false);
        int iAdd = add(t, false);
        if (i2 != iAdd) {
            this.mCallback.onMoved(i2, iAdd);
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i2) {
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t, boolean z) {
        int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 1);
        if (iFindIndexOf == -1) {
            iFindIndexOf = 0;
        } else if (iFindIndexOf < this.mSize) {
            T t2 = this.mData[iFindIndexOf];
            if (this.mCallback.areItemsTheSame(t2, t)) {
                if (this.mCallback.areContentsTheSame(t2, t)) {
                    this.mData[iFindIndexOf] = t;
                    return iFindIndexOf;
                }
                this.mData[iFindIndexOf] = t;
                Callback callback = this.mCallback;
                callback.onChanged(iFindIndexOf, 1, callback.getChangePayload(t2, t));
                return iFindIndexOf;
            }
        }
        addToData(iFindIndexOf, t);
        if (z) {
            this.mCallback.onInserted(iFindIndexOf, 1);
        }
        return iFindIndexOf;
    }

    private boolean remove(T t, boolean z) {
        int iFindIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 2);
        if (iFindIndexOf == -1) {
            return false;
        }
        removeItemAtIndex(iFindIndexOf, z);
        return true;
    }

    public void replaceAll(@NonNull T... tArr) {
        replaceAll(tArr, false);
    }

    public void addAll(@NonNull T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
    }
}
