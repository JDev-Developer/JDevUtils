package it.jdev.jdevutils;

import android.util.Log;

public class JConsole {

    private static boolean enableLog = false;
    private static boolean debug = true;
    private static boolean warning = true;
    private static boolean error = true;
    private static boolean info = true;

    public static void d(String tag, String text) {
        if (enableLog && debug) {
            Log.d(tag, text);
        }
    }

    public static void i(String tag, String text) {
        if (enableLog && info) {
            Log.i(tag, text);
        }
    }

    public static void w(String tag, String text) {
        if (enableLog && warning) {
            Log.w(tag, text);
        }
    }

    public static void e(String tag, String text) {
        if (enableLog && error) {
            Log.e(tag, text);
        }
    }

    public static boolean isEnableLog() {
        return enableLog;
    }

    public static void setEnableLog(boolean enableLog) {
        JConsole.enableLog = enableLog;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        JConsole.debug = debug;
    }

    public static boolean isWarning() {
        return warning;
    }

    public static void setWarning(boolean warning) {
        JConsole.warning = warning;
    }

    public static boolean isError() {
        return error;
    }

    public static void setError(boolean error) {
        JConsole.error = error;
    }

    public static boolean isInfo() {
        return info;
    }

    public static void setInfo(boolean info) {
        JConsole.info = info;
    }
}
