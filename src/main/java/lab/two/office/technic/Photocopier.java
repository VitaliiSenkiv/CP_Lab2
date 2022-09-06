package lab.two.office.technic;

public class Photocopier extends OfficeTechnicItem {

    public static final String CATEGORY = "Photocopier";
    private int opticalResolutionX;
    private int opticalResolutionY;
    private int maxColorBitrate;
    private float maxScanningSpeedInSps;
    private float scanningSurfaceWidthInCm;
    private float scanningSurfaceHeightInCm;

    @Override
    public String toString() {
        return super.toString()
                + "\n[op. res.: " + getOpticalResolutionX()
                + "x" + getOpticalResolutionY()
                + ", max col. bitrate: " + getMaxColorBitrate()
                + ", max scan. speed: " + getMaxScanningSpeedInSps() + "(SPS)"
                + ", scan. surf. : " + getScanningSurfaceWidthInCm() + "(Cm)"
                + " x " + getScanningSurfaceHeightInCm() + "(Cm)]";
    }

    @Override
    public Photocopier clone() {
        return (Photocopier) super.clone();
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    public void setOpticalResolutionX(int opticalResolutionX) {
        if (opticalResolutionX < 0)
            throw new RuntimeException("optical resolution x cant be negative");
        this.opticalResolutionX = opticalResolutionX;
    }

    public int getOpticalResolutionX() {
        return opticalResolutionX;
    }

    public void setOpticalResolutionY(int opticalResolutionY) {
        if (opticalResolutionY < 0)
            throw new RuntimeException("optical resolution y cant be negative");
        this.opticalResolutionY = opticalResolutionY;
    }

    public int getOpticalResolutionY() {
        return opticalResolutionY;
    }

    public void setMaxColorBitrate(int maxColorBitrate) {
        if (maxColorBitrate < 0)
            throw new RuntimeException("max color bitrate cant be negative");
        this.maxColorBitrate = maxColorBitrate;
    }

    public int getMaxColorBitrate() {
        return maxColorBitrate;
    }

    public void setMaxScanningSpeedInSps(float maxScanningSpeedInSps) {
        if (maxScanningSpeedInSps < 0.0f)
            throw new RuntimeException("scanning speed cant be negative");
        this.maxScanningSpeedInSps = maxScanningSpeedInSps;
    }

    public float getMaxScanningSpeedInSps() {
        return maxScanningSpeedInSps;
    }

    public void setScanningSurfaceWidthInCm(float scanningSurfaceWidthInCm) {
        if (scanningSurfaceWidthInCm < 0.0f)
            throw new RuntimeException("scanning surface size x cant be negative");
        this.scanningSurfaceWidthInCm = scanningSurfaceWidthInCm;
    }

    public float getScanningSurfaceWidthInCm() {
        return scanningSurfaceWidthInCm;
    }

    public void setScanningSurfaceHeightInCm(float scanningSurfaceHeightInCm) {
        if (scanningSurfaceHeightInCm < 0.0f)
            throw new RuntimeException("scanning surface size y cant be negative");
        this.scanningSurfaceHeightInCm = scanningSurfaceHeightInCm;
    }

    public float getScanningSurfaceHeightInCm() {
        return scanningSurfaceHeightInCm;
    }
}
