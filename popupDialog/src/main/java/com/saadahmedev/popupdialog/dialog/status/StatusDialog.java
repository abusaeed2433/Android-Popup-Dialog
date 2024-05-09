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

package com.saadahmedev.popupdialog.dialog.status;

import androidx.annotation.NonNull;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStatusDialog;
import com.saadahmedev.popupdialog.databinding.DialogStandardBinding;

/**
 * A dialog class for displaying a status dialog.
 * <p>
 * This dialog extends {@link BaseStatusDialog} and provides functionalities for creating status dialogs,
 * which can represent various states such as success, error, or warning. It serves as a base class for
 * creating specific status dialogs and allows customization of the Lottie animation icon.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 *
 * @see ErrorDialog
 * @see SuccessDialog
 * @see WarningDialog
 */
public class StatusDialog extends BaseStatusDialog<StatusDialog, DialogStandardBinding> {

    /**
     * Constructs a new {@link StatusDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link StatusDialog}.
     */
    private StatusDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
    }

    /**
     * Gets an instance of the {@link StatusDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link StatusDialog}.
     * @return An instance of the {@link StatusDialog}.
     */
    public static StatusDialog getInstance(PopupDialog popupDialog) {
        return new StatusDialog(popupDialog);
    }

    /**
     * Sets the Lottie animation resource for the dialog.
     *
     * @param lottieRaw The resource ID of the Lottie animation.
     * @return The {@link StatusDialog} instance.
     */
    @Override
    public StatusDialog setLottieIcon(@NonNull Integer lottieRaw) {
        return super.setLottieIcon(lottieRaw);
    }

    /**
     * Sets the Lottie animation asset for the dialog.
     *
     * @param lottieAsset The file path of the Lottie animation asset.
     * @return The {@link StatusDialog} instance.
     */
    @Override
    public StatusDialog setLottieIcon(@NonNull String lottieAsset) {
        return super.setLottieIcon(lottieAsset);
    }
}
