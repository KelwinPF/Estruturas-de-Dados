#include "NoCandidato.h"
#include <cstring>
#include <fstream>
#include <iostream>

class ListaCandidatos{
public:
    int cont=0;
    NoCandidato* head;
    NoCandidato* it;
    ListaCandidatos(){
     this->head=NULL;
    }
    void adicioneComoHead(Candidato* c){
    head = new NoCandidato(c,head);
    cont = cont+1;
        }
    bool estaVazia(){
    return head==NULL;
    }
    int tamanho(){
    return cont;
    }
    string toString(){
        if (cont==0)
         return "0";
        else
        return head->toString();
    }
    ListaCandidatos(string nomeDoArquivo){
    this->head=NULL;
    ifstream fcin(nomeDoArquivo.c_str());
    string dados;
    getline(fcin,dados);
    cout << "criacao da lista de candidatos de: " << dados << endl;
    while(getline(fcin,dados)){
    Candidato *c = new Candidato(dados);
    adicioneComoHead(c);
  }
    }
    bool remover(string nome, string sobrenome){
    this -> it = head;
    int contx=0,cont2=0,flag=0;
    bool a;
    while (flag!=1){
            if(it==NULL){
                    return false;
            }
    else{
    a = it->conteudo->igual(nome,sobrenome);
    if (a==true){
            it=it->next;
            while(cont2<contx){
                it = new NoCandidato(head->conteudo,it);
                head=head->next;
                cont2=cont2+1;
            }
            flag=1;
    }
    else{
        if(it->next!=NULL){
        contx=contx+1;
         it=it->next;
    }
    else if(it->next==NULL){
       return false;
    }
        }
            }
                }
    if (flag == 1 ){
            this->head=it;
            cont=cont-1;
        return true;
    }
    else{return false;}
    }

void filtrarCandidatos(int nota){
int cont2=0;
this -> it = NULL;
while(head!=NULL){
    if(nota<=(head->conteudo->nota)){
        it = new NoCandidato(head->conteudo,it);
        head=head->next;
        cont2=cont2+1;
        if(head==NULL){
         this->head=it;
         cont=cont2;
            break;
        }
    }
    else{
        if(head->next!=NULL){
         head=head->next;
    }
       else if(head->next==NULL){
         this->head=it;
         cont=cont2;
            break;
    }
    }
}
}
void concatena(ListaCandidatos* l){
this->it = l->head;
cont= cont+l->cont;
while(head!=NULL){
        it = new NoCandidato(head->conteudo,it);
        head=head->next;
}
this-> head = it;
}
};

