package rw.bdf.attendance.serviceImpls;

import rw.bdf.attendance.exceptions.CustomBadRequestException;
import rw.bdf.attendance.models.File;
import rw.bdf.attendance.models.User;
import rw.bdf.attendance.repositories.UserRepository;
import rw.bdf.attendance.services.IFileService;
import rw.bdf.attendance.services.IUserService;
import rw.bdf.attendance.services.MailService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import java.util.List;
import java.util.UUID;


@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final MailService mailService;
    private final IFileService fileService;

    @Override
    public User create(User user) {
        try {
            this.userRepository.persist(user);
            this.mailService.sendWelcomeEmail(user.getEmail(), user.getNames());
            return user;
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
            throw new CustomBadRequestException(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try {
            this.userRepository.persist(user);
        } catch (Exception e) {
            throw new CustomBadRequestException(e.getMessage());
        }
    }

    @Override
    public User findById(UUID id) {
        return this.userRepository.findById(id);
    }

    @Override
    public User uploadProfile(UUID id, MultipartFormDataInput input) {
        File file = this.fileService.save(id, input);
        User user = this.userRepository.findById(id);
        user.setProfileImage(file);
        this.userRepository.persist(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.listAll();
    }

    @Override
    public void delete(UUID id) {
        this.userRepository.deleteById(id);
    }
}
