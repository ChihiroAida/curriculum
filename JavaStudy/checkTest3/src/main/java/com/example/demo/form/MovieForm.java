package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MovieForm {
	
	    @NotBlank(message="タイトルを入力してください。")
	    private String title;
	    
	    @NotNull(message = "評価を入力してください")
		private Integer evaluation;
		
	    @NotBlank(message="国を入力してください。")
	    private String place;
	    
	    @NotBlank(message="鑑賞方法を入力してください。")
	    private String way;
	    
		@Size(max = 50, message = "50文字以内で入力してください")
		private String memo;
	
}
