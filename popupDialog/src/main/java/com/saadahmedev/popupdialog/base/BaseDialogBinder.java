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

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.saadahmedev.popupdialog.PopupDialog;


/**
 * {@link BaseDialogBinder} is an abstract class providing a foundation for creating dialog
 * components with data binding capabilities in Android applications. It extends {@link BaseDialog}
 * and offers functionalities for inflating layout resources using Data Binding.
 *
 * @param <T> The type of the {@link PopupDialog}.
 * @param <VB> The type of {@link ViewDataBinding} associated with the layout resource.
 *
 * @author <a href="https://github.com/saadahmedscse">Saad Ahmed</a>
 * @see BaseDialog
 */
public class BaseDialogBinder<T, VB extends ViewDataBinding> extends BaseDialog<T> {

    /** The ViewDataBinding associated with the inflated layout resource. */
    protected final VB binding;

    /**
     * Constructs a new {@link BaseDialogBinder} instance with the provided {@link PopupDialog} and layout resource.
     *
     * @param popupDialog The {@link PopupDialog} instance to associate with this dialog.
     * @param layout The layout resource ID to inflate for this dialog.
     */
    protected BaseDialogBinder(PopupDialog popupDialog, @NonNull @LayoutRes Integer layout) {
        super(popupDialog);

        // Inflate the layout resource and associate with ViewDataBinding
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(super.getContext()),
                layout,
                null,
                false
        );

        // Set the inflated view as the content view of the dialog
        super.getDialog().setContentView(binding.getRoot());

        // Set background of dialog window to transparent
        assert super.getDialog().getWindow() != null;
        super.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
