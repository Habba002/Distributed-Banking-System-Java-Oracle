package entity;

public class News {

    private String date;
    private String text;
     private String image;

    public News() {
    }

    public News(String date, String image, String text) {
        this.date = date;
        this.image = image;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    

}
