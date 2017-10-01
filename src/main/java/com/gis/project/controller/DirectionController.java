package com.gis.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gis.project.model.EndDirection;
import com.gis.project.model.StartDirection;
import com.gis.project.repository.DirectionRepository;
import com.gis.project.util.CoordinatesUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class DirectionController {

    private DirectionRepository directionRepository;

    @CrossOrigin
    @RequestMapping(value = "/directions/start", method = RequestMethod.GET, produces = "application/json")
    public String getStartDirections() throws IOException {

        directionRepository = new DirectionRepository();

        return new ObjectMapper().writeValueAsString(directionRepository.getStartDirections());

    }

    @CrossOrigin
    @RequestMapping(value = "/directions/end", method = RequestMethod.GET, produces = "application/json")
    public String getEndDirections() throws IOException {

        directionRepository = new DirectionRepository();

        return new ObjectMapper().writeValueAsString(directionRepository.getEndDirections());

    }

    @CrossOrigin
    @RequestMapping(value = "/directions/start/remove", method = RequestMethod.POST, produces = "application/json")
    public String removeStartDirection(@RequestBody String startDirectionBody) throws IOException {

        directionRepository = new DirectionRepository();

        StartDirection startDirection = CoordinatesUtil.convertJsonToStartDirection(startDirectionBody);

        if (directionRepository.removeStartDirection(startDirection.getAddress())) {

            return "{ \"response\": \"success\" }";

        }

        return "{ \"response\": \"failed\" }";

    }

    @CrossOrigin
    @RequestMapping(value = "/directions/end/remove", method = RequestMethod.POST, produces = "application/json")
    public String removeEndDirection(@RequestBody String endDirectionBody) throws IOException {

        directionRepository = new DirectionRepository();

        EndDirection endDirection = CoordinatesUtil.convertJsonToEndDirection(endDirectionBody);

        if (directionRepository.removeEndDirection(endDirection.getAddress())) {

            return "{ \"response\": \"success\" }";

        }

        return "{ \"response\": \"failed\" }";

    }

}
