package com.xbao.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {


        log.debug("=========preHandle  begin==========");
        log.debug("IP : " + getIpAddr(httpServletRequest));
        log.debug("ServerName : " + httpServletRequest.getServerName());
        log.debug("Port : " + httpServletRequest.getServerPort());
        log.debug("ContextPath : " + httpServletRequest.getContextPath());
        log.debug("ServletPath : " + httpServletRequest.getServletPath());
        log.debug("QueryString : " + httpServletRequest.getQueryString());
        log.debug("=========preHandle    end==========");


        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = httpServletRequest.getHeader(name);



                log.info("===========instor===================="+name+"="+values+"==============");
            }
        }



        // 如果不是映射到方法直接通过
//		if (!(handler instanceof HandlerMethod)) {
//			return true;
//		}
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }
        /*HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有UnCheckToken注释，有则跳过认证
        UnCheckToken unCheckToken = method.getAnnotation(UnCheckToken.class);
        if (unCheckToken==null) {
            //检查有没有需要用户权限的注解
            String token = httpServletRequest.getHeader("token");
            log.debug("token : " + token);
            if(token==null)token = "";
            // 执行认证
            String secCode = "";
            PreAuthorize preAuthorize= method.getAnnotation(PreAuthorize.class);
            if (Objects.nonNull(preAuthorize)) {
                secCode = preAuthorize.value();
            }
            ResResult<Boolean> resResult = null;
            try {
                resResult = ((CommonService) SpringContextUtil.getBean("commonService")).getAuthSec(token,secCode);
            } catch (Exception e) {
                e.printStackTrace();
                //未认证（签名错误）
                resResult.setCode(ResCode.UNAUTHORIZED.getCode()).setMsg(ResCode.UNAUTHORIZED.getMsg()).setData(false);
            }


            if(resResult!=null && resResult.getData()){
                return true;
            }else{
                PrintWriter out = null;
                try {
                    httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");  //这句话的意思，是告诉servlet用UTF-8转码，而不是用默认的ISO8859
                    httpServletResponse.setContentType("text/html;charset=UTF-8");
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    out = httpServletResponse.getWriter();
                    out.print(resResult);
                } catch (IOException e) {
                    log.error("错误异常 : " + resResult.getCode(),resResult.getMsg());
                }finally {
                    //释放资源
                    out.flush();
                    out.close();
                    out = null;
                }
                return false;

            }

        } else {
            if (!unCheckToken.required()) {
                return true;
            }
        }*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
