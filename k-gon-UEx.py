# -*- coding: utf-8 -*-
"""
Created on Wed Dec 22 17:25:16 2021

@author: ALVAROBANDO
Añado algunos comentarios para que se entienda un poco mejor el codigo aunque milagros no hago.
"""
import numpy as np
from time import time

A=[]


puntos = [[8, 10], [8, 8], [6, 6], [8, 6], [6, 4], [4, 4], [2, 2], [2, 0], [0, 2], [0, 4], [2, 6], [4, 6], [6, 8], [2, 4]];

poligono = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13];

def alineadospol(punt,p,poligono): #otro alineados
    alin=False
    lad=[]
    for i in range(0, len(poligono)):
        lad.append(poligono[i])
    lad.append(poligono[0])
    
    for i in range(0,len(lad)-1):
        if(direccion(punt[lad[i]-1],punt[lad[i+1]-1] , p) == 0):
            if(alineadosp(punt[lad[i]-1], punt[lad[i+1]-1], p)==True):
                alin=True
                break
    return alin

def angulo(u,v): #angulo entre dos vectores
    angulo=0
    if(u[0]*u[0]+u[1]*u[1]!=0):
        if(v[0]*v[0]+v[1]*v[1]!=0):
            
            det=u[0]*v[1]-u[1]*v[0]
            v1_u = u / np.linalg.norm(u) #calculos para el angulo
            v2_u = v / np.linalg.norm(v)
            if(det>0):
                angulo=np.arccos(np.clip(np.dot(v1_u, v2_u), -1.0, 1.0)) #angulo
            else:
                angulo=-np.arccos(np.clip(np.dot(v1_u, v2_u), -1.0, 1.0)) #-angulo
    return angulo

def pointin(punt,p,poligono): #punto dentro de un poligono
    if(alineadospol(punt, p, poligono)==True):
        point=True
    else:
        point=False
        n=len(poligono)
        suma=0
        for i in range(0, n-1): #funcion matematica que suma todos los angulos de los vectores resultantes del poligonoy el punto
            suma=suma+ angulo([puntos[poligono[i]-1][0]-p[0],puntos[poligono[i]-1][1]-p[1]], [puntos[poligono[i+1]-1][0]-p[0],puntos[poligono[i+1]-1][1]-p[1]])
        suma=suma+angulo([puntos[poligono[n-1]-1][0]-p[0],puntos[poligono[n-1]-1][1]-p[1]],[puntos[poligono[0]-1][0]-p[0],puntos[poligono[0]-1][1]-p[1]])

        if(np.abs(suma)>=np.pi):
            point=True
    return point

def ladospol(punt):
    n=len(poligono)
    lad=[]
    for i in range(0, n-1):
        lad.append([punt[poligono[i]-1],punt[poligono[i+1]-1]])
    lad.append([punt[poligono[n-1]-1],punt[poligono[0]-1]])
    return lad
    
    
def medio(p,q):
    c1=(p[0]+q[0])/2
    c2=(p[1]+q[1])/2
    m=[c1,c2]
    return m

def interseccionp(l1,l2):
    u1=[l1[1][0]-l1[0][0],l1[1][1]-l1[0][1]]
    u2=[l2[1][0]-l2[0][0],l2[1][1]-l2[0][1]]
    coinc=False
    if(u1[0]*u2[1]==u1[1]*u2[0]):
        coinc=True
    if(coinc==False):
        if(interseccion(l1, l2)==True):
            a=l1[1][1]-l1[0][1]
            b=l1[0][0]-l1[1][0]
            c=l1[0][0]*l1[1][1] - l1[1][0]*l1[0][1]
    
            d=l2[1][1]-l2[0][1]
            e=l2[0][0]-l2[1][0]
            f=l2[0][0]*l2[1][1]-l2[1][0]*l2[0][1]
            if(l1[0][0]==l1[1][0]):
                p=[c/a,(a*f-c*d)/(a*e)]
            else:
                if(l1[0][1]==l1[1][1]):
                    p=[(b*f-c*e)/(b*d),c/b]
                else:    
                    p=[(b*f-c*e)/(b*d-a*e),(a*f-c*d)/(a*e-b*d)]
    
    else:
        p=medio(l2[0],l2[1])
    
    return p
    

def interseccionpolig(l,lado):
    int2=False
    eps=1/100000
    if(interseccion(l, lado)==True):
        p=interseccionp(l, lado)
        if(l[0][0]==l[1][0]):
            m1=[l[0][0],p[1]-eps]
            m2=[l[0][0],p[1]+eps]
        else:
            if(l[0][1]==l[1][1]):
                m1=[p[0]-eps,l[0][1]]
                m2=[p[0]+eps,l[0][1]]
            else:
                a=l[1][1]-l[0][1]
                b=l[0][0]-l[1][0]
                c=l[0][0]*l[1][1] - l[1][0]*l[0][1]
                
                m1=[p[0]-eps, ((c-a*(p[0]-eps))/b)]
                m2=[p[0]+eps, ((c-a*(p[0]+eps))/b)]
                
                
        if(pointin(puntos,m1,poligono)==False or pointin(puntos,m2,poligono)==False):
             int2=True
    return int2

def interseccionpol(l):
    lados=ladospol(puntos)
    int2=False
    for i in range(0, len(lados)):
        int2=interseccionpolig(l,lados[i])
        if(int2==True):
            break
    return int2

def matriz(punt):
    
    matriz=[]
    for i in range(0, len(punt)):
        matriz.append([])
        for j in range(0, len(punt)):
           matriz[i].append(0)
    
    # matriz= [[0]*len(punt)] * len(punt)
    
    lados=ladospol(punt)
    for i in range(0, len(punt)-1):
        for j in range(i+1, len(punt)):
            l=[punt[i],punt[j]]
            aux2 =lados+ [val for val in [l] if val not in lados]
            if(len(aux2)==len(lados)): 
                matriz[i][j]=1
            else:
                
                if(interseccionpol(l)==False):
                    m=medio(punt[i],punt[j])
                    if(pointin(punt,m,poligono)==True):
                        matriz[i][j]=1
    
    for i in range(0, len(punt)):
        for j in range(0, len(punt)):
            matriz[j][i]=matriz[i][j]
    return matriz



def aristas(nodo1,nodo2,distancia,matriz):
    solucion=[] 
    aristas=[] 
    aristas.append([nodo1]) #primer elemeto del primer objeto
    
    if(matriz[nodo1-1][nodo2-1]==1): #comprobacion adyacencia
        for i in range(0, distancia): #recorrido de distancia, empieza en 0 y termina en distancia -1
            temp=[] #Vaciado de para añadir nuevas aristas                             
            for k in range(0, len(aristas)): #recorrido de todas las posibles aristas
                ultimo=aristas[k][i] # obtencion de la ultima posicion actual de la arista
                if(ultimo!=nodo2): # comprobacion que la ultima posicion es distinta de nodo2 por que sino no nos vale dicha arista
                    #recorrido desde 1 hasta la longitud de la matriz+1, esto se realiza por que 
                    # despues se utiliza el valor como si fuera un punto entonces no puede empezar en 0
                    for j in range(1,len(matriz)+1): 
                        if(matriz[ultimo-1][j-1]==1): #comprobacion que existe adyacencia,-1 por que se inicia en 0 la matriz
                            if(j not in aristas[k]): #comprobacion si esta ya dentro dicho valor en caso positivo no se hace nada
                               aristas[k].append(j) #añade j (punto) a la arista
                               temp.extend([aristas[k].copy()]) #añade la arista[k] al resultado
                               aristas[k].pop() #eliminar j de aristas
                               
            aristas=[] #vaciado
            aristas=temp.copy() #copia
        temp=[]
        for k in range(0, len(aristas)): #recorrido de las aristas
            if(aristas[k][distancia]==nodo2):# distancia es para comprobar que el ultimo nodo sea igual al final y por lo tanto es una arista valida
                solucion.append(aristas[k])  # se añade aristas[k] a la solucion
    return solucion




def ladosm(nodos,distancia,matriz):
    lados=[]
    aux=[]
    for i in range(0, nodos-1): #recorrido de 0 a nodo-2
        for j in range(i+2, nodos+1): #recorrido de i+2 hasta nodo 
            aux=[]
            aux=aristas(i+1,j,distancia,matriz).copy() #realizacion del metodo de aristas
            if(aux!=[]): # comprobacion que existe alguna arista
                lados = [*map(list, list(set(map(tuple,lados)) | set(map(tuple,aux))))].copy() #realizacion de la union entre aux y lo que tiene lados
                
    return lados

def alineadosc(punt,camino): 
    cam=camino.copy(); #crea una copia del camino y añade al final los dos primeros puntos
    cam.append(camino[0]) 
    cam.append(camino[1])
    for i in range(0,len(camino)): #recorrio del camino que es igual a cam-2
        #realizacion
        alig=punt[cam[i]-1][0] * (punt[cam[i+1]-1][1]-punt[cam[i+2]-1][1])+punt[cam[i+1]-1][0] * (punt[cam[i+2]-1][1]-punt[cam[i]-1][1]) + punt[cam[i+2]-1][0] * (punt[cam[i]-1][1]-punt[cam[i+1]-1][1])
        if(alig==0):
            break #salida del bucle
    return alig

def direccion(p,q,r): #funcion matematica
    dire=(q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1]- p[1])
    return dire

def alineadosp(p,q,r): #funcion matematica
    alinp=min(p[0],q[0])<=r[0]<=max(p[0],q[0]) and min(p[1],q[1])<=r[1]<=max(p[1],q[1])
    return alinp

def interseccion(l1,l2): #funcion simple para saber si se realiza la interseccion entre dos lados interesa si devuelve true
    inter=False
    p1 = l1[0];
    p2 = l1[1];
    p3 = l2[0];
    p4 = l2[1];
    d1 = direccion(p3, p4, p1)
    d2 = direccion(p3, p4, p2)
    d3 = direccion(p1, p2, p3)
    d4 = direccion(p1, p2, p4)
    
    if(p1!=p3 and p1!=p4 and p2!=p3 and p2!=p4):
        if(((d1 > 0  and  d2 < 0) or (d1 < 0  and  d2 > 0) )and ((d3 > 0  and  d4 < 0) or (d3 < 0  and  d4 > 0))):
            inter=True
        else:
            if(d1==0  and  alineadosp(p3, p4, p1)):
                inter=True
            else:
                if(d2==0  and  alineadosp(p3, p4, p2)):
                    inter=True
                else:
                    if(d3==0  and  alineadosp(p1, p2, p3)):
                        inter=True
                    else:
                        if(d4==0  and  alineadosp(p1, p2, p4)):
                            inter=True
    else:
        inter=False
    return inter

def segmentos(punt,camino): #calculo de los segmentos
    n=len(camino)
    lad=[]
    for i in range(0, len(camino)-1): #recorrido desde 0 hasta len(camino)-2
        lad.append([punt[camino[i]-1],punt[camino[i+1]-1]]) #adicion del punto
    lad.append([punt[camino[n-1]-1],punt[camino[0]-1]]) #adicion del ultimo
    seg=False
    m=len(lad)
    for i in range(0, m-1): #recorrido desde 0 hasta m-2
        if(seg==True): #para finalizar el bucle
            break
        for j in range(i, m):
            seg=interseccion(lad[i], lad[j]) #comprobacion de si devuelve true
            if(seg==True): #para finalizar el bucle
                break
    return seg #solo interesa si devuelve true

def poligonosm(nodos,distancia,matriz): #obtencion de poligonos
    lados=ladosm(nodos,distancia,matriz).copy() #otencion de todos los lados con los parametros
    poligonos2=[]
    for i in range(0,len(lados)): #recorrido de los lados
        alig=alineadosc(puntos, lados[i]) #comprobacion de si estan alineados
        seg=segmentos(puntos, lados[i]) #comprobacion de seg
        # se para los bucles de los modulos anteriores si se dan algun caso de lo contrario a lo que aparece aqui, puesto que entonces no seria un poligono valido
        if(alig!=0  and  seg==False): 
            poligonos2.append(lados[i].copy())
    return poligonos2

def duplicados(poligonos): #eliminacion de los poligonos duplicados de la solucion
    aux = set() #creacion de un set, tipo de datos
    final = []
    for i in range(0,len(poligonos)):  #recorrido de todos los poligonos
        if frozenset(poligonos[i]) not in aux: #ordenacion con frozenset y comprobacion que no esta en aux
            final.append(poligonos[i]) #añade a la respuesta final
            aux.add(frozenset(poligonos[i])) #se añade a la variable aux
    
    return final

def funcion(poligono,fun): #lista de poligonos validos se comprueba cual es el resultado
    n=len(poligono)
    funcion=0
    if(fun==0): #funcion area
        for i in range(1, n):#funcion matematica 
            funcion=funcion+round(np.linalg.det(np.array([puntos[poligono[i-1]-1], puntos[poligono[i]-1]])))
        funcion=funcion+round(np.linalg.det(np.array([puntos[poligono[n-1]-1], puntos[poligono[0]-1]]))) 
        funcion=np.abs(0.5*funcion)
    if(fun==1): #funcion perimetro
        for i in range(1, n): #funcion matematica
            funcion =funcion + np.sqrt(((puntos[poligono[i-1]-1][1]- puntos[poligono[i]-1][1])**2)+((puntos[poligono[i-1]-1][0]- puntos[poligono[i]-1][0])**2))
        funcion =round(funcion + np.sqrt(((puntos[poligono[n-1]-1][1]- puntos[poligono[0]-1][1])**2)+((puntos[poligono[n-1]-1][0]- puntos[poligono[0]-1][0])**2)),12)
        
    return funcion

def update(poligonos,fun): #obtencion de las soluciones
    upd=[]
    maxi=0
    f=0
    for i in range(0, len(poligonos)): #recorrido de todas las posibles soluciones
        f=funcion(poligonos[i],fun) #calculo del resultado
        if(f>=maxi): # si es igual se añade el poligono
            upd.append(poligonos[i].copy())
        if(f>maxi): #si es mayor se eliminan los anteriores y se añade el nuevo,actualiza el nuevo tope
            maxi=f
            upd=[]
            upd.append(poligonos[i].copy())
      
    return upd

def solucion(nodos,distancia,matriz,fun):#modulo principal
    solucion=[]
    poligonos=poligonosm(nodos,distancia,matriz) #todos los poligonos validas con la matriz de adyacencia y la distancia
    noduplic=duplicados(poligonos) # eliminacion de todos los duplicados
    solucion=update(noduplic,fun) # obtencion de los poligonos con los mejores valores en funcion de fun
    solucion.sort()
    return solucion


# Ejecucion del programa, atajo para comentar una linea ctrl + 1
# El orden de las soluciones puede variar con respecto al mathematica pero forma los mismo poligonos
# inicio = time()
# print(solucion(15,3,A,0))
# fin = time() - inicio
# print("Tiempo de ejecucion" ,fin)

# inicio = time()
# print(solucion(15,3,A,0))
# fin = time() - inicio
# print("Tiempo de ejecucion" ,fin)

matriz=matriz(puntos)
print(matriz)
print(solucion(14,2,matriz,0))


