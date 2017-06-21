package com.cheng;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc:
 * Author: hp
 * Date: 2017/6/15
 */
public class testChain {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
//        map = repaymentstatus(map);
//        map = orderinfobyorderid(map);
//        map = orderinfobydate(map);
        map = getpeerinfo(map); // 9.10
//        map = getblockinfo(map);
//        map = gettxidinfobytxid(map);
//        map = pen(map);

        String json = JSON.toJSONString(map);
        System.out.println(json);
    }

    private static Map<String, Object> repaymentstatus(Map<String, Object> map) {
        map.put("mer_id", "201188472119341122");
        map.put("repayment_status", "1");
        map.put("req", "361c495447dbf19e830fc13d5e783575d2005f592f3422fdd6c919dc5830c9a3");
        map.put("sign_type", "");
        map.put("sign_data", "");
        return map;

    }

    private static Map<String, Object> orderinfobyorderid(Map<String, Object> map) {
        List<Map<String, String>> orders = new ArrayList<>();
        Map<String, String> order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:00:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);
        order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:52:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);
        order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:52:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);

        map.put("order", orders);
        map.put("sign_type", "");
        map.put("sign_data", "");
        return map;
    }
    // 9.6
    private static Map<String, Object> orderinfobydate(Map<String, Object> map) {
        List<Map<String, String>> orders = new ArrayList<>();
        Map<String, String> order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:00:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);
        order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:52:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);
        order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:52:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");
        order.put("order_status", "0");
        order.put("req", "41e081ed3847e");
        orders.add(order);

        map.put("order", orders);
        map.put("remaining_amout", "10");
        map.put("sign_type", "");
        map.put("sign_data", "");
        return map;
    }

    // 9.10
    private static Map<String, Object> getpeerinfo(Map<String, Object> map) {
        /*List<Map<String, Object>> ip_lists = new ArrayList<>();
        Map<String, Object> ip_port = new HashMap<>();
        ip_port.put("ip_port", "10.10.10.1:80");
        ip_lists.add(ip_port);
        ip_port = new HashMap<>();
        ip_port.put("ip_port", "10.10.10.2:82");
        ip_lists.add(ip_port);
        ip_port = new HashMap<>();
        ip_port.put("ip_port", "10.10.10.3:83");
        ip_lists.add(ip_port);
        map.put("ip_lists", ip_lists);

        map.put("block_height", "828717");
        map.put("txs_amount", "635535");
        map.put("run_time", "20");
        map.put("sign_type", "");
        map.put("sign_data", "");*/
        return map;
    }
    // 9.11
    private static Map<String, Object> getblockinfo(Map<String, Object> map) {
        /*map.put("block_num", "56");
        map.put("block_hash", "bdd79e212efb59732028a531cb2ae40cc93d117043d0cd5b9bfabea659f4e270");
        map.put("block_prehash", "20");
        map.put("block_createtime", "2017-06-15 12:00:55");
        String[] txs = {"txkC4Ck31r4GzjpjWaLHvGVj","omMEBYqzZDDtGuuRiK6k4yKx"};
        map.put("txs", txs);
        map.put("sign_type", "");*/
        map.put("sign_data", "");
        return map;
    }

    // 9.12
    private static Map<String, Object> gettxidinfobytxid(Map<String, Object> map) {
        map.put("block_num", "56");
        map.put("index", "1");
        map.put("optype", "2");
        map.put("tx_time", "2017-06-15 12:00:55");
        map.put("tx", "");
        map.put("sign_type", "");
        map.put("sign_data", "");
        return map;
    }

    // 10.10
    private static Map<String, Object> pen(Map<String, Object> map) {
        List<Map<String, Object>> orders = new ArrayList<>();
        Map<String, Object> order = new HashMap<>();
        order.put("mer_id", "201188472119341122");
        order.put("order_id", "d7965e7dba579abd2dce442cda9d66f25da0e379c34d81ea047d11e9d08204e6");
        order.put("transaction_date", "2017-06-15 12:00:55");
        order.put("transaction_id", "41e081ed3847e5e151d717a4e458634c91cad90ec2237141c33786e2a66bf226");
        order.put("total_cost", "****10");

        List<Map<String, Object>> order_status_history = new ArrayList<>();
        Map<String, Object> status_history = new HashMap<>();
        status_history.put("order_status", "1");
        status_history.put("txid", "41e081ed3847e5e151d717a4e45");
        order_status_history.add(status_history);
        status_history = new HashMap<>();
        status_history.put("order_status", "2");
        status_history.put("txid", "41e081ed3847e5e151ssswss4e45");
        order_status_history.add(status_history);

        order.put("order_status_history", order_status_history);
        order.put("req", "41e081ed3847e");
        orders.add(order);
        orders.add(order);
        map.put("order", orders);
        map.put("sign_type", "");
        map.put("sign_data", "");
        return map;
    }
}
