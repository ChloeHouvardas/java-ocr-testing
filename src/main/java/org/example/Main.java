package org.example;

public class Main {

    public static void main(String[] args) {
        PDFExtractor bill = new PDFExtractor();
        try {
            bill.importPDF("C:/Users/chloe/Downloads/CISC203 Fall 2024 (1).pdf");
        } catch (Exception e) {
            System.out.println(("Failed " + e.getMessage()));
        }
    }

}