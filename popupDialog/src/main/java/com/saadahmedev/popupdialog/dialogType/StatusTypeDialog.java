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

package com.saadahmedev.popupdialog.dialogType;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.base.BaseDialog;
import com.saadahmedev.popupdialog.dialog.status.ErrorDialog;
import com.saadahmedev.popupdialog.dialog.status.StatusDialog;
import com.saadahmedev.popupdialog.dialog.status.SuccessDialog;
import com.saadahmedev.popupdialog.dialog.status.WarningDialog;

/**
 * A dialog class representing a status type dialog.
 * <p>
 * This dialog serves as a base class for creating different types of status dialogs.
 * It provides methods to create instances of specific status dialog types such as {@link StatusDialog}, {@link SuccessDialog}, {@link WarningDialog}, and {@link ErrorDialog}.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see StatusDialog
 * @see SuccessDialog
 * @see WarningDialog
 * @see ErrorDialog
 */
public class StatusTypeDialog extends BaseDialog<StandardTypeDialog> {

    /**
     * Constructs a new StatusTypeDialog.
     *
     * @param popupDialog The PopupDialog associated with this StatusTypeDialog.
     */
    private StatusTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    /**
     * Gets an instance of the StatusTypeDialog.
     *
     * @param popupDialog The PopupDialog associated with this StatusTypeDialog.
     * @return An instance of the StatusTypeDialog.
     */
    public static StatusTypeDialog getInstance(PopupDialog popupDialog) {
        return new StatusTypeDialog(popupDialog);
    }

    /**
     * Creates a new StatusDialog instance.
     *
     * @return A new StatusDialog instance.
     */
    public StatusDialog createStatusDialog() {
        return StatusDialog.getInstance(super.getPopupDialog());
    }

    /**
     * Creates a new SuccessDialog instance.
     *
     * @return A new SuccessDialog instance.
     */
    public SuccessDialog createSuccessDialog() {
        return SuccessDialog.getInstance(super.getPopupDialog());
    }

    /**
     * Creates a new WarningDialog instance.
     *
     * @return A new WarningDialog instance.
     */
    public WarningDialog createWarningDialog() {
        return WarningDialog.getInstance(super.getPopupDialog());
    }

    /**
     * Creates a new ErrorDialog instance.
     *
     * @return A new ErrorDialog instance.
     */
    public ErrorDialog createErrorDialog() {
        return ErrorDialog.getInstance(super.getPopupDialog());
    }
}
