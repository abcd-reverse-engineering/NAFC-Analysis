package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* loaded from: classes2.dex */
public class dc implements LoggerInterface {

    /* renamed from: a, reason: collision with root package name */
    private LoggerInterface f12634a;

    /* renamed from: b, reason: collision with root package name */
    private LoggerInterface f12635b;

    public dc(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f12634a = null;
        this.f12635b = null;
        this.f12634a = loggerInterface;
        this.f12635b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f12634a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f12635b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f12634a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f12635b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }
}
