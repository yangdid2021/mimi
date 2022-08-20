package com.ytp.service.imp;

import com.ytp.mapper.AdminMapper;
import com.ytp.pojo.Admin;
import com.ytp.pojo.AdminExample;
import com.ytp.service.Login;
import com.ytp.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginImpl implements Login {
    @Autowired
    AdminMapper admin=null;
    @Override
    public Admin login(String name, String pwd) {

        AdminExample am=new AdminExample();

        am.createCriteria().andANameEqualTo(name);

        List<Admin> admins = admin.selectByExample(am);
        if (admins.size()>0){
            Admin ad=admins.get(0);
            String mima= MD5Util.getMD5(pwd);
            if (mima.equals(MD5Util.getMD5(ad.getaPass()))){
                return ad;
            }
        }
        return null;
    }
}
