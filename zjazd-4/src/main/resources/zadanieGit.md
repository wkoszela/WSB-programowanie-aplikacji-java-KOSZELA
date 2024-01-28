Zadanie wykonaj w parze 

1. Klonowanie i Dodawanie Zmian:

      •	**Osoba A:** Po sklonowaniu repozytorium zdalnego o nazwie "example-repo" utwórz nową gałąź o nazwie "my-feature". W tej gałęzi stwórz plik o nazwie "new-feature.txt", dodaj kilka linii tekstu, a następnie zacommituj te zmiany.
      •	**Osoba B**: Następnie, sprawdź, czy istnieją nowe zmiany w zdalnym repozytorium. Następnie przełącz się na gałąź "my-feature" i dodaj kolejne zmiany do pliku "new-feature.txt". Zacommituj zmiany i wypchnij je na zdalne repozytorium.

2.	Rozgałęzianie i Scalanie:
      •	**Osoba A**: W gałęzi "feature-branch" dodaj nowy plik o nazwie "feature.txt", dodaj kilka linii tekstu i zacommituj zmiany. Następnie przełącz się na gałąź główną (master) i dodaj inny plik o nazwie "main.txt" z innymi zmianami. Zacommituj te zmiany.
      •	**Osoba B**: Następnie, przełącz się z powrotem na gałąź "feature-branch" i spróbuj scalić zmiany z gałęzi głównej. Rozwiąż konflikty, jeśli takie występują.

3.  Rozwiązanie Konfliktu:
      •	**Osoba A**: W pliku "new-file.txt" zmień jedną linijkę tekstu, na przykład, dodając swoje imię.
      •	**Osoba B**: W tej samej linijce pliku "new-file.txt" zmień tekst na swoim branchu, np. dodając swoje nazwisko. Następnie spróbuj scalić zmiany i rozwiąż konflikt.

4. Historia i Przeglądanie Zmian:
      •	**Osoba A**: Dodaj nowy commit, który zmienia zawartość istniejącego pliku "example.txt". Następnie sprawdź historię repozytorium i użyj polecenia git show lub git log z odpowiednimi opcjami, aby wyświetlić szczegóły tego nowego commita.
      •	**Osoba B**: Spróbuj cofnąć ostatni commit używając git reset i przywróć plik "example.txt" do poprzedniego stanu.

5. Usunięcie i Przywracanie:
      •	**Osoba A**: Usuń plik "new-file.txt" i zacommituj zmiany. Następnie utwórz nową gałąź o nazwie "restore-branch".
      •	**Osoba B**: W branchu "restore-branch" przywróć usunięty plik "new-file.txt" z poprzedniego commita. Zacommituj zmiany i następnie scal te zmiany z gałęzią główną (master).


Identyfikator: Krotki opis operacji/zmian
* Detal 1
* Detal 2

Ticket-1001231: Problem w Cache z ladowaniem modeli naprawiony
* Dodano nowa klase, celem...
* Poprawiono Testy zwiazane z obiektem X