package kz.galina.springMVC.dao;

import kz.galina.springMVC.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class TestHibernateDAO {
    private  SessionFactory sessionFactory;

    @Autowired
    public TestHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public  List<Person> getPeople(){
        Session session = sessionFactory.openSession();
        List <Person> people = session.createSQLQuery("from person").getResultList();
        return people;
    }

}
