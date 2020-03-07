package com.assignment.movielist.Repositories.Custom.Implementation;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Repositories.Custom.CustomMovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO complete the dynamic query
    @Override
    public List<Movie> getMoviesByFilter(String name, Date releaseBefore, Date releaseAfter) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> query = cb.createQuery(User.class);
//        Root<User> user = query.from(User.class);
//
//        Path<String> emailPath = user.get("email");
//
//        List<Predicate> predicates = new ArrayList<>();
//        for (String email : emails) {
//            predicates.add(cb.like(emailPath, email));
//        }
//        query.select(user)
//                .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
//
//        return entityManager.createQuery(query)
//                .getResultList();


        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);

        Root<Movie> movie = query.from(Movie.class);

        Path<String> moviePath = movie.get("name");

        query
                .select(movie)
                .where(criteriaBuilder.like(moviePath,"%"+name+"%"));

        return entityManager.createQuery(query).getResultList();
    }
}
