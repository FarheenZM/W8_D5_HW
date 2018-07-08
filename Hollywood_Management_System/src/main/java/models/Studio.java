package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studios")
public class Studio implements IFilm {

    private int id;
    private String name;
    private int budgetInMillions;
    private List<Film> films;

    public Studio(){}

    public Studio(String name, int budget) {
        this.name = name;
        this.budgetInMillions = budget;
        this.films = new ArrayList<Film>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "budget_in_Millions")
    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    @OneToMany(mappedBy = "studio", fetch = FetchType.LAZY)
    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public void payActor(Actor actor){
        int amount = actor.getCash() + actor.getFeeInMillions();
        actor.setCash(amount);
        this.budgetInMillions -= actor.getFeeInMillions();
    }

}
