package lab.two.office.technic;

import java.util.ArrayList;

public class Printer extends OfficeTechnicItem {

    public static final String CATEGORY = "Printer";

    private PrintTechnology printTechnology = PrintTechnology.NONE;

    private int maxPaperSizeInFormatA = -1;

    private boolean isMonochrome = false;

    private int numberOfDpi = -1;

    private ArrayList<String> interfaces = new ArrayList<>();

    private boolean hasCardReaderSupport = false;

    @Override
    public String toString() {
        return super.toString()
                + "\n[tech: " + getPrintTechnology()
                + ", max pap. size: A" + getMaxPaperSizeInFormatA()
                + ", is" + (isMonochrome() ? " " : "n't ") + "monochrome"
                + ", DPI: " + getNumberOfDpi()
                + ", interfaces: {" + getInterfaces().toString() + "}"
                + (hasCardReaderSupport() ? ", supports cart reader": "") + "]";
    }

    @Override
    public Printer clone() {
        Printer copy = (Printer) super.clone();
        copy.interfaces = (ArrayList<String>) copy.interfaces.clone();
        return copy;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    public void setPrintTechnology(PrintTechnology printTechnology){
        if(printTechnology == PrintTechnology.NONE)
            throw new RuntimeException("print technology cant be none");
        this.printTechnology = printTechnology;
    }

    public PrintTechnology getPrintTechnology(){
        return printTechnology;
    }

    public void setMaxPaperSizeInFormatA(int maxPaperSizeInFormatA){
        if(maxPaperSizeInFormatA < 0 || maxPaperSizeInFormatA > 10)
            throw new RuntimeException("max paper format should be in range (0, 10)");
        this.maxPaperSizeInFormatA = maxPaperSizeInFormatA;
    }

    public int getMaxPaperSizeInFormatA(){
        return maxPaperSizeInFormatA;
    }

    public void setMonochrome(boolean isMonochrome){
        this.isMonochrome = isMonochrome;
    }

    public boolean isMonochrome(){
        return isMonochrome;
    }

    public void setNumberOfDpi(int numberOfDpi){
        if(numberOfDpi < 0)
            throw new RuntimeException("DPI cant be negative");
        this.numberOfDpi = numberOfDpi;
    }

    public int getNumberOfDpi(){
        return numberOfDpi;
    }

    public void setInterfaces(ArrayList<String> interfaces){
        if(interfaces == null)
            throw new NullPointerException("interfaces variable is null");
        this.interfaces = (ArrayList<String>) interfaces.clone();
    }

    public void addInterface(String interfaceItem) {
        interfaces.add(interfaceItem);
    }

    public ArrayList<String> getInterfaces(){
        return (ArrayList<String>)interfaces.clone();
    }

    public void setCardReaderSupport(boolean hasCardReaderSupport){
        this.hasCardReaderSupport = hasCardReaderSupport;
    }

    public boolean hasCardReaderSupport(){
        return hasCardReaderSupport;
    }
}
