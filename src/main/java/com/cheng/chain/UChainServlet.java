package com.cheng.chain;


import com.cheng.servletmvc.BaseServlet;
import com.cheng.utils.HttpUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Desc: 区块链相关
 * Author: hp
 * Date: 2017/6/12
 *
 * http://localhost/ServletMVC/chain?method=index&api=getPeerInfo
 *
 */
public class UChainServlet extends BaseServlet {
    private static final String API = "api";
    private static final String GETPEERINFO = "getPeerInfo";
    private static final String GETBLOCKINFO = "getBlockInfo";
    private static final String GETTRANSACTIONINFO = "getTransactionInfo";
    private static final String GETTRANSACTIONDETAIL = "getTransactionDetail";
    private static final String QUERYORDER = "queryOrder";
    private static final String ORDERSTATEHISTORY = "orderStateHistory";
    private static final String REPAYMENTSTATE = "repaymentState";

    /**
     * 请求的接口
     * @param request
     * @param response
     */
    public void index(HttpServletRequest request, HttpServletResponse response) {
        String api = getParameter(request, API);
        Map<String, Object> data = new HashMap<>();
        if (GETPEERINFO.equals(api))
            data = getPeerInfo(data);
        if (GETBLOCKINFO.equals(api))
            data = getBlockInfo(data);
        if (GETTRANSACTIONINFO.equals(api))
            data = getTransactionInfo(data);
        if (GETTRANSACTIONDETAIL.equals(api))
            data = getTransactionDetail(data);
        if (QUERYORDER.equals(api))
            data = queryOrder(data);
        if (ORDERSTATEHISTORY.equals(api))
            data = orderStateHistory(data);
        if (REPAYMENTSTATE.equals(api))
            data = repaymentState(data);
        writerToClient(response, data);
    }

    // 15.1.查询节点列表
    private Map<String, Object> getPeerInfo(Map<String, Object> data) {
        List<Map<String, Object>> peerInfos = new ArrayList<>();
        Map<String, Object> peerinfo = new HashMap<>();
        peerinfo.put("peer_id", "0001");
        peerinfo.put("block_height", RandomUtils.nextInt(2510, 2520));
        peerinfo.put("txs_amount", RandomUtils.nextInt(2110, 2120));
        peerinfo.put("run_time", "305");
        peerinfo.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        peerinfo.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        peerInfos.add(peerinfo);

        peerinfo = new HashMap<>();
        peerinfo.put("peer_id", "0002");
        peerinfo.put("block_height", RandomUtils.nextInt(2510, 2520));
        peerinfo.put("txs_amount", RandomUtils.nextInt(2110, 2120));
        peerinfo.put("run_time", "305");
        peerinfo.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        peerinfo.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        peerInfos.add(peerinfo);

        peerinfo = new HashMap<>();
        peerinfo.put("peer_id", "0003");
        peerinfo.put("block_height", RandomUtils.nextInt(2510, 2520));
        peerinfo.put("txs_amount", RandomUtils.nextInt(2110, 2120));
        peerinfo.put("run_time", "305");
        peerinfo.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        peerinfo.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        peerInfos.add(peerinfo);

        peerinfo = new HashMap<>();
        peerinfo.put("peer_id", "0004");
        peerinfo.put("block_height", RandomUtils.nextInt(2510, 2520));
        peerinfo.put("txs_amount", RandomUtils.nextInt(2110, 2120));
        peerinfo.put("run_time", "305");
        peerinfo.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        peerinfo.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        peerInfos.add(peerinfo);

        data.put("peerinfo", peerInfos);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.2.查询块列表
    private Map<String, Object> getBlockInfo (Map<String, Object> data) {
        List<Map<String, Object>> blocks = new ArrayList<>();
        Map<String, Object> block = new HashMap<>();
        block.put("tx_num", RandomUtils.nextInt(2110, 2120));
        block.put("block_num", RandomUtils.nextInt(2510, 2520));
        block.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_pre_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        blocks.add(block);

        block = new HashMap<>();
        block.put("tx_num", RandomUtils.nextInt(2110, 2120));
        block.put("block_num", RandomUtils.nextInt(2510, 2520));
        block.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_pre_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        blocks.add(block);

        block = new HashMap<>();
        block.put("tx_num", RandomUtils.nextInt(2110, 2120));
        block.put("block_num", RandomUtils.nextInt(2510, 2520));
        block.put("block_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_pre_hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("block_createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        blocks.add(block);

        data.put("blocks", blocks);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.3.交易列表
    private Map<String, Object> getTransactionInfo (Map<String, Object> data) {
        List<Map<String, Object>> transactions = new ArrayList<>();
        Map<String, Object> transaction = new HashMap<>();
        transaction.put("txid", RandomStringUtils.randomNumeric(8));
        transaction.put("index", RandomUtils.nextInt(0, 2520));
        transaction.put("optype", RandomUtils.nextInt(1, 5));
        transaction.put("tx_time", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        transaction.put("tx", "");
        transactions.add(transaction);

        transaction = new HashMap<>();
        transaction.put("txid", RandomStringUtils.randomNumeric(8));
        transaction.put("index", RandomUtils.nextInt(0, 2520));
        transaction.put("optype", RandomUtils.nextInt(1, 5));
        transaction.put("tx_time", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        transaction.put("tx", "");
        transactions.add(transaction);

        transaction = new HashMap<>();
        transaction.put("txid", RandomStringUtils.randomNumeric(8));
        transaction.put("index", RandomUtils.nextInt(0, 2520));
        transaction.put("optype", RandomUtils.nextInt(1, 5));
        transaction.put("tx_time", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        transaction.put("tx", "");
        transactions.add(transaction);

        data.put("transactions", transactions);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.4.交易详情
    private Map<String, Object> getTransactionDetail (Map<String, Object> data) {
        data.put("hash", RandomStringUtils.randomAlphanumeric(60));
        data.put("index", RandomUtils.nextInt(0, 2520));
        data.put("optype", RandomUtils.nextInt(1, 5));
        data.put("tx_time", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        data.put("tx", "");

        Map<String, Object> block = new HashMap<>();
        block.put("block_num", RandomUtils.nextInt(2510, 2520));
        block.put("hash", RandomStringUtils.randomAlphanumeric(60));
        block.put("createtime", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        data.put("block", block);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.5订单查询
    private Map<String, Object> queryOrder(Map<String, Object> data) {
        List<Map<String, Object>> orders = new ArrayList<>();
        Map<String, Object> order = new HashMap<>();
        order.put("mer_id", RandomStringUtils.randomAlphanumeric(8));
        order.put("order_id", RandomStringUtils.randomNumeric(10));
        order.put("transaction_date", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        order.put("transaction_id", RandomStringUtils.randomAlphanumeric(10));
        order.put("total_cost", RandomUtils.nextInt(5510, 6500));
        order.put("order_status", RandomUtils.nextInt(0, 2));
        orders.add(order);

        order = new HashMap<>();
        order.put("mer_id", RandomStringUtils.randomAlphanumeric(8));
        order.put("order_id", RandomStringUtils.randomNumeric(10));
        order.put("transaction_date", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        order.put("transaction_id", RandomStringUtils.randomAlphanumeric(10));
        order.put("total_cost", RandomUtils.nextInt(5510, 6500));
        order.put("order_status", RandomUtils.nextInt(0, 2));
        orders.add(order);

        order = new HashMap<>();
        order.put("mer_id", RandomStringUtils.randomAlphanumeric(8));
        order.put("order_id", RandomStringUtils.randomNumeric(10));
        order.put("transaction_date", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        order.put("transaction_id", RandomStringUtils.randomAlphanumeric(10));
        order.put("total_cost", RandomUtils.nextInt(5510, 6500));
        order.put("order_status", RandomUtils.nextInt(0, 2));
        orders.add(order);

        data.put("orders", orders);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.6订单查询
    private Map<String, Object> orderStateHistory(Map<String, Object> data) {
        data.put("transaction_date", DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));
        data.put("transaction_id",  RandomStringUtils.randomAlphanumeric(10));

        Map<String, Object> history = new HashMap<>();
        history.put("order_status", RandomUtils.nextInt(0, 2));
        history.put("txid", RandomStringUtils.randomAlphanumeric(10));
        data.put("order_status_history", history);
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    // 15.7融资状态
    private Map<String, Object> repaymentState(Map<String, Object> data) {
        data.put("repayment_status", RandomUtils.nextInt(1, 2));
        data.put("sign_type", "");
        data.put("sign_data", "");
        return data;
    }

    private final static String DOMAIN = "http://10.10.144.10:8989/";
//    private final static String DOMAIN = "http://10.10.133.26:8989/";
    public void handle(HttpServletRequest request, HttpServletResponse response) {
        String api = getParameter(request, API);
        String peer_id = getParameter(request, "peer_id");
        String begin_block_num = getParameter(request, "begin_block_num");
        String end_block_num = getParameter(request, "end_block_num");
        String block_num = getParameter(request, "block_num");
        String start_index = getParameter(request, "start_index");
        String end_index = getParameter(request, "end_index");
        String txid = getParameter(request, "txid");
        String mer_id = getParameter(request, "mer_id");
        String order_id = getParameter(request, "order_id");
        String url = "";
        if (GETPEERINFO.equals(api))
            url = DOMAIN + "getpeerinfo/0001.json?METHOD=GET";
        if (GETBLOCKINFO.equals(api))
            url = DOMAIN + "getblockinfo/0001.json?METHOD=GET&peer_id="+peer_id+"&begin_block_num="+begin_block_num+"&end_block_num="+end_block_num;
        if (GETTRANSACTIONINFO.equals(api))
            url = DOMAIN + "getTxListByTxIndex/0001.json?METHOD=GET&peer_id="+peer_id+"&block_num="+block_num+"&start_index="+start_index+"&end_index="+end_index;
        if (GETTRANSACTIONDETAIL.equals(api))
            url = DOMAIN + "gettxinfobytxid/0001.json?METHOD=GET&peer_id="+peer_id+"&txid="+txid;
        if (QUERYORDER.equals(api))
            url = "";
        if (ORDERSTATEHISTORY.equals(api))
            url = DOMAIN + "factoring/getorderhistorybyorderid/0001.json?METHOD=GET&mer_id="+mer_id+"&order_id="+order_id;
        if (REPAYMENTSTATE.equals(api))
            url = DOMAIN + "factoring/repaymentstatus/0001.json?METHOD=GET&mer_id="+mer_id;

        String data = HttpUtils.doGet(url);

        writerToClient(response, data);
    }







    /**
     * 获取json
     * @param key
     * @return
     * String json = getJson(api);
     *     // json的数据
     * private static final String CHAINCONFIG = "/chainConfig.properties";
     */
    /*private String getJson(String key) {
        InputStream stream = getClass().getResourceAsStream(CHAINCONFIG);
        Properties props = new Properties();
        try {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key, "");
    }*/

}