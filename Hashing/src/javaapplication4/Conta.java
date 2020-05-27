/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author kelwin
 */
public class Conta {

    String Senha,md5,Numero,Agencia,Saldo,NomedoCliente;
    
    public Conta(String agencia, String numero, String senha){
         this.Agencia = agencia;
         this.Numero=numero;
         this.Senha=senha;
         String catt = agencia + numero + senha + SecurityProvider.salt;
         this.md5 = SecurityProvider.md5(catt);
    }
      public Conta(String agencia, String numero, String senha,String saldo,String nomedocliente){
         this.Agencia = agencia;
         this.Numero=numero;
         this.Senha = senha;
         this.Saldo = saldo;
         this.NomedoCliente = nomedocliente;
         String catt = agencia + numero + senha + SecurityProvider.salt;
         this.md5 = SecurityProvider.md5(catt);
    }
        public Conta(String nomedocliente, String saldo){
         this.Saldo = saldo;
         this.NomedoCliente = nomedocliente;
        }
public static class SecurityProvider{
public static String salt = "5a1t";
public static String md5(String stringToConvert)
{
String hashtext="";
stringToConvert +=salt;
MessageDigest m;
try
{
m = MessageDigest.getInstance("MD5");
m.reset();
m.update(stringToConvert.getBytes());
byte[] digest = m.digest();
BigInteger bigInt = new BigInteger(1,digest);
hashtext = bigInt.toString(16);
}
catch (NoSuchAlgorithmException ex)
{
Logger.getLogger(SecurityProvider.class.getName());
log(Level.SEVERE,null,ex);
}

return hashtext;
}
public static String[] md5ToClient(Conta conta)
{
    String cripto = conta.NomedoCliente + " " + conta.Saldo;
    int b = cripto.length();
    char[] toarry;
    toarry = new char[b];
    String[] criptos;
    criptos = new String[b];
    for (int i=0;i<cripto.length();i++){
        toarry[i] = cripto.charAt(i);
    }
    for(int i=0;i<cripto.length();i++){
    criptos[i] = SecurityProvider.md5(String.valueOf(toarry[i]));  
}
    
     return criptos;
    
    
}
public static String md5ToServer(Conta conta){
        String cat = conta.Agencia+conta.Numero+conta.Senha+SecurityProvider.salt;
        return SecurityProvider.md5(cat);
}

        private static void log(Level SEVERE, Object object, NoSuchAlgorithmException ex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    public String toString(){
     return (Agencia + "\n" + Numero +"\n" + Senha +"\n" + NomedoCliente +"\n"+ Saldo + "\n" +  md5 +"\n");
    }
public static void test2(){
Conta c = new Conta("1234", "2222","1245");
System.out.println(SecurityProvider.md5ToServer(c));
}
 public static void test()
{
Conta c1 = new Conta("124", "333", "1234","10", "john doe");
System.out.println(c1);
Conta c2 = new Conta("John Doe", "10");
System.out.println(c2);
Conta c3 = new Conta("123", "321","666");
System.out.println(c3);
} 
 public static void test4()
{
Conta c = new Conta("124", "333", "1234","10", "john doe");
ServerDatabase.insereConta(c);
String chave = SecurityProvider.md5ToServer(c);
Conta conta = ServerDatabase.getConta(chave);
String chars[];
chars = SecurityProvider.md5ToClient(conta);
for(int i=0;i<chars.length;i++)
{
System.out.println(chars[i]);
}
}

 public static void test1(){
System.out.println(SecurityProvider.md5("teste"));
}
 public static void main(String[] args) {
test4();
}
}
