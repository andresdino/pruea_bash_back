package com.prueba_back.prueba_java.Repository;


import com.prueba_back.prueba_java.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


}
