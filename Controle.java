public enum Controle{
CRIAR(1), ENCERRAR(2), VER(3), MODIFICAR(4);

private final int valor;
Controle(int valorOpcao){
    valor = valorOpcao;


}
public int getValor() {
    return valor;

}
}