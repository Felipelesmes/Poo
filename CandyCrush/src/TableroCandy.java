public class TableroCandy extends Candy {   
    private int matrix[][] = new int[9][9];
    
    public void llenarTab(){
       Candy dulce = new Candy();
       int dado; 
        for(int i=0;i<9;i++){ 
           for(int j=0;j<9;j++){
               dado=(int) Math.floor(Math.random()*5+1);
               switch (dado) {
                   case 1:
                       matrix[i][j]=dulce.getDulce1();
                       break;
                   case 2:
                       matrix[i][j]=dulce.getDulce2();
                       break;
                   case 3:
                       matrix[i][j]=dulce.getDulce3();
                       break;
                   case 4:
                       matrix[i][j]=dulce.getDulce4();
                       break;
                   default:
                       matrix[i][j]=dulce.getDulce5();
                       break;
               }
           }
       }
    }
    public void showTab(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
              System.out.print(matrix[i][j]+" ");
            System.out.println("");
        }   
        System.out.println("");
    }
    
    public void movePosition(int x1,int y1, int x2, int y2){
        int aux=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=aux;
    }
}
