package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBManager;

public class MyService {
	static PreparedStatement preparedStatement = null;    
    static ResultSet resultSet = null;    
    static int updateRowCnt = 0;  
    static int LOGIN_FAILED = 0;  
    static int LOGIN_SUCCEEDED = 1;  
    static int REGISTER_FAILED = 2;  
    static int REGISTER_SUCCEEDED = 3;
    static int ALARM_FAILED = 4;
    static int ALARM_SUCCEEDED = 5;
        
    public static int login(String id, String password) {    
        int result = LOGIN_FAILED;    
        resultSet = null;  
        // ִ�� SQL ��ѯ���    
        String sql = "select * from user_list where id='" + id +"'";    
        try {       
            Connection con = DBManager.getConnection();    
            preparedStatement = con.prepareStatement(sql);    
            try{    
                resultSet = preparedStatement.executeQuery();    
                // ��ѯ���    
                if(resultSet.next()){      
                    if(resultSet.getString("password").equals(password)){  
                        result = LOGIN_SUCCEEDED;  
                        System.out.println("id:" + id   
                            + " username:" + resultSet.getString("username")  
                            + " --login");  
                    }  
                }    
                preparedStatement.close();    
                con.close();    
            }catch(Exception e){    
                e.printStackTrace();    
            }    
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        System.out.println("login service result:" + result);  
        return result;    
    }    
      
    public static int register(String id, String username, String password) {    
        int result = REGISTER_FAILED;    
        updateRowCnt = 0;  
        // ִ�� SQL �������    
        String sql = "insert into user_list(`id`, `username`,`password`) values ('"  
                + id + "', '" + username + "', '" + password + "')";  
        try {       
            Connection con = DBManager.getConnection();    
            preparedStatement = con.prepareStatement(sql);    
            try{    
                updateRowCnt = preparedStatement.executeUpdate();    
                // ������    
                if(updateRowCnt != 0){      
                        result = REGISTER_SUCCEEDED;  
                        System.out.println("id:" + id   
                            + " username:" + resultSet.getString("username")  
                            + " --register");  
                }    
                preparedStatement.close();    
                con.close();    
            }catch(Exception e){    
                e.printStackTrace();    
            }    
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        System.out.println("register service result:" + result);  
        return result;    
    }

    public static int alarm(String id, String hour, String minute,String isvibrate,String state,String repeat,String ringtone,String tag,String username, String password)
    {
        int result = ALARM_FAILED;
        resultSet = null;
        // ִ�� SQL ��ѯ���
        String sql = "insert into alarmtable(`hour`,`minute`,`isvibrate`,`state`,`repeat`,`ringtone`,`tag`, `username`, `password`) values ('" + hour + "', '" + minute + "', '"+ isvibrate + "', '"+ state + "', '"+ repeat + "', '"+ ringtone + "', '" + tag + "', '" + username + "', '" + password + "')";
        try {
            Connection con = DBManager.getConnection();
            preparedStatement = con.prepareStatement(sql);
            try{
                updateRowCnt = preparedStatement.executeUpdate();
                // ������
                if(updateRowCnt != 0){
                    result = ALARM_SUCCEEDED;
                    System.out.println("id:" + id
                            + " username:" + resultSet.getString("username")
                            + " --alarm");
                }
                preparedStatement.close();
                con.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("alarm service result:" + result);
        return result;
    }
}
