package MyFirstProject1.RESTAPIPractices;

public class Info {
    private String appName;
    private String version;
    private String author;

    public Info(String appName, String version, String author) {
        this.appName = appName;
        this.version = version;
        this.author = author;
    }


    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

}
