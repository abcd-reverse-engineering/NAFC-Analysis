package ui.view;

import android.content.Context;
import android.view.View;
import com.hicorenational.antifraud.R;
import com.luozm.captcha.Captcha;
import com.lxj.xpopup.core.CenterPopupView;
import interfaces.IOneClickListener;
import java.util.Random;
import util.w1;

/* loaded from: classes2.dex */
public class HuaKuaiWindow extends CenterPopupView {
    int[] s;
    private Captcha t;
    private Context u;
    private Random v;
    private IOneClickListener w;

    public HuaKuaiWindow(Context context, IOneClickListener iOneClickListener) {
        super(context);
        this.s = new int[]{R.drawable.iv_ct_01, R.drawable.iv_ct_02, R.drawable.iv_ct_03, R.drawable.iv_ct_04, R.drawable.iv_ct_05};
        this.v = new Random();
        this.u = context;
        this.w = iOneClickListener;
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getImplLayoutId() {
        return R.layout.layout_huakuaiwindow;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getMaxHeight() {
        return super.getMaxHeight();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected int getMaxWidth() {
        return super.getMaxWidth();
    }

    @Override // com.lxj.xpopup.core.CenterPopupView, com.lxj.xpopup.core.BasePopupView
    protected com.lxj.xpopup.c.b getPopupAnimator() {
        return super.getPopupAnimator();
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupHeight() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected int getPopupWidth() {
        return 0;
    }

    @Override // com.lxj.xpopup.core.BasePopupView
    protected void n() {
        super.n();
        this.t = (Captcha) findViewById(R.id.captCha);
        Captcha captcha = this.t;
        int[] iArr = this.s;
        captcha.setBitmap(iArr[this.v.nextInt(iArr.length)]);
        this.t.setMaxFailedCount(Integer.MAX_VALUE);
        this.t.setCaptchaListener(new a());
        findViewById(R.id.iv_ct_close).setOnClickListener(new View.OnClickListener() { // from class: ui.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20485a.b(view);
            }
        });
    }

    public /* synthetic */ void b(View view) {
        b();
    }

    class a implements Captcha.f {
        a() {
        }

        @Override // com.luozm.captcha.Captcha.f
        public String a() {
            return "验证失败,帐号已封锁";
        }

        @Override // com.luozm.captcha.Captcha.f
        public String a(long j2) {
            if (HuaKuaiWindow.this.w != null) {
                HuaKuaiWindow.this.w.clickOKBtn();
            }
            HuaKuaiWindow.this.b();
            return "验证通过,耗时" + j2 + "毫秒";
        }

        @Override // com.luozm.captcha.Captcha.f
        public String a(int i2) {
            if (i2 != -100) {
                w1.a("验证失败,请重新验证");
            }
            Captcha captcha = HuaKuaiWindow.this.t;
            HuaKuaiWindow huaKuaiWindow = HuaKuaiWindow.this;
            captcha.setBitmap(huaKuaiWindow.s[huaKuaiWindow.v.nextInt(HuaKuaiWindow.this.s.length)]);
            return "验证失败,请重新验证";
        }
    }
}
