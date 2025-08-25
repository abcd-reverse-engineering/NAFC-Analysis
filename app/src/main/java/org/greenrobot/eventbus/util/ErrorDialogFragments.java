package org.greenrobot.eventbus.util;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class ErrorDialogFragments {

    /* renamed from: a, reason: collision with root package name */
    public static int f17457a;

    /* renamed from: b, reason: collision with root package name */
    public static Class<?> f17458b;

    @TargetApi(11)
    public static class Honeycomb extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) throws IllegalAccessException, InstantiationException {
            ErrorDialogFragments.a(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static class Support extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) throws IllegalAccessException, InstantiationException {
            ErrorDialogFragments.a(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return ErrorDialogFragments.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(ErrorDialogManager.f17462d));
        builder.setMessage(bundle.getString(ErrorDialogManager.f17463e));
        int i2 = f17457a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(R.string.ok, onClickListener);
        return builder.create();
    }

    public static void a(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) throws IllegalAccessException, InstantiationException {
        Class<?> cls = f17458b;
        if (cls != null) {
            try {
                ErrorDialogManager.f17459a.f17494a.b().c(cls.newInstance());
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        }
        if (!bundle.getBoolean(ErrorDialogManager.f17464f, false) || activity == null) {
            return;
        }
        activity.finish();
    }
}
