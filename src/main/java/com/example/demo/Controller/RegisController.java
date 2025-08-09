package com.example.demo.Controller;

import com.example.demo.Model.Acount;
import com.example.demo.repository.AcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RegisController {

    @Autowired
    private AcountRepository acountRepository;

    @PostMapping("/register")
public ResponseEntity<?> adduser(@RequestBody Acount regisData) {
    if (acountRepository.findByUsername(regisData.getUsername()).isPresent()) {
        return ResponseEntity.badRequest().body("Tai khoan ton tai");
    }
    acountRepository.save(regisData);
    return ResponseEntity.ok("Đăng kí thành công!");
}
}
