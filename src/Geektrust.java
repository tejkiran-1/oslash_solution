import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Geektrust {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            float sum = 0;

            float TotalShirtPrice = 0, TotalJacketPrice = 0, TotalCapsPrice = 0, TotalNotebookPrice = 0,
                    TotalPensPrice = 0,
                    TotalMarkersPrice = 0;
            float tax = 0, total = 0;
            while (sc.hasNextLine()) {
                String inputCommand = sc.nextLine();
                String[] inputCommandArray = inputCommand.split(" ");

                int tshirt = 0;
                int jacket = 0;
                int caps = 0;
                int notebook = 0;
                int pens = 0;
                int markers = 0;
                float pShirt = 0, pJacket = 0, pCaps = 0, pNotebooks = 0, pPens = 0, pMarkers = 0;

                if (inputCommandArray.length == 3) {
                    if (inputCommandArray[1].equals("TSHIRT")) {
                        tshirt = Integer.parseInt(inputCommandArray[2]);
                    }
                    if (inputCommandArray[1].equals("JACKET")) {
                        jacket = Integer.parseInt(inputCommandArray[2]);
                    }
                    if (inputCommandArray[1].equals("CAP")) {
                        caps = Integer.parseInt(inputCommandArray[2]);
                    }
                    if (inputCommandArray[1].equals("NOTEBOOK")) {
                        notebook = Integer.parseInt(inputCommandArray[2]);
                    }
                    if (inputCommandArray[1].equals("PENS")) {
                        pens = Integer.parseInt(inputCommandArray[2]);
                    }
                    if (inputCommandArray[1].equals("MARKERS")) {
                        markers = Integer.parseInt(inputCommandArray[2]);
                    }

                    if (tshirt > 0) {
                        if (tshirt <= 2) {
                            System.out.println("ITEM_ADDED");
                            pShirt = tshirt * 1000;
                            TotalShirtPrice += pShirt;
                        } else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }

                    if (jacket > 0) {
                        if (jacket <= 2) {
                            System.out.println("ITEM_ADDED");
                            pJacket = jacket * 2000;
                            TotalJacketPrice += pJacket;
                        }

                        else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }
                    if (caps > 0) {
                        if (caps <= 2) {
                            System.out.println("ITEM_ADDED");
                            pCaps = caps * 500;
                            TotalCapsPrice += pCaps;

                        } else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }
                    if (notebook > 0) {
                        if (notebook <= 3) {
                            System.out.println("ITEM_ADDED");
                            pNotebooks = notebook * 200;
                            TotalNotebookPrice += pNotebooks;

                        } else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }
                    if (pens > 0) {
                        if (pens <= 3) {
                            System.out.println("ITEM_ADDED");
                            pPens = pens * 300;
                            TotalPensPrice += pPens;
                        } else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }
                    if (markers > 0) {
                        if (markers <= 3) {
                            System.out.println("ITEM_ADDED");
                            pMarkers = markers * 500;
                            TotalMarkersPrice += pMarkers;
                        } else
                            System.out.println("ERROR_QUANTITY_EXCEEDED");
                    }

                    sum = sum + pShirt + pJacket + pCaps + pNotebooks + pPens + pMarkers;

                } else {
                    if (sum > 0) {
                        if (sum < 1000) {
                            System.out.printf("TOTAL_DISCOUNT: %.2f\n", 0.00);
                            System.out.printf("TOTAL_AMOUNT_TO_PAY: %.2f\n", sum);
                        } else if (sum >= 1000 && sum < 3000) {
                            float totalDiscount = (float) (0.1 * TotalShirtPrice) + (float) ((0.05) * TotalJacketPrice)
                                    + (float) ((0.2) * TotalCapsPrice) + (float) ((0.1) * TotalPensPrice)
                                    + (float) ((0.05) * TotalMarkersPrice) + (float) ((0.2) * TotalNotebookPrice);

                            float totalAfterDiscount = sum - totalDiscount;

                            float totalAfterTax = totalAfterDiscount + (float) (0.1) * totalAfterDiscount;

                            System.out.printf("TOTAL_DISCOUNT %.2f\n", totalDiscount);
                            System.out.printf("TOTAL_AMOUNT_TO_PAY %.2f\n", totalAfterTax);

                        } else {
                            float totalNormalDiscount = (float) (0.1 * TotalShirtPrice)
                                    + (float) ((0.05) * TotalJacketPrice)
                                    + (float) ((0.2) * TotalCapsPrice) + (float) ((0.1) * TotalPensPrice)
                                    + (float) ((0.05) * TotalMarkersPrice) + (float) ((0.2) * TotalNotebookPrice);

                            float totalAmtAfterNormalDiscount = sum - totalNormalDiscount;
                            float totalDisocountAfterAddionalDiscount = totalNormalDiscount
                                    + (float) (0.05) * totalAmtAfterNormalDiscount;

                            float amtBeforeTax = sum - totalDisocountAfterAddionalDiscount;

                            tax = (float) (0.1) * amtBeforeTax;
                            total = amtBeforeTax + tax;

                            System.out.printf("TOTAL_DISCOUNT %.2f\n", totalDisocountAfterAddionalDiscount);
                            System.out.printf("TOTAL_AMOUNT_TO_PAY %.2f\n", total);

                        }
                    }
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
