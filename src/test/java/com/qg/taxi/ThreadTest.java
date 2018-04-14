package com.qg.taxi;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.CountCallable;
import com.qg.taxi.model.CountModel;
import com.qg.taxi.service.CountByDayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author:Wilder Gao
 * @time:2018/3/28
 * @Discription：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    @Autowired
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;
    @Autowired
    private CountByDayService countByDayService;

    @Test
    public void CallableTest() throws ExecutionException, BrokenBarrierException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CountDownLatch count = new CountDownLatch(3);

        CountCallable callable1 = new CountCallable("operate_his57", count, "ws0e5y", gpsMeterDataHisDaoSql);
        CountCallable callable2 = new CountCallable("operate_his2", count, "ws0e3x", gpsMeterDataHisDaoSql);
        CountCallable callable3 = new CountCallable("operate_his3", count, "ws0e3f", gpsMeterDataHisDaoSql);

        Future<List<CountModel>> future1 = executor.submit(callable1);
//        barrier.await();
        Future<List<CountModel>> future2 = executor.submit(callable2);
        Future<List<CountModel>> future3 = executor.submit(callable3);

        System.out.println("<<<<<<打印第1个结果>>>>>>");
        List<CountModel> models1 = future1.get();
        for (CountModel model : models1) {
            System.out.println(model);
        }

        System.out.println("<<<<<<打印第2个结果>>>>>>");
        List<CountModel> models2 = future2.get();
        for (CountModel model : models2) {
            System.out.println(model);
        }

        List<CountModel> models3 = future3.get();

        System.out.println("<<<<<<打印第3个结果>>>>>>");
        for (CountModel model : models3) {
            System.out.println(model);
        }

        count.await();
        System.out.println("<<<<<<<<<结束>>>>>>>>>>");
        executor.shutdown();
    }

    @Test
    public void test() throws ExecutionException, InterruptedException, FileNotFoundException {
        countByDayService.countByDayTest();
    }
}
