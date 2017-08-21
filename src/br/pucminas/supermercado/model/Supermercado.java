package br.pucminas.supermercado.model;
// Generated 17/08/2017 22:19:53 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Supermercado generated by hbm2java
 */
public class Supermercado  implements java.io.Serializable {


     private int id;
     private Endereco endereco;
     private String cnpj;
     private String nome;
     private String descricao;
     private byte[] logo;
     

    public Supermercado() {
    }

	
    public Supermercado(Endereco endereco, String cnpj, String nome, String descricao) {
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Supermercado(Endereco endereco, String cnpj, String nome, String descricao, byte[] logo) {
       this.endereco = endereco;
       this.cnpj = cnpj;
       this.nome = nome;
       this.descricao = descricao;
       this.logo = logo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public byte[] getLogo() {
        return this.logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }



}

