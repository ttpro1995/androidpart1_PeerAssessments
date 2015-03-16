package com.example.haha.modernartui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    public ImageView left1;
    public int[] colorDefault;
    public ImageView left2;
    public ImageView right1;
    public ImageView right2;
    public ImageView right3;
    public SeekBar mSeekBar;
    public Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Dialog
        mDialog = new Dialog();


//Default color
        colorDefault = new int[5];
        colorDefault[0]=getResources().getColor(R.color.Color1);
        colorDefault[1]=getResources().getColor(R.color.Color2);
        colorDefault[2]=getResources().getColor(R.color.Color3);
        colorDefault[3]=getResources().getColor(R.color.Color4);
        colorDefault[4]=getResources().getColor(R.color.Color5);

//TODO: match variable with view id
        left1 = (ImageView) findViewById(R.id.Left1);
        left2 = (ImageView) findViewById(R.id.Left2);
        right1 = (ImageView) findViewById(R.id.Right1);
        right2 = (ImageView) findViewById(R.id.Right2);
        right3 = (ImageView) findViewById(R.id.Right3);
        mSeekBar = (SeekBar) findViewById(R.id.MySeakBarID);
        mSeekBar.setProgress(0);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                UpdateColor(progress,left1,0);
                UpdateColor(progress,left2,1);
                UpdateColor(progress,right1,2);
                UpdateColor(progress,right2,3);
                UpdateColor(progress,right3,4);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void UpdateColor(int progress,ImageView imageView,int index)
    {

       //TODO :color
        int colorID = colorDefault[index];
        colorID = colorID+progress*5;
       // Color color = new Color();
      //  int blue = color.blue(colorID);
      //  int alpha = color.alpha(colorID);
      //  int red = color.red(colorID);
      //  int green = color.green(colorID);
//TODO : perfect this

       // colorID= color.argb(alpha,red,green,blue);

        imageView.setBackgroundColor(colorID);
Log.i("COLOR","= "+colorID);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.More_Information)
        {
            mDialog.show(getFragmentManager(),"MoreInformation");
            return true;
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
