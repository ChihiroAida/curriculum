package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "moviesinfo")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    // 本のidを保持するフィールド
    private Integer id;
	
    @Column(name="title")
    // 本のタイトルを保持するフィールド
    private String title;
    
    @Column(name="evaluation")
    // 本のidを保持するフィールド
    private Integer evaluation;
	
    @Column(name="place")
    // 本の値段を保持するフィールド
    private String place;
    
    @Column(name="way")
    // 本の値段を保持するフィールド
    private String way;
    
    @Column(name="memo")
    // 本の値段を保持するフィールド
    private String memo;
}
