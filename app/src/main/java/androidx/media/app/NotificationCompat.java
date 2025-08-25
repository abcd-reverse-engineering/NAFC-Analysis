package androidx.media.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.media.R;

/* loaded from: classes.dex */
public class NotificationCompat {

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        private void setBackgroundColor(RemoteViews remoteViews) {
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", this.mBuilder.getColor() != 0 ? this.mBuilder.getColor() : this.mBuilder.mContext.getResources().getColor(R.color.notification_material_background_media_default_color));
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 24) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.DecoratedMediaCustomViewStyle()));
            } else {
                super.apply(notificationBuilderWithBuilderAccessor);
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getBigContentViewLayoutResource(int i2) {
            return i2 <= 3 ? R.layout.notification_template_big_media_narrow_custom : R.layout.notification_template_big_media_custom;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle
        int getContentViewLayoutResource() {
            return this.mBuilder.getContentView() != null ? R.layout.notification_template_media_custom : super.getContentViewLayoutResource();
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews bigContentView = this.mBuilder.getBigContentView() != null ? this.mBuilder.getBigContentView() : this.mBuilder.getContentView();
            if (bigContentView == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, bigContentView);
            if (Build.VERSION.SDK_INT >= 21) {
                setBackgroundColor(remoteViewsGenerateBigContentView);
            }
            return remoteViewsGenerateBigContentView;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            boolean z = true;
            boolean z2 = this.mBuilder.getContentView() != null;
            if (Build.VERSION.SDK_INT >= 21) {
                if (!z2 && this.mBuilder.getBigContentView() == null) {
                    z = false;
                }
                if (z) {
                    RemoteViews remoteViewsGenerateContentView = generateContentView();
                    if (z2) {
                        buildIntoRemoteViews(remoteViewsGenerateContentView, this.mBuilder.getContentView());
                    }
                    setBackgroundColor(remoteViewsGenerateContentView);
                    return remoteViewsGenerateContentView;
                }
            } else {
                RemoteViews remoteViewsGenerateContentView2 = generateContentView();
                if (z2) {
                    buildIntoRemoteViews(remoteViewsGenerateContentView2, this.mBuilder.getContentView());
                    return remoteViewsGenerateContentView2;
                }
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) throws Resources.NotFoundException {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews headsUpContentView = this.mBuilder.getHeadsUpContentView() != null ? this.mBuilder.getHeadsUpContentView() : this.mBuilder.getContentView();
            if (headsUpContentView == null) {
                return null;
            }
            RemoteViews remoteViewsGenerateBigContentView = generateBigContentView();
            buildIntoRemoteViews(remoteViewsGenerateBigContentView, headsUpContentView);
            if (Build.VERSION.SDK_INT >= 21) {
                setBackgroundColor(remoteViewsGenerateBigContentView);
            }
            return remoteViewsGenerateBigContentView;
        }
    }

    private NotificationCompat() {
    }

    public static class MediaStyle extends NotificationCompat.Style {
        private static final int MAX_MEDIA_BUTTONS = 5;
        private static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;
        int[] mActionsToShowInCompact = null;
        PendingIntent mCancelButtonIntent;
        boolean mShowCancelButton;
        MediaSessionCompat.Token mToken;

        public MediaStyle() {
        }

        private RemoteViews generateMediaActionButton(NotificationCompat.Action action) {
            boolean z = action.getActionIntent() == null;
            RemoteViews remoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), R.layout.notification_media_action);
            remoteViews.setImageViewResource(R.id.action0, action.getIcon());
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, action.getActionIntent());
            }
            if (Build.VERSION.SDK_INT >= 15) {
                remoteViews.setContentDescription(R.id.action0, action.getTitle());
            }
            return remoteViews;
        }

        public static MediaSessionCompat.Token getMediaSession(Notification notification) {
            Bundle extras = androidx.core.app.NotificationCompat.getExtras(notification);
            if (extras == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Parcelable parcelable = extras.getParcelable(androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
                if (parcelable != null) {
                    return MediaSessionCompat.Token.fromToken(parcelable);
                }
                return null;
            }
            IBinder binder = BundleCompat.getBinder(extras, androidx.core.app.NotificationCompat.EXTRA_MEDIA_SESSION);
            if (binder == null) {
                return null;
            }
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeStrongBinder(binder);
            parcelObtain.setDataPosition(0);
            MediaSessionCompat.Token tokenCreateFromParcel = MediaSessionCompat.Token.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
            return tokenCreateFromParcel;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                notificationBuilderWithBuilderAccessor.getBuilder().setStyle(fillInMediaStyle(new Notification.MediaStyle()));
            } else if (this.mShowCancelButton) {
                notificationBuilderWithBuilderAccessor.getBuilder().setOngoing(true);
            }
        }

        @RequiresApi(21)
        Notification.MediaStyle fillInMediaStyle(Notification.MediaStyle mediaStyle) {
            int[] iArr = this.mActionsToShowInCompact;
            if (iArr != null) {
                mediaStyle.setShowActionsInCompactView(iArr);
            }
            MediaSessionCompat.Token token = this.mToken;
            if (token != null) {
                mediaStyle.setMediaSession((MediaSession.Token) token.getToken());
            }
            return mediaStyle;
        }

        RemoteViews generateBigContentView() throws Resources.NotFoundException {
            int iMin = Math.min(this.mBuilder.mActions.size(), 5);
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getBigContentViewLayoutResource(iMin), false);
            remoteViewsApplyStandardTemplate.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    remoteViewsApplyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(i2)));
                }
            }
            if (this.mShowCancelButton) {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
                remoteViewsApplyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
                remoteViewsApplyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
            } else {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsApplyStandardTemplate;
        }

        RemoteViews generateContentView() throws Resources.NotFoundException {
            RemoteViews remoteViewsApplyStandardTemplate = applyStandardTemplate(false, getContentViewLayoutResource(), true);
            int size = this.mBuilder.mActions.size();
            int[] iArr = this.mActionsToShowInCompact;
            int iMin = iArr == null ? 0 : Math.min(iArr.length, 3);
            remoteViewsApplyStandardTemplate.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    if (i2 >= size) {
                        throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                    }
                    remoteViewsApplyStandardTemplate.addView(R.id.media_actions, generateMediaActionButton(this.mBuilder.mActions.get(this.mActionsToShowInCompact[i2])));
                }
            }
            if (this.mShowCancelButton) {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.end_padder, 8);
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 0);
                remoteViewsApplyStandardTemplate.setOnClickPendingIntent(R.id.cancel_action, this.mCancelButtonIntent);
                remoteViewsApplyStandardTemplate.setInt(R.id.cancel_action, "setAlpha", this.mBuilder.mContext.getResources().getInteger(R.integer.cancel_button_image_alpha));
            } else {
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.end_padder, 0);
                remoteViewsApplyStandardTemplate.setViewVisibility(R.id.cancel_action, 8);
            }
            return remoteViewsApplyStandardTemplate;
        }

        int getBigContentViewLayoutResource(int i2) {
            return i2 <= 3 ? R.layout.notification_template_big_media_narrow : R.layout.notification_template_big_media;
        }

        int getContentViewLayoutResource() {
            return R.layout.notification_template_media;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return generateBigContentView();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 21) {
                return null;
            }
            return generateContentView();
        }

        public MediaStyle setCancelButtonIntent(PendingIntent pendingIntent) {
            this.mCancelButtonIntent = pendingIntent;
            return this;
        }

        public MediaStyle setMediaSession(MediaSessionCompat.Token token) {
            this.mToken = token;
            return this;
        }

        public MediaStyle setShowActionsInCompactView(int... iArr) {
            this.mActionsToShowInCompact = iArr;
            return this;
        }

        public MediaStyle setShowCancelButton(boolean z) {
            if (Build.VERSION.SDK_INT < 21) {
                this.mShowCancelButton = z;
            }
            return this;
        }

        public MediaStyle(NotificationCompat.Builder builder) {
            setBuilder(builder);
        }
    }
}
