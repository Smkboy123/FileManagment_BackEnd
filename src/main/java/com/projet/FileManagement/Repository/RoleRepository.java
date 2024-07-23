package com.projet.FileManagement.Repository;

import com.projet.FileManagement.models.Role;
import com.projet.FileManagement.models.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    public Optional<Role> findByRoleName(RoleName roleName);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO role (id,role_name) VALUES (1,'ROLE_ADMIN'),  (2,'ROLE_USER');",nativeQuery = true)
    void creationrole();

}
