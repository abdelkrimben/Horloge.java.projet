public interface Observable {
    void addObservateur(Observateur obs);
    void notifyObservateurs(String hour);
}
