package m.b;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.b.c.e;
import c.b.c.k;
import c.b.c.n;
import c.b.c.q;
import c.b.c.r;
import c.b.c.z.j;
import com.hicorenational.antifraud.R;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import zxing.android.CaptureActivity;

/* compiled from: DecodeHandler.java */
/* loaded from: classes2.dex */
public final class b extends Handler {

    /* renamed from: d, reason: collision with root package name */
    private static final String f17293d = b.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private final CaptureActivity f17294a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17296c = true;

    /* renamed from: b, reason: collision with root package name */
    private final k f17295b = new k();

    b(CaptureActivity captureActivity, Map<e, Object> map) {
        this.f17295b.a((Map<e, ?>) map);
        this.f17294a = captureActivity;
    }

    private void a(byte[] bArr, int i2, int i3) {
        r rVarB;
        long jCurrentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        n nVarA = this.f17294a.b().a(bArr2, i3, i2);
        if (nVarA != null) {
            try {
                rVarB = this.f17295b.b(new c.b.c.c(new j(nVarA)));
            } catch (q unused) {
            } finally {
                this.f17295b.reset();
            }
        } else {
            rVarB = null;
        }
        Handler handlerC = this.f17294a.c();
        if (rVarB == null) {
            if (handlerC != null) {
                Message.obtain(handlerC, R.id.decode_failed).sendToTarget();
                return;
            }
            return;
        }
        String str = "Found barcode in " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms";
        if (handlerC != null) {
            Message messageObtain = Message.obtain(handlerC, R.id.decode_succeeded, rVarB);
            Bundle bundle = new Bundle();
            a(nVarA, bundle);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f17296c) {
            int i2 = message.what;
            if (i2 == R.id.decode) {
                a((byte[]) message.obj, message.arg1, message.arg2);
            } else {
                if (i2 != R.id.quit) {
                    return;
                }
                this.f17296c = false;
                Looper.myLooper().quit();
            }
        }
    }

    private static void a(n nVar, Bundle bundle) {
        int[] iArrK = nVar.k();
        int iJ = nVar.j();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrK, 0, iJ, iJ, nVar.i(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray(c.f17297e, byteArrayOutputStream.toByteArray());
        bundle.putFloat(c.f17298f, iJ / nVar.c());
    }
}
