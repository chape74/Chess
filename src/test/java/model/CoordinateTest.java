package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("New coordinate in up direction")
    void up() {
        Coordinate c1 = new Coordinate('c', 2);
        Coordinate c2 = new Coordinate('c', 3).up();
        assertAll(
                () -> assertEquals(c1, c2),
                () -> assertEquals(new Coordinate('a', 2), new Coordinate('A', 3).up()),
                () -> assertEquals(new Coordinate('a', 2), new Coordinate('A', 3).up()),
                () -> assertEquals(new Coordinate('f', 6), new Coordinate('F', 7).up())
                );
    }

    @Test
    void upR() {
        assertEquals(new Coordinate('b', 2), new Coordinate('a', 3).upR());
        assertEquals(new Coordinate('b', 2), new Coordinate('A', 3).upR());
        assertEquals(new Coordinate('g', 6), new Coordinate('F', 7).upR());
    }

    @Test
    void upL() {
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 3).upL());
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 3).upL());
        assertEquals(new Coordinate('f', 6), new Coordinate('G', 7).upL());
    }

    @Test
    void down() {
        assertEquals(new Coordinate('a', 2), new Coordinate('A', 1).down());
        assertEquals(new Coordinate('a', 2), new Coordinate('A', 1).down());
        assertEquals(new Coordinate('f', 6), new Coordinate('F', 5).down());
    }

    @Test
    void downR() {
        assertEquals(new Coordinate('b', 2), new Coordinate('A', 1).downR());
        assertEquals(new Coordinate('b', 2), new Coordinate('A', 1).downR());
        assertEquals(new Coordinate('g', 6), new Coordinate('F', 5).downR());
    }

    @Test
    void downL() {
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 1).downL());
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 1).downL());
        assertEquals(new Coordinate('f', 6), new Coordinate('G', 5).downL());
    }

    @Test
    void left() {
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 2).left());
        assertEquals(new Coordinate('a', 2), new Coordinate('B', 2).left());
        assertEquals(new Coordinate('f', 6), new Coordinate('G', 6).left());
    }

    @Test
    void right() {
        assertEquals(new Coordinate('b', 2), new Coordinate('A', 2).right());
        assertEquals(new Coordinate('b', 2), new Coordinate('A', 2).right());
        assertEquals(new Coordinate('g', 6), new Coordinate('F', 6).right());
    }
}