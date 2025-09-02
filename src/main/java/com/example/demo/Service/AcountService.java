package com.example.demo.Service;

import com.example.demo.Model.Acount;
import com.example.demo.repository.AcountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcountService {

    @Autowired
    private AcountRepository acountRepository;

    public Integer getIdByDisplayName(String displayName) {
        return acountRepository.findByDisplayName(displayName)
                               .map(Acount::getUserId) // nếu có giá trị thì lấy userId
                               .orElse(null);          // nếu không có thì trả về null
    }
}
