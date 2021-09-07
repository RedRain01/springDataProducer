package com.example.springgateway.controller;

import com.example.springgateway.service.EventService;
import com.example.springgateway.service.EventUserService;
import com.example.springpublic.entity.base.BaseOut;
import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.base.ResultCode;
import com.example.springpublic.entity.event.EventUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Slf4j
@RestController
public class CommonController {
    @Autowired
    EventUserService eventUserService;

    @Autowired
    EventService eventService;


    @ResponseBody
    @RequestMapping("/login123")
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
        EventUser eventUser = null;
        try {
            List<EventUser> eventUsersList = eventUserService.queryByEventUser(eventUser);
            if (eventUsersList == null||eventUsersList.size()<1) {
                return new BaseOut(ResultCode.ERROR, "账号不存在");
            }
            if (password.equals(eventUsersList.get(0).getPassword())) {
                LOGGER.info("登录成功");
                HttpSession session = request.getSession();
                session.setAttribute("eventUser", eventUsersList.get(0));
                return new BaseOut(ResultCode.SUCCESS);
            }else {
                return new BaseOut(ResultCode.FAIL, "登录失败，密码错误");
            }
        } catch (Exception e) {
            log.error("系统异常", e);
            return new BaseOut(ResultCode.FAIL, "登录失败，错误码：" + e.getMessage());
        }
    }

}
