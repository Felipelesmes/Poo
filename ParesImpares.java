
public class ParesImpares {
	
	int LimiteA;
	int LimiteB;
	int Par=0;
	int CantImpar=-1;
	int CantPar=0;
	
	void Par() {
	   	System.out.println("PARES:" );
		for (int i = LimiteA; i <= LimiteB; i++) {
		if (i % 2 == 0)
			System.out.println(" " + i);
		if(i % 2 == 0)
			CantPar++;
		}
		System.out.println("********HAY "+CantPar+" PARES*******\n");
	}
	
	void Impar() {
		 System.out.println("IMPARES: ");
		 while (LimiteA <= LimiteB) {	
		    	if (LimiteA % 2 != 0)  
		    		System.out.println(" " + LimiteA);
		    	    LimiteA++;
		    	if (LimiteA % 2 != 0)
		    	CantImpar++;
	}
		 System.out.println("*****HAY "+CantImpar+" IMPARES****\n");
	}
	
	void setLimiteA(int a) {
		this.LimiteA=a;
	}
	void setLimiteB(int b) {
		this.LimiteB=b;
	}

	public static void main(String[] args) {
		ParesImpares Prueba = new ParesImpares();
		Prueba.setLimiteA(0);
		Prueba.setLimiteB(1000);
		Prueba.Par();
		Prueba.Impar();
	
		
		
	}
	
	
}
