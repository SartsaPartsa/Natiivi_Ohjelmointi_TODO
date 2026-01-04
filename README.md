📌 README — Todo-sovellus (MVVM + Jetpack Compose)

📱 Yleiskuvaus

Tämä projekti on osa kurssia Mobiiliohjelmointi natiiviteknologioilla.
Sovellus on yksinkertainen Todo-lista, joka on toteutettu Jetpack Composella ja MVVM-arkkitehtuurilla.

Projektissa on kaksi vaihetta:

✅ Todo 1

Sovellus näyttää kovakoodatun listan merkkijonoja ViewModelista.

🌐 Todo 2

Sovellus hakee Todo-listan verkosta JSONPlaceholder-palvelusta käyttäen Retrofit + Gson -kirjastoja.

⸻

🧩 Käytetty teknologia
	•	Kotlin
	•	Android Studio
	•	Jetpack Compose
	•	MVVM-arkkitehtuuri
	•	ViewModel
	•	Coroutines
	•	Retrofit + Gson (Todo2)
	•	JSONPlaceholder API (Todo2)

⸻

📂 Projektin rakenne
com.example.todo
 ├── ui
 │    └── MainActivity.kt
 ├── viewmodel
 │    └── TodoViewModel.kt
 └── model        (vain Todo2)
      ├── Todo.kt
      └── TodosApi.kt

✅ TODO 1 — Kovakoodattu Todo-lista

🎯 Tavoite

Näyttää lista arvoja:
Test 1
Test 2
Test 3

noudattaen MVVM-arkkitehtuuria.

🧠 Toteutus

✔ ViewModel
class TodoViewModel : ViewModel() {

    val todos = mutableListOf<String>()

    init {
        todos.add("Test 1")
        todos.add("Test 2")
        todos.add("Test 3")
    }
}

✔ UI (Jetpack Compose)
Käyttöliittymä koostuu:

MainActivity → TodoScreen → TodoList
Lista näytetään LazyColumn-komponentilla.