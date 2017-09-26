# VCS Tasks

## Simple statements

- 1a. Programa leidžia įvesti vartotojui norimą skaičių ir pasako ar jis teigiamas ar neigiamas
- 1b. Programa leidžia įvesti vartotojo varda ir jį atspausdina 5 kartus.
- 1c. Programa leidžia įvesti skaičių nuo 0 iki 21 ir parašo skirtumą tarp šių skaičių. (pvz.: 19 -> 2, 21 = 0). Programa neturi leisti įvesti skaičių mažiau nei 0 ir daugiau nei 21.
- 1d. Programa leidžia įvesti vardą ir skaičių. Įvestas skaičius turi nurodyti raidę kuri yra žodyje.
- 1e. Programa leidžia įvesti žodį ir parašo ar jis prasideda fraze "foo"

## Cycles

- 2a. Programa kur leidžia įvesti skaičių ir atspausdina visus likusius skaičius iki 100.
- 2b. Parašyti programą kuri paprašytų vartotojo įvesti žodį ir jį iš karto atvaizduotų, tada vėl paprašytų įvesti kitą žodį, jį atvaizduotų, ir procesą kartotų tol, kol nebus įvestas žodis „pabaiga“.
- 2c. Parašyti programą, kuri paprašytų vesti skaičius tol, kol bus įvestas skaičius 0. Pabaigoje turi būti atvaizduojama įvestų skaičių suma.
- 2d. Parašyti kuri praeitų skaičius nuo 2000 iki 3200 ir atspausdintų tuos skaičius, kurie dalinasi iš 7 be liekanos, ir nesidalina iš 5.

## Arrays

- 3a. Turim masyvą skaičių [4, 5, 7, 11, 20, 11, 50, 55]. Programa turi išvesti šių skaičių sumą.
- 3b. Paimti masyvą iš 3a ir atspausdinti tik tuos skaičius kurie yra lyginiai.
- 3c. Paimti masyvą iš 3a ir atspausdinti visų skaičių vidurkį.
- 3d. Parašyti programą, kuri paprašytų įvesti 5 skaičius. Baigus skaičių įvedimą, turi būti atvaizduojama įvestų skaičių suma ir visi įvesti skaičiai.
- 3e. Parašyti programą kuri paprašytų vartotojo įvesti  5 žodžius.  Po to kai bus įvesti visi žodžiai, jie turi būti atvaizduojami.
- 3f. Sukurti dvimatį masyvą kurio x ir y ašys būtų nuo 0 iki 3. Programa turi priimti iš vartotojo skaičius ir užpildyti masyvą reikšmėmis. 
- 3g. Sukurti masyvą ir jį užpildyti Fibonaci skaičių seka. (0 1 1 2 3 5 8 13 21 34)
- 3h. Suskaičiuoti kiek yra masyve kiekvieno elemento pasikartojimų (pvz.: (1, 2, 2, 3) -> 1=1, 2=2, 3=1)
- 3i. Iš masyvo panaikinti visus skaičius kurie kartojasi. Masyvą sutraukti kad nebūtų tuščių tarpų. 
- 3j. Nukopijuoti masyvą į naują masyvą. Kopijuojant ignoruoti elementus kurių reikšmė -1 ir 0.

## Methods

- 4a. Parašyti programą kuri leistų vartotojui įvesti savo masę ir ūgį, pagal gautus duomenis paskaičiuotų ir atvaizduotų jo kūno masės indeksą.

```
KMI = masė (kg) / (ūgis(m))^2
```

- 4b. Paprašyti vartotojo nurodyti kiek skaičių jis ketina įvesti, tuomet duoti jam įvesti tiek skaičių, kiek jis pasirinko. Po įvedimo atvaizduoti tik tuos skaičius kurie buvo didesni nei 100.
- 5a. Parašyti metodą kuris patikrintų ar įvestas slaptažodis atitinka kriterijus. Turi didžiųjų raidžių, turi specialius simbolius (.-\_!@), turi skaičių. Jeigu ne - slaptažodis per silpnas. 
- 5b. Realizuoti 4a užduotį panaudojant metodą kurio parametrai būtų masė ir ūgis, o grąžinama reikšmė, kūno masės indeksas.
- 5c. Realizuoti 4b užduotį panaudojant metodą kurio parametras  būtų vartotojo įvestų skaičių masyvas ir skaičių didesnių nei 100 atvaizdavimas vyktų pačiame metode.

- 6a. Sukurti žaidimą kurio tikslas atspėti skaičių nuo 1 iki 10. Kaskart spėjant skaičių ir neatspėjus yra generuojamas naujas skaičius.  Žaidimas baigiasi kuomet skaičius yra atspėjamas arba vartotojas kaip spėjamą skaičių įveda 0.

```
        Random rand = new Random();
        int randomNumber  = rand.nextInt(10) + 1;
        random.nextInt(max - min + 1) + min
```

- 6b. Sukurti supaprastintą skaičiuoklės programą kuri paprašytų įvesti du skaičius ir operacijos tarp jų  skaičių (1 – suma, 2 – skirtumas, 3 – sandauga). Gautą rezultatą programa pavaizduotų ekrane ir paklaustų ar norėsime kartoti. Įvedus skaičių 5, programa turėtų kartoti darbą iš naujo, priešingu atveju programa baigtų darbą.
- 7a. Parašyti programą kuri paprašo vartotojo įvesti skaičių n ir suskaičiuoja sumą visų skaičių nuo vieno iki n. Jeigu įvestas skaičius mažesnis nei vienas, programa turi informuoti apie blogą įvestį.
- 7b. Parašyti programą kuri paprašo vartotojo įvesti skaičių n, tuomet leidžia pasirinkti ką suskaičiuoti, skaičių nuo 1 iki n sumą arba sandaugą (1 - suma, 2 - sandauga). Jeigu įvestas skaičius mažesnis nei vienas, programa turi informuoti apie blogą įvestį.
- 7c. Programa priima bet kokį tekstą ir suskaičiuoja kiek yra žodžių. 

## Methods 2
- 8a. Parašyti metodą kurio parametras būtų sveikų skaičių masyvas. Metodas turi grąžinti didžiausią masyvo skaičių.
- 8b. Parašyti metodą kurio parametras būtų sveikų skaičių masyvas. Metodas turi grąžinti mažiausią masyvo skaičių.
- 8c. Parašyti metodą kuris per parametrus pasiimtų masyvą, o grąžintų apsuktą masyvą `([1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1])`. Užuomina: sukurti antrą tokio paties dydžio masyvą ir jam priskirti skaičius nuo galo.

- 9a. Parašyti metodą kuris suskaičiuoja kiek per parametrus paduotame žodyje yra raidžių “a”. Prieš atliekant veiksmus patikrinti ar paduotas žodis yra tinkamas, jei ne, grąžinti 0.
- 9b. Parašyti metodą kuris patikrina ar per parametrus paduotame žodyje yra raidžių derinių “ab”. Prieš atliekant veiksmus patikrinti ar paduotas žodis yra tinkamas, jei ne, grąžinti 0. Užuomina: radus “a” raidę tikrinti ar sekanti raidė (i + 1) yra “b”.
- 9c. Parašyti metodą kuris patikrintų ar duotas žodis yra palindromas (žodis ar sakinys kurį skaitant nuo galo gaunamas tas pats žodis ar sakinys, pvz. “KOL EINU ŠUNIE LOK”, “ARGI TEN NE TIGRA”). Užuomina: pašalinti tarpus ir tuomet keliauti per pusę žodžio iš abiejų pusių tikrinant ar sutampa raidės.

- 10a. Turime sąrašą: `[2, 5, 1, 9, -999, 9879, 55, 26]` Parašyti metodą kuris grąžintų tokį patį sąrašą surikiuotą didėjimo tvarka.

```
        Collections.sort(...)
```

- 10b. Turime sąrašą: `[2, 5, 1, 9, -999, 9879, 55, 26]` Parašyti metodą kuris grąžintų tokį patį sarašą surikiuotą mažėjimo tvarka.


```
        Collections.reverse(array);
        Collections.sort(array Collections.reverseOrder());
```

## Reading file

- 11a. Faile surašyti žmonių vardai. Parašyti programą kuri juos nuskaitytų ir atvaizduotų ekrane.
- 11b. Faile surašyti žmonių vardai. Parašyti programą kuri juos nuskaitytų ir atvaizduotų tik tuos vardus kurie prasideda raide ‘A’.
- 11c. Nuskaityti faile esančius skaičius į sarašą ir atvaizduoti juos didėjimo tvarka.

## Lists

- 12a. Faile surašyti žmonių vardai. Parašyti programą kuri juos nuskaitytų į sarašą (ArrayList) ir iš ten juos atvaizduotų.
- 12b. Faile surašyti žmonių vardai. Parašyti programą kuri juos nuskaitytų į sarašą (ArrayList) ir prieš atvaizduojant leistų pasirinkti iš kokios raidės vardus rodyti. Užuomina: naudoti du Scanner klasės objektus, vieną skaitymui iš failo, kitą iš klaviatūros.
- 12c. Faile surašyti žmonių vardai. Parašyti programą kuri juos nuskaitytų į sarašą (ArrayList), surūšiuotų pagal abėcėlę ir pavaizduotų ekrane.
 
## Maps

- 13a. Faile kiekvienoje eilutėje surašytas žmogaus vardas ir amžius. Parašyti programą kuri nuskaitytų duomenis į HashMap tipo duomenų struktūrą, tuomet leistų vartotojui įvesti norimą vardą, ir jei šis buvo duomenų faile, atvaizduoti to žmogaus amžių.
- 13b. Faile kiekvienoje eilutėje surašytas žmogaus vardas ir jo mėgstama spalva. Parašyti programą kuri nuskaitytų duomenis į HashMap tipo duomenų struktūrą, tuomet leistų vartotojui įvesti norimą vardą, ir jei šis buvo duomenų faile, atvaizduoti to žmogaus mėgstamą spalvą.
- 13c. Sukurti anglų-lietuvių žodynėlio programėlę. Duomenų faile, kiekvienoje eilutėje saugomas angliškas žodis ir po tarpo - jo vertimas. Paleidus programą vartotojas turi turėti galimybę įvesti lietuvišką arba anglišką žodį, o programa atitinkamai turi nustatyti ar tas žodis yra iš lietuviškų žodžių stulpelio faile ar iš angliškų, tuomet pasiūlytų atitinkamą jo vertimą į kitą kalbą. Užuomina: naudoti du HashMap objektus, po vieną kiekvienai kalbai.
 
## Classes / Methods

- 14a. Parašyti metodą kuris per parametrus pasiimtų tekstą ir per grąžinamą reikšmę praneštų ar šiame tekste yra skaičių. 
- 14b. Parašyti metodą kuris per parametrus pasiimtų tekstą ir grąžintų indeksą pirmos sutiktos ‘a’ raidės. Jeigu raidės nerado, grąžintų -1.
 
- 15a. Parašyti metodą kuris per parametrus pasiimtų sąrašą su žodžiais ir grąžintų tekstą kuriame apjungti visi žodžiai.
- 15b. Parašyti metodą kuris per parametrus pasiimtų sąrašą su žodžiais ir grąžintų tekstą kuriame apjungti visi žodžiai prasidedantys raide ‘A’.
 
- 16a. Parašyti metodą kuris per parametrus pasiimtų tekstą ir per grąžinamą reikšmę praneštų ar jame yra žodis “labas”.
- 16b. Parašyti metodą kuris per parametrus pasiimtų tekstą ir per grąžinamą reikšmę praneštų kiek jame yra atskirų žodžių.
 
- 17a. Tekstiniame faile į kiekvieną eilutę yra surašyti du skaičiai, pirmas iš jų nurodo automobilio suvartotą kuro kiekį tam tikram atstumui įveikti, antras - nuvažiuotą atstumą. Parašyti programą su grafine vartotojo sąsaja kuri paskaičiuotų kokios yra vidutinės automobilio kuro sąnaudos. Programa turi turėti teksto laukelį, vidutinių kuro sąnaudų atvaizdavimui, įvesties lauką failo pavadinimui ir mygtuką po kurio paspaudimo būtų nuskaitomas duomenų failas ir atvaizduojamos paskaičiuotos vidutinės kuro sąnaudos.

vidutinės sąnaudos = (suvartotas kuro kiekis * 100) / nuvažiuotas atstumas;

Duomenys: 

```
31,93 - 425.8
37.95 - 520.2
37.00 - 533.6
35.02 - 382.3
37.26 - 479.7
39.49 - 388.7
34.63 - 365.7
37.17 - 434.2
27.51 - 354.8
37.50 - 453.5
35.13 - 468.9
36.81 - 500.2
24.20 - 330.2
37.14 - 484.3
38.55 - 488.5
39.92 - 525.1
27.99 - 366.6
39.87 - 543.2
35.60 - 482.1
35.22 - 460.9
36.95 - 466.0
34.19 - 483.7
37.10 - 487.9
39.52 - 521.2
```
 
## Classes

- 18a. Faile surašyti žmonių vardai. Sukurti klasę kuri turėtų metodą failo nuskaitymui ir nuskaitytų vardų atvaizdavimui.
- 18b. Sukurti klasę kuri turėtų metodus skaičių sumos, skirtumo ir sandaugos radimui. Metodai per parametrus priimtų du skaičius, o gražintų atitinkamo veiksmo rezultatą.
- 19a. Faile surašyti žmonių vardai. Sukurti klasę kuri per konstruktorių paimtų failo vardą ir turėtų du metodus, vieną duomenų nuskaitymui iš failo į sarašą, o kitą atvaizdavimui iš sąrašo į ekraną.
- 19b. Faile surašyti skaičiai. Sukurti klasę kuri per konstruktorių paimtų failo vardą ir turėtų tris metodus: duomenų nuskaitymui iš failo į sarašą, atvaizdavimui iš sąrašo į ekraną ir skaičių sumos radimui.
- 20a. Panaudoti 19a užduotyje sukurtą klasę dviejų failų nuskaitymui ir atvaizdavimui.
- 20b. Panaudoti 19b užduotyje sukurtą klasę dviejų failų nuskaitymui, atvaizdavimui ir skaičių sumos radimui.
- 21a. Sukurti skaičiuotuvo klasę kurioje realizuoti statinius metodus sumai, skirtumui, sąndaugai. Per parametrus bus naudojami sveiko tipo skaičiai.

## Classes (Overloading)

- 22a. Papildyti 21a programą, panaudojant metodų perkrovimą (overloading) sukurti papildomus metodus, kad operacijos veiktų tiek su sveiko tipo skaičiais, tiek su skaičiais po kablelio.

## Interfaces

- 23a. Sukurti sąsają (interface) ‘Spausdinantis’ ir aprašyti joje metodą “spausdinti”. Sukurti spausdintuvo klasę kuri realizuotų metodus duomenų surinkimui į sąrašą ir kitą metodą duomenų spausdinimui. Duomenų rinkimo metodas turėtų į sarašą įdėti žodį “labas”, o spausdinimo metodas turėtų atspausdinti visas sąrašo reikšmes.

## Inheritance

- 24a. Papildyti 23a programą. Sukurti kitą spausdintuvo klasę kuri paveldėtų tėvinę spausdintuvo klasę ir per naują realizuotų duomenų paruošimo metodą, šį kartą duomenis paprašydama įvesti vartotojo.
- 25a. Papildyti 24a programą. Sukurti dar vieną spausdintuvo klasę kuri paveldėtų tėvinę spausdintuvo klasę ir per naują realizuotų duomenų paruošimo metodą, šį kartą duomenys turi būti skaitomi iš failo.
- 26a. Sukurti gyvūno klasę kuri saugotų kintamuosius: masė, ūgis, spalva. Ji turi turėti metodą kuris atspausdintu visas gyvūno savybes į ekraną. Sukurti tris konkrečių gyvūnų klases kurios paveldėtų pagrindinę gyvūno klasę, bet konstruktoriuje pakeistų pagrindinių gyvūno savybių reikšmes.
- 27a. Papildyti 26a programą. Kiekvienam konkrečiam gyvūnui sugalvoti po išskirtinę savybę ir jai parašyti sąsają su metodu tai savybei išreikšti. Realizuoti šias savybes atitinkamose gyvūnų klasėse.
