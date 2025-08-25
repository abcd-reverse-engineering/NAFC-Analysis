package network.gson;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.b0.i;
import com.google.gson.d0.a;
import com.google.gson.e;
import com.google.gson.e0.c;
import com.google.gson.e0.d;
import com.google.gson.f;
import com.google.gson.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ObjectTypeAdapter extends y<Object> {
    private static final e gson = new e();
    private y objectTypeAdapter = gson.a(Object.class);

    /* renamed from: network.gson.ObjectTypeAdapter$2, reason: invalid class name */
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

    public static e buildNewGson() {
        f fVar = new f();
        fVar.a(new a<Map<String, Object>>() { // from class: network.gson.ObjectTypeAdapter.1
        }.getType(), new ObjectTypeAdapter());
        fVar.b();
        return fVar.a();
    }

    @Override // com.google.gson.y
    /* renamed from: read */
    public Object read2(com.google.gson.e0.a aVar) throws IOException {
        switch (AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[aVar.peek().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.j()) {
                    arrayList.add(read2(aVar));
                }
                aVar.f();
                return arrayList;
            case 2:
                i iVar = new i();
                aVar.d();
                while (aVar.j()) {
                    iVar.put(aVar.q(), read2(aVar));
                }
                aVar.g();
                return iVar;
            case 3:
                return aVar.s();
            case 4:
                String strS = aVar.s();
                return (strS.contains(".") || strS.contains("e") || strS.contains(ExifInterface.LONGITUDE_EAST)) ? Double.valueOf(Double.parseDouble(strS)) : Long.valueOf(Long.parseLong(strS));
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
    public void write(d dVar, Object obj) throws IOException {
        this.objectTypeAdapter.write(dVar, obj);
    }
}
