#include <stdlib.h>

typedef struct no {
    int dado;
    struct no *prox;
} Lista;

//inserir no início (para gerar listas aleatórias)
Lista *inserir(int dado, Lista *lista) {
    Lista *novo = (Lista *) malloc(sizeof(Lista));
    novo->dado = dado;
    novo->prox = lista;
    return novo;
}

//exibir lista
void exibir(Lista *lista) {
    while (lista) {
        printf("%d ", lista -> dado);
        lista = lista -> prox;
    }
    printf("\n");
}

//1 - mostrar elementos comuns
void mostrarComuns(Lista *a, Lista *b) {
    printf("Elementos comuns: ");
    for (Lista *i = a; i != NULL; i = i -> prox) {
        for (Lista *j = b ; j != NULL; j = j -> prox) {
            if (i->dado == j->dado) {
                printf("%d ", i->dado);
                break;
            }
        }
    }
    printf("\n");
}

//2 - removendo pares da lista1
Lista *removerPares(Lista *lista) {
    if (!lista) return NULL;

    if (lista->dado % 2 == 0) {
        Lista *tmp = lista->prox;
        free(lista);
        return removerPares(tmp);
    } else {
        lista->prox = removerPares(lista->prox);
        return lista;
    }
}

//3 - unir duas listas (lista1 vem antes da lista2)
Lista *unirListas(Lista *a, Lista *b) {
    if (!a) return b;

    Lista *inicio = a;
    while (a->prox) {
        a = a->prox;
    }
    a->prox = b;
    return inicio;
}

//4 - ordenar lista (usei Bubble Sort)
void ordenarLista(Lista *lista) {
    if (!lista) return;
    int trocado;
    do {
        trocado = 0;
        Lista *p = lista;
        while (p->prox) {
            if (p->dado > p->prox->dado) {
                int tmp = p->dado;
                p->dado = p->prox->dado;
                p->prox->dado = tmp;
                trocado = 1;
            }
            p = p->prox;
        }
    } while (trocado);
}

//5 - deletar lista unida
void deletarLista(Lista *lista) {
    while (lista) {
        Lista *tmp = lista;
        lista = lista->prox;
        free(tmp);
    }
}
