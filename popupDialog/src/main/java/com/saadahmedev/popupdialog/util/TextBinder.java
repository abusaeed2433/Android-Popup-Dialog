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

package com.saadahmedev.popupdialog.util;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

/**
 * Utility class for binding text color to TextViews in XML layouts.
 * <p>
 * This class provides a method to set the text color for a dialog TextView using data binding.
 * It handles the case where the color resource ID is null to avoid setting a null color.
 * If the color resource is not found, it sets the text color directly using the provided color ID.
 * <p>
 * Note: This class suppresses lint warnings for resource colors.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class TextBinder {

    /**
     * Sets the text color for a dialog TextView using data binding.
     *
     * @param textView The TextView to which the text color will be set.
     * @param color    The resource ID of the text color to be set.
     */
    @SuppressLint("ResourceAsColor")
    @BindingAdapter("android:dialogTextColor")
    public static void setDialogTextColor(TextView textView, @ColorRes Integer color) {
        if (color != null) {
            try {
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), color));
            } catch (Resources.NotFoundException e) {
                textView.setTextColor(color);
            }
        }
    }
}
