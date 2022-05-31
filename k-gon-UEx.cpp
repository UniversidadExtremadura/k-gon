    // UNIVERSITY OF EXTREMADURA
	// MEDIA ENGINEERING GROUP
	// CONTACT: andresc@unex.es
	
    #include <iostream>
    #include <algorithm>
    #include <iostream>
    #include <list>
    #include <vector>
    #include <cmath>
    #include <math.h>
    #include <sstream>
    #include <iomanip>

    using namespace std;
    vector<vector<int>> puntos;
    vector<vector<int>> A;


    void imprimirsolucion(vector<vector<int>> v){
        cout <<"Inicio Solucion "<< endl;
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
        cout <<"Fin Solucion "<< endl;
    }

    void imprimirvv(vector<vector<int>> v,string mensaje){
        cout << mensaje<<" inicio "<< endl;
         cout <<"{";
        for (int i = 0; i < v.size(); i++) {
            cout <<"{";
            for (int j = 0; j < v[i].size(); j++) {
                cout <<" "<<v[i][j];
            }
            cout <<"}";
        }
         cout <<"}" <<endl;
        cout << mensaje<<" fin "<< endl;
    }

    void imprimirv(vector<int> v,string mensaje){
        cout << mensaje<<" inicio "<< endl;
        for (int i = 0; i < v.size(); i++) {
            cout <<"{";
            cout <<v[i];
            cout <<"}";
        }
        cout <<""<<endl;
        cout << mensaje<<" fin "<< endl;
    }

    bool dentro(vector<int> v,int j){
        bool encontrado=false;
        for (int i = 0; i < v.size(); i++) {
            if(v[i]==j){
                encontrado=true;
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

    vector<vector<int>> aristas(int nodo1, int nodo2, int distancia, vector<vector<int>> matriz) {
		vector<vector<int>> solucion;
		vector<vector<int>> aristas;
		int ultimo;
		aristas.push_back({});
		aristas[0].push_back(nodo1);

		if (matriz[nodo1 - 1][nodo2 - 1] == 1) {
			for (int i = 0; i < distancia; i++) {
				vector<vector<int>> temp;
				for (int k = 0; k < aristas.size(); k++) {
					ultimo = aristas[k][i];
					if (ultimo != nodo2) {
						for (int j = 1; j < matriz.size() + 1; j++) {
							if (matriz[ultimo - 1][j - 1] == 1) {
                                if(dentro(aristas[k],j)==false){
									aristas[k].push_back(j);
									temp.push_back(aristas[k]);
									aristas[k].pop_back();
								}
							}
						}
					}
				}
				aristas.clear();
				aristas=temp;
			}

			for (int k = 0; k < aristas.size(); k++) {
				if (aristas[k][distancia] == nodo2) {
					solucion.push_back(aristas[k]);
				}
			}
		}
		return solucion;
	}

	vector<vector<int>> ladosm(int nodos, int distancia, vector<vector<int>> matriz) {
		vector<vector<int>> lados;
		vector<vector<int>> aux;
		for (int i = 0; i < nodos - 1; i++) {
			for (int j = i + 1; j < nodos + 1; j++) {
				aux.clear();
				aux = aristas(i + 1, j, distancia, matriz);
				if (!aux.empty()) {
                    for(int x=0;x < aux.size();x++){
                        if(!dentrov(lados,aux[x])){
                            lados.push_back(aux[x]);
                        }
                    }
				}
			}
		}
		return lados;
	}

    int alineadosc( vector<vector<int>> punt, vector<int> camino) {
		vector<int> cam ;
		int alig = -1;
		cam=camino;
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

	int direccion(vector<int> p, vector<int> q, vector<int> r) {
		int dire;
		 dire=(q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1]- p[1]);
		return dire;
	}
    //devuelve 1 para true y 0 para false
	bool alineadosp(vector<int> p, vector<int> q, vector<int> r) {
		bool alinp;
        if(min(p[0], q[0]) <= r[0] && r[0] <= max(p[0], q[0]) && min(p[1], q[1]) <= r[1] && r[1] <= max(p[1], q[1])){
			alinp = true;
		} else {
			alinp = false;
		}
		return alinp;
	}

    //devuelve 1 para true y 0 para false
	bool interseccion(vector<vector<int>> l1, vector<vector<int>> l2) {
		bool inter = false;
		vector<int> p1 = l1[0];
		vector<int> p2 = l1[1];
		vector<int> p3 = l2[0];
		vector<int> p4 = l2[1];
		int d1 = direccion(p3, p4, p1);
		int d2 = direccion(p3, p4, p2);
		int d3 = direccion(p1, p2, p3);
		int d4 = direccion(p1, p2, p4);
		if ((p1[0] != p3[0] || p1[1] != p3[1]) &&

				(p1[0] != p4[0] || p1[1] != p4[1]) &&

				(p2[0] != p3[0] || p2[1] != p3[1]) &&

				(p2[0] != p4[0] || p2[1] != p4[1])) {

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

    bool segmentos(vector<vector<int>> punt, vector<int> camino) {
		vector<vector<vector<int>>> lad;
		vector<vector<int>> puntos;
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

			puntos.clear();
			puntos.push_back(punto1);
			puntos.push_back(punto2);

			lad.push_back(puntos);
		}
		punto1.clear();
		punto1.push_back(punt[camino[n - 1] - 1][0]);
		punto1.push_back(punt[camino[n - 1] - 1][1]);

		punto2.clear();
		punto2.push_back(punt[camino[0] - 1][0]);
		punto2.push_back(punt[camino[0] - 1][1]);

		puntos.clear();
		puntos.push_back(punto1);
		puntos.push_back(punto2);

		lad.push_back(puntos);

		bool seg = false;
		int m = lad.size();

		for (int i = 0; i < m - 1; i++) {
			if (seg == true) {
				break;
			}
			for (int j = i; j < m; j++) {
				seg = interseccion(lad[i], lad[j]);
				if (seg == true) {
					break;
				}
			}
		}
		return seg;
	}

	vector<vector<int>> poligonosm(int nodos, int distancia, vector<vector<int>> matriz) {
		vector<vector<int>> lados;
		vector<vector<int>> poligonos;
		lados = ladosm(nodos,distancia,matriz);
		int alig = 0;
		bool seg = true;
		for (int i = 0; i < lados.size(); i++) {
			alig = alineadosc(puntos, lados[i]);
			seg = segmentos(puntos, lados[i]);
			if (alig != 0 && seg == false) {
				poligonos.push_back(lados[i]);
			}
		}
		return poligonos;
	}

	double funcion(vector<int> poligono, int fun) {
		int n = poligono.size();
		double funcion = 0;
		if (fun == 0) {
			for (int i = 1; i < n; i++) {
				funcion = funcion + ((puntos[poligono[i - 1] - 1][0] * puntos[poligono[i] - 1][1])
						- (puntos[poligono[i] - 1][0] * puntos[poligono[i - 1] - 1][1]));
			}
			funcion = funcion
					+ ((puntos[poligono[n - 1] - 1][0] * puntos[poligono[0] - 1][1]) - (puntos[poligono[0] - 1][0] * puntos[poligono[n - 1] - 1][1]));
			funcion = abs(0.5 * funcion);
		}
		if (fun == 1) {
			for (int i = 1; i < n; i++) {
				funcion = (funcion + sqrt(pow(puntos[poligono[i - 1] - 1][1] - puntos[poligono[i] - 1][1], 2)
						+ pow(puntos[poligono[i - 1] - 1][0] - puntos[poligono[i] - 1][0], 2)));
			}
			funcion = (funcion + sqrt(pow(puntos[poligono[n - 1] - 1][1] - puntos[poligono[0] - 1][1], 2)
					+ pow(puntos[poligono[n - 1] - 1][0] - puntos[poligono[0] - 1][0], 2)));

			funcion= floorf(funcion * 10000000000) / 10000000000;
		}
		return funcion;
	}

	vector<vector<int>> update(vector<vector<int>> poligonos, int fun) {
		vector<vector<int>> upd;
		double maxi = 0;
		double f = 0;
		for (int i = 0; i < poligonos.size(); i++) {
			f = funcion(poligonos[i], fun);
			if (f >= maxi) {
				upd.push_back(poligonos[i]);
			}
			if (f > maxi) {
				upd.clear();
				maxi = f;
				upd.push_back(poligonos[i]);
			}
		}
		return upd;
	}

	vector<vector<int>> duplicados(vector<vector<int>> poligonos) {
		vector<vector<int>> respuesta;
		vector<vector<int>> aux;
		vector<int> aux2;
		for (int i = 0; i < poligonos.size(); i++) {
			aux2=poligonos[i];
			sort(aux2.begin(), aux2.end());
            if(!dentrov(aux,aux2)){
				respuesta.push_back(poligonos[i]);
				aux.push_back(aux2);
			}
			aux2.clear();
		}
		return respuesta;
	}

	vector<vector<int>> solucionm(int nodos, int distancia, vector<vector<int>> matriz, int fun) {
		vector<vector<int>> solucion;
		vector<vector<int>> poligonos;
		vector<vector<int>> noduplic;

		poligonos = poligonosm(nodos, distancia, matriz);
		noduplic = duplicados(poligonos);
		solucion = update(noduplic, fun);
		return solucion;
	}

    int main() {

        cout << "K-GON (UNIVERSITY OF EXTREMADURA)" << endl;

        puntos = {{2, 6}, {4, 6}, {6, 8}, {8, 6}, {6, 4}, {8, 2}, {6, 0},{4, 2}, {4, 0}, {0, 4}, {2, 2}, {6, 6}, {2, 4}, {4, 4}, {6, 2}};
        A = {{0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
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


        imprimirsolucion(solucionm(15,3,A,0));
        imprimirsolucion(solucionm(15,3,A,1));
        return 0;
    }


