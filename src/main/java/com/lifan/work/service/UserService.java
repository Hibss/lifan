package com.lifan.work.service;

import com.lifan.work.mapper.UserMapper;
import com.lifan.work.model.User;
import com.lifan.work.model.vo.UserVO;
import com.lifan.work.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/7/13 11:23
 */
@Service
public class UserService {

    @Autowired
    protected UserMapper userMapper;

    public User getUserByVO(UserVO userVO) {
        return userMapper.getByName(userVO.getName(),userVO.getPassword());
    }

    public Boolean insert(UserVO userVO){
        User user = BeanUtil.map(userVO,User.class);
        return userMapper.insert(user)==1;
    }
}
