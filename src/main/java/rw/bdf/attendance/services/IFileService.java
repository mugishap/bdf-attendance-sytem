package rw.bdf.attendance.services;

import rw.bdf.attendance.models.File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.util.List;
import java.util.UUID;

public interface IFileService {

    File save(UUID uploadedById, MultipartFormDataInput input);

    List<File> findAll();

    File findById(UUID id);

    void delete(UUID id);

}