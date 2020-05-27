/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.ArrayList;
/**
 *
 * @author kelwin
 */
public class Database {
public static final ArrayList<Letra> caracteres;
static
{
caracteres = new ArrayList<Letra>();
caracteres.add(new Letra("a"));
caracteres.add(new Letra("b"));
caracteres.add(new Letra("c"));
caracteres.add(new Letra("d"));
caracteres.add(new Letra("e"));
caracteres.add(new Letra("f"));
caracteres.add(new Letra("g"));
caracteres.add(new Letra("h"));
caracteres.add(new Letra("i"));
caracteres.add(new Letra("j"));
caracteres.add(new Letra("k"));
caracteres.add(new Letra("l"));
caracteres.add(new Letra("m"));
caracteres.add(new Letra("n"));
caracteres.add(new Letra("o"));
caracteres.add(new Letra("p"));
caracteres.add(new Letra("q"));
caracteres.add(new Letra("r"));
caracteres.add(new Letra("s"));
caracteres.add(new Letra("t"));
caracteres.add(new Letra("u"));
caracteres.add(new Letra("v"));
caracteres.add(new Letra("w"));
caracteres.add(new Letra("x"));
caracteres.add(new Letra("y"));
caracteres.add(new Letra("z"));
caracteres.add(new Letra(" "));
caracteres.add(new Letra("0"));
caracteres.add(new Letra("1"));
caracteres.add(new Letra("2"));
caracteres.add(new Letra("3"));
caracteres.add(new Letra("4"));
caracteres.add(new Letra("5"));
caracteres.add(new Letra("6"));
caracteres.add(new Letra("7"));
caracteres.add(new Letra("8"));
caracteres.add(new Letra("9"));


}
public static Letra getLetra(String md5){
    int v=0;
    for (int i=0;i<36;i++){
        if (caracteres.get(i).md5Code.equals(md5)){
            v=i;
            break;
        }
    }
    return caracteres.get(v);
}
public static Conta getConta(String[] md5s){
    String nome = "";
    String saldo = "";
    int cont=0;
    for(int i=0;i<md5s.length;i++){
         if(" ".equals(getLetra(md5s[i]).getCaractere())){
        cont=1+cont;
        }
         if(cont == 1 || cont ==0){
            nome = nome+getLetra(md5s[i]).getCaractere();
        }
         if (cont == 2){
            saldo = saldo+getLetra(md5s[i]).getCaractere();
        }
    }
    Conta d = new Conta(nome,saldo);
    return d;
}
public static void test6()
{
Letra l = new Letra("a");
String md5 = l.getMd5Code();
System.out.println(md5);
Letra ll = Database.getLetra(md5);
System.out.println(ll.getCaractere());
}
public static void test5()
{
Conta c = new Conta("124", "333", "1234","10", "john doe");
ServerDatabase.insereConta(c);
String chave = Conta.SecurityProvider.md5ToServer(c);
Conta conta = ServerDatabase.getConta(chave);
String chars[];
chars = Conta.SecurityProvider.md5ToClient(conta);
System.out.println(Database.getConta(chars));
}
public static void main (String[] args) {
    test5();
}
}