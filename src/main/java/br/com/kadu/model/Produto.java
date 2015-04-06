package br.com.kadu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private List<Fornecedor> fornecedores;

    public Produto() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(String nome, String descricao, BigDecimal valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void addFornecedor(Fornecedor fornecedor) {
        getFornecedores().add(fornecedor);
    }

    public void addFornecedores(List<Fornecedor> fornecedores) {
        getFornecedores().addAll(fornecedores);
    }

    public List<Fornecedor> getFornecedores() {
        if (fornecedores == null){
            fornecedores = new ArrayList<Fornecedor>();
        }

        return fornecedores;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
