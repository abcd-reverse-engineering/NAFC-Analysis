package ui.view;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import com.hicorenational.antifraud.R;

/* compiled from: ProgressDialogBar.java */
/* loaded from: classes2.dex */
public class s extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public static s f20644a;

    public s(Context context) {
        super(context);
    }

    public static s a(Context context) {
        f20644a = new s(context, R.style.CustomProgressDialog);
        f20644a.setContentView(R.layout.progress_layout);
        return f20644a;
    }

    public s b(String str) {
        return f20644a;
    }

    public s(Context context, int i2) {
        super(context, i2);
    }

    public void a(String str) {
        TextView textView = (TextView) f20644a.findViewById(R.id.text_progress);
        if (textView != null) {
            textView.setText(str);
        }
    }
}
