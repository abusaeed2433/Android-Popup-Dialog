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

package com.saadahmedev.popupdialog.base;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;

/**
 * BaseShapeGenerator is an abstract class that extends {@link BaseDialogBinder} and provides methods
 * for generating drawable shapes for dialogs, such as rounded rectangles. It also includes
 * methods for converting color resources to integer values, creating {@link RippleDrawable} objects,
 * and converting dimension resources to float values.
 *
 * @param <T>  The type of the {@link PopupDialog}.
 * @param <VB> The type of {@link ViewDataBinding} associated with the layout resource.
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseDialogBinder
 */
public class BaseShapeGenerator<T, VB extends ViewDataBinding> extends BaseDialogBinder<T, VB> {

    /**
     * Constructs a new BaseShapeGenerator instance with the provided PopupDialog and layout resource.
     *
     * @param popupDialog The {@link PopupDialog} instance to associate with this shape generator.
     * @param layout      The layout resource ID to inflate for this shape generator.
     */
    protected BaseShapeGenerator(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    /**
     * Generates a GradientDrawable with the specified background color and corner radii.
     *
     * @param backgroundColor The background color of the drawable.
     * @param topLeft         The radius of the top-left corner.
     * @param topRight        The radius of the top-right corner.
     * @param bottomLeft      The radius of the bottom-left corner.
     * @param bottomRight     The radius of the bottom-right corner.
     * @return A GradientDrawable representing the generated shape.
     */
    protected GradientDrawable getBackground(
            Integer backgroundColor,
            Float topLeft,
            Float topRight,
            Float bottomLeft,
            Float bottomRight) {
        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(ContextCompat.getColor(super.getContext(), backgroundColor));
        shape.setCornerRadii(
                new float[]{
                        topLeft,
                        topLeft,
                        topRight,
                        topRight,
                        bottomRight,
                        bottomRight,
                        bottomLeft,
                        bottomLeft
                }
        );

        return shape;
    }

    /**
     * Converts a color resource ID to its corresponding integer color value.
     *
     * @param color The color resource ID to convert.
     * @return The integer value representing the color.
     */
    protected Integer resToColorInt(@NonNull @ColorRes Integer color) {
        return ContextCompat.getColor(super.getContext(), color);
    }

    /**
     * Creates a {@link RippleDrawable} with the specified shape and ripple color.
     *
     * @param shape       The shape drawable to apply the ripple effect to.
     * @param rippleColor The color of the ripple effect.
     * @return A {@link RippleDrawable} with the specified properties.
     */
    protected RippleDrawable getRipple(GradientDrawable shape, Integer rippleColor) {
        return new RippleDrawable(
                ColorStateList.valueOf(ContextCompat.getColor(super.getContext(), rippleColor)),
                shape,
                null
        );
    }

    /**
     * Converts a dimension resource ID to its corresponding float value.
     *
     * @param dimen The dimension resource ID to convert.
     * @return The float value representing the dimension.
     */
    protected float dimenToFloat(Integer dimen) {
        return super.getContext().getResources().getDimension(dimen);
    }
}
