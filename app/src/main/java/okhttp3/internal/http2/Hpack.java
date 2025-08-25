package okhttp3.internal.http2;

import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.taobao.accs.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import h.f1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes2.dex */
final class Hpack {
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, "GET"), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, HttpConstant.HTTP), new Header(Header.TARGET_SCHEME, HttpConstant.HTTPS), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header(Constants.KEY_HOST, ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header(RequestParameters.SUBRESOURCE_REFERER, ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header(SocializeProtocolConstants.PROTOCOL_KEY_VERIFY_MEDIA, ""), new Header("www-authenticate", "")};
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i2, Source source) {
            this(i2, i2, source);
        }

        private void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 < i3) {
                if (i2 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i3 - i2);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i2) {
            return this.nextHeaderIndex + 1 + i2;
        }

        private int evictToRecoverBytes(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i2 <= 0) {
                        break;
                    }
                    Header[] headerArr = this.dynamicTable;
                    i2 -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr2 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i4 + 1, headerArr2, i4 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private ByteString getName(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                return Hpack.STATIC_HEADER_TABLE[i2].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void insertIntoDynamicTable(int i2, Header header) {
            this.headerList.add(header);
            int i3 = header.hpackSize;
            if (i2 != -1) {
                i3 -= this.dynamicTable[dynamicTableIndex(i2)].hpackSize;
            }
            int i4 = this.maxDynamicTableByteCount;
            if (i3 > i4) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i4);
            if (i2 == -1) {
                int i5 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i5 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i6 = this.nextHeaderIndex;
                this.nextHeaderIndex = i6 - 1;
                this.dynamicTable[i6] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i2 + dynamicTableIndex(i2) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i3;
        }

        private boolean isStaticHeader(int i2) {
            return i2 >= 0 && i2 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & f1.f16099c;
        }

        private void readIndexedHeader(int i2) throws IOException {
            if (isStaticHeader(i2)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i2]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i2 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i2) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i2) throws IOException {
            this.headerList.add(new Header(getName(i2), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        ByteString readByteString() throws IOException {
            int i2 = readByte();
            boolean z = (i2 & 128) == 128;
            int i3 = readInt(i2, 127);
            return z ? ByteString.of(Huffman.get().decode(this.source.readByteArray(i3))) : this.source.readByteString(i3);
        }

        void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int i2 = this.source.readByte() & f1.f16099c;
                if (i2 == 128) {
                    throw new IOException("index == 0");
                }
                if ((i2 & 128) == 128) {
                    readIndexedHeader(readInt(i2, 127) - 1);
                } else if (i2 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((i2 & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i2, 63) - 1);
                } else if ((i2 & 32) == 32) {
                    this.maxDynamicTableByteCount = readInt(i2, 31);
                    int i3 = this.maxDynamicTableByteCount;
                    if (i3 < 0 || i3 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (i2 == 16 || i2 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i2, 15) - 1);
                }
            }
        }

        int readInt(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int i6 = readByte();
                if ((i6 & 128) == 0) {
                    return i3 + (i6 << i5);
                }
                i3 += (i6 & 127) << i5;
                i5 += 7;
            }
        }

        Reader(int i2, int i3, Source source) {
            this.headerList = new ArrayList();
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i3;
            this.source = Okio.buffer(source);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
            int i2 = this.maxDynamicTableByteCount;
            int i3 = this.dynamicTableByteCount;
            if (i2 < i3) {
                if (i2 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i3 - i2);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    if (length < this.nextHeaderIndex || i2 <= 0) {
                        break;
                    }
                    Header[] headerArr = this.dynamicTable;
                    i2 -= headerArr[length].hpackSize;
                    this.dynamicTableByteCount -= headerArr[length].hpackSize;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr2 = this.dynamicTable;
                int i4 = this.nextHeaderIndex;
                System.arraycopy(headerArr2, i4 + 1, headerArr2, i4 + 1 + i3, this.headerCount);
                Header[] headerArr3 = this.dynamicTable;
                int i5 = this.nextHeaderIndex;
                Arrays.fill(headerArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private void insertIntoDynamicTable(Header header) {
            int i2 = header.hpackSize;
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            int i4 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i4 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i5 = this.nextHeaderIndex;
            this.nextHeaderIndex = i5 - 1;
            this.dynamicTable[i5] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i2;
        }

        void setHeaderTableSizeSetting(int i2) {
            this.headerTableSizeSetting = i2;
            int iMin = Math.min(i2, 16384);
            int i3 = this.maxDynamicTableByteCount;
            if (i3 == iMin) {
                return;
            }
            if (iMin < i3) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), 127, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString byteString2 = buffer.readByteString();
            writeInt(byteString2.size(), 127, 128);
            this.out.write(byteString2);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void writeHeaders(java.util.List<okhttp3.internal.http2.Header> r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        void writeInt(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.out.writeByte(i2 | i4);
                return;
            }
            this.out.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.out.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.out.writeByte(i5);
        }

        Writer(int i2, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i2;
            this.maxDynamicTableByteCount = i2;
            this.useCompression = z;
            this.out = buffer;
        }
    }

    private Hpack() {
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i2 = 0; i2 < size; i2++) {
            byte b2 = byteString.getByte(i2);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i2 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i2 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i2].name)) {
                linkedHashMap.put(STATIC_HEADER_TABLE[i2].name, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
