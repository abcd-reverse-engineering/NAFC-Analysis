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
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.e.f;
import com.lxj.xpopup.widget.CheckView;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class CenterListPopupView extends CenterPopupView {
    RecyclerView s;
    TextView t;
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
            int[] iArr = CenterListPopupView.this.w;
            if (iArr == null || iArr.length <= i2) {
                viewHolder.a(R.id.iv_image).setVisibility(8);
            } else {
                viewHolder.a(R.id.iv_image).setVisibility(0);
                viewHolder.a(R.id.iv_image).setBackgroundResource(CenterListPopupView.this.w[i2]);
            }
            if (CenterListPopupView.this.y != -1) {
                if (viewHolder.a(R.id.check_view) != null) {
                    viewHolder.a(R.id.check_view).setVisibility(i2 != CenterListPopupView.this.y ? 8 : 0);
                    ((CheckView) viewHolder.a(R.id.check_view)).setColor(com.lxj.xpopup.b.b());
                }
                TextView textView = (TextView) viewHolder.a(R.id.tv_text);
                CenterListPopupView centerListPopupView = CenterListPopupView.this;
                textView.setTextColor(i2 == centerListPopupView.y ? com.lxj.xpopup.b.b() : centerListPopupView.getResources().getColor(R.color._xpopup_title_color));
            }
        }
    }

    class b extends MultiItemTypeAdapter.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EasyAdapter f8086a;

        b(EasyAdapter easyAdapter) {
            this.f8086a = easyAdapter;
        }

        @Override // com.lxj.easyadapter.MultiItemTypeAdapter.c, com.lxj.easyadapter.MultiItemTypeAdapter.b
        public void a(View view, RecyclerView.ViewHolder viewHolder, int i2) {
            if (CenterListPopupView.this.x != null && i2 >= 0 && i2 < this.f8086a.a().size()) {
                CenterListPopupView.this.x.a(i2, (String) this.f8086a.a().get(i2));
            }
            CenterListPopupView centerListPopupView = CenterListPopupView.this;
            if (centerListPopupView.y != -1) {
                centerListPopupView.y = i2;
                this.f8086a.notifyDataSetChanged();
            }
            if (CenterListPopupView.this.f7987a.f8030d.booleanValue()) {
                CenterListPopupView.this.b();
            }
        }
    }

    public CenterListPopupView(@NonNull Context context) {
        super(context);
        this.y = -1;
    }

    public CenterListPopupView b(int i2) {
        this.q = i2;
        return this;
    }

    public CenterListPopupView c(int i2) {
        this.y = i2;
        return this;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        int i2 = this.q;
        return i2 == 0 ? R.layout._xpopup_center_impl_list : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        int i2 = this.f7987a.f8037k;
        return i2 == 0 ? (int) (super.getMaxWidth() * 0.8f) : i2;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected void k() {
        super.k();
        this.s = (RecyclerView) findViewById(R.id.recyclerView);
        this.t = (TextView) findViewById(R.id.tv_title);
        if (this.t != null) {
            if (TextUtils.isEmpty(this.u)) {
                this.t.setVisibility(8);
            } else {
                this.t.setText(this.u);
            }
        }
        List listAsList = Arrays.asList(this.v);
        int i2 = this.r;
        if (i2 == 0) {
            i2 = R.layout._xpopup_adapter_text;
        }
        a aVar = new a(listAsList, i2);
        aVar.setOnItemClickListener(new b(aVar));
        this.s.setAdapter(aVar);
    }

    public CenterListPopupView a(int i2) {
        this.r = i2;
        return this;
    }

    public CenterListPopupView a(String str, String[] strArr, int[] iArr) {
        this.u = str;
        this.v = strArr;
        this.w = iArr;
        return this;
    }

    public CenterListPopupView a(f fVar) {
        this.x = fVar;
        return this;
    }
}
