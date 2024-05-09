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

package com.saadahmedev.popupdialog.dialog.standard;

import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseStandardDialog;
import com.saadahmedev.popupdialog.databinding.DialogStandardBinding;
import com.saadahmedev.popupdialog.dto.StandardDialogData;
import com.saadahmedev.popupdialog.exception.PopupDialogException;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

/**
 * A dialog class for displaying a standard dialog with positive and negative buttons.
 * <p>
 * This dialog extends {@link BaseStandardDialog} and provides functionalities for creating customizable dialogs
 * with options for positive and negative actions. It allows customization of button backgrounds, colors, corner
 * radius, and ripple effects.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 *
 * @see AlertDialog
 * @see IOSDialog
 */
public class StandardDialog extends BaseStandardDialog<StandardDialog, DialogStandardBinding> {

    /**
     * The drawable resource ID of the icon displayed in the dialog.
     */
    private Integer icon;

    /**
     * The color resource ID of the icon displayed in the dialog.
     */
    private Integer iconColor;

    /**
     * The drawable resource ID of the background for the positive button.
     */
    private Integer positiveButtonBackground;

    /**
     * The drawable resource ID of the background for the negative button.
     */
    private Integer negativeButtonBackground;

    /**
     * The color resource ID of the background for the positive button.
     */
    private Integer positiveButtonBackgroundColor;

    /**
     * The color resource ID of the background for the negative button.
     */
    private Integer negativeButtonBackgroundColor;

    /**
     * The color resource ID of the ripple effect for the positive button.
     */
    private Integer positiveButtonRippleColor;

    /**
     * The color resource ID of the ripple effect for the negative button.
     */
    private Integer negativeButtonRippleColor;

    /**
     * The corner radius for the positive button.
     */
    private Float positiveButtonCornerRadius;

    /**
     * The corner radius for the negative button.
     */
    private Float negativeButtonCornerRadius;

    /**
     * The top left corner radius for the positive button.
     */
    private Float positiveButtonTopLeftCornerRadius;

    /**
     * The top right corner radius for the positive button.
     */
    private Float positiveButtonTopRightCornerRadius;

    /**
     * The bottom left corner radius for the positive button.
     */
    private Float positiveButtonBottomLeftCornerRadius;

    /**
     * The bottom right corner radius for the positive button.
     */
    private Float positiveButtonBottomRightCornerRadius;

    /**
     * The top left corner radius for the negative button.
     */
    private Float negativeButtonTopLeftCornerRadius;

    /**
     * The top right corner radius for the negative button.
     */
    private Float negativeButtonTopRightCornerRadius;

    /**
     * The bottom left corner radius for the negative button.
     */
    private Float negativeButtonBottomLeftCornerRadius;

    /**
     * The bottom right corner radius for the negative button.
     */
    private Float negativeButtonBottomRightCornerRadius;

    /**
     * Constructs a new {@link StandardDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link StandardDialog}.
     */
    private StandardDialog(PopupDialog popupDialog) {
        super(popupDialog, R.layout.dialog_standard);
    }

    /**
     * Gets an instance of the {@link StandardDialog}.
     *
     * @param popupDialog The {@link PopupDialog} associated with this {@link StandardDialog}.
     * @return An instance of the {@link StandardDialog}.
     */
    public static StandardDialog getInstance(PopupDialog popupDialog) {
        return new StandardDialog(popupDialog);
    }

    /**
     * Initializes button corner radius.
     */
    private void init() {
        if (this.positiveButtonCornerRadius != null) {
            this.positiveButtonTopLeftCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonTopRightCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonBottomLeftCornerRadius = this.positiveButtonCornerRadius;
            this.positiveButtonBottomRightCornerRadius = this.positiveButtonCornerRadius;
        }
        else {
            this.positiveButtonTopLeftCornerRadius = this.positiveButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonTopRightCornerRadius = this.positiveButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonBottomLeftCornerRadius = this.positiveButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.positiveButtonBottomRightCornerRadius = this.positiveButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
        }
        if (this.negativeButtonCornerRadius != null) {
            this.negativeButtonTopLeftCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonTopRightCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonBottomLeftCornerRadius = this.negativeButtonCornerRadius;
            this.negativeButtonBottomRightCornerRadius = this.negativeButtonCornerRadius;
        }
        else {
            this.negativeButtonTopLeftCornerRadius = this.negativeButtonTopLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonTopRightCornerRadius = this.negativeButtonTopRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonBottomLeftCornerRadius = this.negativeButtonBottomLeftCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
            this.negativeButtonBottomRightCornerRadius = this.negativeButtonBottomRightCornerRadius == null ? dimenToFloat(R.dimen.dp_5) : 0;
        }
    }

    /**
     * Builds the {@link StandardDialog}.
     *
     * @param listener The listener for dialog actions.
     * @return The built {@link PopupDialog}.
     */
    @Override
    public PopupDialog build(@NonNull StandardDialogActionListener listener) {
        super.build(listener);
        init();
        if (this.icon == null) throw new PopupDialogException("Standard popup dialog icon cannot be null.");
        if (this.iconColor != null) binding.ivIcon.setColorFilter(ContextCompat.getColor(super.getContext(), iconColor), android.graphics.PorterDuff.Mode.SRC_IN);

        if (this.positiveButtonBackground != null) {
            binding.btnPositive.setBackgroundResource(this.positiveButtonBackground);
        }
        else if (this.positiveButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    positiveButtonBackgroundColor,
                    positiveButtonTopLeftCornerRadius,
                    positiveButtonTopRightCornerRadius,
                    positiveButtonBottomLeftCornerRadius,
                    positiveButtonBottomRightCornerRadius
            );

            if (this.positiveButtonRippleColor != null) binding.btnPositive.setBackground(getRipple(shape, this.positiveButtonRippleColor));
            else binding.btnPositive.setBackground(shape);
        }

        if (this.negativeButtonBackground != null) {
            binding.btnNegative.setBackgroundResource(this.negativeButtonBackground);
        }
        else if (this.negativeButtonBackgroundColor != null) {
            GradientDrawable shape = getBackground(
                    negativeButtonBackgroundColor,
                    negativeButtonTopLeftCornerRadius,
                    negativeButtonTopRightCornerRadius,
                    negativeButtonBottomLeftCornerRadius,
                    negativeButtonBottomRightCornerRadius
            );

            if (this.negativeButtonRippleColor != null) binding.btnNegative.setBackground(getRipple(shape, this.negativeButtonRippleColor));
            else binding.btnNegative.setBackground(shape);
        }

        binding.btnPositive.setTypeface(super.buttonFont);
        binding.btnNegative.setTypeface(super.buttonFont);
        binding.tvHeading.setTypeface(super.headingFont);
        binding.tvDescription.setTypeface(super.descriptionFont);
        binding.btnPositive.setTextSize(super.buttonFontSize);
        binding.btnNegative.setTextSize(super.buttonFontSize);
        binding.tvHeading.setTextSize(super.headingFontSize);
        binding.tvDescription.setTextSize(super.descriptionFontSize);

        if (super.background != null) {
            binding.rootLayout.setBackgroundResource(super.background);
        }
        else if (super.backgroundColor != null) {
            binding.rootLayout.setBackground(
                    getBackground(
                            super.backgroundColor,
                            super.backgroundTopLeftCornerRadius,
                            super.backgroundTopRightCornerRadius,
                            super.backgroundBottomLeftCornerRadius,
                            super.backgroundBottomRightCornerRadius
                    )
            );
        }

        binding.setDialog(super.getDialog());
        binding.setListener(listener);

        super.setPositiveButtonTextColor(super.positiveButtonTextColor == null ? R.color.colorWhite : super.positiveButtonTextColor);
        super.setNegativeButtonTextColor(super.negativeButtonTextColor == null ? R.color.colorBlack : super.negativeButtonTextColor);

        binding.setItem(
                new StandardDialogData(
                        this.icon,
                        super.heading,
                        super.description,
                        super.headingTextColor,
                        super.descriptionTextColor,
                        super.positiveButtonTextColor,
                        super.negativeButtonTextColor,
                        super.positiveButtonText,
                        super.negativeButtonText
                )
        );

        return super.getPopupDialog();
    }

    /**
     * Sets the icon for the {@link StandardDialog}.
     *
     * @param icon The drawable resource ID of the icon.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setIcon(@NonNull @DrawableRes Integer icon) {
        this.icon = icon;
        return this;
    }

    /**
     * Sets the color of the icon for the {@link StandardDialog}.
     *
     * @param iconColor The color resource ID of the icon.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setIconColor(@NonNull @ColorRes Integer iconColor) {
        this.iconColor = iconColor;
        return this;
    }

    /**
     * Sets the background resource for the positive button of the {@link StandardDialog}.
     *
     * @param positiveButtonBackground The drawable resource ID of the positive button background.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setPositiveButtonBackground(@NonNull @DrawableRes Integer positiveButtonBackground) {
        this.positiveButtonBackground = positiveButtonBackground;
        return this;
    }

    /**
     * Sets the background resource for the negative button of the {@link StandardDialog}.
     *
     * @param negativeButtonBackground The drawable resource ID of the negative button background.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setNegativeButtonBackground(@NonNull @DrawableRes Integer negativeButtonBackground) {
        this.negativeButtonBackground = negativeButtonBackground;
        return this;
    }

    /**
     * Sets the corner radius for the positive button of the {@link StandardDialog}.
     *
     * @param positiveButtonCornerRadius The corner radius of the positive button.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setPositiveButtonCornerRadius(@NonNull Float positiveButtonCornerRadius) {
        this.positiveButtonCornerRadius = positiveButtonCornerRadius;
        return this;
    }

    /**
     * Sets the corner radius for the negative button of the {@link StandardDialog}.
     *
     * @param negativeButtonCornerRadius The corner radius of the negative button.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setNegativeButtonCornerRadius(@NonNull Float negativeButtonCornerRadius) {
        this.negativeButtonCornerRadius = negativeButtonCornerRadius;
        return this;
    }

    /**
     * Sets the corner radius for the positive button of the {@link StandardDialog} with individual values.
     *
     * @param topLeft     The top left corner radius.
     * @param topRight    The top right corner radius.
     * @param bottomLeft  The bottom left corner radius.
     * @param bottomRight The bottom right corner radius.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setPositiveButtonCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight
    ) {
        this.positiveButtonTopLeftCornerRadius = topLeft;
        this.positiveButtonTopRightCornerRadius = topRight;
        this.positiveButtonBottomLeftCornerRadius = bottomLeft;
        this.positiveButtonBottomRightCornerRadius = bottomRight;

        return this;
    }

    /**
     * Sets the corner radius for the negative button of the {@link StandardDialog} with individual values.
     *
     * @param topLeft     The top left corner radius.
     * @param topRight    The top right corner radius.
     * @param bottomLeft  The bottom left corner radius.
     * @param bottomRight The bottom right corner radius.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setNegativeButtonCornerRadius(
            @NonNull Float topLeft,
            @NonNull Float topRight,
            @NonNull Float bottomLeft,
            @NonNull Float bottomRight
    ) {
        this.negativeButtonTopLeftCornerRadius = topLeft;
        this.negativeButtonTopRightCornerRadius = topRight;
        this.negativeButtonBottomLeftCornerRadius = bottomLeft;
        this.negativeButtonBottomRightCornerRadius = bottomRight;

        return this;
    }

    /**
     * Sets the background color for the positive button of the {@link StandardDialog}.
     *
     * @param positiveButtonBackgroundColor The color resource ID of the positive button background.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setPositiveButtonBackgroundColor(@NonNull @ColorRes Integer positiveButtonBackgroundColor) {
        this.positiveButtonBackgroundColor = positiveButtonBackgroundColor;
        return this;
    }

    /**
     * Sets the background color for the negative button of the {@link StandardDialog}.
     *
     * @param negativeButtonBackgroundColor The color resource ID of the negative button background.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setNegativeButtonBackgroundColor(@NonNull @ColorRes Integer negativeButtonBackgroundColor) {
        this.negativeButtonBackgroundColor = negativeButtonBackgroundColor;
        return this;
    }

    /**
     * Sets the ripple color for the positive button of the {@link StandardDialog}.
     *
     * @param positiveButtonRippleColor The color resource ID of the positive button ripple effect.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setPositiveButtonRippleColor(Integer positiveButtonRippleColor) {
        this.positiveButtonRippleColor = positiveButtonRippleColor;
        return this;
    }

    /**
     * Sets the ripple color for the negative button of the {@link StandardDialog}.
     *
     * @param negativeButtonRippleColor The color resource ID of the negative button ripple effect.
     * @return This {@link StandardDialog} instance.
     */
    public StandardDialog setNegativeButtonRippleColor(Integer negativeButtonRippleColor) {
        this.negativeButtonRippleColor = negativeButtonRippleColor;
        return this;
    }
}
