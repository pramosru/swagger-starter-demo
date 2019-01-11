package com.evo.msa.demoswagger.model;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String username;
    private String email;
    private String phone;

}