package com.ldb.interceptor;

import com.ldb.pojo.ResultData;
import com.ldb.pojo.Users;
import com.ldb.utils.JsonUtils;
import com.ldb.utils.JwtUtils;
import com.ldb.utils.RsaUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.PublicKey;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2024/01/01 23:07
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if (method.equals("OPTIONS"))
            return true;

        String token=request.getHeader("token");
        try {
            String publicFile = ResourceUtils.getFile("classpath:key/rsa.pub").getPath();
            //获取公钥对象
            PublicKey publicKey = RsaUtils.getPublicKey(publicFile);
            Users users = (Users) JwtUtils.getInfoFromToken(token, publicKey, Users.class);
            if (users.getUsername() != null && !users.getUsername().equals(""))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultData resultData = new ResultData(403, "无权访问");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(JsonUtils.toString(resultData));
        return false;
    }
}
