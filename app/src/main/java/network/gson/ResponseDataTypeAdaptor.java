package network.gson;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.b0.i;
import com.google.gson.d0.a;
import com.google.gson.e;
import com.google.gson.e0.c;
import com.google.gson.e0.d;
import com.google.gson.f;
import com.google.gson.y;
import com.google.gson.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public class ResponseDataTypeAdaptor extends y<ResponseData> {
    public static final z FACTORY = new z() { // from class: network.gson.ResponseDataTypeAdaptor.1
        @Override // com.google.gson.z
        public <T> y<T> create(e eVar, a<T> aVar) {
            if (aVar.getRawType() == ResponseData.class) {
                return new ResponseDataTypeAdaptor(eVar);
            }
            return null;
        }
    };
    private final e gson;

    /* renamed from: network.gson.ResponseDataTypeAdaptor$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = new int[c.values().length];

        static {
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    ResponseDataTypeAdaptor(e eVar) {
        this.gson = eVar;
    }

    public static e buildGson() {
        f fVar = new f();
        fVar.a(FACTORY);
        fVar.b();
        return fVar.a();
    }

    private Object readInternal(com.google.gson.e0.a aVar) throws IOException {
        switch (AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[aVar.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.j()) {
                    arrayList.add(readInternal(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                i iVar = new i();
                aVar.d();
                while (aVar.j()) {
                    iVar.put(aVar.q(), readInternal(aVar));
                }
                aVar.g();
                return iVar;
            case 3:
                return aVar.s();
            case 4:
                String strS = aVar.s();
                return (strS.contains(".") || strS.contains("e") || strS.contains(ExifInterface.LONGITUDE_EAST)) ? Double.valueOf(Double.parseDouble(strS)) : Long.parseLong(strS) <= 2147483647L ? Integer.valueOf(Integer.parseInt(strS)) : Long.valueOf(Long.parseLong(strS));
            case 5:
                return Boolean.valueOf(aVar.m());
            case 6:
                aVar.r();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.y
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public ResponseData read2(com.google.gson.e0.a aVar) throws IOException {
        ResponseData responseData = new ResponseData();
        Map map = (Map) readInternal(aVar);
        responseData.setStatus((Integer) map.get(NotificationCompat.CATEGORY_STATUS));
        responseData.setMsg((String) map.get("msg"));
        responseData.setData(map.get("data"));
        return responseData;
    }

    @Override // com.google.gson.y
    public void write(d dVar, ResponseData responseData) throws IOException {
        if (responseData == null) {
            dVar.j();
            return;
        }
        dVar.d();
        dVar.b(NotificationCompat.CATEGORY_STATUS);
        this.gson.a(Integer.class).write(dVar, responseData.getStatus());
        dVar.b("msg");
        this.gson.a(String.class).write(dVar, responseData.getMsg());
        dVar.b("data");
        this.gson.a(Object.class).write(dVar, responseData.getData());
        dVar.f();
    }
}
