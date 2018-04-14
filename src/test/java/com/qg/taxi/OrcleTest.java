package com.qg.taxi;

import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.dao.mysql.GPSPointDao;
import com.qg.taxi.dao.oracle.GpsLogDao;
import com.qg.taxi.model.GPSPoint;
import com.qg.taxi.model.GpsLog;
import com.qg.taxi.service.GPSPointService;
import com.qg.taxi.service.GpsMeterDataHisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by logan on 2017/7/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrcleTest {

    @Autowired
    private GpsLogDao oracleDao;

    @Autowired
    private GPSPointDao mysqlDao;

    @Autowired
    private GPSPointService gpsPointService;

    @Autowired
    private GpsMeterDataHisService gpsMeterDataHisService;


    @Autowired
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;

    @Test
    public void testCount() {
//        System.out.println("1h数量为：");
//        System.out.println(oracleDao.selectTimeCount());
        long start = System.currentTimeMillis();
        List<GpsLog> gpsLogs = oracleDao.selectAMonth();
        System.out.println(gpsLogs.size());
        long end = System.currentTimeMillis();
        long time = start - end;
        System.out.println("Time : " + time);
    }

    @Test
    public void testGetGPSPoint() {
        Date date = new Date(Long.valueOf("1488211201000"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("时间：" + format.format(date));
        List<GPSPoint> list = gpsPointService.getGPSPointList(date);
        System.out.println("====数据输出开始====");
        for (GPSPoint point : list) {
            System.out.println(point.toString());
        }
        System.out.println("====数据输出结束====");
    }

    @Test
    public void test() {
        List<GpsLog> g = oracleDao.selectAMonth();
        int i = 0;
        System.out.println(g.size());
        while (i < g.size()) {
            System.out.println(g.get(i++));
        }
//        System.out.println(oracleDao.selectTimeCount());
    }

    /**
     * 测试表2：AUDITOR.TAXI_METER_DATA_HIS
     */
    @Test
    public void testMeterHis() throws ParseException {
        gpsMeterDataHisService.insertMeterHisToMysql(13000000, 13100000, 288);
        System.out.println("==========打印结束========");
    }

    @Test
    public void testOpeHis() throws ParseException {
        gpsMeterDataHisService.insertOperateHisToMysql(9400000, 9500000, 111);
        System.out.println("==========打印结束========");
    }

    @Test
    public void test1() throws IOException, InterruptedException {
//        OutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\a.xlsx");
////        try {
////            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
//            //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
//
//            Map map = gpsMeterDataHisService.countGeoHashByTime(23.003394 , 113.333312
//                    ,23.061475,113.398027,5,new Date());
//
//            System.out.println(map);
//            for (Map.Entry<String, List<CountModel>> entry : map.entrySet()){
//                Sheet sheet1 = new Sheet(1, 0,CountModel.class);
//                writer.write(entry.getValue(), sheet1);
//            }
//            writer.finish();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        CountDownLatch latch = new CountDownLatch(6);
        String name = "operate_his";
//        ExecutorService executors = Executors.newFixedThreadPool(10);
//        List<UpdateCallable> callableList = new ArrayList<>();
//        for (int i =25 ; i<= 30 ; i++){
//            String tableName = name+i;
//            UpdateCallable callable = new UpdateCallable(tableName, gpsMeterDataHisDaoSql,latch);
//            callableList.add(callable);
//        }
//        for (UpdateCallable callable : callableList) {
//            Future<String> future = executors.submit(callable);
//        }
//        latch.await();
//        System.out.println("===========操作结束================");
//            gpsMeterDataHisService.updateOpsHis(name+25);

        for (int i = 24; i <= 24; i++) {
            gpsMeterDataHisService.updateOpsHis(name + i);
        }
    }


}
