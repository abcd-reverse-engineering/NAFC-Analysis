package c.b.c;

import java.util.List;

/* compiled from: DecodeHintType.java */
/* loaded from: classes.dex */
public enum e {
    OTHER(Object.class),
    PURE_BARCODE(Void.class),
    POSSIBLE_FORMATS(List.class),
    TRY_HARDER(Void.class),
    CHARACTER_SET(String.class),
    ALLOWED_LENGTHS(int[].class),
    ASSUME_CODE_39_CHECK_DIGIT(Void.class),
    ASSUME_GS1(Void.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(u.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> valueType;

    e(Class cls) {
        this.valueType = cls;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
