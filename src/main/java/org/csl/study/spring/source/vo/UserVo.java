package org.csl.study.spring.source.vo;

import java.io.Serializable;
import java.util.List;

import org.csl.study.spring.source.po.User;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper=false)
public class UserVo extends User implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<MultipartFile> images;
	
	  
}
