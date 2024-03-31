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
import com.saadahmedev.popupdialog.dialog.standard.AlertDialog;
import com.saadahmedev.popupdialog.dialog.standard.IOSDialog;
import com.saadahmedev.popupdialog.dialog.standard.StandardDialog;

/**
 * A dialog class representing a standard type dialog.
 * <p>
 * This dialog serves as a base class for creating different types of standard dialogs.
 * It provides methods to create instances of specific standard dialog types such as {@link StandardDialog}, {@link IOSDialog}, and {@link AlertDialog}.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see StandardDialog
 * @see IOSDialog
 * @see AlertDialog
 */
public class StandardTypeDialog extends BaseDialog<StandardTypeDialog> {

    /**
     * Constructs a new StandardTypeDialog.
     *
     * @param popupDialog The PopupDialog associated with this StandardTypeDialog.
     */
    private StandardTypeDialog(PopupDialog popupDialog) {
        super(popupDialog);
    }

    /**
     * Gets an instance of the StandardTypeDialog.
     *
     * @param popupDialog The PopupDialog associated with this StandardTypeDialog.
     * @return An instance of the StandardTypeDialog.
     */
    public static StandardTypeDialog getInstance(PopupDialog popupDialog) {
        return new StandardTypeDialog(popupDialog);
    }

    /**
     * Creates a new StandardDialog instance.
     *
     * @return A new StandardDialog instance.
     */
    public StandardDialog createStandardDialog() {
        return StandardDialog.getInstance(super.getPopupDialog());
    }

    /**
     * Creates a new IOSDialog instance.
     *
     * @return A new IOSDialog instance.
     */
    public IOSDialog createIOSDialog() {
        return IOSDialog.getInstance(super.getPopupDialog());
    }

    /**
     * Creates a new AlertDialog instance.
     *
     * @return A new AlertDialog instance.
     */
    public AlertDialog createAlertDialog() {
        return AlertDialog.getInstance(super.getPopupDialog());
    }
}
