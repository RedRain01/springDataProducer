package com.example.springservice.service;


import com.example.springservice.model.UserDomain;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2018/4/19.
 */

//@FeignClient(name = "mongodbServer")
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);

    @RequestMapping(value = "/mongo", method = RequestMethod.GET)
    String mongo();

}
