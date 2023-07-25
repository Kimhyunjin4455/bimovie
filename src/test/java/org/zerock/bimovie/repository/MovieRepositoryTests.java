package org.zerock.bimovie.repository;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.bimovie.entity.Movie;
import org.zerock.bimovie.entity.Poster;

import java.util.Arrays;
import java.util.stream.IntStream;

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

    @Test
    public void insertMovies(){
        IntStream.rangeClosed(10,100).forEach(i->{ // 10~100까지의 90개
            Movie movie = Movie.builder().title("세계명작" + i).build();

            movie.addPoster(Poster.builder().fname("세계명작"+i+"포스터1.jpg").build());
            movie.addPoster(Poster.builder().fname("세계명작"+i+"포스터2.jpg").build());

            movieRepository.save(movie);

        });
    }

//    @Test
//    public void testPaging1(){
//        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//        Page<Movie> result = movieRepository.findAll(pageable);
//
//        result.getContent().forEach(m->{
//            log.info(m.getMno());
//            log.info(m.getTitle());
//            log.info(m.getPosterList().size());
//            log.info("-------------------------------");
//        });
//    }

//    @Test
//    public void testPaging2All(){
//        // 문제 발생 >> limit 이 없음
//        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//        Page<Movie> result = movieRepository.findAll2(pageable);
//
//        result.getContent().forEach(m->{
//            log.info(m.getMno());
//            log.info(m.getTitle());
//            log.info(m.getPosterList());
//            log.info("-----------------------------");
//        });
//    }

    @Test
    public void testPaging3All(){
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Object[]> result = movieRepository.findAll3(pageable);

        result.getContent().forEach(arr->{
            log.info(Arrays.toString(arr));
            log.info("----------------------------");
        });


    }
}
