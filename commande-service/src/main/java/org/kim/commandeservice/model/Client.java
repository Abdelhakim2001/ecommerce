package org.kim.commandeservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Client {
    private Long idClient;
    private String name;
    private String email;
}
