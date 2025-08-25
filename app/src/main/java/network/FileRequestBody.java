package network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

/* loaded from: classes2.dex */
public final class FileRequestBody<T> extends RequestBody {
    private BufferedSink bufferedSink;
    private RetrofitCallback<T> callback;
    private RequestBody requestBody;

    public FileRequestBody(RequestBody requestBody, RetrofitCallback<T> retrofitCallback) {
        this.requestBody = requestBody;
        this.callback = retrofitCallback;
    }

    private Sink sink(Sink sink) {
        return new ForwardingSink(sink) { // from class: network.FileRequestBody.1
            long bytesWritten = 0;
            long contentLength = 0;

            @Override // okio.ForwardingSink, okio.Sink
            public void write(Buffer buffer, long j2) throws IOException {
                super.write(buffer, j2);
                if (this.contentLength == 0) {
                    this.contentLength = FileRequestBody.this.contentLength();
                }
                this.bytesWritten += j2;
                FileRequestBody.this.callback.onLoading(this.contentLength, this.bytesWritten);
            }
        };
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (bufferedSink instanceof Buffer) {
            this.requestBody.writeTo(bufferedSink);
            return;
        }
        this.bufferedSink = Okio.buffer(sink(bufferedSink));
        this.requestBody.writeTo(this.bufferedSink);
        this.bufferedSink.flush();
    }
}
