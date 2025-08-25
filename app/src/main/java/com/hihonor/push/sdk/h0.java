package com.hihonor.push.sdk;

import android.os.Bundle;
import android.os.Handler;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushCallback;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.ResponseHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.z;

/* loaded from: classes.dex */
public class h0 extends IPushCallback.Stub {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6288a;

    /* renamed from: b, reason: collision with root package name */
    public final i0 f6289b;

    public h0(Object obj, i0 i0Var) {
        this.f6288a = obj;
        this.f6289b = i0Var;
    }

    @Override // com.hihonor.push.framework.aidl.IPushCallback
    public void onResult(DataBuffer dataBuffer) {
        Bundle header = dataBuffer.getHeader();
        Bundle body = dataBuffer.getBody();
        ResponseHeader responseHeader = new ResponseHeader();
        MessageCodec.parseMessageEntity(header, responseHeader);
        Object obj = this.f6288a;
        if (obj instanceof IMessageEntity) {
            MessageCodec.parseMessageEntity(body, (IMessageEntity) obj);
        }
        i0 i0Var = this.f6289b;
        ApiException apiException = new ApiException(responseHeader.getStatusCode(), responseHeader.getStatusMessage());
        Object obj2 = this.f6288a;
        z.b bVar = (z.b) i0Var;
        bVar.getClass();
        z zVar = z.f6357c;
        f1<?> f1Var = bVar.f6366a;
        zVar.getClass();
        Handler handler = zVar.f6358a;
        handler.sendMessage(handler.obtainMessage(2, f1Var));
        bVar.f6366a.b(apiException, obj2);
    }
}
