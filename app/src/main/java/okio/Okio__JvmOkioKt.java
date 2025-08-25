package okio;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import h.q2.f;
import h.q2.t.i0;
import h.y;
import h.z2.c0;
import i.c.a.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: JvmOkio.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\n\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u000b\u001a%\u0010\b\u001a\u00020\u0006*\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0007\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u000b\u001a%\u0010\u0011\u001a\u00020\u0012*\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u0015"}, d2 = {"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "sink", RequestParameters.SUBRESOURCE_APPEND, "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, k = 5, mv = {1, 1, 16}, xs = "okio/Okio")
/* loaded from: classes2.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    @d
    public static final Sink appendingSink(@d File file) throws FileNotFoundException {
        i0.f(file, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final boolean isAndroidGetsocknameError(@d AssertionError assertionError) {
        i0.f(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? c0.c((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @f
    @d
    public static final Sink sink(@d File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    @d
    public static final Sink sink(@d OutputStream outputStream) {
        i0.f(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @d
    public static final Source source(@d InputStream inputStream) {
        i0.f(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @d
    public static final Sink sink(@d Socket socket) throws IOException {
        i0.f(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        i0.a((Object) outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @d
    public static final Source source(@d Socket socket) throws IOException {
        i0.f(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        i0.a((Object) inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @f
    @d
    public static final Sink sink(@d File file, boolean z) throws FileNotFoundException {
        i0.f(file, "$this$sink");
        return Okio.sink(new FileOutputStream(file, z));
    }

    @d
    public static final Source source(@d File file) throws FileNotFoundException {
        i0.f(file, "$this$source");
        return Okio.source(new FileInputStream(file));
    }

    @d
    @IgnoreJRERequirement
    public static final Sink sink(@d Path path, @d OpenOption... openOptionArr) throws IOException {
        i0.f(path, "$this$sink");
        i0.f(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        i0.a((Object) outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    @d
    @IgnoreJRERequirement
    public static final Source source(@d Path path, @d OpenOption... openOptionArr) throws IOException {
        i0.f(path, "$this$source");
        i0.f(openOptionArr, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        i0.a((Object) inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(inputStreamNewInputStream);
    }
}
