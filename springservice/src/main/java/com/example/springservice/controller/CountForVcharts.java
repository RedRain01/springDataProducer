package com.example.springservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springservice.service.OrderService;
import com.example.springservice.util.RedisUtil;
import com.netflix.discovery.DiscoveryManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ：why
 * @description：TODO
 * @date ：2020/11/7 20:29
 */

@Slf4j
@RestController
public class CountForVcharts {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/offline", method = RequestMethod.GET)
    public void offLine(){
        DiscoveryManager.getInstance().shutdownComponent();
    }

    @ResponseBody
    @RequestMapping("/countTop")
    public String countTop() {
        log.info("进入redis查询<<<<<<<<<<");
        ArrayList<HashMap<String,Integer>> arrayList=new ArrayList<>();
       String comm="{\"c1\":\"诺基亚\",\"c2\":\"iphone\",\"c3\":\"华为\",\"c4\":\"小米\",\"c5\":\"oppo\",\"c6\":\"一加\",\"c7\":\"三星\"}";
        JSONObject jsonObject1 = JSON.parseObject(comm);
        HashMap<String,Integer> map=new HashMap<>();
        JSONArray jsonArrayOrder=new JSONArray();
        JSONArray jsonArrayPort=new JSONArray();
        Map<String,JSONArray> mapReturn=new HashMap();
        try {
            String allCommodity="c1,c2,c3,c4,c5,c6,c7";
            String[] split = allCommodity.split(",");
            for (int i = 0; i < split.length; i++) {
                Object allPort = redisUtil.getJson(split[i]);
                if (allPort != null) {
                    String str= JSONObject.toJSONString(allPort);
                    JSONObject parse = JSON.parseObject(str);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("商品",(String) jsonObject1.get(parse.get("subject")));
                    jsonObject.put("订单金额",parse.get("countAmount"));
                    jsonArrayOrder.add(jsonObject);
                }else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("商品",(String) jsonObject1.get(split[i]));
                    jsonObject.put("订单金额",0);
                    jsonArrayOrder.add(jsonObject);
                }
            }
            ArrayList<String> portList = orderService.allPort();
            for (int i = 0; i <portList.size() ; i++) {
                Object portCount = redisUtil.getJson( portList.get(i));
                if (portCount != null) {
                    String str= JSONObject.toJSONString(portCount);
                    JSONObject parse = JSON.parseObject(str);
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("端口",parse.get("port"));
                    jsonObject.put("订单数量",parse.get("orderCount"));
                    jsonArrayPort.add(jsonObject);
                }else {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("端口",portList.get(i));
                    jsonObject.put("订单数量",0);
                    jsonArrayPort.add(jsonObject);
                }
            }
            mapReturn.put("order",jsonArrayOrder);
            mapReturn.put("port",jsonArrayPort);
            return  JSON.toJSONString(mapReturn);
        } catch (Exception e) {
            log.error("redis查询异常", e);
            return "获取redis异常" + e.getMessage();
        }
    }
    /**
     * retemplate相关配置
     *
     * @param factory
     * @return
     */

}
