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
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;

/**
 * A dialog class for displaying a warning status dialog.
 * <p>
 * This dialog extends {@link BaseStatusDialog} and provides functionalities for creating warning status dialogs.
 * It sets the appropriate Lottie animation icon for representing a warning, along with other customization options
 * available in the base class. It serves as a specialized dialog for indicating warning messages or states.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 *
 * @see StatusDialog
 * @see SuccessDialog
 * @see ErrorDialog
 */
public class WarningDialog extends BaseStatusDialog<WarningDialog, DialogStatusBinding> {

    /**
     * Constructs a new {@link WarningDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link WarningDialog}.
     */
    private WarningDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_status);
        super.setLottieIcon(R.raw.warning);
    }

    /**
     * Gets an instance of the {@link WarningDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link WarningDialog}.
     * @return An instance of the {@link WarningDialog}.
     */
    @NonNull
    public static WarningDialog getInstance(PopupDialog popupDialog) {
        return new WarningDialog(popupDialog);
    }
}
