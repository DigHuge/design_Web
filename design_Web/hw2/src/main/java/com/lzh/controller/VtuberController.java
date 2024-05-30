package com.lzh.controller;
import com.lzh.mybatis.pojo.Vtuber;
import com.lzh.mybatis.service.VtuberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Vtuber")
public class VtuberController {
    @Autowired
    @Qualifier("VtuberServiceimpl")
    private VtuberService mei_service;

    @RequestMapping("/month")
    public  String month(){
        return "page_month";
    }

    @RequestMapping("/day")
    public String day(){
        return "page_day";
    }

    @RequestMapping("/ml")
        public String ml(){
            return "page_ml";
        }

    @ResponseBody
    @RequestMapping(value = "/getMEI",method = RequestMethod.POST)
    public  List<Map<String,Object>> getMEI(){
        List<Vtuber> i = mei_service.getMEI();
        List<Vtuber> top = mei_service.get_120();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (int j=0;j<i.size();j++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date",i.get(j).getDate());
            map.put("income", i.get(j).getIncome());
            map.put("top",top.get(j).getTop120());
            results.add(map);
        }
        //System.out.println("json数据:"+results);
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "/getMEP",method = RequestMethod.POST)
    public  List<Map<String,Object>> getMEP(){
        List<Vtuber> i = mei_service.getMEP();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : i) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date_d",vtuber.getDate());
            map.put("part", vtuber.getParticipants());
            results.add(map);
        }
        //System.out.println("json数据:"+results);
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "/getMEPay",method = RequestMethod.POST)
    public  List<Map<String,Object>> getMEPay(){
        List<Vtuber> i = mei_service.getMEPay();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : i) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date_pay",vtuber.getDate());
            map.put("pay", vtuber.getPay_num());
            results.add(map);
        }
        //System.out.println("json数据:"+results);
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "/get_dIncome",method = RequestMethod.POST)
    public List<Map<String,Object>> get_dIncome(){
        List<Vtuber> i = mei_service.get_dIncome();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : i) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date1",vtuber.getDate());
            map.put("income", vtuber.getIncome());
            results.add(map);
        }
        //System.out.println("数据get");
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "/get_dParticipants",method = RequestMethod.POST)
    public List<Map<String,Object>> get_dParticipants(){
        List<Vtuber> i = mei_service.get_dParticipants();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : i) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date2",vtuber.getDate());
            map.put("part", vtuber.getParticipants());
            results.add(map);
        }
        //System.out.println("数据get");
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "/get_dPay_num",method = RequestMethod.POST)
    public List<Map<String,Object>> get_dPay_num(){
        List<Vtuber> i = mei_service.get_dPay_num();
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : i) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date3",vtuber.getDate());
            map.put("pay", vtuber.getPay_num());
            results.add(map);
        }
        //System.out.println("数据get");
        return results;
    }

    //查询
    @RequestMapping(value = "/queryVtuber")
    public String queryVtuber(String queryV, Model model, HttpServletResponse response) throws IOException{
        String[] i = queryV.split(",");
        List<Vtuber> q = null;
        //按类型获取信息
        if (i.length>1 && i[1].equals("name")){
            q = mei_service.query_Vname(i[0]);
        }
        else if(i.length>1 && i[1].equals("uid")){
            q = mei_service.query_Vuid(i[0]);
        }
        else{
            q = mei_service.query_Vuid(i[0]);
        }
        if (q.size()>1){ //多个结果展示所有
            model.addAttribute("list",q);
            return "page_v";
        }
        else if(q.size()==0){ //没有结果弹窗报错
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("alert('没有搜索到相关内容');");
            out.println("history.back();");
            out.println("</script>");
            out.close();
        }
        else{ //一个结果
            model.addAttribute("list",q);
            model.addAttribute("uid",q.get(0).getUid());
            return "page_v_info";
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(value ="/getVall",method = RequestMethod.POST)
    public List<Map<String,Object>> getVall(String uid){
        List<Vtuber> date = mei_service.get_date();
        List<Vtuber> i = mei_service.query_Vall(uid);
        for(int j = 0;j<date.size();j++){
            for (Vtuber vtuber : i) {
                if (date.get(j).getDate().equals(vtuber.getDate())) {
                    date.set(j, vtuber);
                }
            }
        }
        while (date.get(0).getIncome() ==0){ //去除多余数据
            date.remove(0);
        }
        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        for (Vtuber vtuber : date) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date",vtuber.getDate());
            map.put("income",vtuber.getIncome());
            map.put("part", vtuber.getParticipants());
            map.put("pay", vtuber.getPay_num());
            results.add(map);
        }
        return results;
    }
}
