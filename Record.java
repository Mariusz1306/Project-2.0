public class Record {
    private String values[];

    public Record(String[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        for (String value : values)
            toReturn.append(value + " ");
        return toReturn.toString();
    }

    public String toString(int selectedColumns[]) {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (selectedColumns[i] == 1)
                toReturn.append(values[i] + " ");
        }
        return toReturn.toString();
    }

    //Getters
    public String[] getValues() {
        return values;
    }
}
