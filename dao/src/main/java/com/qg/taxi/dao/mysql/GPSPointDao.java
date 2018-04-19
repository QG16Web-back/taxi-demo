package com.qg.taxi.dao.mysql;

import com.qg.taxi.model.GPSPoint;
import com.qg.taxi.model.GpsLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 前端测试用的 Dao 层接口
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
@Mapper
@Repository
public interface GPSPointDao {

    /**
     * 根据时间获得GPS Point
     *
     * @return
     */
    List<GPSPoint> getGPSPoint(@Param("start") Date start, @Param("end") Date end);

    /***
     * 添加数据
     * @param gpsLog
     * @return
     */
    int addGPSPoint(@Param("gpsPoint") GpsLog gpsLog);

    int addPointList1(@Param("list") List<GPSPoint> list);

    int addPointList2(@Param("list") List<GPSPoint> list);

    int addPointList3(@Param("list") List<GPSPoint> list);

    int addPointList4(@Param("list") List<GPSPoint> list);

    int addPointList5(@Param("list") List<GPSPoint> list);

    int addPointList6(@Param("list") List<GPSPoint> list);

    int addPointList7(@Param("list") List<GPSPoint> list);

    int addPointList8(@Param("list") List<GPSPoint> list);

    int addPointList9(@Param("list") List<GPSPoint> list);

    int addPointList10(@Param("list") List<GPSPoint> list);
}
