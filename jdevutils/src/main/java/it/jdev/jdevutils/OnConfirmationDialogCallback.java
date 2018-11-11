package it.jdev.jdevutils;

import java.util.ArrayList;

public interface OnConfirmationDialogCallback {

    void onPositiveButton(ArrayList<String> confirmedElements);
    void onNegativeButton();
}
