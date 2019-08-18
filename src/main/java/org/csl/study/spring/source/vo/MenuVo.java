package org.csl.study.spring.source.vo;

import java.util.ArrayList;
import java.util.List;

import org.csl.study.spring.source.po.Menu;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MenuVo extends Menu {

	
	private List<MenuVo> childList = new ArrayList<>();
}
