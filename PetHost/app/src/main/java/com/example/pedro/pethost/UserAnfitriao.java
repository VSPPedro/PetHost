package com.example.pedro.pethost;

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
        this.id = 1;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public UserAnfitriao(){};

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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

    // Firebase ou object para passar como paramentro!?
    public void insert()
    {
        //adicionar mais um child ali após o contaAnfitriao para buscar o getId.
        Firebase firebase = FirebaseSingleton.getInstance().child("ContaAnfitriao").child(String.valueOf("User"+getId()));
        firebase.setValue(this);
    }

//    private boolean isDadosValidos(Firebase.CompletionListener dados)
//    {
//        if () {
//
//        }
//    }
}
