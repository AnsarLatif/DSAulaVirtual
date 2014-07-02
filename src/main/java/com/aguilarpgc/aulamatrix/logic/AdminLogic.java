package com.aguilarpgc.aulamatrix.logic;

import com.aguilarpgc.aulamatrix.model.Administrator;
import com.aguilarpgc.aulamatrix.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fabiosalasm on 23/03/14.
 */
@Service
public class AdminLogic {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public void updatePassword(String rawPassword) {

        String adminName = SecurityContextHolder.getContext().getAuthentication().getName();
        Administrator administrator = adminRepository.getAdminByUser(adminName);

        ShaPasswordEncoder pwdEncoder = new ShaPasswordEncoder();
        administrator.setPassword(pwdEncoder.encodePassword(rawPassword, null));

        adminRepository.updateAdministrator(administrator);
    }
}
