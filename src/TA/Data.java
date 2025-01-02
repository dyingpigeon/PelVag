package TA;

public class Data {
    private int id;
    private String label;
    
    public Data(int id, String label) {
        this.id = id;
        this.label = label;
    }
    
    public int getId() {
        return id;
    }
    
    public String getLabel() {
        return label;
    }
    
    // Override toString untuk menampilkan label saja di ComboBox
    @Override
    public String toString() {
        return label;
    }
}
