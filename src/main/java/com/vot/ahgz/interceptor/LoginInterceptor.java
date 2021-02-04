package com.vot.ahgz.interceptor;

import com.vot.ahgz.entity.UserTable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;


@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserTable userTable = (UserTable) session.getAttribute("user");
        if (null == userTable) {
            String ip = (StringUtils.substring(InetAddress.getLocalHost().toString(),InetAddress.getLocalHost().toString().lastIndexOf("/")+1));
            response.sendRedirect("http://"+ip+":8080/");
            return false;
        }else {
            return true;
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
