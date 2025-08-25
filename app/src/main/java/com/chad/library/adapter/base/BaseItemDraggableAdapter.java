package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int e0 = 0;
    private static final String f0 = "Item drag and item swipe should pass the same ItemTouchHelper";
    protected int V;
    protected ItemTouchHelper W;
    protected boolean X;
    protected boolean Y;
    protected com.chad.library.adapter.base.listener.a Z;
    protected com.chad.library.adapter.base.listener.b a0;
    protected boolean b0;
    protected View.OnTouchListener c0;
    protected View.OnLongClickListener d0;

    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
            ItemTouchHelper itemTouchHelper = baseItemDraggableAdapter.W;
            if (itemTouchHelper == null || !baseItemDraggableAdapter.X) {
                return true;
            }
            itemTouchHelper.startDrag((RecyclerView.ViewHolder) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
            return true;
        }
    }

    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (MotionEventCompat.getActionMasked(motionEvent) != 0) {
                return false;
            }
            BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
            if (baseItemDraggableAdapter.b0) {
                return false;
            }
            ItemTouchHelper itemTouchHelper = baseItemDraggableAdapter.W;
            if (itemTouchHelper == null || !baseItemDraggableAdapter.X) {
                return true;
            }
            itemTouchHelper.startDrag((RecyclerView.ViewHolder) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
            return true;
        }
    }

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.V = 0;
        this.X = false;
        this.Y = false;
        this.b0 = true;
    }

    private boolean n(int i2) {
        return i2 >= 0 && i2 < this.A.size();
    }

    public void G() {
        this.X = false;
        this.W = null;
    }

    public void H() {
        this.Y = false;
    }

    public void I() {
        this.Y = true;
    }

    public boolean J() {
        return this.X;
    }

    public boolean K() {
        return this.Y;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(K k2, int i2) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k2, i2);
        int itemViewType = k2.getItemViewType();
        if (this.W == null || !this.X || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819) {
            return;
        }
        int i3 = this.V;
        if (i3 == 0) {
            k2.itemView.setTag(R.id.BaseQuickAdapter_viewholder_support, k2);
            k2.itemView.setOnLongClickListener(this.d0);
            return;
        }
        View viewC = k2.c(i3);
        if (viewC != null) {
            viewC.setTag(R.id.BaseQuickAdapter_viewholder_support, k2);
            if (this.b0) {
                viewC.setOnLongClickListener(this.d0);
            } else {
                viewC.setOnTouchListener(this.c0);
            }
        }
    }

    public int b(RecyclerView.ViewHolder viewHolder) {
        return viewHolder.getAdapterPosition() - j();
    }

    public void c(RecyclerView.ViewHolder viewHolder) {
        com.chad.library.adapter.base.listener.a aVar = this.Z;
        if (aVar == null || !this.X) {
            return;
        }
        aVar.a(viewHolder, b(viewHolder));
    }

    public void d(RecyclerView.ViewHolder viewHolder) {
        com.chad.library.adapter.base.listener.a aVar = this.Z;
        if (aVar == null || !this.X) {
            return;
        }
        aVar.b(viewHolder, b(viewHolder));
    }

    public void e(RecyclerView.ViewHolder viewHolder) {
        com.chad.library.adapter.base.listener.b bVar = this.a0;
        if (bVar == null || !this.Y) {
            return;
        }
        bVar.c(viewHolder, b(viewHolder));
    }

    public void f(RecyclerView.ViewHolder viewHolder) {
        com.chad.library.adapter.base.listener.b bVar = this.a0;
        if (bVar == null || !this.Y) {
            return;
        }
        bVar.a(viewHolder, b(viewHolder));
    }

    public void g(RecyclerView.ViewHolder viewHolder) {
        com.chad.library.adapter.base.listener.b bVar = this.a0;
        if (bVar != null && this.Y) {
            bVar.b(viewHolder, b(viewHolder));
        }
        int iB = b(viewHolder);
        if (n(iB)) {
            this.A.remove(iB);
            notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    public void k(boolean z) {
        this.b0 = z;
        if (this.b0) {
            this.c0 = null;
            this.d0 = new a();
        } else {
            this.c0 = new b();
            this.d0 = null;
        }
    }

    public void m(int i2) {
        this.V = i2;
    }

    public void setOnItemDragListener(com.chad.library.adapter.base.listener.a aVar) {
        this.Z = aVar;
    }

    public void setOnItemSwipeListener(com.chad.library.adapter.base.listener.b bVar) {
        this.a0 = bVar;
    }

    public BaseItemDraggableAdapter(int i2, List<T> list) {
        super(i2, list);
        this.V = 0;
        this.X = false;
        this.Y = false;
        this.b0 = true;
    }

    public void a(@NonNull ItemTouchHelper itemTouchHelper) {
        a(itemTouchHelper, 0, true);
    }

    public void a(@NonNull ItemTouchHelper itemTouchHelper, int i2, boolean z) {
        this.X = true;
        this.W = itemTouchHelper;
        m(i2);
        k(z);
    }

    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        int iB = b(viewHolder);
        int iB2 = b(viewHolder2);
        if (n(iB) && n(iB2)) {
            if (iB < iB2) {
                int i2 = iB;
                while (i2 < iB2) {
                    int i3 = i2 + 1;
                    Collections.swap(this.A, i2, i3);
                    i2 = i3;
                }
            } else {
                for (int i4 = iB; i4 > iB2; i4--) {
                    Collections.swap(this.A, i4, i4 - 1);
                }
            }
            notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        }
        com.chad.library.adapter.base.listener.a aVar = this.Z;
        if (aVar == null || !this.X) {
            return;
        }
        aVar.a(viewHolder, iB, viewHolder2, iB2);
    }

    public void a(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f2, float f3, boolean z) {
        com.chad.library.adapter.base.listener.b bVar = this.a0;
        if (bVar == null || !this.Y) {
            return;
        }
        bVar.a(canvas, viewHolder, f2, f3, z);
    }
}
