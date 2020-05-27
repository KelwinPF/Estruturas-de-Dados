/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.util.ArrayList;
import java.math.BigInteger;
/**
 *
 * @author kelwin
 */
public class ServerDatabase {
public static final ArrayList<ArrayList<Conta>> contas;
public static final int N = 100;
static int a;
static{
contas = new ArrayList<ArrayList<Conta>>();
for(int i=0;i<N;i++){
contas.add(new ArrayList<Conta>());
}
}
public static int hashCode(String md5){
BigInteger bi = new BigInteger(md5, 16);
BigInteger m = new BigInteger(Integer.toString(N), 10);
int pos;
pos = bi.mod(m).intValue();
return pos;
}
public static void insereConta(Conta conta){
  a = hashCode(conta.md5);
  ArrayList<Conta> teste = new ArrayList<Conta>() ;
  teste.add(conta);
  contas.add(a,new ArrayList<Conta>(teste)); 
}
public static Conta getConta(String md5)
{
    hashCode(md5);
    return contas.get(a).get(0);
      
}
public static void test3()
{
Conta c = new Conta("1234", "2222","1245");
ServerDatabase.insereConta(c);
String chave = Conta.SecurityProvider.md5ToServer(c);
System.out.println(chave);
Conta conta = ServerDatabase.getConta(chave);
System.out.println(conta);
}
public static void main (String[] args) {
    test3();
}
}

