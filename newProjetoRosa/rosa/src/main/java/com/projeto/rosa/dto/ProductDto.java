package com.projeto.rosa.dto;

import com.projeto.rosa.StatusEnum;

import lombok.*;
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private StatusEnum status;
    private String destination;
    private Integer profitRate;
    private Integer term;
    private Double administrationRate;
}
