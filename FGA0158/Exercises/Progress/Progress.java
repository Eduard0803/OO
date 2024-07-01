public abstract class Progress{
    // define os atributos da super classe
    private int a0, n, r, soma;
    private int[] p;
    private String out;

    private Progress(){} // metodo construtor padrão
    public Progress(int a0, int n, int r){ // metodo construtor alternativo
        this.a0 = a0;
        this.n = n;
        this.r = r;
        this.soma = 0;
        p = new int[n];
    }

    abstract int[] computeP(); // metodo abstrato para calcular a progressão

    private String computeOut(){ // gera uma String com os Itens da progressão
        computeP();
        String str = "[";
        for(int i=0; i<n-1; ++i)
            str += p[i] + ", ";
        str += p[n-1] + "]";
        this.out = str;
        return str;
    }
    public void printProgress(){ // escreve os Itens da progressão na saida padrão
        computeOut();
        System.out.println(out);
    }
    public int somaElementos(){ // calcula a soma dos Itens da progressão
        computeP();
        for(int i=0; i<n; ++i)
            this.soma += p[i];
        return soma;
    }

    // metodos 'get'
    public int getA0(){return a0;}
    public int getN(){return n;}
    public int getR(){return r;}
    public int[] getP(){return p;}
    public String getOut(){return out;}
}
