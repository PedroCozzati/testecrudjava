public enum Controle{
CRIAR(1), VER(2), ALTERAR(3), DELETAR(4), ENCERRAR(5);

private final int valor;
Controle(int valorOpcao){
    valor = valorOpcao;
}
public int getValor() {
    return valor;
}
}