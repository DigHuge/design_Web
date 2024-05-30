package com.lzh.mybatis.service;
import com.lzh.mybatis.mapper.VtuberMapper;
import com.lzh.mybatis.pojo.Vtuber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public class VtuberServiceimpl implements VtuberService {

    private VtuberMapper vtuberMapper;
    public void setVtuberMapper(VtuberMapper vtuberMapper) {
        this.vtuberMapper = vtuberMapper;
    }

    public List<Vtuber> getMEI(){
        return vtuberMapper.getMEI();
    }

    public List<Vtuber> getMEP(){
        return vtuberMapper.getMEP();
    }

    public List<Vtuber> getMEPay(){
        return vtuberMapper.getMEPay();
    }

    public List<Vtuber> get_dIncome() {
        return vtuberMapper.get_dIncome();
    }

    public List<Vtuber> get_dParticipants() {
        return vtuberMapper.get_dParticipants();
    }

    public List<Vtuber> get_dPay_num() {
        return vtuberMapper.get_dPay_num();
    }

    public List<Vtuber> query_Vname(String Vname) {
        return vtuberMapper.query_Vname(Vname);
    }

    public List<Vtuber> query_Vuid(String Vuid) {
        return vtuberMapper.query_Vuid(Vuid);
    }

    public List<Vtuber> query_Vall(String Vuid){
        return vtuberMapper.query_Vall(Vuid);
    }

    public List<Vtuber> get_date(){
        return  vtuberMapper.get_date();
    }

    public List<Vtuber> get_120(){
        return vtuberMapper.get_120();
    }

}
