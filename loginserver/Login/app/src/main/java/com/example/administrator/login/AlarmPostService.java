//package com.example.administrator.login;
//
//import android.util.Log;
//
//import org.apache.http.NameValuePair;
//
//import java.util.List;
//
///**
// * Created by mengqiqin on 17/5/22.
// */
//
//public class AlarmPostService
//
//    /**
//     * Created by Administrator on 2016/8/27 0027.
//     */{
//        static int LOGIN_FAILED = 0;
//        static int LOGIN_SUCCEEDED = 1;
//        static int Register_FAILED = 2;
//        static int Register_SUCCEEDED = 3;
//        static int Alarm_FAILED = 4;
//        static int Alarm_SUCCEEDED = 5;
//
//        public static int send(List<NameValuePair> params) {
//            // 返回值
//            int responseInt = Alarm_FAILED;
//            // 定位服务器的Servlet
//            String servlet = "AlarmServlet";
//            // 通过 POST 方式获取 HTTP 服务器数据
//            String responseMsg;
//            responseMsg = MyHttpPost.executeHttpPost(servlet, params);
//            Log.i("tag", "RegisterService: responseMsg = " + responseMsg);
//            // 解析服务器数据，返回相应 Long 值
//            if(responseMsg.equals("SUCCEEDED")) {
//                responseInt = Alarm_SUCCEEDED;
//            }
//            return responseInt;
//        }
//    }
//
