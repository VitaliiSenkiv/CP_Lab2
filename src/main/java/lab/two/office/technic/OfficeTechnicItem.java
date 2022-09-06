package lab.two.office.technic;

public abstract class OfficeTechnicItem implements Cloneable{

    private String model = "Unknown";
    private float price = -1.0f;
    private float energyConsumptionInWh = -1.0f;
    private String manufacturerName = "Unknown";
    private EnergyEfficientClass energyEfficientClass = EnergyEfficientClass.NONE;

    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + " " + getManufacturerName() + " " + getModel()
                + " costs " + getPrice() + "(UAH) energy cons. "
                + getEnergyConsumptionInWh() + "(Wh)"
                + "(Energy class " + getEnergyEfficientClass() + ")";
    }
    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception occurred! Info: " + e.toString());
        }
        return clone;
    }

    public void copy(OfficeTechnicItem other) {
        this.model = other.model;
        this.price = other.price;
        this.energyConsumptionInWh = other.energyConsumptionInWh;
        this.manufacturerName = other.manufacturerName;
        this.energyEfficientClass = other.energyEfficientClass;
    }

    public void setModel(String model){
        if(model == null)
            throw new NullPointerException("model name is null");
        this.model = model;
    }

    public String getModel(){
        return model;
    }

    public void setPrice(float price){
        if(price < 0.0)
            throw new RuntimeException("price of technic cant be negative");
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public void setEnergyConsumption(float energyConsumptionInWh){
        if(energyConsumptionInWh < 0.0)
            throw new RuntimeException("energy consumption of technic cant be negative");
        this.energyConsumptionInWh = energyConsumptionInWh;
    }

    public float getEnergyConsumptionInWh(){
        return energyConsumptionInWh;
    }

    public void setManufacturerName(String manufacturerName){
        if(manufacturerName == null)
            throw new NullPointerException("manufacturer name is null");
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerName(){
        return manufacturerName;
    }

    public void setEnergyEfficientClass(EnergyEfficientClass energyEfficientClass){
        if (energyEfficientClass == EnergyEfficientClass.NONE)
            throw new RuntimeException("energy efficient class cant be none");
        this.energyEfficientClass = energyEfficientClass;
    }

    public EnergyEfficientClass getEnergyEfficientClass(){
        return energyEfficientClass;
    }
}
