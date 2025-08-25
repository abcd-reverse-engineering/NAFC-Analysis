package ui.view.drag.vert;

import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import util.c1;

/* loaded from: classes2.dex */
public abstract class OnRecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private GestureDetectorCompat f20539a;

    /* renamed from: b, reason: collision with root package name */
    private RecyclerView f20540b;

    /* renamed from: c, reason: collision with root package name */
    private DisplayMetrics f20541c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f20542d = false;

    private class b extends GestureDetector.SimpleOnGestureListener {
        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            if (motionEvent.getX() < OnRecyclerItemClickListener.this.f20541c.widthPixels - c1.a(OnRecyclerItemClickListener.this.f20540b.getContext(), 80.0f)) {
                return true;
            }
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f20540b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder != null) {
                OnRecyclerItemClickListener.this.b(OnRecyclerItemClickListener.this.f20540b.getChildViewHolder(viewFindChildViewUnder));
                OnRecyclerItemClickListener.this.f20542d = true;
            }
            return super.onDown(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (OnRecyclerItemClickListener.this.f20542d) {
                OnRecyclerItemClickListener.this.a();
                OnRecyclerItemClickListener.this.f20542d = false;
            }
            return super.onScroll(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View viewFindChildViewUnder = OnRecyclerItemClickListener.this.f20540b.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (viewFindChildViewUnder == null) {
                return true;
            }
            OnRecyclerItemClickListener.this.a(OnRecyclerItemClickListener.this.f20540b.getChildViewHolder(viewFindChildViewUnder));
            return true;
        }
    }

    public OnRecyclerItemClickListener(RecyclerView recyclerView) {
        this.f20540b = recyclerView;
        this.f20541c = recyclerView.getContext().getResources().getDisplayMetrics();
        this.f20539a = new GestureDetectorCompat(recyclerView.getContext(), new b());
    }

    public abstract void a();

    public abstract void a(RecyclerView.ViewHolder viewHolder);

    public abstract void b(RecyclerView.ViewHolder viewHolder);

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f20539a.onTouchEvent(motionEvent);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        this.f20539a.onTouchEvent(motionEvent);
    }
}
