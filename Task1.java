import java.util.Scanner;

class Vehicle {
    private String name;
    private int speed;

    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void Show() {
        System.out.println("Назва: " + name + ", швидкість: " + speed + " км/год");
    }
}

class Car extends Vehicle {
    private int seats;

    public Car(String name, int speed, int seats) {
        super(name, speed);
        this.seats = seats;
    }

    @Override
    public void Show() {
        System.out.println("Автомобіль:");
        super.Show();
        System.out.println("Кількість місць: " + seats);
    }
}

class Train extends Vehicle {
    private int wagons;

    public Train(String name, int speed, int wagons) {
        super(name, speed);
        this.wagons = wagons;
    }

    @Override
    public void Show() {
        System.out.println("Поїзд:");
        super.Show();
        System.out.println("Кількість вагонів: " + wagons);
    }
}

class Express extends Train {
    private String route;

    public Express(String name, int speed, int wagons, String route) {
        super(name, speed, wagons);
        this.route = route;
    }

    @Override
    public void Show() {
        System.out.println("Експрес:");
        super.Show();
        System.out.println("Маршрут: " + route);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[3];

        System.out.println("Автомобіль: введіть назву окремим рядком, потім швидкість і кількість місць:");
        vehicles[0] = new Car(in.nextLine(), in.nextInt(), in.nextInt());
        in.nextLine();

        System.out.println("Поїзд: введіть назву окремим рядком, потім швидкість і кількість вагонів:");
        vehicles[1] = new Train(in.nextLine(), in.nextInt(), in.nextInt());
        in.nextLine();

        System.out.println("Експрес: введіть назву окремим рядком, потім швидкість і кількість вагонів:");
        String name = in.nextLine();
        int speed = in.nextInt();
        int wagons = in.nextInt();
        in.nextLine();
        System.out.println("Введіть маршрут:");
        vehicles[2] = new Express(name, speed, wagons, in.nextLine());

        System.out.println("\nВведені транспортні засоби:");
        for (Vehicle vehicle : vehicles) {
            vehicle.Show();
            System.out.println();
        }
        in.close();
    }
}
