package lesson30.dao.impl;

import lesson30.dao.AuthorDao;
import lesson30.model.Author;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@Repository
@RequiredArgsConstructor
public class AuthorDaoJpa implements AuthorDao {

    private final EntityManager em;

    @Override
    public List<Author> findAll() {
//        em.getTransaction().begin();
        final Query selectAllQuery = em.createQuery("select a from Author a");
        final List resultList = selectAllQuery.getResultList();
//        em.getTransaction().commit();
        return resultList;

    }

    @Override
    public Optional<Author> getById(long authorId) {
        return Optional.ofNullable(em.find(Author.class, authorId));
    }

    @Override
    public Author save(@Valid Author author) {
        if (author.getId() == 0) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public void deleteById(long authorId) {
        em.createQuery("delete from Author a where a.id = :authorId")
                .setParameter("authorId", authorId)
                .executeUpdate();
    }

    @Override
    public void delete(@Valid Author author) {
        em.remove(author);
    }
}
