package kr.latera.mybatis.mapper;

import java.util.List;

import kr.latera.mybatis.dto.UserDto;

public interface UserMapper {
	UserDto selectUserById(String id);
	List<UserDto> selectUserList();
	void insertUser(UserDto user);
	void updateUser(UserDto user);
	void deleteUser(String id);
}
