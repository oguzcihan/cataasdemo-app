package com.cihan.catassignment.repositories;

import com.cihan.catassignment.domain.CatImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatImageRepository extends JpaRepository<CatImage, Long> {
}
