package lab.two;

import lab.two.office.technic.Computer;
import lab.two.office.technic.OfficeTechnicItem;
import lab.two.office.technic.Printer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        OfficeTechnicsManager manager = new OfficeTechnicsManager();

        System.out.println("\t\t\tSEARCH:");

        List<OfficeTechnicItem> technicByPrice = manager.findTechnicByPrice("All", 50_000, 600_000);
        technicByPrice.forEach(x -> System.out.println(x + "\n"));

        System.out.println("\t\t\tSORTING: \n\ncomputers by energy consumption:\n");

        List<Computer> sortedComps = manager.getSortedComputersByEnergyConsumption(false);
        sortedComps.forEach(x -> System.out.println(x + "\n"));

        System.out.println("technic by manufacturer name:\n");
        List<OfficeTechnicItem> sortedTechnicsByManufacturerName
                = manager.getSortedTechnicsByManufacturerName(false);
        sortedTechnicsByManufacturerName.forEach(x -> System.out.println(x + "\n"));

        System.out.println("printers by DPI:\n");
        ArrayList<Printer> sortedPrintersByDPI = manager.getSortedPrintersByDPI(true);
        sortedPrintersByDPI.forEach(x -> System.out.println(x + "\n"));

        System.out.println("technic by lambda:\n");
        ArrayList<OfficeTechnicItem> sortedTechnic = manager.getSortedTechnicBy((tech1, tech2) ->
                -1 * tech1.getCategory().compareTo(tech2.getCategory()));
        sortedTechnic.forEach(x -> System.out.println(x + "\n"));
    }
}