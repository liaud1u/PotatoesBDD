package fr.liaud1u.potatoesbdd.web;

import fr.liaud1u.potatoesbdd.model.Potato;
import fr.liaud1u.potatoesbdd.model.PotatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class PotatoController {

    @Value("${me}")
    private String me;

    // Potato DAO used for the requests
    @Autowired
    private PotatoRepository potatoDAO;

    /**
     * Return the list of all Potatoes of the Database
     *
     * @return List of Potatoes
     */
    @GetMapping(value = "/Potatoes")
    public Iterable<Potato> getPotatoes() {
        return potatoDAO.findAll();
    }

    /**
     * Return the user name
     *
     * @return String name
     */
    @GetMapping(value = "/Cqui")
    public String getMe() {
        return me;
    }

    /**
     * Return the specified Potato by ID
     *
     * @param id int ID of the Potato
     * @return Potato
     */
    @GetMapping(value = "/Potato/{id}")
    public Potato getPotato(@PathVariable long id) {
        return potatoDAO.findById(id);
    }

    /**
     * Add a Potato to Database
     *
     * @param potato Potato to add to the DAO
     */
    @PostMapping(value = "Potato")
    public void addPotato(@RequestBody Potato potato) {
        potatoDAO.save(potato);
    }

    /**
     * Delete potato
     *
     * @param id int id of potato to delete
     */
    @Transactional
    @DeleteMapping("/Potato/{id}")
    void deletePotato(@PathVariable long id) {
        potatoDAO.delete(potatoDAO.findById(id));
    }

    /**
     * Update potato
     *
     * @param potato Potato data
     * @param id     int id of the potato to update
     */
    @PutMapping(value = "Potato/{id}")
    public void updatePotato(@RequestBody Potato potato, @PathVariable long id) {
        Potato pot = potatoDAO.findById(id);
        pot.setBreederCountry(potato.getBreederCountry());
        pot.setColourOfFlesh(potato.getColourOfFlesh());
        pot.setDescription(potato.getDescription());
        pot.setColourOfFlower(potato.getColourOfFlower());
        pot.setHeight(potato.getHeight());
        pot.setMaturity(potato.getMaturity());
        pot.setParentage(potato.getParentage());
        pot.setColourOfSkin(potato.getColourOfSkin());
        pot.setIVTVariety(potato.getIVTVariety());
        pot.setVarietyName(potato.getVarietyName());
        pot.setSmoothness(potato.getSmoothness());
        potatoDAO.save(pot);
    }
}
