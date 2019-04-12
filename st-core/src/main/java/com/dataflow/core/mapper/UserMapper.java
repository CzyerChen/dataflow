package com.dataflow.core.mapper;

import com.dataflow.common.domain.UserPO;
import com.dataflow.common.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


/**
 * Discription  用户映射类
 *
 * @author Claire.Chen
 * @create_time 2019 -03 - 15 10:15
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(UserPO userPO);

    void updateUserFromDto(UserDTO userDTO, @MappingTarget UserPO userPO);

}
