package com.qg.taxi.dao.oracle;

import com.qg.taxi.model.GpsMeterDataHis;
import com.qg.taxi.model.GpsOperateHis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wilder Gao on 2018/3/24.
 */
@Mapper
@Repository
public interface GpsMeterDataHisDao {
    List<GpsMeterDataHis> selectHisByNum(@Param("start") long start, @Param("end") long end);

    List<GpsOperateHis> selectOperateHisByNum(@Param("start") long start, @Param("end") long end);
}
