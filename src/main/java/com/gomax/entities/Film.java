package com.gomax.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;



@Entity
@Table(name="Film")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Runtime")
    private String runtime;
    @JsonProperty("Genre")
    private String genre;
    @JsonProperty("Plot")
    private String plot;
    @JsonProperty("Actors")
    private String actors;
    @JsonProperty("Poster")
    private String poster;
}
