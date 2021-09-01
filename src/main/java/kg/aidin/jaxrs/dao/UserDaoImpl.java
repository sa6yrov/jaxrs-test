package kg.aidin.jaxrs.dao;


import kg.aidin.jaxrs.model.UserModel;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(UserModel userModel) {
        return false;
    }

    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public UserModel findById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
