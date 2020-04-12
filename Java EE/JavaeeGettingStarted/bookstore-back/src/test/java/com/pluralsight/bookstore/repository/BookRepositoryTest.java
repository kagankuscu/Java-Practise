package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.model.Language;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(Arquillian.class)
public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void create() throws Exception {

        // Test counting books
        assertEquals(0, bookRepository.findAll().size());
        assertEquals(Long.valueOf(0), bookRepository.countAll());

        // Create a book
        Book book = new Book("a title", "desc", 12F, "isbn", new Date(), 123, "http://blank",Language.ENGLISH);
        bookRepository.create(book);
        Long bookId = book.getId();

        // Check created book
        assertNotNull(bookId);

        // Find created book
        Book bookFound = bookRepository.find(bookId);

        // Check the found book
        assertEquals("a title", bookFound.getTitle());

        // Test counting books
        assertEquals(1, bookRepository.findAll().size());
        assertEquals(Long.valueOf(1), bookRepository.countAll());

        // Delete the book
        bookRepository.delete(bookId);

        // Test counting books
        assertEquals(0, bookRepository.findAll().size());
        assertEquals(Long.valueOf(0), bookRepository.countAll());
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addClass(Language.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("META-INF/test-persistence.xml","persistence.xml");
    }
}