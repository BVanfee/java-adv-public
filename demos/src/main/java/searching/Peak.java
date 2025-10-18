package searching;

public class Peak implements Comparable<Peak>{

    private String moutainName;
    private int height;

    public Peak(String moutainName, int height) {
        this.moutainName = moutainName;
        this.height = height;
    }

    public String getMoutainName() {
        return moutainName;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Peak o) {
        return this.height-o.getHeight();
    }
}
