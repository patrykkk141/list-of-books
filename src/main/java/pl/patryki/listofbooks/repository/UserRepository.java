package pl.patryki.listofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patryki.listofbooks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
