package com.movement.front.map.dao.mapper;


import com.movement.front.map.controller.http.request.UserInfoQueryRequest;
import com.movement.front.map.controller.http.request.UserInfoRequest;
import com.movement.front.map.dao.model.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 项目名称:demo 描述: 创建人:ryw 创建时间:2018/12/25
 */
public interface UserInfoDao {

    UserInfo queryUserInfo(String username);

    Integer queryUserPageCount(@Param("query") UserInfoQueryRequest userInfoRequest);

    void updateUserInfo(@Param("userInfo") UserInfoRequest userInfoRequest);

	UserInfo queryUserInfoById(Long id);

	void deleteUserById(Long id);

	void insertUserInfo(@Param("userInfo")UserInfoRequest userInfoRequest);
}
