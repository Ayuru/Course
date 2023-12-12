package com.example.patterns.prototype.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("My Library");

        library.books.add(new Book("Thrawn: Alliances", "Timothy Zahn",
                LocalDate.ofYearDay(2018, 1)));
        library.books.add(new Book("Harry Potter and the Deathly Hallows", "J.K. Rowling",
                LocalDate.ofYearDay(2009, 12)));
        library.books.add(new Book("Daughter of the Blood", "Anne Bishop",
                LocalDate.ofYearDay(1998, 77)));


        //When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        //Then
        Assertions.assertEquals(library.getBooks(), clonedLibrary.getBooks());
        Assertions.assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());

    }
}
