# Devops_ImanolArtetxe

## 1. Maven eta Java Proiektua
Maven proiektua sortzeko prozesuan, hasierako konfigurazioarekin lotutako hainbat arazo izan nituen, eta honela konpondu nituen:

* **Karpeta Estruktura Arazoa:** Hasieran, fitxategiak eskuz sortzean, kode iturria (`App.java`) `src/test` karpetan geratu zen okerreko tokian (`src/main` izan beharrean). Gainera, kodean definitutako paketeak (`package com.example`) ez zetozen bat karpeten egiturarekin.
    * **Konponbidea:** Proiektua hutsetik birsortu nuen terminaletik `mvn archetype:generate` komandoa erabiliz, Mavenen estruktura ofiziala bermatzeko. Ondoren, fitxategiak `src/main/java/com/devops` eta `src/test/java/com/devops` karpetetara mugitu nituen, `pom.xml` fitxategiko `groupId`-arekin bat etor zitezen.

## 2. GitFlow eta Python
Funtzionalitateak adarretan garatzea ondo joan zen (`feature/suma`, `feature/resta`), baina amaieran gatazka bat sortu zen:

* **Push egiteko errorea Main adarrean:** `main` adarrera azken bertsioa igotzen saiatzean, Gitek atzera bota zuen igoera mezu honekin: `hint: Updates were rejected because the remote contains work that you do not have locally`.
    * **Konponbidea:** Arazoa sortu zen GitHub-en Maven proiektuaren Pull Request-a onartu nuelako, baina aldaketa horiek ez nituelako nire ordenagailuan oraindik. Konpontzeko, `git pull origin main` egin nuen lehenengo (hodeiko aldaketak jaisteko), eta behin fusionatuta, `git push` egin ahal izan nuen.

## 3. Docker eta Dockerfile-ak
Ariketaren helburua pisu oso ezberdineko hiru irudi sortzea zen.

* **Irudien optimizazioa:** Python edo Node bezalako lengoaien irudi ofizialek ia 1GB pisatu dezakete, eta horrek deskarga asko moteltzen du.
    * **Konponbidea:** Pisu ezberdintasuna nabaritzeko baina sarea saturatu gabe, oinarrizko irudi hauek aukeratu nituen:
        1.  **Arina:** `alpine` erabili nuen (~5MB).
        2.  **Ertaina:** `ubuntu` erabili nuen (~70MB).
        3.  **Astuna:** `node:slim` erabili nuen (~200MB). 1GB-ko irudi bat erabili beharrean, hau nahikoa izan zen pisuaren aldea erakusteko.

## 4. Docker Compose
* **Persistentzia eta Konexioa:** Redis datu-base bat konfiguratu nuen bolumen iraunkor batekin (`redis-data`) eta nire aplikazioa haren menpe jarri nuen (`depends_on`).
* **Edukiontzia berehala itzaltzen zen:** Nire aplikazioaren irudiak (Ubuntu) ez zuenez prozesurik exekutatzen lehen planoan (daemon), edukiontzia piztu eta berehala hiltzen zen.
    * **Konponbidea:** `tail -f /dev/null` komandoa gehitu nuen `docker-compose.yml` fitxategian. Trukuko komando honek edukiontzia "ezer egiten ez" baina martxan mantentzen du, konexioa egiaztatu ahal izateko.
