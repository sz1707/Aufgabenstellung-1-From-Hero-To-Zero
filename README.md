# Aufgabenstellung-1-From-Hero-To-Zero

Dieses Repository enthält den Quellcode und die Konfigurationsdateien für eine Jakarta EE-Webanwednung zur Anzeige und Bearbeitung von CO2-Emissionsdaten. 
Die Anwednung basiert auf JSF, JPA (Hibernate), CDI und MySQL, läuft lokal auf einem Apache Tomcat 10.0 Server 
und verwendet eine in phpMyAdmin importierte CSV-Datei als Datenbasis.

Vorbereitung: CSV-Datei in MySQL (phpMyAdmin) importieren: 
1. Stelle sicher, dass die Datei "Kopie von Laenderliste_mit_fikitven_CO2Emissionen.csv" im CSV-Dateiformat vorliegt
2. Melde dich bei phpMyAdmin an (bspw. via: http://localhost/phpmyadmin)
3. Wähle oder erstelle eine Datenbank "CO2Daten"
4. Klicke auf Importieren und Wähle die CSV-Datei aus
5. Wähle das Format CSV und passe die Trennzeichen an
6. Aktiviere die Option "Spaltennamen in der ersten Zeile verwenden"
--> phpMyAdmin erstellte eine neue Tabelle ("emissionswerte")

Vorbereitung: Tomcat 10-Server in Eclipse integrieren

Die Anwendung kann nun durch den beispielhaften Pfad: http://localhost:8080/CO2Datenbank/index.xhtml beziehungsweise xttp://localhost:8080/CO2Datenbank/edit.xhtml
