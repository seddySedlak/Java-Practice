package OOP.Hospital;

import java.io.*;

public class Hospital {
    static int calculateSalary(Doctor doc, String[] attributes) {
        for (int i = 2; i < attributes.length; i++) {
             switch (attributes[i]) {
                 case "Basic":
                     doc.diagnosis();
                     break;
                 case "Surgery":
                     doc.surgery();
                     break;
                 case "CardiacSurgery":
                     doc.cardiacSurgery();
                     break;
             }
        }
        return doc.salary;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader di = new BufferedReader(new FileReader("files/hospitalDataAdvanced.txt"));
//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File())));
        Doctor best = new Doctor(Integer.MIN_VALUE, "TMO");
        Doctor worst = new Doctor(Integer.MAX_VALUE, "FAKE_DOC");
        String[] attributes;
        String line;
        Doctor doc = null;
        while ((line = di.readLine()) != null) {
            attributes = line.split(";");
            switch (attributes[1]) {
                case "S":
                    doc = new Surgeon(-80000, attributes[0]);
                    break;
                case "D":
                    doc = new Doctor(-40000, attributes[0]);
                    break;
                case "C":
                    doc = new CardiacSurgeon(-120000, attributes[0]);
                    break;
            }
            System.out.println(doc.name + " vydelal: " + calculateSalary(doc, attributes));
            if (doc.salary < worst.salary){
                worst = doc;
            }
            if (doc.salary > best.salary) {
                best = doc;
            }
        }
        System.out.println("\n---REPORT---\n");
        System.out.println("Promote " + best.name + ", he brought us " + best.salary + " $");
        System.out.println("Fire " + worst.name + ", he brought us only " + worst.salary + " $");
        di.close();
    }
}




