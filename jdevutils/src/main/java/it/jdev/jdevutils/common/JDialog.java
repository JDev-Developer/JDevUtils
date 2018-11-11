package it.jdev.jdevutils.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import it.jdev.jdevutils.OnConfirmationDialogCallback;
import it.jdev.jdevutils.R;

public class JDialog {

    private static Dialog dialog;

    private enum DialogType {
        NO_TYPE,
        INFORMATION_TYPE,
        WARNING_TYPE,
        ERROR_TYPE
    }

    private static void showConfirmationDialog(String title, ArrayList<String> list, boolean multichoice, String positiveButton, String negativeButton, Activity activity, final OnConfirmationDialogCallback callback) {

        AlertDialog.Builder confirmationDialog = new AlertDialog.Builder(activity);

        confirmationDialog.setCancelable(false);

        if (title != null && title.length() > 0) {
            confirmationDialog.setTitle(title);
        }
        else {
            confirmationDialog.setTitle(activity.getResources().getString(R.string.do_choice));
        }

        final ArrayAdapter<String> dialogElementList = new ArrayAdapter<>(activity, multichoice ? android.R.layout.select_dialog_multichoice : android.R.layout.select_dialog_singlechoice);
        dialogElementList.addAll(list);

        confirmationDialog.setAdapter(dialogElementList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        confirmationDialog.setPositiveButton(createButtonString(positiveButton, true, activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callback != null) {
                    callback.onPositiveButton(null);
                }
            }
        });

        confirmationDialog.setNegativeButton(createButtonString(negativeButton, false, activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callback != null) {
                    callback.onNegativeButton();
                }
            }
        });

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        });
    }

    private static void showAlertDialog(String title, String message, DialogType dialogType, String positiveButton, String negativeButton, Activity activity, final OnDialogCallback callback) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

        alertDialog.setCancelable(false);

        if (title != null && title.length() > 0) {
            alertDialog.setTitle(title);
        }

        if (message != null && message.length() > 0) {
            alertDialog.setMessage(message);
        }

        switch (dialogType) {
            case INFORMATION_TYPE:
                alertDialog.setIcon(R.drawable.icon_info);
                break;
            case WARNING_TYPE:
                alertDialog.setIcon(R.drawable.icon_warning);
                break;
            case ERROR_TYPE:
                alertDialog.setIcon(R.drawable.icon_error);
                break;
            default:
                break;
        }

        alertDialog.setPositiveButton(createButtonString(positiveButton, true, activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callback != null) {
                    callback.onPositiveButton();
                }
            }
        });

        alertDialog.setNegativeButton(createButtonString(negativeButton, false, activity), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (callback != null) {
                    callback.onNegativeButton();
                }
            }
        });

        dialog = alertDialog.create();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        });
    }

    private static String createButtonString(String buttonString, boolean positiveButton, Context context) {

        String button;
        if (buttonString != null && buttonString.length() > 0) {
            button = buttonString;
        }
        else {
            button = positiveButton ? context.getResources().getString(android.R.string.ok) : context.getResources().getString(android.R.string.no);
        }

        return button;
    }

    public static void showAlertDialogWithMessage(String message, String positiveButton, String negativeButton, Activity activity, OnDialogCallback callback) {
        showAlertDialog(null, message, DialogType.NO_TYPE, positiveButton, negativeButton, activity, callback);
    }

    public static void showAlertDialogWithTitleAndMessage(String title, String message, String positiveButton, String negativeButton, Activity activity, OnDialogCallback callback) {
        showAlertDialog(title, message, DialogType.NO_TYPE, positiveButton, negativeButton, activity, callback);
    }

    public static void showInfoAlertDialog(String message, String positiveButton, String negativeButton, Activity activity, OnDialogCallback callback) {
        showAlertDialog(activity.getResources().getString(R.string.info), message, DialogType.INFORMATION_TYPE, positiveButton, negativeButton, activity, callback);
    }

    public static void showWarningAlertDialog(String message, String positiveButton, String negativeButton, Activity activity, OnDialogCallback callback) {
        showAlertDialog(activity.getResources().getString(R.string.warning), message, DialogType.WARNING_TYPE, positiveButton, negativeButton, activity, callback);
    }

    public static void showErrorAlertDialog(String message, String positiveButton, String negativeButton, Activity activity, OnDialogCallback callback) {
        showAlertDialog(activity.getResources().getString(R.string.error), message, DialogType.ERROR_TYPE, positiveButton, negativeButton, activity, callback);
    }

    public static void showToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String message, Context context) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
