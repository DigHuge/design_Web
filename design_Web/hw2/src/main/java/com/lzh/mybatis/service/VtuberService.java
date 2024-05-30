package com.lzh.mybatis.service;

import com.lzh.mybatis.pojo.Vtuber;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface VtuberService {
    List<Vtuber> getMEI();
    List<Vtuber> getMEP();
    List<Vtuber> getMEPay();
    List<Vtuber> get_dIncome();
    List<Vtuber> get_dParticipants();
    List<Vtuber> get_dPay_num();
    List<Vtuber> query_Vname(String Vname);
    List<Vtuber> query_Vuid(String Vuid);
    List<Vtuber> query_Vall(String Vuid);
    List<Vtuber> get_date();
    List<Vtuber> get_120();
}
