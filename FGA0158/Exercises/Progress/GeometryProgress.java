public class GeometryProgress extends Progress{ // define a classe 'GeometryProgress' como uma extensão de 'Progress'

    public GeometryProgress(int a0, int n, int r){ // metodo construtor
        super(a0, n, r); // construtor para a superclasse
    }

    int[] computeP(){ // implementação do metodo abstrato
        int[] a = getP();
        a[0] = getA0();
        for(int i=1; i<getN(); ++i)
            a[i] = a[i-1]*getR();
        return a;
    }
}
