package com.cheng.other.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Desc:
 * Author: hp
 * Date: 2017/7/7
 */
public class TestThread {

    private static final Logger _log = LoggerFactory.getLogger(TestThread.class);

    private static LinkedList<Map<String, Integer>> taskQueue = new LinkedList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Map<String, Integer> task = new HashMap<>();
            task.put("taskType", i);
            taskQueue.offer(task);
        }
    }

    public static void main(String[] args) {

        while (taskQueue.size() > 0) {
            long runTime = System.currentTimeMillis();
            CheckTaskRunTimeThread checkTime = checkTaskRunTime(taskQueue, runTime);
            execTask();
    //        checkTime.interrupt();
            checkTime.stopThread();
        }

    }

    private static void execTask() {
        Map<String, Integer> task = taskQueue.poll();
        int taskType = task.get("taskType");
        _log.info("取出任务{}开始执行", taskType);

        if (task.get("taskType") == 2) {
//            long time = 10*60*1000;
            long time = 15*1000;
            sleep(time); // 模拟执行任务花费时间
        }
        _log.info("任务{}执行结束", taskType);
    }

    private static void execOtherTask() {
        while (taskQueue.size() > 0) {
            execTask();
        }
    }

    static class CheckTaskRunTimeThread implements Runnable {
//        private static final long timeOut = 1*60*1000;
        private static final long timeOut = 10*1000;
        public volatile boolean flag = true;

        private LinkedList<Map<String, Integer>> taskQueue;
        private long runTime;

        public CheckTaskRunTimeThread(LinkedList<Map<String, Integer>> taskQueue, long runTime) {
            this.taskQueue = taskQueue;
            this.runTime = runTime;
        }
        @Override
        public void run() {
            long nowTime = System.currentTimeMillis();
            while (taskQueue.size() > 0 && (nowTime - runTime) < timeOut && flag) {
                sleep(1L);
                nowTime = System.currentTimeMillis();
            }
            if (flag) {
                _log.info("------超时发送Email-----");
                // 从队列中取出新的任务处理
                // 立起一个线程执行后面的
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        execOtherTask();
                    }
                }).start();
            }
        }

        public void stopThread() {
            flag = false;
        }

    }

    private static CheckTaskRunTimeThread checkTaskRunTime(LinkedList<Map<String, Integer>> taskQueue, long runTime) {
        CheckTaskRunTimeThread checkTaskRunTimeThread = new CheckTaskRunTimeThread(taskQueue, runTime);
        Thread checkTime = new Thread(checkTaskRunTimeThread);
        checkTime.setDaemon(true);
        checkTime.start();
        return checkTaskRunTimeThread;
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
