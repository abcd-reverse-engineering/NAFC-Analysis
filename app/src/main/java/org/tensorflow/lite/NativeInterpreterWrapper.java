package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.c;

/* loaded from: classes2.dex */
final class NativeInterpreterWrapper implements AutoCloseable {

    /* renamed from: l, reason: collision with root package name */
    private static final int f17499l = 512;

    /* renamed from: a, reason: collision with root package name */
    private long f17500a;

    /* renamed from: b, reason: collision with root package name */
    private long f17501b;

    /* renamed from: c, reason: collision with root package name */
    private long f17502c;

    /* renamed from: d, reason: collision with root package name */
    private long f17503d;

    /* renamed from: e, reason: collision with root package name */
    private ByteBuffer f17504e;

    /* renamed from: f, reason: collision with root package name */
    private Map<String, Integer> f17505f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Integer> f17506g;

    /* renamed from: h, reason: collision with root package name */
    private Tensor[] f17507h;

    /* renamed from: i, reason: collision with root package name */
    private Tensor[] f17508i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f17509j;

    /* renamed from: k, reason: collision with root package name */
    private final List<b> f17510k;

    static {
        TensorFlowLite.a();
    }

    NativeInterpreterWrapper(String str) {
        this(str, (c.a) null);
    }

    private void a(long j2, long j3, c.a aVar) {
        if (aVar == null) {
            aVar = new c.a();
        }
        this.f17500a = j2;
        this.f17502c = j3;
        this.f17501b = createInterpreter(j3, j2, aVar.f17520a);
        this.f17507h = new Tensor[getInputCount(this.f17501b)];
        this.f17508i = new Tensor[getOutputCount(this.f17501b)];
        Boolean bool = aVar.f17521b;
        if (bool != null) {
            a(bool.booleanValue());
        }
        Boolean bool2 = aVar.f17522c;
        if (bool2 != null) {
            allowFp16PrecisionForFp32(this.f17501b, bool2.booleanValue());
        }
        Boolean bool3 = aVar.f17523d;
        if (bool3 != null) {
            allowBufferHandleOutput(this.f17501b, bool3.booleanValue());
        }
        for (b bVar : aVar.f17524e) {
            applyDelegate(this.f17501b, j2, bVar.c());
            this.f17510k.add(bVar);
        }
        allocateTensors(this.f17501b, j2);
        this.f17509j = true;
    }

    private static native long allocateTensors(long j2, long j3);

    private static native void allowBufferHandleOutput(long j2, boolean z);

    private static native void allowFp16PrecisionForFp32(long j2, boolean z);

    private static native void applyDelegate(long j2, long j3, long j4);

    private static native long createErrorReporter(int i2);

    private static native long createInterpreter(long j2, long j3, int i2);

    private static native long createModel(String str, long j2);

    private static native long createModelWithBuffer(ByteBuffer byteBuffer, long j2);

    private static native void delete(long j2, long j3, long j4);

    private static native int getInputCount(long j2);

    private static native String[] getInputNames(long j2);

    private static native int getInputTensorIndex(long j2, int i2);

    private static native int getOutputCount(long j2);

    private static native int getOutputDataType(long j2, int i2);

    private static native String[] getOutputNames(long j2);

    private static native float getOutputQuantizationScale(long j2, int i2);

    private static native int getOutputQuantizationZeroPoint(long j2, int i2);

    private static native int getOutputTensorIndex(long j2, int i2);

    private static native void numThreads(long j2, int i2);

    private static native boolean resizeInput(long j2, long j3, int i2, int[] iArr);

    private static native void run(long j2, long j3);

    private static native void useNNAPI(long j2, boolean z);

    int b(String str) {
        if (this.f17506g == null) {
            String[] outputNames = getOutputNames(this.f17501b);
            this.f17506g = new HashMap();
            if (outputNames != null) {
                for (int i2 = 0; i2 < outputNames.length; i2++) {
                    this.f17506g.put(outputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f17506g.containsKey(str)) {
            return this.f17506g.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any output. Names of outputs and their indexes are %s", str, this.f17506g.toString()));
    }

    int c(int i2) {
        return getOutputQuantizationZeroPoint(this.f17501b, i2);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        int i2 = 0;
        while (true) {
            Tensor[] tensorArr = this.f17507h;
            if (i2 >= tensorArr.length) {
                break;
            }
            if (tensorArr[i2] != null) {
                tensorArr[i2].a();
                this.f17507h[i2] = null;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            Tensor[] tensorArr2 = this.f17508i;
            if (i3 >= tensorArr2.length) {
                delete(this.f17500a, this.f17502c, this.f17501b);
                this.f17500a = 0L;
                this.f17502c = 0L;
                this.f17501b = 0L;
                this.f17504e = null;
                this.f17505f = null;
                this.f17506g = null;
                this.f17509j = false;
                this.f17510k.clear();
                return;
            }
            if (tensorArr2[i3] != null) {
                tensorArr2[i3].a();
                this.f17508i[i3] = null;
            }
            i3++;
        }
    }

    Long d() {
        long j2 = this.f17503d;
        if (j2 < 0) {
            return null;
        }
        return Long.valueOf(j2);
    }

    void e(int i2) {
        numThreads(this.f17501b, i2);
    }

    NativeInterpreterWrapper(String str, c.a aVar) {
        this.f17503d = -1L;
        this.f17509j = false;
        this.f17510k = new ArrayList();
        long jCreateErrorReporter = createErrorReporter(512);
        a(jCreateErrorReporter, createModel(str, jCreateErrorReporter), aVar);
    }

    int c() {
        return this.f17507h.length;
    }

    Tensor d(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f17508i;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f17501b;
                Tensor tensorA = Tensor.a(j2, getOutputTensorIndex(j2, i2));
                tensorArr[i2] = tensorA;
                return tensorA;
            }
        }
        throw new IllegalArgumentException("Invalid output Tensor index: " + i2);
    }

    int e() {
        return this.f17508i.length;
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer) {
        this(byteBuffer, (c.a) null);
    }

    NativeInterpreterWrapper(ByteBuffer byteBuffer, c.a aVar) {
        this.f17503d = -1L;
        this.f17509j = false;
        this.f17510k = new ArrayList();
        if (byteBuffer != null && ((byteBuffer instanceof MappedByteBuffer) || (byteBuffer.isDirect() && byteBuffer.order() == ByteOrder.nativeOrder()))) {
            this.f17504e = byteBuffer;
            long jCreateErrorReporter = createErrorReporter(512);
            a(jCreateErrorReporter, createModelWithBuffer(this.f17504e, jCreateErrorReporter), aVar);
            return;
        }
        throw new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
    }

    float b(int i2) {
        return getOutputQuantizationScale(this.f17501b, i2);
    }

    void a(Object[] objArr, Map<Integer, Object> map) {
        this.f17503d = -1L;
        if (objArr != null && objArr.length != 0) {
            if (map != null && !map.isEmpty()) {
                int i2 = 0;
                for (int i3 = 0; i3 < objArr.length; i3++) {
                    int[] iArrB = a(i3).b(objArr[i3]);
                    if (iArrB != null) {
                        a(i3, iArrB);
                    }
                }
                boolean z = !this.f17509j;
                if (z) {
                    allocateTensors(this.f17501b, this.f17500a);
                    this.f17509j = true;
                }
                for (int i4 = 0; i4 < objArr.length; i4++) {
                    a(i4).c(objArr[i4]);
                }
                long jNanoTime = System.nanoTime();
                run(this.f17501b, this.f17500a);
                long jNanoTime2 = System.nanoTime() - jNanoTime;
                if (z) {
                    while (true) {
                        Tensor[] tensorArr = this.f17508i;
                        if (i2 >= tensorArr.length) {
                            break;
                        }
                        if (tensorArr[i2] != null) {
                            tensorArr[i2].g();
                        }
                        i2++;
                    }
                }
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    d(entry.getKey().intValue()).a(entry.getValue());
                }
                this.f17503d = jNanoTime2;
                return;
            }
            throw new IllegalArgumentException("Input error: Outputs should not be null or empty.");
        }
        throw new IllegalArgumentException("Input error: Inputs should not be null or empty.");
    }

    void a(int i2, int[] iArr) {
        if (resizeInput(this.f17501b, this.f17500a, i2, iArr)) {
            this.f17509j = false;
            Tensor[] tensorArr = this.f17507h;
            if (tensorArr[i2] != null) {
                tensorArr[i2].g();
            }
        }
    }

    void a(boolean z) {
        useNNAPI(this.f17501b, z);
    }

    void a(b bVar) {
        applyDelegate(this.f17501b, this.f17500a, bVar.c());
        this.f17510k.add(bVar);
    }

    int a(String str) {
        if (this.f17505f == null) {
            String[] inputNames = getInputNames(this.f17501b);
            this.f17505f = new HashMap();
            if (inputNames != null) {
                for (int i2 = 0; i2 < inputNames.length; i2++) {
                    this.f17505f.put(inputNames[i2], Integer.valueOf(i2));
                }
            }
        }
        if (this.f17505f.containsKey(str)) {
            return this.f17505f.get(str).intValue();
        }
        throw new IllegalArgumentException(String.format("Input error: '%s' is not a valid name for any input. Names of inputs and their indexes are %s", str, this.f17505f.toString()));
    }

    Tensor a(int i2) {
        if (i2 >= 0) {
            Tensor[] tensorArr = this.f17507h;
            if (i2 < tensorArr.length) {
                Tensor tensor = tensorArr[i2];
                if (tensor != null) {
                    return tensor;
                }
                long j2 = this.f17501b;
                Tensor tensorA = Tensor.a(j2, getInputTensorIndex(j2, i2));
                tensorArr[i2] = tensorA;
                return tensorA;
            }
        }
        throw new IllegalArgumentException("Invalid input Tensor index: " + i2);
    }
}
