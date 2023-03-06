package dev.wolffe.property_management_example.domain.application;


public enum ApplicationStatus {
    ACCEPTED("accepted"), DENIED("denied"), PENDING("pending");
    private final String applicationStatus;

    ApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }
}
