package com.example.pageproject.service;

import com.example.pageproject.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author cc980
 * @since 2022-06-10
 */
public interface IUserService extends IService<User> {
    Map<String,Object> getUserList(String currentNum,String pageSize);

}
