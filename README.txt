Wymagania dotyczące uruchomienia aplikacji:

Baza Danych:
    -serwer MySQL lub MariaDB z utworzoną bazą o nazwie "list_of_books".
     Aplikacja próbuje domyślnie zalogować się na konto root bez hasła.
Logowanie:
    -aplikacja posiada jednego użytkownika w swojej bazie. Aby móc się zalogować należy skożystać z:
        login: "patryk"
        haslo: "admin1234"

Aplikacja przedstawia spis książek które możemy mieć w swojej domowej bibliotece.
Posiada 3 tabele:
    -book - dane o książce
    -publisher - dane o wydawcy
    -user - znajdują się tu dane dotyczące logowania do aplikacji


W aplikacji mozemy dodawać, usuwać oraz edytować zarówno książki jak i wydawców.
Można również wybrać opcję sortowania wyświetlanych danych przez kolumny "Name" dla wydawcy oraz "Title" dla ksiązki.