import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Horloge implements Observable {
    private final List<Observateur> observateurs = new ArrayList<>();

    @Override
    public void addObservateur(Observateur obs) {
        observateurs.add(obs);
    }

    @Override
    public void notifyObservateurs(String hour) {
        for (Observateur obs : observateurs) {
            obs.update(hour);
        }
    }

    public void start() {
        while (true) {
            String hour = getCurrentTime();
            notifyObservateurs(hour);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        return String.format("%02d : %02d : %02d",
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
    }
}
