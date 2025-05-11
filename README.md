# 📊 Graph-Algorithmen in Java

Dieses Projekt implementiert grundlegende Graphdatenstrukturen sowie klassische Graphsuch- und kürzeste-Wege-Algorithmen in Java.

## 📁 Inhalt

* **Graph**: Repräsentation eines ungerichteten Graphen mit Knoten (`Vertex`) und Kanten (`Edge`).
* **DFS (Tiefensuche)**: Implementiert mit einem Stack zur Tiefensuche.
* **BFS (Breitensuche)**: Implementiert mit einer Queue zur Breitensuche, inkl. Varianten mit maximaler Tiefe.
* **Dijkstra-Algorithmus**: Findet den kürzesten Weg in gewichteten Graphen.
* **Hilfsklassen**: Eigene Implementierungen für Liste, Stack und Queue (analog zu linearen Datenstrukturen aus dem Informatikunterricht).

## 🔍 Überblick über die Algorithmen

### Tiefensuche (DFS)

* Traversiert einen Graphen tief entlang der Kanten.
* Implementiert mit einem `Stack`.
* Zwei Varianten: gibt eine Liste der besuchten Knoten zurück oder erzeugt einen DFS-Graphen.

### Breitensuche (BFS)

* Traversiert den Graphen schichtweise (Level für Level).
* Nutzt eine `Queue`.
* Varianten: klassische BFS, BFS mit maximaler Tiefe, beide mit Option zur Rückgabe eines BFS-Graphens.

### Dijkstra

* Berechnet den kürzesten Pfad zwischen zwei Knoten in einem gewichteten Graphen.
* Zwei Implementierungen:

  * Eine mit `PriorityQueue` (Java Collections).
  * Eine eigene manuelle Version mit Knotenklasse `Knoten`, zur besseren Nachvollziehbarkeit der Schritte.

## 🔧 Struktur

```plaintext
Graph.java          -> Die Hauptklasse zur Darstellung eines Graphen
Vertex.java         -> Klasse für einzelne Knoten
Edge.java           -> Klasse für Kanten inkl. Gewicht
Tiefensuche.java    -> Implementierung von DFS
Breitensuche.java   -> Implementierung von BFS
Dijkstra.java       -> Implementierung des Dijkstra-Algorithmus
Knoten.java         -> Erweiterung von Vertex zur Verwendung im Dijkstra-Algorithmus
List.java           -> Eigene generische Liste (simuliert Java Collections)
Queue.java          -> Eigene Queue-Implementierung
Stack.java          -> Eigene Stack-Implementierung
```

## 🚀 Nutzung

Die Algorithmen erwarten ein `Graph`-Objekt sowie einen Startknoten. Beispiel für die Nutzung von DFS:

```java
Graph g = new Graph();
// Knoten und Kanten hinzufügen...
Vertex start = g.getVertex("A");
Tiefensuche dfs = new Tiefensuche();
List<Vertex> result = dfs.DFS(g, start);
```
