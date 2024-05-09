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

import android.graphics.Typeface;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

/**
 * {@link BaseStandardDialog} is an abstract class designed for customizing standard dialogs in Android applications.
 * It extends {@link BaseShapeGenerator} and provides extensive methods for configuring various aspects of the dialog,
 * including text appearance, button behavior, and background appearance.
 * <p>
 * This class serves as a foundation for creating standard dialogs with enhanced visual and functional capabilities.
 *
 * @param <T> The type of the {@link PopupDialog}.
 * @param <VB> The type of {@link ViewDataBinding} associated with the layout resource.
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseShapeGenerator
 */
public class BaseStandardDialog<T, VB extends ViewDataBinding> extends BaseShapeGenerator<T, VB> {

    /**
     * Default font size for the heading text.
     */
    private static final Float DEFAULT_HEADING_FONT_SIZE = 17F;

    /**
     * Default font size for the description text.
     */
    private static final Float DEFAULT_DESCRIPTION_FONT_SIZE = 15F;

    /**
     * Default font size for the button text.
     */
    private static final Float DEFAULT_BUTTON_FONT_SIZE = 16F;

    /**
     * The heading text of the dialog.
     */
    protected String heading;

    /**
     * The description text of the dialog.
     */
    protected String description;

    /**
     * The text for the negative button (e.g., "Cancel").
     */
    protected String negativeButtonText;

    /**
     * The text for the positive button (e.g., "Submit").
     */
    protected String positiveButtonText;

    /**
     * The text color for the positive button.
     */
    protected Integer positiveButtonTextColor;

    /**
     * The text color for the negative button.
     */
    protected Integer negativeButtonTextColor;

    /**
     * The text color for the heading.
     */
    protected Integer headingTextColor;

    /**
     * The text color for the description.
     */
    protected Integer descriptionTextColor;

    /**
     * The custom font family for the dialog text.
     */
    protected Typeface fontFamily;

    /**
     * The custom font for the heading text.
     */
    protected Typeface headingFont;

    /**
     * The custom font for the description text.
     */
    protected Typeface descriptionFont;

    /**
     * The custom font for the button text.
     */
    protected Typeface buttonFont;

    /**
     * The font size for the heading text.
     */
    protected Float headingFontSize;

    /**
     * The font size for the description text.
     */
    protected Float descriptionFontSize;

    /**
     * The font size for the button text.
     */
    protected Float buttonFontSize;

    /**
     * The background drawable resource for the dialog.
     */
    protected Integer background;

    /**
     * The background color resource for the dialog.
     */
    protected Integer backgroundColor;

    /**
     * The corner radius for the dialog background.
     */
    protected Float backgroundCornerRadius;

    /**
     * The top left corner radius for the dialog background.
     */
    protected Float backgroundTopLeftCornerRadius;

    /**
     * The top right corner radius for the dialog background.
     */
    protected Float backgroundTopRightCornerRadius;

    /**
     * The bottom left corner radius for the dialog background.
     */
    protected Float backgroundBottomLeftCornerRadius;

    /**
     * The bottom right corner radius for the dialog background.
     */
    protected Float backgroundBottomRightCornerRadius;

    /**
     * Constructs a {@link BaseStandardDialog} instance.
     *
     * @param popupDialog The {@link PopupDialog} instance associated with this dialog.
     * @param layout      The layout resource ID for the dialog.
     */
    protected BaseStandardDialog(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    /**
     * Sets the heading text of the dialog.
     *
     * @param heading The heading text.
     * @return The subclass instance for method chaining.
     */
    public T setHeading(@NonNull String heading) {
        this.heading = heading;
        return castType();
    }

    /**
     * Sets the description text of the dialog.
     *
     * @param description The description text.
     * @return The subclass instance for method chaining.
     */
    public T setDescription(@NonNull String description) {
        this.description = description;
        return castType();
    }

    /**
     * Sets the text for the negative button (e.g., "Cancel").
     *
     * @param negativeButtonText The text for the negative button.
     * @return The subclass instance for method chaining.
     */
    public T setNegativeButtonText(@NonNull String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return castType();
    }

    /**
     * Sets the text for the positive button (e.g., "Submit").
     *
     * @param positiveButtonText The text for the positive button.
     * @return The subclass instance for method chaining.
     */
    public T setPositiveButtonText(@NonNull String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return castType();
    }

    /**
     * Sets the text color for the positive button.
     *
     * @param positiveButtonTextColor The text color for the positive button.
     * @return The subclass instance for method chaining.
     */
    public T setPositiveButtonTextColor(@NonNull @ColorRes Integer positiveButtonTextColor) {
        this.positiveButtonTextColor = positiveButtonTextColor;
        return castType();
    }

    /**
     * Sets the text color for the negative button.
     *
     * @param negativeButtonTextColor The text color for the negative button.
     * @return The subclass instance for method chaining.
     */
    public T setNegativeButtonTextColor(@NonNull @ColorRes Integer negativeButtonTextColor) {
        this.negativeButtonTextColor = negativeButtonTextColor;
        return castType();
    }

    /**
     * Sets the text color for the heading.
     *
     * @param headingTextColor The text color for the heading.
     * @return The subclass instance for method chaining.
     */
    public T setHeadingTextColor(@NonNull @ColorRes Integer headingTextColor) {
        this.headingTextColor = headingTextColor;
        return castType();
    }

    /**
     * Sets the text color for the description.
     *
     * @param descriptionTextColor The text color for the description.
     * @return The subclass instance for method chaining.
     */
    public T setDescriptionTextColor(@NonNull @ColorRes Integer descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
        return castType();
    }

    /**
     * Sets the custom font family for the dialog text.
     *
     * @param fontFamily The resource ID of the font family.
     * @return The subclass instance for method chaining.
     */
    public T setFontFamily(@NonNull @FontRes Integer fontFamily) {
        this.fontFamily = resToTypeface(fontFamily);
        return castType();
    }

    /**
     * Sets the custom font for the heading text.
     *
     * @param headingFont The resource ID of the font.
     * @return The subclass instance for method chaining.
     */
    public T setHeadingFont(@NonNull @FontRes Integer headingFont) {
        this.headingFont = resToTypeface(headingFont);
        return castType();
    }

    /**
     * Sets the custom font for the description text.
     *
     * @param descriptionFont The resource ID of the font.
     * @return The subclass instance for method chaining.
     */
    public T setDescriptionFont(@NonNull @FontRes Integer descriptionFont) {
        this.descriptionFont = resToTypeface(descriptionFont);
        return castType();
    }

    /**
     * Sets the custom font for the button text.
     *
     * @param buttonFont The resource ID of the font.
     * @return The subclass instance for method chaining.
     */
    public T setButtonFont(@NonNull @FontRes Integer buttonFont) {
        this.buttonFont = resToTypeface(buttonFont);
        return castType();
    }

    /**
     * Sets the font size for the heading text.
     *
     * @param headingFontSize The font size for the heading text.
     * @return The subclass instance for method chaining.
     */
    public T setHeadingFontSize(@NonNull Float headingFontSize) {
        this.headingFontSize = headingFontSize;
        return castType();
    }

    /**
     * Sets the font size for the description text.
     *
     * @param descriptionFontSize The font size for the description text.
     * @return The subclass instance for method chaining.
     */
    public T setDescriptionFontSize(@NonNull Float descriptionFontSize) {
        this.descriptionFontSize = descriptionFontSize;
        return castType();
    }

    /**
     * Sets the font size for the button text.
     *
     * @param buttonFontSize The font size for the button text.
     * @return The subclass instance for method chaining.
     */
    public T setButtonFontSize(@NonNull Float buttonFontSize) {
        this.buttonFontSize = buttonFontSize;
        return castType();
    }

    /**
     * Sets the background drawable resource for the dialog.
     *
     * @param background The background drawable resource.
     * @return The subclass instance for method chaining.
     */
    public T setBackground(@NonNull @DrawableRes Integer background) {
        this.background = background;
        return castType();
    }

    /**
     * Sets the background color resource for the dialog.
     *
     * @param backgroundColor The background color resource.
     * @return The subclass instance for method chaining.
     */
    public T setBackgroundColor(@NonNull @ColorRes Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return castType();
    }

    /**
     * Sets the corner radius for the dialog background.
     *
     * @param cornerRadius The corner radius for the dialog background.
     * @return The subclass instance for method chaining.
     */
    public T setBackgroundCornerRadius(@NonNull Float cornerRadius) {
        this.backgroundCornerRadius = cornerRadius;
        return castType();
    }

    /**
     * Sets the corner radius for the dialog background.
     *
     * @param topLeft     The top left corner radius for the dialog background.
     * @param topRight    The top right corner radius for the dialog background.
     * @param bottomLeft  The bottom left corner radius for the dialog background.
     * @param bottomRight The bottom right corner radius for the dialog background.
     * @return The subclass instance for method chaining.
     */
    public T setBackgroundCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight) {
        this.backgroundTopLeftCornerRadius = topLeft;
        this.backgroundTopRightCornerRadius = topRight;
        this.backgroundBottomLeftCornerRadius = bottomLeft;
        this.backgroundBottomRightCornerRadius = bottomRight;
        return castType();
    }

    /**
     * Constructs the dialog with the provided settings.
     *
     * @param listener The listener for dialog actions.
     * @return The constructed PopupDialog instance.
     * @throws PopupDialogException if the heading or description is null.
     */
    public PopupDialog build(StandardDialogActionListener listener) {
        if (heading == null) throw new PopupDialogException("Standard dialog heading is null");
        if (description == null)
            throw new PopupDialogException("Standard dialog description is null");

        positiveButtonText = positiveButtonText == null ? "Submit" : positiveButtonText;
        negativeButtonText = negativeButtonText == null ? "Cancel" : negativeButtonText;

//        positiveButtonTextColor = positiveButtonTextColor == null ? super.resToColorInt(R.color.colorWhite) : positiveButtonTextColor;
//        negativeButtonTextColor = negativeButtonTextColor == null ? super.resToColorInt(R.color.colorBlack) : negativeButtonTextColor;

        headingTextColor = headingTextColor == null ? super.resToColorInt(R.color.text_color) : headingTextColor;
        descriptionTextColor = descriptionTextColor == null ? super.resToColorInt(R.color.text_color) : descriptionTextColor;

        if (fontFamily != null) {
            headingFont = fontFamily;
            descriptionFont = fontFamily;
            buttonFont = fontFamily;
        } else {
            headingFont = headingFont == null ? resToTypeface(R.font.bold) : headingFont;
            descriptionFont = descriptionFont == null ? resToTypeface(R.font.regular) : descriptionFont;
            buttonFont = buttonFont == null ? resToTypeface(R.font.medium) : buttonFont;
        }

        headingFontSize = headingFontSize == null ? DEFAULT_HEADING_FONT_SIZE : headingFontSize;
        descriptionFontSize = descriptionFontSize == null ? DEFAULT_DESCRIPTION_FONT_SIZE : descriptionFontSize;
        buttonFontSize = buttonFontSize == null ? DEFAULT_BUTTON_FONT_SIZE : buttonFontSize;

        if (background != null) {
            backgroundColor = null;
            backgroundCornerRadius = null;
        }
        else if (backgroundColor != null) {
            if (backgroundCornerRadius != null) {
                backgroundTopLeftCornerRadius = backgroundCornerRadius;
                backgroundTopRightCornerRadius = backgroundCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundCornerRadius;
                backgroundBottomRightCornerRadius = backgroundCornerRadius;
            }
            else {
                backgroundTopLeftCornerRadius = backgroundTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopLeftCornerRadius;
                backgroundTopRightCornerRadius = backgroundTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopRightCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomLeftCornerRadius;
                backgroundBottomRightCornerRadius = backgroundBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomRightCornerRadius;
            }
        }

        return super.getPopupDialog();
    }

    /**
     * Converts a resource ID of a font to a Typeface object.
     *
     * @param font The resource ID of the font.
     * @return The Typeface object corresponding to the font resource.
     */
    private Typeface resToTypeface(@NonNull @FontRes Integer font) {
        return ResourcesCompat.getFont(super.getContext(), font);
    }

    /**
     * Helper method to cast the subclass type.
     *
     * @return The subclass instance.
     */
    @SuppressWarnings("unchecked")
    protected T castType() {
        return (T) this;
    }
}
