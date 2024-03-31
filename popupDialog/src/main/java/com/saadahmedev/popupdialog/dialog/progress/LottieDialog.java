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
package com.saadahmedev.popupdialog.dialog.progress;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;

import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.R;
import com.saadahmedev.popupdialog.base.BaseDialogBinder;
import com.saadahmedev.popupdialog.databinding.DialogLottieBinding;
import com.saadahmedev.popupdialog.dialogType.ProgressTypeDialog;
import com.saadahmedev.popupdialog.exception.PopupDialogException;

/**
 * A progress dialog class for displaying Lottie animations.
 * This dialog allows displaying Lottie animations either by providing a raw resource ID
 * or an asset file name. It also provides customization options for animation playback.
 * <p>
 * This class extends {@link BaseDialogBinder} to leverage common dialog functionalities.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseDialogBinder
 */
public class LottieDialog extends BaseDialogBinder<LottieDialog, DialogLottieBinding> {

    /**
     * The {@link ProgressTypeDialog} associated with this Lottie dialog.
     */
    private final ProgressTypeDialog progressTypeDialog;

    /**
     * The resource ID of the Lottie animation file.
     */
    private Integer rawRes = null;

    /**
     * The asset file name of the Lottie animation.
     */
    private String asset;

    /**
     * The number of times the animation should be repeated.
     */
    private Integer repeatCount;

    /**
     * The speed of the animation playback.
     */
    private Float animationSpeed;

    /**
     * Constructs a new {@link LottieDialog}.
     *
     * @param progressTypeDialog The progress type dialog associated with this Lottie dialog.
     */
    private LottieDialog(@NonNull ProgressTypeDialog progressTypeDialog) {
        super(progressTypeDialog.getPopupDialog(), R.layout.dialog_lottie);
        this.progressTypeDialog = progressTypeDialog;
    }

    /**
     * Gets an instance of the {@link LottieDialog}.
     *
     * @param progressTypeDialog The progress type dialog associated with this Lottie dialog.
     * @return An instance of the {@link LottieDialog}.
     */
    @NonNull
    public static LottieDialog getInstance(@NonNull ProgressTypeDialog progressTypeDialog) {
        return new LottieDialog(progressTypeDialog);
    }

    /**
     * Sets the Lottie animation by raw resource ID.
     *
     * @param rawRes The resource ID of the Lottie animation file.
     * @return The current instance of the {@link LottieDialog}.
     */
    public LottieDialog setRawRes(@NonNull @RawRes Integer rawRes) {
        this.rawRes = rawRes;
        return this;
    }

    /**
     * Sets the Lottie animation by asset file name.
     *
     * @param asset The asset file name of the Lottie animation.
     * @return The current instance of the {@link LottieDialog}.
     */
    public LottieDialog setAsset(@NonNull String asset) {
        this.asset = asset;
        return this;
    }

    /**
     * Sets the number of times the animation should be repeated.
     *
     * @param repeatCount The number of times the animation should be repeated.
     * @return The current instance of the {@link LottieDialog}.
     */
    public LottieDialog setLottieRepeatCount(@NonNull Integer repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    /**
     * Sets the speed of the animation playback.
     *
     * @param speed The speed of the animation playback.
     * @return The current instance of the {@link LottieDialog}.
     */
    public LottieDialog setLottieAnimationSpeed(@NonNull Float speed) {
        this.animationSpeed = speed;
        return this;
    }

    /**
     * Builds the {@link LottieDialog}.
     *
     * @return The built {@link PopupDialog}.
     * @throws PopupDialogException if no Lottie raw resource or asset file is provided.
     */
    public PopupDialog build() {
        if (this.rawRes == null && this.asset == null) {
            throw new PopupDialogException("No lottie raw resource or asset file provided");
        }

        if (rawRes != null) {
            asset = null;
            binding.lottieAnimationView.setAnimation(rawRes);
        }
        if (asset != null) binding.lottieAnimationView.setAnimation(asset);
        if (repeatCount != null) binding.lottieAnimationView.setRepeatCount(repeatCount);
        if (animationSpeed != null) binding.lottieAnimationView.setSpeed(animationSpeed);

        return progressTypeDialog.getPopupDialog();
    }
}
