package five.project.bookcam.bookcam.mvc.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;

import java.io.File;

import five.project.bookcam.bookcam.R;

/**
 * Created by user on 2018/1/22.
 */

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);


        if (Environment.getExternalStorageState()//確定SD卡可讀寫
                .equals(Environment.MEDIA_MOUNTED))
        {
            File sd=Environment.getExternalStorageDirectory();
            String path=sd.getPath()+"/BookCam";
            File file=new File(path);
            if(!file.exists()) {file.mkdir();}
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent().setClass(WelcomeActivity.this, LoginActivity.class));
                finish();
            }
        }, 3000);
    }
}