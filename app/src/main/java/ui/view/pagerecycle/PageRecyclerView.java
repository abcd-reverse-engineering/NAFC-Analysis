package ui.view.pagerecycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes2.dex */
public class PageRecyclerView extends RecyclerView {

    /* renamed from: a, reason: collision with root package name */
    private Context f20624a;

    /* renamed from: b, reason: collision with root package name */
    private PageAdapter f20625b;

    /* renamed from: c, reason: collision with root package name */
    private int f20626c;

    /* renamed from: d, reason: collision with root package name */
    private float f20627d;

    /* renamed from: e, reason: collision with root package name */
    private float f20628e;

    /* renamed from: f, reason: collision with root package name */
    private float f20629f;

    /* renamed from: g, reason: collision with root package name */
    private int f20630g;

    /* renamed from: h, reason: collision with root package name */
    private int f20631h;

    /* renamed from: i, reason: collision with root package name */
    private int f20632i;

    /* renamed from: j, reason: collision with root package name */
    private int f20633j;

    /* renamed from: k, reason: collision with root package name */
    private int f20634k;

    /* renamed from: l, reason: collision with root package name */
    private PageIndicatorView f20635l;

    public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: a, reason: collision with root package name */
        private List<?> f20636a;

        /* renamed from: b, reason: collision with root package name */
        private a f20637b;

        /* renamed from: c, reason: collision with root package name */
        private int f20638c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f20639d;

        public PageAdapter(List<?> list, a aVar) {
            this.f20636a = null;
            this.f20637b = null;
            this.f20639d = 0;
            this.f20636a = list;
            this.f20637b = aVar;
            this.f20639d = this.f20636a.size() + (PageRecyclerView.this.f20630g * PageRecyclerView.this.f20631h);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f20639d;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (PageRecyclerView.this.f20631h == 1) {
                viewHolder.itemView.getLayoutParams().width = this.f20638c + PageRecyclerView.this.f20634k;
                viewHolder.itemView.setPadding(PageRecyclerView.this.f20634k, 0, 0, 0);
            } else {
                int i3 = i2 % (PageRecyclerView.this.f20630g * PageRecyclerView.this.f20631h);
                if (i3 < PageRecyclerView.this.f20630g) {
                    viewHolder.itemView.getLayoutParams().width = this.f20638c + PageRecyclerView.this.f20634k;
                    viewHolder.itemView.setPadding(PageRecyclerView.this.f20634k, 0, 0, 0);
                } else if (i3 >= (PageRecyclerView.this.f20630g * PageRecyclerView.this.f20631h) - PageRecyclerView.this.f20630g) {
                    viewHolder.itemView.getLayoutParams().width = this.f20638c + PageRecyclerView.this.f20634k;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                } else {
                    viewHolder.itemView.getLayoutParams().width = this.f20638c;
                    viewHolder.itemView.setPadding(0, 0, 0, 0);
                }
            }
            if (i2 >= this.f20636a.size()) {
                viewHolder.itemView.setVisibility(4);
            } else {
                viewHolder.itemView.setVisibility(0);
                this.f20637b.a(viewHolder, i2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (this.f20638c <= 0) {
                this.f20638c = (viewGroup.getWidth() - PageRecyclerView.this.f20634k) / PageRecyclerView.this.f20631h;
            }
            RecyclerView.ViewHolder viewHolderA = this.f20637b.a(viewGroup, i2);
            viewHolderA.itemView.measure(0, 0);
            viewHolderA.itemView.getLayoutParams().width = this.f20638c;
            viewHolderA.itemView.getLayoutParams().height = viewHolderA.itemView.getMeasuredHeight();
            return viewHolderA;
        }

        public void a(List<?> list) {
            this.f20636a = list;
            this.f20639d = this.f20636a.size() + (PageRecyclerView.this.f20630g * PageRecyclerView.this.f20631h);
            notifyDataSetChanged();
            PageRecyclerView.this.a();
        }
    }

    public interface a {
        RecyclerView.ViewHolder a(ViewGroup viewGroup, int i2);

        void a(RecyclerView.ViewHolder viewHolder, int i2);
    }

    public PageRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        PageAdapter pageAdapter = this.f20625b;
        if (pageAdapter != null && pageAdapter.f20636a != null && this.f20625b.f20636a.size() == 0) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20627d = motionEvent.getX();
        } else {
            if (action == 1) {
                this.f20628e = motionEvent.getX() - this.f20627d;
                if (Math.abs(this.f20628e) > this.f20626c) {
                    if (this.f20628e > 0.0f) {
                        int i2 = this.f20633j;
                        this.f20633j = i2 == 1 ? 1 : i2 - 1;
                    } else {
                        int i3 = this.f20633j;
                        int i4 = this.f20632i;
                        if (i3 != i4) {
                            i4 = i3 + 1;
                        }
                        this.f20633j = i4;
                    }
                    PageIndicatorView pageIndicatorView = this.f20635l;
                    if (pageIndicatorView != null) {
                        pageIndicatorView.setSelectedPage(this.f20633j - 1);
                    }
                }
                smoothScrollBy((int) (((this.f20633j - 1) * getWidth()) - this.f20629f), 0);
                return true;
            }
            if (action == 2 && this.f20633j == this.f20632i && this.f20627d - motionEvent.getX() > 0.0f) {
                return true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrolled(int i2, int i3) {
        this.f20629f += i2;
        super.onScrolled(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter2) {
        super.setAdapter(adapter2);
        this.f20625b = (PageAdapter) adapter2;
        a();
    }

    public void setIndicator(PageIndicatorView pageIndicatorView) {
        this.f20635l = pageIndicatorView;
    }

    public void setPageMargin(int i2) {
        this.f20634k = i2;
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f20624a = context;
        setLayoutManager(new GridLayoutManager(this.f20624a, this.f20630g, 0, false));
        setOverScrollMode(2);
    }

    public PageRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20624a = null;
        this.f20625b = null;
        this.f20626c = 100;
        this.f20627d = 0.0f;
        this.f20628e = 0.0f;
        this.f20629f = 0.0f;
        this.f20630g = 1;
        this.f20631h = 1;
        this.f20632i = 0;
        this.f20633j = 1;
        this.f20634k = 0;
        this.f20635l = null;
        a(context);
    }

    public void a(int i2, int i3) {
        if (i2 <= 0) {
            i2 = this.f20630g;
        }
        this.f20630g = i2;
        if (i3 <= 0) {
            i3 = this.f20631h;
        }
        this.f20631h = i3;
        setLayoutManager(new GridLayoutManager(this.f20624a, this.f20630g, 0, false));
    }

    public View a(int i2) {
        int i3 = this.f20631h;
        if ((i2 / i3) + 1 == this.f20633j) {
            return getChildAt(i2 % i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iCeil = (int) Math.ceil(this.f20625b.f20636a.size() / (this.f20630g * this.f20631h));
        if (iCeil != this.f20632i) {
            PageIndicatorView pageIndicatorView = this.f20635l;
            if (pageIndicatorView != null) {
                pageIndicatorView.a(iCeil);
            }
            int i2 = this.f20632i;
            if (iCeil < i2 && this.f20633j == i2) {
                this.f20633j = iCeil;
                smoothScrollBy(-getWidth(), 0);
            }
            PageIndicatorView pageIndicatorView2 = this.f20635l;
            if (pageIndicatorView2 != null) {
                pageIndicatorView2.setSelectedPage(this.f20633j - 1);
            }
            this.f20632i = iCeil;
        }
    }
}
