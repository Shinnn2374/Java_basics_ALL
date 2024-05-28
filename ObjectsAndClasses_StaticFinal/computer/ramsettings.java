public class ramsettings {
    private final RAM.RAMTYPE ramtype;
    private final RAM.RAMVALUE ramvalue;
    private final double ramweight;

    public ramsettings(RAM.RAMTYPE ramtype, RAM.RAMVALUE ramvalue, double ramweight) {
        this.ramtype = ramtype;
        this.ramvalue = ramvalue;
        this.ramweight = ramweight;
    }

    public RAM.RAMTYPE getRamtype() {
        return ramtype;
    }

    public RAM.RAMVALUE getRamvalue() {
        return ramvalue;
    }

    public double getRamweight() {
        return ramweight;
    }

    public String toStringRam(){
        return("Тип ОП - " + ramtype + "\n" +
                "Объем ОП - " + ramvalue + "\n" +
                "Вес ОП - " + ramweight);
    }
}
