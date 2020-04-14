/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemafila;

/**
 *
 * @author natan
 */
public class Cliente {
    private String nome;
    private int status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", status=" + status + '}';
    }
    
    
}
