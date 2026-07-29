package esercizio_enumerazioni;

public enum Status {

    ONLINE,
    BUSY,
    HIDDEN,
    OFFLINE;

    public boolean isVisible() {
        return this == ONLINE || this == BUSY;
    }

    public boolean canContact(Status x) {
        return this != OFFLINE && x.isVisible();
    }
}
