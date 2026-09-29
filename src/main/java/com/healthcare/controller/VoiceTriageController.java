package com.healthcare.controller;

import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/voice")
@CrossOrigin(origins = "*")
public class VoiceTriageController {

    @Autowired
    private TriageService triageService;

    @Autowired
    private DoctorRepository doctorRepository;

    // Nee flow: Voice -> Text vachaka ee API call avthundi
    @PostMapping("/triage")
    public List<Doctor> doTriage(@RequestBody String symptoms) {
        // 1. Symptoms batti level decide
        String level = triageService.decideTriageLevel(symptoms);
        // 2. E doctor kavalo decide
        String specialization = triageService.suggestSpecialization(symptoms);
        System.out.println("Detected Level: " + level + " Need: " + specialization);
        // 3. DB lo aa doctors ni techi istundi
        return doctorRepository.findBySpecialization(specialization);
    }

    // Kothaga add chesina - Doctors list chudataniki
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
