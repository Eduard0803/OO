class DescricaoEmBrancoException extends Exception{
    private DescricaoEmBrancoException(){}
    public DescricaoEmBrancoException(String nome_campo){
        super("Descricao em Branco em '" + nome_campo + "'");
    }
}
