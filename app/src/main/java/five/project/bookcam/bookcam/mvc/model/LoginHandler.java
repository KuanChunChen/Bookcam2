package five.project.bookcam.bookcam.mvc.model;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.Serializable;

import static android.R.attr.text;

public class LoginHandler extends Handler {
       Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");//取出key中的字串存入val

        }
    };

    Handler handler_Error = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
           // Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
        }
    };

    Handler handler_Nodata = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            //Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
        }
    };



}
