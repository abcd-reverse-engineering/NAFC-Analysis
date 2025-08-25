package com.bumptech.glide.load.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: GlideException.java */
/* loaded from: classes.dex */
public final class q extends Exception {

    /* renamed from: a, reason: collision with root package name */
    private static final StackTraceElement[] f4639a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private com.bumptech.glide.load.a dataSource;
    private String detailMessage;

    @Nullable
    private Exception exception;
    private com.bumptech.glide.load.g key;

    public q(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void a(Throwable th, List<Throwable> list) {
        if (!(th instanceof q)) {
            list.add(th);
            return;
        }
        Iterator<Throwable> it = ((q) th).getCauses().iterator();
        while (it.hasNext()) {
            a(it.next(), list);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof q) {
                ((q) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        sb.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb.append(this.key != null ? ", " + this.key : "");
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (Throwable th : rootCauses) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            sb.toString();
            rootCauses.get(i2);
            i2 = i3;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    void setLoggingDetails(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.a aVar) {
        setLoggingDetails(gVar, aVar, null);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }

    public q(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        a(printStream);
    }

    void setLoggingDetails(com.bumptech.glide.load.g gVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.key = gVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    public q(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f4639a);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        a(printWriter);
    }

    /* compiled from: GlideException.java */
    private static final class a implements Appendable {

        /* renamed from: c, reason: collision with root package name */
        private static final String f4640c = "";

        /* renamed from: d, reason: collision with root package name */
        private static final String f4641d = "  ";

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f4642a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f4643b = true;

        a(Appendable appendable) {
            this.f4642a = appendable;
        }

        @NonNull
        private CharSequence a(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c2) throws IOException {
            if (this.f4643b) {
                this.f4643b = false;
                this.f4642a.append(f4641d);
            }
            this.f4643b = c2 == '\n';
            this.f4642a.append(c2);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.f4643b) {
                this.f4643b = false;
                this.f4642a.append(f4641d);
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i3 - 1) == '\n') {
                z = true;
            }
            this.f4643b = z;
            this.f4642a.append(charSequenceA, i2, i3);
            return this;
        }
    }

    private void a(Appendable appendable) throws IOException {
        a(this, appendable);
        a(getCauses(), new a(appendable));
    }

    private static void a(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
