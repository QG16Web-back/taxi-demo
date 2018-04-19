package com.qg.taxi.web.controller;

import com.qg.taxi.model.GPS;
import com.qg.taxi.service.GpsMeterDataHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:Wilder Gao
 * @time:2018/3/27
 * @Discription：
 */
@Controller
@RequestMapping("/geohash")
@CrossOrigin
public class GeoHashController {

    private final GpsMeterDataHisService gpsMeterDataHisService;

    @Autowired
    public GeoHashController(GpsMeterDataHisService gpsMeterDataHisService) {
        this.gpsMeterDataHisService = gpsMeterDataHisService;
    }

    /**
     * @param map 选定一个区域返回对应的 Map
     * @return
     * @throws ParseException
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.POST, value = "/getAreaExcel")
    @ResponseBody
    @CrossOrigin
    public Map<Integer, List<GPS>> getCountMap(@RequestBody Map<String, Object> map) throws ParseException, IOException {

        String dateString = (String) map.get("date");
        double latmin = (double) map.get("latmin");
        double lomin = (double) map.get("lomin");
        double latmax = (double) map.get("latmax");
        double lomax = (double) map.get("lomax");

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString + " 00:00:00");
        Map<Integer, List<GPS>> timeMap = gpsMeterDataHisService.getAreaGpsMapByDay(latmin, lomin, latmax, lomax, date);

        return timeMap;
    }

}
