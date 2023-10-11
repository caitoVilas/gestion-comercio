package com.trade.domain.dao;

import com.trade.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

        boolean findByEmail(String email);
}
