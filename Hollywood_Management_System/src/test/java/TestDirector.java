import models.Director;
import models.Film;
import models.Film_staff;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestDirector {

    Film film1;
    Director director1;
    Studio studio1;

    @Before
    public void setUp() throws Exception {
        director1 = new Director("Chris Buck", 2);
        studio1 = new Studio("Walt Disney", 1000);
        film1 = new Film("Frozen", "animated", director1, studio1);
    }

    @Test
    public void hasName() {
        assertEquals("Chris Buck", director1.getName());
        director1.setName("Chris");
        assertEquals("Chris", director1.getName());
    }

    @Test
    public void hasFee() {
        assertEquals(2, director1.getFeeInMillions());
        director1.setFeeInMillions(3);
        assertEquals(3, director1.getFeeInMillions());
    }

    @Test
    public void hasFilms() {
        assertEquals(0, director1.getFilms().size());
    }

    @Test
    public void canAddFilms() {
        director1.addFilm(film1);
        assertEquals(1,director1.getFilms().size());

        List<Film> newFilms = new ArrayList<Film>();
        newFilms.add(film1);
        director1.setFilms(newFilms);
        assertEquals(1, director1.getFilms().size());
    }

}
