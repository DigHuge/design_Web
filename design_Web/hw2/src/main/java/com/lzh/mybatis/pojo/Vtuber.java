package com.lzh.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vtuber {
    private String date;
    private int income;
    private int pay_num;
    private int danmu;
    private int top120;
    private int participants;
    private int follower;
    private int guard_num;

    private String name;
    private String uid;
    private String face;
    private float live_time;
}
