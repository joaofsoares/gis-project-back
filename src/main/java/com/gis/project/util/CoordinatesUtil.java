package com.gis.project.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gis.project.model.EndDirection;
import com.gis.project.model.Point;
import com.gis.project.model.StartDirection;

import java.io.IOException;
import java.util.List;

public class CoordinatesUtil {

    public static double getLatitudeFromPoint(String point) {

        String[] coordinates = point
                .replace("POINT(", "")
                .replace(")", "")
                .split(" ");

        return Double.parseDouble(coordinates[0].trim());

    }

    public static double getLongitudeFromPoint(String point) {

        String[] coordinates = point
                .replace("POINT(", "")
                .replace(")", "")
                .split(" ");

        return Double.parseDouble(coordinates[1].trim());

    }

    public static String convertPointNamesListToJson(List<String> nameList) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(nameList);

    }

    public static String convertPointListToJson(List<Point> pointList) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(pointList);

    }

    public static Point convertJsonToPoint(String pointBody) throws IOException {

        return new ObjectMapper().readValue(pointBody, Point.class);

    }

    public static StartDirection convertJsonToStartDirection(String startDirectionBody) throws IOException {

        return new ObjectMapper().readValue(startDirectionBody, StartDirection.class);

    }

    public static EndDirection convertJsonToEndDirection(String endDirectionBody) throws IOException {

        return new ObjectMapper().readValue(endDirectionBody, EndDirection.class);

    }

}
