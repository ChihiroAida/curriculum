package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
  /**
   * ユーザー情報 Service
   */
 @Autowired
 private UserService userService;


  /**
   * ユーザー情報一覧画面を表示
   * @param  model Model
   * @return  ユーザー情報一覧画面のHTML
   */
 @GetMapping("/user/list")
	public String displayList(Model model) {
     List<UserEntity> userlist = userService.searchAll();
	    model.addAttribute("userlist", userlist);
	    return "user/list";

}
 
	/**
	 * ユーザー新規登録画面を表示
	 * @param  model Model
	 * @return  ユーザー情報一覧画面
	 */
  @GetMapping(value = "/user/add")
  public String displayAdd(Model model) {
    return "user/add";
  }
	/**
	 * ユーザー新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  ユーザー情報一覧画面
	 */
	@GetMapping("/user/create")
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		//入力判定入れること
		if (result.hasErrors()) {
			// 入力チェックエラーの場合3行実装
			List<String> errorList = new ArrayList<String>();
		      for (ObjectError error : result.getAllErrors()) {
		        errorList.add(error.getDefaultMessage());
		      }
           //エラー判定後の画面遷移2行実装
		      model.addAttribute("validationError", errorList);
		      model.addAttribute("userRequest", userRequest);
		      return "user/add";
		    }
		// ユーザー情報の登録2行実装
	    userService.create(userRequest);
	    return "redirect:/user/list";
	  }

		/**
		 * ユーザー情報詳細画面を表示
		 * @param  id 表示するユーザーID
		 * @param  model Model
		 * @return  ユーザー情報詳細画面
		 */
  @GetMapping("/user/{id}")
		public String displayView(@PathVariable  Integer id, Model model) {
	   UserEntity user = userService.findById(id);
	    model.addAttribute("userData", user);
			return "user/view";

		}
	}