package com.example.amqpdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUnserialize {
    Long id = 0L;
    String name = "default";
}
