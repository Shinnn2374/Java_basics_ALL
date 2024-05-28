public class Computer {
    private processorsettings processor;
    private ramsettings ram;
    private storagesettings storage;
    private monitorsettings monitor;
    private keyboardsettings keyboard;

    public Computer(processorsettings processor, ramsettings ram, storagesettings storage,
                    monitorsettings monitor, keyboardsettings keyboard) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public processorsettings getProcessor() {
        return processor;
    }

    public ramsettings getRam() {
        return ram;
    }

    public storagesettings getStorage() {
        return storage;
    }

    public monitorsettings getMonitor() {
        return monitor;
    }

    public keyboardsettings getKeyboard() {
        return keyboard;
    }

    public void setProcessor(processorsettings processor) {
        this.processor = processor;
        Computer computer = new Computer(processor, ram, storage, monitor, keyboard);
    }
    public void setRam(ramsettings ram){
        this.ram = ram;
        Computer computer = new Computer(processor,ram,storage,monitor,keyboard);
    }
    public void setStorage(storagesettings storage){
        this.storage = storage;
        Computer computer = new Computer(processor,ram,storage,monitor,keyboard);
    }
    public void setMonitor(monitorsettings monitor){
        this.monitor = monitor;
        Computer computer = new Computer(processor,ram,storage,monitor,keyboard);
    }
    public void setKeyboard(keyboardsettings keyboard){
        this.keyboard = keyboard;
        Computer computer = new Computer(processor,ram,storage,monitor,keyboard);
    }

    public  String  toString(){
        System.out.println("ИНФОРМАЦИЯ О КОМПЬЮТЕРЕ"+ "\n" + processor.toStringProcessor() + "\n" +
                ram.toStringRam() + "\n" +
                storage.toStringStorage() + "\n" +
                monitor.toStringMonitor() + "\n" +
                keyboard.toStringKeyboard());
        return("");
    }
    public double computerWeight(){
         double computerWeight = processor.getProcessorweight() + ram.getRamweight() +
                 storage.getStorageweight() + monitor.getMonitorweight() +
                 keyboard.getKeyboardweight();
        System.out.println(computerWeight);
        return (computerWeight);
    }
}
