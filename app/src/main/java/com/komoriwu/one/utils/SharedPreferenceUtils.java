package com.komoriwu.one.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Map;

/**
 * Created by KomoriWu
 * on 2017-04-21.
 */

public class SharedPreferenceUtils {
    private static final String SEND_SERVICE_NAME = "send_service_name";
    private static final String SEND_SERVICE_KEY = "send_service_key";
    private static final String SEND_CHARACTER_NAME = "send_character_name";
    private static final String SEND_CHARACTER_KEY = "send_character_key";
    private static final String MAC_ADDRESS_NAME = "mac_address_name";
    private static final String MAC_ADDRESS_KEY = "mac_address_key";
    private static final String TIMER_MIN_NAME = "timer_min_name";
    private static final String TIMER_MIN_KEY = "timer_min_key";
    private static final String PLAYER_STATUE_NAME = "player_statue_name";
    private static final String PLAYER_STATUE_KEY = "player_statue_key";
    private static final String IS_AUTO_CONN_NAME = "is_auto_conn_name";
    private static final String IS_AUTO_CONN_KEY = "is_auto_conn_key";
    private static final String FIRST_IN_NAME = "first_in_name";
    private static final String FIRST_IN_KEY = "first_in_key";

    public static void saveTimerStopTime(Context context, int timerCount) {
        SharedPreferenceUtils.saveSharedPreference(context, TIMER_MIN_NAME,
                TIMER_MIN_KEY, timerCount);
    }

    public static int getTimerStopTime(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceInt(context, TIMER_MIN_NAME,
                TIMER_MIN_KEY);
    }

    public static void saveIsAutoConn(Context context, boolean isAutoConn) {
        SharedPreferenceUtils.saveSharedPreference(context, IS_AUTO_CONN_NAME,
                IS_AUTO_CONN_KEY, isAutoConn);
    }

    public static boolean getIsAutoConn(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceBoolean(context, IS_AUTO_CONN_NAME,
                IS_AUTO_CONN_KEY, false);
    }

    public static void saveMacAddress(Context context, String macAddress) {
        SharedPreferenceUtils.saveSharedPreference(context, MAC_ADDRESS_NAME,
                MAC_ADDRESS_KEY, macAddress);
    }

    public static String getMacAddress(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceString(context, MAC_ADDRESS_NAME,
                MAC_ADDRESS_KEY);
    }

    public static void saveSendService(Context context, String serviceUUID) {
        SharedPreferenceUtils.saveSharedPreference(context, SEND_SERVICE_NAME,
                SEND_SERVICE_KEY, serviceUUID);
    }

    public static String getSendService(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceString(context, SEND_SERVICE_NAME,
                SEND_SERVICE_KEY);
    }


    public static void savePlayerStatue(Context context, boolean playStatue) {
        SharedPreferenceUtils.saveSharedPreference(context, PLAYER_STATUE_NAME,
                PLAYER_STATUE_KEY, playStatue);
    }

    public static boolean getPlayerStatue(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceBoolean(context, PLAYER_STATUE_NAME,
                PLAYER_STATUE_KEY, false);
    }

    public static void saveSendCharacter(Context context, String characterUUID) {
        SharedPreferenceUtils.saveSharedPreference(context, SEND_CHARACTER_NAME,
                SEND_CHARACTER_KEY, characterUUID);
    }

    public static String getSendCharacter(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceString(context, SEND_CHARACTER_NAME,
                SEND_CHARACTER_KEY);
    }

    public static void saveIsFirst(Context context, boolean isFirst) {
        SharedPreferenceUtils.saveSharedPreference(context, FIRST_IN_NAME,
                FIRST_IN_KEY, isFirst);
    }

    public static boolean getIsFirst(Context context) {
        return SharedPreferenceUtils.getSharedPreferenceBoolean(context, FIRST_IN_NAME,
                FIRST_IN_KEY, true);
    }


    public static boolean saveSharedPreference(Context context, String name, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static boolean saveSharedPreference(Context context, String name, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name, Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean saveSharedPreference(Context context, String name, String key, long value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name, Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static boolean saveSharedPreference(Context context, String name, String key, boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static String getSharedPreferenceString(Context context, String name, String key) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getString(key, null);
    }

    public static String getSharedPreferenceString(Context context, String name, String key, String defaultValue) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getString(key, defaultValue);
    }


    public static int getSharedPreferenceInt(Context context, String name, String key) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getInt(key, -1);
    }

    public static int getSharedPreferenceInt(Context context, String name, String key, int defaultValue) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getInt(key, defaultValue);
    }

    public static long getSharedPreferenceLong(Context context, String name, String key) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        try {
            return savedPreference.getLong(key, -1);
        } catch (ClassCastException e) {
            return -1;
        }
    }

    public static long getSharedPreferenceLong(Context context, String name, String key, long defaultValue) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        try {
            return savedPreference.getLong(key, defaultValue);
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public static boolean getSharedPreferenceBoolean(Context context, String name, String key) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getBoolean(key, false);
    }

    public static boolean getSharedPreferenceBoolean(Context context, String name, String key, boolean defaultValue) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getBoolean(key, defaultValue);
    }

    public static boolean removeSharedPreference(Context context, String name, String key) {
        SharedPreferences.Editor editor = context.getSharedPreferences(name, Context.MODE_PRIVATE).edit();
        editor.remove(key);
        return editor.commit();
    }

    public static boolean existSharedPreferenceKey(Context context, String name, String key) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.contains(key);
    }

    public static int getSharedPreferenceSize(Context context, String name) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getAll().size();
    }

    public static Map<String, ?> getSharedPreferenceAll(Context context, String name) {
        SharedPreferences savedPreference = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return savedPreference.getAll();
    }

    public static void setSharedPreferencesFlag(Context context, String title, boolean content) {
        SharedPreferences pre = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pre.edit();
        editor.putBoolean(title, content);
        editor.apply();
    }
}
