package com.orange.hzm.service.impl;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.hzm.pojo.entity.User;
import com.orange.hzm.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>,User> implements UserService {
}
