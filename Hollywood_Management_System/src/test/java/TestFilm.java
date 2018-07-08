import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestFilm {

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
        assertEquals("Frozen", film1.getName());
        studio1.setName("Frozen2");
        assertEquals("Frozen2", studio1.getName());
    }

    @Test
    public void hasGenre() {
        assertEquals("animated", film1.getGenre());
        film1.setGenre("entertainment");
        assertEquals("entertainment", film1.getGenre());
    }

    @Test
    public void hasActors() {
        film1.addActor(actor1);
        assertEquals(1, film1.getActors().size());

        List<Actor> newActors = new ArrayList<Actor>();
        newActors.add(actor1);
        newActors.add(actor2);
        film1.setActors(newActors);
        assertEquals(2, film1.getActors().size());

    }
}
