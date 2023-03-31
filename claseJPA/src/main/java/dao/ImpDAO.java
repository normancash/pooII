package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImpDAO implements IDAO{
    @Override
    public <T> List<T> findAll(Class<T> clazz,String nameQuery) {
        final EntityManager em = getEntityManager();
        TypedQuery<T> query = em.createNamedQuery(nameQuery,clazz);
        return query.getResultList();
    }

    @Override
    public <T> void create(T entity) {
            final EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(entity);
                em.getTransaction().commit();
            }
            catch(Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            }
    }

    @Override
    public <T> void delete(T entity) {
        final EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public <T> void update(T entity) {
        final EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public <T> T findById(Long id, Class<T> clazz) {
        EntityManager em = getEntityManager();
        T entity = em.find(clazz,id);
        return entity;
    }

    private EntityManager getEntityManager() {
        return EntityManagerAdmin.getEntityManager();
    }

}
