package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.EditMovieForm;
import com.example.demo.form.MovieForm;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@Controller
public class MovieController {
	
    @Autowired
    MovieService service;
	
    @GetMapping("/movie-list")
    public String movieList(Model model) {

        // serviceを使って、本の一覧をDBから取得する
        List<Movie> movieList = service.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("movieList", movieList);
        // bookList.htmlの表示
        return "movieList";
    }
	
    /**
     * 新規登録画面を表示
     * @param model
     * @return 新規登録画面
     */
    @GetMapping("/movie-create")
    public String createMovie(Model model) {

        model.addAttribute("movieForm", new MovieForm());

        return "add";
    }

    /**
     * データベースに本を登録する
     * @param bookForm
     * @param model
     * @return
     */
    @PostMapping("/movie-create")
    public String saveMovie(@ModelAttribute @Validated MovieForm movieForm, BindingResult result,Model model) {
    	
    	// バリデーションエラーの場合
    	if (result.hasErrors()) {
    		// 新規登録画面に遷移
    		return "add";
    	}

        // 本を登録する
        service.insert(movieForm);

        // 本の一覧表示画面にリダイレクト
        return "redirect:/movie-list";
    }
    
    /**
     * 編集画面を表示する
     * @param model
     * @param editBook
     * @return
     */
    @GetMapping("/movie-edit")
    public String editBook(Model model, EditMovieForm editMovie) {
    		
    	editMovie = service.getOneBook(editMovie.getId());
        model.addAttribute(editMovie);
    		
        return "edit";
    }
    
    /**
     * 本の情報を更新する
     * @param editBook
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/movie-edit")
    public String update(@ModelAttribute @Validated EditMovieForm editMovie, BindingResult result, Model model) {

        // バリデーションエラーの場合
        if (result.hasErrors()) {
            // 編集画面に遷移
            return "edit";
        }

        // 本を更新する
        service.update(editMovie);

        // 本の一覧画面にリダイレクト
        return "redirect:/movie-list";
    }
    
    /**
     * 本の削除を行う
     * @param model
     * @param Book
     * @return
     */
    @GetMapping("/movie-delete")
    public String deleteBook(Model model, Movie Movie) {

        // データベースのデータを削除する
        service.delete(Movie.getId());

        // 本の一覧画面にリダイレクト
        return "redirect:/movie-list";
    }
}
