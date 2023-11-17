package com.mungge.orumi.domain.Image.dao;

import com.mungge.orumi.domain.Image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    public Optional<Image> findById(Long Id);
}
