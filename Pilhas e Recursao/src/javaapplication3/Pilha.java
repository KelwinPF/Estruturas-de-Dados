import java.util.LinkedList;
import java.util.AbstractCollection;

class  Pilha<T> {
LinkedList<T> conteudo;
    public Pilha(){
        conteudo = new LinkedList<T>();
    }
    boolean estaVazia(){
    return conteudo.isEmpty();
    }
    void empilha(T c){
      conteudo.addFirst(c);
    }
    T desempilha(){
        if(conteudo.isEmpty()==true){
            throw new Error("erro");
        }
        else{
        T aux;
        aux=conteudo.getFirst();
        conteudo.removeFirst();
       return aux;
        }
    }
    T topo(){
         if(conteudo.isEmpty()==true){
            throw new Error("erro");
        }
         else{
        return conteudo.getFirst();
         }
    }
    public String toString(){
       return conteudo.toString();
    }
    public String toStringInverse(){
     LinkedList<T> aux = new LinkedList<T>(conteudo);
     LinkedList<T> aux2 = new LinkedList<T>();
  
     while(aux.isEmpty()==false){
         T c;
         c = aux.getFirst();
         aux2.addFirst(c);
         aux.removeFirst();
     }
     return aux2.toString();
    }
    static void test1() {
Pilha <Double> aPilha = new Pilha <Double>();
aPilha.empilha(1.1);
aPilha.empilha(2.1);
aPilha.empilha(3.1);
aPilha.empilha(4.1);
aPilha.empilha(5.1);
double valor = 0.0;
valor = aPilha.topo();
System.out.println("topo pilha = " + valor);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor);
valor = aPilha.topo();
System.out.println("topo pilha = " + valor);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor);
}
static void test2() {
Pilha<Double> aPilha = new Pilha<Double>();
System.out.println(aPilha);
aPilha.empilha(1.1);
System.out.println(aPilha);
aPilha.empilha(2.1);
System.out.println(aPilha);
aPilha.empilha(3.1);
System.out.println(aPilha);
double valor = 0.0;
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor );
System.out.println(aPilha);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor );
System.out.println(aPilha);
valor = aPilha.desempilha();
System.out.println("topo pilha = " + valor );
System.out.println(aPilha);
}
public static void main(String[] args) {
test2();
}
}