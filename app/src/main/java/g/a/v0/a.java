package g.a.v0;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* compiled from: CompositeException.java */
/* loaded from: classes2.dex */
public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* compiled from: CompositeException.java */
    /* renamed from: g.a.v0.a$a, reason: collision with other inner class name */
    static final class C0179a extends RuntimeException {
        static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        C0179a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return MESSAGE;
        }
    }

    /* compiled from: CompositeException.java */
    static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    /* compiled from: CompositeException.java */
    static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintStream f13877a;

        c(PrintStream printStream) {
            this.f13877a = printStream;
        }

        @Override // g.a.v0.a.b
        void a(Object obj) {
            this.f13877a.println(obj);
        }
    }

    /* compiled from: CompositeException.java */
    static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f13878a;

        d(PrintWriter printWriter) {
            this.f13878a = printWriter;
        }

        @Override // g.a.v0.a.b
        void a(Object obj) {
            this.f13878a.println(obj);
        }
    }

    public a(@g.a.t0.f Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i2 = 1;
        for (Throwable th : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            a(sb, th, "\t");
            i2++;
        }
        bVar.a(sb.toString());
    }

    private Throwable b(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || this.cause == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    @Override // java.lang.Throwable
    @g.a.t0.f
    public synchronized Throwable getCause() {
        if (this.cause == null) {
            C0179a c0179a = new C0179a();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it = this.exceptions.iterator();
            Throwable thB = c0179a;
            while (it.hasNext()) {
                Throwable next = it.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable th : a(next)) {
                        if (hashSet.contains(th)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(th);
                        }
                    }
                    try {
                        thB.initCause(next);
                    } catch (Throwable unused) {
                    }
                    thB = b(thB);
                }
            }
            this.cause = c0179a;
        }
        return this.cause;
    }

    @g.a.t0.f
    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    @g.a.t0.f
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.exceptions.size();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(new d(printWriter));
    }

    public a(@g.a.t0.f Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            this.message = this.exceptions.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private List<Throwable> a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }
}
