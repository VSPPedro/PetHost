package com.example.pedro.pethost;

import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Classe model do Usuario anfitriao
 * @author Matheus Mayer <matheusmayerduarte@gmail.com>
 */
public class UserAnfitriao
{
    private int id = 1; // VER O MELHOR JEITO DESTE ID
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;

    public UserAnfitriao(String nome, String endereco, String telefone, String email, String senha)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public UserAnfitriao(){};

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
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
        Firebase firebase = FirebaseSingleton.getInstance().child("ContaAnfitriao");
        firebase.push().setValue(this);
    }

//    private boolean isDadosValidos(Firebase.CompletionListener dados)
//    {
//        if () {
//
//        }
//    }
}
