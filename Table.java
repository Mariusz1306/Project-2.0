import java.util.HashMap;

public class Table {
    String name;
    private String columnNames[];
    private HashMap<Integer, Record> records;

    public Table(String name, String[] columnNames) {
        records = new HashMap<>();
        this.name = name;
        this.columnNames = columnNames;
    }

    public void addRecord(Record record){
        records.put(records.size(), record);
    }

    //Getters
    public String getName() {
        return name;
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public HashMap<Integer, Record> getRecords() {
        return records;
    }
}
