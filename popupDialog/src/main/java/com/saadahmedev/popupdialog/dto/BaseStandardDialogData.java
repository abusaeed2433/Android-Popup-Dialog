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

public class BaseStandardDialogData {
    private final String heading;
    private final String description;
    private final Integer headingTextColor;
    private final Integer descriptionTextColor;
    private final Integer positiveButtonTextColor;
    private final Integer negativeButtonTextColor;
    private final String positiveButtonText;
    private final String negativeButtonText;

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

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHeadingTextColor() {
        return headingTextColor;
    }

    public Integer getDescriptionTextColor() {
        return descriptionTextColor;
    }

    public Integer getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    public Integer getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }
}
