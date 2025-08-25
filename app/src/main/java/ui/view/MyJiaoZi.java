package ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.jzvd.JzvdStd;
import com.hicorenational.antifraud.R;

/* loaded from: classes2.dex */
public class MyJiaoZi extends JzvdStd {
    ImageView i1;
    public b j1;
    private int k1;
    private View l1;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyJiaoZi myJiaoZi = MyJiaoZi.this;
            b bVar = myJiaoZi.j1;
            if (bVar != null) {
                bVar.a(myJiaoZi.k1, MyJiaoZi.this.l1);
            }
        }
    }

    public interface b {
        void a(int i2, View view);
    }

    public MyJiaoZi(Context context) {
        super(context);
        this.i1 = new ImageView(context);
        this.i1.setImageResource(R.drawable.ic_video_delete);
        this.i1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.i1.setX(100.0f);
        this.i1.setY(200.0f);
        addView(this.i1);
    }

    public void setOnDeleteClickListener(b bVar) {
        this.j1 = bVar;
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void u() {
        super.u();
        ImageView imageView = this.i1;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void v() {
        super.v();
        ImageView imageView = this.i1;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    @Override // cn.jzvd.JzvdStd, cn.jzvd.Jzvd
    public void a(Context context) {
        super.a(context);
    }

    public void a(int i2, View view) {
        this.k1 = i2;
        this.l1 = view;
    }

    public MyJiaoZi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i1 = new ImageView(context);
        this.i1.setImageResource(R.drawable.ic_video_delete);
        this.i1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.i1.setX(300.0f);
        this.i1.setY(0.0f);
        this.i1.setOnClickListener(new a());
        addView(this.i1);
    }
}
