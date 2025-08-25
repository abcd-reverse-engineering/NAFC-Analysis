package h.g2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0018\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010\u0004\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\b\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\n\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\f\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u000e\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u0010\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u0012\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0014\u001aU\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001c\u001a9\u0010\u0015\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010\u001d\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010\u0015\u001a\u00020\u000f*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a2\u0010\u001e\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\f¢\u0006\u0004\b \u0010!\u001a\"\u0010\"\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0004\b#\u0010$\u001a\"\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0004\b'\u0010(\u001a0\u0010)\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\f¢\u0006\u0002\u0010!\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\b2\u0006\u0010\u001f\u001a\u00020\bH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0010H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0087\f\u001a\u0015\u0010)\u001a\u00020\u0005*\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0087\f\u001a \u0010*\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010$\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0006H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\bH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\nH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\fH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u000eH\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0010H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0012H\u0087\b\u001a\r\u0010*\u001a\u00020\u000f*\u00020\u0014H\u0087\b\u001a \u0010+\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010(\u001a\r\u0010+\u001a\u00020&*\u00020\u0006H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\bH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\nH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\fH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u000eH\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0010H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0012H\u0087\b\u001a\r\u0010+\u001a\u00020&*\u00020\u0014H\u0087\b\u001aQ\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00101\u001a2\u0010,\u001a\u00020\u0006*\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\b*\u00020\b2\u0006\u0010-\u001a\u00020\b2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\n*\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\f*\u00020\f2\u0006\u0010-\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0010*\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0012*\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a2\u0010,\u001a\u00020\u0014*\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u000f2\b\b\u0002\u0010/\u001a\u00020\u000f2\b\b\u0002\u00100\u001a\u00020\u000fH\u0007\u001a$\u00102\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u00103\u001a.\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u00104\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\u00105\u001a\r\u00102\u001a\u00020\u0006*\u00020\u0006H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0006*\u00020\u00062\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\b*\u00020\bH\u0087\b\u001a\u0015\u00102\u001a\u00020\b*\u00020\b2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\n*\u00020\nH\u0087\b\u001a\u0015\u00102\u001a\u00020\n*\u00020\n2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\f*\u00020\fH\u0087\b\u001a\u0015\u00102\u001a\u00020\f*\u00020\f2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u000e*\u00020\u000eH\u0087\b\u001a\u0015\u00102\u001a\u00020\u000e*\u00020\u000e2\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0010*\u00020\u0010H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0010*\u00020\u00102\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0012*\u00020\u0012H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0012*\u00020\u00122\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a\r\u00102\u001a\u00020\u0014*\u00020\u0014H\u0087\b\u001a\u0015\u00102\u001a\u00020\u0014*\u00020\u00142\u0006\u00104\u001a\u00020\u000fH\u0087\b\u001a6\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0004\b7\u00108\u001a\"\u00106\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a\"\u00106\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\b7\u001a5\u00109\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0004\b6\u00108\u001a!\u00109\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\b*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\f*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a!\u00109\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0001¢\u0006\u0002\b6\u001a(\u0010:\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u0006\u0010;\u001a\u00020\u000fH\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010:\u001a\u00020\u0005*\u00020\u00062\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0007*\u00020\b2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\t*\u00020\n2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u000b*\u00020\f2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\r*\u00020\u000e2\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u000f*\u00020\u00102\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0011*\u00020\u00122\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a\u0015\u0010:\u001a\u00020\u0013*\u00020\u00142\u0006\u0010;\u001a\u00020\u000fH\u0087\b\u001a7\u0010=\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010?\u001a&\u0010=\u001a\u00020>*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\n2\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a&\u0010=\u001a\u00020>*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a-\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0\u0001\"\u0004\b\u0000\u0010A*\u0006\u0012\u0002\b\u00030\u00032\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010D\u001aA\u0010E\u001a\u0002HF\"\u0010\b\u0000\u0010F*\n\u0012\u0006\b\u0000\u0012\u0002HA0G\"\u0004\b\u0001\u0010A*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010-\u001a\u0002HF2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C¢\u0006\u0002\u0010H\u001a,\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010J\u001a4\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0086\u0002¢\u0006\u0002\u0010L\u001a2\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00020MH\u0086\u0002¢\u0006\u0002\u0010N\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0005H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0006*\u00020\u00062\u0006\u0010K\u001a\u00020\u0006H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0006*\u00020\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0007H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\b*\u00020\b2\u0006\u0010K\u001a\u00020\bH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\b*\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010\u0016\u001a\u00020\tH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\nH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\n*\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\t0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000bH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\f*\u00020\f2\u0006\u0010K\u001a\u00020\fH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\f*\u00020\f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010K\u001a\u00020\u000eH\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u000e*\u00020\u000e2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\r0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u000fH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0010*\u00020\u00102\u0006\u0010K\u001a\u00020\u0010H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0010*\u00020\u00102\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0011H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0012*\u00020\u00122\u0006\u0010K\u001a\u00020\u0012H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0012*\u00020\u00122\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110MH\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010I\u001a\u00020\u0014*\u00020\u00142\u0006\u0010K\u001a\u00020\u0014H\u0086\u0002\u001a\u001b\u0010I\u001a\u00020\u0014*\u00020\u00142\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00130MH\u0086\u0002\u001a,\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0016\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010J\u001a\u001d\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Q\u001a*\u0010P\u001a\u00020>\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003H\u0087\b¢\u0006\u0002\u0010S\u001a1\u0010P\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010T\u001a\n\u0010P\u001a\u00020>*\u00020\b\u001a\u001e\u0010P\u001a\u00020>*\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\n\u001a\u001e\u0010P\u001a\u00020>*\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\f\u001a\u001e\u0010P\u001a\u00020>*\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u000e\u001a\u001e\u0010P\u001a\u00020>*\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0010\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0012\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a\n\u0010P\u001a\u00020>*\u00020\u0014\u001a\u001e\u0010P\u001a\u00020>*\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f\u001a9\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010V\u001aM\u0010U\u001a\u00020>\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u000f¢\u0006\u0002\u0010W\u001a-\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020R*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003¢\u0006\u0002\u0010Z\u001a?\u0010X\u001a\b\u0012\u0004\u0012\u0002H\u00020Y\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0018j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0019¢\u0006\u0002\u0010[\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050Y*\u00020\u0006\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070Y*\u00020\b\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\t0Y*\u00020\n\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000b0Y*\u00020\f\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\r0Y*\u00020\u000e\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u000f0Y*\u00020\u0010\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110Y*\u00020\u0012\u001a\u0010\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130Y*\u00020\u0014\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\u00020\u0006¢\u0006\u0002\u0010]\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\b¢\u0006\u0002\u0010^\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\t0\u0003*\u00020\n¢\u0006\u0002\u0010_\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003*\u00020\f¢\u0006\u0002\u0010`\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\r0\u0003*\u00020\u000e¢\u0006\u0002\u0010a\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003*\u00020\u0010¢\u0006\u0002\u0010b\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003*\u00020\u0012¢\u0006\u0002\u0010c\u001a\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003*\u00020\u0014¢\u0006\u0002\u0010d¨\u0006e"}, d2 = {"asList", "", ExifInterface.GPS_DIRECTION_TRUE, "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", DispatchConstants.OTHER, "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes2.dex */
public class q extends p {

    /* compiled from: _ArraysJvm.kt */
    public static final class a extends h.g2.d<Byte> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f16163a;

        a(byte[] bArr) {
            this.f16163a = bArr;
        }

        public boolean a(byte b2) {
            return r.b(this.f16163a, b2);
        }

        public int b(byte b2) {
            return r.c(this.f16163a, b2);
        }

        public int c(byte b2) {
            return r.d(this.f16163a, b2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return a(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16163a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return b(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16163a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return c(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Byte get(int i2) {
            return Byte.valueOf(this.f16163a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class b extends h.g2.d<Short> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ short[] f16164a;

        b(short[] sArr) {
            this.f16164a = sArr;
        }

        public boolean a(short s) {
            return r.b(this.f16164a, s);
        }

        public int b(short s) {
            return r.c(this.f16164a, s);
        }

        public int c(short s) {
            return r.d(this.f16164a, s);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return a(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16164a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return b(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16164a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return c(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Short get(int i2) {
            return Short.valueOf(this.f16164a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class c extends h.g2.d<Integer> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f16165a;

        c(int[] iArr) {
            this.f16165a = iArr;
        }

        public boolean a(int i2) {
            return r.a(this.f16165a, i2);
        }

        public int b(int i2) {
            return r.g(this.f16165a, i2);
        }

        public int c(int i2) {
            return r.h(this.f16165a, i2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return a(((Number) obj).intValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16165a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return b(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16165a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return c(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Integer get(int i2) {
            return Integer.valueOf(this.f16165a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class d extends h.g2.d<Long> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long[] f16166a;

        d(long[] jArr) {
            this.f16166a = jArr;
        }

        public boolean a(long j2) {
            return r.b(this.f16166a, j2);
        }

        public int b(long j2) {
            return r.c(this.f16166a, j2);
        }

        public int c(long j2) {
            return r.d(this.f16166a, j2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return a(((Number) obj).longValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16166a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return b(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16166a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return c(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Long get(int i2) {
            return Long.valueOf(this.f16166a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class e extends h.g2.d<Float> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float[] f16167a;

        e(float[] fArr) {
            this.f16167a = fArr;
        }

        public boolean a(float f2) {
            return r.b(this.f16167a, f2);
        }

        public int b(float f2) {
            return r.c(this.f16167a, f2);
        }

        public int c(float f2) {
            return r.d(this.f16167a, f2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return a(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16167a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return b(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16167a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return c(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Float get(int i2) {
            return Float.valueOf(this.f16167a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class f extends h.g2.d<Double> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ double[] f16168a;

        f(double[] dArr) {
            this.f16168a = dArr;
        }

        public boolean a(double d2) {
            return r.b(this.f16168a, d2);
        }

        public int b(double d2) {
            return r.c(this.f16168a, d2);
        }

        public int c(double d2) {
            return r.d(this.f16168a, d2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return a(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16168a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return b(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16168a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return c(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Double get(int i2) {
            return Double.valueOf(this.f16168a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class g extends h.g2.d<Boolean> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean[] f16169a;

        g(boolean[] zArr) {
            this.f16169a = zArr;
        }

        public boolean a(boolean z) {
            return r.b(this.f16169a, z);
        }

        public int b(boolean z) {
            return r.c(this.f16169a, z);
        }

        public int c(boolean z) {
            return r.d(this.f16169a, z);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return a(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16169a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return b(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16169a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return c(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Boolean get(int i2) {
            return Boolean.valueOf(this.f16169a[i2]);
        }
    }

    /* compiled from: _ArraysJvm.kt */
    public static final class h extends h.g2.d<Character> implements RandomAccess {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ char[] f16170a;

        h(char[] cArr) {
            this.f16170a = cArr;
        }

        public boolean a(char c2) {
            return r.b(this.f16170a, c2);
        }

        public int b(char c2) {
            return r.c(this.f16170a, c2);
        }

        public int c(char c2) {
            return r.d(this.f16170a, c2);
        }

        @Override // h.g2.a, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return a(((Character) obj).charValue());
            }
            return false;
        }

        @Override // h.g2.d, h.g2.a
        public int getSize() {
            return this.f16170a.length;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return b(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // h.g2.a, java.util.Collection
        public boolean isEmpty() {
            return this.f16170a.length == 0;
        }

        @Override // h.g2.d, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return c(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // h.g2.d, java.util.List
        @i.c.a.d
        public Character get(int i2) {
            return Character.valueOf(this.f16170a[i2]);
        }
    }

    @i.c.a.d
    public static final <R> List<R> a(@i.c.a.d Object[] objArr, @i.c.a.d Class<R> cls) {
        h.q2.t.i0.f(objArr, "$this$filterIsInstance");
        h.q2.t.i0.f(cls, "klass");
        return (List) a(objArr, new ArrayList(), cls);
    }

    @h.m2.f
    private static final byte b(@i.c.a.d byte[] bArr, int i2) {
        return bArr[i2];
    }

    @h.m2.f
    private static final <T> T c(@i.c.a.d T[] tArr, int i2) {
        return tArr[i2];
    }

    @i.c.a.d
    public static <T> List<T> d(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$asList");
        List<T> listA = s.a(tArr);
        h.q2.t.i0.a((Object) listA, "ArraysUtilJVM.asList(this)");
        return listA;
    }

    @h.m2.f
    @h.q2.e(name = "contentDeepHashCodeInline")
    @h.t0(version = "1.1")
    private static final <T> int e(@i.c.a.d T[] tArr) {
        return h.m2.l.a(1, 3, 0) ? o.a(tArr) : Arrays.deepHashCode(tArr);
    }

    @h.m2.f
    @h.q2.e(name = "contentDeepToStringInline")
    @h.t0(version = "1.1")
    private static final <T> String f(@i.c.a.d T[] tArr) {
        if (h.m2.l.a(1, 3, 0)) {
            return p.c(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        h.q2.t.i0.a((Object) strDeepToString, "java.util.Arrays.deepToString(this)");
        return strDeepToString;
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> int g(@i.c.a.d T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> String h(@i.c.a.d T[] tArr) {
        String string = Arrays.toString(tArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final <T> T[] i(@i.c.a.d T[] tArr) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        h.q2.t.i0.a((Object) tArr2, "java.util.Arrays.copyOf(this, size)");
        return tArr2;
    }

    public static final <T> void j(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$sort");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    @i.c.a.d
    public static final <C extends Collection<? super R>, R> C a(@i.c.a.d Object[] objArr, @i.c.a.d C c2, @i.c.a.d Class<R> cls) {
        h.q2.t.i0.f(objArr, "$this$filterIsInstanceTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(cls, "klass");
        for (Object obj : objArr) {
            if (cls.isInstance(obj)) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @h.m2.f
    private static final short b(@i.c.a.d short[] sArr, int i2) {
        return sArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final <T> boolean c(@i.c.a.d T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    @h.m2.f
    private static final byte[] d(@i.c.a.d byte[] bArr) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        h.q2.t.i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @i.c.a.d
    public static final Byte[] g(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$toTypedArray");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = Byte.valueOf(bArr[i2]);
        }
        return bArr2;
    }

    @i.c.a.d
    public static final List<Byte> a(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$asList");
        return new a(bArr);
    }

    @h.m2.f
    private static final int b(@i.c.a.d int[] iArr, int i2) {
        return iArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d byte[] bArr) {
        String string = Arrays.toString(bArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final short[] d(@i.c.a.d short[] sArr) {
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        h.q2.t.i0.a((Object) sArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return sArrCopyOf;
    }

    @i.c.a.d
    public static final List<Short> a(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$asList");
        return new b(sArr);
    }

    @h.m2.f
    private static final long b(@i.c.a.d long[] jArr, int i2) {
        return jArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d short[] sArr) {
        String string = Arrays.toString(sArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final int[] d(@i.c.a.d int[] iArr) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        h.q2.t.i0.a((Object) iArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return iArrCopyOf;
    }

    public static final void e(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$sort");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @i.c.a.d
    public static final Boolean[] f(@i.c.a.d boolean[] zArr) {
        h.q2.t.i0.f(zArr, "$this$toTypedArray");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            boolArr[i2] = Boolean.valueOf(zArr[i2]);
        }
        return boolArr;
    }

    @i.c.a.d
    public static final List<Integer> a(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$asList");
        return new c(iArr);
    }

    @h.m2.f
    private static final float b(@i.c.a.d float[] fArr, int i2) {
        return fArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d int[] iArr) {
        String string = Arrays.toString(iArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final long[] d(@i.c.a.d long[] jArr) {
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        h.q2.t.i0.a((Object) jArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return jArrCopyOf;
    }

    public static final void e(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$sort");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @i.c.a.d
    public static final Short[] g(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$toTypedArray");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            shArr[i2] = Short.valueOf(sArr[i2]);
        }
        return shArr;
    }

    @i.c.a.d
    public static final List<Long> a(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$asList");
        return new d(jArr);
    }

    @h.m2.f
    private static final double b(@i.c.a.d double[] dArr, int i2) {
        return dArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d long[] jArr) {
        String string = Arrays.toString(jArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final float[] d(@i.c.a.d float[] fArr) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        h.q2.t.i0.a((Object) fArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return fArrCopyOf;
    }

    public static final void e(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$sort");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @i.c.a.d
    public static final List<Float> a(@i.c.a.d float[] fArr) {
        h.q2.t.i0.f(fArr, "$this$asList");
        return new e(fArr);
    }

    @h.m2.f
    private static final boolean b(@i.c.a.d boolean[] zArr, int i2) {
        return zArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d float[] fArr) {
        String string = Arrays.toString(fArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final double[] d(@i.c.a.d double[] dArr) {
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        h.q2.t.i0.a((Object) dArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return dArrCopyOf;
    }

    public static final void e(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$sort");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    @i.c.a.d
    public static final SortedSet<Byte> f(@i.c.a.d byte[] bArr) {
        h.q2.t.i0.f(bArr, "$this$toSortedSet");
        return (SortedSet) r.c(bArr, new TreeSet());
    }

    @i.c.a.d
    public static final List<Double> a(@i.c.a.d double[] dArr) {
        h.q2.t.i0.f(dArr, "$this$asList");
        return new f(dArr);
    }

    @h.m2.f
    private static final char b(@i.c.a.d char[] cArr, int i2) {
        return cArr[i2];
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d double[] dArr) {
        String string = Arrays.toString(dArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final boolean[] d(@i.c.a.d boolean[] zArr) {
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        h.q2.t.i0.a((Object) zArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return zArrCopyOf;
    }

    public static final void e(@i.c.a.d double[] dArr) {
        h.q2.t.i0.f(dArr, "$this$sort");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @i.c.a.d
    public static final SortedSet<Short> f(@i.c.a.d short[] sArr) {
        h.q2.t.i0.f(sArr, "$this$toSortedSet");
        return (SortedSet) r.c(sArr, new TreeSet());
    }

    @i.c.a.d
    public static final Integer[] g(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$toTypedArray");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @i.c.a.d
    public static final List<Boolean> a(@i.c.a.d boolean[] zArr) {
        h.q2.t.i0.f(zArr, "$this$asList");
        return new g(zArr);
    }

    @h.m2.f
    @h.q2.e(name = "contentDeepEqualsInline")
    @h.t0(version = "1.1")
    private static final <T> boolean b(@i.c.a.d T[] tArr, T[] tArr2) {
        if (h.m2.l.a(1, 3, 0)) {
            return p.a(tArr, tArr2);
        }
        return Arrays.deepEquals(tArr, tArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d boolean[] zArr) {
        String string = Arrays.toString(zArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @h.m2.f
    private static final char[] d(@i.c.a.d char[] cArr) {
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        h.q2.t.i0.a((Object) cArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return cArrCopyOf;
    }

    public static final void e(@i.c.a.d float[] fArr) {
        h.q2.t.i0.f(fArr, "$this$sort");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @i.c.a.d
    public static final SortedSet<Integer> f(@i.c.a.d int[] iArr) {
        h.q2.t.i0.f(iArr, "$this$toSortedSet");
        return (SortedSet) r.c(iArr, new TreeSet());
    }

    @i.c.a.d
    public static final List<Character> a(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$asList");
        return new h(cArr);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final String c(@i.c.a.d char[] cArr) {
        String string = Arrays.toString(cArr);
        h.q2.t.i0.a((Object) string, "java.util.Arrays.toString(this)");
        return string;
    }

    @i.c.a.d
    public static final <T> T[] d(@i.c.a.d T[] tArr, @i.c.a.d T[] tArr2) {
        h.q2.t.i0.f(tArr, "$this$plus");
        h.q2.t.i0.f(tArr2, "elements");
        int length = tArr.length;
        int length2 = tArr2.length;
        T[] tArr3 = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(tArr2, 0, tArr3, length, length2);
        h.q2.t.i0.a((Object) tArr3, "result");
        return tArr3;
    }

    public static final void e(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$sort");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @i.c.a.d
    public static final SortedSet<Long> f(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$toSortedSet");
        return (SortedSet) r.c(jArr, new TreeSet());
    }

    public static /* synthetic */ int a(Object[] objArr, Object obj, Comparator comparator, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return a(objArr, obj, (Comparator<? super Object>) comparator, i2, i3);
    }

    @i.c.a.d
    public static int[] c(@i.c.a.d int[] iArr, int i2) {
        h.q2.t.i0.f(iArr, "$this$plus");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
        iArrCopyOf[length] = i2;
        h.q2.t.i0.a((Object) iArrCopyOf, "result");
        return iArrCopyOf;
    }

    @i.c.a.d
    public static final SortedSet<Boolean> e(@i.c.a.d boolean[] zArr) {
        h.q2.t.i0.f(zArr, "$this$toSortedSet");
        return (SortedSet) r.c(zArr, new TreeSet());
    }

    @i.c.a.d
    public static final SortedSet<Float> f(@i.c.a.d float[] fArr) {
        h.q2.t.i0.f(fArr, "$this$toSortedSet");
        return (SortedSet) r.c(fArr, new TreeSet());
    }

    @i.c.a.d
    public static final Long[] g(@i.c.a.d long[] jArr) {
        h.q2.t.i0.f(jArr, "$this$toTypedArray");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            lArr[i2] = Long.valueOf(jArr[i2]);
        }
        return lArr;
    }

    public static final <T> int a(@i.c.a.d T[] tArr, T t, @i.c.a.d Comparator<? super T> comparator, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$binarySearch");
        h.q2.t.i0.f(comparator, "comparator");
        return Arrays.binarySearch(tArr, i2, i3, t, comparator);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @i.c.a.d
    public static final SortedSet<Double> f(@i.c.a.d double[] dArr) {
        h.q2.t.i0.f(dArr, "$this$toSortedSet");
        return (SortedSet) r.c(dArr, new TreeSet());
    }

    public static /* synthetic */ int a(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        return a(objArr, obj, i2, i3);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @i.c.a.d
    public static final SortedSet<Character> f(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$toSortedSet");
        return (SortedSet) r.c(cArr, new TreeSet());
    }

    public static final <T> int a(@i.c.a.d T[] tArr, T t, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$binarySearch");
        return Arrays.binarySearch(tArr, i2, i3, t);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @i.c.a.d
    public static final Float[] g(@i.c.a.d float[] fArr) {
        h.q2.t.i0.f(fArr, "$this$toTypedArray");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = Float.valueOf(fArr[i2]);
        }
        return fArr2;
    }

    public static /* synthetic */ int a(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return a(bArr, b2, i2, i3);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    public static final <T> void c(@i.c.a.d T[] tArr, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$sort");
        Arrays.sort(tArr, i2, i3);
    }

    public static final int a(@i.c.a.d byte[] bArr, byte b2, int i2, int i3) {
        h.q2.t.i0.f(bArr, "$this$binarySearch");
        return Arrays.binarySearch(bArr, i2, i3, b2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static final void c(@i.c.a.d byte[] bArr, int i2, int i3) {
        h.q2.t.i0.f(bArr, "$this$sort");
        Arrays.sort(bArr, i2, i3);
    }

    public static /* synthetic */ int a(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        return a(sArr, s, i2, i3);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    public static final void c(@i.c.a.d short[] sArr, int i2, int i3) {
        h.q2.t.i0.f(sArr, "$this$sort");
        Arrays.sort(sArr, i2, i3);
    }

    @i.c.a.d
    public static final Double[] g(@i.c.a.d double[] dArr) {
        h.q2.t.i0.f(dArr, "$this$toTypedArray");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = Double.valueOf(dArr[i2]);
        }
        return dArr2;
    }

    public static final int a(@i.c.a.d short[] sArr, short s, int i2, int i3) {
        h.q2.t.i0.f(sArr, "$this$binarySearch");
        return Arrays.binarySearch(sArr, i2, i3, s);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    public static final void c(@i.c.a.d int[] iArr, int i2, int i3) {
        h.q2.t.i0.f(iArr, "$this$sort");
        Arrays.sort(iArr, i2, i3);
    }

    public static /* synthetic */ int a(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        return a(iArr, i2, i3, i4);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final int b(@i.c.a.d char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    public static final void c(@i.c.a.d long[] jArr, int i2, int i3) {
        h.q2.t.i0.f(jArr, "$this$sort");
        Arrays.sort(jArr, i2, i3);
    }

    public static final int a(@i.c.a.d int[] iArr, int i2, int i3, int i4) {
        h.q2.t.i0.f(iArr, "$this$binarySearch");
        return Arrays.binarySearch(iArr, i3, i4, i2);
    }

    @h.m2.f
    private static final <T> T[] b(@i.c.a.d T[] tArr, int i2) {
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i2);
        h.q2.t.i0.a((Object) tArr2, "java.util.Arrays.copyOf(this, newSize)");
        return tArr2;
    }

    public static final void c(@i.c.a.d float[] fArr, int i2, int i3) {
        h.q2.t.i0.f(fArr, "$this$sort");
        Arrays.sort(fArr, i2, i3);
    }

    @i.c.a.d
    public static final Character[] g(@i.c.a.d char[] cArr) {
        h.q2.t.i0.f(cArr, "$this$toTypedArray");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            chArr[i2] = Character.valueOf(cArr[i2]);
        }
        return chArr;
    }

    public static /* synthetic */ int a(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        return a(jArr, j2, i2, i3);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final <T> T[] b(@i.c.a.d T[] tArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return (T[]) n.a(tArr, i2, i3);
        }
        if (i3 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
            h.q2.t.i0.a((Object) tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + tArr.length);
    }

    public static final void c(@i.c.a.d double[] dArr, int i2, int i3) {
        h.q2.t.i0.f(dArr, "$this$sort");
        Arrays.sort(dArr, i2, i3);
    }

    public static final int a(@i.c.a.d long[] jArr, long j2, int i2, int i3) {
        h.q2.t.i0.f(jArr, "$this$binarySearch");
        return Arrays.binarySearch(jArr, i2, i3, j2);
    }

    public static final void c(@i.c.a.d char[] cArr, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$sort");
        Arrays.sort(cArr, i2, i3);
    }

    public static /* synthetic */ int a(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        return a(fArr, f2, i2, i3);
    }

    public static final int a(@i.c.a.d float[] fArr, float f2, int i2, int i3) {
        h.q2.t.i0.f(fArr, "$this$binarySearch");
        return Arrays.binarySearch(fArr, i2, i3, f2);
    }

    public static /* synthetic */ int a(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        return a(dArr, d2, i2, i3);
    }

    public static final int a(@i.c.a.d double[] dArr, double d2, int i2, int i3) {
        h.q2.t.i0.f(dArr, "$this$binarySearch");
        return Arrays.binarySearch(dArr, i2, i3, d2);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final byte[] b(@i.c.a.d byte[] bArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(bArr, i2, i3);
        }
        if (i3 <= bArr.length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
            h.q2.t.i0.a((Object) bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return bArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + bArr.length);
    }

    public static /* synthetic */ int a(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        return a(cArr, c2, i2, i3);
    }

    public static final int a(@i.c.a.d char[] cArr, char c2, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$binarySearch");
        return Arrays.binarySearch(cArr, i2, i3, c2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final short[] b(@i.c.a.d short[] sArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(sArr, i2, i3);
        }
        if (i3 <= sArr.length) {
            short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i2, i3);
            h.q2.t.i0.a((Object) sArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return sArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + sArr.length);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    @h.m2.f
    @h.t0(version = "1.1")
    private static final boolean a(@i.c.a.d char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final int[] b(@i.c.a.d int[] iArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(iArr, i2, i3);
        }
        if (i3 <= iArr.length) {
            int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i2, i3);
            h.q2.t.i0.a((Object) iArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return iArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + iArr.length);
    }

    public static /* synthetic */ Object[] a(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return a(objArr, objArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static final <T> T[] a(@i.c.a.d T[] tArr, @i.c.a.d T[] tArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(tArr, "$this$copyInto");
        h.q2.t.i0.f(tArr2, "destination");
        System.arraycopy(tArr, i3, tArr2, i2, i4 - i3);
        return tArr2;
    }

    public static /* synthetic */ byte[] a(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = bArr.length;
        }
        return a(bArr, bArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static byte[] a(@i.c.a.d byte[] bArr, @i.c.a.d byte[] bArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(bArr, "$this$copyInto");
        h.q2.t.i0.f(bArr2, "destination");
        System.arraycopy(bArr, i3, bArr2, i2, i4 - i3);
        return bArr2;
    }

    public static /* synthetic */ short[] a(short[] sArr, short[] sArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = sArr.length;
        }
        return a(sArr, sArr2, i2, i3, i4);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final long[] b(@i.c.a.d long[] jArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(jArr, i2, i3);
        }
        if (i3 <= jArr.length) {
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i2, i3);
            h.q2.t.i0.a((Object) jArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return jArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + jArr.length);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static short[] a(@i.c.a.d short[] sArr, @i.c.a.d short[] sArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(sArr, "$this$copyInto");
        h.q2.t.i0.f(sArr2, "destination");
        System.arraycopy(sArr, i3, sArr2, i2, i4 - i3);
        return sArr2;
    }

    public static /* synthetic */ int[] a(int[] iArr, int[] iArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = iArr.length;
        }
        return a(iArr, iArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static int[] a(@i.c.a.d int[] iArr, @i.c.a.d int[] iArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(iArr, "$this$copyInto");
        h.q2.t.i0.f(iArr2, "destination");
        System.arraycopy(iArr, i3, iArr2, i2, i4 - i3);
        return iArr2;
    }

    public static /* synthetic */ long[] a(long[] jArr, long[] jArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = jArr.length;
        }
        return a(jArr, jArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static long[] a(@i.c.a.d long[] jArr, @i.c.a.d long[] jArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(jArr, "$this$copyInto");
        h.q2.t.i0.f(jArr2, "destination");
        System.arraycopy(jArr, i3, jArr2, i2, i4 - i3);
        return jArr2;
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final float[] b(@i.c.a.d float[] fArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(fArr, i2, i3);
        }
        if (i3 <= fArr.length) {
            float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i2, i3);
            h.q2.t.i0.a((Object) fArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return fArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + fArr.length);
    }

    public static /* synthetic */ float[] a(float[] fArr, float[] fArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = fArr.length;
        }
        return a(fArr, fArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static final float[] a(@i.c.a.d float[] fArr, @i.c.a.d float[] fArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(fArr, "$this$copyInto");
        h.q2.t.i0.f(fArr2, "destination");
        System.arraycopy(fArr, i3, fArr2, i2, i4 - i3);
        return fArr2;
    }

    public static /* synthetic */ double[] a(double[] dArr, double[] dArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = dArr.length;
        }
        return a(dArr, dArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static final double[] a(@i.c.a.d double[] dArr, @i.c.a.d double[] dArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(dArr, "$this$copyInto");
        h.q2.t.i0.f(dArr2, "destination");
        System.arraycopy(dArr, i3, dArr2, i2, i4 - i3);
        return dArr2;
    }

    public static /* synthetic */ boolean[] a(boolean[] zArr, boolean[] zArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = zArr.length;
        }
        return a(zArr, zArr2, i2, i3, i4);
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final double[] b(@i.c.a.d double[] dArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(dArr, i2, i3);
        }
        if (i3 <= dArr.length) {
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i2, i3);
            h.q2.t.i0.a((Object) dArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return dArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + dArr.length);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static final boolean[] a(@i.c.a.d boolean[] zArr, @i.c.a.d boolean[] zArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(zArr, "$this$copyInto");
        h.q2.t.i0.f(zArr2, "destination");
        System.arraycopy(zArr, i3, zArr2, i2, i4 - i3);
        return zArr2;
    }

    public static /* synthetic */ char[] a(char[] cArr, char[] cArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = cArr.length;
        }
        return a(cArr, cArr2, i2, i3, i4);
    }

    @h.t0(version = "1.3")
    @i.c.a.d
    public static final char[] a(@i.c.a.d char[] cArr, @i.c.a.d char[] cArr2, int i2, int i3, int i4) {
        h.q2.t.i0.f(cArr, "$this$copyInto");
        h.q2.t.i0.f(cArr2, "destination");
        System.arraycopy(cArr, i3, cArr2, i2, i4 - i3);
        return cArr2;
    }

    @h.m2.f
    private static final byte[] a(@i.c.a.d byte[] bArr, int i2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
        h.q2.t.i0.a((Object) bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf;
    }

    @h.m2.f
    private static final short[] a(@i.c.a.d short[] sArr, int i2) {
        short[] sArrCopyOf = Arrays.copyOf(sArr, i2);
        h.q2.t.i0.a((Object) sArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return sArrCopyOf;
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final boolean[] b(@i.c.a.d boolean[] zArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(zArr, i2, i3);
        }
        if (i3 <= zArr.length) {
            boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i2, i3);
            h.q2.t.i0.a((Object) zArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return zArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + zArr.length);
    }

    @h.m2.f
    private static final int[] a(@i.c.a.d int[] iArr, int i2) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, i2);
        h.q2.t.i0.a((Object) iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return iArrCopyOf;
    }

    @h.m2.f
    private static final long[] a(@i.c.a.d long[] jArr, int i2) {
        long[] jArrCopyOf = Arrays.copyOf(jArr, i2);
        h.q2.t.i0.a((Object) jArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return jArrCopyOf;
    }

    @h.m2.f
    private static final float[] a(@i.c.a.d float[] fArr, int i2) {
        float[] fArrCopyOf = Arrays.copyOf(fArr, i2);
        h.q2.t.i0.a((Object) fArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return fArrCopyOf;
    }

    @h.m2.f
    private static final double[] a(@i.c.a.d double[] dArr, int i2) {
        double[] dArrCopyOf = Arrays.copyOf(dArr, i2);
        h.q2.t.i0.a((Object) dArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return dArrCopyOf;
    }

    @h.m2.f
    private static final boolean[] a(@i.c.a.d boolean[] zArr, int i2) {
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i2);
        h.q2.t.i0.a((Object) zArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return zArrCopyOf;
    }

    @h.m2.f
    @h.q2.e(name = "copyOfRangeInline")
    private static final char[] b(@i.c.a.d char[] cArr, int i2, int i3) {
        if (h.m2.l.a(1, 3, 0)) {
            return a(cArr, i2, i3);
        }
        if (i3 <= cArr.length) {
            char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i2, i3);
            h.q2.t.i0.a((Object) cArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
            return cArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i3 + ", size: " + cArr.length);
    }

    @h.m2.f
    private static final char[] a(@i.c.a.d char[] cArr, int i2) {
        char[] cArrCopyOf = Arrays.copyOf(cArr, i2);
        h.q2.t.i0.a((Object) cArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        return cArrCopyOf;
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static <T> T[] a(@i.c.a.d T[] tArr, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$copyOfRangeImpl");
        o.a(i3, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i2, i3);
        h.q2.t.i0.a((Object) tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static byte[] a(@i.c.a.d byte[] bArr, int i2, int i3) {
        h.q2.t.i0.f(bArr, "$this$copyOfRangeImpl");
        o.a(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        h.q2.t.i0.a((Object) bArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static /* synthetic */ void b(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        b(objArr, obj, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static short[] a(@i.c.a.d short[] sArr, int i2, int i3) {
        h.q2.t.i0.f(sArr, "$this$copyOfRangeImpl");
        o.a(i3, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i2, i3);
        h.q2.t.i0.a((Object) sArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return sArrCopyOfRange;
    }

    public static final <T> void b(@i.c.a.d T[] tArr, T t, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$fill");
        Arrays.fill(tArr, i2, i3, t);
    }

    public static /* synthetic */ void b(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        b(bArr, b2, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static int[] a(@i.c.a.d int[] iArr, int i2, int i3) {
        h.q2.t.i0.f(iArr, "$this$copyOfRangeImpl");
        o.a(i3, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i2, i3);
        h.q2.t.i0.a((Object) iArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return iArrCopyOfRange;
    }

    public static void b(@i.c.a.d byte[] bArr, byte b2, int i2, int i3) {
        h.q2.t.i0.f(bArr, "$this$fill");
        Arrays.fill(bArr, i2, i3, b2);
    }

    public static /* synthetic */ void b(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = sArr.length;
        }
        b(sArr, s, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static long[] a(@i.c.a.d long[] jArr, int i2, int i3) {
        h.q2.t.i0.f(jArr, "$this$copyOfRangeImpl");
        o.a(i3, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i2, i3);
        h.q2.t.i0.a((Object) jArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return jArrCopyOfRange;
    }

    public static void b(@i.c.a.d short[] sArr, short s, int i2, int i3) {
        h.q2.t.i0.f(sArr, "$this$fill");
        Arrays.fill(sArr, i2, i3, s);
    }

    public static /* synthetic */ void b(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = iArr.length;
        }
        b(iArr, i2, i3, i4);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final float[] a(@i.c.a.d float[] fArr, int i2, int i3) {
        h.q2.t.i0.f(fArr, "$this$copyOfRangeImpl");
        o.a(i3, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i2, i3);
        h.q2.t.i0.a((Object) fArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return fArrCopyOfRange;
    }

    public static void b(@i.c.a.d int[] iArr, int i2, int i3, int i4) {
        h.q2.t.i0.f(iArr, "$this$fill");
        Arrays.fill(iArr, i3, i4, i2);
    }

    public static /* synthetic */ void b(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = jArr.length;
        }
        b(jArr, j2, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final double[] a(@i.c.a.d double[] dArr, int i2, int i3) {
        h.q2.t.i0.f(dArr, "$this$copyOfRangeImpl");
        o.a(i3, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i2, i3);
        h.q2.t.i0.a((Object) dArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return dArrCopyOfRange;
    }

    public static void b(@i.c.a.d long[] jArr, long j2, int i2, int i3) {
        h.q2.t.i0.f(jArr, "$this$fill");
        Arrays.fill(jArr, i2, i3, j2);
    }

    public static /* synthetic */ void b(float[] fArr, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = fArr.length;
        }
        b(fArr, f2, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final boolean[] a(@i.c.a.d boolean[] zArr, int i2, int i3) {
        h.q2.t.i0.f(zArr, "$this$copyOfRangeImpl");
        o.a(i3, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i2, i3);
        h.q2.t.i0.a((Object) zArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return zArrCopyOfRange;
    }

    public static final void b(@i.c.a.d float[] fArr, float f2, int i2, int i3) {
        h.q2.t.i0.f(fArr, "$this$fill");
        Arrays.fill(fArr, i2, i3, f2);
    }

    public static /* synthetic */ void b(double[] dArr, double d2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = dArr.length;
        }
        b(dArr, d2, i2, i3);
    }

    @h.q2.e(name = "copyOfRange")
    @h.t0(version = "1.3")
    @h.n0
    @i.c.a.d
    public static final char[] a(@i.c.a.d char[] cArr, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$copyOfRangeImpl");
        o.a(i3, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i2, i3);
        h.q2.t.i0.a((Object) cArrCopyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return cArrCopyOfRange;
    }

    public static final void b(@i.c.a.d double[] dArr, double d2, int i2, int i3) {
        h.q2.t.i0.f(dArr, "$this$fill");
        Arrays.fill(dArr, i2, i3, d2);
    }

    public static /* synthetic */ void b(char[] cArr, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = cArr.length;
        }
        b(cArr, c2, i2, i3);
    }

    public static /* synthetic */ void a(boolean[] zArr, boolean z, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = zArr.length;
        }
        a(zArr, z, i2, i3);
    }

    public static final void b(@i.c.a.d char[] cArr, char c2, int i2, int i3) {
        h.q2.t.i0.f(cArr, "$this$fill");
        Arrays.fill(cArr, i2, i3, c2);
    }

    public static final void a(@i.c.a.d boolean[] zArr, boolean z, int i2, int i3) {
        h.q2.t.i0.f(zArr, "$this$fill");
        Arrays.fill(zArr, i2, i3, z);
    }

    @i.c.a.d
    public static byte[] b(@i.c.a.d byte[] bArr, @i.c.a.d byte[] bArr2) {
        h.q2.t.i0.f(bArr, "$this$plus");
        h.q2.t.i0.f(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) bArrCopyOf, "result");
        return bArrCopyOf;
    }

    @i.c.a.d
    public static final <T> T[] a(@i.c.a.d T[] tArr, T t) {
        h.q2.t.i0.f(tArr, "$this$plus");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, length + 1);
        tArr2[length] = t;
        h.q2.t.i0.a((Object) tArr2, "result");
        return tArr2;
    }

    @i.c.a.d
    public static byte[] a(@i.c.a.d byte[] bArr, byte b2) {
        h.q2.t.i0.f(bArr, "$this$plus");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, length + 1);
        bArrCopyOf[length] = b2;
        h.q2.t.i0.a((Object) bArrCopyOf, "result");
        return bArrCopyOf;
    }

    @i.c.a.d
    public static short[] b(@i.c.a.d short[] sArr, @i.c.a.d short[] sArr2) {
        h.q2.t.i0.f(sArr, "$this$plus");
        h.q2.t.i0.f(sArr2, "elements");
        int length = sArr.length;
        int length2 = sArr2.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(sArr2, 0, sArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) sArrCopyOf, "result");
        return sArrCopyOf;
    }

    @i.c.a.d
    public static short[] a(@i.c.a.d short[] sArr, short s) {
        h.q2.t.i0.f(sArr, "$this$plus");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, length + 1);
        sArrCopyOf[length] = s;
        h.q2.t.i0.a((Object) sArrCopyOf, "result");
        return sArrCopyOf;
    }

    @i.c.a.d
    public static int[] b(@i.c.a.d int[] iArr, @i.c.a.d int[] iArr2) {
        h.q2.t.i0.f(iArr, "$this$plus");
        h.q2.t.i0.f(iArr2, "elements");
        int length = iArr.length;
        int length2 = iArr2.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) iArrCopyOf, "result");
        return iArrCopyOf;
    }

    @i.c.a.d
    public static long[] a(@i.c.a.d long[] jArr, long j2) {
        h.q2.t.i0.f(jArr, "$this$plus");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + 1);
        jArrCopyOf[length] = j2;
        h.q2.t.i0.a((Object) jArrCopyOf, "result");
        return jArrCopyOf;
    }

    @i.c.a.d
    public static long[] b(@i.c.a.d long[] jArr, @i.c.a.d long[] jArr2) {
        h.q2.t.i0.f(jArr, "$this$plus");
        h.q2.t.i0.f(jArr2, "elements");
        int length = jArr.length;
        int length2 = jArr2.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) jArrCopyOf, "result");
        return jArrCopyOf;
    }

    @i.c.a.d
    public static final float[] a(@i.c.a.d float[] fArr, float f2) {
        h.q2.t.i0.f(fArr, "$this$plus");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + 1);
        fArrCopyOf[length] = f2;
        h.q2.t.i0.a((Object) fArrCopyOf, "result");
        return fArrCopyOf;
    }

    @i.c.a.d
    public static final float[] b(@i.c.a.d float[] fArr, @i.c.a.d float[] fArr2) {
        h.q2.t.i0.f(fArr, "$this$plus");
        h.q2.t.i0.f(fArr2, "elements");
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) fArrCopyOf, "result");
        return fArrCopyOf;
    }

    @i.c.a.d
    public static final double[] a(@i.c.a.d double[] dArr, double d2) {
        h.q2.t.i0.f(dArr, "$this$plus");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + 1);
        dArrCopyOf[length] = d2;
        h.q2.t.i0.a((Object) dArrCopyOf, "result");
        return dArrCopyOf;
    }

    @i.c.a.d
    public static final boolean[] a(@i.c.a.d boolean[] zArr, boolean z) {
        h.q2.t.i0.f(zArr, "$this$plus");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + 1);
        zArrCopyOf[length] = z;
        h.q2.t.i0.a((Object) zArrCopyOf, "result");
        return zArrCopyOf;
    }

    @i.c.a.d
    public static final double[] b(@i.c.a.d double[] dArr, @i.c.a.d double[] dArr2) {
        h.q2.t.i0.f(dArr, "$this$plus");
        h.q2.t.i0.f(dArr2, "elements");
        int length = dArr.length;
        int length2 = dArr2.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(dArr2, 0, dArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) dArrCopyOf, "result");
        return dArrCopyOf;
    }

    @i.c.a.d
    public static final char[] a(@i.c.a.d char[] cArr, char c2) {
        h.q2.t.i0.f(cArr, "$this$plus");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + 1);
        cArrCopyOf[length] = c2;
        h.q2.t.i0.a((Object) cArrCopyOf, "result");
        return cArrCopyOf;
    }

    @i.c.a.d
    public static final boolean[] b(@i.c.a.d boolean[] zArr, @i.c.a.d boolean[] zArr2) {
        h.q2.t.i0.f(zArr, "$this$plus");
        h.q2.t.i0.f(zArr2, "elements");
        int length = zArr.length;
        int length2 = zArr2.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) zArrCopyOf, "result");
        return zArrCopyOf;
    }

    @i.c.a.d
    public static final <T> T[] a(@i.c.a.d T[] tArr, @i.c.a.d Collection<? extends T> collection) {
        h.q2.t.i0.f(tArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = tArr.length;
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, collection.size() + length);
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            tArr2[length] = it.next();
            length++;
        }
        h.q2.t.i0.a((Object) tArr2, "result");
        return tArr2;
    }

    @i.c.a.d
    public static final char[] b(@i.c.a.d char[] cArr, @i.c.a.d char[] cArr2) {
        h.q2.t.i0.f(cArr, "$this$plus");
        h.q2.t.i0.f(cArr2, "elements");
        int length = cArr.length;
        int length2 = cArr2.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(cArr2, 0, cArrCopyOf, length, length2);
        h.q2.t.i0.a((Object) cArrCopyOf, "result");
        return cArrCopyOf;
    }

    @i.c.a.d
    public static final byte[] a(@i.c.a.d byte[] bArr, @i.c.a.d Collection<Byte> collection) {
        h.q2.t.i0.f(bArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, collection.size() + length);
        Iterator<Byte> it = collection.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().byteValue();
            length++;
        }
        h.q2.t.i0.a((Object) bArrCopyOf, "result");
        return bArrCopyOf;
    }

    @h.m2.f
    private static final <T> T[] b(@i.c.a.d T[] tArr, T t) {
        return (T[]) a(tArr, t);
    }

    @i.c.a.d
    public static final short[] a(@i.c.a.d short[] sArr, @i.c.a.d Collection<Short> collection) {
        h.q2.t.i0.f(sArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, collection.size() + length);
        Iterator<Short> it = collection.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().shortValue();
            length++;
        }
        h.q2.t.i0.a((Object) sArrCopyOf, "result");
        return sArrCopyOf;
    }

    @i.c.a.d
    public static final <T extends Comparable<? super T>> SortedSet<T> b(@i.c.a.d T[] tArr) {
        h.q2.t.i0.f(tArr, "$this$toSortedSet");
        return (SortedSet) r.e((Object[]) tArr, new TreeSet());
    }

    @i.c.a.d
    public static final <T> SortedSet<T> b(@i.c.a.d T[] tArr, @i.c.a.d Comparator<? super T> comparator) {
        h.q2.t.i0.f(tArr, "$this$toSortedSet");
        h.q2.t.i0.f(comparator, "comparator");
        return (SortedSet) r.e((Object[]) tArr, new TreeSet(comparator));
    }

    @i.c.a.d
    public static final int[] a(@i.c.a.d int[] iArr, @i.c.a.d Collection<Integer> collection) {
        h.q2.t.i0.f(iArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, collection.size() + length);
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().intValue();
            length++;
        }
        h.q2.t.i0.a((Object) iArrCopyOf, "result");
        return iArrCopyOf;
    }

    @i.c.a.d
    public static final long[] a(@i.c.a.d long[] jArr, @i.c.a.d Collection<Long> collection) {
        h.q2.t.i0.f(jArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, collection.size() + length);
        Iterator<Long> it = collection.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().longValue();
            length++;
        }
        h.q2.t.i0.a((Object) jArrCopyOf, "result");
        return jArrCopyOf;
    }

    @i.c.a.d
    public static final float[] a(@i.c.a.d float[] fArr, @i.c.a.d Collection<Float> collection) {
        h.q2.t.i0.f(fArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = fArr.length;
        float[] fArrCopyOf = Arrays.copyOf(fArr, collection.size() + length);
        Iterator<Float> it = collection.iterator();
        while (it.hasNext()) {
            fArrCopyOf[length] = it.next().floatValue();
            length++;
        }
        h.q2.t.i0.a((Object) fArrCopyOf, "result");
        return fArrCopyOf;
    }

    @i.c.a.d
    public static final double[] a(@i.c.a.d double[] dArr, @i.c.a.d Collection<Double> collection) {
        h.q2.t.i0.f(dArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = dArr.length;
        double[] dArrCopyOf = Arrays.copyOf(dArr, collection.size() + length);
        Iterator<Double> it = collection.iterator();
        while (it.hasNext()) {
            dArrCopyOf[length] = it.next().doubleValue();
            length++;
        }
        h.q2.t.i0.a((Object) dArrCopyOf, "result");
        return dArrCopyOf;
    }

    @i.c.a.d
    public static final boolean[] a(@i.c.a.d boolean[] zArr, @i.c.a.d Collection<Boolean> collection) {
        h.q2.t.i0.f(zArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = zArr.length;
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, collection.size() + length);
        Iterator<Boolean> it = collection.iterator();
        while (it.hasNext()) {
            zArrCopyOf[length] = it.next().booleanValue();
            length++;
        }
        h.q2.t.i0.a((Object) zArrCopyOf, "result");
        return zArrCopyOf;
    }

    @i.c.a.d
    public static final char[] a(@i.c.a.d char[] cArr, @i.c.a.d Collection<Character> collection) {
        h.q2.t.i0.f(cArr, "$this$plus");
        h.q2.t.i0.f(collection, "elements");
        int length = cArr.length;
        char[] cArrCopyOf = Arrays.copyOf(cArr, collection.size() + length);
        Iterator<Character> it = collection.iterator();
        while (it.hasNext()) {
            cArrCopyOf[length] = it.next().charValue();
            length++;
        }
        h.q2.t.i0.a((Object) cArrCopyOf, "result");
        return cArrCopyOf;
    }

    @h.m2.f
    private static final <T extends Comparable<? super T>> void a(@i.c.a.d T[] tArr) {
        if (tArr == null) {
            throw new h.e1("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        j(tArr);
    }

    public static /* synthetic */ void a(Object[] objArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = objArr.length;
        }
        c(objArr, i2, i3);
    }

    public static /* synthetic */ void a(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        c(bArr, i2, i3);
    }

    public static /* synthetic */ void a(short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = sArr.length;
        }
        c(sArr, i2, i3);
    }

    public static /* synthetic */ void a(int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = iArr.length;
        }
        c(iArr, i2, i3);
    }

    public static /* synthetic */ void a(long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = jArr.length;
        }
        c(jArr, i2, i3);
    }

    public static /* synthetic */ void a(float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = fArr.length;
        }
        c(fArr, i2, i3);
    }

    public static /* synthetic */ void a(double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = dArr.length;
        }
        c(dArr, i2, i3);
    }

    public static /* synthetic */ void a(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        c(cArr, i2, i3);
    }

    public static final <T> void a(@i.c.a.d T[] tArr, @i.c.a.d Comparator<? super T> comparator) {
        h.q2.t.i0.f(tArr, "$this$sortWith");
        h.q2.t.i0.f(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ void a(Object[] objArr, Comparator comparator, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        a(objArr, comparator, i2, i3);
    }

    public static final <T> void a(@i.c.a.d T[] tArr, @i.c.a.d Comparator<? super T> comparator, int i2, int i3) {
        h.q2.t.i0.f(tArr, "$this$sortWith");
        h.q2.t.i0.f(comparator, "comparator");
        Arrays.sort(tArr, i2, i3, comparator);
    }
}
