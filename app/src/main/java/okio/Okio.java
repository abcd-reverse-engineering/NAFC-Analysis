package okio;

import h.q2.e;
import h.q2.f;
import h.y;
import i.c.a.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@y(bv = {1, 0, 3}, d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Okio {
    @d
    public static final Sink appendingSink(@d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @e(name = "blackhole")
    @d
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @d
    public static final BufferedSink buffer(@d Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    public static final boolean isAndroidGetsocknameError(@d AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    @f
    @d
    public static final Sink sink(@d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @f
    @d
    public static final Sink sink(@d File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z);
    }

    @d
    public static final Source source(@d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    @d
    public static final BufferedSource buffer(@d Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @d
    public static final Sink sink(@d OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @d
    public static final Source source(@d InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @d
    public static final Sink sink(@d Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @d
    public static final Source source(@d Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    @d
    @IgnoreJRERequirement
    public static final Sink sink(@d Path path, @d OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }

    @d
    @IgnoreJRERequirement
    public static final Source source(@d Path path, @d OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }
}
