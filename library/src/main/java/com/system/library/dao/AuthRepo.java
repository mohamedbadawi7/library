package com.system.library.dao;

import com.system.library.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepo extends JpaRepository<Authorities, Integer> {
}
