package kg.aidin.jaxrs.service;

import kg.aidin.jaxrs.dao.UserDao;
import kg.aidin.jaxrs.dao.UserDaoImpl;
import kg.aidin.jaxrs.model.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save(UserModel userModel){
        UserDao userDao = new UserDaoImpl();
        userDao.save(userModel);
        return Response.ok()
                .entity("УСпешно сохранено")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getById(@PathParam("id") Long id){
        UserDao userDao = new UserDaoImpl();
        return Response.ok()
                .entity(userDao.findById(id))
                .build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll(){
        UserDao userDao = new UserDaoImpl();
        return Response.ok()
                .entity(userDao.findAll())
                .build();
    }
}
