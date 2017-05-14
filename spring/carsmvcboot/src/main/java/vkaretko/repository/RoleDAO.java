package vkaretko.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkaretko.domain.Role;

/**
 * Role DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 13.05.2017.
 */
@Repository
public interface RoleDAO extends CrudRepository<Role,Integer> {

}
