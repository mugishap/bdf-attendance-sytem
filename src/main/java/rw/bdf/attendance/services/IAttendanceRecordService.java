package rw.bdf.attendance.services;

import rw.bdf.attendance.models.AttendanceRecord;

import java.util.UUID;

public interface IAttendanceRecordService {

    AttendanceRecord create();

    AttendanceRecord update();

    AttendanceRecord findById();

    AttendanceRecord findAll();

    AttendanceRecord findByUserId(UUID userId);

    void delete();

}
