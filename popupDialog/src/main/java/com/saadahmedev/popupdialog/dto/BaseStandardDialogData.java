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
 * Represents the base data for a standard dialog.
 * <p>
 * This class encapsulates the basic data elements required for creating a standard dialog,
 * including heading text, description text, text colors for heading and description, as well as
 * text colors and labels for positive and negative buttons.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */

public class BaseStandardDialogData {

    /** The heading text of the dialog. */
    private final String heading;
    /** The description text of the dialog. */
    private final String description;
    /** The text color of the heading. */
    private final Integer headingTextColor;

    /** The text color of the description. */
    private final Integer descriptionTextColor;

    /** The text color of the positive button. */
    private final Integer positiveButtonTextColor;

    /** The text color of the negative button. */
    private final Integer negativeButtonTextColor;

    /** The text for the positive button. */
    private final String positiveButtonText;

    /** The text for the negative button. */
    private final String negativeButtonText;

    /**
     * Constructs a new BaseStandardDialogData object.
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
    public BaseStandardDialogData(String heading, String description, Integer headingTextColor, Integer descriptionTextColor, Integer positiveButtonTextColor, Integer negativeButtonTextColor, String positiveButtonText, String negativeButtonText) {
        this.heading = heading;
        this.description = description;
        this.headingTextColor = headingTextColor;
        this.descriptionTextColor = descriptionTextColor;
        this.positiveButtonTextColor = positiveButtonTextColor;
        this.negativeButtonTextColor = negativeButtonTextColor;
        this.positiveButtonText = positiveButtonText;
        this.negativeButtonText = negativeButtonText;
    }

    /**
     * Gets the heading text of the dialog.
     *
     * @return The heading text.
     */
    public String getHeading() {
        return heading;
    }

    /**
     * Gets the description text of the dialog.
     *
     * @return The description text.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the text color of the heading.
     *
     * @return The heading text color.
     */
    public Integer getHeadingTextColor() {
        return headingTextColor;
    }

    /**
     * Gets the text color of the description.
     *
     * @return The description text color.
     */
    public Integer getDescriptionTextColor() {
        return descriptionTextColor;
    }

    /**
     * Gets the text color of the positive button.
     *
     * @return The positive button text color.
     */
    public Integer getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    /**
     * Gets the text color of the negative button.
     *
     * @return The negative button text color.
     */
    public Integer getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    /**
     * Gets the text for the positive button.
     *
     * @return The text for the positive button.
     */
    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    /**
     * Gets the text for the negative button.
     *
     * @return The text for the negative button.
     */
    public String getNegativeButtonText() {
        return negativeButtonText;
    }
}
