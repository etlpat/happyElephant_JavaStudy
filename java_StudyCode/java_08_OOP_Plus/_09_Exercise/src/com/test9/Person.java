package com.test9;

public class Person {
    private String name;
    public int riverCrossing;// 0表示不过河，其它表示过河
    private Vehicles vehicle;

    public Person(String name) {
        this.name = name;
        riverCrossing = 0;// 默认不过河
        vehicle = VehiclesFactory.getHorse();
    }

    public Person(String name, int riverCrossing) {
        this.name = name;
        this.riverCrossing = riverCrossing;
        if (riverCrossing == 0) {
            vehicle = VehiclesFactory.getHorse();
        } else {
            vehicle = VehiclesFactory.getBoat();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", riverCrossing=" + riverCrossing +
                ", vehicle=" + vehicle +
                '}';
    }
}
