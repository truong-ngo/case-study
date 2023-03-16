package com.example.projectdemobackend.service;

import com.example.projectdemobackend.model.Role;

public interface IRoleService extends IService<Role, Long> {
    Role findByName(String name);
}
