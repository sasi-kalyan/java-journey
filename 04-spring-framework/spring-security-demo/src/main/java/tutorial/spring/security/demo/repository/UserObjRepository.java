package tutorial.spring.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorial.spring.security.demo.dto.UserObj;

import java.util.Optional;

@Repository
public interface UserObjRepository extends JpaRepository<UserObj, Long> {
    Optional<UserObj> findByUsername(String username);
}
