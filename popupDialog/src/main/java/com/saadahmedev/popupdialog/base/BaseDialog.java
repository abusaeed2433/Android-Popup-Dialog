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

package com.saadahmedev.popupdialog.base;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.dialog.progress.LottieDialog;
import com.saadahmedev.popupdialog.dialog.progress.ProgressDialog;
import com.saadahmedev.popupdialog.dialog.standard.AlertDialog;
import com.saadahmedev.popupdialog.dialog.standard.IOSDialog;
import com.saadahmedev.popupdialog.dialog.standard.StandardDialog;
import com.saadahmedev.popupdialog.dialog.status.ErrorDialog;
import com.saadahmedev.popupdialog.dialog.status.StatusDialog;
import com.saadahmedev.popupdialog.dialog.status.SuccessDialog;
import com.saadahmedev.popupdialog.dialog.status.WarningDialog;

/**
 * Base class representing a generic dialog, providing common functionality and properties for all dialog types.
 * Subclasses of this class include {@link ProgressDialog}, {@link LottieDialog}, {@link StandardDialog},
 * {@link AlertDialog}, {@link IOSDialog}, {@link StatusDialog}, {@link SuccessDialog}, {@link WarningDialog},
 * and {@link ErrorDialog}.
 *
 * @param <T> The type of the specific dialog extending this base class.
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see PopupDialog
 */
public class BaseDialog<T> {

    /**
     * The {@link PopupDialog} instance associated with this dialog.
     */
    private final PopupDialog popupDialog;

    /**
     * The context in which the dialog is being displayed.
     */
    private final Context context;

    /**
     * The underlying {@link Dialog} object.
     */
    private final Dialog dialog;

    /**
     * Returns the {@link PopupDialog} instance associated with this dialog.
     *
     * @return The {@link PopupDialog} instance.
     */
    public PopupDialog getPopupDialog() {
        return popupDialog;
    }

    /**
     * Returns the context in which the dialog is being displayed.
     *
     * @return The context.
     */
    public Context getContext() {
        return context;
    }

    /**
     * Returns the underlying {@link Dialog} object.
     *
     * @return The {@link Dialog} object.
     */
    public Dialog getDialog() {
        return dialog;
    }

    /**
     * Protected constructor to be used by subclasses.
     *
     * @param popupDialog The {@link PopupDialog} instance.
     */
    protected BaseDialog(@NonNull PopupDialog popupDialog) {
        this.popupDialog = popupDialog;
        this.context = popupDialog.getContext();
        this.dialog = popupDialog.getDialog();
    }

    /**
     * Sets whether the dialog is cancelable or not.
     *
     * @param isCancelable True if the dialog is cancelable, false otherwise.
     * @return This {@link BaseDialog} instance.
     */
    public T setCancelable(boolean isCancelable) {
        this.popupDialog.setCancelable(isCancelable);
        return castType();
    }

    /**
     * Sets the timeout for the dialog in milliseconds.
     *
     * @param milliseconds The timeout in milliseconds.
     * @return This {@link BaseDialog} instance.
     */
    public T setTimeout(long milliseconds) {
        this.popupDialog.setTimeout(milliseconds);
        return castType();
    }

    /**
     * Casts this instance to the specified type.
     *
     * @return This {@link BaseDialog} instance cast to the specified type.
     */
    @SuppressWarnings("unchecked")
    private T castType() {
        return (T) this;
    }
}
