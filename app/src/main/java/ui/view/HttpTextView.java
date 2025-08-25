package ui.view;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class HttpTextView extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    private String f20313a;

    /* renamed from: b, reason: collision with root package name */
    Pattern f20314b;

    /* renamed from: c, reason: collision with root package name */
    Matcher f20315c;

    /* renamed from: d, reason: collision with root package name */
    LinkedList<String> f20316d;

    /* renamed from: e, reason: collision with root package name */
    LinkedList<b> f20317e;

    /* renamed from: f, reason: collision with root package name */
    int f20318f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20319g;

    /* renamed from: h, reason: collision with root package name */
    private String f20320h;

    class a extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        private String f20321a;

        public a(String str) {
            this.f20321a = str;
            HttpTextView.this.f20320h = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Toast.makeText(view.getContext(), this.f20321a, 0).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-11436114);
            textPaint.setUnderlineText(false);
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        public int f20323a;

        /* renamed from: b, reason: collision with root package name */
        public int f20324b;

        b() {
        }
    }

    public HttpTextView(Context context) {
        this(context, null);
    }

    public boolean getIsNeedToRegionUrl() {
        return this.f20319g;
    }

    public String getUrlText() {
        String str = this.f20320h;
        if (str == null) {
            return null;
        }
        return str;
    }

    public void setOpenRegionUrl(boolean z) {
        this.f20319g = z;
    }

    public void setUrlText(CharSequence charSequence) {
        if (!this.f20319g) {
            super.setText(charSequence);
        } else {
            super.setText(a(charSequence));
            setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public HttpTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private u a(CharSequence charSequence) {
        CharSequence charSequenceSubSequence;
        this.f20316d.clear();
        this.f20317e.clear();
        if (charSequence == null) {
            charSequence = "";
        }
        u uVar = new u(charSequence);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) uVar.getSpans(0, charSequence.length(), ClickableSpan.class);
        if (clickableSpanArr.length > 0) {
            int spanEnd = 0;
            int spanStart = 0;
            for (ClickableSpan clickableSpan : clickableSpanArr) {
                spanStart = uVar.getSpanStart(clickableSpanArr[0]);
                spanEnd = uVar.getSpanEnd(clickableSpan);
            }
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(spanEnd, charSequence.length());
            charSequenceSubSequence = charSequence.subSequence(spanStart, spanEnd);
            charSequence = charSequenceSubSequence2;
        } else {
            charSequenceSubSequence = null;
        }
        this.f20315c = this.f20314b.matcher(charSequence);
        while (this.f20315c.find()) {
            b bVar = new b();
            bVar.f20323a = this.f20315c.start();
            bVar.f20324b = this.f20315c.end();
            this.f20316d.add(this.f20315c.group());
            this.f20317e.add(bVar);
        }
        return a(charSequenceSubSequence, charSequence);
    }

    public HttpTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20313a = "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?|(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?";
        this.f20314b = Pattern.compile(this.f20313a);
        this.f20318f = 33;
        this.f20319g = true;
        this.f20316d = new LinkedList<>();
        this.f20317e = new LinkedList<>();
    }

    private u a(CharSequence charSequence, CharSequence charSequence2) {
        u uVar;
        if (charSequence != null) {
            uVar = new u(charSequence);
        } else {
            uVar = new u();
        }
        if (this.f20316d.size() > 0) {
            if (this.f20316d.size() == 1) {
                uVar.append((CharSequence) charSequence2.toString().substring(0, this.f20317e.get(0).f20323a));
                String str = this.f20316d.get(0);
                uVar.append((CharSequence) str, (Object) new a(str), this.f20318f);
                uVar.append((CharSequence) charSequence2.toString().substring(this.f20317e.get(0).f20324b));
            } else {
                for (int i2 = 0; i2 < this.f20316d.size(); i2++) {
                    if (i2 == 0) {
                        uVar.append((CharSequence) charSequence2.toString().substring(0, this.f20317e.get(0).f20323a));
                    }
                    if (i2 == this.f20316d.size() - 1) {
                        uVar.append((CharSequence) this.f20316d.get(i2), (Object) new a(this.f20316d.get(i2)), this.f20318f);
                        uVar.append((CharSequence) charSequence2.toString().substring(this.f20317e.get(i2).f20324b));
                    }
                    if (i2 != this.f20316d.size() - 1) {
                        uVar.append((CharSequence) this.f20316d.get(i2), (Object) new a(this.f20316d.get(i2)), this.f20318f);
                        uVar.append((CharSequence) charSequence2.toString().substring(this.f20317e.get(i2).f20324b, this.f20317e.get(i2 + 1).f20323a));
                    }
                }
            }
        } else {
            uVar.append(charSequence2);
        }
        return uVar;
    }
}
