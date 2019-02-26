package com.zj.data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zj.data.domain.App;


/**
 * 应用基础
 */
@Mapper
public interface AppMapper {


	@Select("SELECT a.*,(select codeName from sys_code c where codetype='AppType' and a.appType =c.codeValue) AppTypeName  FROM um_app a where validFlag = 'Y' and a.type != '4' ORDER BY appId")
	public List<App> queryList();
	
	

}