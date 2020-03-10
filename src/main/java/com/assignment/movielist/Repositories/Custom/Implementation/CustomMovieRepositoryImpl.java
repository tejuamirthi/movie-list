package com.assignment.movielist.Repositories.Custom.Implementation;

import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Repositories.Custom.CustomMovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

public class CustomMovieRepositoryImpl implements CustomMovieRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO complete the dynamic query
    @Override
    public <T> List<Movie> getMoviesByFilter(String name, Date releaseBefore, Date releaseAfter, T sortBy, boolean desc) {
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
        Path<Date> movieReleasedAfter = movie.get("releaseDate");
        Path<Date> movieReleasedBefore = movie.get("releaseDate");

        List<Predicate> predicateList = new ArrayList<>();

        if(name != null) {
            Predicate titlePredicate = criteriaBuilder.like(moviePath,"%"+name+"%");
            predicateList.add(titlePredicate);
        }

        if(releaseBefore != null) {
            Predicate preRelBefore = criteriaBuilder.lessThan(movieReleasedBefore, releaseBefore);
            predicateList.add(preRelBefore);
        }

        if(releaseAfter != null) {
            Predicate preRelAfter = criteriaBuilder.greaterThan(movieReleasedAfter, releaseAfter);
            predicateList.add(preRelAfter);
        }

        query
                .select(movie)
                .where(predicateList.toArray(new Predicate[predicateList.size()]));


        if(sortBy != null) {
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    if(o1.getReleaseDate() == null )
                        return 1;
                    else if (o2.getReleaseDate() == null)
                        return -1;

                    if (sortBy.equals(name))
                        return o1.getName().compareTo(o2.getName());
                    else
                        return o1.getReleaseDate().compareTo(o2.getReleaseDate());
                }
            };
            List<Movie> results = entityManager.createQuery(query).getResultList();
            if (!desc)
                Collections.sort(results,comparator);
            else
                Collections.sort(results,comparator.reversed());
            return results;

            // Use orderBy database criteria to make query
            /*
            if(sortBy.equals(name))
                query.orderBy(criteriaBuilder.asc(movie.get("name")));
            else
                query.orderBy(criteriaBuilder.asc(movie.get("releaseDate")));
            } else if(sortBy != null) {
                if(sortBy.equals(name))
                    query.orderBy(criteriaBuilder.desc(movie.get("name")));
                else
                    query.orderBy(criteriaBuilder.desc(movie.get("releaseDate")));
            */
        }

        return entityManager.createQuery(query).getResultList();
    }
}
