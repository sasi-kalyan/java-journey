package io.expense.tracker.app.repository;

import io.expense.tracker.app.entity.CustomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends CrudRepository<CustomUser, Long> {

}
