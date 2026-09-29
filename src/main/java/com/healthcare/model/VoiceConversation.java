package com.healthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "voice_conversations")
public class VoiceConversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private User patient; // Evaru matladaro

    private String userTranscript; // Patient em cheppado - "naku 2 days jwaram"

    private String aiResponse; // AI em cheppindo - "Cold kuda unda?"

    private String detectedSymptoms; // AI detect chesina symptoms - fever, headache

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getPatient() { return patient; }
    public void setPatient(User patient) { this.patient = patient; }
    public String getUserTranscript() { return userTranscript; }
    public void setUserTranscript(String userTranscript) { this.userTranscript = userTranscript; }
    public String getAiResponse() { return aiResponse; }
    public void setAiResponse(String aiResponse) { this.aiResponse = aiResponse; }
    public String getDetectedSymptoms() { return detectedSymptoms; }
    public void setDetectedSymptoms(String detectedSymptoms) { this.detectedSymptoms = detectedSymptoms; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
