package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
	/**
	 * ユーザー情報 Repository
	 */
	  @Autowired
	    UserRepository userRepository;


	/**
	 * ユーザー情報 全検索
	 * @return  検索結果
	 */
	public List<UserEntity> searchAll() {
		return userRepository.findAll();
	  }
	/**
	 * ユーザー情報 主キー検索
	 * @return  検索結果
	 */
	public UserEntity findById(Integer id) {
		return (UserEntity) userRepository.findAll();
	}

	/**
	 * ユーザー情報 新規登録
	 * @param  user ユーザー情報
	 */
	public void create(UserRequest userRequest) {
		Date now = new Date();
		UserEntity user = new UserEntity();
		user.setName(userRequest.getName());
		user.setAddress(userRequest.getAddress());
		user.setPhone(userRequest.getPhone());
		user.setCreateDate(now);
		user.setUpdateDate(now);
		userRepository.save(user);

	}
	
	}
