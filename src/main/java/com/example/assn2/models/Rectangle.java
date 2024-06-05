package com.example.assn2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Rectangles")
public class Rectangle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String colour;
    private int width;
    private int height;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Rectangle() {}

    public Rectangle(String name, String colour, int width, int height) {
        this.name = name;
        this.colour = colour;
        this.width = width;
        this.height = height;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
