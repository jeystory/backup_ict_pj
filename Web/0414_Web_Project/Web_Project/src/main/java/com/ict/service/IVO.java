package com.ict.service;

import org.springframework.web.multipart.MultipartFile;

public class IVO {
	
	
	String idx, item_category,item_name, item_spec,  item_price, item_cal, item_content, item_aller, file_name;
	MultipartFile file;
	
	public IVO() {
		// TODO Auto-generated constructor stub
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_categpry) {
		this.item_category = item_categpry;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_spec() {
		return item_spec;
	}

	public void setItem_spec(String item_spec) {
		this.item_spec = item_spec;
	}

	public String getItem_price() {
		return item_price;
	}

	public void setItem_price(String item_price) {
		this.item_price = item_price;
	}

	public String getItem_cal() {
		return item_cal;
	}

	public void setItem_cal(String item_cal) {
		this.item_cal = item_cal;
	}

	public String getItem_content() {
		return item_content;
	}

	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}

	public String getItem_aller() {
		return item_aller;
	}

	public void setItem_aller(String item_aller) {
		this.item_aller = item_aller;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
		
	
}
