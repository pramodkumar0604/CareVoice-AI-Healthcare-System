package com.healthcare.model;

import jakarta.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization; // Ex: Cardiology, Dentist
    private String qualification;
    private int experience;
    private double consultationFee;
    private String availableTimings;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user; // Ee Doctor evaru anedi User table nundi link

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }
    public String getAvailableTimings() { return availableTimings; }
    public void setAvailableTimings(String availableTimings) { this.availableTimings = availableTimings; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
