package models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actors")
public class Actor extends Film_staff implements IFilm {

    private List<Film> films;
    private int cash;

    public Actor(){}

    public Actor(String name, int fee) {
        super(name, fee);
        this.films = new ArrayList<Film>();
        this.cash = 0;
    }


    @ManyToMany
    @JoinTable(name = "films_actors",
            joinColumns = {@JoinColumn(name = "actor_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    @Column(name = "cash")
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int filmsAppearedByGenre(String genre){
        int count = 0;
        for(Film film : this.films){
            if( genre == film.getGenre()){
                count += 1;
            }
        }
        return count;
    }
}
