package rw.bdf.attendance.services;

import rw.bdf.attendance.payload.AuthResponse;

import java.util.UUID;

public interface IAuthService {

    AuthResponse login(String email, String password);

    String initiatePasswordReset(String email);

    String resetPassword(String token, String password);

    String initiateEmailVerification(UUID id);

    String verifyEmail(String token);

}
