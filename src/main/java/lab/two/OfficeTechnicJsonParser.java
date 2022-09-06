package lab.two;

import lab.two.office.technic.Computer;
import lab.two.office.technic.OfficeTechnicItem;
import lab.two.office.technic.Photocopier;
import lab.two.office.technic.Printer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class OfficeTechnicJsonParser {

    // types
    private static final String TAG_TYPE = "type";
    private static final String TYPE_COMPUTER = "computer";
    private static final String TYPE_PRINTER = "printer";
    private static final String TYPE_PHOTOCOPIER = "photocopier";

    // base info
    protected static final String TAG_BASE_INFO = "baseInfo";
    private static final String TAG_MODEL = "model";
    private static final String TAG_PRICE = "price";
    private static final String TAG_ENERGY_CONSUMPTION = "energyConsumptionInWh";
    private static final String TAG_MANUFACTURER_NAME = "manufacturerName";
    private static final String TAG_ENERGY_EFFICIENT_CLASS = "energyEfficientClass";

    // computer info
    private static final String TAG_COMPUTER_INFO = "computerInfo";
    private static final String TAG_PROCESSOR_NAME = "processorName";
    private static final String TAG_GRAPHICS_CARD_NAME = "graphicsCardName";
    private static final String TAG_MEMORY_AMOUNT = "memoryAmount";
    private static final String TAG_AMOUNT_OF_RAM = "amountOfRam";
    private static final String TAG_SCREEN_PPI = "screenPpi";

    // printer info
    private static final String TAG_PRINTER_INFO = "printerInfo";
    private static final String TAG_PRINT_TECHNOLOGY = "printTechnology";
    private static final String TAG_MAX_PAPER_SIZE = "maxPaperSizeInFormatA";
    private static final String TAG_IS_MONOCHROME = "isMonochrome";
    private static final String TAG_NUMBER_OF_DPI = "numberOfDpi";
    private static final String TAG_INTERFACES = "interfaces";
    private static final String TAG_HAS_CARD_READER_SUPPORT = "hasCardReaderSupport";

    // photocopier info
    private static final String TAG_PHOTOCOPIER_INFO = "photocopierInfo";
    private static final String TAG_OPTICAL_RESOLUTION_X = "opticalResolutionX";
    private static final String TAG_OPTICAL_RESOLUTION_Y = "opticalResolutionY";
    private static final String TAG_MAX_COLOR_BITRATE = "maxColorBitrate";
    private static final String TAG_MAX_SCANNING_SPEED = "maxScanningSpeed";
    private static final String TAG_SCANNING_SURFACE_WIDTH = "scanningSurfaceWidthInCm";
    private static final String TAG_SCANNING_SURFACE_HEIGHT = "scanningSurfaceHeightInCm";
    private String filePath;
    private JSONParser parser = new JSONParser();

    private static OfficeTechnicItem createOfficeTechnicItemFromJson(JSONObject object) {
        String type = (String) object.get(TAG_TYPE);

        switch (type)
        {
            case TYPE_COMPUTER:
                return parseComputerFromJson(object);
            case TYPE_PRINTER:
                return parsePrinterFromJson(object);
            case TYPE_PHOTOCOPIER:
                return parsePhotocopierFromJson(object);
            default:
                return null;
        }
    }

    private static void setOfficeTechnicDataFromJson(OfficeTechnicItem officeTechnicItem, JSONObject baseInfoObject) {
        officeTechnicItem.setModel((String) baseInfoObject.get(TAG_MODEL));
        officeTechnicItem.setPrice( (float) (double) baseInfoObject.get(TAG_PRICE));
        officeTechnicItem.setEnergyConsumption( (float) (double) baseInfoObject.get(TAG_ENERGY_CONSUMPTION));
        officeTechnicItem.setManufacturerName((String) baseInfoObject.get(TAG_MANUFACTURER_NAME));
        String energyEfficientClassString = (String) baseInfoObject.get(TAG_ENERGY_EFFICIENT_CLASS);
        officeTechnicItem.setEnergyEfficientClass(ConvertHelper.convertEnergyEfficientClassFromString(energyEfficientClassString));
    }
    private static Computer parseComputerFromJson(JSONObject object) {
        Computer parsedComputer = new Computer();
        setOfficeTechnicDataFromJson(parsedComputer, (JSONObject) object.get(TAG_BASE_INFO));

        JSONObject computerDataJsonObject = (JSONObject) object.get(TAG_COMPUTER_INFO);
        parsedComputer.setProcessorName( (String) computerDataJsonObject.get(TAG_PROCESSOR_NAME));
        parsedComputer.setGraphicsCardName( (String) computerDataJsonObject.get(TAG_GRAPHICS_CARD_NAME));
        parsedComputer.setMemoryAmountInGb( (int) (long) computerDataJsonObject.get(TAG_MEMORY_AMOUNT));
        parsedComputer.setAmountOfRamInMb( (int) (long) computerDataJsonObject.get(TAG_AMOUNT_OF_RAM));
        parsedComputer.setScreenPpi( (int) (long) computerDataJsonObject.get(TAG_SCREEN_PPI));

        return parsedComputer;
    }

    private static Printer parsePrinterFromJson(JSONObject object) {
        Printer parsedPrinter = new Printer();
        setOfficeTechnicDataFromJson(parsedPrinter, (JSONObject) object.get(TAG_BASE_INFO));

        JSONObject printerDataJsonObject = (JSONObject) object.get(TAG_PRINTER_INFO);

        String printTechnology = (String) printerDataJsonObject.get(TAG_PRINT_TECHNOLOGY);
        parsedPrinter.setPrintTechnology(ConvertHelper.convertPrintTypeFromString(printTechnology));
        parsedPrinter.setMaxPaperSizeInFormatA( (int) (long) printerDataJsonObject.get(TAG_MAX_PAPER_SIZE));
        parsedPrinter.setMonochrome( (boolean) printerDataJsonObject.get(TAG_IS_MONOCHROME));
        parsedPrinter.setNumberOfDpi( (int) (long) printerDataJsonObject.get(TAG_NUMBER_OF_DPI));
        parsedPrinter.setCardReaderSupport( (boolean) printerDataJsonObject.get(TAG_HAS_CARD_READER_SUPPORT));

        JSONArray interfaces = (JSONArray) printerDataJsonObject.get(TAG_INTERFACES);

        interfaces.forEach(x -> parsedPrinter.addInterface( (String) x));

        parsedPrinter.setNumberOfDpi( (int) (long) printerDataJsonObject.get(TAG_NUMBER_OF_DPI));

        return parsedPrinter;
    }

    private static Photocopier parsePhotocopierFromJson(JSONObject object) {
        Photocopier parsedPhotocopier = new Photocopier();
        setOfficeTechnicDataFromJson(parsedPhotocopier, (JSONObject) object.get(TAG_BASE_INFO));

        JSONObject photocopierDataJsonObject = (JSONObject) object.get(TAG_PHOTOCOPIER_INFO);

        parsedPhotocopier.setOpticalResolutionX( (int) (long) photocopierDataJsonObject.get(TAG_OPTICAL_RESOLUTION_X));
        parsedPhotocopier.setOpticalResolutionY( (int) (long) photocopierDataJsonObject.get(TAG_OPTICAL_RESOLUTION_Y));
        parsedPhotocopier.setMaxColorBitrate( (int) (long) photocopierDataJsonObject.get(TAG_MAX_COLOR_BITRATE));
        parsedPhotocopier.setMaxScanningSpeedInSps( (float) (double) photocopierDataJsonObject.get(TAG_MAX_SCANNING_SPEED));
        parsedPhotocopier.setScanningSurfaceWidthInCm(
                (float) (double) photocopierDataJsonObject.get(TAG_SCANNING_SURFACE_WIDTH));
        parsedPhotocopier.setScanningSurfaceHeightInCm(
                (float) (double) photocopierDataJsonObject.get(TAG_SCANNING_SURFACE_HEIGHT));

        return parsedPhotocopier;
    }

    public OfficeTechnicJsonParser(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<OfficeTechnicItem> extractOfficeTechnics() {
        ArrayList<OfficeTechnicItem> readOfficeTechnics = new ArrayList<>();

        try (FileReader reader = new FileReader(filePath)) {
            JSONArray technicItems = (JSONArray) parser.parse(reader);

            for (Object item : technicItems) {
                JSONObject itemJson = (JSONObject) item;

                readOfficeTechnics.add(createOfficeTechnicItemFromJson(itemJson));
            }
        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return  readOfficeTechnics;
    }

}
