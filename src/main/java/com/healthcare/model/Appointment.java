package com.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Evaru book chesaro
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient;

    // Evarni book chesaro
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDateTime appointmentDate;
    private String status; // PENDING, APPROVED, CANCELLED, COMPLETED

    // --- MANAM ADD CHESE 2 NEW FEATURES KOSAM ---

    // 1. Video Call kosam
    private String meetLink; 

    // 2. Reminder kosam
    private boolean reminderSent = false;

    private String reason; // Enduku kalavalo

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getPatient() { return patient; }
    public void setPatient(User patient) { this.patient = patient; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public LocalDateTime getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDateTime appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMeetLink() { return meetLink; }
    public void setMeetLink(String meetLink) { this.meetLink = meetLink; }
    public boolean isReminderSent() { return reminderSent; }
    public void setReminderSent(boolean reminderSent) { this.reminderSent = reminderSent; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
