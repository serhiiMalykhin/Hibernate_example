package com.concretepage;

import com.concretepage.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//https://www.concretepage.com/java/jpa/jpa-entitymanager-and-entitymanagerfactory-example-using-hibernate-with-persist-find-contains-detach-merge-and-remove
//https://devcolibri.com/%D0%BA%D0%B0%D0%BA-%D1%81%D0%B2%D1%8F%D0%B7%D0%B0%D1%82%D1%8C-entity-%D0%B2-jpa/
public class JPAWriteDemo {
    public static void main(String[] args) {
//        insert();
        find();
    }

    public static void insert() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        entityManager.getTransaction().begin();
        Employee employee = new Employee(1, "Mahesh", "Varanasi");
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        JPAUtility.close();
        System.out.println("Entity saved.");
    }

    public static void find() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Employee emp = entityManager.find(Employee.class, 2);
            entityManager.getTransaction().commit();
//            Book fbook = emp.getBooks().stream()
//                    .filter(book -> book.getName().equalsIgnoreCase("book2"))
//                    .findFirst().get();
//            emp.getBooks().remove(fbook);
//
//            emp = entityManager.find(Employee.class, 2);
            System.out.println("Name:" + emp.getName() + ", City:" + emp.getBooks());
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtility.close();
        }
        System.out.println("Done");
    }
} 