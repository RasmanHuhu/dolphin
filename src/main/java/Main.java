//Relations - One to one

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello Dolphin!");

        //Nedenunder er "databasen"
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig("dolphin");

        //Pakker EntityManager ind i en try til sidst
        try (EntityManager em = emf.createEntityManager()) {

            Person p1 = new Person("Rasmus");
            PersonDetail pd1 = new PersonDetail("Vordingborggade 2", 9000, "Holbæk", 34);

            //Laver et personobjekt og smider personDetails på
            p1.addPersonDetail(pd1);

            //Laver Fee - får fat i personenobjektet og hægter fee på dem

            Fee f1 = new Fee(125, LocalDate.of(2023, 8, 25));
            Fee f2 = new Fee(150, LocalDate.of(2023, 7, 19));
            p1.addFee(f1);
            p1.addFee(f2);

            //Nu skal vi lave en transaktion
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();

        }
    }
}
