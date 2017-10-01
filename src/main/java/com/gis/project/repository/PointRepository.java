package com.gis.project.repository;

import com.gis.project.model.EndDirection;
import com.gis.project.model.Point;
import com.gis.project.model.StartDirection;
import com.gis.project.persistence.SessionPersistence;
import com.gis.project.util.CoordinatesUtil;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PointRepository {

    private static final Logger logger = Logger.getLogger(PointRepository.class);

    private DirectionRepository directionRepository;

    public boolean savePoint(Point point) {

        if (isPointAlreadyExists(point)) {

            return false;

        } else {

            try (Session mapSession = SessionPersistence.getSession()) {

                String sql = "insert into map_points(address, point) values ('" + point.getAddress() +
                        "', ST_GeomFromText('POINT(" + point.getLatitude() + " " + point.getLongitude() + ")'))";

                Query query = mapSession.createSQLQuery(sql);
                int result = query.executeUpdate();

                boolean isDirectionsInserted = false;

                if (result == 1) {

                    directionRepository = new DirectionRepository();

                    isDirectionsInserted = directionRepository
                            .saveStartDirection(StartDirection.newInstance().withAddress(point.getAddress())) &
                            directionRepository
                                    .saveEndDirection(EndDirection.newInstance().withAddress(point.getAddress()));

                }

                return result == 1 && isDirectionsInserted;

            } catch (Exception e) {

                logger.error(e.getMessage());

            }

        }

        return false;

    }

    public boolean removePoint(Point point) {

        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("delete from Point where address = :address")
                    .setParameter("address", point.getAddress());

            if (query.executeUpdate() == 1) {

                directionRepository = new DirectionRepository();

                directionRepository.removeStartDirection(point.getAddress());
                directionRepository.removeEndDirection(point.getAddress());

                return true;
            }

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;

    }

    private boolean isPointAlreadyExists(Point point) {
        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("select address from Point where address = :address")
                    .setParameter("address", point.getAddress());

            return (long) query.list().size() > 0;

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;
    }

    public List<Point> getAllPoints() {

        List<Point> pointList = new ArrayList<>();

        try (Session mapSession = SessionPersistence.getSession()) {

            String sql = "select id, address, ST_AsText(point) from map_points";

            Query query = mapSession.createSQLQuery(sql);

            List<Object> objectList = query.list();

            objectList.stream()
                    .map(Object[].class::cast)
                    .forEach(obj ->
                            pointList.add(Point.newInstance()
                                    .withId(Long.parseLong(obj[0].toString()))
                                    .withAddress(obj[1].toString())
                                    .withLatitude(CoordinatesUtil.getLatitudeFromPoint(obj[2].toString()))
                                    .withLongitude(CoordinatesUtil.getLongitudeFromPoint(obj[2].toString()))));

            if (pointList.size() > 0) {
                return pointList;
            }

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return pointList;

    }

    public List<String> getAllPointsName() {

        try (Session mapSession = SessionPersistence.getSession()) {

            String sql = "select address from map_points";

            Query query = mapSession.createSQLQuery(sql);

            return query.list();

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return new ArrayList<>();

    }
}
