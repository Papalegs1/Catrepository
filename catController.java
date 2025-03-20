package com.csc340.sp25_crud_api_demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CatController.java
 * Includes all REST API endpoint mappings for the Cat object.
 */
@RestController
@RequestMapping("/animals")
public class CatController {

    @Autowired
    private CatService service;

    /**
     * Get a list of all Cats in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Cat objects.
     */
    @GetMapping("/all")
    public Object getAllCats() {
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.OK);
    }

    /**
     * Get a specific Cat by Id.
     * http://localhost:8080/animals/2
     *
     * @param catId the unique Id for a Cat.
     * @return One Cat object.
     */
    @GetMapping("/{catId}")
    public Object getOneCat(@PathVariable int catId) {
        return new ResponseEntity<>(service.getCatById(catId), HttpStatus.OK);
    }

    /**
     * Get a list of cats with a name that contains the given string.
     * http://localhost:8080/animals/name?search=alex
     *
     * @param search the search key.
     * @return list of Cat objects matching the search key.
     */
    @GetMapping("/name")
    public Object getCatsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getCatsByName(search), HttpStatus.OK);
    }

    /**
     * Get a list of cats with a description that matches the given string.
     * http://localhost:8080/animals/description?search=cute
     *
     * @param description the search key.
     * @return A list of Cat objects matching the search key.
     */
    @GetMapping("/description")
    public Object getCatsByDescription(@RequestParam(name = "search", defaultValue = "") String description) {
        return new ResponseEntity<>(service.getCatsByDescription(description), HttpStatus.OK);
    }

    /**
     * Get a list of cats based on their breed.
     * http://localhost:8080/animals/breed?search=labrador
     *
     * @param breed the search key.
     * @return A list of Cat objects matching the search key.
     */
    @GetMapping("/breed")
    public Object getCatsByBreed(@RequestParam(name = "search", defaultValue = "") String breed) {
        return new ResponseEntity<>(service.getCatsByBreed(breed), HttpStatus.OK);
    }

    /**
     * Get a list of cats above a certain age threshold.
     * http://localhost:8080/animals/age?age=5.0
     *
     * @param age the minimum age.
     * @return list of Cat objects matching the search key.
     */
    @GetMapping("/age")
    public Object getCatsByAge(@RequestParam(name = "age", defaultValue = "0.0") double age) {
        return new ResponseEntity<>(service.getCatsByAge(age), HttpStatus.OK);
    }

    /**
     * Create a new Cat entry.
     * http://localhost:8080/animals/new --data '{ "name": "Whiskers", "description": "Playful cat", "breed": "Siamese", "age": 3.5, "activeDate": "2022-01-01" }'
     *
     * @param cat the new Cat object.
     * @return the updated list of Cats.
     */
    @PostMapping("/new")
    public Object addNewCat(@RequestBody Cat cat) {
        service.addNewCat(cat);
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.CREATED);
    }

    /**
     * Update an existing Cat object.
     * http://localhost:8080/animals/update/2 --data '{ "catId": 1, "name": "Mittens", "description": "Curious cat", "breed": "Persian", "age": 4.0, "activeDate": "2023-05-12" }'
     *
     * @param catId the unique Cat Id.
     * @param cat   the new update Cat details.
     * @return the updated Cat object.
     */
    @PutMapping("/update/{catId}")
    public Object updateCat(@PathVariable int catId, @RequestBody Cat cat) {
        service.updateCat(catId, cat);
        return new ResponseEntity<>(service.getCatById(catId), HttpStatus.CREATED);
    }

    /**
     * Delete a Cat object.
     * http://localhost:8080/animals/delete/2
     *
     * @param catId the unique Cat Id.
     * @return the updated list of Cats.
     */
    @DeleteMapping("/delete/{catId}")
    public Object deleteCatById(@PathVariable int catId) {
        service.deleteCatById(catId);
        return new ResponseEntity<>(service.getAllCats(), HttpStatus.OK);
    }
}


