package fr.liaud1u.potatoesbdd.model;

import org.springframework.data.repository.CrudRepository;
import sun.security.tools.policytool.PolicyTool;

public interface PotatoRepository extends CrudRepository<Potato,Integer> {
    Iterable<Potato> findByColourOfSkin(String colour);

    Potato findById(long id);

    void deleteById(long id);

}
