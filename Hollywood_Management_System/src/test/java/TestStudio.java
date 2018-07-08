import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStudio {

    Studio studio1;
    Director director1;
    Film film1;
    Actor actor1;
    Actor actor2;

    @Before
    public void setUp() throws Exception {
        studio1 = new Studio("Walt Disney", 1000);
        director1 = new Director("Chris Buck", 2);
        film1 = new Film("Frozen", "animated", director1, studio1 );
        actor1 = new Actor("Kristen Bell", 1);
        actor2 = new Actor("Idina Manzel", 1);

    }

    @Test
    public void hasName() {
        assertEquals("Walt Disney", studio1.getName());
        studio1.setName("20th Century Fox");
        assertEquals("20th Century Fox", studio1.getName());
    }

    @Test
    public void hasBudget() {
        assertEquals(1000, studio1.getBudgetInMillions());
        studio1.setBudgetInMillions(500);
        assertEquals(500, studio1.getBudgetInMillions());
    }

    @Test
    public void hasFilms() {
        assertEquals(0, studio1.getFilms().size());
        studio1.addFilm(film1);
        assertEquals(1, studio1.getFilms().size());
    }

    @Test
    public void canPayActor() {
        studio1.payActor(actor1);
        assertEquals(999, studio1.getBudgetInMillions());
    }
}
