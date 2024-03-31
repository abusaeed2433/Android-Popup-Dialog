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

package com.saadahmedev.popupdialog.dialog.standard;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStandardDialog;
import com.saadahmedev.popupdialog.databinding.DialogIosBinding;
import com.saadahmedev.popupdialog.dto.IOSDialogData;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

/**
 * A dialog class for displaying an iOS-style dialog.
 * <p>
 * This dialog extends {@link BaseStandardDialog} and provides functionalities for creating customizable iOS-style dialogs
 * with options for positive and negative actions.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 *
 * @see StandardDialog
 * @see AlertDialog
 */
public class IOSDialog extends BaseStandardDialog<IOSDialog, DialogIosBinding> {

    /**
     * Constructs a new {@link IOSDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link IOSDialog}.
     */
    private IOSDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_ios);
    }

    /**
     * Gets an instance of the {@link IOSDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link IOSDialog}.
     * @return An instance of the {@link IOSDialog}.
     */
    public static IOSDialog getInstance(PopupDialog popupDialog) {
        return new IOSDialog(popupDialog);
    }

    /**
     * Builds and displays the {@link IOSDialog}.
     *
     * @param listener The listener for dialog actions.
     * @return The built {@link PopupDialog}.
     */
    @Override
    public PopupDialog build(StandardDialogActionListener listener) {
        super.build(listener);

        binding.btnPositive.setTypeface(super.buttonFont);
        binding.btnNegative.setTypeface(super.buttonFont);
        binding.tvHeading.setTypeface(super.headingFont);
        binding.tvDescription.setTypeface(super.descriptionFont);
        binding.btnPositive.setTextSize(super.buttonFontSize);
        binding.btnNegative.setTextSize(super.buttonFontSize);
        binding.tvHeading.setTextSize(super.headingFontSize);
        binding.tvDescription.setTextSize(super.descriptionFontSize);

        if (super.background != null) {
            binding.rootLayout.setBackgroundResource(super.background);
        } else if (super.backgroundColor != null) {
            binding.rootLayout.setBackground(
                    getBackground(
                            super.backgroundColor,
                            super.backgroundTopLeftCornerRadius,
                            super.backgroundTopRightCornerRadius,
                            super.backgroundBottomLeftCornerRadius,
                            super.backgroundBottomRightCornerRadius
                    )
            );
        }

        binding.setDialog(super.getDialog());
        binding.setListener(listener);
        binding.setItem(
                new IOSDialogData(
                        super.heading,
                        super.description,
                        super.headingTextColor,
                        super.descriptionTextColor,
                        super.positiveButtonTextColor,
                        super.negativeButtonTextColor,
                        super.positiveButtonText,
                        super.negativeButtonText
                )
        );

        return super.getPopupDialog();
    }
}
