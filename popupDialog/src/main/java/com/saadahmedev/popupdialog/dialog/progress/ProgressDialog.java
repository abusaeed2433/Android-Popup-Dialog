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

package com.saadahmedev.popupdialog.dialog.progress;

import android.content.res.ColorStateList;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;
import com.saadahmedev.popupdialog.databinding.DialogProgressBinding;
import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;

/**
 * A dialog class for displaying a progress bar dialog.
 * <p>
 * This dialog allows displaying a progress bar with optional tinting for customization.
 * <p>
 * This class extends {@link BaseDialogBinder} to leverage common dialog functionalities.
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseDialogBinder
 */
public class ProgressDialog extends BaseDialogBinder<ProgressDialog, DialogProgressBinding> {

    /**
     * The {@link ProgressTypeDialog} associated with this Progress dialog.
     */
    private final ProgressTypeDialog progressTypeDialog;

    /**
     * The color resource ID for tinting the progress bar.
     */
    private Integer tint;

    /**
     * Constructs a new {@link ProgressDialog}.
     *
     * @param progressTypeDialog The progress type dialog associated with this {@link ProgressDialog}.
     */
    private ProgressDialog(@NonNull ProgressTypeDialog progressTypeDialog) {
        super(progressTypeDialog.getPopupDialog(), R.layout.dialog_progress);
        this.progressTypeDialog = progressTypeDialog;
    }

    /**
     * Gets an instance of the {@link ProgressDialog}.
     *
     * @param progressTypeDialog The progress type dialog associated with this {@link ProgressDialog}.
     * @return An instance of the {@link ProgressDialog}.
     */
    @NonNull
    public static ProgressDialog getInstance(@NonNull ProgressTypeDialog progressTypeDialog) {
        return new ProgressDialog(progressTypeDialog);
    }

    /**
     * Sets the tint color for the progress bar.
     *
     * @param tint The color resource ID for tinting the progress bar.
     * @return The current instance of the {@link ProgressDialog}.
     */
    public ProgressDialog setTint(@NonNull @ColorRes Integer tint) {
        this.tint = tint;
        return this;
    }

    /**
     * Builds the {@link ProgressDialog}.
     *
     * @return The built {@link PopupDialog}.
     */
    public PopupDialog build() {
        if (tint != null) {
            binding.progressBar.setIndeterminateTintList(ColorStateList.valueOf(ContextCompat.getColor(getContext(), this.tint)));
        }

        return progressTypeDialog.getPopupDialog();
    }
}
