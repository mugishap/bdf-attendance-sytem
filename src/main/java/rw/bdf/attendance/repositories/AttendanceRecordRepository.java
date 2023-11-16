package rw.bdf.attendance.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import rw.bdf.attendance.models.AttendanceRecord;

import java.util.UUID;

public class AttendanceRecordRepository implements PanacheRepositoryBase<AttendanceRecord, UUID> {
}
