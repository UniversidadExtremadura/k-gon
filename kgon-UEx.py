# UNIVERSITY OF EXTREMADURA
# MEDIA ENGINEERING GROUP
# CONTACT: andresc@unex.es

import numpy as np
from time import time

matrix = [[0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
     [1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
     [0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1],
     [1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0],
     [1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1],
     [1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1],
     [1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1],
     [1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0],
     [1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1],
     [1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1],
     [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1],
     [1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0]];

points = [[2,6], [4,6],[6,8],[8,6],[6,4],
          [8,2],[6,0],[4,2],[4,0],[0,4],
          [2,2],[6,6],[2,4],[4,4],[6,2]];

def edges(nodo1, nodo2, distance, matrix):
    solucion = []
    edges = []
    edges.append([nodo1])
    if (matrix[nodo1 - 1][nodo2 - 1] == 1):
        for i in range(0, distance):
            temp = []
            for k in range(0, len(edges)):
                ultimo = edges[k][i]
                if (ultimo != nodo2):
                    for j in range(1, len(matrix) + 1):
                        if (matrix[ultimo - 1][
                            j - 1] == 1):
                            if (j not in edges[k]):
                                edges[k].append(j)
                                temp.extend([edges[k].copy()])
                                edges[k].pop()
            edges = []
            edges = temp.copy()
        temp = []
        for k in range(0, len(edges)):
            if (edges[k][
                distance] == nodo2):
                solucion.append(edges[k])
    return solucion

def sides(nodos, distance, matrix):
    sid = []
    aux = []
    for i in range(0, nodos - 1):
        for j in range(i + 2, nodos + 1):
            aux = []
            aux = edges(i + 1, j, distance, matrix).copy()
            if (aux != []):
                sid = [*map(list, list(set(map(tuple, sid)) | set(
                    map(tuple, aux))))].copy()
    return sid

def aligned(punt, camino):
    cam = camino.copy();
    cam.append(camino[0])
    cam.append(camino[1])
    for i in range(0, len(camino)):
        alig = punt[cam[i] - 1][0] * (punt[cam[i + 1] - 1][1] - punt[cam[i + 2] - 1][1]) + punt[cam[i + 1] - 1][0] * (
                punt[cam[i + 2] - 1][1] - punt[cam[i] - 1][1]) + punt[cam[i + 2] - 1][0] * (
                punt[cam[i] - 1][1] - punt[cam[i + 1] - 1][1])
        if (alig == 0):
            break
    return alig

def direction(p, q, r):
    dir = (q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1] - p[1])
    return dir

def alignedp(p, q, r):
    alig = min(p[0], q[0]) <= r[0] <= max(p[0], q[0]) and min(p[1], q[1]) <= r[1] <= max(p[1], q[1])
    return alig

def intersection(l1,l2):
    inter = False
    p1 = l1[0];
    p2 = l1[1];
    p3 = l2[0];
    p4 = l2[1];
    d1 = direction(p3, p4, p1)
    d2 = direction(p3, p4, p2)
    d3 = direction(p1, p2, p3)
    d4 = direction(p1, p2, p4)
    if (p1 != p3 and p1 != p4 and p2 != p3 and p2 != p4):
        if (((d1 > 0 and d2 < 0) or (d1 < 0 and d2 > 0)) and ((d3 > 0 and d4 < 0) or (d3 < 0 and d4 > 0))):
            inter = True
        else:
            if (d1 == 0 and alignedp(p3, p4, p1)):
                inter = True
            else:
                if (d2 == 0 and alignedp(p3, p4, p2)):
                    inter = True
                else:
                    if (d3 == 0 and alignedp(p1, p2, p3)):
                        inter = True
                    else:
                        if (d4 == 0 and alignedp(p1, p2, p4)):
                            inter = True
    else:
        inter = False
    return inter

def segments(punt, camino):
    n = len(camino)
    lad = []
    for i in range(0, len(camino) - 1):
        lad.append([punt[camino[i] - 1], punt[camino[i + 1] - 1]])
        lad.append([punt[camino[n - 1] - 1], punt[camino[0] - 1]])
    seg = False
    m = len(lad)
    for i in range(0, m - 1):
        if (seg == True):
            break
        for j in range(i, m):
            seg = intersection(lad[i], lad[j])
            if (seg == True):
                break
    return seg

def polygons(nodos, distance, matrix):
    sid = sides(nodos, distance, matrix).copy()
    polygons = []
    for i in range(0, len(sid)):
        alig = aligned(points, sid[i])
        seg = segments(points, sid[i])
        if (alig != 0 and seg == False):
            polygons.append(sid[i].copy())
    return polygons

def function(polygon, fun):
    n = len(polygon)
    function = 0
    if (fun == 0):
        for i in range(1, n):
            function = function + round(np.linalg.det(np.array([points[polygon[i - 1] - 1], points[polygon[i] - 1]])))
        function = function + round(np.linalg.det(np.array([points[polygon[n - 1] - 1], points[polygon[0] - 1]])))
        function = np.abs(0.5 * function)
    if (fun == 1):
        for i in range(1, n):
            function = function + np.sqrt(((points[polygon[i - 1] - 1][1] - points[polygon[i] - 1][1]) ** 2) + (
                        (points[polygon[i - 1] - 1][0] - points[polygon[i] - 1][0]) ** 2))
        function = round(function + np.sqrt(((points[polygon[n - 1] - 1][1] - points[polygon[0] - 1][1]) ** 2) + (
                    (points[polygon[n - 1] - 1][0] - points[polygon[0] - 1][0]) ** 2)), 12)
    return function

def update(polygons, fun):
    upd = []
    maxi = 0
    f = 0
    for i in range(0, len(polygons)):
        f = function(polygons[i], fun)
        if (f >= maxi):
            upd.append(polygons[i].copy())
        if (f > maxi):
            maxi = f
            upd = []
            upd.append(polygons[i].copy())
    return upd

def duplicates(polygons):
    aux = set()
    final = []
    for i in range(0, len(polygons)):
        if frozenset(polygons[i]) not in aux:
            final.append(polygons[i])
            aux.add(frozenset(polygons[i]))

    return final

def solution(nodos, distance, matrix, fun):
    solution = []
    poly = polygons(nodos, distance, matrix)
    noduplic = duplicates(poly)
    solution = update(noduplic, fun)
    solution.sort()
    return solution

nodos = 15

inicio = time()
print("TRIANGLE (area)) = ")
print(solution(nodos, 2, matrix, 0))
fin = time() - inicio
print("Time:", fin)
print("----------------------------")

inicio = time()
print("QUADRILATERAL (area) = ")
print(solution(nodos, 3, matrix, 0))
fin = time() - inicio
print("Time:", fin)
print("----------------------------")

inicio = time()
print("PENTAGON (area) = ")
print(solution(nodos, 4, matrix, 0))
fin = time() - inicio
print("Time:", fin)
print("----------------------------")

inicio = time()
print("HEXAGON (area) = ")
print(solution(nodos, 5, matrix, 0))
fin = time() - inicio
print("Time:", fin)
print("----------------------------")
