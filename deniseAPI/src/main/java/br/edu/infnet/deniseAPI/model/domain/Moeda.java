package br.edu.infnet.deniseAPI.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class Moeda {
    @JsonProperty("value")
    private Collection<Value> value;
}
