package com.guhex.modelo;

import javax.persistence.*;

@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String message;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario usuario;

    public Articulo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
