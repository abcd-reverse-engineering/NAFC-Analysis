package h.z2;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import h.c1;
import h.e1;
import h.o0;
import h.q2.t.j0;
import h.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\u0087\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0086\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\u0087\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\u0087\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\u0087\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\u0087\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\u0086\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, d2 = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", DispatchConstants.OTHER, "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", RequestParameters.PREFIX, "removeRange", "range", "removeSuffix", "removeSurrounding", RequestParameters.DELIMITER, "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes2.dex */
public class c0 extends b0 {

    /* compiled from: Strings.kt */
    public static final class a extends h.g2.v {

        /* renamed from: a, reason: collision with root package name */
        private int f16676a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f16677b;

        a(CharSequence charSequence) {
            this.f16677b = charSequence;
        }

        @Override // h.g2.v
        public char b() {
            CharSequence charSequence = this.f16677b;
            int i2 = this.f16676a;
            this.f16676a = i2 + 1;
            return charSequence.charAt(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f16676a < this.f16677b.length();
        }
    }

    /* compiled from: Strings.kt */
    static final class b extends j0 implements h.q2.s.p<CharSequence, Integer, h.i0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] $delimiters;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(char[] cArr, boolean z) {
            super(2);
            this.$delimiters = cArr;
            this.$ignoreCase = z;
        }

        @i.c.a.e
        public final h.i0<Integer, Integer> invoke(@i.c.a.d CharSequence charSequence, int i2) {
            h.q2.t.i0.f(charSequence, "$receiver");
            int iA = c0.a(charSequence, this.$delimiters, i2, this.$ignoreCase);
            if (iA < 0) {
                return null;
            }
            return c1.a(Integer.valueOf(iA), 1);
        }

        @Override // h.q2.s.p
        public /* bridge */ /* synthetic */ h.i0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    static final class c extends j0 implements h.q2.s.p<CharSequence, Integer, h.i0<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List $delimitersList;
        final /* synthetic */ boolean $ignoreCase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, boolean z) {
            super(2);
            this.$delimitersList = list;
            this.$ignoreCase = z;
        }

        @i.c.a.e
        public final h.i0<Integer, Integer> invoke(@i.c.a.d CharSequence charSequence, int i2) {
            h.q2.t.i0.f(charSequence, "$receiver");
            h.i0 i0VarB = c0.b(charSequence, (Collection<String>) this.$delimitersList, i2, this.$ignoreCase, false);
            if (i0VarB != null) {
                return c1.a(i0VarB.getFirst(), Integer.valueOf(((String) i0VarB.getSecond()).length()));
            }
            return null;
        }

        @Override // h.q2.s.p
        public /* bridge */ /* synthetic */ h.i0<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return invoke(charSequence, num.intValue());
        }
    }

    /* compiled from: Strings.kt */
    static final class d extends j0 implements h.q2.s.l<h.v2.k, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d h.v2.k kVar) {
            h.q2.t.i0.f(kVar, "it");
            return c0.c(this.$this_splitToSequence, kVar);
        }
    }

    /* compiled from: Strings.kt */
    static final class e extends j0 implements h.q2.s.l<h.v2.k, String> {
        final /* synthetic */ CharSequence $this_splitToSequence;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(CharSequence charSequence) {
            super(1);
            this.$this_splitToSequence = charSequence;
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d h.v2.k kVar) {
            h.q2.t.i0.f(kVar, "it");
            return c0.c(this.$this_splitToSequence, kVar);
        }
    }

    @i.c.a.d
    public static final CharSequence b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$trimEnd");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (lVar.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue());
        return charSequence.subSequence(0, length + 1);
    }

    @i.c.a.d
    public static final CharSequence c(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$trimStart");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @h.m2.f
    private static final boolean d(@i.c.a.d CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    @h.m2.f
    private static final boolean e(@i.c.a.d CharSequence charSequence) {
        return !b0.a(charSequence);
    }

    @h.m2.f
    private static final boolean f(@i.c.a.d CharSequence charSequence) {
        return charSequence.length() > 0;
    }

    @h.m2.f
    private static final boolean g(@i.c.a.e CharSequence charSequence) {
        return charSequence == null || b0.a(charSequence);
    }

    @h.m2.f
    private static final boolean h(@i.c.a.e CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @i.c.a.d
    public static final h.g2.v i(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$iterator");
        return new a(charSequence);
    }

    @i.c.a.d
    public static final h.x2.m<String> j(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$lineSequence");
        return b(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    @i.c.a.d
    public static final List<String> k(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$lines");
        return h.x2.u.L(j(charSequence));
    }

    @i.c.a.d
    public static CharSequence l(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zP = h.z2.d.p(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zP) {
                    break;
                }
                length--;
            } else if (zP) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @i.c.a.d
    public static final CharSequence m(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (h.z2.d.p(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    @i.c.a.d
    public static final CharSequence n(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!h.z2.d.p(charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @h.m2.f
    private static final String n(@i.c.a.e String str) {
        return str != null ? str : "";
    }

    @h.m2.f
    private static final String o(@i.c.a.d String str) {
        if (str != null) {
            return l((CharSequence) str).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @h.m2.f
    private static final String p(@i.c.a.d String str) {
        if (str != null) {
            return m((CharSequence) str).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @h.m2.f
    private static final String q(@i.c.a.d String str) {
        if (str != null) {
            return n((CharSequence) str).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$trim");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zBooleanValue = lVar.invoke(Character.valueOf(charSequence.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static /* synthetic */ String d(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return d(str, str2, str3);
    }

    public static /* synthetic */ String e(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return e(str, str2, str3);
    }

    @i.c.a.d
    public static final String d(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$substringBefore");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iA = a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iA);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @i.c.a.d
    public static final String e(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$substringBeforeLast");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iB = b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iB == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iB);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ CharSequence b(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return b(charSequence, i2, c2);
    }

    public static final int c(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ CharSequence a(CharSequence charSequence, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return a(charSequence, i2, c2);
    }

    @i.c.a.d
    public static final CharSequence b(@i.c.a.d CharSequence charSequence, int i2, char c2) {
        h.q2.t.i0.f(charSequence, "$this$padStart");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    @i.c.a.d
    public static final String c(@i.c.a.d CharSequence charSequence, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(charSequence, "$this$substring");
        h.q2.t.i0.f(kVar, "range");
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String d(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return d(str, c2, str2);
    }

    public static /* synthetic */ boolean e(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return e(charSequence, charSequence2, z);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, int i2, char c2) {
        h.q2.t.i0.f(charSequence, "$this$padEnd");
        if (i2 >= 0) {
            if (i2 <= charSequence.length()) {
                return charSequence.subSequence(0, charSequence.length());
            }
            StringBuilder sb = new StringBuilder(i2);
            sb.append(charSequence);
            int length = i2 - charSequence.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c2);
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            return sb;
        }
        throw new IllegalArgumentException("Desired length " + i2 + " is less than zero.");
    }

    public static /* synthetic */ String c(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return c(str, c2, str2);
    }

    @i.c.a.d
    public static final String d(@i.c.a.d String str, char c2, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$substringBeforeLast");
        h.q2.t.i0.f(str2, "missingDelimiterValue");
        int iB = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iB == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iB);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean e(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$startsWith");
        h.q2.t.i0.f(charSequence2, RequestParameters.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return b0.d((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return b(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, char c2, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$substringBefore");
        h.q2.t.i0.f(str2, "missingDelimiterValue");
        int iA = a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iA);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String d(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return d(str, c2, str2, str3);
    }

    public static /* synthetic */ String c(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return c(str, str2, str3);
    }

    @i.c.a.d
    public static final String d(@i.c.a.d String str, char c2, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$replaceBeforeLast");
        h.q2.t.i0.f(str2, "replacement");
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iB = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iB == -1 ? str3 : a((CharSequence) str, 0, iB, (CharSequence) str2).toString();
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$substringAfterLast");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iB = b((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iB == -1) {
            return str3;
        }
        String strSubstring = str.substring(iB + str2.length(), str.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String d(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return d(str, str2, str3, str4);
    }

    public static /* synthetic */ String b(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return b(str, i2, c2);
    }

    @i.c.a.d
    public static final CharSequence c(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$removeSurrounding");
        h.q2.t.i0.f(charSequence2, RequestParameters.DELIMITER);
        return a(charSequence, charSequence2, charSequence2);
    }

    @i.c.a.d
    public static final String d(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, @i.c.a.d String str4) {
        h.q2.t.i0.f(str, "$this$replaceBeforeLast");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "replacement");
        h.q2.t.i0.f(str4, "missingDelimiterValue");
        int iB = b((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iB == -1 ? str4 : a((CharSequence) str, 0, iB, (CharSequence) str3).toString();
    }

    public static /* synthetic */ String a(String str, int i2, char c2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            c2 = ' ';
        }
        return a(str, i2, c2);
    }

    @i.c.a.d
    public static String b(@i.c.a.d String str, int i2, char c2) {
        h.q2.t.i0.f(str, "$this$padStart");
        return b((CharSequence) str, i2, c2).toString();
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(str, "$this$removeSurrounding");
        h.q2.t.i0.f(charSequence, RequestParameters.DELIMITER);
        return a(str, charSequence, charSequence);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, int i2, char c2) {
        h.q2.t.i0.f(str, "$this$padEnd");
        return a((CharSequence) str, i2, c2).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <C extends CharSequence & R, R> R b(C c2, h.q2.s.a<? extends R> aVar) {
        return c2.length() == 0 ? aVar.invoke() : c2;
    }

    public static /* synthetic */ String c(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return c(str, c2, str2, str3);
    }

    public static /* synthetic */ boolean d(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return d(charSequence, charSequence2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h.m2.f
    @t0(version = "1.3")
    private static final <C extends CharSequence & R, R> R a(C c2, h.q2.s.a<? extends R> aVar) {
        return b0.a(c2) ? aVar.invoke() : c2;
    }

    @i.c.a.d
    public static final h.v2.k b(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$indices");
        return new h.v2.k(0, charSequence.length() - 1);
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, char c2, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$replaceBefore");
        h.q2.t.i0.f(str2, "replacement");
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iA = a((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iA == -1 ? str3 : a((CharSequence) str, 0, iA, (CharSequence) str2).toString();
    }

    public static final boolean d(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$endsWith");
        h.q2.t.i0.f(charSequence2, "suffix");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return b0.b((String) charSequence, (String) charSequence2, false, 2, null);
        }
        return b(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    static /* synthetic */ String a(CharSequence charSequence, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = charSequence.length();
        }
        return charSequence.subSequence(i2, i3).toString();
    }

    public static final boolean b(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$hasSurrogatePairAt");
        return i2 >= 0 && charSequence.length() + (-2) >= i2 && Character.isHighSurrogate(charSequence.charAt(i2)) && Character.isLowSurrogate(charSequence.charAt(i2 + 1));
    }

    public static /* synthetic */ String c(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return c(str, str2, str3, str4);
    }

    public static /* synthetic */ String a(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return a(str, c2, str2);
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, @i.c.a.d String str4) {
        h.q2.t.i0.f(str, "$this$replaceBefore");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "replacement");
        h.q2.t.i0.f(str4, "missingDelimiterValue");
        int iA = a((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iA == -1 ? str4 : a((CharSequence) str, 0, iA, (CharSequence) str3).toString();
    }

    public static /* synthetic */ int d(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return d(charSequence, (Collection<String>) collection, i2, z);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, char c2, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$substringAfter");
        h.q2.t.i0.f(str2, "missingDelimiterValue");
        int iA = a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str2;
        }
        String strSubstring = str.substring(iA + 1, str.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(str, "$this$substring");
        h.q2.t.i0.f(kVar, "range");
        String strSubstring = str.substring(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final int d(@i.c.a.d CharSequence charSequence, @i.c.a.d Collection<String> collection, int i2, boolean z) {
        Integer first;
        h.q2.t.i0.f(charSequence, "$this$lastIndexOfAny");
        h.q2.t.i0.f(collection, "strings");
        h.i0<Integer, String> i0VarB = b(charSequence, collection, i2, z, true);
        if (i0VarB == null || (first = i0VarB.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @i.c.a.d
    public static final CharSequence b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(charSequence, "$this$subSequence");
        h.q2.t.i0.f(kVar, "range");
        return charSequence.subSequence(kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c(charSequence, c2, z);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, int i2, int i3, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$replaceRange");
        h.q2.t.i0.f(charSequence2, "replacement");
        if (i3 >= i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i2);
            h.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
            sb.append(charSequence2);
            sb.append(charSequence, i3, charSequence.length());
            h.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
    }

    @h.m2.f
    @h.c(message = "Use parameters named startIndex and endIndex.", replaceWith = @o0(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence b(@i.c.a.d String str, int i2, int i3) {
        return str.subSequence(i2, i3);
    }

    public static final boolean c(@i.c.a.d CharSequence charSequence, char c2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$startsWith");
        return charSequence.length() > 0 && h.z2.e.a(charSequence.charAt(0), c2, z);
    }

    @h.m2.f
    private static final String b(@i.c.a.d CharSequence charSequence, int i2, int i3) {
        return charSequence.subSequence(i2, i3).toString();
    }

    public static /* synthetic */ int c(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return c(charSequence, (Collection<String>) collection, i2, z);
    }

    public static /* synthetic */ String b(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return b(str, str2, str3);
    }

    public static final int c(@i.c.a.d CharSequence charSequence, @i.c.a.d Collection<String> collection, int i2, boolean z) {
        Integer first;
        h.q2.t.i0.f(charSequence, "$this$indexOfAny");
        h.q2.t.i0.f(collection, "strings");
        h.i0<Integer, String> i0VarB = b(charSequence, collection, i2, z, false);
        if (i0VarB == null || (first = i0VarB.getFirst()) == null) {
            return -1;
        }
        return first.intValue();
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$substringAfter");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iA = a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (iA == -1) {
            return str3;
        }
        String strSubstring = str.substring(iA + str2.length(), str.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return c(charSequence, charSequence2, z);
    }

    public static final boolean c(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$contains");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        if (charSequence2 instanceof String) {
            if (a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, (Object) null) >= 0) {
            return true;
        }
        return false;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, int i2, int i3, CharSequence charSequence) {
        if (str != null) {
            return a((CharSequence) str, i2, i3, charSequence).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static /* synthetic */ String b(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return b(str, c2, str2);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.v2.k kVar, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$replaceRange");
        h.q2.t.i0.f(kVar, "range");
        h.q2.t.i0.f(charSequence2, "replacement");
        return a(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1, charSequence2);
    }

    @i.c.a.d
    public static String b(@i.c.a.d String str, char c2, @i.c.a.d String str2) {
        h.q2.t.i0.f(str, "$this$substringAfterLast");
        h.q2.t.i0.f(str2, "missingDelimiterValue");
        int iB = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (iB == -1) {
            return str2;
        }
        String strSubstring = str.substring(iB + 1, str.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, h.v2.k kVar, CharSequence charSequence) {
        if (str != null) {
            return a((CharSequence) str, kVar, charSequence).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        h.q2.t.i0.f(str, "$this$trimStart");
        h.q2.t.i0.f(lVar, "predicate");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequenceSubSequence.toString();
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, int i2, int i3) {
        h.q2.t.i0.f(charSequence, "$this$removeRange");
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
        }
        if (i3 == i2) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(charSequence.length() - (i3 - i2));
        sb.append(charSequence, 0, i2);
        h.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
        sb.append(charSequence, i3, charSequence.length());
        h.q2.t.i0.a((Object) sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @i.c.a.d
    public static final CharSequence b(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$removeSuffix");
        h.q2.t.i0.f(charSequence2, "suffix");
        if (d(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(str, "$this$removeSuffix");
        h.q2.t.i0.f(charSequence, "suffix");
        if (!d((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @i.c.a.d
    public static final CharSequence c(@i.c.a.d CharSequence charSequence, @i.c.a.d char... cArr) {
        h.q2.t.i0.f(charSequence, "$this$trimStart");
        h.q2.t.i0.f(cArr, "chars");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!h.g2.r.b(cArr, charSequence.charAt(i2))) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, int i2, int i3) {
        if (str != null) {
            return a((CharSequence) str, i2, i3).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static /* synthetic */ String b(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return b(str, str2, str3, str4);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(charSequence, "$this$removeRange");
        h.q2.t.i0.f(kVar, "range");
        return a(charSequence, kVar.getStart().intValue(), kVar.getEndInclusive().intValue() + 1);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, @i.c.a.d String str4) {
        h.q2.t.i0.f(str, "$this$replaceAfterLast");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "replacement");
        h.q2.t.i0.f(str4, "missingDelimiterValue");
        int iB = b((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iB == -1 ? str4 : a((CharSequence) str, iB + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, h.v2.k kVar) {
        if (str != null) {
            return a((CharSequence) str, kVar).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @i.c.a.d
    public static final String c(@i.c.a.d String str, @i.c.a.d char... cArr) {
        CharSequence charSequenceSubSequence;
        h.q2.t.i0.f(str, "$this$trimStart");
        h.q2.t.i0.f(cArr, "chars");
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                charSequenceSubSequence = "";
                break;
            }
            if (!h.g2.r.b(cArr, str.charAt(i2))) {
                charSequenceSubSequence = str.subSequence(i2, str.length());
                break;
            }
            i2++;
        }
        return charSequenceSubSequence.toString();
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$removePrefix");
        h.q2.t.i0.f(charSequence2, RequestParameters.PREFIX);
        if (e(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static /* synthetic */ String b(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return b(str, c2, str2, str3);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, char c2, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$replaceAfterLast");
        h.q2.t.i0.f(str2, "replacement");
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iB = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iB == -1 ? str3 : a((CharSequence) str, iB + 1, str.length(), (CharSequence) str2).toString();
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(str, "$this$removePrefix");
        h.q2.t.i0.f(charSequence, RequestParameters.PREFIX);
        if (!e((CharSequence) str, charSequence, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @h.m2.f
    private static final String b(@i.c.a.d CharSequence charSequence, o oVar, String str) {
        return oVar.replaceFirst(charSequence, str);
    }

    @h.m2.f
    private static final boolean b(@i.c.a.d CharSequence charSequence, o oVar) {
        return oVar.matches(charSequence);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, @i.c.a.d CharSequence charSequence3) {
        h.q2.t.i0.f(charSequence, "$this$removeSurrounding");
        h.q2.t.i0.f(charSequence2, RequestParameters.PREFIX);
        h.q2.t.i0.f(charSequence3, "suffix");
        if (charSequence.length() >= charSequence2.length() + charSequence3.length() && e(charSequence, charSequence2, false, 2, (Object) null) && d(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final boolean b(@i.c.a.d CharSequence charSequence, int i2, @i.c.a.d CharSequence charSequence2, int i3, int i4, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$regionMatchesImpl");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!h.z2.e.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(charSequence, c2, z);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(str, "$this$removeSurrounding");
        h.q2.t.i0.f(charSequence, RequestParameters.PREFIX);
        h.q2.t.i0.f(charSequence2, "suffix");
        if (str.length() < charSequence.length() + charSequence2.length() || !e((CharSequence) str, charSequence, false, 2, (Object) null) || !d((CharSequence) str, charSequence2, false, 2, (Object) null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length(), str.length() - charSequence2.length());
        h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean b(@i.c.a.d CharSequence charSequence, char c2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$endsWith");
        return charSequence.length() > 0 && h.z2.e.a(charSequence.charAt(c(charSequence)), c2, z);
    }

    public static /* synthetic */ String b(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(charSequence, charSequence2, z);
    }

    public static /* synthetic */ String a(String str, char c2, String str2, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = str;
        }
        return a(str, c2, str2, str3);
    }

    @i.c.a.d
    public static final String b(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$commonSuffixWith");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        int length = charSequence.length();
        int iMin = Math.min(length, charSequence2.length());
        int i2 = 0;
        while (i2 < iMin && h.z2.e.a(charSequence.charAt((length - i2) - 1), charSequence2.charAt((r1 - i2) - 1), z)) {
            i2++;
        }
        if (b(charSequence, (length - i2) - 1) || b(charSequence2, (r1 - i2) - 1)) {
            i2--;
        }
        return charSequence.subSequence(length - i2, length).toString();
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, char c2, @i.c.a.d String str2, @i.c.a.d String str3) {
        h.q2.t.i0.f(str, "$this$replaceAfter");
        h.q2.t.i0.f(str2, "replacement");
        h.q2.t.i0.f(str3, "missingDelimiterValue");
        int iA = a((CharSequence) str, c2, 0, false, 6, (Object) null);
        return iA == -1 ? str3 : a((CharSequence) str, iA + 1, str.length(), (CharSequence) str2).toString();
    }

    public static /* synthetic */ String a(String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str4 = str;
        }
        return a(str, str2, str3, str4);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d String str2, @i.c.a.d String str3, @i.c.a.d String str4) {
        h.q2.t.i0.f(str, "$this$replaceAfter");
        h.q2.t.i0.f(str2, RequestParameters.DELIMITER);
        h.q2.t.i0.f(str3, "replacement");
        h.q2.t.i0.f(str4, "missingDelimiterValue");
        int iA = a((CharSequence) str, str2, 0, false, 6, (Object) null);
        return iA == -1 ? str4 : a((CharSequence) str, iA + str2.length(), str.length(), (CharSequence) str3).toString();
    }

    @h.m2.f
    private static final String a(@i.c.a.d CharSequence charSequence, o oVar, String str) {
        return oVar.replace(charSequence, str);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(charSequence, cArr, i2, z);
    }

    @h.m2.f
    private static final String a(@i.c.a.d CharSequence charSequence, o oVar, h.q2.s.l<? super m, ? extends CharSequence> lVar) {
        return oVar.replace(charSequence, lVar);
    }

    public static final int b(@i.c.a.d CharSequence charSequence, @i.c.a.d char[] cArr, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$lastIndexOfAny");
        h.q2.t.i0.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(h.g2.r.E(cArr), i2);
        }
        for (int iB = h.v2.q.b(i2, c(charSequence)); iB >= 0; iB--) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (h.z2.e.a(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iB;
            }
        }
        return -1;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, i2, z);
    }

    public static final boolean a(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$startsWith");
        h.q2.t.i0.f(charSequence2, RequestParameters.PREFIX);
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return b0.a((String) charSequence, (String) charSequence2, i2, false, 4, (Object) null);
        }
        return b(charSequence, i2, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ String a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(charSequence, charSequence2, z);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$commonPrefixWith");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        int i2 = 0;
        while (i2 < iMin && h.z2.e.a(charSequence.charAt(i2), charSequence2.charAt(i2), z)) {
            i2++;
        }
        int i3 = i2 - 1;
        if (b(charSequence, i3) || b(charSequence2, i3)) {
            i2--;
        }
        return charSequence.subSequence(0, i2).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h.i0<Integer, String> b(@i.c.a.d CharSequence charSequence, Collection<String> collection, int i2, boolean z, boolean z2) {
        Object next;
        Object next2;
        if (!z && collection.size() == 1) {
            String str = (String) h.g2.w.C(collection);
            int iA = !z2 ? a(charSequence, str, i2, false, 4, (Object) null) : b(charSequence, str, i2, false, 4, (Object) null);
            if (iA < 0) {
                return null;
            }
            return c1.a(Integer.valueOf(iA), str);
        }
        h.v2.i kVar = !z2 ? new h.v2.k(h.v2.q.a(i2, 0), charSequence.length()) : h.v2.q.c(h.v2.q.b(i2, c(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = kVar.getFirst();
            int last = kVar.getLast();
            int iB = kVar.b();
            if (iB < 0 ? first >= last : first <= last) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (b0.a(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += iB;
                    } else {
                        return c1.a(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = kVar.getFirst();
            int last2 = kVar.getLast();
            int iB2 = kVar.b();
            if (iB2 < 0 ? first2 >= last2 : first2 <= last2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (b(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += iB2;
                    } else {
                        return c1.a(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, cArr, i2, z);
    }

    public static final int a(@i.c.a.d CharSequence charSequence, @i.c.a.d char[] cArr, int i2, boolean z) {
        boolean z2;
        h.q2.t.i0.f(charSequence, "$this$indexOfAny");
        h.q2.t.i0.f(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(h.g2.r.E(cArr), i2);
        }
        int iA = h.v2.q.a(i2, 0);
        int iC = c(charSequence);
        if (iA > iC) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iA);
            int length = cArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z2 = false;
                    break;
                }
                if (h.z2.e.a(cArr[i3], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i3++;
            }
            if (z2) {
                return iA;
            }
            if (iA == iC) {
                return -1;
            }
            iA++;
        }
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2, int i4, Object obj) {
        return a(charSequence, charSequence2, i2, i3, z, (i4 & 16) != 0 ? false : z2);
    }

    private static final int a(@i.c.a.d CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        h.v2.i iVarC;
        if (!z2) {
            iVarC = new h.v2.k(h.v2.q.a(i2, 0), h.v2.q.b(i3, charSequence.length()));
        } else {
            iVarC = h.v2.q.c(h.v2.q.b(i2, c(charSequence)), h.v2.q.a(i3, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = iVarC.getFirst();
            int last = iVarC.getLast();
            int iB = iVarC.b();
            if (iB >= 0) {
                if (first > last) {
                    return -1;
                }
            } else if (first < last) {
                return -1;
            }
            while (!b0.a((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += iB;
            }
            return first;
        }
        int first2 = iVarC.getFirst();
        int last2 = iVarC.getLast();
        int iB2 = iVarC.b();
        if (iB2 >= 0) {
            if (first2 > last2) {
                return -1;
            }
        } else if (first2 < last2) {
            return -1;
        }
        while (!b(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += iB2;
        }
        return first2;
    }

    public static /* synthetic */ h.i0 b(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(charSequence, (Collection<String>) collection, i2, z);
    }

    @i.c.a.e
    public static final h.i0<Integer, String> b(@i.c.a.d CharSequence charSequence, @i.c.a.d Collection<String> collection, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$findLastAnyOf");
        h.q2.t.i0.f(collection, "strings");
        return b(charSequence, collection, i2, z, true);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(charSequence, c2, i2, z);
    }

    public static final int b(@i.c.a.d CharSequence charSequence, char c2, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return b(charSequence, new char[]{c2}, i2, z);
    }

    public static /* synthetic */ h.i0 a(CharSequence charSequence, Collection collection, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, (Collection<String>) collection, i2, z);
    }

    @i.c.a.e
    public static final h.i0<Integer, String> a(@i.c.a.d CharSequence charSequence, @i.c.a.d Collection<String> collection, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$findAnyOf");
        h.q2.t.i0.f(collection, "strings");
        return b(charSequence, collection, i2, z, false);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = c(charSequence);
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i2, z);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c2, i2, z);
    }

    public static final int b(@i.c.a.d CharSequence charSequence, @i.c.a.d String str, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$lastIndexOf");
        h.q2.t.i0.f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, 0, z, true);
    }

    public static final int a(@i.c.a.d CharSequence charSequence, char c2, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return a(charSequence, new char[]{c2}, i2, z);
    }

    public static /* synthetic */ h.x2.m b(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return b(charSequence, strArr, z, i2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i2, z);
    }

    @i.c.a.d
    public static final h.x2.m<String> b(@i.c.a.d CharSequence charSequence, @i.c.a.d String[] strArr, boolean z, int i2) {
        h.q2.t.i0.f(charSequence, "$this$splitToSequence");
        h.q2.t.i0.f(strArr, "delimiters");
        return h.x2.u.w(a(charSequence, strArr, 0, z, i2, 2, (Object) null), new d(charSequence));
    }

    public static final int a(@i.c.a.d CharSequence charSequence, @i.c.a.d String str, int i2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$indexOf");
        h.q2.t.i0.f(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, charSequence.length(), z, false, 16, (Object) null);
    }

    public static /* synthetic */ h.x2.m b(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return b(charSequence, cArr, z, i2);
    }

    @i.c.a.d
    public static final h.x2.m<String> b(@i.c.a.d CharSequence charSequence, @i.c.a.d char[] cArr, boolean z, int i2) {
        h.q2.t.i0.f(charSequence, "$this$splitToSequence");
        h.q2.t.i0.f(cArr, "delimiters");
        return h.x2.u.w(a(charSequence, cArr, 0, z, i2, 2, (Object) null), new e(charSequence));
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        CharSequence charSequenceSubSequence;
        h.q2.t.i0.f(str, "$this$trimEnd");
        h.q2.t.i0.f(lVar, "predicate");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequenceSubSequence = "";
                break;
            }
            if (!lVar.invoke(Character.valueOf(str.charAt(length))).booleanValue()) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, char c2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return a(charSequence, c2, z);
    }

    public static final boolean a(@i.c.a.d CharSequence charSequence, char c2, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$contains");
        return a(charSequence, c2, 0, z, 2, (Object) null) >= 0;
    }

    @h.m2.f
    private static final boolean a(@i.c.a.d CharSequence charSequence, o oVar) {
        h.q2.t.i0.f(charSequence, "$this$contains");
        return oVar.containsMatchIn(charSequence);
    }

    static /* synthetic */ h.x2.m a(CharSequence charSequence, char[] cArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, cArr, i2, z, i3);
    }

    @i.c.a.d
    public static final CharSequence b(@i.c.a.d CharSequence charSequence, @i.c.a.d char... cArr) {
        h.q2.t.i0.f(charSequence, "$this$trimEnd");
        h.q2.t.i0.f(cArr, "chars");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (h.g2.r.b(cArr, charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    private static final h.x2.m<h.v2.k> a(@i.c.a.d CharSequence charSequence, char[] cArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new h(charSequence, i2, i3, new b(cArr, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    static /* synthetic */ h.x2.m a(CharSequence charSequence, String[] strArr, int i2, boolean z, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, strArr, i2, z, i3);
    }

    private static final h.x2.m<h.v2.k> a(@i.c.a.d CharSequence charSequence, String[] strArr, int i2, boolean z, int i3) {
        if (i3 >= 0) {
            return new h(charSequence, i2, i3, new c(h.g2.q.d((Object[]) strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    @i.c.a.d
    public static final String b(@i.c.a.d String str, @i.c.a.d char... cArr) {
        CharSequence charSequenceSubSequence;
        h.q2.t.i0.f(str, "$this$trimEnd");
        h.q2.t.i0.f(cArr, "chars");
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                charSequenceSubSequence = "";
                break;
            }
            if (!h.g2.r.b(cArr, str.charAt(length))) {
                charSequenceSubSequence = str.subSequence(0, length + 1);
                break;
            }
        }
        return charSequenceSubSequence.toString();
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, z, i2);
    }

    @i.c.a.d
    public static final List<String> a(@i.c.a.d CharSequence charSequence, @i.c.a.d String[] strArr, boolean z, int i2) {
        h.q2.t.i0.f(charSequence, "$this$split");
        h.q2.t.i0.f(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i2);
            }
        }
        Iterable iterableG = h.x2.u.g(a(charSequence, strArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(h.g2.z.a(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(c(charSequence, (h.v2.k) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ List a(CharSequence charSequence, char[] cArr, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return a(charSequence, cArr, z, i2);
    }

    @i.c.a.d
    public static final List<String> a(@i.c.a.d CharSequence charSequence, @i.c.a.d char[] cArr, boolean z, int i2) {
        h.q2.t.i0.f(charSequence, "$this$split");
        h.q2.t.i0.f(cArr, "delimiters");
        if (cArr.length == 1) {
            return a(charSequence, String.valueOf(cArr[0]), z, i2);
        }
        Iterable iterableG = h.x2.u.g(a(charSequence, cArr, 0, z, i2, 2, (Object) null));
        ArrayList arrayList = new ArrayList(h.g2.z.a(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(c(charSequence, (h.v2.k) it.next()));
        }
        return arrayList;
    }

    private static final List<String> a(@i.c.a.d CharSequence charSequence, String str, boolean z, int i2) {
        int length = 0;
        if (i2 >= 0) {
            int iA = a(charSequence, str, 0, z);
            if (iA != -1 && i2 != 1) {
                boolean z2 = i2 > 0;
                ArrayList arrayList = new ArrayList(z2 ? h.v2.q.b(i2, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(length, iA).toString());
                    length = str.length() + iA;
                    if (z2 && arrayList.size() == i2 - 1) {
                        break;
                    }
                    iA = a(charSequence, str, length, z);
                } while (iA != -1);
                arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
                return arrayList;
            }
            return h.g2.x.a(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @h.m2.f
    private static final List<String> a(@i.c.a.d CharSequence charSequence, o oVar, int i2) {
        return oVar.split(charSequence, i2);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$trim");
        h.q2.t.i0.f(lVar, "predicate");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zBooleanValue = lVar.invoke(Character.valueOf(str.charAt(!z ? i2 : length))).booleanValue();
            if (z) {
                if (!zBooleanValue) {
                    break;
                }
                length--;
            } else if (zBooleanValue) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d char... cArr) {
        h.q2.t.i0.f(charSequence, "$this$trim");
        h.q2.t.i0.f(cArr, "chars");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zB = h.g2.r.b(cArr, charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!zB) {
                    break;
                }
                length--;
            } else if (zB) {
                i2++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d char... cArr) {
        h.q2.t.i0.f(str, "$this$trim");
        h.q2.t.i0.f(cArr, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zB = h.g2.r.b(cArr, str.charAt(!z ? i2 : length));
            if (z) {
                if (!zB) {
                    break;
                }
                length--;
            } else if (zB) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    static /* synthetic */ List a(CharSequence charSequence, o oVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return oVar.split(charSequence, i2);
    }
}
