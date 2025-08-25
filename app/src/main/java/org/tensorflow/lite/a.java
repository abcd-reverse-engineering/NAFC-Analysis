package org.tensorflow.lite;

/* compiled from: DataType.java */
/* loaded from: classes2.dex */
public enum a {
    FLOAT32(1),
    INT32(2),
    UINT8(3),
    INT64(4),
    STRING(5);


    /* renamed from: a, reason: collision with root package name */
    private static final a[] f17516a = values();
    private final int value;

    /* compiled from: DataType.java */
    /* renamed from: org.tensorflow.lite.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0279a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17518a = new int[a.values().length];

        static {
            try {
                f17518a[a.FLOAT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17518a[a.INT32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17518a[a.UINT8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17518a[a.INT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17518a[a.STRING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    a(int i2) {
        this.value = i2;
    }

    static a fromC(int i2) {
        for (a aVar : f17516a) {
            if (aVar.value == i2) {
                return aVar;
            }
        }
        throw new IllegalArgumentException("DataType error: DataType " + i2 + " is not recognized in Java (version " + TensorFlowLite.runtimeVersion() + ")");
    }

    public int byteSize() {
        int i2 = C0279a.f17518a[ordinal()];
        if (i2 == 1 || i2 == 2) {
            return 4;
        }
        if (i2 == 3) {
            return 1;
        }
        if (i2 == 4) {
            return 8;
        }
        if (i2 == 5) {
            return -1;
        }
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }

    int c() {
        return this.value;
    }

    String toStringName() {
        int i2 = C0279a.f17518a[ordinal()];
        if (i2 == 1) {
            return "float";
        }
        if (i2 == 2) {
            return "int";
        }
        if (i2 == 3) {
            return "byte";
        }
        if (i2 == 4) {
            return "long";
        }
        if (i2 == 5) {
            return "string";
        }
        throw new IllegalArgumentException("DataType error: DataType " + this + " is not supported yet");
    }
}
