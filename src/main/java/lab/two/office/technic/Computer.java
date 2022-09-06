package lab.two.office.technic;

public class Computer extends OfficeTechnicItem {

    public static final String CATEGORY = "Computer";
    private String processorName;
    private String graphicsCardName;
    private int memoryAmountInGb;
    private int amountOfRamInMb;
    private int screenPpi;

    @Override
    public String toString() {
        return super.toString()
                + "\n[proc: " + getProcessorName()
                + ", grahp: " + getGraphicsCardName()
                + ", main memory: " + getMemoryAmountInGb() + "Gb"
                + ", RAM: " + getAmountOfRamInMb() + "Mb"
                + ", PPI: " + getScreenPpi() + "]";
    }

    @Override
    public Computer clone() {
        return (Computer) super.clone();
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    public void setProcessorName(String processorName){
        if(processorName == null)
            throw new NullPointerException("processor name is null");
        this.processorName = processorName;
    }

    public String getProcessorName(){
        return processorName;
    }

    public void setGraphicsCardName(String graphicsCardName){
        if(graphicsCardName == null)
            throw new NullPointerException("graphics card name is null");
        this.graphicsCardName = graphicsCardName;
    }

    public String getGraphicsCardName(){
        return graphicsCardName;
    }

    public void setMemoryAmountInGb(int memoryAmountInGb){
        if(memoryAmountInGb < 0)
            throw new RuntimeException("memory amount cant be negative");
        this.memoryAmountInGb = memoryAmountInGb;
    }

    public int getMemoryAmountInGb(){
        return memoryAmountInGb;
    }

    public void setAmountOfRamInMb(int amountOfRamInMb){
        if(amountOfRamInMb < 0)
            throw new RuntimeException("RAM amount cant be negative");
        this.amountOfRamInMb = amountOfRamInMb;
    }

    public int getAmountOfRamInMb(){
        return amountOfRamInMb;
    }

    public void setScreenPpi(int screenPpi){
        if(screenPpi < 0)
            throw new RuntimeException("screen PPI cant be negative");
        this.screenPpi = screenPpi;
    }

    public int getScreenPpi(){
        return screenPpi;
    }
}
