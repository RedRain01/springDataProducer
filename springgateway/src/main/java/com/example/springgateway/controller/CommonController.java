package com.example.springgateway.controller;

import com.example.springpublic.entity.base.BaseOut;
import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.base.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
@Slf4j
@RestController
public class CommonController {


    @ResponseBody
    @RequestMapping("/login")
    public String addOrderDetil(@RequestBody Event event){
        String addOrderDetil = eventService.addEvent(event);
        return addOrderDetil;
    }
    /**
     * 登录接口
     * @return
     */
    @RequestMapping("/login")
    public BaseOut login(@RequestBody Map<String, Object> param, HttpServletRequest request) {
        String userCode = (String) param.get("userCode");
        log.info("[" + userCode + "]开始登录");
        String password = (String) param.get("password");
        if (StringUtils.isEmpty(userCode) || StringUtils.isEmpty(password)) {
            return new BaseOut(ResultCode.ERROR);
        }
        // 1.账号是否存在
        CorporateInfomationPojo corporate = null;
        try {
            corporate = corporateManageService.queryByUserCode(userCode);
            if (corporate == null) {
                return new BaseOut(ResultCode.ERROR, "账号不存在");
            }
        } catch (Exception e) {
            log.error("系统异常", e);
            return new BaseOut(ResultCode.FAIL);
        }

        // 2.密码解密
        HttpSession session = request.getSession();
        String mcryptKey = CommonUtil.decryptByMcryptKey(session);
        if(mcryptKey == null) {
            return new BaseOut(ResultCode.ERROR, "解密失败");
        }
        try {
            password = CommonUtil.passWordDecrypt(password, mcryptKey);
        } catch (Exception e1) {
            LOGGER.error("密码有误，解密失败", e1);
            return new BaseOut(ResultCode.ERROR, "密码有误");
        }

        // 3.验证证号密码
        try {
            userHessianServer.checkLoginPassword(userCode, password);
            UserBean user = new UserBean();
            user.setUserCode(corporate.getUserCode());
            user.setUserName(corporate.getUserName());
            user.setRegTime(new Date());
            user.setBreakfastStartTime(corporate.getBreakfastStarTime());
            user.setLunchStartTime(corporate.getLunchStarTime());
            user.setDinnerStartTime(corporate.getDinnerStarTime());
            session.setAttribute(com.yspay.common.config.Constant.USER_INFO, user);
            LOGGER.info("登录成功");
            return new BaseOut(ResultCode.SUCCESS);
        } catch (OperException e) {
            if(e.getErrorCode().equals(CustErrorCode.Code6042.getCode())) {
                return new BaseOut(ResultCode.ERROR, e.getErrorCode()+"：账号密码不匹配");
            } else if(e.getErrorCode().equals(CustErrorCode.Code6025.getCode())){
                return new BaseOut(ResultCode.ERROR, e.getErrorCode()+"：银盛账号不存在");
            }
            return new BaseOut(ResultCode.FAIL, "登录失败，错误码：" + e.getErrorCode());
        } catch (Exception e2) {
            log.error("登录失败，获取用户异常", e2);
            return new BaseOut(ResultCode.FAIL, "登录失败，请重试");
        }
    }

}
