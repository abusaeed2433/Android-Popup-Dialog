package com.caffeine.popupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import com.caffeine.popupdialog.databinding.ActivityMainBinding;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setClickListener();
    }

    private void setClickListener(){

        binding.buttonProgress.setOnClickListener(view ->{
            PopupDialog.getInstance(this)
                    .setStyle(Styles.PROGRESS)
                    .setProgressDialogTint(getResources().getColor(com.saadahmedsoft.popupdialog.R.color.colorRed))
                    .setCancelable(true)
                    .showDialog();
        });

        binding.buttonIos.setOnClickListener(view -> {
            showPopupTwoButton(
                    Styles.IOS
            );
        });

        binding.buttonDefault.setOnClickListener(view -> {
            showPopupTwoButton(
                    Styles.ANDROID_DEFAULT
            );
        });

        binding.buttonStandard.setOnClickListener(view -> {
            showPopupTwoButton(
                    Styles.STANDARD
            );
        });

        binding.buttonLottie.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .setStyle(Styles.LOTTIE_ANIMATION)
                    .setLottieRawRes(com.saadahmedsoft.popupdialog.R.raw.failed)
                    .setCancelable(true)
                    .showDialog();
        });

        binding.buttonSuccess.setOnClickListener(view -> {
            showPopup(Styles.SUCCESS,"Well Done","You have successfully completed the task");
        });

        binding.buttonFailed.setOnClickListener(view -> {
            showPopup(Styles.ALERT,"Pending","You verification is under observation. Try again later.");
        });

        binding.buttonAlert.setOnClickListener(view -> {
            showPopup(Styles.FAILED,"Uh-Oh","Unexpected error occurred. Try again later.");
        });

    }

    private void showPopupTwoButton(Styles style){
        PopupDialog.getInstance(this)
                .setStyle(style)
                .setHeading("Logout")
                .setDescription("Are you sure you want to logout? This action cannot be undone")
                .setCancelable(false)
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onPositiveClicked(Dialog dialog) {
                        super.onPositiveClicked(dialog);
                    }

                    @Override
                    public void onNegativeClicked(Dialog dialog) {
                        super.onNegativeClicked(dialog);
                    }
                });
    }
    private void showPopup(Styles style, String heading, String description){
        PopupDialog.getInstance(this)
                .setStyle(style)
                .setHeading(heading)
                .setDescription(description)
                .setCancelable(false)
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        super.onDismissClicked(dialog);
                    }
                });
    }

}
