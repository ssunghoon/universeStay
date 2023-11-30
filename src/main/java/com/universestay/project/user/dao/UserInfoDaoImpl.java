package com.universestay.project.user.dao;

import com.universestay.project.user.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    SqlSession session;
    final private static String namespace = "com.universestay.project.user.dao.UserInfoDao.";

    @Override
    public UserDto getUserInfo(String user_email) throws Exception {
        return session.selectOne(namespace + "selectUserInfo", user_email);
    }

    @Override
    public int updateUserInfo(UserDto userDto) throws Exception {
        return session.update(namespace + "updateUserInfo", userDto);
    }

    @Override
    public int deleteUser(String user_email) throws Exception {
        return session.delete(namespace + "deleteUser", user_email);
    }
}