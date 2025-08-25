package com.lxj.xpopup.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.easyadapter.EasyAdapter;
import com.lxj.easyadapter.MultiItemTypeAdapter;
import com.lxj.easyadapter.ViewHolder;
import com.lxj.xpopup.R;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.e.f;
import com.lxj.xpopup.widget.CheckView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class BottomListPopupView extends BottomPopupView {
    RecyclerView q;
    TextView r;
    protected int s;
    protected int t;
    String u;
    String[] v;
    int[] w;
    private f x;
    int y;

    class a extends EasyAdapter<String> {
        a(List list, int i2) {
            super(list, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.lxj.easyadapter.EasyAdapter
        public void a(@NonNull ViewHolder viewHolder, @NonNull String str, int i2) {
            viewHolder.a(R.id.tv_text, str);
            int[] iArr = BottomListPopupView.this.w;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.a(R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.a(R.id.iv_image).setVisibility(0);
                viewHolder.a(R.id.iv_image).setBackgroundResource(BottomListPopupView.this.w[i2]);
            }
            if (BottomListPopupView.this.y != -1) {
                if (viewHolder.a(R.id.check_view) != null) {
                    viewHolder.a(R.id.check_view).setVisibility(i2 != BottomListPopupView.this.y ? 8 : 0);
                    ((CheckView) viewHolder.a(R.id.check_view)).setColor(com.lxj.xpopup.b.b());
                }
                TextView textView = (TextView) viewHolder.a(R.id.tv_text);
                BottomListPopupView bottomListPopupView = BottomListPopupView.this;
                textView.setTextColor(i2 == bottomListPopupView.y ? com.lxj.xpopup.b.b() : bottomListPopupView.getResources().getColor(R.color._xpopup_title_color));
            }
        }
    }

    class b extends MultiItemTypeAdapter.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EasyAdapter f8082a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BottomListPopupView.this.f7987a.f8030d.booleanValue()) {
                    BottomListPopupView.this.b();
                }
            }
        }

        b(EasyAdapter easyAdapter) {
            this.f8082a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.c, com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (BottomListPopupView.this.x != null) {
                BottomListPopupView.this.x.a(i2, (String) this.f8082a.a().get(i2));
            }
            BottomListPopupView bottomListPopupView = BottomListPopupView.this;
            if (bottomListPopupView.y != -1) {
                bottomListPopupView.y = i2;
                this.f8082a.notifyDataSetChanged();
            }
            BottomListPopupView.this.postDelayed(new a(), 100L);
        }
    }

    public BottomListPopupView(@NonNull Context context) {
        super(context);
        this.y = -1;
    }

    public BottomListPopupView b(int i2) {
        this.s = i2;
        return this;
    }

    public BottomListPopupView c(int i2) {
        this.y = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.s;
        return i2 == 0 ? R.layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.BottomPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.q = (RecyclerView) findViewById(R.id.recyclerView);
        this.r = (TextView) findViewById(R.id.tv_title);
        if (this.r != null) {
            if (TextUtils.isEmpty(this.u)) {
                this.r.setVisibility(8);
            } else {
                this.r.setText(this.u);
            }
        }
        List listAsList = Arrays.asList(this.v);
        int i2 = this.t;
        if (i2 == 0) {
            i2 = R.layout._xpopup_adapter_text;
        }
        a aVar = new a(listAsList, i2);
        aVar.setOnItemClickListener(new b(aVar));
        this.q.setAdapter(aVar);
    }

    public BottomListPopupView a(int i2) {
        this.t = i2;
        return this;
    }

    public BottomListPopupView a(String str, String[] strArr, int[] iArr) {
        this.u = str;
        this.v = strArr;
        this.w = iArr;
        return this;
    }

    public BottomListPopupView a(f fVar) {
        this.x = fVar;
        return this;
    }
}
