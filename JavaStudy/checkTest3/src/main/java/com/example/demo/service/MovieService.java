package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.form.EditMovieForm;
import com.example.demo.form.MovieForm;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@Service
@Transactional
public class MovieService {
	
    @Autowired
    MovieRepository repository;
	
    /**
     * データベースから本の一覧を取得する
     * @return
     */
    public List<Movie> findAll() {
        return repository.findAll();
    }
	
    /**
     * データベースにデータを登録する
     * @return
     */
    public void insert(MovieForm movieForm) {
        // データベースに登録する値を保持するインスタンス
    	Movie movie = new Movie();
    	
        // 画面から受け取った値をデータベースに保存するインスタンスに渡す
    	movie.setTitle(movieForm.getTitle());
    	movie.setEvaluation(movieForm.getEvaluation());
    	movie.setPlace(movieForm.getPlace());
    	movie.setWay(movieForm.getWay());
    	movie.setMemo(movieForm.getMemo());
        // データベースに登録する
        repository.save(movie);
    }
    
    /**
     * idからデータを取得する
     * @param id
     * @return
     */
    public EditMovieForm getOneBook(Integer id) {

        // idを指定して本の情報を取得する
    	Movie movie = repository.findById(id).orElseThrow();

        // 画面返却用のFormに値を設定する
        EditMovieForm editMovie = new EditMovieForm();
        editMovie.setId(movie.getId());
        editMovie.setTitle(movie.getTitle());
        editMovie.setEvaluation(movie.getEvaluation());
        editMovie.setPlace(movie.getPlace());
        editMovie.setWay(movie.getWay());
        editMovie.setMemo(movie.getMemo());
        
        return editMovie;
    }
    
    
    /**
     * 本の情報を更新する
     * @param editBook
     */
    public void update(EditMovieForm editMovie) {

        // データベースに登録する値を保持するインスタンスの作成
    	Movie movie = new Movie();

        // 画面から受け取った値を設定する
    	movie.setId(editMovie.getId());
    	movie.setTitle(editMovie.getTitle());
    	movie.setEvaluation(editMovie.getEvaluation());
    	movie.setPlace(editMovie.getPlace());
    	movie.setWay(editMovie.getWay());
    	movie.setMemo(editMovie.getMemo());

        // データベースを更新する
        repository.save(movie);
    }
    
    /**
     * 本を削除する
     * @param id
     */
    public void delete(Integer id) {

        // idを指定して、データベースからデータを削除する
        repository.deleteById(id);
    }
}