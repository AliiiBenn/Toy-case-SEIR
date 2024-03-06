


public class Individu {



    private Status currentStatus = Status.SUSCEPTIBLE;
    private int currentStatusDays = 0;

    private int daysExposed;
    private int daysInfected;
    private int daysRecovered;


    public Individu() {
        

    }


    public Status getCurrentStatus() {
        return currentStatus;
    }

    public int getCurrentStatusDays() {
        return currentStatusDays;
    }

    public int getDaysExposed() {
        return daysExposed;
    }

    public int getDaysInfected() {
        return daysInfected;
    }

    public int getDaysRecovered() {
        return daysRecovered;
    }


    public static Individu createIndividu(Status status, int currentStatusDays, int daysExposed, int daysInfected, int daysRecovered) {
        Individu individu = new Individu();
        individu.currentStatus = status;
        individu.currentStatusDays = currentStatusDays;
        individu.daysExposed = daysExposed;
        individu.daysInfected = daysInfected;
        individu.daysRecovered = daysRecovered;
        return individu;
    }


    
}