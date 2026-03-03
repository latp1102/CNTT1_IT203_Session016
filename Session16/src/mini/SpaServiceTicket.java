package mini;

import java.time.LocalDateTime;

public class SpaServiceTicket {
    private String ticketId;
    private String petId;
    private String serviceType;
    private LocalDateTime checkInTime;

    public SpaServiceTicket(String ticketId, String petId, String serviceType) {
        this.ticketId = ticketId;
        this.petId = petId;
        this.serviceType = serviceType;
        this.checkInTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "ticketId" + ticketId + "petId" + petId + "serviceType" + serviceType + "checkInTime" + checkInTime;
    }

}
