# OBJETIVO

- Implementação de algoritmos de alocação de memória.

# DESCRIÇÃO

A partir de uma memória com alocação representada por uma lista encadeada, implementar os algoritmos de alocação de memória FIRST-FIT, NEXT-FIT, BEST-FIT e WORST-FIT, considerando que as partições da memória são fixas.

# ENTRADAS

Dois arquivos de entrada um representando a memória com suas partições através de uma lista encadeada e  outro com uma lista de processos, e seus respectivos tamanhos, a serem alocados na memória na ordem de solicitação.

ENTRADA 1: ARQUIVO DE MEMÓRIA
Arquivo de texto onde cada linha representa uma partição da memória, representada por três dados:
P ou H: Processo (partição alocada) ou Hole (partição livre)
Endereço inicial: Endereço inicial da partição
Tamanho: tamanho da partição
O final do arquivo representa o final da lista encadeada e, consequentemente, o final da memória.

Exemplo:
- P 0 10

- P 10 15

- H 25 30

- P 55 15

- H 70 5

- H 75 8

ENTRADA 2: ARQUIVO DE PROCESSOS
Arquivo de texto onde cada linha representa um processo e seu tamanho para alocação

Exemplo:
- 12

- 5

- 10

- 8

- 20

# SAÍDA

Arquivo de entrada de memória atualizado com a alocação dos processos de entrada nas representado por uma lista encadeada no mesmo formato da Entrada.
Para cada algoritmo de alocação, gerar um arquivo de saída.
Caso um ou mais processos não seja alocado por falta de espaço, apresentá-los no final do arquivo com a tag "PROCESSOS NÃO ALOCADOS (TAMANHOS): " e seus tamanhos.

Exemplo:
Arquivo FIRST-FIT
- P 0 10

- P 10 15

- P 25 12

- P 55 15

- P 70 5

- P 75 8

PROCESSOS NÃO ALOCADOS (TAMANHOS): 10, 20

