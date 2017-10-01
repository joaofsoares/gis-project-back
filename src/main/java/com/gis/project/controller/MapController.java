package com.gis.project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MapController {

    @CrossOrigin
    @RequestMapping(value = "/mapservice", method = RequestMethod.GET, produces = "application/json")
    public String testService() throws IOException {

        return "{ \"response\": \"success\" }";

    }

}
