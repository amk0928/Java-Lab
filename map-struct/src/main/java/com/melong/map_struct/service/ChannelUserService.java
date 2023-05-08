package com.melong.map_struct.service;

import com.melong.map_struct.model.dto.Channel;
import com.melong.map_struct.model.dto.User;
import com.melong.map_struct.model.entity.ChannelEntity;
import com.melong.map_struct.model.entity.ChannelUserEntity;
import com.melong.map_struct.model.entity.UserEntity;
import com.melong.map_struct.model.mapper.ChannelMapper;
import com.melong.map_struct.model.mapper.ChannelUserMapper;
import com.melong.map_struct.repository.ChannelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelUserService {
    private final ChannelMapper channelMapper;
    private final ChannelRepository channelRepository;
    private final ChannelService channelService;
    private final ChannelUserMapper channelUserMapper;
    private final UserService userService;

    @Transactional
    public void subscribeUser(Channel channel, User user) throws Exception {
        ChannelEntity channelEntity = channelService.getChannelEntity(channel.getSeq());
        UserEntity userEntity = userService.getUserEntity(user);

        ChannelUserEntity channelUserEntity = new ChannelUserEntity();
        channelUserEntity.setChannel(channelEntity);
        channelUserEntity.setUser(userEntity);

        channelEntity.getChannelUserList().add(channelUserEntity);
        channelRepository.save(channelEntity);
    }
}
