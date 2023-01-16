package com.epam.mjc.demo.repository;

import com.epam.mjc.demo.entity.Actor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ActorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Actor actor) {
        entityManager.persist(actor);
    }

    public Actor findById(Long actorId) {
        return entityManager.find(Actor.class, actorId);
    }
}
