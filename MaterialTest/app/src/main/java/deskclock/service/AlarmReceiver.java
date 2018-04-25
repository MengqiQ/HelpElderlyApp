//package deskclock.service;
//
//import android.util.Log;
//
//import org.apache.http.NameValuePair;
//
//import java.util.List;
//
//import login.MyHttpPost;
//
///**
// * Created by Administrator on 2016/8/27 0027.
// */
//public class AlarmReceiver {
//    static int LOGIN_FAILED = 0;
//    static int LOGIN_SUCCEEDED = 1;
//    static int Register_FAILED = 2;
//    static int Register_SUCCEEDED = 3;
//    static int ALARM_FAILED = 4;
//    static int ALARM_SUCCEEDED = 5;
//
//    public static int send(List<NameValuePair> params) {
//        // 返回值
//        int responseInt = Alarm_FAILED;
//        // 定位服务器的Servlet
//        String servlet = "AlarmServlet";
//        // 通过 POST 方式获取 HTTP 服务器数据
//        String responseMsg;
//        responseMsg = MyHttpPost.executeHttpPost(servlet, params);
//        Log.i("tag", "AlarmService: responseMsg = " + responseMsg);
//        // 解析服务器数据，返回相应 Long 值
//        if(responseMsg.equals("SUCCEEDED")) {
//            responseInt = Alarm_SUCCEEDED;
//        }
//        return responseInt;
//    }
//}

package deskclock.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import deskclock.ui.AlarmActivity;

/**
 * Created by H on 2016/7/12.
 */
public class AlarmReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d("AlarmReceiverLog", "Broadcast has received");
        if(action.equals("com.vancior.deskclock.ACTION_ALARM")) {
            Bundle bundle = intent.getExtras();

            Log.d("AlarmReceiverLog", "Broadcast has received");
            Intent ringIntent = new Intent(context, AlarmActivity.class);
            ringIntent.putExtras(bundle);
            ringIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(ringIntent);
        }
    }

}
