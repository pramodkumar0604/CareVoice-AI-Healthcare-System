package com.healthcare.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CareVoiceController {

    private List<Map<String,Object>> bookings = new ArrayList<>();

    @PostMapping("/upload-report")
    public Map<String,Object> uploadReport(@RequestParam("report") MultipartFile file,
                                          @RequestParam(value="email", required=false) String email,
                                          @RequestParam(value="doctor", required=false) String doctor) throws Exception {
        Path uploadPath = Paths.get("uploads");
        if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
        String filename = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), uploadPath.resolve(filename));
        System.out.println("✅ PDF VACHINDI: " + filename);
        return Map.of("success", true, "file", filename);
    }

    @PostMapping("/book")
    public Map<String,Object> bookAppointment(@RequestBody Map<String,Object> booking) {
        bookings.add(booking);
        System.out.println("✅ BOOKING VACHINDI: " + booking);
        return Map.of("success", true);
    }

    @PostMapping("/video-room")
    public Map<String,Object> createVideoRoom() {
        String roomId = "carevoice-" + System.currentTimeMillis();
        return Map.of("roomId", roomId, "jitsiLink", "https://meet.jit.si/" + roomId);
    }

    @GetMapping("/bookings")
    public List<Map<String,Object>> getBookings() { return bookings; }
}
