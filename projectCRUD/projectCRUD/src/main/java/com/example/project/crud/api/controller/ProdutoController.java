package com.example.project.crud.api.controller;

import com.example.project.crud.api.DTO.ProdutoDTO;
import com.example.project.crud.api.db.entity.Produto;
import com.example.project.crud.api.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @Operation(summary = "Endpoint para criar um produto através de um DTO")
    @RequestMapping(path = "/criar-produto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> criarProduto(
            @RequestBody ProdutoDTO produtoDTO
    ) {
        return ResponseEntity.ok(produtoService.criarProduto(produtoDTO));
    }


    @Operation(summary = "Endpoint para listar todos os produtos presentes")
    @RequestMapping(path = "/lista-produtos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> listaProdutos() {
        return ResponseEntity.ok(produtoService.getProdutos());
    }


    @Operation(summary = "Endpoint para listar um produto específico")
    @RequestMapping(path = "/lista-produto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> getProdutoId(
            @PathVariable(name = "id") Long id
    ) {
        Optional<Produto> produtoId = produtoService.getProdutoId(id);
        if (produtoId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Endpoint para atualizar um produto específico")
    @RequestMapping(path = "/atualiza-produto/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaProduto(
            @PathVariable (name = "id") Long id,
            @RequestBody Produto produto
    ) {
        produtoService.atualizaProduto(id, produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Endpoint para deletar um produto específico")
    @RequestMapping(path = "/deleta-produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> produtoIdDeletado(
            @PathVariable(name = "id") Long id
    ) {
        produtoService.produtoIdDeletado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}