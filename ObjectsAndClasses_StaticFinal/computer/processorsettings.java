public class processorsettings {
    private final PROCESSOR.PROCESSORHGZ hgz;
    private final PROCESSOR.PROCESSORCORE core;
    private final PROCESSOR.PROCESSORPRODUCER producter;
    private final double processorweight;

    public processorsettings(PROCESSOR.PROCESSORHGZ hgz, PROCESSOR.PROCESSORCORE core,
                             PROCESSOR.PROCESSORPRODUCER producter
            , double processorweight) {
        this.hgz = hgz;
        this.core = core;
        this.producter = producter;
        this.processorweight = processorweight;
    }

    public PROCESSOR.PROCESSORHGZ getHgz() {
        return hgz;
    }

    public PROCESSOR.PROCESSORCORE getCore() {
        return core;
    }

    public PROCESSOR.PROCESSORPRODUCER getProducter() {
        return producter;
    }

    public double getProcessorweight() {
        return processorweight;
    }
    public String toStringProcessor(){
        return ("Герцовка процессора - " + hgz + "\n" +
                "Количество ядер - " + core + "\n" +
                "Производитель - " + producter + "\n" +
                "Вес процессора - " + processorweight);
    }
}
