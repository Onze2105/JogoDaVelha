# Jogo da Velha em JavaFX

Projeto simples de Jogo da Velha desenvolvido em Java utilizando JavaFX, com interface gráfica e lógica completa do jogo.

## Funcionalidades
- Interface gráfica com JavaFX
- Alternância de turnos entre X e O
- Verificação de vitória
- Verificação de empate
- Popups ao final do jogo (vitória ou empate)
- Opção de reiniciar ou encerrar o jogo
- 
## Funcionamento
Tabuleiro
O estado do jogo é armazenado em uma matriz:

private String[][] tabuleiro = new String[3][3];

Cada posição pode conter "X", "O" ou null.

### Botões

A interface do jogo utiliza uma matriz de botões:

`private Button[][] botoes;`

Eles são inicializados no método start:

`botoes = new Button[3][3];`

Cada botão representa uma posição do tabuleiro.

### Jogadas

O método responsável pelas jogadas é:

`private void jogar(Button btn, int linha, int coluna)`

Ele:

- Verifica se a posição já foi utilizada
- Define o jogador atual
- Atualiza o botão e o tabuleiro
- Verifica vitória ou empate
- Verificação de Vitória
- private boolean verificarVitoria(String j)

Verifica:

- Linhas
- Colunas
- Diagonais
- Verificação de Empate
- private boolean tabuleiroCheio()

Retorna verdadeiro quando não há mais posições vazias.

### Reinício do Jogo
private void reiniciarJogo()

Reseta:

- Tabuleiro
- Botões
- Turno
- Popups

Utiliza Alert para exibir:

- Mensagem de vitória
- Mensagem de empate
- Opção de reiniciar ou sair
- Uso de Imagens

As imagens devem estar dentro de:

`src/imagens/`

Exemplo de carregamento:

`new Image(getClass().getResource("/imagens/icone.png").toExternalForm())`

### Observações
Arrays devem ser inicializados antes do uso
Caminhos de imagem devem começar com /
Evitar caminhos relativos como "./imagens/..."
Tecnologias
Java
JavaFX

# Imagens do Projeto
<img width="300" height="332" alt="image" src="https://github.com/user-attachments/assets/f9ed222a-5802-46de-889e-da4d404f4ded" />
<img width="299" height="330" alt="image" src="https://github.com/user-attachments/assets/048b8718-54c8-447e-9160-019c2141c359" />
<img width="372" height="338" alt="image" src="https://github.com/user-attachments/assets/a826ab25-4f66-4400-bd63-3958416b3644" />
<img width="383" height="337" alt="image" src="https://github.com/user-attachments/assets/006d2538-0352-432e-b349-9a60d7bf0bb0" />
<img width="445" height="341" alt="image" src="https://github.com/user-attachments/assets/a913f7ba-17e7-446c-943f-019b3dd26c24" />

### Autor

Onze //_//

