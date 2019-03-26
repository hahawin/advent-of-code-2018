package day4;

public enum GuardEventType {
    START_SHIFT("starts shift"),
    FALL_ASLEEP("falls asleep"),
    WAKE_UP("wakes up");

    private String eventText;

    GuardEventType(String eventText) {
        this.eventText = eventText;
    }

    @Override
    public String toString() {
        return eventText;
    }

    public static GuardEventType parseGuardEvent(String eventText){
        if(eventText.contains("begins shift")) return START_SHIFT;
        if(eventText.contains("falls asleep")) return FALL_ASLEEP;
        if(eventText.contains("wakes up")) return WAKE_UP;
        throw new IllegalArgumentException();
    }


}
