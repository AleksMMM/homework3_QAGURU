public enum Constant {

    BASE_URL("https://demoqa.com/automation-practice-form");

    private String url;

    Constant(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
