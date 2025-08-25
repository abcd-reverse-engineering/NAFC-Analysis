package util;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import interfaces.IEditAfterListener;
import java.util.regex.Pattern;

/* compiled from: EditUtil.java */
/* loaded from: classes2.dex */
public class d1 {

    /* compiled from: EditUtil.java */
    static class a implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IEditAfterListener f20794a;

        a(IEditAfterListener iEditAfterListener) {
            this.f20794a = iEditAfterListener;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f20794a.editLength(editable.toString().length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: EditUtil.java */
    static class b implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f20795a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f20796b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IEditAfterListener f20797c;

        b(int i2, EditText editText, IEditAfterListener iEditAfterListener) {
            this.f20795a = i2;
            this.f20796b = editText;
            this.f20797c = iEditAfterListener;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IEditAfterListener iEditAfterListener = this.f20797c;
            if (iEditAfterListener != null) {
                iEditAfterListener.editLength(editable.toString().length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            int iIndexOf;
            if (this.f20795a <= 0 || (iIndexOf = charSequence.toString().indexOf(".")) <= -1) {
                return;
            }
            if (charSequence.toString().indexOf(".") == 0) {
                String str = "0" + charSequence.toString();
                this.f20796b.setText(str);
                this.f20796b.setSelection(str.length());
            }
            int i5 = iIndexOf + 1;
            if (charSequence.length() - i5 > this.f20795a) {
                String string = charSequence.toString().subSequence(0, i5 + this.f20795a).toString();
                this.f20796b.setText(string);
                this.f20796b.setSelection(Math.min(i2 + 1, string.length()));
            }
        }
    }

    /* compiled from: EditUtil.java */
    static class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (1 == motionEvent.getAction()) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    /* compiled from: EditUtil.java */
    static class d implements InputFilter {
        d() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuffer stringBuffer = new StringBuffer();
            int i6 = i2;
            while (i6 < i3) {
                char cCharAt = charSequence.charAt(i6);
                if (d1.a(cCharAt)) {
                    w1.a("不能含有第三方表情");
                    i6++;
                } else {
                    stringBuffer.append(cCharAt);
                }
                i6++;
            }
            if (!(charSequence instanceof Spanned)) {
                return stringBuffer;
            }
            SpannableString spannableString = new SpannableString(stringBuffer);
            TextUtils.copySpansFrom((Spanned) charSequence, i2, i3, null, spannableString, 0);
            return spannableString;
        }
    }

    /* compiled from: EditUtil.java */
    static class e implements InputFilter {
        e() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            StringBuffer stringBuffer = new StringBuffer();
            int i6 = i2;
            while (i6 < i3) {
                char cCharAt = charSequence.charAt(i6);
                if (d1.b(cCharAt)) {
                    w1.a("不能含有特殊字符");
                    i6++;
                } else {
                    stringBuffer.append(cCharAt);
                }
                i6++;
            }
            if (!(charSequence instanceof Spanned)) {
                return stringBuffer;
            }
            SpannableString spannableString = new SpannableString(stringBuffer);
            TextUtils.copySpansFrom((Spanned) charSequence, i2, i3, null, spannableString, 0);
            return spannableString;
        }
    }

    /* compiled from: EditUtil.java */
    static class f extends NumberKeyListener {
        f() {
        }

        @Override // android.text.method.NumberKeyListener
        protected char[] getAcceptedChars() {
            return "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM`~!@#$%^&*()_\\-+=<>?:\"{}|,./;'\\\\\\[\\]".toCharArray();
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 128;
        }
    }

    /* compiled from: EditUtil.java */
    static class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            if (motionEvent.getAction() == 1) {
                view.getParent().requestDisallowInterceptTouchEvent(false);
            }
            return false;
        }
    }

    public static void a(EditText editText, IEditAfterListener iEditAfterListener) {
        editText.addTextChangedListener(new a(iEditAfterListener));
    }

    public static boolean a(char c2) {
        if (c2 == 0 || c2 == '\t' || c2 == '\n' || c2 == '\r') {
            return false;
        }
        if (c2 >= ' ' && c2 <= 55295) {
            return false;
        }
        if (c2 < 57344 || c2 > 65533) {
            return c2 < 0 || c2 > 65535;
        }
        return false;
    }

    public static void b(EditText editText, int i2) {
        try {
            if (i2 > 0) {
                editText.setFilters(new InputFilter[]{a(), b(), new InputFilter.LengthFilter(i2)});
            } else {
                editText.setFilters(new InputFilter[]{a(), b()});
            }
        } catch (Exception unused) {
        }
    }

    public static void c(EditText editText) {
        editText.setOnTouchListener(new g());
    }

    public static void a(EditText editText, int i2, IEditAfterListener iEditAfterListener) {
        editText.addTextChangedListener(new b(i2, editText, iEditAfterListener));
    }

    public static String a(String str, int i2) {
        int length;
        String str2 = "";
        int i3 = 0;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() == 16) {
                return (str.contains(".") && str.indexOf(".") == 15) ? str.substring(0, 16) : str;
            }
            if (str.length() == 15 && !str.contains(".")) {
                return str;
            }
            int iIndexOf = str.indexOf(".");
            if (str.indexOf("0") == 0 && iIndexOf != 1) {
                str = Double.parseDouble(str) + "";
            }
            int iIndexOf2 = str.indexOf(".");
            if (iIndexOf2 > -1) {
                length = str.length() - (iIndexOf2 + 1);
            } else {
                str = str + ".";
                length = 0;
            }
            while (i3 < i2 - length) {
                str2 = str2 + "0";
                i3++;
            }
            return str + str2;
        }
        while (i3 < i2) {
            str2 = str2 + "0";
            i3++;
        }
        return "0." + str2;
    }

    public static InputFilter b() {
        return new e();
    }

    public static boolean b(char c2) {
        return Character.getType(c2) > 10;
    }

    public static void b(EditText editText) {
        try {
            editText.setKeyListener(new f());
        } catch (Exception unused) {
        }
    }

    public static void a(EditText editText) {
        editText.setOnTouchListener(new c());
    }

    public static void a(EditText editText, int i2) {
        try {
            if (i2 > 0) {
                editText.setFilters(new InputFilter[]{a(), new InputFilter.LengthFilter(i2)});
            } else {
                editText.setFilters(new InputFilter[]{a()});
            }
        } catch (Exception unused) {
        }
    }

    public static InputFilter a() {
        return new d();
    }

    public static boolean a(String str) {
        return Pattern.compile("^[0-9]*$").matcher(str).matches() || Pattern.compile("^[A-Za-z]+$").matcher(str).matches() || Pattern.compile("^[`~!@#$%^&*()_\\-+=<>?:\"{}|,./;'\\\\\\[\\]]*$").matcher(str).matches();
    }
}
