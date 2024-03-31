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

package com.saadahmedev.popupdialog.dto;

/**
 * Represents the data for an alert dialog.
 * <p>
 * This class extends {@link BaseStandardDialogData} and provides specific data elements
 * for creating an alert dialog, such as heading text, description text, text colors for heading
 * and description, as well as text colors and labels for positive and negative buttons.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class AlertDialogData extends BaseStandardDialogData {

    /**
     * Constructs a new AlertDialogData object.
     *
     * @param heading                The heading text of the dialog.
     * @param description            The description text of the dialog.
     * @param headingTextColor       The text color of the heading.
     * @param descriptionTextColor   The text color of the description.
     * @param positiveButtonTextColor The text color of the positive button.
     * @param negativeButtonTextColor The text color of the negative button.
     * @param positiveButtonText     The text for the positive button.
     * @param negativeButtonText     The text for the negative button.
     */
    public AlertDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        super(heading, description, headingTextColor, descriptionTextColor, positiveButtonTextColor, negativeButtonTextColor, positiveButtonText, negativeButtonText);
    }
}
