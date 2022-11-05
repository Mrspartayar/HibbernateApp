package yar.lavr;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import yar.lavr.model.Director;
import yar.lavr.model.Movie;
import yar.lavr.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();


            Movie movie = session.get(Movie.class,3);
            Director director = movie.getOwner();

            session.remove(movie);

            movie.setOwner(null); //???
            director.getMovies().remove(movie);




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

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }

    }
}


