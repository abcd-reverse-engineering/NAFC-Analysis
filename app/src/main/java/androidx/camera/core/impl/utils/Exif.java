package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import c.c.a.b.a.a;
import com.luck.picture.lib.widget.longimage.SubsamplingScaleImageView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Exif {
    public static final long INVALID_TIMESTAMP = -1;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.1
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.2
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss", Locale.US);
        }
    };
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>() { // from class: androidx.camera.core.impl.utils.Exif.3
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        }
    };

    private static final class Speed {

        static final class Converter {
            final double mMph;

            Converter(double d2) {
                this.mMph = d2;
            }

            double toKilometersPerHour() {
                return this.mMph / 0.621371d;
            }

            double toKnots() {
                return this.mMph / 1.15078d;
            }

            double toMetersPerSecond() {
                return this.mMph / 2.23694d;
            }

            double toMilesPerHour() {
                return this.mMph;
            }
        }

        private Speed() {
        }

        static Converter fromKilometersPerHour(double d2) {
            return new Converter(d2 * 0.621371d);
        }

        static Converter fromKnots(double d2) {
            return new Converter(d2 * 1.15078d);
        }

        static Converter fromMetersPerSecond(double d2) {
            return new Converter(d2 * 2.23694d);
        }

        static Converter fromMilesPerHour(double d2) {
            return new Converter(d2);
        }
    }

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    private void attachLastModifiedTimestamp() throws NumberFormatException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, strConvertToExifDateTime);
        try {
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime()));
        } catch (ParseException unused) {
        }
    }

    private static Date convertFromExifDate(String str) throws ParseException {
        return DATE_FORMAT.get().parse(str);
    }

    private static Date convertFromExifDateTime(String str) throws ParseException {
        return DATETIME_FORMAT.get().parse(str);
    }

    private static Date convertFromExifTime(String str) throws ParseException {
        return TIME_FORMAT.get().parse(str);
    }

    private static String convertToExifDateTime(long j2) {
        return DATETIME_FORMAT.get().format(new Date(j2));
    }

    @NonNull
    public static Exif createFromFile(@NonNull File file) throws IOException {
        return createFromFileString(file.toString());
    }

    @NonNull
    public static Exif createFromFileString(@NonNull String str) throws IOException {
        return new Exif(new ExifInterface(str));
    }

    @NonNull
    public static Exif createFromInputStream(@NonNull InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    private long parseTimestamp(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            return -1L;
        }
        if (str2 == null) {
            try {
                return convertFromExifDate(str).getTime();
            } catch (ParseException unused) {
                return -1L;
            }
        }
        if (str == null) {
            try {
                return convertFromExifTime(str2).getTime();
            } catch (ParseException unused2) {
                return -1L;
            }
        }
        return parseTimestamp(str + a.f3100g + str2);
    }

    public void attachLocation(@NonNull Location location) throws NumberFormatException {
        this.mExifInterface.setGpsInfo(location);
    }

    public void attachTimestamp() throws NumberFormatException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConvertToExifDateTime = convertToExifDateTime(jCurrentTimeMillis);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, strConvertToExifDateTime);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, strConvertToExifDateTime);
        try {
            String string = Long.toString(jCurrentTimeMillis - convertFromExifDateTime(strConvertToExifDateTime).getTime());
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, string);
            this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, string);
        } catch (ParseException unused) {
        }
        this.mRemoveTimestamp = false;
    }

    public void flipHorizontally() throws NumberFormatException {
        int i2;
        switch (getOrientation()) {
            case 2:
                i2 = 1;
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 2;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    public void flipVertically() throws NumberFormatException {
        int i2;
        switch (getOrientation()) {
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                i2 = 1;
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 4;
                break;
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    @Nullable
    public String getDescription() {
        return this.mExifInterface.getAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION);
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, 0);
    }

    public long getLastModifiedTimestamp() throws NumberFormatException {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME);
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j2 = Long.parseLong(attribute);
            while (j2 > 1000) {
                j2 /= 10;
            }
            return timestamp + j2;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    @Nullable
    public Location getLocation() {
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD);
        double[] latLong = this.mExifInterface.getLatLong();
        double altitude = this.mExifInterface.getAltitude(0.0d);
        double attributeDouble = this.mExifInterface.getAttributeDouble(ExifInterface.TAG_GPS_SPEED, 0.0d);
        String attribute2 = this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_SPEED_REF);
        if (attribute2 == null) {
            attribute2 = "K";
        }
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_DATESTAMP), this.mExifInterface.getAttribute(ExifInterface.TAG_GPS_TIMESTAMP));
        if (latLong == null) {
            return null;
        }
        if (attribute == null) {
            attribute = TAG;
        }
        Location location = new Location(attribute);
        location.setLatitude(latLong[0]);
        location.setLongitude(latLong[1]);
        if (altitude != 0.0d) {
            location.setAltitude(altitude);
        }
        if (attributeDouble != 0.0d) {
            char c2 = 65535;
            int iHashCode = attribute2.hashCode();
            if (iHashCode != 75) {
                if (iHashCode != 77) {
                    if (iHashCode == 78 && attribute2.equals("N")) {
                        c2 = 1;
                    }
                } else if (attribute2.equals("M")) {
                    c2 = 0;
                }
            } else if (attribute2.equals("K")) {
                c2 = 2;
            }
            location.setSpeed((float) (c2 != 0 ? c2 != 1 ? Speed.fromKilometersPerHour(attributeDouble).toMetersPerSecond() : Speed.fromKnots(attributeDouble).toMetersPerSecond() : Speed.fromMilesPerHour(attributeDouble).toMetersPerSecond()));
        }
        if (timestamp != -1) {
            location.setTime(timestamp);
        }
        return location;
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
    }

    public int getRotation() {
        switch (getOrientation()) {
            case 2:
                return 0;
            case 3:
            case 4:
                return 180;
            case 5:
                return SubsamplingScaleImageView.ORIENTATION_270;
            case 6:
            case 7:
                return 90;
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    public long getTimestamp() throws NumberFormatException {
        long timestamp = parseTimestamp(this.mExifInterface.getAttribute(ExifInterface.TAG_DATETIME_ORIGINAL));
        if (timestamp == -1) {
            return -1L;
        }
        String attribute = this.mExifInterface.getAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL);
        if (attribute == null) {
            return timestamp;
        }
        try {
            long j2 = Long.parseLong(attribute);
            while (j2 > 1000) {
                j2 /= 10;
            }
            return timestamp + j2;
        } catch (NumberFormatException unused) {
            return timestamp;
        }
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, 0);
    }

    public boolean isFlippedHorizontally() {
        switch (getOrientation()) {
            case 2:
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    public boolean isFlippedVertically() {
        switch (getOrientation()) {
            case 2:
            case 3:
                return false;
            case 4:
            case 5:
                return true;
            case 6:
                return false;
            case 7:
                return true;
            case 8:
            default:
                return false;
        }
    }

    public void removeLocation() throws NumberFormatException {
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_PROCESSING_METHOD, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LATITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_ALTITUDE_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_SPEED_REF, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_DATESTAMP, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_GPS_TIMESTAMP, null);
    }

    public void removeTimestamp() throws NumberFormatException {
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_DATETIME_DIGITIZED, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, null);
        this.mExifInterface.setAttribute(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int i2) throws NumberFormatException {
        if (i2 % 90 != 0) {
            String.format("Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", Integer.valueOf(i2));
            this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(0));
            return;
        }
        int i3 = i2 % 360;
        int orientation = getOrientation();
        while (i3 < 0) {
            i3 += 90;
            switch (orientation) {
                case 2:
                    orientation = 5;
                    break;
                case 3:
                case 8:
                    orientation = 6;
                    break;
                case 4:
                    orientation = 7;
                    break;
                case 5:
                    orientation = 4;
                    break;
                case 6:
                    orientation = 1;
                    break;
                case 7:
                    orientation = 2;
                    break;
                default:
                    orientation = 8;
                    break;
            }
        }
        while (i3 > 0) {
            i3 -= 90;
            switch (orientation) {
                case 2:
                    orientation = 7;
                    break;
                case 3:
                    orientation = 8;
                    break;
                case 4:
                    orientation = 5;
                    break;
                case 5:
                    orientation = 2;
                    break;
                case 6:
                    orientation = 3;
                    break;
                case 7:
                    orientation = 4;
                    break;
                case 8:
                    orientation = 1;
                    break;
                default:
                    orientation = 6;
                    break;
            }
        }
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(orientation));
    }

    public void save() throws Throwable {
        if (!this.mRemoveTimestamp) {
            attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public void setDescription(@Nullable String str) throws NumberFormatException {
        this.mExifInterface.setAttribute(ExifInterface.TAG_IMAGE_DESCRIPTION, str);
    }

    public void setOrientation(int i2) throws NumberFormatException {
        this.mExifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(getRotation()), Boolean.valueOf(isFlippedVertically()), Boolean.valueOf(isFlippedHorizontally()), getLocation(), Long.valueOf(getTimestamp()), getDescription());
    }

    private long parseTimestamp(@Nullable String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return convertFromExifDateTime(str).getTime();
        } catch (ParseException unused) {
            return -1L;
        }
    }
}
