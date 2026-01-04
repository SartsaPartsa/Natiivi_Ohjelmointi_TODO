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

Näyttää lista arvoja: 
- Test 1
- Test 2
- Test 3

noudattaen MVVM-arkkitehtuuria. 

### 🧠 Toteutus

#### ✔ ViewModel

```kotlin
class TodoViewModel : ViewModel() {

    val todos = mutableListOf<String>()

    init {
        todos.add("Test 1")
        todos.add("Test 2")
        todos.add("Test 3")
    }
}
```

#### ✔ UI (Jetpack Compose)

Käyttöliittymä koostuu: 

**MainActivity → TodoScreen → TodoList**

Lista näytetään LazyColumn-komponentilla. 

---

## 🌐 TODO 2 — JSON API + Retrofit

### 🎯 Tavoite

Korvata kovakoodattu lista verkosta haetulla datalla:  
https://jsonplaceholder.typicode.com/todos

JSON parsitaan Todo-olioiksi ja näytetään ruudulla.

### 📦 Data-malli

```kotlin
data class Todo(
    val userId: Int,
    val id:  Int,
    val title: String,
    val completed: Boolean
)
```

### 🔗 Retrofit API-rajapinta

```kotlin
interface TodosApi {

    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        fun getInstance(): TodosApi =
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TodosApi::class.java)
    }
}
```

### 🧠 ViewModel (Todo2)

```kotlin
class TodoViewModel : ViewModel() {

    var todos: List<Todo> by mutableStateOf(emptyList())
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            try {
                todos = TodosApi.getInstance().getTodos()
            } catch (e: Exception) {
                Log.e("TODOVIEWMODEL", "Error fetching todos: ${e.message}")
            }
        }
    }
}
```

### 🌍 INTERNET-lupa Manifestiin

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### 🎨 Käyttöliittymä

UI näyttää `todo.title` arvot listana:

```kotlin
items(todos) { todo ->
    Text(text = todo.title)
}
```

### 🧪 Lopputulos

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

---

## 🚀 Käynnistys

1. Avaa projekti Android Studiossa
2. Asenna riippuvuudet (Gradle Sync)
3. Aja sovellus emulaattorissa tai laitteella
