package br.edu.infnet.deniseAPI.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cotacao {
    private String code;
    private String name;
    private String high;
}
