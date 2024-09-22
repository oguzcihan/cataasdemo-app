package com.cihan.catassignment.cat.repositories;

import com.cihan.catassignment.cat.model.CatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatImageRepository extends JpaRepository<CatImage, Long> {
}
