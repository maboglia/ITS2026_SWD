public class Book {
    String title;
    String author;
    int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString(){
        return "Title: " + title + ", Author: " + author + ", Year of Publication: " + yearOfPublication;
    }
}
