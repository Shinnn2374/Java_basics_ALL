public class Arithmetic {
    private int i ;
    private int j ;
    public Arithmetic(int i, int j){
        this.i=i;
        this.j=j;
    }
    public int sum(){
        return i+j;
    }
    public int multiplication(){
        return i*j;
    }
    public String maxMin(){
        if(i>j){
            return "Number" + i + ">" + "Number" + j;
        }else if (i<j){
            return "Number" + i + "<" + "Number" + j;
        }else{
            return " Numbers =";
        }
    }
}
//