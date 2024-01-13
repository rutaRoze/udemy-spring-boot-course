package com.springboot.learn.cruddemo.dao;

import com.springboot.learn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {

        entityManager.persist(student);

    }

    @Override
    public Student findById(Integer id) {

        return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {


// Could be written like this, but param should be id (implementation not clear, as not shown on course)
//        Student theStudent = entityManager.find(Student.class, 1);
//        theStudent.setFirstName("Ru");

        entityManager.merge(student);

    }

    //multiple update
    @Transactional
    public Integer updateStudents() {

        int numRowsUpdated = entityManager.createQuery(
                "UPDATE Student SET lastName='Tester'")
                .executeUpdate();

        return numRowsUpdated;
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery(
                "DELETE FROM Student")
                .executeUpdate();

        return numRowsDeleted;
    }


}
