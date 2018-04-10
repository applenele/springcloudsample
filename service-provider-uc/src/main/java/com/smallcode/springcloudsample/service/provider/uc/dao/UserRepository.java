package com.smallcode.springcloudsample.service.provider.uc.dao;

import com.smallcode.springcloudsample.service.provider.uc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
