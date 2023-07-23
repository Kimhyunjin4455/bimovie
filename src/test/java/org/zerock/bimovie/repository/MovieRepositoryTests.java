package org.zerock.bimovie.repository;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.bimovie.entity.Movie;
import org.zerock.bimovie.entity.Poster;

@SpringBootTest
@Log4j2
public class MovieRepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

//    @Test
//    public void testInsert(){
//        log.info("testInsert.....................");
//
//        Movie movie = Movie.builder().title("범죄도시").build();
//        movie.addPoster(Poster.builder().fname("범죄도시포스터1.jpg").build());
//        movie.addPoster(Poster.builder().fname("범죄도시포스터2.jpg").build());
//
//        movieRepository.save(movie);
//
//        log.info(movie.getMno());
//    }

    @Test
    @Transactional
    @Commit
    public void testAddPoster(){
        Movie movie = movieRepository.getOne(1L);
        movie.addPoster(Poster.builder().fname("범죄도시포스터3.jpg").build());
        movieRepository.save(movie);
    }


//    @Test
//    @Transactional
//    @Commit
//    public void testRemovePoster(){
//        Movie movie = movieRepository.getOne(1L);
//        movie.removePoster(2L);
//        movieRepository.save(movie);
//    }


//    @Test
//    public void deleteByMno(){
//        movieRepository.deleteById(1L);
//        movieRepository.deleteById(2L);
//    }
}
