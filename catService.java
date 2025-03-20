package com.csc340.sp25_crud_api_demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CatService.java
 * Centralizes data access to the Cat Database.
 */
@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    /**
     * Fetch all Cats.
     *
     * @return the list of all Cats.
     */
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    /**
     * Fetch a unique cat by its ID.
     *
     * @param catId the unique Cat id.
     * @return a unique Cat object.
     */
    public Cat getCatById(int catId) {
        return catRepository.findById(catId).orElse(null);
    }

    /**
     * Fetch all cats whose breed matches the search term.
     *
     * @param breed the search key.
     * @return the list of matching Cats.
     */
    public List<Cat> getCatsByBreed(String breed) {
        return catRepository.getCatsByBreed(breed);
    }

    /**
     * Fetch all cats with an age above a certain threshold.
     *
     * @param age the threshold age.
     * @return the list of matching Cats.
     */
    public List<Cat> getCatsByAge(double age) {
        return catRepository.getCatsByAge(age);
    }

    /**
     * Fetch all cats with a name that contains the given string.
     *
     * @param name the search name.
     * @return the list of matching Cats.
     */
    public List<Cat> getCatsByName(String name) {
        return catRepository.getCatsByName(name);
    }

    /**
     * Fetch all cats with a description that contains the given string.
     *
     * @param description the search key.
     * @return the list of matching Cats.
     */
    public List<Cat> getCatsByDescription(String description) {
        return catRepository.getCatsByDescription(description);
    }

    /**
     * Add a new Cat to the database.
     *
     * @param cat the new Cat to add.
     */
    public void addNewCat(Cat cat) {
        catRepository.save(cat);
    }

    /**
     * Update an existing Cat.
     *
     * @param catId the unique Cat Id.
     * @param cat   the new Cat details.
     */
    public void updateCat(int catId, Cat cat) {
        Cat existing = getCatById(catId);
        if (existing != null) {
            existing.setName(cat.getName());
            existing.setDescription(cat.getDescription());
            existing.setBreed(cat.getBreed());
            existing.setAge(cat.getAge());
            existing.setActiveDate(cat.getActiveDate());

            catRepository.save(existing);
        }
    }

    /**
     * Delete a unique Cat.
     *
     * @param catId the unique Cat Id.
     */
    public void deleteCatById(int catId) {
        catRepository.deleteById(catId);
    }
}
