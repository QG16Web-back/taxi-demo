package com.qg.taxi;

import com.qg.taxi.model.GPSPoint;
import com.qg.taxi.service.GPSPointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnyWorkApplicationTests {

    @Autowired
    private GPSPointService gpsPointService;

    @Test
    public void testList() {
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


//	@Autowired
//	private GpsLogDao gpsLogDao;
//
//	@Test
//	public void contextLoads() throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		List<GpsLog> list = null;
//		long time_1 = System.currentTimeMillis();
//		list = gpsLogDao.selectFormTime("粤AM0Q08", 10);
//		list = null;
//		long time_2 = System.currentTimeMillis();
//		System.out.println(time_2 - time_1);
//
//		long time_3 = System.currentTimeMillis();
//		list = gpsLogDao.selectFormTime("粤AM0Q08", 100);
//		list = null;
//		long time_4 = System.currentTimeMillis();
//		System.out.println(time_4 - time_3);
//
//		long time_5 = System.currentTimeMillis();
//		list = gpsLogDao.selectFormTime("粤AM0Q08", 1000);
//		list = null;
//		long time_6 = System.currentTimeMillis();
//		System.out.println(time_6 - time_5);
//
//		long time_7 = System.currentTimeMillis();
//		list = gpsLogDao.selectFormTime("粤AM0Q08", 10000);
//		list = null;
//		long time_8 = System.currentTimeMillis();
//		System.out.println(time_8 - time_7);
//
//		long time_9 = System.currentTimeMillis();
//		list = gpsLogDao.selectFormTime("粤A0PM02", 1000);
//		list = null;
//		long time_10 = System.currentTimeMillis();
//		System.out.println(time_10 - time_9);

//		if (list == null){
//			System.out.println("List Is NULL!");
//		} else {
//			System.out.println("List Length : " + list.size());
//			System.out.println("==========================");
//			for (GpsLog gpsLog : list){
//				System.out.println(gpsLog.toString());
//			}
//		}

//	}
//
//	@Test
//	public void test2() throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		System.out.println("数据为" + gpsLogDao.selectOne("粤AU0Z40"));
//
//	}
//
//	@Test
//	public void test3() throws ParseException{
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = format.parse("2017-02-28 00:00:04");
//		List<GpsLog> list = gpsLogDao.selectWithName("粤AM0Q08", date);
//		System.out.println("num = " + list.size());
//		for (GpsLog gpsLog : list){
//			System.out.println(gpsLog);
//		}
//	}


}
