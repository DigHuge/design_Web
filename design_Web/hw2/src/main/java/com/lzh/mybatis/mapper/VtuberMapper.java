package com.lzh.mybatis.mapper;
import com.lzh.mybatis.pojo.Vtuber;
import org.apache.ibatis.annotations.Param;
import java.util.List;

//【Dao层】
public interface VtuberMapper {

//    Integer test_mybaits(); //增
//    Integer test_update();  //改
//    Integer test_delete();  //删
//    Vtuber test_select(); //【 实体类返回一条结果 】
//    List<Vtuber> test_select_list();//【 list返回多条结果 】
    List<Vtuber> getMEI();
    List<Vtuber> getMEP();
    List<Vtuber> getMEPay();
    List<Vtuber> get_dIncome();
    List<Vtuber> get_dParticipants();
    List<Vtuber> get_dPay_num();
    List<Vtuber> query_Vname(@Param("Vname") String Vname);
    List<Vtuber> query_Vuid(@Param("Vuid") String Vuid);
    List<Vtuber> query_Vall(@Param("Vuid") String Vuid);
    List<Vtuber> get_date();
    List<Vtuber> get_120();
}
