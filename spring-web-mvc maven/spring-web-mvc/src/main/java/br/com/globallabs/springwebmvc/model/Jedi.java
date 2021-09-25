package br.com.globallabs.springwebmvc.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name ="jedi")
@Getter
@Setter
public class Jedi {

    @Id
    @Column(name="id_jedi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 10, message = "Name must have between 3 e 10 characters")
    @NotBlank(message = "Name cannot me blank")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Lastname cannot be blank`")
    @Column(name = "last_name")
    private String lastName;

    public Jedi(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi() {
        
    }
}


