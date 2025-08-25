package anet.channel.bytes;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* renamed from: a, reason: collision with root package name */
    private final TreeSet<ByteArray> f1687a = new TreeSet<>();

    /* renamed from: b, reason: collision with root package name */
    private final ByteArray f1688b = ByteArray.create(0);

    /* renamed from: c, reason: collision with root package name */
    private final Random f1689c = new Random();

    /* renamed from: d, reason: collision with root package name */
    private long f1690d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: anet.channel.bytes.a$a, reason: collision with other inner class name */
    public static class C0012a {

        /* renamed from: a, reason: collision with root package name */
        public static a f1691a = new a();

        C0012a() {
        }
    }

    public synchronized void a(ByteArray byteArray) {
        if (byteArray != null) {
            if (byteArray.bufferLength < 524288) {
                this.f1690d += byteArray.bufferLength;
                this.f1687a.add(byteArray);
                while (this.f1690d > PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.f1690d -= (this.f1689c.nextBoolean() ? this.f1687a.pollFirst() : this.f1687a.pollLast()).bufferLength;
                }
            }
        }
    }

    public synchronized ByteArray a(int i2) {
        if (i2 >= 524288) {
            return ByteArray.create(i2);
        }
        this.f1688b.bufferLength = i2;
        ByteArray byteArrayCeiling = this.f1687a.ceiling(this.f1688b);
        if (byteArrayCeiling == null) {
            byteArrayCeiling = ByteArray.create(i2);
        } else {
            Arrays.fill(byteArrayCeiling.buffer, (byte) 0);
            byteArrayCeiling.dataLength = 0;
            this.f1687a.remove(byteArrayCeiling);
            this.f1690d -= byteArrayCeiling.bufferLength;
        }
        return byteArrayCeiling;
    }

    public ByteArray a(byte[] bArr, int i2) {
        ByteArray byteArrayA = a(i2);
        System.arraycopy(bArr, 0, byteArrayA.buffer, 0, i2);
        byteArrayA.dataLength = i2;
        return byteArrayA;
    }
}
