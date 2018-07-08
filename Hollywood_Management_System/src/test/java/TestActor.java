import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestActor {

    Actor actor1;
    Actor actor2;
    Film film1;
    Director director1;
    Studio studio1;

    @Before
    public void setUp() throws Exception {
        actor1 = new Actor("Kristen Bell", 1);
        actor2 = new Actor("Idina Manzel", 1);
        director1 = new Director("Chris Buck", 2);
        studio1 = new Studio("Walt Disney", 1000);
        film1 = new Film("Frozen", "animated", director1, studio1);

    }

    @Test
    public void hasName() {
        assertEquals("Kristen Bell", actor1.getName());
        actor1.setName("Idina Manzel");
        assertEquals("Idina Manzel", actor1.getName());
    }

    @Test
    public void hasFee() {
        assertEquals(1, actor1.getFeeInMillions());
        actor2.setFeeInMillions(2);
        assertEquals(2, actor2.getFeeInMillions());
    }

    @Test
    public void hasFilms() {
        assertEquals(0, actor1.getFilms().size());
    }

    @Test
    public void hasCash() {
        assertEquals(0, actor2.getCash());
    }

    @Test
    public void canAddFilms() {
        actor1.addFilm(film1);
        assertEquals(1, actor1.getFilms().size());

        List<Film> newFilms = new ArrayList<Film>();
        newFilms.add(film1);
        actor1.setFilms(newFilms);
        assertEquals(1, actor1.getFilms().size());
    }

    @Test
    public void testFilmsAppearedByGenre() {
        actor1.addFilm(film1);
        int count = actor1.filmsAppearedByGenre("animated");
        assertEquals(1, count);
    }
}

