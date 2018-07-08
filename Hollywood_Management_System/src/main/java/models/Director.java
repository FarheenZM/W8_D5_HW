package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "directors")
public class Director extends Film_staff implements IFilm {

    private List<Film> films;

    public Director(){}

    public Director(String name, int fee) {
        super(name, fee);
        this.films = new ArrayList<Film>();
    }


    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

}
