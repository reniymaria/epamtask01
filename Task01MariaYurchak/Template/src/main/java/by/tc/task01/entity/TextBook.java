package by.tc.task01.entity;

import java.util.Objects;

public class TextBook extends Appliance{

    private String title;
    private String subject;
    private String author;
    private int numberOfPage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBook textBook = (TextBook) o;
        return numberOfPage == textBook.numberOfPage &&
                Objects.equals(title, textBook.title) &&
                Objects.equals(subject, textBook.subject) &&
                Objects.equals(author, textBook.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, subject, author, numberOfPage);
    }

    @Override
    public String toString() {
        return "TextBook: " +
                "title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPage=" + numberOfPage;
    }
}
