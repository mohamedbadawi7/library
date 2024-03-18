package com.system.library.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="book")
public class Book {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull(message = "ID cannot be empty")
    @Min(value = 0)
    private int id;



    @Column(name="isbn")
    @NotNull(message = "ISBN entry cannot be empty")
    @Size(min = 4, max = 4, message = "ISBN must be 4 digits")
    private String ISBN;


    @Column(name="author")
    @NotNull(message = "Author name must be entered")
    @Size(min = 3, message = "Author name must be at least 3 characters")
    //@Pattern(regexp = "^[0-9]$*/", message = "Author name entered is of wrong type")
    private String author;


    @Column(name="title")
    @NotNull(message = "Title name must be entered")
    @Size(min = 3, message = "Title name must be at least 3 characters")
    //@Pattern(regexp = "^[0-9]$*/", message = "Title name entered is of wrong type")
    private String title;

    @Column(name="genre")
    @NotNull(message = "Genre name must be entered")
    @Size(min = 3, message = "Genre name must be at least 3 characters")
    //@Pattern(regexp = "^[0-9]$*/", message = "Genre name entered is of wrong type")
    private String genre;



    public Book() {
    }

    /**
     *
     * @param n_ISBN- ISBN of new book
     * @param n_author - Author of new book
     * @param n_title - Title of new book
     * @param n_genre - Genre of new book
     */
    public Book(String n_ISBN, String n_author, String n_title, String n_genre) {

        ISBN = n_ISBN;
        author = n_author;
        title = n_title;
        genre = n_genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param new_ISBN new ISBN of book
     */
    public void setISBN(String new_ISBN) {
        ISBN = new_ISBN;
    }


    /**
     *
     * @param new_author new Author book
     */
    public void setAuthor(String new_author) {
        author = new_author;
    }


    /**
     *
     * @param new_title new title of book
     */
    public void setTitle(String new_title) {
        title = new_title;
    }


    /**
     *
     * @param new_genre new genre of book
     */
    public void setGenre(String new_genre) {
        genre = new_genre;
    }


    /**
     *
     * @return the ISBN of book
     */
    public String getISBN() {
        return ISBN;
    }


    /**
     *
     * @return the author of book
     */
    public String getAuthor() {
        return author;
    }


    /**
     *
     * @return the title of book
     */
    public String getTitle() {
        return title;
    }


    /**
     *
     * @return the genre of book
     */
    public String getGenre() {
        return genre;
    }


    /**
     *
     * @return the reference code of book
     */
    /*
    public String getRefCode() {
        return refCode;
    }
    */


    /**
     * creates a reference code for book based off the first two letters of the author name and genre
     */

    /*
    public void generateReference() {
        String temp1;
        String temp2;

        String a = String.valueOf(author.charAt(0));
        String b = String.valueOf(author.charAt(1));

        String c = String.valueOf(genre.charAt(0));
        String d = String.valueOf(genre.charAt(1));

        temp1 = a + b;
        temp2 = c + d;

        refCode = temp1 + "-" + temp2;
    }
    */




    /**
     *
     * @param ISBN ISBN to be verified
     * @return true if ISBN is valid or false if ISBN is invalid
     **/
    /*
    public boolean verifyISBN(int ISBN) {


        //first digit

        int temp;
        temp = ISBN;
        while (temp >= 10) {
            temp /= 10;

        }

        int first_digit = temp;


        //second digit
        int temp1;
        temp1 = ISBN;

        while(temp1 >= 100) {
            temp1 /= 10;

        }
        int t = temp1 * 10;
        temp1 = temp1 % 10;

        int second_digit = temp1;

        //third digit
        int temp2;
        temp2 = ISBN;

        while(temp2 >= 1000) {
            temp2 /= 10;
        }
        temp2 = temp2 - t;
        int third_digit = temp2;

        //fourth digit
        int temp3;
        int temp4;
        temp3 = ISBN;
        temp4 = ISBN;

        while(temp3 >= 1000) {
            temp3 /= 10;
        }

        temp3 = temp3 * 10;
        temp4 = temp4 - temp3;

        int control = temp4;


        int result = ((first_digit * 3) + (second_digit * 2) + (third_digit * 1)) % 4;


        if (result == control) {
            return true;
        }
        else {
            return false;
        }

    }
    */


    /**
     * prints book info
     */

    /*
    public void printBookInfo() {
        String output = "";

        output += "Title: " + title + "\n";
        output += "Author: " + author + "\n";
        output += "ISBN: " + ISBN + " - Reference Code: " + refCode + "\n";
        output += "Genre: " + genre + "\n";

        System.out.println(output);

    }
    */
}