package okhttp3.internal.http2;

import h.f1;
import h.t1;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation;
    final Hpack.Reader hpackReader;
    private final BufferedSource source;

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            int i2 = this.streamId;
            int medium = Http2Reader.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            byte b2 = (byte) (this.source.readByte() & f1.f16099c);
            this.flags = (byte) (this.source.readByte() & f1.f16099c);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, b2, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (b2 != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(b2));
            }
            if (this.streamId != i2) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            while (true) {
                int i2 = this.left;
                if (i2 != 0) {
                    long j3 = this.source.read(buffer, Math.min(j2, i2));
                    if (j3 == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - j3);
                    return j3;
                }
                this.source.skip(this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, ByteString byteString, String str2, int i3, long j2);

        void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i2, int i3, List<Header> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i2, long j2);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
        this.continuation = new ContinuationSource(this.source);
        this.hpackReader = new Hpack.Reader(4096, this.continuation);
    }

    static int lengthWithoutPadding(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }

    private void readData(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & f1.f16099c) : (short) 0;
        handler.data(z, i3, this.source, lengthWithoutPadding(i2, b2, s));
        this.source.skip(s);
    }

    private void readGoAway(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
        }
        if (i3 != 0) {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        int i6 = i2 - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i5);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i5));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i6 > 0) {
            byteString = this.source.readByteString(i6);
        }
        handler.goAway(i4, errorCodeFromHttp2, byteString);
    }

    private List<Header> readHeaderBlock(int i2, short s, byte b2, int i3) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i2;
        continuationSource.length = i2;
        continuationSource.padding = s;
        continuationSource.flags = b2;
        continuationSource.streamId = i3;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & f1.f16099c) : (short) 0;
        if ((b2 & 32) != 0) {
            readPriority(handler, i3);
            i2 -= 5;
        }
        handler.headers(z, i3, -1, readHeaderBlock(lengthWithoutPadding(i2, b2, s), s, b2, i3));
    }

    static int readMedium(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & f1.f16099c) | ((bufferedSource.readByte() & f1.f16099c) << 16) | ((bufferedSource.readByte() & f1.f16099c) << 8);
    }

    private void readPing(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i2));
        }
        if (i3 != 0) {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
        handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
    }

    private void readPriority(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
        }
        if (i3 == 0) {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        readPriority(handler, i3);
    }

    private void readPushPromise(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b2 & 8) != 0 ? (short) (this.source.readByte() & f1.f16099c) : (short) 0;
        handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i2 - 4, b2, s), s, b2, i3));
    }

    private void readRstStream(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
        }
        if (i3 == 0) {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i4 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
        if (errorCodeFromHttp2 == null) {
            throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i4));
        }
        handler.rstStream(i3, errorCodeFromHttp2);
    }

    private void readSettings(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i2 != 0) {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            handler.ackSettings();
            return;
        }
        if (i2 % 6 != 0) {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
        }
        Settings settings = new Settings();
        for (int i4 = 0; i4 < i2; i4 += 6) {
            int i5 = this.source.readShort() & t1.f16480c;
            int i6 = this.source.readInt();
            switch (i5) {
                case 2:
                    if (i6 != 0 && i6 != 1) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                case 3:
                    i5 = 4;
                    break;
                case 4:
                    i5 = 7;
                    if (i6 < 0) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                case 5:
                    if (i6 < 16384 || i6 > 16777215) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i6));
                    }
                    break;
                    break;
            }
            settings.set(i5, i6);
        }
        handler.settings(false, settings);
    }

    private void readWindowUpdate(Handler handler, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
        }
        long j2 = this.source.readInt() & 2147483647L;
        if (j2 == 0) {
            throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(j2));
        }
        handler.windowUpdate(i3, j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        try {
            this.source.require(9L);
            int medium = readMedium(this.source);
            if (medium < 0 || medium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(medium));
            }
            byte b2 = (byte) (this.source.readByte() & f1.f16099c);
            if (z && b2 != 4) {
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(b2));
            }
            byte b3 = (byte) (this.source.readByte() & f1.f16099c);
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Http2.frameLog(true, i2, medium, b2, b3));
            }
            switch (b2) {
                case 0:
                    readData(handler, medium, b3, i2);
                    return true;
                case 1:
                    readHeaders(handler, medium, b3, i2);
                    return true;
                case 2:
                    readPriority(handler, medium, b3, i2);
                    return true;
                case 3:
                    readRstStream(handler, medium, b3, i2);
                    return true;
                case 4:
                    readSettings(handler, medium, b3, i2);
                    return true;
                case 5:
                    readPushPromise(handler, medium, b3, i2);
                    return true;
                case 6:
                    readPing(handler, medium, b3, i2);
                    return true;
                case 7:
                    readGoAway(handler, medium, b3, i2);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, b3, i2);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format("<< CONNECTION %s", byteString.hex()));
        }
        if (!Http2.CONNECTION_PREFACE.equals(byteString)) {
            throw Http2.ioException("Expected a connection header but was %s", byteString.utf8());
        }
    }

    private void readPriority(Handler handler, int i2) throws IOException {
        int i3 = this.source.readInt();
        handler.priority(i2, i3 & Integer.MAX_VALUE, (this.source.readByte() & f1.f16099c) + 1, (Integer.MIN_VALUE & i3) != 0);
    }
}
