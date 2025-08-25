package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;

/* loaded from: classes.dex */
public class ItemDragAndSwipeCallback extends ItemTouchHelper.Callback {

    /* renamed from: a, reason: collision with root package name */
    private BaseItemDraggableAdapter f5458a;

    /* renamed from: b, reason: collision with root package name */
    private float f5459b = 0.1f;

    /* renamed from: c, reason: collision with root package name */
    private float f5460c = 0.7f;

    /* renamed from: d, reason: collision with root package name */
    private int f5461d = 15;

    /* renamed from: e, reason: collision with root package name */
    private int f5462e = 32;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.f5458a = baseItemDraggableAdapter;
    }

    public void a(float f2) {
        this.f5459b = f2;
    }

    public void b(float f2) {
        this.f5460c = f2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (a(viewHolder)) {
            return;
        }
        if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) != null && ((Boolean) viewHolder.itemView.getTag(R.id.BaseQuickAdapter_dragging_support)).booleanValue()) {
            this.f5458a.c(viewHolder);
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, false);
        }
        if (viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) == null || !((Boolean) viewHolder.itemView.getTag(R.id.BaseQuickAdapter_swiping_support)).booleanValue()) {
            return;
        }
        this.f5458a.e(viewHolder);
        viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, false);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.f5459b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder) ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(this.f5461d, this.f5462e);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.f5460c;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return this.f5458a.K();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, float f3, int i2, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f2, f3, i2, z);
        if (i2 != 1 || a(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        canvas.save();
        if (f2 > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f2, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f2, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f2, view.getTop());
        }
        this.f5458a.a(canvas, viewHolder, f2, f3, z);
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i2, RecyclerView.ViewHolder viewHolder2, int i3, int i4, int i5) {
        super.onMoved(recyclerView, viewHolder, i2, viewHolder2, i3, i4, i5);
        this.f5458a.a(viewHolder, viewHolder2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i2) {
        if (i2 == 2 && !a(viewHolder)) {
            this.f5458a.d(viewHolder);
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, true);
        } else if (i2 == 1 && !a(viewHolder)) {
            this.f5458a.f(viewHolder);
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, true);
        }
        super.onSelectedChanged(viewHolder, i2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i2) {
        if (a(viewHolder)) {
            return;
        }
        this.f5458a.g(viewHolder);
    }

    public void a(int i2) {
        this.f5461d = i2;
    }

    public void b(int i2) {
        this.f5462e = i2;
    }

    private boolean a(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }
}
