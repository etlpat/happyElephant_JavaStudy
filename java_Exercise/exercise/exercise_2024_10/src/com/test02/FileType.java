package com.test02;

public class FileType {
    public String typeName;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "FileType{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
