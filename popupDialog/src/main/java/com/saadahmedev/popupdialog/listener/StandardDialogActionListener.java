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

package com.saadahmedev.popupdialog.listener;

import android.app.Dialog;

/**
 * Interface for handling actions performed on a StandardDialog.
 * <p>
 * This interface defines methods to handle actions performed on a StandardDialog,
 * such as clicking the positive or negative button.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public interface StandardDialogActionListener {

    /**
     * Called when the positive button of the dialog is clicked.
     *
     * @param dialog The dialog on which the positive button was clicked.
     */
    void onPositiveButtonClicked(Dialog dialog);

    /**
     * Called when the negative button of the dialog is clicked.
     *
     * @param dialog The dialog on which the negative button was clicked.
     */
    void onNegativeButtonClicked(Dialog dialog);
}
