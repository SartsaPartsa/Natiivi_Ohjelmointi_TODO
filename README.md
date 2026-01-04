# 📌 README — Todo-sovellus (MVVM + Jetpack Compose)

## 📱 Yleiskuvaus

Tämä projekti on osa kurssia **Mobiiliohjelmointi natiiviteknologioilla**.    
Sovellus on yksinkertainen Todo-lista, joka on toteutettu Jetpack Composella ja MVVM-arkkitehtuurilla.  

Projektissa on kaksi vaihetta:  

### ✅ Todo 1
Sovellus näyttää kovakoodatun listan merkkijonoja ViewModelista.

### 🌐 Todo 2
Sovellus hakee Todo-listan verkosta JSONPlaceholder-palvelusta käyttäen Retrofit + Gson -kirjastoja.

---

## 🧩 Käytetty teknologia

- Kotlin
- Android Studio
- Jetpack Compose
- MVVM-arkkitehtuuri
- ViewModel
- Coroutines
- Retrofit + Gson (Todo2)
- JSONPlaceholder API (Todo2)

---

## 📂 Projektin rakenne

```
com.example.todo
 ├── ui
 │    └── MainActivity.kt
 ├── viewmodel
 │    └── TodoViewModel.kt
 └── model        (vain Todo2)
      ├── Todo.kt
      └── TodosApi.kt
```

---

## ✅ TODO 1 — Kovakoodattu Todo-lista

### 🎯 Tavoite

Näyttää lista arvoja (Test 1, Test 2, Test 3) noudattaen MVVM-arkkitehtuuria.  

### 🧠 Toteutus

- `TodoViewModel` sisältää kovakoodatun listan merkkijonoja
- UI näyttää listan `LazyColumn`-komponentilla

---

## 🌐 TODO 2 — JSON API + Retrofit

### 🎯 Tavoite

Korvata kovakoodattu lista verkosta haetulla datalla:   
https://jsonplaceholder.typicode.com/todos

JSON parsitaan `Todo`-olioiksi ja näytetään ruudulla. 

### 📦 Data-malli

```kotlin
data class Todo(
    val userId: Int,
    val id: Int,
    val title:  String,
    val completed: Boolean
)
```

### 🔗 API-rajapinta

- `TodosApi` käyttää Retrofit-kirjastoa
- `getTodos()` hakee listan Todo-olioita
- `ViewModel` kutsuu API:a coroutinen avulla

### 🌍 INTERNET-lupa

Lisää `AndroidManifest.xml`:ään: 

```xml
<uses-permission android:name="android.permission. INTERNET" />
```

---

## 🧪 Lopputulos

**✅ Todo 1**  
Sovellus näyttää kovakoodatun listan. 

**🌐 Todo 2**  
Sovellus näyttää API:sta haetut tehtävät. 

---

## 📖 MVVM lyhyesti

| Kerros          | Vastuu |
|-----------------|--------|
| **Model**       | Data-oliot + API-logiikka |
| **View**        | Compose-käyttöliittymä |
| **ViewModel**   | Datan hallinta & logiikka UI:n ja Modelin välissä |

UI ei käsittele dataa suoraan → se kuuntelee ViewModelia. 
