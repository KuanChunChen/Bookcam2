package five.project.bookcam.bookcam.mvc.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import five.project.bookcam.bookcam.R;
import five.project.bookcam.bookcam.mvc.model.LoginRunnable;

/**
 * Created by user on 2018/1/22.
 */

public class LoginActivity extends Activity {

    private TextView text;
    private EditText user, password;
    private Button loginbutton, signupbutton;
    private String CheckPassword;
    private String abc="123";
    private Thread checkdata;
    private LoginRunnable getLogindata ;



    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initView();
       // checkdata_btn();
        signup_btn();
    }


   private void checkdata_btn(){
        loginbutton.setOnClickListener(new Button.OnClickListener(){

            @Override

            public void onClick(View v) {

                //確認是否為空值

                if (password.getText().toString().isEmpty() && user.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "請輸入帳號密碼", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "尚未輸入密碼", Toast.LENGTH_SHORT).show();

                }else if(user.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "尚未輸入使用者名稱", Toast.LENGTH_SHORT).show();
                }else {


                    //呼叫runnable
                    getLogindata = new LoginRunnable();
                    //傳送uesrid給loginrunnable
                    getLogindata.setUserid(user.getText().toString());
                    checkdata = new Thread(getLogindata);
                    checkdata.start();


                    try {
                        checkdata.join();

                    } catch (InterruptedException e) {
                        Toast.makeText(getApplicationContext(), " 連線逾時", Toast.LENGTH_LONG).show();

                    }

                    //從LoginHandler取出val值
                    CheckPassword = getLogindata.getPassword();
                    //判斷帳密與DB是否相同

                    if (CheckPassword== "連線失敗") {
                        Toast.makeText(getApplicationContext(), CheckPassword, Toast.LENGTH_LONG).show();
                        startActivity(new Intent().setClass(LoginActivity.this, MainFragment.class));

                    }

                    else if (CheckPassword == "無資料")
                        Toast.makeText(getApplicationContext(), CheckPassword, Toast.LENGTH_LONG).show();
                    else {

                        if (password.getText().toString() == CheckPassword) {
                            Toast.makeText(getApplicationContext(), "登入成功", Toast.LENGTH_LONG).show();





                        }

                        else {
                            startActivity(new Intent().setClass(LoginActivity.this, MainFragment.class));

                            Toast.makeText(getApplicationContext(), "帳號密碼錯誤"+password.getText().toString()+CheckPassword, Toast.LENGTH_LONG).show();
                        }



                    }

                }






            }

        }); //登入按鈕結束
    }

    private void signup_btn(){
        signupbutton.setOnClickListener(new Button.OnClickListener() {
            @Override

            public void onClick(View v) {
                startActivity(new Intent().setClass(LoginActivity.this, MainFragment.class));






        }

        });
    }

    private void initView(){user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        loginbutton = (Button) findViewById(R.id.login_btn);
        signupbutton = (Button) findViewById(R.id.signup_btn);
        text = (TextView) findViewById(R.id.textView);

    }





}