package org.zerock.bimovie.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "movie")
@Table(name = "tbl_poster")
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String fname;
    private int idx;  //포스터 순번
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    // 엔티티 클래스에 setXXX 메서드는 가능하면 줄이는 것이 좋음
    // 하지만 하위 엔티티는 상위 엔티티에서 관리하기 편하도록 약간의 set메서드를 지정하기도 함
    public void setIdx(int idx){
        this.idx = idx;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }
}
