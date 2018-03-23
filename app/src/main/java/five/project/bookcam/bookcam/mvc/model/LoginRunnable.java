package five.project.bookcam.bookcam.mvc.model;

import android.os.Bundle;
import android.os.Message;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;



public class LoginRunnable implements Runnable{


    private LoginHandler getmessage;
    private String userid;
    private String val="0";

    //專教server
    //final String url = "http://140.115.80.225/getdata.php";

    //test server
     final String url = "http://140.115.80.225/getdata.php";// 連線位置


    //LoginActivity傳過來的值 //設定val的值
    public void setUserid(String userid)
    {
        this.userid = userid;
    }
    public void setVal(String key){ this.val = key; }
    public String getPassword() { return this.val; }



    public void run() {
            //
            // TODO: http request.
            //
            Message msg = new Message();
            Bundle data = new Bundle();
            msg.setData(data);
            try
            {
                //連線到 url網址
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost method = new HttpPost(url);

                //傳值給PHP
                List<NameValuePair> vars=new ArrayList<NameValuePair>();
                vars.add(new BasicNameValuePair("number",userid));
                method.setEntity(new UrlEncodedFormEntity(vars));

                //接收PHP回傳的資料
                HttpResponse response = httpclient.execute(method);
                HttpEntity entity = response.getEntity();

              if(entity != null){
                   data.putString("key", EntityUtils.toString(entity,"utf-8"));//如果成功將網頁內容存入key
                  //handler_Success.sendMessage(msg);
                  val = data.getString("key");//取出key中的字串存入val
                  setVal(val);
                }
                else{
                    data.putString("key","無資料");
                    //handler_Nodata.sendMessage(msg);
                  val = data.getString("key");//取出key中的字串存入val
                  setVal(val);
                }
            }
            catch(Exception e){
                data.putString("key","連線失敗");
                //handler_Error.sendMessage(msg);
                val = data.getString("key");//取出key中的字串存入val
                setVal(val);
            }

        }
    };


