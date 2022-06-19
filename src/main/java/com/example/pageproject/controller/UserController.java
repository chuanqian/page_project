package com.example.pageproject.controller;


import com.example.pageproject.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author cc980
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/pageproject/user")
public class UserController {
    @Autowired
    IUserService iUserService;
    /**
     * 引入日志，注意都是"org.slf4j"包下
     */
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/getUserList")
    public Map<String,Object> getUserList(/*@Param(value = "currentNum") String currentNum, @Param(value = "pageSize") String pageSize*/){
        logger.info("Processing trade with param1:[{}] and param2: [{}] ", "currentNum", "pageSize");

        Map<String,Object> map = iUserService.getUserList("1","5");
        if(map.get("pageData")==null){
            logger.error("没有用户数据");
        }
        return map;
    }

}
