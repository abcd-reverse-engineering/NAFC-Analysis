package okhttp3.internal.http;

import anet.channel.request.Request;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http2.ConnectionShutdownException;

/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private final boolean forWebSocket;
    private volatile StreamAllocation streamAllocation;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient, boolean z) {
        this.client = okHttpClient;
        this.forWebSocket = z;
    }

    private Address createAddress(HttpUrl httpUrl) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        String strHeader;
        HttpUrl httpUrlResolve;
        if (response == null) {
            throw new IllegalStateException();
        }
        int iCode = response.code();
        String strMethod = response.request().method();
        if (iCode == 307 || iCode == 308) {
            if (!strMethod.equals("GET") && !strMethod.equals(Request.Method.HEAD)) {
                return null;
            }
        } else {
            if (iCode == 401) {
                return this.client.authenticator().authenticate(route, response);
            }
            if (iCode == 503) {
                if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                }
                return null;
            }
            if (iCode == 407) {
                if ((route != null ? route.proxy() : this.client.proxy()).type() == Proxy.Type.HTTP) {
                    return this.client.proxyAuthenticator().authenticate(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (iCode == 408) {
                if (!this.client.retryOnConnectionFailure() || (response.request().body() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                    return response.request();
                }
                return null;
            }
            switch (iCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.client.followRedirects() || (strHeader = response.header("Location")) == null || (httpUrlResolve = response.request().url().resolve(strHeader)) == null) {
            return null;
        }
        if (!httpUrlResolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder builderNewBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(strMethod)) {
            boolean zRedirectsWithBody = HttpMethod.redirectsWithBody(strMethod);
            if (HttpMethod.redirectsToGet(strMethod)) {
                builderNewBuilder.method("GET", null);
            } else {
                builderNewBuilder.method(strMethod, zRedirectsWithBody ? response.request().body() : null);
            }
            if (!zRedirectsWithBody) {
                builderNewBuilder.removeHeader("Transfer-Encoding");
                builderNewBuilder.removeHeader("Content-Length");
                builderNewBuilder.removeHeader("Content-Type");
            }
        }
        if (!sameConnection(response, httpUrlResolve)) {
            builderNewBuilder.removeHeader("Authorization");
        }
        return builderNewBuilder.url(httpUrlResolve).build();
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private boolean recover(IOException iOException, StreamAllocation streamAllocation, boolean z, okhttp3.Request request) throws IOException {
        streamAllocation.streamFailed(iOException);
        if (this.client.retryOnConnectionFailure()) {
            return !(z && (request.body() instanceof UnrepeatableRequestBody)) && isRecoverable(iOException, z) && streamAllocation.hasMoreRoutes();
        }
        return false;
    }

    private int retryAfter(Response response, int i2) {
        String strHeader = response.header("Retry-After");
        if (strHeader == null) {
            return i2;
        }
        if (strHeader.matches("\\d+")) {
            return Integer.valueOf(strHeader).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean sameConnection(Response response, HttpUrl httpUrl) {
        HttpUrl httpUrlUrl = response.request().url();
        return httpUrlUrl.host().equals(httpUrl.host()) && httpUrlUrl.port() == httpUrl.port() && httpUrlUrl.scheme().equals(httpUrl.scheme());
    }

    public void cancel() throws IOException {
        this.canceled = true;
        StreamAllocation streamAllocation = this.streamAllocation;
        if (streamAllocation != null) {
            streamAllocation.cancel();
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response responseProceed;
        okhttp3.Request requestFollowUpRequest;
        okhttp3.Request request = chain.request();
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Call call = realInterceptorChain.call();
        EventListener eventListener = realInterceptorChain.eventListener();
        StreamAllocation streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(request.url()), call, eventListener, this.callStackTrace);
        this.streamAllocation = streamAllocation;
        Response response = null;
        int i2 = 0;
        while (!this.canceled) {
            try {
                try {
                    try {
                        responseProceed = realInterceptorChain.proceed(request, streamAllocation, null, null);
                        if (response != null) {
                            responseProceed = responseProceed.newBuilder().priorResponse(response.newBuilder().body(null).build()).build();
                        }
                        try {
                            requestFollowUpRequest = followUpRequest(responseProceed, streamAllocation.route());
                        } catch (IOException e2) {
                            streamAllocation.release();
                            throw e2;
                        }
                    } catch (RouteException e3) {
                        if (!recover(e3.getLastConnectException(), streamAllocation, false, request)) {
                            throw e3.getFirstConnectException();
                        }
                    }
                } catch (IOException e4) {
                    if (!recover(e4, streamAllocation, !(e4 instanceof ConnectionShutdownException), request)) {
                        throw e4;
                    }
                }
                if (requestFollowUpRequest == null) {
                    if (!this.forWebSocket) {
                        streamAllocation.release();
                    }
                    return responseProceed;
                }
                Util.closeQuietly(responseProceed.body());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    streamAllocation.release();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
                if (requestFollowUpRequest.body() instanceof UnrepeatableRequestBody) {
                    streamAllocation.release();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", responseProceed.code());
                }
                if (!sameConnection(responseProceed, requestFollowUpRequest.url())) {
                    streamAllocation.release();
                    streamAllocation = new StreamAllocation(this.client.connectionPool(), createAddress(requestFollowUpRequest.url()), call, eventListener, this.callStackTrace);
                    this.streamAllocation = streamAllocation;
                } else if (streamAllocation.codec() != null) {
                    throw new IllegalStateException("Closing the body of " + responseProceed + " didn't close its backing stream. Bad interceptor?");
                }
                response = responseProceed;
                request = requestFollowUpRequest;
                i2 = i3;
            } catch (Throwable th) {
                streamAllocation.streamFailed(null);
                streamAllocation.release();
                throw th;
            }
        }
        streamAllocation.release();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCallStackTrace(Object obj) {
        this.callStackTrace = obj;
    }

    public StreamAllocation streamAllocation() {
        return this.streamAllocation;
    }
}
