package by.it_class.model.entities;
//если есть ID, значит класс entity

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String email;
}
