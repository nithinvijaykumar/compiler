class Variable {
    private String dataType;
    private String name;
    private String value;

    public Variable(String dataType, String name, String value) {
        this.dataType = dataType;
        this.name = name;
        this.value = value;
    }

    public int intValue() {
        return Integer.parseInt(value);
    }

    public String strValue() {
        return value;
    }
}