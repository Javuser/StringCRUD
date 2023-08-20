package org.example;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private Integer id;
    private String name = null;
    private Integer age = 0;
}
