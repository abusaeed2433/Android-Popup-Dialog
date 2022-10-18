package com.saadahmedsoft.popupdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;

import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class PopupDialog {

    private final Dialog dialog;
    private final Context context;
    @SuppressLint("StaticFieldLeak")
    private static PopupDialog instance = null;

    private PopupDialog(Context context) {
        this.context = context;
        dialog = new Dialog(context);
    }

    public static PopupDialog getInstance(Context context) {
        if (instance == null) {
            instance = new PopupDialog(context);
        }
        return instance;
    }

    public CreateDialog setStyle(Styles style) {
        return CreateDialog.getInstance(context, style, dialog);
    }
}
