package kg.aidin.jaxrs.dao;

import kg.aidin.jaxrs.model.TaskModel;


import java.util.List;

public interface TaskDao {
    boolean save(TaskModel taskModel);
    List<TaskModel> findAll();
    TaskModel findById(Long id);
    boolean delete(Long id);

}
