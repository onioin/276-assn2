package com.example.assn2.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    private String createdAt;
    private String updatedAt;
    private LocalDateTime createdAtRaw;
    private LocalDateTime updatedAtRaw;

    public Rectangle() {
        this.createdAtRaw = LocalDateTime.now();
        this.updatedAtRaw = createdAtRaw;
        this.createdAt = createdAtRaw.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updatedAt = updatedAtRaw.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public Rectangle(String name, String colour, int width, int height) {
        this.name = name;
        this.colour = colour;
        this.width = width;
        this.height = height;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
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
        if(!Objects.equals(name, this.name)){
            this.setUpdatedAt(LocalDateTime.now());
        }
        this.name = name;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        if(!Objects.equals(colour, this.colour)){
            this.setUpdatedAt(LocalDateTime.now());
        }
        this.colour = colour;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        if(width != this.width){
            this.setUpdatedAt(LocalDateTime.now());
        }
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        if(height != this.height){
            this.setUpdatedAt(LocalDateTime.now());
        }
        this.height = height;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAtRaw = createdAt;
        this.createdAt = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAtRaw = updatedAt;
        this.updatedAt = updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
