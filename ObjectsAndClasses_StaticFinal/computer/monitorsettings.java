public class monitorsettings {
    private final MONITOR.MONITORDIAGON monitordiagon;
    private final MONITOR.MONITORTYPE monitortype;
    private final double monitorweight;

    public monitorsettings(MONITOR.MONITORDIAGON monitordiagon, MONITOR.MONITORTYPE monitortype,
                           double monitorweight) {
        this.monitordiagon = monitordiagon;
        this.monitortype = monitortype;
        this.monitorweight = monitorweight;
    }

    public MONITOR.MONITORDIAGON getMonitordiagon() {
        return monitordiagon;
    }

    public MONITOR.MONITORTYPE getMonitortype() {
        return monitortype;
    }

    public double getMonitorweight() {
        return monitorweight;
    }

    public String toStringMonitor(){
        return("Диагональ монитора - " + monitordiagon + "\n" +
                "Тип монитора - " + monitortype + "\n" +
                "Вес монитора - " + monitorweight);
    }
}
