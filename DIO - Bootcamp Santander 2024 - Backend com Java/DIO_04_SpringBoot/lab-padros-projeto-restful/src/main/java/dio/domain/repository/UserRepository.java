package dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {}
