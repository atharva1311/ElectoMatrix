
package com.tka.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tka.entity.Candidate;
import com.tka.utility.ElectionUtility;

public class ElectionDao {

    // Get all candidates
    public List<Candidate> getAllCandidates() {
        List<Candidate> allCandidates = new ArrayList<>();
        try (Session session = ElectionUtility.getSessionFactory().openSession()) {
            allCandidates = session.createQuery("FROM Candidate", Candidate.class).list();
        } catch (HibernateException e) {
            System.err.println("Hibernate exception occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
        return allCandidates;
    }

    // Add a new candidate
    public void addCandidate(Scanner sc) {
        System.out.println("Enter candidate details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Party: ");
        String party = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Assembly Name: ");
        String assemblyName = sc.nextLine();
        System.out.print("Assembly Number: ");
        int assemblyNo = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Clear buffer

        Transaction tx = null;
        try (Session session = ElectionUtility.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Candidate candidate = new Candidate(name, party, state, assemblyName, assemblyNo, status, gender, age);
            session.save(candidate);
            tx.commit();
            System.out.println("Candidate added successfully!");
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Hibernate exception occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Remove a candidate by name
    public void removeCandidate(Scanner sc) {
        System.out.print("Enter candidate name to delete: ");
        String name = sc.nextLine();

        Transaction tx = null;
        try (Session session = ElectionUtility.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            String hql = "DELETE FROM Candidate WHERE name = :name";
            Query<?> query = session.createQuery(hql);
            query.setParameter("name", name);

            int rowsAffected = query.executeUpdate();
            tx.commit();
            if (rowsAffected > 0) {
                System.out.println("Candidate with name '" + name + "' deleted successfully!");
            } else {
                System.out.println("No candidate found with name '" + name + "'.");
            }
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            System.err.println("Hibernate exception occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
