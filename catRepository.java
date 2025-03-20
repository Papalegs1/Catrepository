package com.csc340.sp25_crud_api_demo.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions for Cat entities.
 */
@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    // Find cats by breed
    List<Cat> getCatsByBreed(String breed);

    // Custom query to find cats above a certain age
    @Query(value = "select * from cats c where c.age >= ?1", nativeQuery = true)
    List<Cat> getCatsByAge(double age);

    // Custom query to find cats by name (case-insensitive search)
    @Query(value = "select * from cats c where c.name like %?1%", nativeQuery = true)
    List<Cat> getCatsByName(String name);

    // Custom query to find cats by description (case-insensitive search)
    @Query(value = "select * from cats c where c.description like %?1%", nativeQuery = true)
    List<Cat> getCatsByDescription(String description);
}
