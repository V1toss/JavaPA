package vkaretko.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkaretko.models.Model;

/**
 * Model DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.05.2017.
 */
@Repository
public interface ModelDAO extends CrudRepository<Model,Integer> {

}
