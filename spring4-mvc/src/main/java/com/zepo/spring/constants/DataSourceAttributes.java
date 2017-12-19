package com.zepo.spring.constants;

public enum DataSourceAttributes {
DRIVER_CLASS_NAME("com.mysql.jdbc.Driver"),
    /*DATABASE_URL("jdbc:mysql://localhost:3306/db_sarto"),*/
DATABASE_URL("jdbc:mysql://192.168.30.13:3306/Walmart"),
   /* DATABASE_USERNAME("root"),
    DATABASE_PASSWORD("P@55w0rd");*/
DATABASE_USERNAME("rein"),
DATABASE_PASSWORD("hFgYur7B3@");

    private String attributeName;

    DataSourceAttributes(String attributeName) {
        this.attributeName = attributeName;
    }

    public String attributeValue() {
        return attributeName;
    }
    
    
    public static void main(String[] args) {

		//whois.arin.net
        System.out.println(DataSourceAttributes.DRIVER_CLASS_NAME.attributeValue());

    }
}
