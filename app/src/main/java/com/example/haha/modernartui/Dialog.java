package com.example.haha.modernartui;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created by haha on 3/16/2015.
 */
public class Dialog extends DialogFragment {
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(getResources().getString(R.string.DialogMes))
                .setPositiveButton(getResources().getString(R.string.dialogYes),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    OpenWebSiteMOMA();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.dialogNO),new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    //Nope
                    }
                });

        return builder.create();
    }
    public void OpenWebSiteMOMA()
    {
        // Open moma website
        Intent intent;
        Uri website = Uri.parse("http://www.moma.org/");
        intent = new Intent(Intent.ACTION_VIEW,website);
        startActivity(intent);
    }


}
