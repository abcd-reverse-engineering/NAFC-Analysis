package okio;

import h.f1;
import h.g2.d;
import h.q2.h;
import h.q2.t.v;
import h.y;
import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Options.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Options extends d<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);

    @i.c.a.d
    private final ByteString[] byteStrings;

    @i.c.a.d
    private final int[] trie;

    /* compiled from: Options.kt */
    @y(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        private final void buildTrieRecursive(long j2, Buffer buffer, int i2, List<? extends ByteString> list, int i3, int i4, List<Integer> list2) throws IOException {
            int i5;
            int i6;
            int i7;
            int i8;
            Buffer buffer2;
            int i9 = i2;
            if (!(i3 < i4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i10 = i3; i10 < i4; i10++) {
                if (!(list.get(i10).size() >= i9)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i3);
            ByteString byteString2 = list.get(i4 - 1);
            if (i9 == byteString.size()) {
                int iIntValue = list2.get(i3).intValue();
                int i11 = i3 + 1;
                ByteString byteString3 = list.get(i11);
                i5 = i11;
                i6 = iIntValue;
                byteString = byteString3;
            } else {
                i5 = i3;
                i6 = -1;
            }
            if (byteString.getByte(i9) == byteString2.getByte(i9)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i12 = 0;
                for (int i13 = i9; i13 < iMin && byteString.getByte(i13) == byteString2.getByte(i13); i13++) {
                    i12++;
                }
                long intCount = j2 + getIntCount(buffer) + 2 + i12 + 1;
                buffer.writeInt(-i12);
                buffer.writeInt(i6);
                int i14 = i9 + i12;
                while (i9 < i14) {
                    buffer.writeInt(byteString.getByte(i9) & f1.f16099c);
                    i9++;
                }
                if (i5 + 1 == i4) {
                    if (!(i14 == list.get(i5).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer.writeInt(list2.get(i5).intValue());
                    return;
                } else {
                    Buffer buffer3 = new Buffer();
                    buffer.writeInt(((int) (getIntCount(buffer3) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer3, i14, list, i5, i4, list2);
                    buffer.writeAll(buffer3);
                    return;
                }
            }
            int i15 = 1;
            for (int i16 = i5 + 1; i16 < i4; i16++) {
                if (list.get(i16 - 1).getByte(i9) != list.get(i16).getByte(i9)) {
                    i15++;
                }
            }
            long intCount2 = j2 + getIntCount(buffer) + 2 + (i15 * 2);
            buffer.writeInt(i15);
            buffer.writeInt(i6);
            for (int i17 = i5; i17 < i4; i17++) {
                byte b2 = list.get(i17).getByte(i9);
                if (i17 == i5 || b2 != list.get(i17 - 1).getByte(i9)) {
                    buffer.writeInt(b2 & f1.f16099c);
                }
            }
            Buffer buffer4 = new Buffer();
            while (i5 < i4) {
                byte b3 = list.get(i5).getByte(i9);
                int i18 = i5 + 1;
                int i19 = i18;
                while (true) {
                    if (i19 >= i4) {
                        i7 = i4;
                        break;
                    } else {
                        if (b3 != list.get(i19).getByte(i9)) {
                            i7 = i19;
                            break;
                        }
                        i19++;
                    }
                }
                if (i18 == i7 && i9 + 1 == list.get(i5).size()) {
                    buffer.writeInt(list2.get(i5).intValue());
                    i8 = i7;
                    buffer2 = buffer4;
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer4))) * (-1));
                    i8 = i7;
                    buffer2 = buffer4;
                    buildTrieRecursive(intCount2, buffer4, i9 + 1, list, i5, i7, list2);
                }
                buffer4 = buffer2;
                i5 = i8;
            }
            buffer.writeAll(buffer4);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j2, Buffer buffer, int i2, List list, int i3, int i4, List list2, int i5, Object obj) throws IOException {
            companion.buildTrieRecursive((i5 & 1) != 0 ? 0L : j2, buffer, (i5 & 4) != 0 ? 0 : i2, list, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? list.size() : i4, list2);
        }

        private final long getIntCount(@i.c.a.d Buffer buffer) {
            return buffer.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ee, code lost:
        
            continue;
         */
        @h.q2.h
        @i.c.a.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options of(@i.c.a.d okio.ByteString... r17) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 336
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.of(okio.ByteString[]):okio.Options");
        }

        public /* synthetic */ Companion(v vVar) {
            this();
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, v vVar) {
        this(byteStringArr, iArr);
    }

    @h
    @i.c.a.d
    public static final Options of(@i.c.a.d ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // h.g2.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    @i.c.a.d
    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // h.g2.d, h.g2.a
    public int getSize() {
        return this.byteStrings.length;
    }

    @i.c.a.d
    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // h.g2.d, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // h.g2.d, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Object) byteString);
    }

    @Override // h.g2.d, java.util.List
    @i.c.a.d
    public ByteString get(int i2) {
        return this.byteStrings[i2];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Object) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Object) byteString);
    }
}
