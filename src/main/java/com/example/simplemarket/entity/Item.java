package com.example.simplemarket.entity;

import com.example.simplemarket.controller.ItemRequest;
import com.example.simplemarket.controller.ItemResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public Item(ItemRequest request) {
        this.username = request.getUsername();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.price = request.getPrice();
    }

    public ItemResponse toResponse() {
        return new ItemResponse(this.id, this.username, this.title, this.content, this.price);
    }

    public void update(ItemRequest request) {
        this.username = request.getUsername();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.price = request.getPrice();
    }
}
