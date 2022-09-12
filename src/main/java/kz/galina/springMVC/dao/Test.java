package kz.galina.springMVC.dao;

import kz.galina.springMVC.config.HibernateConfig;
import kz.galina.springMVC.config.SpringConfig;
import kz.galina.springMVC.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestHibernateDAO testHibernateDAO = context.getBean("testHibernateDAO", TestHibernateDAO.class);
        List<Person> people = testHibernateDAO.getPeople();
        System.out.println(people.toString());
        context.close();
    }

}
