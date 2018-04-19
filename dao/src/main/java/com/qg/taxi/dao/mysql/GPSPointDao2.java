package com.qg.taxi.dao.mysql;

import com.qg.taxi.model.GPSPoint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前端测试用的 Dao 层接口
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
@Mapper
@Repository
public interface GPSPointDao2 {

    int addPointList11(@Param("list") List<GPSPoint> list);

    int addPointList12(@Param("list") List<GPSPoint> list);

    int addPointList13(@Param("list") List<GPSPoint> list);

    int addPointList14(@Param("list") List<GPSPoint> list);

    int addPointList15(@Param("list") List<GPSPoint> list);

    int addPointList16(@Param("list") List<GPSPoint> list);

    int addPointList17(@Param("list") List<GPSPoint> list);

    int addPointList18(@Param("list") List<GPSPoint> list);

    int addPointList19(@Param("list") List<GPSPoint> list);

    int addPointList20(@Param("list") List<GPSPoint> list);
}
