package vkaretko.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vkaretko.models.Brand;

import java.util.List;

/**
 * Brand DAO class.
 *
 * @author Karetko Victor.
 * @version 1.00.
 * @since 08.05.2017.
 */
@Repository
public interface BrandDAO extends CrudRepository<Brand,Integer> {

}
