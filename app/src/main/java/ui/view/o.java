package ui.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import interfaces.ITextCallBackListener;

/* compiled from: CustomClickableSpan.java */
/* loaded from: classes2.dex */
public class o extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private String f20608a;

    /* renamed from: b, reason: collision with root package name */
    private ITextCallBackListener f20609b;

    public o(String str, ITextCallBackListener iTextCallBackListener) {
        this.f20608a = str;
        this.f20609b = iTextCallBackListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (view instanceof TextView) {
            ((TextView) view).setHighlightColor(0);
            this.f20609b.onResult(this.f20608a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }
}
