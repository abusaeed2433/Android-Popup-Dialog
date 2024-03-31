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
 * Represents the data for a status dialog.
 * <p>
 * This class extends {@link BaseStatusDialogData} and provides specific data elements required
 * for constructing a status dialog. It includes heading text, description text, text colors for
 * heading and description, as well as text color and label for the action button. It serves as a
 * container for storing information necessary to create a status dialog.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class StatusDialogData extends BaseStatusDialogData {
    /**
     * Constructs a new StatusDialogData object.
     *
     * @param heading             The heading text of the dialog.
     * @param description         The description text of the dialog.
     * @param headingTextColor    The text color of the heading.
     * @param descriptionTextColor The text color of the description.
     * @param actionButtonTextColor The text color of the action button.
     * @param actionButtonText   The text for the action button.
     */
    public StatusDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer actionButtonTextColor, String actionButtonText) {
        super(heading, description, headingTextColor, descriptionTextColor, actionButtonTextColor, actionButtonText);
    }
}
