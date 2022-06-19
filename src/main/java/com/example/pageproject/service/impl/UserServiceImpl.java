package com.example.pageproject.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.pageproject.entity.User;
import com.example.pageproject.mapper.UserMapper;
import com.example.pageproject.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cc980
 * @since 2022-06-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> getUserList(String currentNum,String pageSize) {
        Map<String,Object> map = new HashMap<>(16);
        try {
            Page<User> page = new Page<>(Integer.valueOf(currentNum),Integer.valueOf(pageSize));
            IPage<User> userIPage = userMapper.selectPage(page, null);
            map.put("pageData",userIPage.getRecords());
            map.put("total",userIPage.getTotal());
            map.put("currentNum",userIPage.getCurrent());
            map.put("page_number", userIPage.getPages());
            map.put("msg", "OK");
            map.put("status", 200);
        }catch (Exception e){
            map.put("smg", "ERROR");
            map.put("status", 500);
        }
        return map;
    }
}
