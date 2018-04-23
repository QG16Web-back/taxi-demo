package com.qg.taxi.dao.mysql;

import com.qg.taxi.model.CountModel;
import com.qg.taxi.model.DriverInfo;
import com.qg.taxi.model.GPS;
import com.qg.taxi.model.GpsMeterDataHis;
import com.qg.taxi.model.GpsOperateHis;
import com.qg.taxi.model.TakeTaxiCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/24.
 */
@Mapper
@Repository
@Scope("prototype")
public interface GPSMeterDataHisDaoSql {
    /**
     * 往mysql插入数据
     *
     * @param graph 表名
     * @param list  集合
     * @return
     */
    int addGpsMeterHisList(@Param("graph") String graph, @Param("list") List<GpsMeterDataHis> list);

    /**
     * 插入表2数据
     *
     * @param graph
     * @param list
     * @return
     */
    int addGpsOperateHisList(@Param("graph") String graph, @Param("list") List<GpsOperateHis> list);

    /**
     * 以geoHash、小时为单位统计出租车的总量
     *
     * @param tableName
     * @param geoHash
     * @return
     */
    List<CountModel> countByTimeGeoHash(@Param("tableName") String tableName,
                                        @Param("geoHash") String geoHash);

    /**
     * 统计某个小时车的空间分布
     *
     * @param tableName
     * @param timeRepre
     * @return
     */
    List<CountModel> countByDay(@Param("tableName") String tableName,
                                @Param("timeRepre") int timeRepre);

    List<GPS> selectGeoHashByTime(@Param("tableName") String tableName,
                                  @Param("lngmin") double lngmin,
                                  @Param("lngmax") double lngmax,
                                  @Param("latmin") double latmin,
                                  @Param("latmax") double latmax);

    List<TakeTaxiCount> totalCount(@Param("table") String table);

    List<DriverInfo> getIncome(@Param("table") String table);

    List<DriverInfo> getIncomeByCustomQuery(@Param("table") String table, @Param("startTime") int startTime, @Param("endTime") int endTime);

    List<DriverInfo> getEmptyMileage(@Param("table") String table);

    List<DriverInfo> getEmptyMileageByCustomQuery(@Param("table") String table, @Param("startTime") int startTime, @Param("endTime") int endTime);

    List<DriverInfo> getIncomeByHour(@Param("table") String table);

    List<DriverInfo> getEmptyMileageByHour(@Param("table") String table);

    List<GpsOperateHis> getOpsHisData(@Param("tableName") String tableName);

    int updateOpsHis(@Param("tableName") String tableName, @Param("rowKey") String rowKey,
                     @Param("id") long id);
}
