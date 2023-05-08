package com.melong.map_struct.model.mapper;

import com.melong.map_struct.model.dto.Channel;
import com.melong.map_struct.model.entity.ChannelEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChannelMapper extends EntityMapper<Channel, ChannelEntity> {
}
