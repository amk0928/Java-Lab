package com.melong.map_struct.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    private long seq;
    private String id;
    private String name;
    private String description;
}
