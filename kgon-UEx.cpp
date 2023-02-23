// UNIVERSITY OF EXTREMADURA
// MEDIA ENGINEERING GROUP
// CONTACT: andresc@unex.es

    #include <iostream>
    #include <algorithm>
    #include <list>
    #include <vector>
    #include <cmath>

    using namespace std;
    vector<vector<int>> points;
    vector<vector<int>> matrix;

    void imprimirsolucion(vector<vector<int>> v){
        cout <<"Start solution "<< endl;
         cout <<"{";
        for (int i = 0; i < v.size(); i++) {
            cout <<"{";
            for (int j = 0; j < v[i].size(); j++) {
                cout <<" "<<v[i][j];
            }
            cout <<" ";
            cout <<"}";
        }
         cout <<"}" <<endl;
        cout <<"End solution "<< endl;
    }

    bool dentro(vector<int> v,int j){
        bool encontrado=false;
        for (int i = 0; i < v.size(); i++) {
            if(v[i]==j){
                encontrado = true;
            }
        }
        return encontrado;
    }
    bool dentrov(vector<vector<int>> v,vector<int> j){
        bool encontrado=false;
        for (int i = 0; i < v.size(); i++) {
                if(v[i]==j){
                    encontrado=true;
                }
        }
        return encontrado;
    }

    vector<vector<int>> edges(int nodo1, int nodo2, int distance, vector<vector<int>> matrix) {
		vector<vector<int>> solution;
		vector<vector<int>> edges;
		int ultimo;
        edges.push_back({});
        edges[0].push_back(nodo1);

		if (matrix[nodo1 - 1][nodo2 - 1] == 1) {
			for (int i = 0; i < distance; i++) {
				vector<vector<int>> temp;
				for (int k = 0; k < edges.size(); k++) {
					ultimo = edges[k][i];
					if (ultimo != nodo2) {
						for (int j = 1; j < matrix.size() + 1; j++) {
							if (matrix[ultimo - 1][j - 1] == 1) {
                                if(!dentro(edges[k], j)){
                                    edges[k].push_back(j);
									temp.push_back(edges[k]);
                                    edges[k].pop_back();
								}
							}
						}
					}
				}
                edges.clear();
                edges=temp;
			}

			for (int k = 0; k < edges.size(); k++) {
				if (edges[k][distance] == nodo2) {
                    solution.push_back(edges[k]);
				}
			}
		}
		return solution;
	}

	vector<vector<int>> Sides(int nodos, int distance, vector<vector<int>> matrix) {
		vector<vector<int>> sides;
		vector<vector<int>> aux;
		for (int i = 0; i < nodos - 1; i++) {
			for (int j = i + 1; j < nodos + 1; j++) {
				aux.clear();
				aux = edges(i + 1, j, distance, matrix);
				if (!aux.empty()) {
                    for(int x=0;x < aux.size();x++){
                        if(!dentrov(sides,aux[x])){
                            sides.push_back(aux[x]);
                        }
                    }
				}
			}
		}
		return sides;
	}

    int aligned(vector<vector<int>> punt, vector<int> camino) {
		vector<int> cam ;
		int alig = -1;
		cam = camino;
		cam.push_back(camino[0]);
		cam.push_back(camino[1]);
		for (int i = 0; i < camino.size(); i++) {
			alig =punt[cam[i]-1][0] * (punt[cam[i+1]-1][1]-punt[cam[i+2]-1][1])+punt[cam[i+1]-1][0] * (punt[cam[i+2]-1][1]-punt[cam[i]-1][1]) + punt[cam[i+2]-1][0] * (punt[cam[i]-1][1]-punt[cam[i+1]-1][1]);
			if (alig == 0) {
				break;
			}
		}
		return alig;
	}

	int direction(vector<int> p, vector<int> q, vector<int> r) {
		int dire;
		 dire=(q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1]- p[1]);
		return dire;
	}

	bool alignedp(vector<int> p, vector<int> q, vector<int> r) {
		bool alinp;
        if(min(p[0], q[0]) <= r[0] && r[0] <= max(p[0], q[0]) && min(p[1], q[1]) <= r[1] && r[1] <= max(p[1], q[1])){
			alinp = true;
		} else {
			alinp = false;
		}
		return alinp;
	}

    bool intersection(vector<vector<int>> l1, vector<vector<int>> l2) {
		bool inter = false;
		vector<int> p1 = l1[0];
		vector<int> p2 = l1[1];
		vector<int> p3 = l2[0];
		vector<int> p4 = l2[1];
		int d1 = direction(p3, p4, p1);
		int d2 = direction(p3, p4, p2);
		int d3 = direction(p1, p2, p3);
		int d4 = direction(p1, p2, p4);
		if ((p1[0] != p3[0] || p1[1] != p3[1]) &&
				(p1[0] != p4[0] || p1[1] != p4[1]) &&
				(p2[0] != p3[0] || p2[1] != p3[1]) &&
				(p2[0] != p4[0] || p2[1] != p4[1])) {
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
		} else {
			inter = false;
		}
		return inter;
	}

    bool segments(vector<vector<int>> punt, vector<int> camino) {
		vector<vector<vector<int>>> lad;
		vector<vector<int>> points;
		vector<int> punto1;
		vector<int> punto2;
		int n = camino.size();
		for (int i = 0; i < camino.size() - 1; i++) {
			punto1.clear();
			punto1.push_back(punt[camino[i] - 1][0]);
			punto1.push_back(punt[camino[i] - 1][1]);

			punto2.clear();
			punto2.push_back(punt[camino[i + 1] - 1][0]);
			punto2.push_back(punt[camino[i + 1] - 1][1]);

            points.clear();
            points.push_back(punto1);
            points.push_back(punto2);

			lad.push_back(points);
		}
		punto1.clear();
		punto1.push_back(punt[camino[n - 1] - 1][0]);
		punto1.push_back(punt[camino[n - 1] - 1][1]);

		punto2.clear();
		punto2.push_back(punt[camino[0] - 1][0]);
		punto2.push_back(punt[camino[0] - 1][1]);

        points.clear();
        points.push_back(punto1);
        points.push_back(punto2);

		lad.push_back(points);

		bool seg = false;
		int m = lad.size();

		for (int i = 0; i < m - 1; i++) {
			if (seg) {
				break;
			}
			for (int j = i; j < m; j++) {
				seg = intersection(lad[i], lad[j]);
				if (seg) {
					break;
				}
			}
		}
		return seg;
	}

	vector<vector<int>> polygons(int nodos, int distance, vector<vector<int>> matrix) {
		vector<vector<int>> sides;
		vector<vector<int>> polygons;
        sides = Sides(nodos,distance,matrix);
		int alig = 0;
		bool seg = true;
		for (int i = 0; i < sides.size(); i++) {
			alig = aligned(points, sides[i]);
			seg = segments(points, sides[i]);
			if (alig != 0 && !seg) {
                polygons.push_back(sides[i]);
			}
		}
		return polygons;
	}

	double funcion(vector<int> poligono, int fun) {
		int n = poligono.size();
		double funcion = 0;
		if (fun == 0) {
			for (int i = 1; i < n; i++) {
				funcion = funcion + ((points[poligono[i - 1] - 1][0] * points[poligono[i] - 1][1])
						- (points[poligono[i] - 1][0] * points[poligono[i - 1] - 1][1]));
			}
			funcion = funcion
					+ ((points[poligono[n - 1] - 1][0] * points[poligono[0] - 1][1]) - (points[poligono[0] - 1][0] * points[poligono[n - 1] - 1][1]));
			funcion = abs(0.5 * funcion);
		}
		if (fun == 1) {
			for (int i = 1; i < n; i++) {
				funcion = (funcion + sqrt(pow(points[poligono[i - 1] - 1][1] - points[poligono[i] - 1][1], 2)
						+ pow(points[poligono[i - 1] - 1][0] - points[poligono[i] - 1][0], 2)));
			}
			funcion = (funcion + sqrt(pow(points[poligono[n - 1] - 1][1] - points[poligono[0] - 1][1], 2)
					+ pow(points[poligono[n - 1] - 1][0] - points[poligono[0] - 1][0], 2)));

			funcion= floorf(funcion * 10000000000) / 10000000000;
		}
		return funcion;
	}

	vector<vector<int>> update(vector<vector<int>> polygons, int fun) {
		vector<vector<int>> upd;
		double maxi = 0;
		double f = 0;
		for (int i = 0; i < polygons.size(); i++) {
			f = funcion(polygons[i], fun);
			if (f >= maxi) {
				upd.push_back(polygons[i]);
			}
			if (f > maxi) {
				upd.clear();
				maxi = f;
				upd.push_back(polygons[i]);
			}
		}
		return upd;
	}

	vector<vector<int>> duplicates(vector<vector<int>> polygons) {
		vector<vector<int>> respuesta;
		vector<vector<int>> aux;
		vector<int> aux2;
		for (int i = 0; i < polygons.size(); i++) {
			aux2=polygons[i];
			sort(aux2.begin(), aux2.end());
            if(!dentrov(aux,aux2)){
				respuesta.push_back(polygons[i]);
				aux.push_back(aux2);
			}
			aux2.clear();
		}
		return respuesta;
	}

	vector<vector<int>> solution(int nodos, int distance, vector<vector<int>> matrix, int fun) {
		vector<vector<int>> sol;
		vector<vector<int>> poly;
		vector<vector<int>> noduplic;

        poly = polygons(nodos, distance, matrix);
		noduplic = duplicates(poly);
		sol = update(noduplic, fun);
		return sol;
	}

    int main() {
        cout << "K-GON (UNIVERSITY OF EXTREMADURA)" << endl;

        points = {{2, 6}, {4, 6}, {6, 8}, {8, 6}, {6, 4}, {8, 2}, {6, 0},{4, 2}, {4, 0}, {0, 4}, {2, 2}, {6, 6}, {2, 4}, {4, 4}, {6, 2}};
        matrix = {{0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
        {1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0},
        {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
        {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0}};

        int nodos = 15;
        imprimirsolucion(solution(nodos, 2, matrix, 0)); // Area
        imprimirsolucion(solution(nodos, 2, matrix, 1)); // Perimeter
        imprimirsolucion(solution(nodos, 3, matrix, 0)); // Area
        imprimirsolucion(solution(nodos, 3, matrix, 1)); // Perimeter
        imprimirsolucion(solution(nodos, 4, matrix, 0)); // Area
        imprimirsolucion(solution(nodos, 4, matrix, 1)); // Perimeter
        return 0;
    }