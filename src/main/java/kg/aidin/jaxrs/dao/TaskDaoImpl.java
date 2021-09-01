package kg.aidin.jaxrs.dao;


import kg.aidin.jaxrs.config.DbConfig;
import kg.aidin.jaxrs.model.TaskModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDaoImpl implements TaskDao{

    @Override
    public boolean save(TaskModel taskModel) {
        String sql = "insert into task(name, user_id) values(?, ?)";
        try(Connection connection = DbConfig.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, taskModel.getName());
            pstmt.setLong(2, taskModel.getUserId());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TaskModel> findAll() {
        List<TaskModel> taskModels = new ArrayList<>();
        String sql = "select * from task";
        try (Connection connection = DbConfig.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                TaskModel taskModel = TaskModel.builder()
                        .name(resultSet.getString("name"))
                        .userId(resultSet.getLong("user_id"))
                        .build();
                taskModels.add(taskModel);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return taskModels;
    }

    @Override
    public TaskModel findById(Long id) {
        String sql = "select * from task where id = " + id;
//        try(Connection connection = DbConfig.connect();
//            PreparedStatement pstmt = connection.prepareStatement(sql)){
//            pstmt.setLong(1, id);
//            ResultSet resultSet = pstmt.getResultSet();
//            return TaskModel.builder()
//                    .name(resultSet.getString("name"))
//                    .userId(resultSet.getLong("user_id"))
//                    .build();
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        try {
            ResultSet resultSet = DbConfig.connect().createStatement().executeQuery(sql);
            resultSet.next();
            return TaskModel.builder()
                    .name(resultSet.getString("name"))
                    .userId(resultSet.getLong("user_id"))
                    .build();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
