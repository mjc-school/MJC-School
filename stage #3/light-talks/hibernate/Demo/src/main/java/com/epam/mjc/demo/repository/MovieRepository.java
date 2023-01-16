package com.epam.mjc.demo.repository;

import com.epam.mjc.demo.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Movie movie) {
        entityManager.persist(movie);
    }

    public Movie findById(Long movieId) {
        return entityManager.find(Movie.class, movieId);
    }

    public List<Movie> findJPQL() {
        final TypedQuery<Movie> query = entityManager
                .createQuery("SELECT m FROM Movie m", Movie.class);
        return query.getResultList();
    }

    public List<Movie> findJPQLLeftJoinFetch() {
        final TypedQuery<Movie> query = entityManager
                .createQuery("SELECT distinct m FROM Movie m left join fetch m.actors a", Movie.class);
        return query.getResultList();
    }

    public List<Movie> findWithOffsetAndLimit(int offset, int limit) {
        final TypedQuery<Movie> query = entityManager
                .createQuery("SELECT distinct m FROM Movie m left join fetch m.actors a", Movie.class)
                .setFirstResult(offset)
                .setMaxResults(limit);
        return query.getResultList();
    }

    public void flush() {
        entityManager.flush();
    }
}
