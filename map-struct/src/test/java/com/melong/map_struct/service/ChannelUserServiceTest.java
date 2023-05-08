package com.melong.map_struct.service;

import com.melong.map_struct.MapStructApplication;
import com.melong.map_struct.model.dto.Channel;
import com.melong.map_struct.model.dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= MapStructApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ChannelUserServiceTest {

    @Autowired
    private ChannelService channelService;
    @Autowired
    private ChannelUserService channelUserService;
    @Autowired
    private UserService userService;

    @Test
    @Order(1)
    public void 채널_추가_테스트() {
        Channel channel = new Channel();
        channel.setId("ChannelID");
        channel.setName("ChannelName");
        channel.setDescription("ChannelDescription");

        channelService.createChannel(channel);
    }

    @Test
    @Order(2)
    public void 채널_구독_테스트() throws Exception {
        Channel channel = channelService.getChannel(1);

        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setId("UserId-1");

        User user2 = new User();
        user2.setId("UserId-2");

        userList.add(user1);
        userList.add(user2);

        userService.createUser(user1);
        userService.createUser(user2);

        userList.forEach(user -> {
            try {
                channelUserService.subscribeUser(channel, user);
            } catch (Exception ignored) {
            }
        });
    }

    @Order(3)
    @Test
    public void 채널_조회() {
        List<Channel> channels = channelService.getChannelList();
        System.out.println(channels);
    }
}