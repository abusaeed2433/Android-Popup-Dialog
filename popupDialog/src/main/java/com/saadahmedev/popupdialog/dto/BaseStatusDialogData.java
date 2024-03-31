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
 * Represents the base data for a status dialog.
 * <p>
 * This class encapsulates the basic data elements required for constructing a status dialog,
 * including heading text, description text, text colors for heading and description, as well as
 * text color and label for the action button. It serves as the foundation for creating various
 * types of status dialogs.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class BaseStatusDialogData {
    /**
     * The heading text of the dialog.
     */
    private final String heading;

    /**
     * The description text of the dialog.
     */
    private final String description;

    /**
     * The text color of the heading.
     */
    private final Integer headingTextColor;

    /**
     * The text color of the description.
     */
    private final Integer descriptionTextColor;

    /**
     * The text color of the action button.
     */
    private final Integer actionButtonTextColor;

    /**
     * The text for the action button.
     */
    private final String actionButtonText;

    /**
     * Constructs a new BaseStatusDialogData object.
     *
     * @param heading             The heading text of the dialog.
     * @param description         The description text of the dialog.
     * @param headingTextColor    The text color of the heading.
     * @param descriptionTextColor The text color of the description.
     * @param actionButtonTextColor The text color of the action button.
     * @param actionButtonText   The text for the action button.
     */
    public BaseStatusDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer actionButtonTextColor, String actionButtonText) {
        this.heading = heading;
        this.description = description;
        this.headingTextColor = headingTextColor;
        this.descriptionTextColor = descriptionTextColor;
        this.actionButtonTextColor = actionButtonTextColor;
        this.actionButtonText = actionButtonText;
    }

    /**
     * Retrieves the heading text of the dialog.
     *
     * @return The heading text.
     */
    public String getHeading() {
        return heading;
    }

    /**
     * Retrieves the description text of the dialog.
     *
     * @return The description text.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the text color of the heading.
     *
     * @return The text color of the heading.
     */
    public Integer getHeadingTextColor() {
        return headingTextColor;
    }

    /**
     * Retrieves the text color of the description.
     *
     * @return The text color of the description.
     */
    public Integer getDescriptionTextColor() {
        return descriptionTextColor;
    }

    /**
     * Retrieves the text color of the action button.
     *
     * @return The text color of the action button.
     */
    public Integer getActionButtonTextColor() {
        return actionButtonTextColor;
    }

    /**
     * Retrieves the text for the action button.
     *
     * @return The text for the action button.
     */
    public String getActionButtonText() {
        return actionButtonText;
    }
}
