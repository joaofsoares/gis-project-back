package com.gis.project.repository;

import com.gis.project.model.EndDirection;
import com.gis.project.model.StartDirection;
import com.gis.project.persistence.SessionPersistence;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class DirectionRepository {

    private final static Logger logger = Logger.getLogger(DirectionRepository.class);

    boolean saveStartDirection(StartDirection startDirection) {

        try (Session mapSession = SessionPersistence.getSession()) {

            mapSession.save(startDirection);
            return true;

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;

    }

    boolean saveEndDirection(EndDirection endDirection) {

        try (Session mapSession = SessionPersistence.getSession()) {

            mapSession.save(endDirection);
            return true;

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;

    }

    public boolean removeStartDirection(String startDirectionAddress) {

        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("delete from StartDirection where address = :address")
                    .setParameter("address", startDirectionAddress);
            query.executeUpdate();

            return true;

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;

    }

    public boolean removeEndDirection(String endDirectionAddress) {

        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("delete from EndDirection where address = :address")
                    .setParameter("address", endDirectionAddress);
            query.executeUpdate();

            return true;

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return false;

    }

    public List<String> getStartDirections() {

        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("select address from StartDirection ");

            return query.list();

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return new ArrayList<>();

    }

    public List<String> getEndDirections() {

        try (Session mapSession = SessionPersistence.getSession()) {

            Query query = mapSession.createQuery("select address from EndDirection ");

            return query.list();

        } catch (Exception e) {

            logger.error(e.getMessage());

        }

        return new ArrayList<>();
    }

}
