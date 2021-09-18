package utils;

import java.util.Scanner;

// Sample input: 214 7 11 12 7 13 176 23 191
// Output: 38 207
public class Simulation {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Enter data: ");
        final String[] data = scanner.nextLine().split("\s+");
        final int width = Integer.parseInt(data[0]);
        final int particlesCount = Integer.parseInt(data[1]);
        final int[] particles = new int[data.length - 2];
        assert particlesCount == particles.length; // must match
        for (int i = 0, j = 2; j < data.length; i++, j++) {
            particles[i] = Integer.parseInt(data[j]);
        }
        final Pole pole = new Pole(width, particles);
        System.out.println(pole.shortestSimulationTime());
        System.out.println(pole.longestSimulationTime());
    }

}
