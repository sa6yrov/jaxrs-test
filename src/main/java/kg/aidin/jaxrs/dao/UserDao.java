package kg.aidin.jaxrs.dao;

import kg.aidin.jaxrs.model.UserModel;

import java.util.List;

public interface UserDao{
    boolean save(UserModel userModel);
    List<UserModel> findAll();
    UserModel findById(Long id);
    boolean delete(Long id);
}
