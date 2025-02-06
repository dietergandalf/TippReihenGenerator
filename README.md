<<<<<<< HEAD
# TippReihenGenerator
=======
# TippReihenGenerator

## Übersicht

TippReihenGenerator ist ein Java-basiertes Kommandozeilenprogramm, das zufällige Lottozahlen generiert. Es unterstützt sowohl das deutsche Lotto 6 aus 49 als auch das Eurolotto (5 aus 50 + 2 aus 10). Das Programm ermöglicht es dem Benutzer, bis zu 6 Unglückszahlen anzugeben, die bei der Generierung der Tippreihen ausgeschlossen werden.

## Funktionen

- Generierung von Lottozahlen für zwei Spielvarianten:
  - Lotto 6 aus 49
  - Eurolotto (5 aus 50 + 2 aus 10)
- Berücksichtigung von bis zu 6 Unglückszahlen
- Einfache Bedienung über die Kommandozeile

## Systemvoraussetzungen

- Java Runtime Environment (JRE) 21 oder höher

## Installation

1. Laden Sie die `TippReihenGenerator.jar`-Datei herunter.
2. Stellen Sie sicher, dass Java auf Ihrem System installiert ist.

## Verwendung

Öffnen Sie ein Terminal oder eine Kommandozeile und navigieren Sie zum Verzeichnis, in dem sich die JAR-Datei befindet. Verwenden Sie dann den folgenden Befehl:

```
java -jar TippReihenGenerator.jar [Spieltyp] [Unglückszahlen]
```

### Parameter

- `[Spieltyp]`: Wählen Sie zwischen `euro` für Eurolotto und ohne input für Lotto 6 aus 49.
- `[Unglückszahlen]`: Geben Sie optional bis zu 6 Unglückszahlen an, getrennt durch Leerzeichen.
- `help`: Zeigt eine Hilfe mit den verfügbaren Optionen an.
- `delete`: Lösche die alten Unglückszahlen.

### Beispiele

1. Lotto 6 aus 49 ohne Unglückszahlen:
   ```
   java -jar TippReihenGenerator.jar
   ```

2. Eurolotto mit drei Unglückszahlen:
   ```
   java -jar TippReihenGenerator.jar euro 13 23 42
   ```

3. Lotto 6 aus 49 mit sechs Unglückszahlen:
   ```
   java -jar TippReihenGenerator.jar 7 13 23 31 42 49
   ```

4. Hilfe anzeigen:
   ```
   java -jar TippReihenGenerator.jar help
   ```
   
5. Lösche die alten Unglückszahlen:
   ```
   java -jar TippReihenGenerator.jar delete
   ```

## Ausgabe

Das Programm gibt die generierten Lottozahlen auf der Konsole aus. Bei Eurolotto werden die Hauptzahlen und die Eurozahlen separat angezeigt.
Mit j wird immer eine neue Zahlenreihe generiert.
Mit n wird das Programm beendet.

## Fehlerbehebung

- Stellen Sie sicher, dass Java korrekt installiert ist.
- Überprüfen Sie, ob Sie sich im richtigen Verzeichnis befinden.
- Achten Sie auf die korrekte Schreibweise der Parameter.
>>>>>>> master
