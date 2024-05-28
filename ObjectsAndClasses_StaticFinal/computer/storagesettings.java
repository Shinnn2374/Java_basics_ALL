public class storagesettings {
    private final STORAGE.STORAGETYPE storagetype;
    private final STORAGE.STORAGEVALUE storagevalue;
    private final double storageweight;

    public storagesettings(STORAGE.STORAGETYPE storagetype, STORAGE.STORAGEVALUE storagevalue,
                           double storageweight) {
        this.storagetype = storagetype;
        this.storagevalue = storagevalue;
        this.storageweight = storageweight;
    }

    public STORAGE.STORAGETYPE getStoragetype() {
        return storagetype;
    }

    public STORAGE.STORAGEVALUE getStoragevalue() {
        return storagevalue;
    }

    public double getStorageweight() {
        return storageweight;
    }

    public String toStringStorage(){
        return ("Тип накопителя - " + storagetype + "\n" +
                "Объем накопителя - " + storagevalue + "\n" +
                "Вес накопителя - " + storageweight);
    }
}
