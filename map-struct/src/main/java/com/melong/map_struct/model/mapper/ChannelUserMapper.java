package com.melong.map_struct.model.mapper;

import com.melong.map_struct.model.dto.ChannelUser;
import com.melong.map_struct.model.entity.ChannelUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChannelUserMapper extends EntityMapper<ChannelUser, ChannelUserEntity> {
}
