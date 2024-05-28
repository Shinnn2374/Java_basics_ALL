public class Main {
    public static void main(String[] args){
        processorsettings processor1 = new processorsettings(PROCESSOR.PROCESSORHGZ.HUNGRED,
                PROCESSOR.PROCESSORCORE.EIGHT, PROCESSOR.PROCESSORPRODUCER.AMD,
                200);

        ramsettings ram1 = new ramsettings(RAM.RAMTYPE.DDR4, RAM.RAMVALUE.THRETYTWO,
                200);

        storagesettings storage1 = new storagesettings(STORAGE.STORAGETYPE.SSD, STORAGE.STORAGEVALUE.TB,
                200);

        monitorsettings monitor1 = new monitorsettings(MONITOR.MONITORDIAGON.HUNGRED,
                MONITOR.MONITORTYPE.IPS, 200);

        keyboardsettings keyboard1 = new keyboardsettings(KEYBOARD.KEYBOARDTYPE.MEH,
                KEYBOARD.KEYBOARDGIDRAVLIK.YES, 200);

        Computer computer1 = new Computer(processor1, ram1, storage1, monitor1, keyboard1);
        computer1.toString();
        System.out.println("\n");
        computer1.computerWeight();
    }
}
//