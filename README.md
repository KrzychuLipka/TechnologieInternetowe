### Tydzień 2

## CZĘŚĆ 1 - PYTANIA DO STUDENTÓW

1. Która funkcja jest punktem startowym interfejsu? 

App w pliku pl.lipov.technologieinternetowe.App.kt

2. Czym jest Composable?

Funkcją, która opisuje UI. Jest renderowana przez Compose.

3. UI w Compose jest deklaratywny czy imperatywny?

Deklaratywny. 

Zamiast:
stwórz element
dodaj go do widoku
zmień jego tekst

piszemy:
UI wygląda tak...

4. Czym jest Scaffold?

Jest to komponent Material Design, który dostarcza: layout aplikacji, padding systemowy,
miejsce na toolbar, miejsce na content.

5. Która funkcja odpowiada za wyświetlenie ekranu listy gier?

GamesListScreen
Jest to komponent UI odpowiedzialny za listę gier.
Tutaj dzieją się trzy rzeczy:
- pobranie listy gier za pośrednictwem view modelu,
- obserwacja stanu UI,
- wyświetlenie listy gier.

6. Czym jest Flow?

Flow to strumień danych.
Gdy dane się zmienią UI się automatycznie przerysuje (reaktywne UI).

7. Czym jest LazyRow?

LazyRow to komponent wyświetlający listę poziomą.
Elementy są tworzone tylko wtedy gdy są widoczne.
To działa podobnie jak:
- RecyclerView w Android
- virtual list w React

8. Która funkcja odpowiada za wyświetlenie pojedynczego elementu listy (pojedynczą grę)?
- GameItem
Składa się z kilku elementów:
- Image
- Text
- Box
- Column

9. Czym jest Modifier?
Modifier w Compose odpowiada za:
- rozmiar
- padding 
- tło
- kliknięcia

Jest to łańcuch dekoratorów.

10. Jakiego typu dane przechowuje każdy view model?

ViewModel przechowuje dane UI.

private val _games = MutableStateFlow<List<Game>>
StateFlow to reaktywny stan.

11. Co się dzieje tuż po utworzeniu GamesListViewModel? 

Następuje pobieranie danych dot. gier (init{}).

12. Za co odpowiada UseCase?

Reprezentuje konkretną operację biznesową.
GetAllGamesUseCase - pobierz wszystkie gry

To oddziela logikę aplikacji od UI.

13. Czym jest repository?

Repository to abstrakcja źródła danych.
To oznacza, że UI nie wie czy dane pochodzą z:
- API,
- bazy danych,
- pliku,
- cache.

14. Czym jest DataSource?

Źródłem danych.
GamesLocalDataSource - dane są zapisane na sztywno w kodzie.

15. Wskaż modele danych używane przez naszą aplikację.

Game, Platform.

Uwaga: Domena nie powinna wiedzieć o:
Compose
Android
resource system
...

Dlatego docelowo nasz model Game nie powinien zawierać pola typu DrawableResource.
Obrazek powinien być określany dopiero w warstwie UI. Jednak na tym etapie (dane tylko lokalnie)
może tak zostać.

16. Dlaczego Platform jest enumem, a nie klasą?
- Skończona liczba wartości
- Brak dodatkowych pól
- Prostota
- Bezpieczeństwo typów

## CZĘŚĆ 2 
- Proszę 2 lub 3 osoby (po kolei) o wykonanie projektu zgodnie z instrukcją 
  (ale temat biznesowy inny!).
- Każdy określa temaat swojego projektu.

## CZĘŚĆ 3 - Testy + Git + Rozpoczynamy pisać backend