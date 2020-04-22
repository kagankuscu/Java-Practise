package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.util.NumberGenerator;
import com.pluralsight.bookstore.util.TextUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class BookRepository {

    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;

    @Inject
    private TextUtil textUtil;

    @Inject
    private NumberGenerator numberGenerator;

    public Book find(Long id) {
        return em.find(Book.class, id);
    }

    @Transactional(REQUIRED)
    public Book create(Book book) {
        book.setTitle(textUtil.sanitize(book.getTitle()));
        book.setIsbn(numberGenerator.generatorNumber());
        em.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete(Long id) {
        em.remove(em.getReference(Book.class, id));
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b order by b.title", Book.class);
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery("SELECT count(b) FROM Book b", Long.class);
        return query.getSingleResult();
    }
}
