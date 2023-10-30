import java.util.Scanner;
import Model.Layout;
import Model.Robot;
import Model.Position;

public class RobotApp {
    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(1, 1));
        this.scanner = new Scanner(System.in);
        String instruction = "";

        System.out.println("-------- Permainan Dimulai --------");
        do {
            draw();
            instruction = waitInstruction();
            processInstruction(instruction);
        } while (!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukkan instruksi: ");
        return scanner.nextLine();
    }

    private void processInstruction(String instruction) {
        if (instruction.length() >= 2) {
            char direction = instruction.charAt(0);
            int steps = 0;
            try {
                steps = Integer.parseInt(instruction.substring(1));
            } catch (NumberFormatException e) {
                System.out.println("Error: Jumlah langkah tidak valid.");
                return;
            }

            Position newPosition = robot.getPosition();
            switch (direction) {
                case 'd':
                    newPosition.setX(newPosition.getX() + steps);
                    break;
                case 'a':
                    newPosition.setX(newPosition.getX() - steps);
                    break;
                case 'w':
                    newPosition.setY(newPosition.getY() - steps);
                    break;
                case 's':
                    newPosition.setY(newPosition.getY() + steps);
                    break;
                default:
                    System.out.println("Error: Instruksi tidak valid.");
                    return;
            }

            if (isValidPosition(newPosition)) {
                robot.setPosition(newPosition);
            } else {
                System.out.println("Error: Robot tidak boleh keluar dari area permainan.");
            }
        } else {
            System.out.println("Error: Instruksi tidak valid.");
        }
    }

    private boolean isValidPosition(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 1 && x <= layout.getMaxX() && y >= 1 && y <= layout.getMaxY();
    }

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        char[][] area = layout.getArea();
        Position robotPosition = robot.getPosition();

        for (int y = 1; y <= layout.getMaxY(); y++) {
            for (int x = 1; x <= layout.getMaxX(); x++) {
                if (x == robotPosition.getX() && y == robotPosition.getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(area[x - 1][y - 1]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new RobotApp();
    }
}
