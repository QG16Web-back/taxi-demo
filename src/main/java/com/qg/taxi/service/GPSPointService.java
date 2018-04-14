package com.qg.taxi.service;

import com.qg.taxi.dao.mysql.GPSPointDao;
import com.qg.taxi.dao.mysql.GPSPointDao2;
import com.qg.taxi.dao.oracle.GpsLogDao;
import com.qg.taxi.model.GPSPoint;
import com.qg.taxi.model.GpsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
@Service
public class GPSPointService {

    @Autowired
    private GPSPointDao gpsPointDao;
    @Autowired
    private GPSPointDao2 gpsPointDao2;
    @Autowired
    private GpsLogDao oracle;

    public List<GPSPoint> getGPSPointList(Date start) {
        //控制date结束时间,增加10s
        Date end = new Date(start.getTime() + 10000);
        List<GPSPoint> list = gpsPointDao.getGPSPoint(start, end);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    public int transfer(int index) {
        List<GpsLog> gpsLogs = oracle.selectAMonth();
        List<GPSPoint> gpsPoints = new ArrayList<>();
        for (GpsLog gpsLog : gpsLogs) {
            //gpsPointDao.addGPSPoint(gpsLog);
            gpsPoints.add(new GPSPoint(gpsLog));
        }
        for (GPSPoint point : gpsPoints) {
            System.out.println(point);
        }
        // todo 将数据添加到数据库
        gpsLogs = null; //释放对象
        //gpsPointDao.addPointList1(gpsPoints);

        gpsPoints = null;
        return 1;
    }

    public String insertList(int start, int end, int i) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = sdf.parse("2017-02-02 00:00:00");
        Date date2 = sdf.parse("2017-02-03 00:00:00");
        Date date3 = sdf.parse("2017-02-04 00:00:00");
        Date date4 = sdf.parse("2017-02-05 00:00:00");
        Date date5 = sdf.parse("2017-02-06 00:00:00");
        Date date6 = sdf.parse("2017-02-07 00:00:00");
        Date date7 = sdf.parse("2017-02-08 00:00:00");
        Date date8 = sdf.parse("2017-02-09 00:00:00");
        Date date9 = sdf.parse("2017-02-10 00:00:00");
        Date date10 = sdf.parse("2017-02-11 00:00:00");
        Date date11 = sdf.parse("2017-02-12 00:00:00");
        Date date12 = sdf.parse("2017-02-13 00:00:00");
        Date date13 = sdf.parse("2017-02-14 00:00:00");
        Date date14 = sdf.parse("2017-02-15 00:00:00");
        Date date15 = sdf.parse("2017-02-16 00:00:00");
        Date date16 = sdf.parse("2017-02-17 00:00:00");
        Date date17 = sdf.parse("2017-02-18 00:00:00");
        Date date18 = sdf.parse("2017-02-19 00:00:00");
        Date date19 = sdf.parse("2017-02-20 00:00:00");

        while (end <= 80000000 * i && start < 80000000 * i) {
            List<GpsLog> gpsLogs = oracle.selectByNum(start, end);
            List<GPSPoint> points1 = new ArrayList<>();
            List<GPSPoint> points2 = new ArrayList<>();
            List<GPSPoint> points3 = new ArrayList<>();
            List<GPSPoint> points4 = new ArrayList<>();
            List<GPSPoint> points5 = new ArrayList<>();
            List<GPSPoint> points6 = new ArrayList<>();
            List<GPSPoint> points7 = new ArrayList<>();
            List<GPSPoint> points8 = new ArrayList<>();
            List<GPSPoint> points9 = new ArrayList<>();
            List<GPSPoint> points10 = new ArrayList<>();
            List<GPSPoint> points11 = new ArrayList<>();
            List<GPSPoint> points12 = new ArrayList<>();
            List<GPSPoint> points13 = new ArrayList<>();
            List<GPSPoint> points14 = new ArrayList<>();
            List<GPSPoint> points15 = new ArrayList<>();
            List<GPSPoint> points16 = new ArrayList<>();
            List<GPSPoint> points17 = new ArrayList<>();
            List<GPSPoint> points18 = new ArrayList<>();
            List<GPSPoint> points19 = new ArrayList<>();
            List<GPSPoint> points20 = new ArrayList<>();


            GPSPoint point = null;
            //分发转换坐标点
            for (GpsLog gpsLog : gpsLogs) {
                point = new GPSPoint(gpsLog);
                if (point.getGps_date().before(date1)) {             //第一天
                    points1.add(point);
                } else if (point.getGps_date().before(date2)) {      //第二天
                    points2.add(point);
                } else if (point.getGps_date().before(date3)) {      //第三天
                    points3.add(point);
                } else if (point.getGps_date().before(date4)) {      //第四天
                    points4.add(point);
                } else if (point.getGps_date().before(date5)) {       //5
                    points5.add(point);
                } else if (point.getGps_date().before(date6)) {       //6
                    points6.add(point);
                } else if (point.getGps_date().before(date7)) {       //7
                    points7.add(point);
                } else if (point.getGps_date().before(date8)) {       //8
                    points8.add(point);
                } else if (point.getGps_date().before(date9)) {       //9
                    points9.add(point);
                } else if (point.getGps_date().before(date10)) {       //10
                    points10.add(point);
                } else if (point.getGps_date().before(date11)) {       //11
                    points11.add(point);
                } else if (point.getGps_date().before(date12)) {       //12
                    points12.add(point);
                } else if (point.getGps_date().before(date13)) {       //13
                    points13.add(point);
                } else if (point.getGps_date().before(date14)) {       //14
                    points14.add(point);
                } else if (point.getGps_date().before(date15)) {       //15
                    points15.add(point);
                } else if (point.getGps_date().before(date16)) {       //16
                    points16.add(point);
                } else if (point.getGps_date().before(date17)) {       //17
                    points17.add(point);
                } else if (point.getGps_date().before(date18)) {       //18
                    points18.add(point);
                } else if (point.getGps_date().before(date19)) {       //19
                    points19.add(point);
                } else {                                             //20
                    points20.add(point);
                }
            }
            gpsLogs.clear();
            gpsLogs = null;

            if (!points1.isEmpty()) {
                gpsPointDao.addPointList1(points1);
            }
            if (!points2.isEmpty()) {
                gpsPointDao.addPointList2(points2);
            }
            if (!points3.isEmpty()) {
                gpsPointDao.addPointList3(points3);
            }
            if (!points4.isEmpty()) {
                gpsPointDao.addPointList4(points4);
            }
            if (!points5.isEmpty()) {
                gpsPointDao.addPointList5(points5);
            }
            if (!points6.isEmpty()) {
                gpsPointDao.addPointList6(points6);
            }
            if (!points7.isEmpty()) {
                gpsPointDao.addPointList7(points7);
            }
            if (!points8.isEmpty()) {
                gpsPointDao.addPointList8(points8);
            }
            if (!points9.isEmpty()) {
                gpsPointDao.addPointList9(points9);
            }
            if (!points10.isEmpty()) {
                gpsPointDao.addPointList10(points10);
            }
            if (!points11.isEmpty()) {
                gpsPointDao2.addPointList11(points11);
            }
            if (!points12.isEmpty()) {
                gpsPointDao2.addPointList12(points12);
            }
            if (!points13.isEmpty()) {
                gpsPointDao2.addPointList13(points13);
            }
            if (!points14.isEmpty()) {
                gpsPointDao2.addPointList14(points14);
            }
            if (!points15.isEmpty()) {
                gpsPointDao2.addPointList15(points15);
            }
            if (!points16.isEmpty()) {
                gpsPointDao2.addPointList16(points16);
            }
            if (!points17.isEmpty()) {
                gpsPointDao2.addPointList17(points17);
            }
            if (!points18.isEmpty()) {
                gpsPointDao2.addPointList18(points18);
            }
            if (!points19.isEmpty()) {
                gpsPointDao2.addPointList19(points19);
            }
            if (!points20.isEmpty()) {
                gpsPointDao2.addPointList20(points20);
            }

            {
                points1.clear();
                points2.clear();
                points3.clear();
                points4.clear();
                points5.clear();
                points6.clear();
                points7.clear();
                points8.clear();
                points9.clear();
                points10.clear();
                points11.clear();
                points12.clear();
                points13.clear();
                points14.clear();
                points15.clear();
                points16.clear();
                points17.clear();
                points18.clear();
                points19.clear();
                points20.clear();
            }

            System.out.println("》》》》》》》第" + i + "：完成" + start + "到" + end + "的插入");
            start += 200000;
            end += 200000;
            if (end > (80000000 * i)) {
                end = 80000000 * i;
            }
        }
        return "success";
    }


    private static List<GPSPoint> change(List<GpsLog> gpsLogs) {
        List<GPSPoint> gpsPoints = new ArrayList<>();
        for (GpsLog gpsLog : gpsLogs) {
            //gpsPointDao.addGPSPoint(gpsLog);
            gpsPoints.add(new GPSPoint(gpsLog));
        }
        return gpsPoints;
    }
}
