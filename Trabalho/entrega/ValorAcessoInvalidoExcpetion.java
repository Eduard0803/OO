

class ValorAcessoInvalidoException extends Exception{
    // Exceção quando inserir dados invalidos
    private ValorAcessoInvalidoException(){}
    public ValorAcessoInvalidoException(String nome_campo){
        super("Valor de Acesso Invalido em '" + nome_campo + "'");
    }
}
