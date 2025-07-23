package com.example.memorydb.user.model;

import com.example.memorydb.entity.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserEntity extends Entity {

    private String name;

    private int score;

}