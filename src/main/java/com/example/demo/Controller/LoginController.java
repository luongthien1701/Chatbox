package com.example.demo.Controller;

import com.example.demo.Model.Acount;
import com.example.demo.repository.AcountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AcountRepository acountRepository;

    @PostMapping("/login")
    public String login(@RequestBody Acount loginData) {
        Optional<Acount> user = acountRepository.findByUsernameAndPassword(
                loginData.getUsername(), loginData.getPassword());

        if (user.isPresent()) {
            return "Đăng nhập thành công!";
        } else {
            return "Sai tài khoản hoặc mật khẩu!";
        }
    }
}
