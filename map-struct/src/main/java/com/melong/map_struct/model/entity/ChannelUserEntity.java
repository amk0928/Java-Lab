package com.melong.map_struct.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="channel_user")
public class ChannelUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @ManyToOne
    private ChannelEntity channel;

    @ManyToOne
    private UserEntity user;

    public static ChannelUserEntity of(ChannelEntity channelEntity, UserEntity userEntity) {
        ChannelUserEntity newEntity = new ChannelUserEntity();
        newEntity.setChannel(channelEntity);
        newEntity.setUser(userEntity);
        return newEntity;
    }
}
