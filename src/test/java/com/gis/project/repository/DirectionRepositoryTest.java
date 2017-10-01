package com.gis.project.repository;

import com.gis.project.model.EndDirection;
import com.gis.project.model.StartDirection;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DirectionRepositoryTest {

    private static DirectionRepository mockedDirectionRepository;
    private static StartDirection mockedStartDirection;
    private static EndDirection mockedEndDirection;

    @BeforeClass
    public static void setUp() {

        mockedDirectionRepository = mock(DirectionRepository.class);

        mockedStartDirection = StartDirection.newInstance().withAddress("Dublin, Ireland");

        mockedEndDirection = EndDirection.newInstance().withAddress("Swords, Ireland");

        when(mockedDirectionRepository.getStartDirections())
                .thenReturn(Arrays.asList(mockedStartDirection.getAddress()));

        when(mockedDirectionRepository.getEndDirections())
                .thenReturn(Arrays.asList(mockedEndDirection.getAddress()));

    }

    @Test
    public void getStartDirection() throws Exception {

        List<String> startDirectionsList = mockedDirectionRepository.getStartDirections();

        assertEquals(1, startDirectionsList.size());

        StartDirection startDirection = StartDirection.newInstance().withAddress(startDirectionsList.get(0));

        assertEquals(mockedStartDirection.getAddress(), startDirection.getAddress());

    }

    @Test
    public void getEndDirection() throws Exception {

        List<String> endDirectionsList = mockedDirectionRepository.getEndDirections();

        assertEquals(1, endDirectionsList.size());

        EndDirection endDirection = EndDirection.newInstance().withAddress(endDirectionsList.get(0));

        assertEquals(mockedEndDirection.getAddress(), endDirection.getAddress());

    }

}
