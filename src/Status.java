public enum Status {
    TO_DO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
