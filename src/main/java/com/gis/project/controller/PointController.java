package com.gis.project.controller;

import com.gis.project.repository.PointRepository;
import com.gis.project.util.CoordinatesUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class PointController {

    private PointRepository pointRepository;

    @CrossOrigin
    @RequestMapping(value = "/points", method = RequestMethod.GET, produces = "application/json")
    public String getPoints() throws IOException {

        pointRepository = new PointRepository();

        return CoordinatesUtil.convertPointListToJson(pointRepository.getAllPoints());

    }

    @CrossOrigin
    @RequestMapping(value = "/points/name", method = RequestMethod.GET, produces = "application/json")
    public String getPointsName() throws IOException {

        pointRepository = new PointRepository();

        return CoordinatesUtil.convertPointNamesListToJson(pointRepository.getAllPointsName());

    }

    @CrossOrigin
    @RequestMapping(value = "/points/save", method = RequestMethod.POST, produces = "application/json")
    public String savePoint(@RequestBody String pointBody) throws IOException {

        pointRepository = new PointRepository();

        if (pointRepository.savePoint(CoordinatesUtil.convertJsonToPoint(pointBody))) {

            return "{ \"response\": \"success\" }";

        }

        return "{ \"response\": \"failed\" }";

    }

    @CrossOrigin
    @RequestMapping(value = "/points/remove", method = RequestMethod.POST, produces = "application/json")
    public String removePoint(@RequestBody String pointBody) throws IOException {

        pointRepository = new PointRepository();

        if (pointRepository.removePoint(CoordinatesUtil.convertJsonToPoint(pointBody))) {

            return "{ \"response\": \"success\" }";

        }

        return "{ \"response\": \"failed\" }";

    }

}
