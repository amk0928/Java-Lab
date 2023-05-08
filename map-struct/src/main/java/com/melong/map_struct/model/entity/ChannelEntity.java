package com.melong.map_struct.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="channel")
public class ChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "channel")
    private List<ChannelUserEntity> channelUserList = new ArrayList<>();
}
