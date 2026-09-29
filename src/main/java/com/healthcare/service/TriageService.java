package com.healthcare.service;

import org.springframework.stereotype.Service;

@Service // Idi pedithe Spring ki idi brain ani telustundi
public class TriageService {

    // Patient cheppina symptoms batti level decide chestundi
    public String decideTriageLevel(String symptoms) {
        symptoms = symptoms.toLowerCase();
        // Nee flow lo HIGH risk - direct doctor kavali
        if(symptoms.contains("chest pain") || symptoms.contains("breath") || symptoms.contains("5 days")) {
            return "HIGH";
        } else if(symptoms.contains("fever") || symptoms.contains("headache")) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    // Level ni batti e doctor kavalo suggest chestundi
    public String suggestSpecialization(String symptoms) {
        symptoms = symptoms.toLowerCase();
        if(symptoms.contains("heart") || symptoms.contains("chest")) return "Cardiologist";
        if(symptoms.contains("fever") || symptoms.contains("cold")) return "General Physician";
        if(symptoms.contains("skin")) return "Dermatologist";
        return "General Physician";
    }
}
