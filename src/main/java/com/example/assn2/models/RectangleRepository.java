package com.example.assn2.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RectangleRepository extends JpaRepository<Rectangle, Integer> {
    List<Rectangle> findByName(String name);
}
