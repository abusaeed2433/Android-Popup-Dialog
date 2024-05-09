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
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.databinding.DialogStatusBinding;
import com.saadahmedev.popupdialog.dialog.status.ErrorDialog;
import com.saadahmedev.popupdialog.dialog.status.SuccessDialog;
import com.saadahmedev.popupdialog.dto.StatusDialogData;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StatusDialogActionListener;

/**
 * Base class for creating status dialogs with customizable properties such as headings, descriptions, and action buttons.
 * Developers can extend this class to create specialized status dialogs for various use cases in Android applications.
 * <p>
 * This class provides extensive customization options, including support for Lottie animations, text styling,
 * background colors, corner radii, and more. It follows a builder pattern to construct dialogs efficiently
 * while ensuring essential properties are not null.
 * <p>
 * To use this class, developers should use it's subclasses such as {@link SuccessDialog}, {@link ErrorDialog} etc.
 *
 * @param <T>  The type of the subclass extending {@link BaseStatusDialog}.
 * @param <VB> The type of {@link ViewDataBinding} used in the dialog layout.
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseShapeGenerator
 */
public class BaseStatusDialog<T, VB extends ViewDataBinding> extends BaseShapeGenerator<T, VB> {

    /**
     * Default font size for heading text.
     */
    private static final Float DEFAULT_HEADING_FONT_SIZE = 17F;

    /**
     * Default font size for description text.
     */
    private static final Float DEFAULT_DESCRIPTION_FONT_SIZE = 15F;

    /**
     * Default font size for button text.
     */
    private static final Float DEFAULT_BUTTON_FONT_SIZE = 16F;

    /**
     * Resource ID for the Lottie animation file.
     */
    private Integer lottieRaw;

    /**
     * Asset file name for the Lottie animation.
     */
    private String lottieAsset;

    /**
     * Text for the dialog heading.
     */
    private String heading;

    /**
     * Text for the dialog description.
     */
    private String description;

    /**
     * Text for the action button.
     */
    private String actionButtonText;

    /**
     * Color resource ID for heading text color.
     */
    private Integer headingTextColor;

    /**
     * Color resource ID for description text color.
     */
    private Integer descriptionTextColor;

    /**
     * Color resource ID for action button text color.
     */
    private Integer actionButtonTextColor;

    /**
     * Drawable resource ID for dialog background.
     */
    private Integer background;

    /**
     * Color resource ID for dialog background color.
     */
    private Integer backgroundColor;

    /**
     * Drawable resource ID for action button background.
     */
    private Integer actionButtonBackground;

    /**
     * Color resource ID for action button background color.
     */
    private Integer actionButtonBackgroundColor;

    /**
     * Color resource ID for action button ripple color.
     */
    private Integer actionButtonRippleColor;

    /**
     * Corner radius for action button.
     */
    private Float actionButtonCornerRadius;

    /**
     * Corner radius for dialog background.
     */
    private Float backgroundCornerRadius;

    /**
     * Corner radius for dialog background (top left).
     */
    private Float backgroundTopLeftCornerRadius;

    /**
     * Corner radius for dialog background (top right).
     */
    private Float backgroundTopRightCornerRadius;

    /**
     * Corner radius for dialog background (bottom left).
     */
    private Float backgroundBottomLeftCornerRadius;

    /**
     * Corner radius for dialog background (bottom right).
     */
    private Float backgroundBottomRightCornerRadius;

    /**
     * Corner radius for action button (top left).
     */
    private Float actionButtonTopLeftCornerRadius;

    /**
     * Corner radius for action button (top right).
     */
    private Float actionButtonTopRightCornerRadius;

    /**
     * Corner radius for action button (bottom left).
     */
    private Float actionButtonBottomLeftCornerRadius;

    /**
     * Corner radius for action button (bottom right).
     */
    private Float actionButtonBottomRightCornerRadius;

    /**
     * Resource ID for the font family.
     */
    private Typeface fontFamily;

    /**
     * Typeface for the dialog heading.
     */
    private Typeface headingFont;

    /**
     * Typeface for the dialog description.
     */
    private Typeface descriptionFont;

    /**
     * Typeface for the action button text.
     */
    private Typeface buttonFont;

    /**
     * Font size for the dialog heading.
     */
    private Float headingFontSize;

    /**
     * Font size for the dialog description.
     */
    private Float descriptionFontSize;

    /**
     * Font size for the action button text.
     */
    private Float buttonFontSize;

    /**
     * Constructs a {@link BaseStatusDialog}.
     *
     * @param popupDialog The {@link PopupDialog} instance.
     * @param layout      The layout resource ID for the dialog.
     */
    protected BaseStatusDialog(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog, layout);
    }

    /**
     * Initializes default values for corner radius properties.
     */
    private void init() {
        if (this.actionButtonCornerRadius != null) {
            this.actionButtonTopLeftCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonTopRightCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonBottomRightCornerRadius = this.actionButtonCornerRadius;
            this.actionButtonBottomLeftCornerRadius = this.actionButtonCornerRadius;
        } else {
            this.actionButtonTopLeftCornerRadius = this.actionButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : actionButtonTopLeftCornerRadius;
            this.actionButtonTopRightCornerRadius = this.actionButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : actionButtonTopRightCornerRadius;
            this.actionButtonBottomRightCornerRadius = this.actionButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : actionButtonBottomRightCornerRadius;
            this.actionButtonBottomLeftCornerRadius = this.actionButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : actionButtonBottomLeftCornerRadius;
        }
    }

    /**
     * Builds and returns the {@link PopupDialog}.
     *
     * @param listener The listener for dialog actions.
     * @return The constructed {@link PopupDialog} instance.
     */
    public PopupDialog build(StatusDialogActionListener listener) {
        init();
        if (lottieRaw == null && lottieAsset == null) throw new PopupDialogException("Lottie raw or asset animation is required");
        if (heading == null) throw new PopupDialogException("Standard dialog heading is null");
        if (description == null)
            throw new PopupDialogException("Standard dialog description is null");

        if (this.actionButtonBackground != null) {
            ((DialogStatusBinding) binding).btnDismiss.setBackgroundResource(this.actionButtonBackground);
        } else if (this.actionButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    actionButtonBackgroundColor,
                    actionButtonTopLeftCornerRadius,
                    actionButtonTopRightCornerRadius,
                    actionButtonBottomLeftCornerRadius,
                    actionButtonBottomRightCornerRadius
            );

            if (this.actionButtonRippleColor != null) ((DialogStatusBinding) binding).btnDismiss.setBackground(getRipple(shape, this.actionButtonRippleColor));
            else ((DialogStatusBinding) binding).btnDismiss.setBackground(shape);
        }

        actionButtonText = actionButtonText == null ? "Submit" : actionButtonText;

        actionButtonTextColor = actionButtonTextColor == null ? super.resToColorInt(R.color.static_white) : actionButtonTextColor;
        headingTextColor = headingTextColor == null ? super.resToColorInt(R.color.text_color) : headingTextColor;
        descriptionTextColor = descriptionTextColor == null ? super.resToColorInt(R.color.text_color_dim) : descriptionTextColor;

        if (lottieRaw != null) ((DialogStatusBinding) binding).lottieIcon.setAnimation(lottieRaw);
        else if (lottieAsset != null) ((DialogStatusBinding) binding).lottieIcon.setAnimation(lottieAsset);

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

        ((DialogStatusBinding) binding).btnDismiss.setTypeface(buttonFont);
        ((DialogStatusBinding) binding).tvHeading.setTypeface(headingFont);
        ((DialogStatusBinding) binding).tvDescription.setTypeface(descriptionFont);
        ((DialogStatusBinding) binding).btnDismiss.setTextSize(buttonFontSize);
        ((DialogStatusBinding) binding).tvHeading.setTextSize(headingFontSize);
        ((DialogStatusBinding) binding).tvDescription.setTextSize(descriptionFontSize);

        if (background != null) {
            backgroundColor = null;
            backgroundCornerRadius = null;
            ((DialogStatusBinding) binding).layoutRoot.setBackgroundResource(background);
        } else if (backgroundColor != null) {
            if (backgroundCornerRadius != null) {
                backgroundTopLeftCornerRadius = backgroundCornerRadius;
                backgroundTopRightCornerRadius = backgroundCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundCornerRadius;
                backgroundBottomRightCornerRadius = backgroundCornerRadius;
            } else {
                backgroundTopLeftCornerRadius = backgroundTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopLeftCornerRadius;
                backgroundTopRightCornerRadius = backgroundTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundTopRightCornerRadius;
                backgroundBottomLeftCornerRadius = backgroundBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomLeftCornerRadius;
                backgroundBottomRightCornerRadius = backgroundBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : backgroundBottomRightCornerRadius;
            }

            ((DialogStatusBinding) binding).layoutRoot.setBackground(
                    getBackground(
                            backgroundColor,
                            backgroundTopLeftCornerRadius,
                            backgroundTopRightCornerRadius,
                            backgroundBottomLeftCornerRadius,
                            backgroundBottomRightCornerRadius
                    )
            );
        }

        ((DialogStatusBinding) binding).setDialog(super.getDialog());
        ((DialogStatusBinding) binding).setListener(listener);
        ((DialogStatusBinding) binding).setItem(
                new StatusDialogData(
                        heading,
                        description,
                        headingTextColor,
                        descriptionTextColor,
                        actionButtonTextColor,
                        actionButtonText
                )
        );

        return super.getPopupDialog();
    }

    /**
     * Sets the Lottie animation by resource ID.
     *
     * @param lottieRaw The resource ID of the Lottie animation file.
     * @return The current instance of the subclass.
     */
    protected T setLottieIcon(@NonNull @RawRes Integer lottieRaw) {
        this.lottieRaw = lottieRaw;
        return castType();
    }

    /**
     * Sets the Lottie animation by asset file name.
     *
     * @param lottieAsset The asset file name of the Lottie animation.
     * @return The current instance of the subclass.
     */
    protected T setLottieIcon(@NonNull String lottieAsset) {
        this.lottieAsset = lottieAsset;
        return castType();
    }

    /**
     * Sets the dialog heading text.
     *
     * @param heading The text for the dialog heading.
     * @return The current instance of the subclass.
     */
    public T setHeading(String heading) {
        this.heading = heading;
        return castType();
    }

    /**
     * Sets the dialog description text.
     *
     * @param description The text for the dialog description.
     * @return The current instance of the subclass.
     */
    public T setDescription(String description) {
        this.description = description;
        return castType();
    }

    /**
     * Sets the text for the action button.
     *
     * @param actionButtonText The text for the action button.
     * @return The current instance of the subclass.
     */
    public T setActionButtonText(String actionButtonText) {
        this.actionButtonText = actionButtonText;
        return castType();
    }

    /**
     * Sets the heading text color.
     *
     * @param headingTextColor The color resource ID for the heading text color.
     * @return The current instance of the subclass.
     */
    public T setHeadingTextColor(@NonNull @ColorRes Integer headingTextColor) {
        this.headingTextColor = headingTextColor;
        return castType();
    }

    /**
     * Sets the description text color.
     *
     * @param descriptionTextColor The color resource ID for the description text color.
     * @return The current instance of the subclass.
     */
    public T setDescriptionTextColor(@NonNull @ColorRes Integer descriptionTextColor) {
        this.descriptionTextColor = descriptionTextColor;
        return castType();
    }

    /**
     * Sets the action button text color.
     *
     * @param actionButtonTextColor The color resource ID for the action button text color.
     * @return The current instance of the subclass.
     */
    public T setActionButtonTextColor(@NonNull @ColorRes Integer actionButtonTextColor) {
        this.actionButtonTextColor = actionButtonTextColor;
        return castType();
    }

    /**
     * Sets the background drawable resource for the dialog.
     *
     * @param background The drawable resource ID for the dialog background.
     * @return The current instance of the subclass.
     */
    public T setBackground(@NonNull @DrawableRes Integer background) {
        this.background = background;
        return castType();
    }

    /**
     * Sets the background color for the dialog.
     *
     * @param backgroundColor The color resource ID for the dialog background color.
     * @return The current instance of the subclass.
     */
    public T setBackgroundColor(@NonNull @ColorRes Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
        return castType();
    }

    /**
     * Sets the corner radius for the dialog background.
     *
     * @param backgroundCornerRadius The corner radius for the dialog background.
     * @return The current instance of the subclass.
     */
    public T setBackgroundCornerRadius(@NonNull Float backgroundCornerRadius) {
        this.backgroundCornerRadius = backgroundCornerRadius;
        return castType();
    }

    /**
     * Sets the ripple color for the action button.
     *
     * @param dismissButtonRippleColor The color resource ID for the action button ripple color.
     * @return The current instance of the subclass.
     */
    public T setDismissButtonRippleColor(@NonNull @ColorRes Integer dismissButtonRippleColor) {
        this.actionButtonRippleColor = dismissButtonRippleColor;
        return castType();
    }

    /**
     * Sets the corner radius for the dialog background.
     *
     * @param topLeft     The corner radius for the top-left corner.
     * @param topRight    The corner radius for the top-right corner.
     * @param bottomLeft  The corner radius for the bottom-left corner.
     * @param bottomRight The corner radius for the bottom-right corner.
     * @return The current instance of the subclass.
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
     * Sets the background drawable resource for the action button.
     *
     * @param actionButtonBackground The drawable resource ID for the action button background.
     * @return The current instance of the subclass.
     */
    public T setActionButtonBackground(@NonNull @DrawableRes Integer actionButtonBackground) {
        this.actionButtonBackground = actionButtonBackground;
        return castType();
    }

    /**
     * Sets the background color for the action button.
     *
     * @param actionButtonBackgroundColor The color resource ID for the action button background color.
     * @return The current instance of the subclass.
     */
    public T setActionButtonBackgroundColor(@NonNull @DrawableRes Integer actionButtonBackgroundColor) {
        this.actionButtonBackgroundColor = actionButtonBackgroundColor;
        return castType();
    }

    /**
     * Sets the corner radius for the action button.
     *
     * @param actionButtonCornerRadius The corner radius for the action button.
     * @return The current instance of the subclass.
     */
    public T setActionButtonCornerRadius(@NonNull Float actionButtonCornerRadius) {
        this.actionButtonCornerRadius = actionButtonCornerRadius;
        return castType();
    }

    /**
     * Sets the corner radius for the action button.
     *
     * @param topLeft     The corner radius for the top-left corner.
     * @param topRight    The corner radius for the top-right corner.
     * @param bottomLeft  The corner radius for the bottom-left corner.
     * @param bottomRight The corner radius for the bottom-right corner.
     * @return The current instance of the subclass.
     */
    public T setActionButtonCornerRadius(@NonNull Float topLeft, @NonNull Float topRight, @NonNull Float bottomLeft, @NonNull Float bottomRight) {
        this.actionButtonTopLeftCornerRadius = topLeft;
        this.actionButtonTopRightCornerRadius = topRight;
        this.actionButtonBottomLeftCornerRadius = bottomLeft;
        this.actionButtonBottomRightCornerRadius = bottomRight;
        return castType();
    }

    /**
     * Sets the font family for text elements.
     *
     * @param fontFamily The resource ID for the font family.
     * @return The current instance of the subclass.
     */
    public T setFontFamily(@NonNull @FontRes Integer fontFamily) {
        this.fontFamily = resToTypeface(fontFamily);
        return castType();
    }

    /**
     * Sets the font for the dialog heading.
     *
     * @param headingFont The resource ID for the heading font.
     * @return The current instance of the subclass.
     */
    public T setHeadingFont(@NonNull @FontRes Integer headingFont) {
        this.headingFont = resToTypeface(headingFont);
        return castType();
    }

    /**
     * Sets the font for the dialog description.
     *
     * @param descriptionFont The resource ID for the description font.
     * @return The current instance of the subclass.
     */
    public T setDescriptionFont(@NonNull @FontRes Integer descriptionFont) {
        this.descriptionFont = resToTypeface(descriptionFont);
        return castType();
    }

    /**
     * Sets the font for the action button text.
     *
     * @param buttonFont The resource ID for the button font.
     * @return The current instance of the subclass.
     */
    public T setButtonFont(@NonNull @FontRes Integer buttonFont) {
        this.buttonFont = resToTypeface(buttonFont);
        return castType();
    }

    /**
     * Sets the font size for the dialog heading.
     *
     * @param headingFontSize The font size for the heading text.
     * @return The current instance of the subclass.
     */
    public T setHeadingFontSize(@NonNull Float headingFontSize) {
        this.headingFontSize = headingFontSize;
        return castType();
    }

    /**
     * Sets the font size for the dialog description.
     *
     * @param descriptionFontSize The font size for the description text.
     * @return The current instance of the subclass.
     */
    public T setDescriptionFontSize(@NonNull Float descriptionFontSize) {
        this.descriptionFontSize = descriptionFontSize;
        return castType();
    }

    /**
     * Sets the font size for the action button text.
     *
     * @param buttonFontSize The font size for the action button text.
     * @return The current instance of the subclass.
     */
    public T setButtonFontSize(@NonNull Float buttonFontSize) {
        this.buttonFontSize = buttonFontSize;
        return castType();
    }

    /**
     * Converts a resource ID to a Typeface object.
     *
     * @param font The resource ID of the font.
     * @return The corresponding Typeface object.
     */
    private Typeface resToTypeface(@NonNull @FontRes Integer font) {
        return ResourcesCompat.getFont(super.getContext(), font);
    }

    /**
     * Casts the subclass type.
     *
     * @return The current instance of the subclass.
     */
    @SuppressWarnings("unchecked")
    protected T castType() {
        return (T) this;
    }
}
