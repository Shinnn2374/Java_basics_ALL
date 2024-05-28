public class Cargo {
    private  double mass;
    private  String adres;
    private  String regNumber;
    private  boolean friangle;

    public Cargo(double mass, String adres,String regNumber, boolean friangle) {

        this.mass = mass;
        this.adres = adres;
        this.regNumber = regNumber;
        this.friangle = friangle;
        System.out.println("Масса  - " + mass + "\n" +
                "Адрес - " + adres + "\n" + "Регистрационный номер - " + regNumber + "\n" +
                "Хрупкий объект - " + friangle);
    }

    public double getMass() {
        return mass;
    }

    public String getAdres() {
        return adres;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public boolean isFriangle() {
        return friangle;
    }
}
