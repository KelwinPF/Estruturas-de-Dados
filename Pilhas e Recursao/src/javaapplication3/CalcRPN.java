import java.io.*;
public class CalcRPN {
Pilha<Double> aPilha;
Pilha<Operacao> hist;

CalcRPN () {
hist = new Pilha<Operacao>();
aPilha = new Pilha<Double>();
}

void mais() {
double aux,aux2;
aux=aPilha.desempilha();
aux2=aPilha.topo();
aPilha.empilha(aux+aPilha.desempilha());
hist.empilha(new Operacao('+',aux,aux2));
}

void menos() {
double aux,aux2;
aux=aPilha.desempilha();
aux2=aPilha.topo();
aPilha.empilha(aPilha.desempilha()-aux);
hist.empilha(new Operacao('-',aux,aux2));
}

void vezes() {
  double aux,aux2;
aux=aPilha.desempilha();
aux2=aPilha.topo();
aPilha.empilha(aux*aPilha.desempilha());
hist.empilha(new Operacao('*',aux,aux2));
}

void dividido() {
  double aux,aux2;
aux=aPilha.desempilha();
aux2=aPilha.topo();
aPilha.empilha(aPilha.desempilha()/aux);
hist.empilha(new Operacao('/',aux,aux2));
}

Double resultado() {
return aPilha.topo();
}

void clear(){
   aPilha.conteudo.clear();
   hist.conteudo.clear();
}

void cancela(){
 if(hist.topo().code == 'e'){
      aPilha.conteudo.removeFirst();
      hist.conteudo.removeFirst();
  }
 else{
    aPilha.conteudo.removeFirst();
    aPilha.empilha(hist.topo().b);
    aPilha.empilha(hist.topo().a);
    hist.conteudo.removeFirst();
 }
}

void exec(String cmd) {
   double aux;
   Operacao aux2;
if(cmd.equalsIgnoreCase("+")){
    mais();
}
else if(cmd.equalsIgnoreCase("undo")){
    cancela();
    System.out.println("historico = " + hist.toStringInverse());
}
else if(cmd.equalsIgnoreCase("hist")){
    System.out.println("historico = " + hist.toStringInverse());
}
else if(cmd.equalsIgnoreCase("clear")){
   clear();
}
else if(cmd.equalsIgnoreCase("-")){
    menos();
}
else if(cmd.equalsIgnoreCase("*")){
    vezes();
}
else if(cmd.equalsIgnoreCase("/")){
    dividido();
}
else{
       aux2 = new Operacao(Double.parseDouble(cmd));
       aux = Double.parseDouble(cmd);
       aPilha.empilha(aux);
       hist.empilha(aux2);
}
}

static void test() {
CalcRPN calc = new CalcRPN() ;
System.out.print("3 2 + = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.mais();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 - = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.menos();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 * = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.vezes();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("3 2 / = ");
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(2.0);
calc.dividido();
System.out.println(calc.resultado());
calc = new CalcRPN();
System.out.print("1 2 + 3 4 - / 10 3 - * = ");
calc.aPilha.empilha(1.0);
calc.aPilha.empilha(2.0);
calc.mais();
calc.aPilha.empilha(3.0);
calc.aPilha.empilha(4.0);
calc.menos();
calc.dividido();
calc.aPilha.empilha(10.0);
calc.aPilha.empilha(3.0);
calc.menos();
calc.vezes();
System.out.println(calc.resultado());
}
static void interfaceUsuario() throws IOException {
CalcRPN calc = new CalcRPN() ;
String line;
BufferedReader reader = new BufferedReader
(new InputStreamReader (System.in));
while((line = reader.readLine()) != null) {
if (line.isEmpty())
continue;
for (String s : line.split(" "))
calc.exec(s);
System.out.println("Pilha = " + calc.aPilha);
}
System.out.println("Ate logo");
}
public static void main(String[] args)throws IOException{
interfaceUsuario();
}
}
