//package com.example.administrator.login;
//
///**
// * Created by mengqiqin on 17/5/22.
// */
//
//import android.app.Dialog;
//import android.content.Context;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//
////import deskclock.ui.AlarmListActivity;
//
////import static android.R.attr.tag;
////import static com.example.administrator.login.R.drawable.minute;
////import static com.example.administrator.login.R.id.alarmBtn;
////import static com.example.administrator.login.R.id.password2;
//
///**
// * Created by mengqiqin on 17/5/22.
// */
//
//public class AlarmActivity extends AppCompatActivity {
//
//
//    /**
//     * Created by Administrator on 2016/8/27 0027.
//     */
//    EditText id, hour,minute,isvibrate,state,repeat,ringtone, tag, username, password;
//    Button alarmBtn;
//    //Button returnBtn;
//
//    Dialog dialog;
//    Handler handler;
//    static int LOGIN_FAILED = 0;
//    static int LOGIN_SUCCEEDED = 1;
//    static int REGISTER_FAILED = 2;
//    static int REGISTER_SUCCEEDED = 3;
//    static int Alarm_FAILED = 4;
//    static int Alarm_SUCCEEDED = 5;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_alarm);
//        id = (EditText)findViewById(R.id.id);
//        hour = (EditText)findViewById(R.id.hour);
//        minute = (EditText)findViewById(R.id.minute);
//        isvibrate = (EditText)findViewById(R.id.isvibrate);
//        state = (EditText)findViewById(R.id.state);
//        repeat = (EditText)findViewById(R.id.repeat);
//        ringtone = (EditText)findViewById(R.id.ringtone);
//        tag = (EditText)findViewById(R.id.tag);
//        username = (EditText)findViewById(R.id.username);
//        password = (EditText)findViewById(R.id.password);
//        alarmBtn = (Button)findViewById(R.id.alarmBtn);
//        //returnBtn = (Button)findViewById(R.id.returnBtn);
//
//        alarmBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(checkEdit()){//检查注册信息
//                    if(isConnectingToInternet()){ //检查网络
//                        if (id.getText().toString().equals(""))
//                            Toast.makeText(com.example.administrator.login.AlarmActivity.this, "请输入提醒", Toast.LENGTH_SHORT).show();
//                        else {
//                            //启动登录Thread
//                            dialog = new Dialog(com.example.administrator.login.AlarmActivity.this);
//                            dialog.setTitle("正在访问，请稍后...");
//                            dialog.setCancelable(false);
//                            dialog.show();
//                            new com.example.administrator.login.AlarmActivity.AlarmPostThread(id.getText().toString(),
//                                    hour.getText().toString(),
//                                    minute.getText().toString(),
//                                    isvibrate.getText().toString(),
//                                    state.getText().toString(),
//                                    repeat.getText().toString(),
//                                    ringtone.getText().toString(),
//                                    tag.getText().toString(),
//                                    username.getText().toString(),
//                                    password.getText().toString()).start();
//                        }
//                    }else{
//                        Toast.makeText(getApplicationContext(),
//                                "网络未连接",Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//
//        //Handle,Msg返回成功信息，跳转到其他Activity
//        handler = new Handler() {
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                dialog.dismiss();
//                if (msg.what == 222) {  // 处理发送线程传回的消息
//                    if(msg.obj.toString().equals("SUCCEEDED")){
//                        Log.i("tag", "注册模拟跳转");
//                        //跳转
//                        Toast.makeText(AlarmActivity.this, "设置完成", Toast.LENGTH_SHORT).show();
//                        //startActivity(new Intent(com.example.administrator.login.AlarmActivity.this, AlarmListActivity.class));
//                    }else{
//                        Toast.makeText(com.example.administrator.login.AlarmActivity.this, "账号已被注册，注册失败", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        };
//
//        /*
//        returnBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //回到登录Activity
//                Intent intent = new Intent(RegisterActivity.this,
//                        LoginActivity.class);
//                startActivity(intent);
//            }
//        });*/
//    }
//
//    //注册Thread调用RegisterPostService，返回Msg
//    public class AlarmPostThread extends Thread {
//        public String id,hour,minute,isvibrate,state,repeat,ringtone, tag,  username, password;
//
//        public AlarmPostThread(String id,String hour, String minute,String isvibrate,String state,String repeat,String ringtone,String tag, String username, String password) {
//            this.id = id;
//            this.hour = hour;
//            this.minute = minute;
//            this.isvibrate = isvibrate;
//            this.state = state;
//            this.repeat = repeat;
//            this.ringtone = ringtone;
//            this.tag = tag;
//            this.username = username;
//            this.password = password;
//
//        }
//
//        @Override
//        public void run() {
//            // Sevice传回int
//            int responseInt = 0;
//            if(!id.equals("")) {
//                // 要发送的数据
//                List<NameValuePair> params = new ArrayList<NameValuePair>();
//                params.add(new BasicNameValuePair("id", id));
//                params.add(new BasicNameValuePair("hour", hour));
//                params.add(new BasicNameValuePair("minute", minute));
//                params.add(new BasicNameValuePair("isvibrate", isvibrate));
//                params.add(new BasicNameValuePair("state", state));
//                params.add(new BasicNameValuePair("repeat", repeat));
//                params.add(new BasicNameValuePair("ringtone", ringtone));
//                params.add(new BasicNameValuePair("tag", tag));
//                params.add(new BasicNameValuePair("username", username));
//                params.add(new BasicNameValuePair("password", password));
//                // 发送数据，获取对象
//                responseInt = AlarmPostService.send(params);
//                Log.i("tag", "AlarmActivity: responseInt = " + responseInt);
//                // 准备发送消息
//                Message msg = handler.obtainMessage();
//                // 设置消息默认值
//                msg.what = 222;
//                // 服务器返回信息的判断和处理
//                if(responseInt == Alarm_FAILED) {
//                    msg.obj = "FAILED";
//                }else if(responseInt == Alarm_SUCCEEDED) {
//                    msg.obj = "SUCCEEDED";
//                }
//                handler.sendMessage(msg);
//            }
//        }
//    }
//
//    //检查注册信息
//    public boolean checkEdit(){
////            if(id.getText().toString().equals("")){
////                Toast.makeText(com.example.administrator.login.AlarmActivity.this, "账户不能为空", Toast.LENGTH_SHORT).show();
////                return false;
////            }
////            if(password.getText().toString().equals("")){
////                Toast.makeText(com.example.administrator.login.AlarmActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
////                return false;
////            }
////            if(!password2.getText().toString().equals(password.getText().toString())){
////                Toast.makeText(com.example.administrator.login.AlarmActivity.this, "两次输入的密码不同", Toast.LENGTH_SHORT).show();
////                return false;
////            }
////            if(username.getText().toString().equals("")){
////                Toast.makeText(com.example.administrator.login.AlarmActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
////                return false;
////            }
//        return true;
//    }
//
//    // 检测网络状态
//    public boolean isConnectingToInternet() {
//        ConnectivityManager connectivity = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivity != null) {
//            NetworkInfo[] info = connectivity.getAllNetworkInfo();
//            if (info != null)
//                for (int i = 0; i < info.length; i++)
//                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
//                    {
//                        return true;
//                    }
//        }
//        return false;
//    }
//}
//
//
//
