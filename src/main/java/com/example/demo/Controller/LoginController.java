package com.example.demo.Controller;

import com.example.demo.Model.Acount;
import com.example.demo.repository.AcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AcountRepository acountRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Acount loginRequest) {
        Optional<Acount> optionalUser = acountRepository.findByUsernameAndPassword(
            loginRequest.getUsername(), loginRequest.getPassword());

        if (optionalUser.isPresent()) {
            Acount user = optionalUser.get();
            Map<String, Object> response = new HashMap<>();
            response.put("userId", user.getUserId());
	    response.put("DisplayName", user.getDisplayName());
            response.put("message", "Đăng nhập thành công");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("message", "Sai tên đăng nhập hoặc mật khẩu"));
        }
    }
}
