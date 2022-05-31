import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class TFGEntrega1 {

	static ArrayList<Integer> punto1 = new ArrayList<Integer>(Arrays.asList(2, 6));
	static ArrayList<Integer> punto2 = new ArrayList<Integer>(Arrays.asList(4, 6));
	static ArrayList<Integer> punto3 = new ArrayList<Integer>(Arrays.asList(6, 8));
	static ArrayList<Integer> punto4 = new ArrayList<Integer>(Arrays.asList(8, 6));
	static ArrayList<Integer> punto5 = new ArrayList<Integer>(Arrays.asList(6, 4));
	static ArrayList<Integer> punto6 = new ArrayList<Integer>(Arrays.asList(8, 2));
	static ArrayList<Integer> punto7 = new ArrayList<Integer>(Arrays.asList(6, 0));
	static ArrayList<Integer> punto8 = new ArrayList<Integer>(Arrays.asList(4, 2));
	static ArrayList<Integer> punto9 = new ArrayList<Integer>(Arrays.asList(4, 0));
	static ArrayList<Integer> punto10 = new ArrayList<Integer>(Arrays.asList(0, 4));
	static ArrayList<Integer> punto11 = new ArrayList<Integer>(Arrays.asList(2, 2));
	static ArrayList<Integer> punto12 = new ArrayList<Integer>(Arrays.asList(6, 6));
	static ArrayList<Integer> punto13 = new ArrayList<Integer>(Arrays.asList(2, 4));
	static ArrayList<Integer> punto14 = new ArrayList<Integer>(Arrays.asList(4, 4));
	static ArrayList<Integer> punto15 = new ArrayList<Integer>(Arrays.asList(6, 2));

	static ArrayList<ArrayList<Integer>> puntos = new ArrayList<ArrayList<Integer>>() {
		{
			add(punto1);
			add(punto2);
			add(punto3);
			add(punto4);
			add(punto5);
			add(punto6);
			add(punto7);
			add(punto8);
			add(punto9);
			add(punto10);
			add(punto11);
			add(punto12);
			add(punto13);
			add(punto14);
			add(punto15);
		}
	};

	static ArrayList<Integer> m1 = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m2 = new ArrayList<Integer>(Arrays.asList(1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m3 = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m4 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0));
	static ArrayList<Integer> m5 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m6 = new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1));
	static ArrayList<Integer> m7 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1));
	static ArrayList<Integer> m8 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m9 = new ArrayList<Integer>(Arrays.asList(1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0));
	static ArrayList<Integer> m10 = new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1));
	static ArrayList<Integer> m11 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1));
	static ArrayList<Integer> m12 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1));
	static ArrayList<Integer> m13 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1));
	static ArrayList<Integer> m14 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1));
	static ArrayList<Integer> m15 = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0));

	static ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>() {
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
		System.out.println("TFG");
		long inicio;
		long fin;
		double tiempo;
		// zona de ejecucion
//		inicio = System.currentTimeMillis();
		System.out.println(solucion(15, 4, A, 1));
//		fin = System.currentTimeMillis();
//		tiempo= (double) ((fin - inicio));
//		System.out.println(tiempo+ " milisegundos");
//		
//		inicio = System.currentTimeMillis();
//		System.out.println(solucion(15, 7, A, 1));
//		fin = System.currentTimeMillis();
//		tiempo = (double) ((fin - inicio));
//		System.out.println(tiempo+ " milisegundos");
		
//		System.out.println(lados(15, 2, A).size());

	}

	static ArrayList<ArrayList<Integer>> aristas(int nodo1, int nodo2, int distancia, ArrayList<ArrayList<Integer>> matriz) {
		ArrayList<ArrayList<Integer>> solucion = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> aristas = new ArrayList<ArrayList<Integer>>();
		int ultimo;
		aristas.add(new ArrayList<Integer>());
		aristas.get(0).add(nodo1);
		if (matriz.get(nodo1 - 1).get(nodo2 - 1) == 1) {
			for (int i = 0; i < distancia; i++) {
				ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
				for (int k = 0; k < aristas.size(); k++) {
					ultimo = aristas.get(k).get(i);
					if (ultimo != nodo2) {
						for (int j = 1; j < matriz.size() + 1; j++) {
							if (matriz.get(ultimo - 1).get(j - 1) == 1) {
								if (!aristas.get(k).contains(j)) {
									aristas.get(k).add(j);
									temp.add((ArrayList<Integer>) aristas.get(k).clone());
									aristas.get(k).remove(aristas.get(k).size() - 1);
								}
							}
						}
					}
				}
				aristas.clear();
				aristas.addAll(temp);
			}
			for (int k = 0; k < aristas.size(); k++) {
				if (aristas.get(k).get(distancia) == nodo2) {
					solucion.add(aristas.get(k));
				}
			}
		}
		return solucion;
	}

	static ArrayList<ArrayList<Integer>> lados(int nodos, int distancia, ArrayList<ArrayList<Integer>> matriz) {
		ArrayList<ArrayList<Integer>> lados = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < nodos - 1; i++) {
			for (int j = i + 1; j < nodos + 1; j++) {
				aux = new ArrayList<ArrayList<Integer>>();
				aux = aristas(i + 1, j, distancia, matriz);
				if (!aux.isEmpty()) {
					lados = (ArrayList<ArrayList<Integer>>) union(aux, lados);
				}
			}
		}
		return lados;
	}

	static int alineadosc(ArrayList<ArrayList<Integer>> punt, ArrayList<Integer> camino) {
		ArrayList<Integer> cam = new ArrayList<Integer>();
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

	static int direccion(ArrayList<Integer> p, ArrayList<Integer> q, ArrayList<Integer> r) {
		int dire;
		dire = (q.get(0) - p.get(0)) * (r.get(1) - p.get(1)) - (r.get(0) - p.get(0)) * (q.get(1) - p.get(1));
		return dire;
	}

	static boolean alineadosp(ArrayList<Integer> p, ArrayList<Integer> q, ArrayList<Integer> r) {
		boolean alinp;
		if (Math.min(p.get(0), q.get(0)) <= r.get(0) && r.get(0) <= Math.max(p.get(0), q.get(0)) && Math.min(p.get(1), q.get(1)) <= r.get(1) && r.get(1) <= Math.max(p.get(1), q.get(1))) {
			alinp = true;
		} else {
			alinp = false;
		}
		return alinp;
	}

	static boolean interseccion(ArrayList<ArrayList<Integer>> l1, ArrayList<ArrayList<Integer>> l2) {
		boolean inter = false;
		ArrayList<Integer> p1 = new ArrayList<Integer>(l1.get(0));
		ArrayList<Integer> p2 = new ArrayList<Integer>(l1.get(1));
		ArrayList<Integer> p3 = new ArrayList<Integer>(l2.get(0));
		ArrayList<Integer> p4 = new ArrayList<Integer>(l2.get(1));
		int d1 = direccion(p3, p4, p1);
		int d2 = direccion(p3, p4, p2);
		int d3 = direccion(p1, p2, p3);
		int d4 = direccion(p1, p2, p4);
		if ((p1.get(0) != p3.get(0) || p1.get(1) != p3.get(1)) &&

				(p1.get(0) != p4.get(0) || p1.get(1) != p4.get(1)) &&

				(p2.get(0) != p3.get(0) || p2.get(1) != p3.get(1)) &&

				(p2.get(0) != p4.get(0) || p2.get(1) != p4.get(1))) {

			if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {

				inter = true;
			} else {
				if (d1 == 0 && alineadosp(p3, p4, p1)) {
					inter = true;
				} else {
					if (d2 == 0 && alineadosp(p3, p4, p2)) {
						inter = true;
					} else {
						if (d3 == 0 && alineadosp(p1, p2, p3)) {
							inter = true;
						} else {
							if (d4 == 0 && alineadosp(p1, p2, p4)) {
								inter = true;
							}
						}
					}
				}
			}
		} else {
			inter = false;
		}
		return inter;
	}

	static boolean segmentos(ArrayList<ArrayList<Integer>> punt, ArrayList<Integer> camino) {
		ArrayList<ArrayList<ArrayList<Integer>>> lad = new ArrayList<ArrayList<ArrayList<Integer>>>();
		ArrayList<ArrayList<Integer>> puntos = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> punto1 = new ArrayList<Integer>();
		ArrayList<Integer> punto2 = new ArrayList<Integer>();
		int n = camino.size();

		for (int i = 0; i < camino.size() - 1; i++) {
			punto1 = new ArrayList<Integer>();
			punto1.add(punt.get(camino.get(i) - 1).get(0));
			punto1.add(punt.get(camino.get(i) - 1).get(1));

			punto2 = new ArrayList<Integer>();
			punto2.add(punt.get(camino.get(i + 1) - 1).get(0));
			punto2.add(punt.get(camino.get(i + 1) - 1).get(1));

			puntos = new ArrayList<ArrayList<Integer>>();
			puntos.add(punto1);
			puntos.add(punto2);

			lad.add(puntos);
		}
		punto1 = new ArrayList<Integer>();
		punto1.add(punt.get(camino.get(n - 1) - 1).get(0));
		punto1.add(punt.get(camino.get(n - 1) - 1).get(1));

		punto2 = new ArrayList<Integer>();
		punto2.add(punt.get(camino.get(0) - 1).get(0));
		punto2.add(punt.get(camino.get(0) - 1).get(1));

		puntos = new ArrayList<ArrayList<Integer>>();
		puntos.add(punto1);
		puntos.add(punto2);

		lad.add(puntos);

		boolean seg = false;
		int m = lad.size();

		for (int i = 0; i < m - 1; i++) {
			if (seg == true) {
				break;
			}
			for (int j = i; j < m; j++) {
				seg = interseccion(lad.get(i), lad.get(j));
				if (seg == true) {
					break;
				}
			}
		}
		return seg;
	}

	static ArrayList<ArrayList<Integer>> poligonos(int nodos, int distancia, ArrayList<ArrayList<Integer>> matriz) {
		ArrayList<ArrayList<Integer>> lados = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> poligonos = new ArrayList<ArrayList<Integer>>();
		lados = lados(nodos, distancia, matriz);

		int alig = 0;
		boolean seg = true;
		for (int i = 0; i < lados.size(); i++) {
			alig = alineadosc(puntos, lados.get(i));
			seg = segmentos(puntos, lados.get(i));
			if (alig != 0 && seg == false) {
				poligonos.add((ArrayList<Integer>) lados.get(i).clone());
			}
		}

		return poligonos;
	}

	static double funcion(ArrayList<Integer> poligono, int fun) {
		int n = poligono.size();
		double funcion = 0;
		if (fun == 0) {
			for (int i = 1; i < n; i++) {
				funcion = funcion + ((puntos.get(poligono.get(i - 1) - 1).get(0) * puntos.get(poligono.get(i) - 1).get(1))
						- (puntos.get(poligono.get(i) - 1).get(0) * puntos.get(poligono.get(i - 1) - 1).get(1)));

			}
			funcion = funcion
					+ ((puntos.get(poligono.get(n - 1) - 1).get(0) * puntos.get(poligono.get(0) - 1).get(1)) - (puntos.get(poligono.get(0) - 1).get(0) * puntos.get(poligono.get(n - 1) - 1).get(1)));
			funcion = Math.abs(0.5 * funcion);
		}
		if (fun == 1) {
			for (int i = 1; i < n; i++) {
				funcion = (funcion + Math.sqrt(Math.pow(puntos.get(poligono.get(i - 1) - 1).get(1) - puntos.get(poligono.get(i) - 1).get(1), 2)
						+ Math.pow(puntos.get(poligono.get(i - 1) - 1).get(0) - puntos.get(poligono.get(i) - 1).get(0), 2)));
			}
			funcion = (funcion + Math.sqrt(Math.pow(puntos.get(poligono.get(n - 1) - 1).get(1) - puntos.get(poligono.get(0) - 1).get(1), 2)
					+ Math.pow(puntos.get(poligono.get(n - 1) - 1).get(0) - puntos.get(poligono.get(0) - 1).get(0), 2)));
			funcion = Math.round(funcion * 10000000000.0) / 10000000000.0;
		}
		return funcion;
	}

	static ArrayList<ArrayList<Integer>> update(ArrayList<ArrayList<Integer>> poligonos, int fun) {
		ArrayList<ArrayList<Integer>> upd = new ArrayList<ArrayList<Integer>>();
		double maxi = 0;
		double f = 0;
		for (int i = 0; i < poligonos.size(); i++) {
			f = funcion(poligonos.get(i), fun);
			if (f >= maxi) {
				upd.add(poligonos.get(i));
			}
			if (f > maxi) {
				upd = new ArrayList<ArrayList<Integer>>();
				maxi = f;
				upd.add(poligonos.get(i));
			}
		}
		return upd;
	}

	static ArrayList<ArrayList<Integer>> duplicados(ArrayList<ArrayList<Integer>> poligonos) {
		ArrayList<ArrayList<Integer>> respuesta = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> aux2 = new ArrayList<Integer>();
		for (int i = 0; i < poligonos.size(); i++) {
			aux2.addAll((ArrayList<Integer>) poligonos.get(i).clone());
			Collections.sort(aux2);
			if (!aux.contains(aux2)) {
				respuesta.add((ArrayList<Integer>) poligonos.get(i).clone());
				aux.add((ArrayList<Integer>) aux2.clone());
			}
			aux2.clear();
		}
		return respuesta;
	}

	static ArrayList<ArrayList<Integer>> solucion(int nodos, int distancia, ArrayList<ArrayList<Integer>> matriz, int fun) {
		ArrayList<ArrayList<Integer>> solucion = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> poligonos = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> noduplic = new ArrayList<ArrayList<Integer>>();

		poligonos = (ArrayList<ArrayList<Integer>>) poligonos(nodos, distancia, matriz).clone();
		noduplic = (ArrayList<ArrayList<Integer>>) duplicados(poligonos).clone();
		solucion = (ArrayList<ArrayList<Integer>>) update(noduplic, fun).clone();
		return solucion;
	}

	// Funciones auxiliares
	static public <T> List<T> union(ArrayList<T> list1, ArrayList<T> list2) {
		Set<T> set = new HashSet<T>();
		set.addAll(list1);
		set.addAll(list2);
		return new ArrayList<T>(set);
	}

}
