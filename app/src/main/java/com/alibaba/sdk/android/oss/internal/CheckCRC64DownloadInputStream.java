package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public class CheckCRC64DownloadInputStream extends CheckedInputStream {
    private long mClientCRC64;
    private String mRequestId;
    private long mServerCRC64;
    private long mTotalBytesRead;
    private long mTotalLength;

    public CheckCRC64DownloadInputStream(InputStream inputStream, Checksum checksum, long j2, long j3, String str) {
        super(inputStream, checksum);
        this.mTotalLength = j2;
        this.mServerCRC64 = j3;
        this.mRequestId = str;
    }

    private void checkCRC64(int i2) throws IOException {
        this.mTotalBytesRead += i2;
        if (this.mTotalBytesRead >= this.mTotalLength) {
            this.mClientCRC64 = getChecksum().getValue();
            OSSUtils.checkChecksum(Long.valueOf(this.mClientCRC64), Long.valueOf(this.mServerCRC64), this.mRequestId);
        }
    }

    public long getClientCRC64() {
        return this.mClientCRC64;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2 = super.read();
        checkCRC64(i2);
        return i2;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = super.read(bArr, i2, i3);
        checkCRC64(i4);
        return i4;
    }
}
