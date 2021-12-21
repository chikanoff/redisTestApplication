package by.chikanoff.redisTest.repository;

import by.chikanoff.redisTest.beans.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends CrudRepository<Movie, String> {
}
