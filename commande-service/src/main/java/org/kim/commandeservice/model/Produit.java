package org.kim.commandeservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Produit {
    private Long idProduit;
    private String name;
}
