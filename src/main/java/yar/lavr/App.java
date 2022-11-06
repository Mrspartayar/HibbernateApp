package yar.lavr;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import yar.lavr.model.Director;
import yar.lavr.model.Item;
import yar.lavr.model.Movie;
import yar.lavr.model.Person;

import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test cascading", 30);

            person.addItem(new Item("Item1"));
            person.addItem(new Item("Item2"));
            person.addItem(new Item("Item3"));

//            Item item1 = new Item ("Item1");
//            Item item2 = new Item ("Item2");
//            Item item3 = new Item ("Item3");

//            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.save(person);

            session.getTransaction().commit();

//            Director newDirector = new Director("Director from project1", 1950);
//            Movie newMovie = new Movie("Movie2 from project1", 1980,newDirector);
//
//            newDirector.setMovies(new ArrayList<>(Collections.singletonList(newMovie)));
//
//            session.save(newDirector);
//            session.save(newMovie);

//            Director director=session.get(Director.class,1);
//            Movie newMovie = new Movie("New movie from project", 1999,director);
//
//            director.getMovies().add(newMovie);
//            session.save(newMovie);


//            Movie movie=session.get(Movie.class,3);
//            System.out.println(movie);
//
//            Director director = movie.getOwner();

//            Director director = session.get(Director.class,1);
//            System.out.println(director);
//
//            List<Movie> movies = director.getMovies();
//            System.out.println(movies);


        } finally {
            sessionFactory.close();
        }

    }
}


