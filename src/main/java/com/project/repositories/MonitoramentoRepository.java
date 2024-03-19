package com.project.repositories;

import com.project.models.Monitoramento;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class MonitoramentoRepository implements JpaRepository<Monitoramento, Long> {

    private final Logger logger = Logger.getLogger(MonitoramentoRepository.class.getName());

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");

    private final EntityManager em = emf.createEntityManager();

    @SuppressWarnings("all")
    @Override
    public List<Monitoramento> findAll() {
        try {
            var objects = em.createNativeQuery("select * from monitoramento").getResultList();
            return objects;
        } catch (Exception e){
            logger.info(e.getMessage());
        }
        return null;
    }

    @Override
    public Optional<Monitoramento> findById(Long id) {
        try {
            var object = em.find(Monitoramento.class, id);
            return Optional.of(object);
        } catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Monitoramento> save(Monitoramento object) {
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.of(object);
    }

    @Override
    public Optional<Monitoramento> update(Monitoramento object) {
        try {
            if(em.find(Monitoramento.class, object.getId()) == null)
                throw new Exception("ID inválido");

            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();

            return Optional.of(object);
        } catch (Exception e){
            logger.info(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            var object = em.find(Monitoramento.class, id);

            if (object == null)
                throw new Exception("ID Inválido");

            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        } catch (Exception e){
            logger.info(e.getMessage());
        }
    }
}
