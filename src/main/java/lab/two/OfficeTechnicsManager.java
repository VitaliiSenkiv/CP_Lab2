package lab.two;

import lab.two.office.technic.Computer;
import lab.two.office.technic.OfficeTechnicItem;
import lab.two.office.technic.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OfficeTechnicsManager {
    private ArrayList<OfficeTechnicItem> technicsItems;

    public OfficeTechnicsManager() {
        OfficeTechnicJsonParser jsonParser = new OfficeTechnicJsonParser("src/OfficeTechnics.json");
        technicsItems = jsonParser.extractOfficeTechnics();
    }

    public List<OfficeTechnicItem> findTechnicByPrice(String categoryName, float minPrice, float maxPrice) {
        ArrayList<OfficeTechnicItem> appropriateTechnicElements = getCopyOfTechItems(categoryName);

        return appropriateTechnicElements.stream()
                .filter(x -> x.getPrice() >= minPrice)
                .filter(x -> x.getPrice() <= maxPrice)
                .toList();
    }

    /**
     * @param categoryName is name of category if set "All" returns technic of all categories
     */
    private ArrayList<OfficeTechnicItem> getCopyOfTechItems(String categoryName) {
        ArrayList<OfficeTechnicItem> copiedTechnicElements = new ArrayList<>();

        technicsItems.forEach(item -> {
            if (categoryName.equals("All") || item.getCategory().equals(categoryName)) {
                copiedTechnicElements.add((OfficeTechnicItem) item.clone());
            }
        });
        return copiedTechnicElements;
    }

    static class ComputerEnergyConsumptionComparator implements Comparator<Computer> {

        private boolean ascendingSort;

        public ComputerEnergyConsumptionComparator(boolean ascendingSort) {
            this.ascendingSort = ascendingSort;
        }

        @Override
        public int compare(Computer comp1, Computer comp2) {
            Float comp1Consumption = comp1.getEnergyConsumptionInWh();
            Float comp2Consumption = comp2.getEnergyConsumptionInWh();
            return (ascendingSort ? 1 : -1) * comp1Consumption.compareTo(comp2Consumption);
        }
    }

    /**
     * sorting with comparator which is inner static class
     */
    public ArrayList<Computer> getSortedComputersByEnergyConsumption(boolean ascending) {
        ArrayList<Computer> computers = new ArrayList<>();
        getCopyOfTechItems(Computer.CATEGORY).forEach(comp -> computers.add((Computer) comp));

        computers.sort(new ComputerEnergyConsumptionComparator(ascending));

        return computers;
    }

    class TechnicManufacturerNameComparator implements Comparator<OfficeTechnicItem> {

        private boolean ascendingSort;

        public TechnicManufacturerNameComparator(boolean ascendingSort) {
            this.ascendingSort = ascendingSort;
        }

        @Override
        public int compare(OfficeTechnicItem tech1, OfficeTechnicItem tech2) {
            return (ascendingSort ? 1 : -1) * tech1.getManufacturerName().compareTo(tech2.getManufacturerName());
        }
    }

    /**
     * sorting with comparator which is inner class
     */
    public ArrayList<OfficeTechnicItem> getSortedTechnicsByManufacturerName(boolean ascending) {
        ArrayList<OfficeTechnicItem> technicItems = getCopyOfTechItems("All");
        technicItems.sort(new TechnicManufacturerNameComparator(ascending));

        return technicItems;
    }

    public ArrayList<Printer> getSortedPrintersByDPI(boolean ascending) {
        ArrayList<Printer> printers = new ArrayList<>();
        getCopyOfTechItems(Printer.CATEGORY).forEach(x -> printers.add((Printer) x));

        printers.sort(new Comparator<Printer>() {
            @Override
            public int compare(Printer printer1, Printer printer2) {
                Integer dpi1 = printer1.getNumberOfDpi();
                Integer dpi2 = printer2.getNumberOfDpi();
                return (ascending ? 1 : -1) * dpi1.compareTo(dpi2);
            }
        });

        return printers;
    }
    public ArrayList<OfficeTechnicItem> getSortedTechnicBy(Comparator<OfficeTechnicItem> lambda) {
        ArrayList<OfficeTechnicItem> technicItems = getCopyOfTechItems("All");
        technicItems.sort(lambda);
        return technicItems;
    }
}
