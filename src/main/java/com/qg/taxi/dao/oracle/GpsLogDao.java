package com.qg.taxi.dao.oracle;

import com.qg.taxi.model.GpsLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by FunriLy on 2017/7/29.
 * From small beginnings comes great things.
 */
@Mapper
@Repository
public interface GpsLogDao {

    List<GpsLog> selectFormTime(@Param("str") String str, @Param("num") int num);

    int selectOne(@Param("str") String str);

    List<GpsLog> selectWithName(@Param("name") String name, @Param("time") Date time);

    /***
     * 查询总数目
     * @return
     */
    Long selectCount();

    /***
     * 查询2.1-2.8的数据量
     * @return
     */
    Long selectTimeCount();

    /***
     * 查询2.1-2.8的数据
     * @return
     */
    List<GpsLog> selectAMonth();

    /***
     * 查询某一区域内的数据
     * @return
     */
    List<GpsLog> selectByNum(@Param("start") long start, @Param("end") long end);
}
