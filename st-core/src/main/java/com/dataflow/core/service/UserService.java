package com.dataflow.core.service;


import com.dataflow.common.domain.dto.UserDTO;

/**
 * 用户服务类
 */
public interface UserService {

    public UserDTO saveUser(UserDTO dto);

    public void deleteUserById(int id);

    public UserDTO getUserById(int id);
}
