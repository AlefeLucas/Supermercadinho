package br.pucminas.supermercado.model;
// Generated 17/08/2017 22:19:53 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Compra generated by hbm2java
 */
public class Compra  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private float valorTotal;
     private Date horario;
     private Set compraTemProdutos = new HashSet(0);
     private Set entregas = new HashSet(0);

    public Compra() {
    }

	
    public Compra(Usuario usuario, float valorTotal, Date horario) {
        this.usuario = usuario;
        this.valorTotal = valorTotal;
        this.horario = horario;
    }
    public Compra(Usuario usuario, float valorTotal, Date horario, Set compraTemProdutos, Set entregas) {
       this.usuario = usuario;
       this.valorTotal = valorTotal;
       this.horario = horario;
       this.compraTemProdutos = compraTemProdutos;
       this.entregas = entregas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public float getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    public Date getHorario() {
        return this.horario;
    }
    
    public void setHorario(Date horario) {
        this.horario = horario;
    }
    public Set getCompraTemProdutos() {
        return this.compraTemProdutos;
    }
    
    public void setCompraTemProdutos(Set compraTemProdutos) {
        this.compraTemProdutos = compraTemProdutos;
    }
    public Set getEntregas() {
        return this.entregas;
    }
    
    public void setEntregas(Set entregas) {
        this.entregas = entregas;
    }




}


