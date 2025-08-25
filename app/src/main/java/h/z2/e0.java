package h.z2;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import h.c1;
import h.e1;
import h.g2.b1;
import h.g2.l1;
import h.g2.m1;
import h.g2.n0;
import h.g2.p1;
import h.g2.r0;
import h.g2.s0;
import h.q2.t.j0;
import h.t0;
import h.y1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import ui.activity.SmsRecordSelectActivity;

/* compiled from: _Strings.kt */
@h.y(bv = {1, 0, 3}, d1 = {"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u001f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0010\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b*\u00020\u0002\u001a\u0010\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n*\u00020\u0002\u001aE\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\u0086\b\u001a3\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00050\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u001aM\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u001aN\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0018\b\u0001\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u00020\u00050\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b¢\u0006\u0002\u0010\u0018\u001ah\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b¢\u0006\u0002\u0010\u0019\u001a`\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0018\b\u0002\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e0\u00100\u0004H\u0086\b¢\u0006\u0002\u0010\u0018\u001a3\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\f\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0087\b\u001aN\u0010\u001d\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u000e\"\u0018\b\u0001\u0010\u0015*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0005\u0012\u0006\b\u0000\u0012\u0002H\u000e0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0087\b¢\u0006\u0002\u0010\u0018\u001a\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0007\u001a4\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\n*\u00020\u00022\u0006\u0010!\u001a\u00020\"H\u0007\u001a4\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0\n\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\r\u0010%\u001a\u00020\"*\u00020\u0002H\u0087\b\u001a!\u0010%\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010&\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010(\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0012\u0010(\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a!\u0010)\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010)\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010*\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010*\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a)\u0010+\u001a\u00020\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001a\u001c\u0010.\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"H\u0087\b¢\u0006\u0002\u0010/\u001a!\u00100\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u00100\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a6\u00101\u001a\u00020\u0002*\u00020\u00022'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\u0086\b\u001a6\u00101\u001a\u00020 *\u00020 2'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\u0086\b\u001aQ\u00105\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000102H\u0086\b¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010:\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a<\u0010;\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¢\u0006\u0002\u0010<\u001a<\u0010=\u001a\u0002H6\"\f\b\u0000\u00106*\u000607j\u0002`8*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¢\u0006\u0002\u0010<\u001a(\u0010>\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0087\b¢\u0006\u0002\u0010?\u001a(\u0010@\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0087\b¢\u0006\u0002\u0010?\u001a\n\u0010A\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010A\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0011\u0010B\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a(\u0010B\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¢\u0006\u0002\u0010?\u001a3\u0010D\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0\b0\u0004H\u0086\b\u001aL\u0010E\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0\b0\u0004H\u0086\b¢\u0006\u0002\u0010G\u001aI\u0010H\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2'\u0010J\u001a#\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\u0086\b¢\u0006\u0002\u0010L\u001a^\u0010M\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0NH\u0086\b¢\u0006\u0002\u0010O\u001aI\u0010P\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2'\u0010J\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002H#02H\u0086\b¢\u0006\u0002\u0010L\u001a^\u0010Q\u001a\u0002H#\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u0002H#0NH\u0086\b¢\u0006\u0002\u0010O\u001a!\u0010R\u001a\u00020S*\u00020\u00022\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S0\u0004H\u0086\b\u001a6\u0010U\u001a\u00020S*\u00020\u00022'\u0010T\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S02H\u0086\b\u001a)\u0010V\u001a\u00020\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\b\u001a\u0019\u0010W\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010,\u001a\u00020\"¢\u0006\u0002\u0010/\u001a9\u0010X\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\f\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b\u001aS\u0010X\u001a\u0014\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u001f0\f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b\u001aR\u0010Y\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u001c\b\u0001\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050Z0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0086\b¢\u0006\u0002\u0010\u0018\u001al\u0010Y\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u001c\b\u0002\u0010\u0015*\u0016\u0012\u0006\b\u0000\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0Z0\u0016*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H\u00152\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0086\b¢\u0006\u0002\u0010\u0019\u001a5\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\\\"\u0004\b\u0000\u0010\r*\u00020\u00022\u0014\b\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\r0\u0004H\u0087\b\u001a!\u0010]\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a!\u0010^\u001a\u00020\"*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\n\u0010_\u001a\u00020\u0005*\u00020\u0002\u001a!\u0010_\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0011\u0010`\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a(\u0010`\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¢\u0006\u0002\u0010?\u001a-\u0010a\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\u0086\b\u001aB\u0010b\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\u0086\b\u001aH\u0010c\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\b\b\u0000\u0010#*\u00020d*\u00020\u00022)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#02H\u0086\b\u001aa\u0010e\u001a\u0002H6\"\b\b\u0000\u0010#*\u00020d\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62)\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#02H\u0086\b¢\u0006\u0002\u0010f\u001a[\u0010g\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62'\u0010\u000f\u001a#\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\u0086\b¢\u0006\u0002\u0010f\u001a3\u0010h\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\b\b\u0000\u0010#*\u00020d*\u00020\u00022\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#0\u0004H\u0086\b\u001aL\u0010i\u001a\u0002H6\"\b\b\u0000\u0010#*\u00020d\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u0001H#0\u0004H\u0086\b¢\u0006\u0002\u0010G\u001aF\u0010j\u001a\u0002H6\"\u0004\b\u0000\u0010#\"\u0010\b\u0001\u00106*\n\u0012\u0006\b\u0000\u0012\u0002H#0F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H62\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\u0086\b¢\u0006\u0002\u0010G\u001a\u0011\u0010k\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a8\u0010l\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0m*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\u0086\b¢\u0006\u0002\u0010?\u001a-\u0010o\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010p\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050qj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`r¢\u0006\u0002\u0010s\u001a\u0011\u0010t\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a8\u0010u\u001a\u0004\u0018\u00010\u0005\"\u000e\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0m*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0\u0004H\u0086\b¢\u0006\u0002\u0010?\u001a-\u0010v\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u001a\u0010p\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00050qj\n\u0012\u0006\b\u0000\u0012\u00020\u0005`r¢\u0006\u0002\u0010s\u001a\n\u0010w\u001a\u00020\u0001*\u00020\u0002\u001a!\u0010w\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a0\u0010x\u001a\u0002Hy\"\b\b\u0000\u0010y*\u00020\u0002*\u0002Hy2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020S0\u0004H\u0087\b¢\u0006\u0002\u0010z\u001a-\u0010{\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0010*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a-\u0010{\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u0010*\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\r\u0010|\u001a\u00020\u0005*\u00020\u0002H\u0087\b\u001a\u0014\u0010|\u001a\u00020\u0005*\u00020\u00022\u0006\u0010|\u001a\u00020}H\u0007\u001a\u0014\u0010~\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010C\u001a\u001b\u0010~\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010|\u001a\u00020}H\u0007¢\u0006\u0002\u0010\u007f\u001a7\u0010\u0080\u0001\u001a\u00020\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0086\b\u001aL\u0010\u0081\u0001\u001a\u00020\u0005*\u00020\u00022<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050NH\u0086\b\u001a?\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0087\b¢\u0006\u0003\u0010\u0083\u0001\u001a7\u0010\u0084\u0001\u001a\u00020\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u000502H\u0086\b\u001aL\u0010\u0085\u0001\u001a\u00020\u0005*\u00020\u00022<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u00050NH\u0086\b\u001a?\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u00022'\u0010J\u001a#\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u000502H\u0087\b¢\u0006\u0003\u0010\u0083\u0001\u001a\u000b\u0010\u0087\u0001\u001a\u00020\u0002*\u00020\u0002\u001a\u000e\u0010\u0087\u0001\u001a\u00020 *\u00020 H\u0087\b\u001aQ\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2'\u0010J\u001a#\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#02H\u0087\b¢\u0006\u0003\u0010\u0089\u0001\u001af\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010I\u001a\u0002H#2<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u0011H#¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H#0NH\u0087\b¢\u0006\u0003\u0010\u008b\u0001\u001a=\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f*\u00020\u00022'\u0010J\u001a#\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0087\b\u001aR\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f*\u00020\u00022<\u0010J\u001a8\u0012\u0013\u0012\u00110\"¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050NH\u0087\b\u001a\u000b\u0010\u008e\u0001\u001a\u00020\u0005*\u00020\u0002\u001a\"\u0010\u008e\u0001\u001a\u00020\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\u0012\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u0002¢\u0006\u0002\u0010C\u001a)\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b¢\u0006\u0002\u0010?\u001a\u001a\u0010\u0090\u0001\u001a\u00020\u0002*\u00020\u00022\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\b\u001a\u0015\u0010\u0090\u0001\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001\u001a\u001d\u0010\u0090\u0001\u001a\u00020 *\u00020 2\r\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\bH\u0087\b\u001a\u0015\u0010\u0090\u0001\u001a\u00020 *\u00020 2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001\u001a\"\u0010\u0093\u0001\u001a\u00020\"*\u00020\u00022\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0\u0004H\u0086\b\u001a$\u0010\u0094\u0001\u001a\u00030\u0095\u0001*\u00020\u00022\u0013\u0010n\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0005\u0012\u00030\u0095\u00010\u0004H\u0086\b\u001a\u0013\u0010\u0096\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0096\u0001\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0097\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\"\u001a\u0013\u0010\u0097\u0001\u001a\u00020 *\u00020 2\u0006\u0010'\u001a\u00020\"\u001a\"\u0010\u0098\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0098\u0001\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0099\u0001\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a\"\u0010\u0099\u0001\u001a\u00020 *\u00020 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u001a+\u0010\u009a\u0001\u001a\u0002H6\"\u0010\b\u0000\u00106*\n\u0012\u0006\b\u0000\u0012\u00020\u00050F*\u00020\u00022\u0006\u0010\u0017\u001a\u0002H6¢\u0006\u0003\u0010\u009b\u0001\u001a\u001d\u0010\u009c\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00050\u009d\u0001j\t\u0012\u0004\u0012\u00020\u0005`\u009e\u0001*\u00020\u0002\u001a\u0011\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f*\u00020\u0002\u001a\u0011\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\u00050Z*\u00020\u0002\u001a\u0012\u0010¡\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¢\u0001*\u00020\u0002\u001a1\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010¤\u0001\u001a\u00020\"2\t\b\u0002\u0010¥\u0001\u001a\u00020\u0001H\u0007\u001aK\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010¤\u0001\u001a\u00020\"2\t\b\u0002\u0010¥\u0001\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a1\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020 0\n*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010¤\u0001\u001a\u00020\"2\t\b\u0002\u0010¥\u0001\u001a\u00020\u0001H\u0007\u001aK\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\n\"\u0004\b\u0000\u0010#*\u00020\u00022\u0006\u0010!\u001a\u00020\"2\t\b\u0002\u0010¤\u0001\u001a\u00020\"2\t\b\u0002\u0010¥\u0001\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H#0\u0004H\u0007\u001a\u0018\u0010§\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00050¨\u00010\b*\u00020\u0002\u001a)\u0010©\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u001f*\u00020\u00022\u0007\u0010ª\u0001\u001a\u00020\u0002H\u0086\u0004\u001a]\u0010©\u0001\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001f\"\u0004\b\u0000\u0010\u000e*\u00020\u00022\u0007\u0010ª\u0001\u001a\u00020\u000228\u0010\u000f\u001a4\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(«\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(¬\u0001\u0012\u0004\u0012\u0002H\u000e02H\u0086\b\u001a\u001f\u0010\u00ad\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00100\u001f*\u00020\u0002H\u0007\u001aT\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u0002H#0\u001f\"\u0004\b\u0000\u0010#*\u00020\u000228\u0010\u000f\u001a4\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(«\u0001\u0012\u0014\u0012\u00120\u0005¢\u0006\r\b3\u0012\t\b4\u0012\u0005\b\b(¬\u0001\u0012\u0004\u0012\u0002H#02H\u0087\b¨\u0006®\u0001"}, d2 = {"all", "", "", "predicate", "Lkotlin/Function1;", "", i.a.a.a.m.k.c.f16811b, "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/CharSequence;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "chunked", "", "", "size", "", "R", "chunkedSequence", "count", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAtOrElse", "index", "defaultValue", "elementAtOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "filterIndexedTo", "C", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Appendable;", "filterNot", "filterNotTo", "(Ljava/lang/CharSequence;Ljava/lang/Appendable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "filterTo", "find", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "findLast", "first", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "flatMap", "flatMapTo", "", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "fold", "initial", "operation", "acc", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOfFirst", "indexOfLast", "last", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "", "mapIndexedNotNullTo", "(Ljava/lang/CharSequence;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "maxBy", "", "selector", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "none", "onEach", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "partition", "random", "Lkotlin/random/Random;", "randomOrNull", "(Ljava/lang/CharSequence;Lkotlin/random/Random;)Ljava/lang/Character;", "reduce", "reduceIndexed", "reduceOrNull", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;)Ljava/lang/Character;", "reduceRight", "reduceRightIndexed", "reduceRightOrNull", "reversed", "scan", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "scanIndexed", "(Ljava/lang/CharSequence;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "scanReduce", "scanReduceIndexed", SmsRecordSelectActivity.f19032l, "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sumBy", "sumByDouble", "", "take", "takeLast", "takeLastWhile", "takeWhile", "toCollection", "(Ljava/lang/CharSequence;Ljava/util/Collection;)Ljava/util/Collection;", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toList", "toMutableList", "toSet", "", "windowed", "step", "partialWindows", "windowedSequence", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", DispatchConstants.OTHER, bh.ay, "b", "zipWithNext", "kotlin-stdlib"}, k = 5, mv = {1, 1, 16}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes2.dex */
class e0 extends d0 {

    /* compiled from: Iterables.kt */
    public static final class a implements Iterable<Character>, h.q2.t.q1.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f16678a;

        public a(CharSequence charSequence) {
            this.f16678a = charSequence;
        }

        @Override // java.lang.Iterable
        @i.c.a.d
        public Iterator<Character> iterator() {
            return c0.i(this.f16678a);
        }
    }

    /* compiled from: Sequences.kt */
    public static final class b implements h.x2.m<Character> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f16679a;

        public b(CharSequence charSequence) {
            this.f16679a = charSequence;
        }

        @Override // h.x2.m
        @i.c.a.d
        public Iterator<Character> iterator() {
            return c0.i(this.f16679a);
        }
    }

    /* compiled from: _Strings.kt */
    static final class c extends j0 implements h.q2.s.l<CharSequence, String> {
        public static final c INSTANCE = new c();

        c() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d CharSequence charSequence) {
            h.q2.t.i0.f(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    /* compiled from: _Strings.kt */
    public static final class d<K> implements n0<Character, K> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f16680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h.q2.s.l f16681b;

        public d(CharSequence charSequence, h.q2.s.l lVar) {
            this.f16680a = charSequence;
            this.f16681b = lVar;
        }

        @Override // h.g2.n0
        public /* bridge */ /* synthetic */ Object a(Character ch) {
            return a(ch.charValue());
        }

        @Override // h.g2.n0
        @i.c.a.d
        public Iterator<Character> a() {
            return c0.i(this.f16680a);
        }

        public K a(char c2) {
            return (K) this.f16681b.invoke(Character.valueOf(c2));
        }
    }

    /* compiled from: _Strings.kt */
    static final class e extends j0 implements h.q2.s.l<CharSequence, String> {
        public static final e INSTANCE = new e();

        e() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d CharSequence charSequence) {
            h.q2.t.i0.f(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* compiled from: _Strings.kt */
    static final class f extends j0 implements h.q2.s.l<CharSequence, String> {
        public static final f INSTANCE = new f();

        f() {
            super(1);
        }

        @Override // h.q2.s.l
        @i.c.a.d
        public final String invoke(@i.c.a.d CharSequence charSequence) {
            h.q2.t.i0.f(charSequence, "it");
            return charSequence.toString();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: _Strings.kt */
    static final class g<R> extends j0 implements h.q2.s.l<Integer, R> {
        final /* synthetic */ int $size;
        final /* synthetic */ CharSequence $this_windowedSequence;
        final /* synthetic */ h.q2.s.l $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(CharSequence charSequence, int i2, h.q2.s.l lVar) {
            super(1);
            this.$this_windowedSequence = charSequence;
            this.$size = i2;
            this.$transform = lVar;
        }

        public final R invoke(int i2) {
            int length = this.$size + i2;
            if (length < 0 || length > this.$this_windowedSequence.length()) {
                length = this.$this_windowedSequence.length();
            }
            return (R) this.$transform.invoke(this.$this_windowedSequence.subSequence(i2, length));
        }

        @Override // h.q2.s.l
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return invoke(num.intValue());
        }
    }

    /* compiled from: _Strings.kt */
    static final class h extends j0 implements h.q2.s.a<h.g2.v> {
        final /* synthetic */ CharSequence $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(CharSequence charSequence) {
            super(0);
            this.$this_withIndex = charSequence;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h.q2.s.a
        @i.c.a.d
        public final h.g2.v invoke() {
            return c0.i(this.$this_withIndex);
        }
    }

    @i.c.a.d
    public static final HashSet<Character> A(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$toHashSet");
        return (HashSet) a(charSequence, new HashSet(b1.b(charSequence.length())));
    }

    @i.c.a.d
    public static final List<Character> B(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$toList");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? C(charSequence) : h.g2.x.a(Character.valueOf(charSequence.charAt(0))) : h.g2.y.b();
    }

    @i.c.a.d
    public static final List<Character> C(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$toMutableList");
        return (List) a(charSequence, new ArrayList(charSequence.length()));
    }

    @i.c.a.d
    public static final Set<Character> D(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$toSet");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? (Set) a(charSequence, new LinkedHashSet(b1.b(charSequence.length()))) : l1.a(Character.valueOf(charSequence.charAt(0))) : m1.a();
    }

    @i.c.a.d
    public static final Iterable<r0<Character>> E(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$withIndex");
        return new s0(new h(charSequence));
    }

    @i.c.a.d
    public static final h.i0<CharSequence, CharSequence> F(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$partition");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new h.i0<>(sb, sb2);
    }

    public static final char G(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$single");
        h.q2.t.i0.f(lVar, "predicate");
        Character chValueOf = null;
        boolean z = false;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                chValueOf = Character.valueOf(cCharAt);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        if (chValueOf != null) {
            return chValueOf.charValue();
        }
        throw new e1("null cannot be cast to non-null type kotlin.Char");
    }

    @i.c.a.e
    public static final Character H(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$singleOrNull");
        h.q2.t.i0.f(lVar, "predicate");
        Character chValueOf = null;
        boolean z = false;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                if (z) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z = true;
            }
        }
        if (z) {
            return chValueOf;
        }
        return null;
    }

    public static final int I(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Integer> lVar) {
        h.q2.t.i0.f(charSequence, "$this$sumBy");
        h.q2.t.i0.f(lVar, "selector");
        int iIntValue = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            iIntValue += lVar.invoke(Character.valueOf(charSequence.charAt(i2))).intValue();
        }
        return iIntValue;
    }

    public static final double J(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Double> lVar) {
        h.q2.t.i0.f(charSequence, "$this$sumByDouble");
        h.q2.t.i0.f(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            dDoubleValue += lVar.invoke(Character.valueOf(charSequence.charAt(i2))).doubleValue();
        }
        return dDoubleValue;
    }

    @i.c.a.d
    public static final CharSequence K(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$takeLastWhile");
        h.q2.t.i0.f(lVar, "predicate");
        for (int iC = c0.c(charSequence); iC >= 0; iC--) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(iC))).booleanValue()) {
                return charSequence.subSequence(iC + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @i.c.a.d
    public static final CharSequence L(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$takeWhile");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(0, i2);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @t0(version = "1.3")
    public static final char a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(charSequence, "$this$random");
        h.q2.t.i0.f(fVar, "random");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(fVar.c(charSequence.length()));
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Character b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.u2.f fVar) {
        h.q2.t.i0.f(charSequence, "$this$randomOrNull");
        h.q2.t.i0.f(fVar, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(fVar.c(charSequence.length())));
    }

    @h.m2.f
    private static final char c(@i.c.a.d CharSequence charSequence, int i2, h.q2.s.l<? super Integer, Character> lVar) {
        return (i2 < 0 || i2 > c0.c(charSequence)) ? lVar.invoke(Integer.valueOf(i2)).charValue() : charSequence.charAt(i2);
    }

    @h.m2.f
    private static final char d(@i.c.a.d CharSequence charSequence, int i2, h.q2.s.l<? super Integer, Character> lVar) {
        return (i2 < 0 || i2 > c0.c(charSequence)) ? lVar.invoke(Integer.valueOf(i2)).charValue() : charSequence.charAt(i2);
    }

    @i.c.a.d
    public static final CharSequence e(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$drop");
        if (i2 >= 0) {
            return charSequence.subSequence(h.v2.q.b(i2, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @i.c.a.d
    public static final String f(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$drop");
        if (i2 >= 0) {
            String strSubstring = str.substring(h.v2.q.b(i2, str.length()));
            h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @h.m2.f
    private static final Character g(@i.c.a.d CharSequence charSequence, int i2) {
        return h(charSequence, i2);
    }

    @i.c.a.e
    public static final Character h(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$getOrNull");
        if (i2 < 0 || i2 > c0.c(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i2));
    }

    @i.c.a.d
    public static final CharSequence i(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$take");
        if (i2 >= 0) {
            return charSequence.subSequence(0, h.v2.q.b(i2, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @i.c.a.d
    public static final CharSequence j(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$dropLastWhile");
        h.q2.t.i0.f(lVar, "predicate");
        for (int iC = c0.c(charSequence); iC >= 0; iC--) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(iC))).booleanValue()) {
                return charSequence.subSequence(0, iC + 1);
            }
        }
        return "";
    }

    @i.c.a.d
    public static final CharSequence k(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$dropWhile");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return charSequence.subSequence(i2, charSequence.length());
            }
        }
        return "";
    }

    @i.c.a.d
    public static final CharSequence l(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filter");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    @i.c.a.d
    public static final CharSequence m(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filterNot");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        return sb;
    }

    @h.m2.f
    private static final String n(@i.c.a.d String str) {
        if (str != null) {
            return x(str).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static final char o(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$first");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final char p(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$first");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @i.c.a.e
    public static final Character q(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$firstOrNull");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @i.c.a.e
    public static final Character r(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$lastOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final void s(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, y1> lVar) {
        h.q2.t.i0.f(charSequence, "$this$forEach");
        h.q2.t.i0.f(lVar, "action");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
        }
    }

    @i.c.a.d
    public static final <K> Map<K, List<Character>> t(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar) {
        h.q2.t.i0.f(charSequence, "$this$groupBy");
        h.q2.t.i0.f(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <K> n0<Character, K> u(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar) {
        h.q2.t.i0.f(charSequence, "$this$groupingBy");
        h.q2.t.i0.f(lVar, "keySelector");
        return new d(charSequence, lVar);
    }

    public static final int v(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$indexOfFirst");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int w(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$indexOfLast");
        h.q2.t.i0.f(lVar, "predicate");
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    public static final char x(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        char cCharAt;
        h.q2.t.i0.f(charSequence, "$this$last");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
            }
            cCharAt = charSequence.charAt(length);
        } while (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue());
        return cCharAt;
    }

    @i.c.a.e
    public static final Character y(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        char cCharAt;
        h.q2.t.i0.f(charSequence, "$this$lastOrNull");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            cCharAt = charSequence.charAt(length);
        } while (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue());
        return Character.valueOf(cCharAt);
    }

    @i.c.a.e
    public static final Character z(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @i.c.a.d
    public static final <R> List<R> A(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$mapNotNull");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @i.c.a.e
    public static final <R extends Comparable<? super R>> Character C(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$minBy");
        h.q2.t.i0.f(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (iC == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) > 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @t0(version = "1.1")
    @i.c.a.d
    public static final <S extends CharSequence> S E(@i.c.a.d S s, @i.c.a.d h.q2.s.l<? super Character, y1> lVar) {
        h.q2.t.i0.f(s, "$this$onEach");
        h.q2.t.i0.f(lVar, "action");
        for (int i2 = 0; i2 < s.length(); i2++) {
            lVar.invoke(Character.valueOf(s.charAt(i2)));
        }
        return s;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <V, M extends Map<? super Character, ? super V>> M c(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associateWithTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "valueSelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m2.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return m2;
    }

    @i.c.a.d
    public static final String d(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$dropLastWhile");
        h.q2.t.i0.f(lVar, "predicate");
        for (int iC = c0.c((CharSequence) str); iC >= 0; iC--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(iC))).booleanValue()) {
                String strSubstring = str.substring(0, iC + 1);
                h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @i.c.a.d
    public static final String g(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$dropLast");
        if (i2 >= 0) {
            return h(str, h.v2.q.a(str.length() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @i.c.a.d
    public static final String h(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$take");
        if (i2 >= 0) {
            String strSubstring = str.substring(0, h.v2.q.b(i2, str.length()));
            h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @h.m2.f
    private static final Character n(@i.c.a.d CharSequence charSequence, h.q2.s.l<? super Character, Boolean> lVar) {
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    public static final char q(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$last");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(c0.c(charSequence));
    }

    @i.c.a.d
    public static final <R> List<R> r(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        h.q2.t.i0.f(charSequence, "$this$flatMap");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            h.g2.d0.a((Collection) arrayList, (Iterable) lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.e
    public static final Character s(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$max");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt < cCharAt2) {
                    cCharAt = cCharAt2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final boolean u(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$none");
        return charSequence.length() == 0;
    }

    @i.c.a.d
    public static final <R> List<R> z(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$map");
        h.q2.t.i0.f(lVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            arrayList.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <C extends Appendable> C b(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filterTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "predicate");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
        }
        return c2;
    }

    @i.c.a.d
    public static final String e(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$dropWhile");
        h.q2.t.i0.f(lVar, "predicate");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                String strSubstring = str.substring(i2);
                h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @i.c.a.d
    public static final CharSequence f(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$dropLast");
        if (i2 >= 0) {
            return i(charSequence, h.v2.q.a(charSequence.length() - i2, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @i.c.a.d
    public static final String i(@i.c.a.d String str, int i2) {
        h.q2.t.i0.f(str, "$this$takeLast");
        if (i2 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - h.v2.q.b(i2, length));
            h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @i.c.a.e
    public static final Character p(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @h.m2.f
    @t0(version = "1.3")
    private static final char v(@i.c.a.d CharSequence charSequence) {
        return a(charSequence, h.u2.f.f16499c);
    }

    @h.m2.f
    @t0(version = "1.3")
    @h.j
    private static final Character w(@i.c.a.d CharSequence charSequence) {
        return b(charSequence, h.u2.f.f16499c);
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filterIndexed");
        h.q2.t.i0.f(pVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        return sb;
    }

    @i.c.a.d
    public static final <R> List<R> c(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$mapIndexed");
        h.q2.t.i0.f(pVar, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(pVar.invoke(numValueOf, Character.valueOf(cCharAt)));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final String g(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(str, "$this$filterNot");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "filterNotTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @t0(version = "1.3")
    @i.c.a.d
    public static final <V> Map<Character, V> h(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associateWith");
        h.q2.t.i0.f(lVar, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.v2.q.a(b1.b(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(Character.valueOf(cCharAt), lVar.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @i.c.a.d
    public static final CharSequence j(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$takeLast");
        if (i2 >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - h.v2.q.b(i2, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    @h.m2.f
    private static final Character o(@i.c.a.d CharSequence charSequence, h.q2.s.l<? super Character, Boolean> lVar) {
        char cCharAt;
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return null;
            }
            cCharAt = charSequence.charAt(length);
        } while (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue());
        return Character.valueOf(cCharAt);
    }

    public static final char y(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$single");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @i.c.a.e
    public static final <R extends Comparable<? super R>> Character B(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$maxBy");
        h.q2.t.i0.f(lVar, "selector");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (iC == 0) {
            return Character.valueOf(cCharAt);
        }
        R rInvoke = lVar.invoke(Character.valueOf(cCharAt));
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                R rInvoke2 = lVar.invoke(Character.valueOf(cCharAt2));
                if (rInvoke.compareTo(rInvoke2) < 0) {
                    cCharAt = cCharAt2;
                    rInvoke = rInvoke2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final boolean D(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$none");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @i.c.a.d
    public static final CharSequence d(@i.c.a.d CharSequence charSequence, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(charSequence, "$this$slice");
        h.q2.t.i0.f(kVar, "indices");
        return kVar.isEmpty() ? "" : c0.b(charSequence, kVar);
    }

    @i.c.a.d
    public static final String f(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(str, "$this$filter");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @i.c.a.d
    public static final CharSequence x(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$reversed");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        h.q2.t.i0.a((Object) sbReverse, "StringBuilder(this).reverse()");
        return sbReverse;
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M b(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends h.i0<? extends K, ? extends V>> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associateTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            h.i0<? extends K, ? extends V> i0VarInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            m2.put(i0VarInvoke.getFirst(), i0VarInvoke.getSecond());
        }
        return m2;
    }

    public static final boolean e(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$any");
        return !(charSequence.length() == 0);
    }

    @i.c.a.d
    public static final String i(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$takeLastWhile");
        h.q2.t.i0.f(lVar, "predicate");
        for (int iC = c0.c((CharSequence) str); iC >= 0; iC--) {
            if (!lVar.invoke(Character.valueOf(str.charAt(iC))).booleanValue()) {
                String strSubstring = str.substring(iC + 1);
                h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        h.q2.t.i0.f(str, "$this$filterIndexed");
        h.q2.t.i0.f(pVar, "predicate");
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        String string = sb.toString();
        h.q2.t.i0.a((Object) string, "filterIndexedTo(StringBu…(), predicate).toString()");
        return string;
    }

    @i.c.a.d
    public static final <R, C extends Collection<? super R>> C c(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$mapTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            c2.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return c2;
    }

    @i.c.a.d
    public static final <K, M extends Map<? super K, List<Character>>> M d(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar) {
        h.q2.t.i0.f(charSequence, "$this$groupByTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "keySelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = m2.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m2.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return m2;
    }

    public static final boolean e(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$any");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @i.c.a.d
    public static final <K> Map<K, Character> g(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associateBy");
        h.q2.t.i0.f(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.v2.q.a(b1.b(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @h.m2.f
    private static final int h(@i.c.a.d CharSequence charSequence) {
        return charSequence.length();
    }

    @i.c.a.d
    public static final String j(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$takeWhile");
        h.q2.t.i0.f(lVar, "predicate");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!lVar.invoke(Character.valueOf(str.charAt(i2))).booleanValue()) {
                String strSubstring = str.substring(0, i2);
                h.q2.t.i0.a((Object) strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final List<h.i0<Character, Character>> F(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$zipWithNext");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return h.g2.y.b();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            i2++;
            arrayList.add(c1.a(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <K, V> Map<K, List<V>> b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar2) {
        h.q2.t.i0.f(charSequence, "$this$groupBy");
        h.q2.t.i0.f(lVar, "keySelector");
        h.q2.t.i0.f(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            List<V> arrayList = linkedHashMap.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kInvoke, arrayList);
            }
            arrayList.add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final char e(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, Character> pVar) {
        h.q2.t.i0.f(charSequence, "$this$reduce");
        h.q2.t.i0.f(pVar, "operation");
        int i2 = 1;
        if (!(charSequence.length() == 0)) {
            char cCharAt = charSequence.charAt(0);
            int iC = c0.c(charSequence);
            if (1 <= iC) {
                while (true) {
                    cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                    if (i2 == iC) {
                        break;
                    }
                    i2++;
                }
            }
            return cCharAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Character h(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, Character> pVar) {
        h.q2.t.i0.f(charSequence, "$this$reduceRightOrNull");
        h.q2.t.i0.f(pVar, "operation");
        int iC = c0.c(charSequence);
        if (iC < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iC);
        for (int i2 = iC - 1; i2 >= 0; i2--) {
            cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final <R> List<R> c(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.p<? super R, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$scan");
        h.q2.t.i0.f(pVar, "operation");
        if (charSequence.length() == 0) {
            return h.g2.x.a(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            r = pVar.invoke(r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    public static final int i(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$count");
        h.q2.t.i0.f(lVar, "predicate");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (lVar.invoke(Character.valueOf(charSequence.charAt(i3))).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @i.c.a.e
    public static final Character t(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$min");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt > cCharAt2) {
                    cCharAt = cCharAt2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> f(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends h.i0<? extends K, ? extends V>> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associate");
        h.q2.t.i0.f(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.v2.q.a(b1.b(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            h.i0<? extends K, ? extends V> i0VarInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            linkedHashMap.put(i0VarInvoke.getFirst(), i0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final List<Character> i(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, Character> pVar) {
        h.q2.t.i0.f(charSequence, "$this$scanReduce");
        h.q2.t.i0.f(pVar, "operation");
        if (charSequence.length() == 0) {
            return h.g2.y.b();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final <R> List<R> j(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$zipWithNext");
        h.q2.t.i0.f(pVar, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return h.g2.y.b();
        }
        ArrayList arrayList = new ArrayList(length);
        int i2 = 0;
        while (i2 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i2));
            i2++;
            arrayList.add(pVar.invoke(chValueOf, Character.valueOf(charSequence.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <C extends Appendable> C a(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filterNotTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if (!lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
        }
        return c2;
    }

    public static final char g(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, Character> pVar) {
        h.q2.t.i0.f(charSequence, "$this$reduceRight");
        h.q2.t.i0.f(pVar, "operation");
        int iC = c0.c(charSequence);
        if (iC >= 0) {
            char cCharAt = charSequence.charAt(iC);
            for (int i2 = iC - 1; i2 >= 0; i2--) {
                cCharAt = pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
            }
            return cCharAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @i.c.a.d
    public static final String a(@i.c.a.d String str, @i.c.a.d h.v2.k kVar) {
        h.q2.t.i0.f(str, "$this$slice");
        h.q2.t.i0.f(kVar, "indices");
        return kVar.isEmpty() ? "" : c0.b(str, kVar);
    }

    @i.c.a.d
    public static final h.i0<String, String> h(@i.c.a.d String str, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(str, "$this$partition");
        h.q2.t.i0.f(lVar, "predicate");
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (lVar.invoke(Character.valueOf(cCharAt)).booleanValue()) {
                sb.append(cCharAt);
            } else {
                sb2.append(cCharAt);
            }
        }
        return new h.i0<>(sb.toString(), sb2.toString());
    }

    @i.c.a.d
    public static final CharSequence a(@i.c.a.d CharSequence charSequence, @i.c.a.d Iterable<Integer> iterable) {
        h.q2.t.i0.f(charSequence, "$this$slice");
        h.q2.t.i0.f(iterable, "indices");
        int iA = h.g2.z.a(iterable, 10);
        if (iA == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iA);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(charSequence.charAt(it.next().intValue()));
        }
        return sb;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final <R> List<R> c(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        h.q2.t.i0.f(charSequence, "$this$scanIndexed");
        h.q2.t.i0.f(qVar, "operation");
        if (charSequence.length() == 0) {
            return h.g2.x.a(r);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r);
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            r = qVar.invoke(Integer.valueOf(i2), r, Character.valueOf(charSequence.charAt(i2)));
            arrayList.add(r);
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <R> List<R> d(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$mapIndexedNotNull");
        h.q2.t.i0.f(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.e
    public static final Character f(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Character, ? super Character, Character> pVar) {
        h.q2.t.i0.f(charSequence, "$this$reduceOrNull");
        h.q2.t.i0.f(pVar, "operation");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (1 <= iC) {
            while (true) {
                cCharAt = pVar.invoke(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @i.c.a.d
    public static final h.x2.m<Character> g(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$asSequence");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return h.x2.s.b();
            }
        }
        return new b(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i.c.a.d
    public static final <K, V, M extends Map<? super K, List<V>>> M b(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar2) {
        h.q2.t.i0.f(charSequence, "$this$groupByTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "keySelector");
        h.q2.t.i0.f(lVar2, "valueTransform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            K kInvoke = lVar.invoke(Character.valueOf(cCharAt));
            Object arrayList = m2.get(kInvoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                m2.put(kInvoke, arrayList);
            }
            ((List) arrayList).add(lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m2;
    }

    public static final boolean d(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, Boolean> lVar) {
        h.q2.t.i0.f(charSequence, "$this$all");
        h.q2.t.i0.f(lVar, "predicate");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (!lVar.invoke(Character.valueOf(charSequence.charAt(i2))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @h.m2.f
    private static final String a(@i.c.a.d String str, Iterable<Integer> iterable) {
        if (str != null) {
            return a((CharSequence) str, iterable).toString();
        }
        throw new e1("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final h.x2.m<String> d(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$chunkedSequence");
        return b(charSequence, i2, c.INSTANCE);
    }

    @i.c.a.d
    public static final <K, V> Map<K, V> a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar2) {
        h.q2.t.i0.f(charSequence, "$this$associateBy");
        h.q2.t.i0.f(lVar, "keySelector");
        h.q2.t.i0.f(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.v2.q.a(b1.b(charSequence.length()), 16));
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            linkedHashMap.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @t0(version = "1.3")
    @h.j
    @i.c.a.d
    public static final List<Character> c(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        h.q2.t.i0.f(charSequence, "$this$scanReduceIndexed");
        h.q2.t.i0.f(qVar, "operation");
        if (charSequence.length() == 0) {
            return h.g2.y.b();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i2 = 1; i2 < length; i2++) {
            cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final List<h.i0<Character, Character>> d(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2) {
        h.q2.t.i0.f(charSequence, "$this$zip");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(c1.a(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(charSequence2.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final Iterable<Character> f(@i.c.a.d CharSequence charSequence) {
        h.q2.t.i0.f(charSequence, "$this$asIterable");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return h.g2.y.b();
            }
        }
        return new a(charSequence);
    }

    @i.c.a.d
    public static final <K, M extends Map<? super K, ? super Character>> M a(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar) {
        h.q2.t.i0.f(charSequence, "$this$associateByTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "keySelector");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m2.put(lVar.invoke(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return m2;
    }

    @i.c.a.d
    public static final <R, C extends Collection<? super R>> C b(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$mapIndexedTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(pVar, "transform");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            c2.add(pVar.invoke(numValueOf, Character.valueOf(cCharAt)));
        }
        return c2;
    }

    @i.c.a.d
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@i.c.a.d CharSequence charSequence, @i.c.a.d M m2, @i.c.a.d h.q2.s.l<? super Character, ? extends K> lVar, @i.c.a.d h.q2.s.l<? super Character, ? extends V> lVar2) {
        h.q2.t.i0.f(charSequence, "$this$associateByTo");
        h.q2.t.i0.f(m2, "destination");
        h.q2.t.i0.f(lVar, "keySelector");
        h.q2.t.i0.f(lVar2, "valueTransform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            m2.put(lVar.invoke(Character.valueOf(cCharAt)), lVar2.invoke(Character.valueOf(cCharAt)));
        }
        return m2;
    }

    public static final <R> R b(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.p<? super Character, ? super R, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$foldRight");
        h.q2.t.i0.f(pVar, "operation");
        for (int iC = c0.c(charSequence); iC >= 0; iC--) {
            r = pVar.invoke(Character.valueOf(charSequence.charAt(iC)), r);
        }
        return r;
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final List<String> c(@i.c.a.d CharSequence charSequence, int i2) {
        h.q2.t.i0.f(charSequence, "$this$chunked");
        return a(charSequence, i2, i2, true);
    }

    @i.c.a.d
    public static final <C extends Collection<? super Character>> C a(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2) {
        h.q2.t.i0.f(charSequence, "$this$toCollection");
        h.q2.t.i0.f(c2, "destination");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            c2.add(Character.valueOf(charSequence.charAt(i2)));
        }
        return c2;
    }

    public static final <R> R b(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.q<? super Integer, ? super Character, ? super R, ? extends R> qVar) {
        h.q2.t.i0.f(charSequence, "$this$foldRightIndexed");
        h.q2.t.i0.f(qVar, "operation");
        for (int iC = c0.c(charSequence); iC >= 0; iC--) {
            r = qVar.invoke(Integer.valueOf(iC), Character.valueOf(charSequence.charAt(iC)), r);
        }
        return r;
    }

    @i.c.a.d
    public static final <R, C extends Collection<? super R>> C a(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        h.q2.t.i0.f(charSequence, "$this$flatMapTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            h.g2.d0.a((Collection) c2, (Iterable) lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return c2;
    }

    public static final void b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, y1> pVar) {
        h.q2.t.i0.f(charSequence, "$this$forEachIndexed");
        h.q2.t.i0.f(pVar, "action");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            pVar.invoke(numValueOf, Character.valueOf(cCharAt));
        }
    }

    @i.c.a.e
    public static final Character b(@i.c.a.d CharSequence charSequence, @i.c.a.d Comparator<? super Character> comparator) {
        h.q2.t.i0.f(charSequence, "$this$minWith");
        h.q2.t.i0.f(comparator, "comparator");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final <R> R a(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.p<? super R, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$fold");
        h.q2.t.i0.f(pVar, "operation");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            r = pVar.invoke(r, Character.valueOf(charSequence.charAt(i2)));
        }
        return r;
    }

    public static final <R> R a(@i.c.a.d CharSequence charSequence, R r, @i.c.a.d h.q2.s.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        h.q2.t.i0.f(charSequence, "$this$foldIndexed");
        h.q2.t.i0.f(qVar, "operation");
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char cCharAt = charSequence.charAt(i3);
            Integer numValueOf = Integer.valueOf(i2);
            i2++;
            r = qVar.invoke(numValueOf, r, Character.valueOf(cCharAt));
        }
        return r;
    }

    @i.c.a.e
    public static final Character a(@i.c.a.d CharSequence charSequence, @i.c.a.d Comparator<? super Character> comparator) {
        h.q2.t.i0.f(charSequence, "$this$maxWith");
        h.q2.t.i0.f(comparator, "comparator");
        int i2 = 1;
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iC = c0.c(charSequence);
        if (1 <= iC) {
            while (true) {
                char cCharAt2 = charSequence.charAt(i2);
                if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                    cCharAt = cCharAt2;
                }
                if (i2 == iC) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(cCharAt);
    }

    public static final char b(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        h.q2.t.i0.f(charSequence, "$this$reduceRightIndexed");
        h.q2.t.i0.f(qVar, "operation");
        int iC = c0.c(charSequence);
        if (iC >= 0) {
            char cCharAt = charSequence.charAt(iC);
            for (int i2 = iC - 1; i2 >= 0; i2--) {
                cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(charSequence.charAt(i2)), Character.valueOf(cCharAt)).charValue();
            }
            return cCharAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    public static final char a(@i.c.a.d CharSequence charSequence, @i.c.a.d h.q2.s.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        h.q2.t.i0.f(charSequence, "$this$reduceIndexed");
        h.q2.t.i0.f(qVar, "operation");
        int i2 = 1;
        if (!(charSequence.length() == 0)) {
            char cCharAt = charSequence.charAt(0);
            int iC = c0.c(charSequence);
            if (1 <= iC) {
                while (true) {
                    cCharAt = qVar.invoke(Integer.valueOf(i2), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i2))).charValue();
                    if (i2 == iC) {
                        break;
                    }
                    i2++;
                }
            }
            return cCharAt;
        }
        throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final <R> h.x2.m<R> b(@i.c.a.d CharSequence charSequence, int i2, @i.c.a.d h.q2.s.l<? super CharSequence, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$chunkedSequence");
        h.q2.t.i0.f(lVar, "transform");
        return b(charSequence, i2, i2, true, (h.q2.s.l) lVar);
    }

    public static /* synthetic */ h.x2.m b(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return b(charSequence, i2, i3, z);
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final h.x2.m<String> b(@i.c.a.d CharSequence charSequence, int i2, int i3, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$windowedSequence");
        return b(charSequence, i2, i3, z, f.INSTANCE);
    }

    public static /* synthetic */ h.x2.m b(CharSequence charSequence, int i2, int i3, boolean z, h.q2.s.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return b(charSequence, i2, i3, z, lVar);
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final <R> h.x2.m<R> b(@i.c.a.d CharSequence charSequence, int i2, int i3, boolean z, @i.c.a.d h.q2.s.l<? super CharSequence, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$windowedSequence");
        h.q2.t.i0.f(lVar, "transform");
        p1.a(i2, i3);
        return h.x2.u.w(h.g2.g0.i(h.v2.q.a((h.v2.i) (z ? c0.b(charSequence) : h.v2.q.d(0, (charSequence.length() - i2) + 1)), i3)), new g(charSequence, i2, lVar));
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final <R> List<R> a(@i.c.a.d CharSequence charSequence, int i2, @i.c.a.d h.q2.s.l<? super CharSequence, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$chunked");
        h.q2.t.i0.f(lVar, "transform");
        return a(charSequence, i2, i2, true, (h.q2.s.l) lVar);
    }

    public static /* synthetic */ List a(CharSequence charSequence, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(charSequence, i2, i3, z);
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final List<String> a(@i.c.a.d CharSequence charSequence, int i2, int i3, boolean z) {
        h.q2.t.i0.f(charSequence, "$this$windowed");
        return a(charSequence, i2, i3, z, e.INSTANCE);
    }

    @i.c.a.d
    public static final <R, C extends Collection<? super R>> C b(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.l<? super Character, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$mapNotNullTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(lVar, "transform");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            R rInvoke = lVar.invoke(Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
        }
        return c2;
    }

    public static /* synthetic */ List a(CharSequence charSequence, int i2, int i3, boolean z, h.q2.s.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 1;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return a(charSequence, i2, i3, z, lVar);
    }

    @t0(version = "1.2")
    @i.c.a.d
    public static final <R> List<R> a(@i.c.a.d CharSequence charSequence, int i2, int i3, boolean z, @i.c.a.d h.q2.s.l<? super CharSequence, ? extends R> lVar) {
        h.q2.t.i0.f(charSequence, "$this$windowed");
        h.q2.t.i0.f(lVar, "transform");
        p1.a(i2, i3);
        int length = charSequence.length();
        int i4 = 0;
        ArrayList arrayList = new ArrayList((length / i3) + (length % i3 == 0 ? 0 : 1));
        while (i4 >= 0 && length > i4) {
            int i5 = i4 + i2;
            if (i5 < 0 || i5 > length) {
                if (!z) {
                    break;
                }
                i5 = length;
            }
            arrayList.add(lVar.invoke(charSequence.subSequence(i4, i5)));
            i4 += i3;
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <V> List<V> a(@i.c.a.d CharSequence charSequence, @i.c.a.d CharSequence charSequence2, @i.c.a.d h.q2.s.p<? super Character, ? super Character, ? extends V> pVar) {
        h.q2.t.i0.f(charSequence, "$this$zip");
        h.q2.t.i0.f(charSequence2, DispatchConstants.OTHER);
        h.q2.t.i0.f(pVar, "transform");
        int iMin = Math.min(charSequence.length(), charSequence2.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i2 = 0; i2 < iMin; i2++) {
            arrayList.add(pVar.invoke(Character.valueOf(charSequence.charAt(i2)), Character.valueOf(charSequence2.charAt(i2))));
        }
        return arrayList;
    }

    @i.c.a.d
    public static final <C extends Appendable> C a(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, Boolean> pVar) throws IOException {
        h.q2.t.i0.f(charSequence, "$this$filterIndexedTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(pVar, "predicate");
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            int i4 = i3 + 1;
            if (pVar.invoke(Integer.valueOf(i3), Character.valueOf(cCharAt)).booleanValue()) {
                c2.append(cCharAt);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @i.c.a.d
    public static final <R, C extends Collection<? super R>> C a(@i.c.a.d CharSequence charSequence, @i.c.a.d C c2, @i.c.a.d h.q2.s.p<? super Integer, ? super Character, ? extends R> pVar) {
        h.q2.t.i0.f(charSequence, "$this$mapIndexedNotNullTo");
        h.q2.t.i0.f(c2, "destination");
        h.q2.t.i0.f(pVar, "transform");
        int i2 = 0;
        int i3 = 0;
        while (i2 < charSequence.length()) {
            int i4 = i3 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i3), Character.valueOf(charSequence.charAt(i2)));
            if (rInvoke != null) {
                c2.add(rInvoke);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }
}
