package models;

import db.DBHelper;

public class Runner {

    public static void main(String[] args){

        Studio studio1 = new Studio("UTV Motion Pictures", 100000);
        DBHelper.save(studio1);

        Director director1 = new Director("Rohit Shetty", 15000);
        DBHelper.save(director1);

        Actor actor1 = new Actor("Sharukh Khan", 25000);
        DBHelper.save(actor1);

        Film film1 = new Film("Chennai Express", "Drama", director1, studio1);
        DBHelper.save(film1);

        DBHelper.addFilmToStudio(film1, studio1);
        DBHelper.addActorToFilm(actor1, film1);
        DBHelper.giveFilmToDirector(film1, director1);

    }

}
