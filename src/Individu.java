


public class Individu {



    private Status currentStatus;

    private int daysExposed;
    private int daysInfected;
    private int daysRecovered;


    public Individu(Status initialStatus) {
        this.currentStatus = initialStatus;

    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }
    
}