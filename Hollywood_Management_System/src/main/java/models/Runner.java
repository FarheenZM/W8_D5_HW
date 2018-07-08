package models;

import db.DBHelper;

public class Runner {

    public static void main(String[] args){

        Studio studio1 = new Studio("20th Century Fox", 1000);
        DBHelper.save(studio1);
        Studio studio2 = new Studio("Warner Bros", 3000);
        DBHelper.save(studio2);

        Director director1 = new Director("James Cameron ", 1);
        DBHelper.save(director1);
        Director director2 = new Director("Alejandro Inarittu", 2);
        DBHelper.save(director2);
        Director director3 = new Director("Christopher Nolan", 1);
        DBHelper.save(director3);

        Actor actor1 = new Actor("Leonardo DiCaprio", 2);
        DBHelper.save(actor1);
        Actor actor2 = new Actor("Kate Winslet", 1);
        DBHelper.save(actor2);
        Actor actor3 = new Actor("Tom Hardy", 1);
        DBHelper.save(actor3);
        Actor actor4 = new Actor("Ellen Page", 2);
        DBHelper.save(actor4);

        Film film1 = new Film("Titanic", "Romance", director1, studio1);
        DBHelper.save(film1);
        Film film2 = new Film("The Revenant", "Thriller", director2, studio1);
        DBHelper.save(film2);
        Film film3 = new Film("Inception", "Sci-fi", director3, studio2);
        DBHelper.save(film3);

        DBHelper.addFilmToStudio(film1, studio1);
        DBHelper.addActorToFilm(actor1, film1);
        DBHelper.addActorToFilm(actor2, film1);
        DBHelper.giveFilmToDirector(film1, director1);
        studio1.payActor(actor1);
        studio1.payActor(actor2);

        DBHelper.addFilmToStudio(film2, studio1);
        DBHelper.addActorToFilm(actor1, film2);
        DBHelper.addActorToFilm(actor3, film2);
        DBHelper.giveFilmToDirector(film2, director2);
        studio2.payActor(actor1);
        studio2.payActor(actor3);

        DBHelper.addFilmToStudio(film3, studio2);
        DBHelper.addActorToFilm(actor1, film3);
        DBHelper.addActorToFilm(actor3, film3);
        DBHelper.addActorToFilm(actor4, film3);
        DBHelper.giveFilmToDirector(film3, director3);
        studio2.payActor(actor1);
        studio2.payActor(actor3);
        studio2.payActor(actor4);

        DBHelper.update(studio1);
        DBHelper.update(studio2);
        DBHelper.update(actor1);
        DBHelper.update(actor2);
        DBHelper.update(actor3);
        DBHelper.update(actor4);

        int countOfFilms = actor1.filmsAppearedByGenre("Thriller");

    }

}
