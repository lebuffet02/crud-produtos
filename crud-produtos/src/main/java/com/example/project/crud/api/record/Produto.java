package com.example.project.crud.api.record;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({
//        "id",
//        "nome_produto",
//        "descricao_produto",
//        "preco_produto"
//})
public record Produto(
        @JsonProperty("nome_produto") String nome,
        @JsonProperty("descricao_produto") String descricao,
        @JsonProperty("preco_produto") double preco){}