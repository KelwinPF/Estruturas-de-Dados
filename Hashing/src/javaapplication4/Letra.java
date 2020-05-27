/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author kelwin
 */
public class Letra {
    String Caractere;
    String md5Code;
    public Letra(String caractere){
        this.Caractere = caractere;
        this.md5Code = Conta.SecurityProvider.md5(caractere);
    }
    String getCaractere(){
        return Caractere;
    }
    String getMd5Code(){
        return md5Code;
    }
}
