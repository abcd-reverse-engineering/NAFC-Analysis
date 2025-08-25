package ui.view;

import android.text.SpannableStringBuilder;

/* compiled from: SpannableStringBuilderAllVer.java */
/* loaded from: classes2.dex */
public class u extends SpannableStringBuilder {
    public u() {
        super("");
    }

    public u(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    public u(CharSequence charSequence, int i2, int i3) {
        super(charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public u append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        return (u) replace(length, length, charSequence, 0, charSequence.length());
    }

    @Override // android.text.SpannableStringBuilder
    public u append(CharSequence charSequence, Object obj, int i2) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i2);
        return this;
    }
}
