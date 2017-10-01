package com.gis.project.repository;

import com.gis.project.model.Point;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PointRepositoryTest {

    private static PointRepository mockedPointRepository;
    private static Point mockedDublinPoint;
    private static Point mockedSwordsPoint;

    @BeforeClass
    public static void setUp() {

        mockedPointRepository = mock(PointRepository.class);

        mockedDublinPoint = Point.newInstance().withId(0).withAddress("Dublin, Ireland").withLatitude(1)
                .withLongitude(1);

        mockedSwordsPoint = Point.newInstance().withId(1).withAddress("Swords, Ireland").withLatitude(2)
                .withLongitude(2);

        when(mockedPointRepository.getAllPoints())
                .thenReturn(Arrays.asList(mockedDublinPoint, mockedSwordsPoint));

        when(mockedPointRepository.getAllPointsName())
                .thenReturn(Arrays.asList("Dublin, Ireland", "Swords, Ireland"));

    }

    @Test
    public void getPointsTest() {

        List<Point> pointList = mockedPointRepository.getAllPoints();

        assertEquals(2, pointList.size());

        Point point1 = pointList.get(0);
        Point point2 = pointList.get(1);

        assertEquals(mockedDublinPoint.getId(), point1.getId());
        assertEquals(mockedDublinPoint.getAddress(), point1.getAddress());
        assert (mockedDublinPoint.getLatitude() == point1.getLatitude());
        assert (mockedDublinPoint.getLongitude() == point1.getLongitude());

        assertEquals(mockedSwordsPoint.getId(), point2.getId());
        assertEquals(mockedSwordsPoint.getAddress(), point2.getAddress());
        assert (mockedSwordsPoint.getLatitude() == point2.getLongitude());
        assert (mockedSwordsPoint.getLongitude() == point2.getLongitude());

    }

    @Test
    public void getPointsNameTest() {

        List<String> pointsNameList = mockedPointRepository.getAllPointsName();

        assertEquals(2, pointsNameList.size());

        String dublinAddress = pointsNameList.get(0);
        String swordsAddress = pointsNameList.get(1);

        assertEquals(mockedDublinPoint.getAddress(), dublinAddress);
        assertEquals(mockedSwordsPoint.getAddress(), swordsAddress);

    }

}
