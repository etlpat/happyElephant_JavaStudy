package test01;

abstract class Pet {
    private String name;
    private String sex;

    public Pet(String name, String sex) {
        setName(name);
        setSex(sex);
    }

    public Pet() {
    }

    public void talk() {
    }

    public void eat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
