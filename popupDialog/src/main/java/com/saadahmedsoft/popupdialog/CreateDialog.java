package com.saadahmedsoft.popupdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class CreateDialog {

    @SuppressLint("StaticFieldLeak")
    private static CreateDialog instance = null;
    private final Context context;
    private final Styles style;
    private final Dialog dialog;

    private String heading, description, positiveButtonText, negativeButtonText;
    private ImageView icon;
    private boolean cancelable = true;

    @ColorInt
    @Nullable
    private Integer tint;

    @ColorRes
    @Nullable
    private Integer positiveButtonTextColor, negativeButtonTextColor, headingTextColor, descriptionTextColor;

    @DrawableRes
    @Nullable
    private Integer dialogBackground, positiveButtonBackground, negativeButtonBackground;

    private OnDialogButtonClickListener listener;

    private CreateDialog(Context context, Styles style, Dialog dialog) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;
    }

    private CreateDialog(Context context, Styles style, Dialog dialog, OnDialogButtonClickListener listener) {
        this.context = context;
        this.style = style;
        this.dialog = dialog;
        this.listener = listener;
    }

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog);
        }
        return instance;
    }

    public static CreateDialog getInstance(Context context, Styles style, Dialog dialog, OnDialogButtonClickListener listener) {
        if (instance == null) {
            instance = new CreateDialog(context, style, dialog, listener);
        }
        return instance;
    }

    public CreateDialog setHeading(String heading) {
        this.heading = heading;
        return instance;
    }

    public CreateDialog setDescription(String description) {
        this.description = description;
        return instance;
    }

    public CreateDialog setPositiveButtonText(String positiveButtonText) {
        this.positiveButtonText = positiveButtonText;
        return instance;
    }

    public CreateDialog setNegativeButtonText(String negativeButtonText) {
        this.negativeButtonText = negativeButtonText;
        return instance;
    }

    public CreateDialog setDialogIcon(@DrawableRes int icon) {
        this.icon.setImageResource(icon);
        return instance;
    }

    public CreateDialog setDialogIconTint(@ColorRes int iconTint) {
        if (this.icon != null) {
            this.icon.setColorFilter(ContextCompat.getColor(context, iconTint), android.graphics.PorterDuff.Mode.SRC_IN);
        }
        return instance;
    }

    public CreateDialog setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        this.dialog.setCancelable(cancelable);
        return instance;
    }

    public CreateDialog setPositiveButtonTextColor(@ColorRes int color) {
        this.positiveButtonTextColor = color;
        return instance;
    }

    public CreateDialog setNegativeButtonTextColor(@ColorRes int color) {
        this.negativeButtonTextColor = color;
        return instance;
    }

    public CreateDialog setHeadingButtonTextColor(@ColorRes int color) {
        this.headingTextColor = color;
        return instance;
    }

    public CreateDialog setDescriptionButtonTextColor(@ColorRes int color) {
        this.descriptionTextColor = color;
        return instance;
    }

    public CreateDialog setDialogBackground(@DrawableRes int background) {
        this.dialogBackground = background;
        return instance;
    }

    public CreateDialog setPositiveButtonBackground(@DrawableRes int background) {
        this.positiveButtonBackground = background;
        return instance;
    }

    public CreateDialog setNegativeButtonBackground(@DrawableRes int background) {
        this.negativeButtonBackground = background;
        return instance;
    }

    public CreateDialog setTint(@ColorInt int tint) {
        this.tint = tint;
        return instance;
    }

    public CreateDialog setTimeout(long seconds) {
        new Handler().postDelayed(dialog::dismiss, seconds * 1000);
        return instance;
    }

    public void showDialog() {
        switch (style) {
            case PROGRESS: {
                showProgressDialog();
                break;
            }
            case ALERT_DIALOG: {
                showAlertDialog();
                break;
            }
            case IOS: {
                dialogStyleOne(R.layout.dialog_ios);
                break;
            }
        }
    }
    
    public void dismissDialog() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
    
    private void show() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    private void showProgressDialog() {
        setContentView(R.layout.dialog_progress);
        ProgressBar progressBar = dialog.findViewById(R.id.progress_bar);
        if (tint != null) {
            progressBar.getIndeterminateDrawable().setColorFilter(tint, PorterDuff.Mode.SRC_IN);
        }
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        show();
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context)
                .setTitle(heading)
                .setMessage(description)
                .setPositiveButton(positiveButtonText, (dialogInterface, i) -> listener.onAction())
                .setNegativeButton(negativeButtonText, ((dialogInterface, i) -> listener.onClose()));
        alertDialog.setCancelable(cancelable);
        alertDialog.show();
    }

    private void dialogStyleOne(@LayoutRes int layout) {
        setContentView(layout);
        TextView heading, description, btnNegative, btnPositive;
        ConstraintLayout root;

        root = dialog.findViewById(R.id.root_layout);
        heading = dialog.findViewById(R.id.tv_heading);
        description = dialog.findViewById(R.id.tv_description);
        btnNegative = dialog.findViewById(R.id.btn_negative);
        btnPositive = dialog.findViewById(R.id.btn_positive);

        if (this.heading != null) {
            heading.setText(this.heading);
        }
        if (this.description != null) {
            description.setText(this.description);
        }
        if (dialogBackground != null) {
            root.setBackgroundResource(dialogBackground);
        }
        if (positiveButtonTextColor != null) {
            btnPositive.setTextColor(ContextCompat.getColor(context, positiveButtonTextColor));
        }
        if (negativeButtonTextColor != null) {
            btnNegative.setTextColor(ContextCompat.getColor(context, negativeButtonTextColor));
        }
        if (positiveButtonBackground != null) {
            btnPositive.setBackgroundResource(positiveButtonBackground);
        }
        if (negativeButtonBackground != null) {
            btnNegative.setBackgroundResource(negativeButtonBackground);
        }
        show();
    }

    private void setContentView(@LayoutRes int layout) {
        dialog.setContentView(layout);
    }
}
