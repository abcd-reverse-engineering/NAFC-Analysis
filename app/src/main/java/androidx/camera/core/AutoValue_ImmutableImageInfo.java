package androidx.camera.core;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
final class AutoValue_ImmutableImageInfo extends ImmutableImageInfo {
    private final int rotationDegrees;
    private final Object tag;
    private final long timestamp;

    AutoValue_ImmutableImageInfo(@Nullable Object obj, long j2, int i2) {
        this.tag = obj;
        this.timestamp = j2;
        this.rotationDegrees = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableImageInfo)) {
            return false;
        }
        ImmutableImageInfo immutableImageInfo = (ImmutableImageInfo) obj;
        Object obj2 = this.tag;
        if (obj2 != null ? obj2.equals(immutableImageInfo.getTag()) : immutableImageInfo.getTag() == null) {
            if (this.timestamp == immutableImageInfo.getTimestamp() && this.rotationDegrees == immutableImageInfo.getRotationDegrees()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    @Nullable
    public Object getTag() {
        return this.tag;
    }

    @Override // androidx.camera.core.ImmutableImageInfo, androidx.camera.core.ImageInfo
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        Object obj = this.tag;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        long j2 = this.timestamp;
        return ((((iHashCode ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.rotationDegrees;
    }

    public String toString() {
        return "ImmutableImageInfo{tag=" + this.tag + ", timestamp=" + this.timestamp + ", rotationDegrees=" + this.rotationDegrees + "}";
    }
}
