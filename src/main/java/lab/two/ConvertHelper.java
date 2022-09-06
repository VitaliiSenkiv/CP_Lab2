package lab.two;

import lab.two.office.technic.EnergyEfficientClass;
import lab.two.office.technic.PrintTechnology;

public class ConvertHelper {

    public static EnergyEfficientClass convertEnergyEfficientClassFromString(String str) {
        return switch (str) {
            case "A+++" -> EnergyEfficientClass.A_PPP;
            case "A++" -> EnergyEfficientClass.A_PP;
            case "A+" -> EnergyEfficientClass.A_P;
            case "A" -> EnergyEfficientClass.A;
            case "B" -> EnergyEfficientClass.B;
            case "C" -> EnergyEfficientClass.C;
            case "D" -> EnergyEfficientClass.D;
            default -> EnergyEfficientClass.NONE;
        };
    }

    public static PrintTechnology convertPrintTypeFromString(String str) {
        return switch (str) {
            case "Matrix" -> PrintTechnology.MATRIX;
            case "Laser" -> PrintTechnology.LASER;
            case "Inject" -> PrintTechnology.INJECT;
            case "SolidInk" -> PrintTechnology.SOLID_INK;
            case "Led" -> PrintTechnology.LED;
            default -> PrintTechnology.NONE;
        };
    }

}
