package com.example.pedro.pethost;

import com.firebase.client.Firebase;

public class UserDono
{
    private String nome;
    private String email;
    private String senha;

    public UserDono(){}

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    /**
     * Metodo que realiza o insert no firebase
     * @author Matheus Mayer
     */
    public void insert()
    {
        Firebase firebase = FirebaseSingleton.getInstance().child("ContaDono");
        firebase.push().setValue(this);
    }
}
