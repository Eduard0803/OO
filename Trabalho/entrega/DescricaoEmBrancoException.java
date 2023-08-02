

class DescricaoEmBrancoException extends Exception{
    // Exceção para quando não inserir dados obrigatórios
    private DescricaoEmBrancoException(){}
    public DescricaoEmBrancoException(String nome_campo){
        super("Descricao em Branco em '" + nome_campo + "'");
    }
}