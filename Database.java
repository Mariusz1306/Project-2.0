import java.util.HashMap;


public class Database {
    private HashMap<String, Table> tables;

    public Database() {
        tables = new HashMap<>();
    }

    public Table addTable(String name, String[] columnNames) {
        Table tableToBeAdded = new Table(name, columnNames);
        return tables.putIfAbsent(name, tableToBeAdded);
    }

    public Table removeTable(String name) {
        return tables.remove(name);
    }

    public boolean insertIntoTable(String name, String values[]) {
        Table table = tables.get(name);
        if (table.getColumnNames().length != values.length)
            return false;
        table.addRecord(new Record(values));
        return true;
    }

    public void select(String tableName) {
        if (tables.containsKey(tableName)) {
            Table table = tables.get(tableName);
            for (String columnName : table.getColumnNames())
                System.out.print(columnName + " ");
            System.out.println();
            for (int i = 0; i < table.getRecords().size(); i++) {
                System.out.println(table.getRecords().get(i).toString());
            }
        } else
            System.out.println("There is no table with that name!");
    }

    public void select(String tableName, String columnNames[]) {
        if (tables.containsKey(tableName)) {
            Table table = tables.get(tableName);
            int selectedColumns[] = new int[table.getColumnNames().length];
            for (String columnName : columnNames){
                System.out.print(columnName + " ");
            }
            System.out.println();
            for (int i = 0; i < table.getColumnNames().length; i++){
                String tempColumnName = table.getColumnNames()[i];
                for (int j = 0; j < columnNames.length; j++)
                    if (tempColumnName.equalsIgnoreCase(columnNames[j]))
                        selectedColumns[i] = 1;
            }
            for (int i = 0; i < table.getRecords().size(); i++) {
                System.out.println(table.getRecords().get(i).toString(selectedColumns));
            }
        } else
            System.out.println("There is no table with that name!");
    }

    public void update(String tableName, String[] columnNames, String[] values) {
        Table table = tables.get(tableName);

    }

    //Getters
    public HashMap<String, Table> getTables() {
        return tables;
    }

    public Table getTable(String tableName){
        return tables.get(tableName);
    }
}
