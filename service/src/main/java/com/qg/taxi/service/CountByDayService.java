package com.qg.taxi.service;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.model.CountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author:Wilder Gao
 * @time:2018/3/29
 * @Discription：
 */
@Service
public class CountByDayService {

    private final GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;
    private static final String tableName = "operate_his";
    private static final String excelPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\result.xlsx";
    private static int tableNum = 59;

    @Autowired
    public CountByDayService(GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql) {
        this.gpsMeterDataHisDaoSql = gpsMeterDataHisDaoSql;
    }

    public void countByDayTest()
            throws ExecutionException, InterruptedException, FileNotFoundException {

        CountDownLatch count = new CountDownLatch(tableNum);
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Map<String, List<CountModel>>> mapList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= tableNum; i++) {
            CountDayCallable callable = new CountDayCallable(tableName + i, gpsMeterDataHisDaoSql, count);

            Future<Map<String, List<CountModel>>> future = executor.submit(callable);

            Map<String, List<CountModel>> map = future.get();

            mapList.add(map);
        }
        count.await();
        System.out.println(mapList.size());

        OutputStream out = new FileOutputStream(excelPath);
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

        int sheetNo = 1;
        for (Map<String, List<CountModel>> listMap : mapList) {
            Sheet sheet = new Sheet(sheetNo, 0, CountModel.class);
            sheet.setSheetName("第" + sheetNo + "天");
            for (Map.Entry<String, List<CountModel>> entry : listMap.entrySet()) {
                writer.write(entry.getValue(), sheet);
            }
            sheetNo++;
        }

        writer.finish();
        executor.shutdown();

    }
}
