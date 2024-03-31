/*
 * Copyright 2018-2024 Saad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.saadahmedev.popupdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;
import com.saadahmedev.popupdialog.dialogType.StandardTypeDialog;
import com.saadahmedev.popupdialog.dialogType.StatusTypeDialog;
import com.saadahmedev.popupdialog.dto.BaseStandardDialogData;
import com.saadahmedev.popupdialog.dto.BaseStatusDialogData;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.util.ImageBinder;
import com.saadahmedev.popupdialog.util.TextBinder;

/**
 * Represents a utility class for creating and managing different types of dialogs within an Android application.
 * <p>
 * This class provides methods to create various types of dialogs, including {@link ProgressTypeDialog}, {@link StandardTypeDialog},
 * and {@link StatusTypeDialog}, each serving different purposes within the application. It also allows setting properties
 * such as cancellability and timeout for automatic dismissal of dialogs. Additionally, it handles the showing and
 * dismissing of dialogs.
 * <p>
 * This class works in conjunction with other dialog-related classes such as {@link ProgressTypeDialog}, {@link StandardTypeDialog},
 * {@link StatusTypeDialog}, {@link BaseStandardDialogData}, and {@link BaseStatusDialogData}. Each dialog type corresponds to a specific
 * use case and extends from a base dialog class providing common functionality. The {@link BaseStandardDialogData} and
 * {@link BaseStatusDialogData} classes hold data for standard and status type dialogs, respectively, providing a consistent
 * structure for dialog content.
 * <p>
 * The {@link PopupDialogException} class is used to handle errors related to the {@link PopupDialog}, providing a means to
 * communicate exceptions that occur during dialog operations.
 * <p>
 * Additionally, this class utilizes utility classes such as {@link ImageBinder} and {@link TextBinder} for data binding operations,
 * facilitating the dynamic setting of image resources and text colors in dialog layouts.
 *
 * @see ProgressTypeDialog
 * @see StandardTypeDialog
 * @see StatusTypeDialog
 * @see BaseStandardDialogData
 * @see BaseStatusDialogData
 * @see PopupDialogException
 * @see ImageBinder
 * @see TextBinder
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class PopupDialog {

    private final Dialog dialog;
    private final Context context;

    /**
     * Constructs a new PopupDialog instance with the given context.
     *
     * @param context The context used to create the dialog.
     */
    private PopupDialog(Context context) {
        this.dialog = new Dialog(context);
        this.context = this.dialog.getContext();
    }

    /**
     * Retrieves the underlying Dialog object.
     *
     * @return The Dialog object.
     */
    public Dialog getDialog() {
        return this.dialog;
    }

    /**
     * Retrieves the context associated with the dialog.
     *
     * @return The context associated with the dialog.
     */
    public Context getContext() {
        return this.context;
    }

    /**
     * Creates a new instance of PopupDialog with the given context.
     *
     * @param context The context used to create the dialog.
     * @return A new PopupDialog instance.
     */
    public static PopupDialog getInstance(Context context) {
        return new PopupDialog(context);
    }

    /**
     * Creates a ProgressTypeDialog instance.
     *
     * @return A ProgressTypeDialog instance.
     */
    public ProgressTypeDialog progressDialogBuilder() {
        return ProgressTypeDialog.getInstance(this);
    }

    /**
     * Creates a StandardTypeDialog instance.
     *
     * @return A StandardTypeDialog instance.
     */
    public StandardTypeDialog standardDialogBuilder() {
        return StandardTypeDialog.getInstance(this);
    }

    /**
     * Creates a StatusTypeDialog instance.
     *
     * @return A StatusTypeDialog instance.
     */
    public StatusTypeDialog statusDialogBuilder() {
        return StatusTypeDialog.getInstance(this);
    }

    /**
     * Sets whether the dialog is cancelable.
     *
     * @param isCancelable True to make the dialog cancelable, false otherwise.
     * @return The PopupDialog instance.
     */
    public PopupDialog setCancelable(boolean isCancelable) {
        this.dialog.setCancelable(isCancelable);
        return this;
    }

    /**
     * Sets a timeout for the dialog to automatically dismiss after a specified duration.
     *
     * @param milliseconds The duration in milliseconds before the dialog is automatically dismissed.
     * @return The PopupDialog instance.
     */
    public PopupDialog setTimeout(long milliseconds) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (this.dialog.isShowing()) this.dialog.dismiss();
        }, milliseconds);
        return this;
    }

    /**
     * Shows the dialog.
     */
    public void show() {
        if (dialog.getWindow() == null) {
            throw new PopupDialogException("Show method called before building the dialog.");
        }

        if (!this.dialog.isShowing()) this.dialog.show();
    }

    /**
     * Dismisses the dialog if it is showing.
     */
    public void dismiss() {
        if (this.dialog.isShowing()) this.dialog.dismiss();
    }
}
