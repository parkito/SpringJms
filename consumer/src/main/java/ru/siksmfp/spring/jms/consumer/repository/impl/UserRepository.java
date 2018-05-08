package ru.siksmfp.spring.jms.consumer.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.siksmfp.spring.jms.consumer.entity.UserEntity;
import ru.siksmfp.spring.jms.consumer.exception.DAOException;
import ru.siksmfp.spring.jms.consumer.repository.api.GenericRepository;

import javax.persistence.NoResultException;


@Repository
public class UserRepository extends GenericRepository<UserEntity, Long> {

    public UserEntity findUserByEmail(String email) {
        UserEntity userEntity;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from UserEntity where email =:email");
            query.setParameter("email", email);
            try {
                userEntity = (UserEntity) query.getSingleResult();
            } catch (NoResultException ex) {
                return null;
            }
            return userEntity;
        } catch (Exception ex) {
            throw new DAOException("Can't find user by email " + email, ex);
        }
    }

    public void deleteUserByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("delete UserEntity where email =:email");
            query.setParameter("email", email);
            query.executeUpdate();
            tx.commit();
        } catch (Exception ex) {
            throw new DAOException("Can't delete user by email " + email, ex);
        }
    }
}
