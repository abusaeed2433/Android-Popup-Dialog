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

import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.databinding.BindingAdapter;

/**
 * Utility class for binding image resources to ImageViews in XML layouts.
 * <p>
 * This class provides a method to set an icon for a dialog ImageView using data binding.
 * It handles the case where the icon resource ID is null to avoid setting a null icon.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 */
public class ImageBinder {

    /**
     * Sets the icon for a dialog ImageView using data binding.
     *
     * @param imageView The ImageView to which the icon will be set.
     * @param icon      The resource ID of the icon to be set.
     */
    @BindingAdapter("android:popupIcon")
    public static void setDialogIcon(ImageView imageView, @DrawableRes Integer icon) {
        if (icon != null) {
            imageView.setImageResource(icon);
        }
    }
}
