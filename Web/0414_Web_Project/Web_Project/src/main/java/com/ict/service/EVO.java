package com.ict.service;

import org.springframework.web.multipart.MultipartFile;

public class EVO {
	public String idx, title, content, sm_img, lg_img, s_date, e_date;
	MultipartFile sm_file, lg_file;
	
	
	public EVO() {}
	
	
	public EVO(String idx, String title, String content, String sm_img, String lg_img, String s_date, String e_date,
			MultipartFile sm_file, MultipartFile lg_file) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.sm_img = sm_img;
		this.lg_img = lg_img;
		this.s_date = s_date;
		this.e_date = e_date;
		this.sm_file = sm_file;
		this.lg_file = lg_file;
	}

	public MultipartFile getSm_file() {
		return sm_file;
	}

	public void setSm_file(MultipartFile sm_file) {
		this.sm_file = sm_file;
	}


	public MultipartFile getLg_file() {
		return lg_file;
	}

	public void setLg_file(MultipartFile lg_file) {
		this.lg_file = lg_file;
	}


	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSm_img() {
		return sm_img;
	}

	public void setSm_img(String sm_img) {
		this.sm_img = sm_img;
	}

	public String getLg_img() {
		return lg_img;
	}

	public void setLg_img(String lg_img) {
		this.lg_img = lg_img;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	
	

}
