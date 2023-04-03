package com.code.codeupspringblog.repositories;

import com.code.codeupspringblog.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<Group, Long> {
    Group findByCode(String code);
}
