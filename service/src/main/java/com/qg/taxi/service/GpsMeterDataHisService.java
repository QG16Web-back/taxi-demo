package com.qg.taxi.service;

import ch.hsr.geohash.GeoHash;
import com.qg.taxi.dao.mysql.GPSMeterDataHisDaoSql;
import com.qg.taxi.dao.oracle.GpsMeterDataHisDao;
import com.qg.taxi.model.CountModel;
import com.qg.taxi.model.GPS;
import com.qg.taxi.model.GpsMeterDataHis;
import com.qg.taxi.model.GpsOperateHis;
import com.qg.taxi.util.DateUtil;
import com.qg.taxi.util.MyGeoHashUtils;
import com.qg.taxi.util.RowKeyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wilder Gao
 * @date 2018/3/24
 */
@Service
public class GpsMeterDataHisService {
    private static final String graphName = "meter_data_his";
    private static final String graphOperateName = "operate_his";
    @Autowired
    private GpsMeterDataHisDao gpsMeterDataHisDao;
    @Autowired
    private GPSMeterDataHisDaoSql gpsMeterDataHisDaoSql;

    private Logger logger = LoggerFactory.getLogger(GpsMeterDataHisService.class);

    /**
     * 表1插入操作
     *
     * @param start
     * @param end
     * @param k
     * @throws ParseException
     */
    public void insertMeterHisToMysql(int start, int end, int k) throws ParseException {
        int times = 130;
        while (start <= 100000 * k && end <= 100000 * k) {
            List<List<GpsMeterDataHis>> sortGpsByDayList = new ArrayList<>(60);
            int iteator = 0;
            while (iteator < 60) {
                List<GpsMeterDataHis> gpsList = new ArrayList<>();
                sortGpsByDayList.add(iteator, gpsList);
                iteator++;
            }
            List<GpsMeterDataHis> dataHisList = gpsMeterDataHisDao.selectHisByNum(start, end);

            //将得到的数据进行分类
            logger.info("=========正在整理数据=========");
            for (GpsMeterDataHis gpsMeterDataHis : dataHisList) {
                if (null == gpsMeterDataHis.getPlateNo()) {
                    continue;
                }
                //得到这一条数据所对应的日期
                Map dayAndHourMap = DateUtil.getDayAndHour(gpsMeterDataHis.getWorkBeginTime());
                int dayOfGps = (int) dayAndHourMap.get("day");
                if (dayOfGps > 60) {
                    continue;
                }
                gpsMeterDataHis.setTimeRepre((Integer) dayAndHourMap.get("hour"));
                sortGpsByDayList.get(dayOfGps - 1).add(gpsMeterDataHis);
            }
            logger.info("==========整理结束==========");

            for (int i = 1; i <= sortGpsByDayList.size(); i++) {
                String graphNameAdd = graphName + i;
                if (sortGpsByDayList.get(i - 1).size() == 0) {
                    continue;
                }
                gpsMeterDataHisDaoSql.addGpsMeterHisList(graphNameAdd, sortGpsByDayList.get(i - 1));
            }

            start += 100000;
            end += 100000;
            dataHisList.clear();
            for (List<GpsMeterDataHis> gpsMeterDataHises : sortGpsByDayList) {
                gpsMeterDataHises.clear();
            }

            sortGpsByDayList.clear();


            logger.info("<<<<<<<<导入第" + times + "次成功>>>>>>>>>>>");
            times++;
        }
    }

    /**
     * 表2插入操作
     *
     * @param start
     * @param end
     * @param k
     * @throws ParseException
     */
    public void insertOperateHisToMysql(int start, int end, int k) throws ParseException {
        int times = 1;
        while (start <= 100000 * k && end <= 100000 * k) {
            List<List<GpsOperateHis>> sortGpsOpsByDayList = new ArrayList<>(60);
            int iteator = 0;
            while (iteator < 60) {
                List<GpsOperateHis> gpsList = new ArrayList<>();
                sortGpsOpsByDayList.add(iteator, gpsList);
                iteator++;
            }
            List<GpsOperateHis> operateHisList = gpsMeterDataHisDao.selectOperateHisByNum(start, end);

            //将得到的数据进行分类
            logger.info("==================================================正在整OpeHis表数据==================================================");
            for (GpsOperateHis operateHis : operateHisList) {
                if (null == operateHis.getPlateNo())
                    continue;
                //得到这一条数据所对应的日期
                Map dayAndHourMap = DateUtil.getDayAndHour(operateHis.getWorkBeginTime());
                int dayOfGps = (int) dayAndHourMap.get("day");
                int hour = (int) dayAndHourMap.get("hour");
                int year = (int) dayAndHourMap.get("year");
                int month = (int) dayAndHourMap.get("month");

                //清理垃圾数据
                if (dayOfGps > 60 || year != 2017) continue;
                if (month != 2 && month != 3) continue;

                operateHis.setTimeRepre(hour);
                sortGpsOpsByDayList.get(dayOfGps - 1).add(operateHis);
            }
            logger.info("==================================================整理OpeHis结束====================================================");

            for (int i = 1; i <= sortGpsOpsByDayList.size(); i++) {
                String graphNameAdd = graphOperateName + i;
                if (sortGpsOpsByDayList.get(i - 1).size() == 0) continue;
                gpsMeterDataHisDaoSql.addGpsOperateHisList(graphNameAdd, sortGpsOpsByDayList.get(i - 1));
            }


            start += 100000;
            end += 100000;
            operateHisList.clear();
            for (List<GpsOperateHis> gpsMeterDataHises : sortGpsOpsByDayList) {
                gpsMeterDataHises.clear();
            }

            sortGpsOpsByDayList.clear();


            System.out.println("<<<<<<<<导入第" + times + "次成功>>>>>>>>>>>");
            times++;
        }
    }

//    /**
//     * 统计一个区域内各个时间段的打车总量
//     * 注：一个区域将划分为多个6位的geoHash
//     * 一个 geoHash 的划分代表一个键值对
//     * @param latmin    最小纬度
//     * @param lonmin    最小经度
//     * @param latmax    最大纬度
//     * @param lonmax    最大经度
//     * @param precis    划分geoHash长度
//     * @return excel 链接
//     */
//    public Map<GPS, List<CountModel>> countGeoHashByTime(double latmin, double lonmin,
//                                                         double latmax, double lonmax, int precis,
//                                                         Date date) throws IOException {
//        //获得这个区域的geoHash分布
//        List<GeoHash> geoHashList = MyGeoHashUtils.getArea(latmin, lonmin, latmax, lonmax, precis);
//
//        //没有这个区域的情况
//        if (null == geoHashList || null == date) {
//            return null;
//        }else {
//            Map<GPS, List<CountModel>> countMap = new HashMap<>();
//            //获得表名
//            String tableName = graphOperateName + DateUtil.getDayAndHour(date).get("day");
//            for (GeoHash geoHash : geoHashList) {
//                List<CountModel> countModels = gpsMeterDataHisDaoSql.countByTimeGeoHash(tableName, geoHash.toBase32());
//                if (null == countModels){
//                    continue;
//                } else {
//                    countMap.put(MyGeoHashUtils.GetGPSByGeoHash(geoHash.toBase32()), countModels);
//                }
//            }
//
////            return ExcelUtil.createExcel(countMap);
//            return countMap;
//        }
//    }


    /**
     * 统计一个区域内各个时间段的打车总量
     * 注：一个区域将划分为多个6位的geoHash
     * 一个 geoHash 的划分代表一个键值对
     *
     * @param latmin 最小纬度
     * @param lonmin 最小经度
     * @param latmax 最大纬度
     * @param lonmax 最大经度
     * @param precis 划分geoHash长度
     * @return Map ，键为小时，值为数量
     */
    public Map<Integer, List<GPS>> countGeoHashToMap(double latmin, double lonmin,
                                                     double latmax, double lonmax, int precis,
                                                     Date date) throws IOException {
        //获得这个区域的geoHash分布
        List<GeoHash> geoHashList = MyGeoHashUtils.getArea(latmin, lonmin, latmax, lonmax, precis);

        //没有这个区域的情况
        if (null == geoHashList || null == date) {
            return null;
        } else {
            Map<Integer, List<GPS>> countMap = new HashMap<>();
            for (int i = 0; i <= 23; i++) {
                countMap.put(i, new ArrayList<>());
            }

            //获得表名
            String tableName = graphOperateName + DateUtil.getDayAndHour(date).get("day");
            for (GeoHash geoHash : geoHashList) {
                List<CountModel> countModels = gpsMeterDataHisDaoSql.countByTimeGeoHash(tableName, geoHash.toBase32());
                if (null == countModels) {
                    continue;
                } else {
                    for (CountModel countModel : countModels) {
                        GPS gps = MyGeoHashUtils.GetGPSByGeoHash(countModel.getGeoHash());
                        gps.setCount(countModel.getCount());
                        countMap.get(countModel.getTimeRepre()).add(gps);
                    }
                }
            }
            return countMap;
        }
    }


    /**
     * 获得这个区域的gps坐标，按照时间排列
     *
     * @param latmin
     * @param lonmin
     * @param latmax
     * @param lonmax
     * @param date
     * @return
     */
    public Map<Integer, List<GPS>> getAreaGpsMapByDay(double latmin, double lonmin,
                                                      double latmax, double lonmax,
                                                      Date date) {
        if (latmin > latmax || lonmin > lonmax) {
            return null;
        } else if (latmin > 90 || latmin < -90 || lonmin > 180 || lonmin < -180 || latmax > 90 || latmax < -90 || lonmax > 180 || lonmax < -180) {
            return null;
        } else {
            String tableName = graphOperateName + DateUtil.getDayAndHour(date).get("day");
            List<GPS> gpsList = gpsMeterDataHisDaoSql.selectGeoHashByTime(tableName, lonmin, lonmax, latmin, latmax);
            if (gpsList.size() == 0) {
                return null;
            } else {
                Map<Integer, List<GPS>> countMap = new HashMap<>();
                for (int i = 0; i <= 23; i++) {
                    countMap.put(i, new ArrayList<>());
                }
                for (GPS gps : gpsList) {
                    gps.setCount(10);
                    countMap.get(gps.getTimeRepre()).add(gps);
                }

                return countMap;
            }
        }
    }

    public void updateOpsHis(String tableName) {
        List<GpsOperateHis> operateHisList = gpsMeterDataHisDaoSql.getOpsHisData(tableName);

        for (GpsOperateHis gpsOperateHis : operateHisList) {

            String rowKey = RowKeyUtils.getRowKey(gpsOperateHis.getId(),
                    gpsOperateHis.getPlateNo(),
                    gpsOperateHis.getGeoHash(), gpsOperateHis.getWorkBeginTime());
            gpsOperateHis.setRowKey(rowKey);
            gpsMeterDataHisDaoSql.updateOpsHis(tableName, gpsOperateHis.getRowKey(),
                    gpsOperateHis.getId());
        }
    }
}
