package com.qg.taxi.web;

import com.qg.taxi.dto.RequestResult;
import com.qg.taxi.model.GPSPoint;
import com.qg.taxi.service.GPSPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by FunriLy on 2017/7/30.
 * From small beginnings comes great things.
 */
@Controller
public class GPSPointController {

    @Autowired
    private GPSPointService gpsPointService;

    @RequestMapping(value = "/get/{time}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public RequestResult<List<GPSPoint>> getGPSPointList(@PathVariable("time") long time) {

        if (time < Long.valueOf("1488211200000") || time > Long.valueOf("1493308800000")) {
            return new RequestResult<List<GPSPoint>>(0, "时间参数出错！必须在 2017-02-28 00:00:00 到 2017-04-28 00:00:00", null);
        }
        Date date = new Date(time);
        List<GPSPoint> list = gpsPointService.getGPSPointList(date);
        int num = list.size();
        return new RequestResult<List<GPSPoint>>(num, "获得GPS点的数据", list);
    }

    @RequestMapping(value = "/transfer/{time}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String transfer(@PathVariable int time) {
        try {
            int i = 1;
            if (time < 80000000 * 4) {
                i = 4;
            } else if (time < 80000000 * 5) {
                i = 5;
            } else if (time < 80000000 * 6) {
                i = 6;
            } else if (time < 80000000 * 7) {
                i = 7;
            } else if (time < 80000000 * 8) {
                i = 8;
            } else if (time < 80000000 * 9) {
                i = 9;
            } else if (time < 80000000 * 10) {
                i = 10;
            } else {
                return "Number Error";
            }
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(System.currentTimeMillis())));
            return gpsPointService.insertList(time, time + 200000, i);
        } catch (Exception e) {
            e.printStackTrace();
            return "fails";
        }

    }

}
