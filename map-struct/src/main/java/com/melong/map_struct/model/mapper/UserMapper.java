package com.melong.map_struct.model.mapper;

import com.melong.map_struct.model.dto.User;
import com.melong.map_struct.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper extends EntityMapper<User, UserEntity> {
}
