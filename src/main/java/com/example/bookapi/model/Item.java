package com.example.bookapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Item {
    private Long id;
    private String title;

    public abstract String getInfo();
}
