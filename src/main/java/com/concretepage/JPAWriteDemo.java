package com.concretepage;

import com.concretepage.entity.Author;
import com.concretepage.entity.Book;
import com.concretepage.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://www.concretepage.com/java/jpa/jpa-entitymanager-and-entitymanagerfactory-example-using-hibernate-with-persist-find-contains-detach-merge-and-remove
//https://devcolibri.com/%D0%BA%D0%B0%D0%BA-%D1%81%D0%B2%D1%8F%D0%B7%D0%B0%D1%82%D1%8C-entity-%D0%B2-jpa/
public class JPAWriteDemo {
    public static void main(String[] args) {
        insert();
//        find();
    }

    public static void insert() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        
//        List<Employee> employees = createEmployee(entityManager);
//        List<Book> books = createBooks(entityManager);
        List<Author> authors = createAuthors(entityManager);
        
        entityManager.close();
        JPAUtility.close();
        System.out.println("Entity saved.");
    }
    
    private static List<Author> createAuthors(EntityManager entityManager) {
        Author author1 = new Author();
        author1.setLastName("Author1");
        author1.setName("Name1");
        author1.setId(1);
    
        author1.setBooks(new HashSet<>(createBooks(entityManager)));
        
//        Author author2 = new Author();
//        author2.setId(2);
//        author2.setLastName("Author2");
//        author2.setBooks(new HashSet<>(createBooks(entityManager)));
        
    
//        save(entityManager, author1.getBooks());
        save(entityManager, author1);
//        save(entityManager, author2);
        return Arrays.asList(author1);
    }
    
    private static List<Book> createBooks(EntityManager entityManager) {
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("book1");
        
//        Book book2 = new Book();
//        book2.setId(2);
//        book2.setName("book2");
//
//        Book book3 = new Book();
//        book3.setId(3);
//        book3.setName("book3");
//
//        book3.setEmployees(new HashSet<>(createEmployee(entityManager)));
    
        save(entityManager, book1);
//        save(entityManager, book2);
//        save(entityManager, book3);
        return Arrays.asList(book1);
    }
    
    private static List<Employee> createEmployee(EntityManager entityManager) {
        Employee employee1 = new Employee(1, "Employee1", "City1");
        Employee employee2 = new Employee(2, "Employee2", "City2");
    
//        save(entityManager, employee1);
//        save(entityManager, employee2);
//        save(entityManager, employee3);
        return Arrays.asList(employee1,employee2);
    }
    
    
    private static void save(EntityManager entityManager, Object obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }
    
    public static void find() {
        EntityManager entityManager = JPAUtility.getEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Employee emp = entityManager.find(Employee.class, 2);
            entityManager.getTransaction().commit();

            System.out.println("Name:" + emp.getName() + ", City:" + emp.getBooks());
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        } finally {
            JPAUtility.close();
        }
        System.out.println("Done");
    }
}