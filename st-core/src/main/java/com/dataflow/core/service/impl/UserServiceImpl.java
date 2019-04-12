package com.dataflow.core.service.impl;

import com.dataflow.common.domain.UserPO;
import com.dataflow.common.domain.dto.UserDTO;
import com.dataflow.core.mapper.UserMapper;
import com.dataflow.core.repository.UserRepository;
import com.dataflow.core.service.UserService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.Date;

/**
 * Desciption 用户服务类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 06 11:34
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;


    /**
     * 保存用户
     * @param dto
     * @return
     */
    @Override
    public UserDTO saveUser(UserDTO dto) {
        if(dto.getCreateTime() == null){
            dto.setCreateTime(new Date());
        }
        if(dto.getUpdateTime() == null){
            dto.setUpdateTime(new Date());
        }
        UserPO userPO = new UserPO();
        userMapper.updateUserFromDto(dto,userPO);
        UserPO po = userRepository.save(userPO);
        Preconditions.checkNotNull(po);
        return userMapper.userToUserDTO(po);
    }

    /**
     * 删除用户
     * @param id
     */
    @Override
    public void deleteUserById(int id){
        UserPO user = userRepository.findByIdAndDeleted(id,false);
        if(user != null){
            user.setDeleted(true);
            userRepository.save(user);
        }
    }

    /**
     * 根据ID获取用户
     * @param id
     * @return
     */
    @Override
    public UserDTO getUserById(int id) {
        UserPO userPO = userRepository.findByIdAndDeleted(id,false);
        UserPO checkNotNull = Preconditions.checkNotNull(userPO);
        return userMapper.userToUserDTO(checkNotNull);
    }
}
