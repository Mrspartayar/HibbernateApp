package yar.lavr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import yar.lavr.model.Passport;
import yar.lavr.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = session.get(Person.class,10);
            session.remove(person);


//            Passport passport = session.get(Passport.class, 10);
//            System.out.println(passport.getPerson().getName());

//            Person person = session.get(Person.class, 10);
//            System.out.println(person.getPassport().getPassportNumber());

//            Person person = new Person("Test person", 50);
//            Passport passport = new Passport(12345);
//
//            person.setPassport(passport);
//            session.save(person);





            session.getTransaction().commit();


//            person.addItem(new Item("Item1"));
//            person.addItem(new Item("Item2"));
//            person.addItem(new Item("Item3"));

//            Item item1 = new Item ("Item1");
//            Item item2 = new Item ("Item2");
//            Item item3 = new Item ("Item3");

//            person.setItems(new ArrayList<>(Collections.singletonList(item)));



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


