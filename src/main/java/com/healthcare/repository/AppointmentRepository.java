package com.healthcare.repository; // Repository folder lo

import com.healthcare.model.Appointment; // Appointment table tho pani
import com.healthcare.model.User; // Patient tho link kabatti User kavali
import com.healthcare.model.Doctor; // Doctor tho link kabatti Doctor kavali
import org.springframework.data.jpa.repository.JpaRepository; // DB tools
import java.time.LocalDateTime; // Date tho search kosam
import java.util.List; // Chala appointments vastai kabatti List

public interface AppointmentRepository extends JpaRepository<Appointment, Long> { // Appointment table ki full access

    List<Appointment> findByPatient(User patient); // Oka patient book chesina anni appointments chudadaniki - My Appointments page lo

    List<Appointment> findByDoctor(Doctor doctor); // Oka doctor ki vachina anni appointments chudadaniki - Doctor Dashboard lo

    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end); // Reminder Feature kosam - Repu unna appointments anni velakadaniki. Eg: start=tomorrow 00:00, end=tomorrow 23:59
}
