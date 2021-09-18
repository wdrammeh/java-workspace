package utils;

import java.util.ArrayList;
import java.util.Comparator;

public class Pole {
    final int length;
    final int mid;
    private final int[] data;
    private final ArrayList<Particle> particles;


    public Pole(int length, int[] data) {
        this.length = length;
        this.data = data;
        mid = length/2;
        particles = new ArrayList<>();
        addParticles();
    }

    private void addParticles(){
        for (int d : data) {
            particles.add(new Particle(d, Particle.UNDEFINED));
        }
        particles.sort(Comparator.comparing(particle -> particle.position));
    }

    public int shortestSimulationTime(){
        for (Particle p : particles) {
            p.direction = p.position > mid ? Particle.RIGHT : Particle.LEFT;
        }
        return doSimulation() - 1;
    }

    public int longestSimulationTime(){
        for (Particle p : particles) {
            p.direction = p.position > mid ? Particle.LEFT : Particle.RIGHT;
        }
        return doSimulation();
    }

    private int doSimulation(){
        int time = 0;
        while (!particles.isEmpty()){
            for (int i = 0; i < particles.size(); i++) {
                final Particle previous = i > 0 ? particles.get(i - 1) : null;
                final Particle current = particles.get(i);
                final Particle next = i == particles.size() - 1 ? null : particles.get(i + 1);
                if (isExtreme(current)) {
                    particles.remove(current);
                } else if (previous != null && isCollision(previous, current)) {
                    previous.shiftDirection();
                    current.shiftDirection();
                } else if (next != null && isCollision(current, next)) {
                    current.shiftDirection();
                    next.shiftDirection();
                } else {
                    current.move();
                    if (isExtreme(current)) {
                        particles.remove(current);
                    }
                }
            }
            time++;
        }
        addParticles();
        return time;
    }

    private boolean isExtreme(Particle p){
        return (p.position == 1 && p.direction.equals(Particle.LEFT)) ||
                (p.position == length && p.direction.equals(Particle.RIGHT));
    }

    private boolean isCollision(Particle p1, Particle p2){
        if (Math.abs(p1.position - p2.position) == 1){
            if ((p1.position < p2.position) &&
                    (p1.direction.equals(Particle.RIGHT) && p2.direction.equals(Particle.LEFT))) {
                return true;
            } else if ((p2.position < p1.position) &&
                    (p2.direction.equals(Particle.RIGHT) && p1.direction.equals(Particle.LEFT))) {
                return true;
            }
        }
        return false;
    }

}
