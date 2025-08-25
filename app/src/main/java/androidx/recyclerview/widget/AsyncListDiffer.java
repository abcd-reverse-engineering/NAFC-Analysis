package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = new MainThreadExecutor();
    final AsyncDifferConfig<T> mConfig;

    @Nullable
    private List<T> mList;
    final Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;

    @NonNull
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    private static class MainThreadExecutor implements Executor {
        final Handler mHandler = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.mHandler.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull RecyclerView.Adapter adapter2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter2), new AsyncDifferConfig.Builder(itemCallback).build());
    }

    @NonNull
    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    void latchList(@NonNull List<T> list, @NonNull DiffUtil.DiffResult diffResult) {
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
    }

    public void submitList(@Nullable final List<T> list) {
        final int i2 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i2;
        final List<T> list2 = this.mList;
        if (list == list2) {
            return;
        }
        if (list == null) {
            int size = list2.size();
            this.mList = null;
            this.mReadOnlyList = Collections.emptyList();
            this.mUpdateCallback.onRemoved(0, size);
            return;
        }
        if (list2 != null) {
            this.mConfig.getBackgroundThreadExecutor().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areContentsTheSame(int i3, int i4) {
                            Object obj = list2.get(i3);
                            Object obj2 = list.get(i4);
                            if (obj != null && obj2 != null) {
                                return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                            }
                            if (obj == null && obj2 == null) {
                                return true;
                            }
                            throw new AssertionError();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public boolean areItemsTheSame(int i3, int i4) {
                            Object obj = list2.get(i3);
                            Object obj2 = list.get(i4);
                            return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(obj, obj2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        @Nullable
                        public Object getChangePayload(int i3, int i4) {
                            Object obj = list2.get(i3);
                            Object obj2 = list.get(i4);
                            if (obj == null || obj2 == null) {
                                throw new AssertionError();
                            }
                            return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getNewListSize() {
                            return list.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public int getOldListSize() {
                            return list2.size();
                        }
                    });
                    AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.mMaxScheduledGeneration == i2) {
                                asyncListDiffer.latchList(list, diffResultCalculateDiff);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.mList = list;
        this.mReadOnlyList = Collections.unmodifiableList(list);
        this.mUpdateCallback.onInserted(0, list.size());
    }

    public AsyncListDiffer(@NonNull ListUpdateCallback listUpdateCallback, @NonNull AsyncDifferConfig<T> asyncDifferConfig) {
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = listUpdateCallback;
        this.mConfig = asyncDifferConfig;
        if (asyncDifferConfig.getMainThreadExecutor() != null) {
            this.mMainThreadExecutor = asyncDifferConfig.getMainThreadExecutor();
        } else {
            this.mMainThreadExecutor = sMainThreadExecutor;
        }
    }
}
