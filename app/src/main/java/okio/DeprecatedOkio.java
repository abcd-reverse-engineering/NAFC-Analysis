package okio;

import h.c;
import h.d;
import h.o0;
import h.q2.t.i0;
import h.y;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;

/* compiled from: -DeprecatedOkio.kt */
@c(message = "changed in Okio 2.x")
@y(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 1, mv = {1, 1, 16})
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes2.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @i.c.a.d
    public final Sink appendingSink(@i.c.a.d File file) {
        i0.f(file, "file");
        return Okio.appendingSink(file);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @i.c.a.d
    public final Sink blackhole() {
        return Okio.blackhole();
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @i.c.a.d
    public final BufferedSink buffer(@i.c.a.d Sink sink) {
        i0.f(sink, "sink");
        return Okio.buffer(sink);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "file.sink()", imports = {"okio.sink"}))
    @i.c.a.d
    public final Sink sink(@i.c.a.d File file) {
        i0.f(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "file.source()", imports = {"okio.source"}))
    @i.c.a.d
    public final Source source(@i.c.a.d File file) {
        i0.f(file, "file");
        return Okio.source(file);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "source.buffer()", imports = {"okio.buffer"}))
    @i.c.a.d
    public final BufferedSource buffer(@i.c.a.d Source source) {
        i0.f(source, "source");
        return Okio.buffer(source);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @i.c.a.d
    public final Sink sink(@i.c.a.d OutputStream outputStream) {
        i0.f(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "inputStream.source()", imports = {"okio.source"}))
    @i.c.a.d
    public final Source source(@i.c.a.d InputStream inputStream) {
        i0.f(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @i.c.a.d
    public final Sink sink(@i.c.a.d Path path, @i.c.a.d OpenOption... openOptionArr) {
        i0.f(path, "path");
        i0.f(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "path.source(*options)", imports = {"okio.source"}))
    @i.c.a.d
    public final Source source(@i.c.a.d Path path, @i.c.a.d OpenOption... openOptionArr) {
        i0.f(path, "path");
        i0.f(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "socket.sink()", imports = {"okio.sink"}))
    @i.c.a.d
    public final Sink sink(@i.c.a.d Socket socket) {
        i0.f(socket, "socket");
        return Okio.sink(socket);
    }

    @c(level = d.ERROR, message = "moved to extension function", replaceWith = @o0(expression = "socket.source()", imports = {"okio.source"}))
    @i.c.a.d
    public final Source source(@i.c.a.d Socket socket) {
        i0.f(socket, "socket");
        return Okio.source(socket);
    }
}
