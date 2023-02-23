// UNIVERSITY OF EXTREMADURA
// MEDIA ENGINEERING GROUP
// CONTACT: andresc@unex.es

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class kgon {
    static ArrayList<Integer> point1 = new ArrayList<>(Arrays.asList(2, 6));
    static ArrayList<Integer> point2 = new ArrayList<>(Arrays.asList(4, 6));
    static ArrayList<Integer> point3 = new ArrayList<>(Arrays.asList(6, 8));
    static ArrayList<Integer> point4 = new ArrayList<>(Arrays.asList(8, 6));
    static ArrayList<Integer> point5 = new ArrayList<>(Arrays.asList(6, 4));
    static ArrayList<Integer> point6 = new ArrayList<>(Arrays.asList(8, 2));
    static ArrayList<Integer> point7 = new ArrayList<>(Arrays.asList(6, 0));
    static ArrayList<Integer> point8 = new ArrayList<>(Arrays.asList(4, 2));
    static ArrayList<Integer> point9 = new ArrayList<>(Arrays.asList(4, 0));
    static ArrayList<Integer> point10 = new ArrayList<>(Arrays.asList(0, 4));
    static ArrayList<Integer> point11 = new ArrayList<>(Arrays.asList(2, 2));
    static ArrayList<Integer> point12 = new ArrayList<>(Arrays.asList(6, 6));
    static ArrayList<Integer> point13 = new ArrayList<>(Arrays.asList(2, 4));
    static ArrayList<Integer> point14 = new ArrayList<>(Arrays.asList(4, 4));
    static ArrayList<Integer> point15 = new ArrayList<>(Arrays.asList(6, 2));

    static ArrayList<ArrayList<Integer>> points = new ArrayList<>() {
        {
            add(point1);
            add(point2);
            add(point3);
            add(point4);
            add(point5);
            add(point6);
            add(point7);
            add(point8);
            add(point9);
            add(point10);
            add(point11);
            add(point12);
            add(point13);
            add(point14);
            add(point15);
        }
    };

    static ArrayList<Integer> m1 = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m2 = new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m3 = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m4 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0));
    static ArrayList<Integer> m5 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m6 = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1));
    static ArrayList<Integer> m7 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1));
    static ArrayList<Integer> m8 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m9 = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0));
    static ArrayList<Integer> m10 = new ArrayList<>(Arrays.asList(1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1));
    static ArrayList<Integer> m11 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1));
    static ArrayList<Integer> m12 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1));
    static ArrayList<Integer> m13 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1));
    static ArrayList<Integer> m14 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1));
    static ArrayList<Integer> m15 = new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0));

    static ArrayList<ArrayList<Integer>> matrix = new ArrayList<>() {
        {
            add(m1);
            add(m2);
            add(m3);
            add(m4);
            add(m5);
            add(m6);
            add(m7);
            add(m8);
            add(m9);
            add(m10);
            add(m11);
            add(m12);
            add(m13);
            add(m14);
            add(m15);
        }
    };

    public static void main(String args[]) {
        long start;
        long end;
        double time;
        int nodos = 15;

        start = System.currentTimeMillis();
        System.out.println("TRIANGLE (area) = " + solution(nodos, 2, matrix, 0));
        end = System.currentTimeMillis();
        time = (double) ((end - start));
        System.out.println("Time = " + time/1000 + "seg");
        System.out.println("---------------------");

        start = System.currentTimeMillis();
        System.out.println("QUADRILATERAL (area) = " + solution(nodos, 3, matrix, 0));
        end = System.currentTimeMillis();
        time = (double) ((end - start));
        System.out.println("Time = " + time/1000 + "seg");
        System.out.println("---------------------");

        start = System.currentTimeMillis();
        System.out.println("PENTAGON (area) = " + solution(nodos, 4, matrix, 0));
        end = System.currentTimeMillis();
        time = (double) ((end - start));
        System.out.println("Time = " + time/1000 + "seg");
        System.out.println("---------------------");

        start = System.currentTimeMillis();
        System.out.println("HEXAGON (area) = " + solution(nodos, 5, matrix, 0));
        end = System.currentTimeMillis();
        time = (double) ((end - start));
        System.out.println("Time = " + time/1000 + "seg");
        System.out.println("---------------------");
    }

    static ArrayList<ArrayList<Integer>> edges(int nodo1, int nodo2, int distance, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> solution = new ArrayList<>();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int last;
        edges.add(new ArrayList<>());
        edges.get(0).add(nodo1);
        if (matrix.get(nodo1 - 1).get(nodo2 - 1) == 1) {
            for (int i = 0; i < distance; i++) {
                ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
                for (int k = 0; k < edges.size(); k++) {
                    last = edges.get(k).get(i);
                    if (last != nodo2) {
                        for (int j = 1; j < matrix.size() + 1; j++) {
                            if (matrix.get(last - 1).get(j - 1) == 1) {
                                if (!edges.get(k).contains(j)) {
                                    edges.get(k).add(j);
                                    temp.add((ArrayList<Integer>) edges.get(k).clone());
                                    edges.get(k).remove(edges.get(k).size() - 1);
                                }
                            }
                        }
                    }
                }
                edges.clear();
                edges.addAll(temp);
            }
            for (int k = 0; k < edges.size(); k++) {
                if (edges.get(k).get(distance) == nodo2) {
                    solution.add(edges.get(k));
                }
            }
        }
        return solution;
    }

    static ArrayList<ArrayList<Integer>> sides(int nodos, int distance, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> sides = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aux;
        for (int i = 0; i < nodos - 1; i++) {
            for (int j = i + 1; j < nodos + 1; j++) {
                aux = edges(i + 1, j, distance, matrix);
                if (!aux.isEmpty()) {
                    sides = (ArrayList<ArrayList<Integer>>) union(aux, sides);
                }
            }
        }
        return sides;
    }

    static int aligned(ArrayList<ArrayList<Integer>> punt, ArrayList<Integer> camino) {
        ArrayList<Integer> cam = new ArrayList<>();
        int alig = -1;
        cam.addAll((ArrayList<Integer>) camino.clone());
        cam.add(camino.get(0));
        cam.add(camino.get(1));
        for (int i = 0; i < camino.size(); i++) {
            alig = punt.get(cam.get(i) - 1).get(0) * (punt.get(cam.get(i + 1) - 1).get(1) - punt.get(cam.get(i + 2) - 1).get(1))
                    + punt.get(cam.get(i + 1) - 1).get(0) * (punt.get(cam.get(i + 2) - 1).get(1) - punt.get(cam.get(i) - 1).get(1))
                    + punt.get(cam.get(i + 2) - 1).get(0) * (punt.get(cam.get(i) - 1).get(1) - punt.get(cam.get(i + 1) - 1).get(1));
            if (alig == 0) {
                break;
            }
        }
        return alig;
    }

    static int direction(ArrayList<Integer> p, ArrayList<Integer> q, ArrayList<Integer> r) {
        int dire;
        dire = (q.get(0) - p.get(0)) * (r.get(1) - p.get(1)) - (r.get(0) - p.get(0)) * (q.get(1) - p.get(1));
        return dire;
    }

    static boolean alignedp(ArrayList<Integer> p, ArrayList<Integer> q, ArrayList<Integer> r) {
        boolean alinp;
        alinp = Math.min(p.get(0), q.get(0)) <= r.get(0) && r.get(0) <= Math.max(p.get(0), q.get(0)) && Math.min(p.get(1), q.get(1)) <= r.get(1) && r.get(1) <= Math.max(p.get(1), q.get(1));
        return alinp;
    }

    static boolean intersection(ArrayList<ArrayList<Integer>> l1, ArrayList<ArrayList<Integer>> l2) {
        boolean inter = false;
        ArrayList<Integer> p1 = new ArrayList<>(l1.get(0));
        ArrayList<Integer> p2 = new ArrayList<>(l1.get(1));
        ArrayList<Integer> p3 = new ArrayList<>(l2.get(0));
        ArrayList<Integer> p4 = new ArrayList<>(l2.get(1));
        int d1 = direction(p3, p4, p1);
        int d2 = direction(p3, p4, p2);
        int d3 = direction(p1, p2, p3);
        int d4 = direction(p1, p2, p4);
        if ((p1.get(0) != p3.get(0) || p1.get(1) != p3.get(1)) &&
                (p1.get(0) != p4.get(0) || p1.get(1) != p4.get(1)) &&
                (p2.get(0) != p3.get(0) || p2.get(1) != p3.get(1)) &&
                (p2.get(0) != p4.get(0) || p2.get(1) != p4.get(1))) {

            if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
                inter = true;
            } else {
                if (d1 == 0 && alignedp(p3, p4, p1)) {
                    inter = true;
                } else {
                    if (d2 == 0 && alignedp(p3, p4, p2)) {
                        inter = true;
                    } else {
                        if (d3 == 0 && alignedp(p1, p2, p3)) {
                            inter = true;
                        } else {
                            if (d4 == 0 && alignedp(p1, p2, p4)) {
                                inter = true;
                            }
                        }
                    }
                }
            }
        }
        return inter;
    }

    static boolean segments(ArrayList<ArrayList<Integer>> punt, ArrayList<Integer> camino) {
        ArrayList<ArrayList<ArrayList<Integer>>> lad = new ArrayList<>();
        ArrayList<ArrayList<Integer>> points;
        ArrayList<Integer> point1;
        ArrayList<Integer> point2;
        int n = camino.size();

        for (int i = 0; i < camino.size() - 1; i++) {
            point1 = new ArrayList<>();
            point1.add(punt.get(camino.get(i) - 1).get(0));
            point1.add(punt.get(camino.get(i) - 1).get(1));

            point2 = new ArrayList<>();
            point2.add(punt.get(camino.get(i + 1) - 1).get(0));
            point2.add(punt.get(camino.get(i + 1) - 1).get(1));

            points = new ArrayList<>();
            points.add(point1);
            points.add(point2);

            lad.add(points);
        }
        point1 = new ArrayList<>();
        point1.add(punt.get(camino.get(n - 1) - 1).get(0));
        point1.add(punt.get(camino.get(n - 1) - 1).get(1));

        point2 = new ArrayList<>();
        point2.add(punt.get(camino.get(0) - 1).get(0));
        point2.add(punt.get(camino.get(0) - 1).get(1));

        points = new ArrayList<>();
        points.add(point1);
        points.add(point2);

        lad.add(points);

        boolean seg = false;
        int m = lad.size();

        for (int i = 0; i < m - 1; i++) {
            if (seg) {
                break;
            }
            for (int j = i; j < m; j++) {
                seg = intersection(lad.get(i), lad.get(j));
                if (seg) {
                    break;
                }
            }
        }
        return seg;
    }

    static ArrayList<ArrayList<Integer>> polygons(int nodos, int distance, ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> sides;
        ArrayList<ArrayList<Integer>> polygons = new ArrayList<>();
        sides = sides(nodos, distance, matrix);

        int alig;
        boolean seg;
        for (int i = 0; i < sides.size(); i++) {
            alig = aligned(points, sides.get(i));
            seg = segments(points, sides.get(i));
            if (alig != 0 && !seg) {
                polygons.add((ArrayList<Integer>) sides.get(i).clone());
            }
        }
        return polygons;
    }

    static double function(ArrayList<Integer> polygon, int fun) {
        int n = polygon.size();
        double function = 0;
        if (fun == 0) {
            for (int i = 1; i < n; i++) {
                function = function + ((points.get(polygon.get(i - 1) - 1).get(0) * points.get(polygon.get(i) - 1).get(1))
                        - (points.get(polygon.get(i) - 1).get(0) * points.get(polygon.get(i - 1) - 1).get(1)));

            }
            function = function
                    + ((points.get(polygon.get(n - 1) - 1).get(0) * points.get(polygon.get(0) - 1).get(1)) - (points.get(polygon.get(0) - 1).get(0) * points.get(polygon.get(n - 1) - 1).get(1)));
            function = Math.abs(0.5 * function);
        }
        if (fun == 1) {
            for (int i = 1; i < n; i++) {
                function = (function + Math.sqrt(Math.pow(points.get(polygon.get(i - 1) - 1).get(1) - points.get(polygon.get(i) - 1).get(1), 2)
                        + Math.pow(points.get(polygon.get(i - 1) - 1).get(0) - points.get(polygon.get(i) - 1).get(0), 2)));
            }
            function = (function + Math.sqrt(Math.pow(points.get(polygon.get(n - 1) - 1).get(1) - points.get(polygon.get(0) - 1).get(1), 2)
                    + Math.pow(points.get(polygon.get(n - 1) - 1).get(0) - points.get(polygon.get(0) - 1).get(0), 2)));
            function = Math.round(function * 10000000000.0) / 10000000000.0;
        }
        return function;
    }

    static ArrayList<ArrayList<Integer>> update(ArrayList<ArrayList<Integer>> polygons, int fun) {
        ArrayList<ArrayList<Integer>> upd = new ArrayList<>();
        double maxi = 0;
        double f;
        for (int i = 0; i < polygons.size(); i++) {
            f = function(polygons.get(i), fun);
            if (f >= maxi) {
                upd.add(polygons.get(i));
            }
            if (f > maxi) {
                upd = new ArrayList<>();
                maxi = f;
                upd.add(polygons.get(i));
            }
        }
        return upd;
    }

    static ArrayList<ArrayList<Integer>> duplicates(ArrayList<ArrayList<Integer>> polygons) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> aux = new ArrayList<>();
        ArrayList<Integer> aux2 = new ArrayList<>();
        for (int i = 0; i < polygons.size(); i++) {
            aux2.addAll((ArrayList<Integer>) polygons.get(i).clone());
            Collections.sort(aux2);
            if (!aux.contains(aux2)) {
                res.add((ArrayList<Integer>) polygons.get(i).clone());
                aux.add((ArrayList<Integer>) aux2.clone());
            }
            aux2.clear();
        }
        return res;
    }

    static ArrayList<ArrayList<Integer>> solution(int nodos, int distance, ArrayList<ArrayList<Integer>> matrix, int fun) {
        ArrayList<ArrayList<Integer>> solution;
        ArrayList<ArrayList<Integer>> polygons;
        ArrayList<ArrayList<Integer>> noduplic;

        polygons = (ArrayList<ArrayList<Integer>>) polygons(nodos, distance, matrix).clone();
        noduplic = (ArrayList<ArrayList<Integer>>) duplicates(polygons).clone();
        solution = (ArrayList<ArrayList<Integer>>) update(noduplic, fun).clone();
        return solution;
    }

    static public <T> List<T> union(ArrayList<T> list1, ArrayList<T> list2) {
        Set<T> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }
}