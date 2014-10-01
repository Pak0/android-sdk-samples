package com.sensorberg.sdk.near;

import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String DEFAULT_API_KEY = "f257de3b91d141aa93b6a9b39c97b83df257de3b91d141aa93b6a9b39c97b83d";
    public static final String API_KEY = "com.sensorberg.apiKey";
    public static final String VIBRATION_ON_NOTIFICATIONS = "com.sensorberg.vibration_on_notifications";
    public static final String FOREGROUND_NOTIFICATIONS = "com.sensorberg.foreground_notifications";

    private SharedPreferences preferences;

    public SharedPreferencesHelper(SharedPreferences preferences){
        this.preferences = preferences;
    }

    public void setAPIKey(String APIKey) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(API_KEY, APIKey);
        editor.commit();
    }

    public String getAPIKey() {
        return preferences.getString(API_KEY, DEFAULT_API_KEY);
    }

    public boolean foreGroundNotificationsEnabled() {
        return preferences.getBoolean(FOREGROUND_NOTIFICATIONS, false);
    }

    public boolean vibrationOnNotificationsEnabled() {
        return preferences.getBoolean(VIBRATION_ON_NOTIFICATIONS, false);
    }

    public void setEnableVibrationOnNotifications(boolean value) {
        saveValueForKey(value, VIBRATION_ON_NOTIFICATIONS);
    }

    public void setForegroundNotificationEnabled(boolean value) {
        saveValueForKey(value, FOREGROUND_NOTIFICATIONS);
    }

    private void saveValueForKey(boolean value, String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
}
