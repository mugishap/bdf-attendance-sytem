package rw.bdf.attendance.mappers;


import rw.bdf.attendance.exceptions.CustomBadRequestException;
import rw.bdf.attendance.payload.ApiResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomBadRequestExceptionMapper implements ExceptionMapper<CustomBadRequestException> {

    @Override
    public Response toResponse(CustomBadRequestException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(
                        ApiResponse.error(exception.getMessage())
                )
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}