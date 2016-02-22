package com.thebluealliance.androidclient.gcm.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.thebluealliance.androidclient.BuildConfig;
import com.thebluealliance.androidclient.Constants;
import com.thebluealliance.androidclient.R;
import com.thebluealliance.androidclient.Utilities;
import com.thebluealliance.androidclient.activities.RecentNotificationsActivity;
import com.thebluealliance.androidclient.helpers.JSONHelper;
import com.thebluealliance.androidclient.models.StoredNotification;

import java.util.Calendar;
import java.util.Date;

public class GenericNotification extends BaseNotification {

    public static final String TITLE = "title";
    public static final String DESC = "desc";
    public static final String URL = "url";
    public static final String APP_VERSION = "app_version";

    protected String title, message;
    protected Uri uri;

    public GenericNotification(String type, String messageData) {
        super(type, messageData);
    }

    @Override
    public boolean shouldShowInRecentNotificationsList() {
        if (getNotificationType().equals(NotificationTypes.BROADCAST)) {
            return true;
        }

        // False for pings
        return false;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void parseMessageData() throws JsonParseException {
        JsonObject jsonData = JSONHelper.getasJsonObject(messageData);
        if (!jsonData.has(TITLE)) {
            throw new JsonParseException("Notification data does not contain 'title'");
        }
        title = jsonData.get(TITLE).getAsString();

        if (!jsonData.has(DESC)) {
            throw new JsonParseException("Notification data does not contain 'desc'");
        }
        message = jsonData.get(DESC).getAsString();

        if (jsonData.has(URL)) {
            uri = Uri.parse(jsonData.get(URL).getAsString());
        }

        if (jsonData.has(APP_VERSION)) {
            int targetVersion = jsonData.get(APP_VERSION).getAsInt();
            int currentVersion = BuildConfig.VERSION_CODE;
            if (currentVersion < targetVersion) {
                // The broadcast is not targeted at this version, don't show it
                Log.d(Constants.LOG_TAG, "Not displaying received broadcast target at version " +
                        targetVersion + " (this is version " + currentVersion + ")");
                display = false;
            }
        }
    }

    @Override
    public Notification buildNotification(Context context) {
        if (getNotificationType().equals(NotificationTypes.BROADCAST)) {
            // Only store broadcasts, not pings
            stored = new StoredNotification();
            stored.setType(getNotificationType());
            stored.setTitle(title);
            stored.setBody(message);
            stored.setMessageData(messageData);
            stored.setTime(Calendar.getInstance().getTime());
        }

        Intent intent = getIntent(context);

        NotificationCompat.Builder builder = getBaseBuilder(context, intent)
                .setContentTitle(title)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message));

        return builder.build();
    }

    @Override
    public Intent getIntent(Context context) {
        Intent intent;
        if (uri != null) {
            intent = Utilities.getIntentForTBAUrl(context, uri);
            if (intent == null) {
                // The URI didn't match anything that TBA can process
                // Pass off the URI to a general View intent
                intent = new Intent(Intent.ACTION_VIEW, uri);

            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                // Nothing can process this URI, pretend it doesn't exist and go on our merry way
                intent = null;
            }
        } else {
            intent = RecentNotificationsActivity.newInstance(context);
        }
        return intent;
    }

    @Override
    public void updateDataLocally() {
        /* No data to be stored locally */
    }

    @Override
    public int getNotificationId() {
        return (new Date().getTime() + ":" + getNotificationType() + ":" + messageData).hashCode();
    }
}
