class ValorAcessoInvalidoException extends Exception{
    private ValorAcessoInvalidoException(){}
    public ValorAcessoInvalidoException(String nome_campo){
        super("Valor de Acesso Invalido em '" + nome_campo + "'");
    }
}
