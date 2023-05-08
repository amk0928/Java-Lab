package com.melong.map_struct.service;

import com.melong.map_struct.model.dto.Channel;
import com.melong.map_struct.model.dto.User;
import com.melong.map_struct.model.entity.ChannelEntity;
import com.melong.map_struct.model.entity.ChannelUserEntity;
import com.melong.map_struct.model.entity.UserEntity;
import com.melong.map_struct.model.mapper.ChannelMapper;
import com.melong.map_struct.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;
    private final UserService userService;

    @Transactional
    public void createChannel(Channel channel) {
        ChannelEntity channelEntity = channelMapper.toEntity(channel);
        channelRepository.save(channelEntity);
    }

    @Transactional(readOnly = true)
    public Channel getChannel(long seq) throws Exception {
        return channelMapper.toModel(getChannelEntity(seq));
    }

    @Transactional(readOnly = true)
    public List<Channel> getChannelList() {
        return channelMapper.toModelList(channelRepository.findAll());
    }

    @Transactional
    public void subscribeChannel(Channel channel, User user) throws Exception {
        Optional<ChannelEntity> channelEntityOptional = channelRepository.findById(channel.getSeq());
        if (channelEntityOptional.isEmpty()) throw  new Exception();
        ChannelEntity channelEntity = channelEntityOptional.get();

        UserEntity userEntity = userService.getUserEntity(user);

        List<ChannelUserEntity> channelUserEntityList = channelEntity.getChannelUserList();
        channelUserEntityList.add(ChannelUserEntity.of(channelEntity, userEntity));

        channelRepository.save(channelEntity);
    }

    @Transactional(readOnly = true)
    public ChannelEntity getChannelEntity(long seq) throws Exception{
        Optional<ChannelEntity> channelEntityOptional = channelRepository.findById(seq);
        if(channelEntityOptional.isEmpty()) throw new Exception();
        return channelEntityOptional.get();
    }
}
