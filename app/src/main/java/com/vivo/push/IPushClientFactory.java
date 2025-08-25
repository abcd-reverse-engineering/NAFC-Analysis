package com.vivo.push;

import android.content.Intent;

/* loaded from: classes2.dex */
public interface IPushClientFactory {
    com.vivo.push.f.aa createReceiveTask(v vVar);

    v createReceiverCommand(Intent intent);

    s createTask(v vVar);
}
