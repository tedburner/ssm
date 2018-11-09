package com.ssm.security;

import com.ssm.common.constant.Constants;
import com.ssm.common.utils.cache.CacheUtils;
import com.ssm.common.utils.http.ResponseCodeEnum;
import com.ssm.common.utils.http.ResponseModel;
import com.ssm.common.utils.http.tools.ResponseTool;
import com.ssm.model.DO.UserDO;
import com.ssm.persist.UserMapper;
import com.ssm.service.cache.JedisSetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Lucifer
 * @date: 2018/10/29 11:37
 * @description:
 */
public class UserAuthFilter extends HandlerInterceptorAdapter {

    @Resource
    private UserMapper userMapper;
    @Autowired
    private JedisSetService jedisSetService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        //请求URI
        String uri = request.getRequestURI();
        //不拦截的URI
        String notFilter = "/user/";
        //是否过滤
        boolean doFilter = !uri.contains(notFilter);

        if (doFilter) {
            String token = "";
            String phone = "";
            String msg = "请重新登录";

            token = request.getParameter(Constants.LOGIN_COOKIC_NAME);
            if (StringUtils.isEmpty(token)) {
                token = request.getHeader(Constants.LOGIN_COOKIC_NAME);
            }

            if (StringUtils.isNotEmpty(token)) {
                phone = jedisSetService.loadFPhoneForToKen(Constants.redisUserInfo, token);

                if (StringUtils.isNotEmpty(phone)) {
                    UserDO userDO = userMapper.selectByPhone(phone);
                    if (null != userDO) {
                        request.setAttribute("userId", userDO.getId());
                        request.setAttribute("phone", userDO.getPhone());
                    }
                }

            } else if (StringUtils.isBlank(token)) {
                ResponseModel responseModel = new ResponseModel();
                responseModel.setStatus(ResponseCodeEnum.LOGIN_FAIL.getCode());
                responseModel.setInfo(msg);
                ResponseTool.writeJsonPToResponse(responseModel, response, request.getParameter("callback"));
                return false;
            }
        }
        return super.preHandle(request, response, handler);
    }
}
