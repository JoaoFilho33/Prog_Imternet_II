package com.projeto.rosa.services;

import com.projeto.rosa.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto) {
        produtos.add(produto);
        return produto;
    }

    public List<Produto> listarProdutosPorStatus(String status) {
        return produtos.stream()
                .filter(produto -> produto.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public void removerProduto(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public Produto mudarStatus(Long id, String novoStatus) {
        Produto produto = produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));

        produto.setStatus(novoStatus);
        return produto;
    }
}
