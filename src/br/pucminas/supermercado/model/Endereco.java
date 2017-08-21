package br.pucminas.supermercado.model;
// Generated 17/08/2017 22:19:53 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Endereco generated by hbm2java
 */
public class Endereco  implements java.io.Serializable {


     private int id;
     private String logradouro;
     private short numero;
     private String complemento;
     private String bairro;
     private String cidade;
     private String estado;
     private String cep;


    public Endereco() {
    }

	
    public Endereco(String logradouro, short numero, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public Endereco(String logradouro, short numero, String complemento, String bairro, String cidade, String estado, String cep) {
       this.logradouro = logradouro;
       this.numero = numero;
       this.complemento = complemento;
       this.bairro = bairro;
       this.cidade = cidade;
       this.estado = estado;
       this.cep = cep;

    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getLogradouro() {
        return this.logradouro;
    }
    
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public short getNumero() {
        return this.numero;
    }
    
    public void setNumero(short numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }





}


