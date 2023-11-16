package rw.bdf.attendance.mappers;

import rw.bdf.attendance.exceptions.CustomNotfoundException;
import rw.bdf.attendance.payload.ApiResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomNotFoundExceptionMapper implements ExceptionMapper<CustomNotfoundException> {

    @Override
    public Response toResponse(CustomNotfoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(
                        ApiResponse.error(exception.getMessage())
                )
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}