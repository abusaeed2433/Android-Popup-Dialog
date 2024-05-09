package com.caffeine.popupdialog;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.caffeine.popupdialog.databinding.ActivityMainBinding;
import com.saadahmedev.popupdialog.PopupDialog;
import com.saadahmedev.popupdialog.listener.StandardDialogActionListener;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

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
                    .progressDialogBuilder()
                    .createProgressDialog()
                    .setTint(com.saadahmedev.popupdialog.R.color.colorRed)
                    .build()
                    .setCancelable(true)
                    .show();
        });

        binding.buttonIos.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .standardDialogBuilder()
                    .createIOSDialog()
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout?" +
                            " This action cannot be undone")
                    .build(new StandardDialogActionListener() {
                        @Override
                        public void onPositiveButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }

                        @Override
                        public void onNegativeButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        });

        binding.buttonDefault.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .standardDialogBuilder()
                    .createAlertDialog()
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout?" +
                            " This action cannot be undone")
                    .build(new StandardDialogActionListener() {
                        @Override
                        public void onPositiveButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }

                        @Override
                        public void onNegativeButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        });

        binding.buttonStandard.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .standardDialogBuilder()
                    .createStandardDialog()
                    .setHeading("Logout")
                    .setDescription("Are you sure you want to logout?" +
                            " This action cannot be undone")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setIconColor(R.color.purple_200)
                    .build(new StandardDialogActionListener() {
                        @Override
                        public void onPositiveButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }

                        @Override
                        public void onNegativeButtonClicked(Dialog dialog) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        });

        binding.buttonLottie.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .progressDialogBuilder()
                    .createLottieDialog()
                    .setRawRes(R.raw.success)
                    .build()
                    .show();
        });

        binding.buttonSuccess.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .statusDialogBuilder()
                    .createSuccessDialog()
                    .setHeading("Well Done")
                    .setDescription("You have successfully" +
                            " completed the task")
                    .build(Dialog::dismiss)
                    .show();
        });

        binding.buttonFailed.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .statusDialogBuilder()
                    .createErrorDialog()
                    .setHeading("Uh-Oh")
                    .setDescription("Unexpected error occurred." +
                            " Try again later.")
                    .build(Dialog::dismiss)
                    .show();
        });

        binding.buttonAlert.setOnClickListener(view -> {
            PopupDialog.getInstance(this)
                    .statusDialogBuilder()
                    .createWarningDialog()
                    .setHeading("Pending")
                    .setDescription("You verification is under" +
                            " observation. Try again later.")
                    .build(Dialog::dismiss)
                    .show();
        });

    }

}
