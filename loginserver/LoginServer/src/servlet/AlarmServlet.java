package servlet;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;


/**
 * Servlet implementation class LoginServlet
 */

public class AlarmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    static int LOGIN_FAILED = 0;
    static int LOGIN_SUCCEEDED = 1;
    static int REGISTER_FAILED = 2;
    static int REGISTER_SUCCEEDED = 3;
    static int ALARM_FAILED = 4;
    static int ALARM_SUCCEEDED = 5;

    public AlarmServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // �����ַ���
        String responseMsg="FAILED";
        // �����
        PrintWriter out = response.getWriter();
        // ���ñ�����ʽ
        request.setCharacterEncoding("utf-8");
        // ��ȡ��������
        String id = request.getParameter("id");
        String hour = request.getParameter("hour");
        String minute = request.getParameter("minute");
        String isvibrate = request.getParameter("isvibrate");
        String state = request.getParameter("state");
        String repeat = request.getParameter("repeat");
        String ringtone = request.getParameter("ringtone");
        String tag = request.getParameter("tag");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("id:" + id + " --try to set alarm");

        // �������ݿ�
        int value = MyService.alarm(id,hour,minute,isvibrate,state,repeat,ringtone,tag, username, password);
        if(value == ALARM_SUCCEEDED) {
            responseMsg = "SUCCEEDED";
        }
        System.out.println("register servlet responseMsg:" + responseMsg);
        out.print(responseMsg);
    }

}
