package com.example.project.crud.api.db.repository;

import com.example.project.crud.api.DTO.ProdutoDTO;
import com.example.project.crud.api.db.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}