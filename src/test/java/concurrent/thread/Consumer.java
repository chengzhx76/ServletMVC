package concurrent.thread;

/**
 * Desc:
 * Author: chengzhx76@qq.com
 * Date: 2017/8/8
 */
public class Consumer extends Thread {


    @Override
    public void run() {
        System.out.println("-------执行方法--------");
    }
}
