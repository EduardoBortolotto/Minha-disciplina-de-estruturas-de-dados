#include <stdio.h>
#include <time.h>
#include "lista_ligada.h"

int main() {
    srand(time(NULL));

    //lista1 e lista2 com mais de 20 elementos
    Lista *lista1 = NULL;
    Lista *lista2 = NULL;
    for (int i=0; i<25; i++) {
        lista1 = inserir(rand() % 100 + 1, lista1);
        lista2 = inserir(rand() % 100 + 1, lista2);
    }

    printf("Lista 1:\n");
    exibir(lista1);
    printf("Lista 2:\n");
    exibir(lista2);

    printf("\n1 - Números comuns:\n");
    mostrarComuns(lista1, lista2);

    printf("\n2 - Lista 1 após remover pares:\n");
    lista1 = removerPares(lista1);
    exibir(lista1);

    printf("\n3 - União das listas\n");
    Lista *unida = unirListas(lista1, lista2);
    exibir(unida);

    printf("\n4 - Lista unida ordenada:\n");
    ordenarLista(unida);
    exibir(unida);

    printf("\n 5 - Deletando lista unida:\n");
    deletarLista(unida);
    printf("Lista deletada.\n");

    return 0;
}
